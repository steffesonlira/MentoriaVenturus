package com.example.mentoriaventurus.mvvm

import com.example.mentoriaventurus.mvvm.state.StateLiveData
import com.example.mentoriaventurus.rest.BuildRetrofit
import com.example.mentoriaventurus.rest.responses.PokeAPIResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MVVMViewModel {

    private var calculateLiveData: StateLiveData<Int> = StateLiveData()
    private var fetchAbilities: StateLiveData<Int> = StateLiveData()


//    val result = MutableLiveData<Int>()
//    val error = MutableLiveData<Throwable>()

    fun calculate(operation: String, firstValue: Int, secondValue: Int): StateLiveData<Int> {
        calculateLiveData.postLoading()

        val calculate = when (operation) {
            "SUM" -> firstValue + secondValue
            "MULTIPLICATION" -> firstValue * secondValue
            "DIVISION" -> firstValue / secondValue
            else -> firstValue - secondValue
        }

        if (calculate > 100) {
            calculateLiveData.postError(Throwable("Resultado maior que 100"))
            //error.value = Throwable("Resultado maior que 100")
        } else {
            calculateLiveData.postSuccess(calculate)
//            result.value = calculate
        }

        return calculateLiveData
    }

    fun fetchAbilities(): StateLiveData<Int>{
        val call: Call<PokeAPIResponse> = BuildRetrofit.apiCallPokemon().fetchAbities()
        call.enqueue(object : Callback<PokeAPIResponse> {
            override fun onResponse(
                call: Call<PokeAPIResponse>,
                response: Response<PokeAPIResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body == null) {
                        fetchAbilities.postError(Throwable("O resultado não contém valores."))

                    } else {
                        val results = body.results
                        if (results.isEmpty()) {
                            fetchAbilities.postError(Throwable("O resultado não contém valores."))
                        } else {

                            fetchAbilities.resultSuccess(results)
                        }
                    }
                } else {
                    fetchAbilities.postError(
                        Throwable("Houve um erro ao tentar obter as " +
                            "informações do servidor")
                    )
                }
            }

            override fun onFailure(call: Call<PokeAPIResponse>, t: Throwable) {
                fetchAbilities.postError(Throwable(t.message))
            }
        })

        return fetchAbilities
    }
}