package com.example.mentoriaventurus.mvvm

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mentoriaventurus.R
import com.example.mentoriaventurus.mvvm.state.StateData
import com.example.mentoriaventurus.mvvm.state.StateData.DataStatus.*


class MVVMMainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView
    private lateinit var viewModel: MVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvvm)

        textResult = findViewById(R.id.tv_result)

        viewModel = MVVMViewModel()

        //createObservables()

        createObservablesAlternative()

        viewModel.calculate("SUM", 10, 2)
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

    private fun createObservablesAlternative() {
        viewModel.calculateListLiveData?.observe(
            this, this::handleResult
        )

    }

    private fun handleResult(result: StateData<List<MVVMViewModel>>) {
        val calculateList: Int
        val e: Throwable?
        when (result.getStatus()) {

            SUCCESS ->   calculateList = result.getData()

            ERROR ->   e = result.getError()

            LOADING -> {}

            COMPLETE -> {}

            else -> {}
        }
    }

}