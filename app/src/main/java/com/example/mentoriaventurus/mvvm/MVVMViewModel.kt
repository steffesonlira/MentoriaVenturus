package com.example.mentoriaventurus.mvvm

import androidx.lifecycle.MutableLiveData

class MVVMViewModel {

    val result = MutableLiveData<Int>()
    val error = MutableLiveData<Throwable>()

    fun calculate(operation: String, firstValue: Int, secondValue: Int) {
        val calculate = when (operation) {
            "SUM" -> firstValue + secondValue
            "MULTIPLICATION" -> firstValue * secondValue
            "DIVISION" -> firstValue / secondValue
            else -> firstValue - secondValue
        }

        if (calculate > 100) {
            error.value = Throwable("Resultado maior que 100")
        } else {
            result.value = calculate
        }
    }
}