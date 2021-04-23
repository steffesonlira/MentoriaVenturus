package com.example.mentoriaventurus.mvp

import com.example.mentoriaventurus.rest.BuildRetrofit
import com.example.mentoriaventurus.rest.responses.AbilityResponse
import com.example.mentoriaventurus.rest.responses.PokemonResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MVPPresenter(private var view: MVPContract.View) : MVPContract.Presenter {

    val disposable = CompositeDisposable()

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
    override fun fetchPokemons() {
        val call: Call<PokemonResponse> = BuildRetrofit.apiCallPokemon().fetchPokemons()
        call.enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body == null) {
                        view.showEmptyResultMessage()
                    } else {
                        val results = body.results
                        if (results.isEmpty()) {
                            view.showEmptyResultMessage()
                        } else {
                            view.showResultPokemons(results)
                        }
                    }
                } else {
                    view.showToastLimit()
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                view.showApiErrorMessage(t)
            }
        })
    }

    //    RxJava
//    override fun fetchPokemons() {
//        val toDispose = BuildRetrofit.apiCallPokemon()
//            .fetchPokemons()
//            .observeOn(mainThread())
//            .subscribeBy(
//                onNext = {
//                    if (it.results.isEmpty()) {
//                        view.showEmptyResultMessage()
//                    } else {
//                        view.showResultPokemons(it.results)
//                    }
//                },
//                onError = { view.showApiErrorMessage(it) }
//            )
//
//        disposable.add(toDispose)
//
//    }
}