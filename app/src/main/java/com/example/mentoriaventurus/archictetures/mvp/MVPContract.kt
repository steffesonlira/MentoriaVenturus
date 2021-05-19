package com.example.mentoriaventurus.archictetures.mvp

import com.example.mentoriaventurus.data.rest.responses.ResultResponse

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
        fun cleanup()
        fun calculate(operation: String, firstValue: Int, secondValue: Int)
        fun fetchPokemons()
        fun fetchAbilities()
    }
}