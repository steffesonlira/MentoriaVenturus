package com.example.mentoriaventurus.mvp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentoriaventurus.R

class MVPMainActivity : AppCompatActivity(), MVPContract.View {

    private lateinit var textResult: TextView
    private lateinit var mpvPresenter: MVPPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp)

        textResult = findViewById(R.id.tv_result)

        mpvPresenter = MVPPresenter(this)

        mpvPresenter.calculate("SUM", 10, 100)
    }

    override fun showResult(result: Int) {
        textResult.text = result.toString()
    }

    override fun showToastLimit() {
        Toast.makeText(this, "Error result limit 100", Toast.LENGTH_SHORT).show()
    }
}