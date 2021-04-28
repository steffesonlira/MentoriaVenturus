package com.example.mentoriaventurus.mvp

import com.example.mentoriaventurus.rest.BuildRetrofit
import com.example.mentoriaventurus.rest.responses.AbilityResponse
import com.example.mentoriaventurus.rest.responses.PokemonResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class MVPPresenter(private var view: MVPContract.View) : MVPContract.Presenter, CoroutineScope {

    val disposable = CompositeDisposable()

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun cleanup() {
        job.cancel()
    }

    override fun calculate(operation: String, firstValue: Int, secondValue: Int) {
        val result = when (operation) {
            "SUM" -> firstValue + secondValue
            "MULTIPLICATION" -> firstValue * secondValue
            "DIVISION" -> firstValue / secondValue
            else -> firstValue - secondValue
        }

        view.showResult(result)

        if (result > 100) view.showToastLimit()
    }

//    Retrofit
//    override fun fetchPokemons() {
//        val call: Call<PokemonResponse> = BuildRetrofit.apiCallPokemon().fetchPokemons()
//        call.enqueue(object : Callback<PokemonResponse> {
//            override fun onResponse(
//                call: Call<PokemonResponse>,
//                response: Response<PokemonResponse>
//            ) {
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    if (body == null) {
//                        view.showEmptyResultMessage()
//                    } else {
//                        val results = body.results
//                        if (results.isEmpty()) {
//                            view.showEmptyResultMessage()
//                        } else {
//                            view.showResultPokemons(results)
//                        }
//                    }
//                } else {
//                    view.showToastLimit()
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
//                view.showApiErrorMessage(t)
//            }
//        })
//    }

    //    RxJava
    override fun fetchPokemons() {
        val toDispose = BuildRetrofit.apiCallPokemon()
            .fetchPokemons()
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread())
            .subscribeBy(
                onNext = {
                    if (it.results.isEmpty()) {
                        view.showEmptyResultMessage()
                    } else {
                        view.showResultPokemons(it.results)
                    }
                },
                onError = { view.showApiErrorMessage(it) }
            )

        disposable.add(toDispose)
    }

    // Coroutines (
    // https://medium.com/android-dev-br/utilizando-kotlin-coroutines-no-android-c73fcda71e27
    // https://mikecaulley.com/blog/retrofit-with-kotlin-coroutines/
    // https://faithlife.codes/blog/2018/11/android-mvp-with-coroutines/
    // )
    override fun fetchAbilities() {
        // Se estender a classe CoroutineScope
//        CoroutineScope(Dispatchers.IO).launch {
        launch {
            val response = BuildRetrofit.apiCallPokemon().fetchAbilities()
            withContext(Dispatchers.Main) {
                view.showResultPokemons(response.results)
            }
        }
    }
}