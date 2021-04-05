package com.example.mentoriaventurus.mvvm

import androidx.lifecycle.MutableLiveData
import com.example.mentoriaventurus.mvvm.state.StateLiveData


class MVVMViewModel {


    var calculateListLiveData: StateLiveData<List<MVVMViewModel>>? = null

    val result = MutableLiveData<Int>()
    val error = MutableLiveData<Throwable>()

    fun calculate(operation: String, firstValue: Int, secondValue: Int) {
        calculateListLiveData?.postLoading()
        val calculate = when (operation) {
            "SUM" -> firstValue + secondValue
            "MULTIPLICATION" -> firstValue * secondValue
            "DIVISION" -> firstValue / secondValue
            else -> firstValue - secondValue
        }

        if (calculate > 100) {
            calculateListLiveData?.postError(Throwable("Resultado maior que 100"))
            //error.value = Throwable("Resultado maior que 100")
        } else {
            calculateListLiveData?.postSuccess(calculate)
            result.value = calculate
        }


    }

    fun getCalculate(){



    }
}