package com.example.mentoriaventurus.mvp

interface MVPContract {

    /** O que será mostrado ao usuário final, transferido para a activity */
    interface View {
        fun showResult(result: Int)
        fun showToastLimit()
    }

    /** Onde ficam as regras de negócio */
    interface Presenter {
        fun calculate(operation: String, firstValue: Int, secondValue: Int)
    }
}