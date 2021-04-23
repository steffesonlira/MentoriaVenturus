package com.example.mentoriaventurus.mvp

import com.example.mentoriaventurus.rest.responses.ResultResponse

interface MVPContract {

    /** O que será mostrado ao usuário final, transferido para a activity */
    interface View {
        fun showResult(result: Int)
        fun showResultPokemons(results: List<ResultResponse>)
        fun showEmptyResultMessage()
        fun showToastLimit()
        fun showApiErrorMessage(throwable: Throwable)
    }

    /** Onde ficam as regras de negócio */
    interface Presenter {
        fun calculate(operation: String, firstValue: Int, secondValue: Int)
        fun fetchPokemons()
    }
}