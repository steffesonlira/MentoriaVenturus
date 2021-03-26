package com.example.mentoriaventurus.mvp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mentoriaventurus.R

class MVPMainActivity : AppCompatActivity(), MVPContract.View {

    lateinit var textResult: TextView
    lateinit var mpvPresenter: MVPPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp)

        textResult = findViewById(R.id.tv_result)

        mpvPresenter = MVPPresenter(this)

        mpvPresenter.calculate("SUM", 10, 10)
    }

    override fun showResult(result: Int) {
        textResult.text = result.toString()
    }
}