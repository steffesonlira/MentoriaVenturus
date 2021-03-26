package com.example.mentoriaventurus.mvp

class MVPPresenter(private var view: MVPContract.View) : MVPContract.Presenter {

    override fun calculate(operation: String, firstValue: Int, secondValue: Int) {
        val result = when (operation) {
            "SUM" -> firstValue + secondValue
            "MULTIPLICATION" -> firstValue * secondValue
            "DIVISION" -> firstValue / secondValue
            else -> firstValue - secondValue
        }

        view.showResult(result)
    }
}