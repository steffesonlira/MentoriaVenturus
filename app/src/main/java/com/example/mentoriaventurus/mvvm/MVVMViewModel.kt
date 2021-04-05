package com.example.mentoriaventurus.mvvm

import com.example.mentoriaventurus.mvvm.state.StateLiveData

class MVVMViewModel {

    private var calculateLiveData: StateLiveData<Int> = StateLiveData()

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
}