package com.example.viewpagerandtablayoutwithmvvm

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.example.viewpagerandtablayoutwithmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel = createVm()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).setVariable(BR.viewModel,viewModel)
    }

    private fun createVm() = MainViewModel(object : MainViewModel.MainActivityContract {
        override fun getFragmentManger(): FragmentManager = supportFragmentManager
    })
}
