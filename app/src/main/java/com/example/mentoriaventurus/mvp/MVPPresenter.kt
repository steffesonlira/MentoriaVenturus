package com.example.mentoriaventurus.mvp

import com.example.mentoriaventurus.rest.BuildRetrofit
import com.example.mentoriaventurus.rest.responses.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MVPPresenter(private var view: MVPContract.View) : MVPContract.Presenter {

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
                view.showToastLimit()
            }
        })
    }
}