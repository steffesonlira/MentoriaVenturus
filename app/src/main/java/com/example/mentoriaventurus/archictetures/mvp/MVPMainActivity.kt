package com.example.mentoriaventurus.archictetures.mvp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentoriaventurus.R
import com.example.mentoriaventurus.data.rest.responses.ResultResponse

class MVPMainActivity : AppCompatActivity(), MVPContract.View {

    private lateinit var textResult: TextView
    private lateinit var mvpPresenter: MVPPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp)

        textResult = findViewById(R.id.tv_result)

        mvpPresenter = MVPPresenter(this)

//        mpvPresenter.calculate("SUM", 10, 100)
//        mpvPresenter.fetchPokemons()
        mvpPresenter.fetchAbilities()

    }

    override fun onDestroy() {
        super.onDestroy()
        mvpPresenter.disposable.clear()
        mvpPresenter.cleanup()
    }

    override fun showResult(result: Int) {
        textResult.text = result.toString()
    }

    override fun showResultPokemons(results: List<ResultResponse>) {
        textResult.text = results.toString()
    }

    override fun showEmptyResultMessage() {
        Toast.makeText(this, "No result", Toast.LENGTH_SHORT).show()
    }

    override fun showToastLimit() {
        Toast.makeText(this, "Error result limit 100", Toast.LENGTH_SHORT).show()
    }

    override fun showApiErrorMessage(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}