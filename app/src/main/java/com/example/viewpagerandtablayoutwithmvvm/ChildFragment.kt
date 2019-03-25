package com.example.viewpagerandtablayoutwithmvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.viewpagerandtablayoutwithmvvm.databinding.FragmentChildBinding
import com.example.viewpagerandtablayoutwithmvvm.model.ModelItem

class ChildFragment : Fragment() {
    private val viewModel = createVm()
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_TEXT) ?: ""
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding =
            DataBindingUtil.inflate<FragmentChildBinding>(inflater, R.layout.fragment_child, container, false)
        binding.setVariable(BR.viewModel, viewModel)

        viewModel.adapter.replaceAll(listOf(ModelItem("$text Fragment", "$text Fragment\nBtnClick")))

        return binding.root
    }


    private fun createVm() = ChildFragmentViewModel(object : ChildFragmentViewModel.ChildFragmentContract {
        override fun showToast(message: String) {
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }
    })

    companion object {
        private const val ARG_TEXT = "fragmentTAG"

        fun newInstance(text: String) =
            ChildFragment().apply {
                arguments =
                    Bundle().apply {
                        putString(ARG_TEXT, text)
                    }
            }
    }
}

