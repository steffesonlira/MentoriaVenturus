package com.example.mentoriaventurus.mvp

interface MVPContract {

    interface View {
        fun showResult(result: Int)
        fun showToastLimit()
    }

    interface Presenter {
        fun calculate(operation: String, firstValue: Int, secondValue: Int)
    }
}