package com.example.mentoriaventurus.archictetures.mvvm

import com.example.mentoriaventurus.archictetures.mvvm.state.StateLiveData
import com.example.mentoriaventurus.data.rest.responses.AbilityResponse

class MVVMViewModel {

    private var calculateLiveData: StateLiveData<Int> = StateLiveData()
    private var abilities: StateLiveData<AbilityResponse> = StateLiveData()


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

//    fun fetchAbilities(): StateLiveData<AbilityResponse> {
//        val call: Call<AbilityResponse> = BuildRetrofit.apiCallPokemon().fetchAbilities()
//        call.enqueue(object : Callback<AbilityResponse> {
//            override fun onResponse(
//                call: Call<AbilityResponse>,
//                response: Response<AbilityResponse>
//            ) {
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    if (body == null) {
//                        abilities.postError(Throwable("O resultado não contém valores."))
//
//                    } else {
//                        abilities.postSuccess(body)
//                    }
//                } else {
//                    abilities.postError(
//                        Throwable(
//                            "Houve um erro ao tentar obter as " +
//                                    "informações do servidor"
//                        )
//                    )
//                }
//            }
//
//            override fun onFailure(call: Call<AbilityResponse>, t: Throwable) {
//                abilities.postError(Throwable(t.message))
//            }
//        })
//
//        return abilities
//    }
}