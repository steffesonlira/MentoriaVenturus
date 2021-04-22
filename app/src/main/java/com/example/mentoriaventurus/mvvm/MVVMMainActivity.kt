package com.example.mentoriaventurus.mvvm

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentoriaventurus.R
import com.example.mentoriaventurus.mvvm.state.DataStatus
import com.example.mentoriaventurus.mvvm.state.StateData


class MVVMMainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView
    private lateinit var viewModel: MVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvvm)

        textResult = findViewById(R.id.tv_result)

        viewModel = MVVMViewModel()

        viewModel.fetchAbilities().observe(
            this, this::handleResult
        )

//        createObservables()
//        viewModel.calculate("SUM", 10, 2)

//        viewModel.calculate("SUM", 10, 2).observe(
//            this, this::handleResult
//        )

    }

//    private fun createObservables() {
//        viewModel.result.observe(this, {
//            textResult.text = it.toString()
//        })
//
//        viewModel.error.observe(this, {
//            Toast.makeText(this, "Error result limit 100", Toast.LENGTH_SHORT).show()
//        })
//    }

    private fun handleResult(resultResponse: StateData<Int>) {
        when (resultResponse.status) {
            DataStatus.LOADING -> {
                Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
            }
            DataStatus.SUCCESS -> textResult.text = resultResponse.result?.toString()
            DataStatus.ERROR -> {
                Toast.makeText(this, resultResponse.error?.message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit //COMPLETE
        }
    }
}