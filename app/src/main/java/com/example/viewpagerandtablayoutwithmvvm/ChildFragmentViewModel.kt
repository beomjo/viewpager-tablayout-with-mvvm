package com.example.viewpagerandtablayoutwithmvvm

import com.example.viewpagerandtablayoutwithmvvm.model.ModelItem


class ChildFragmentViewModel(private val contract: ChildFragmentContract) {
    interface ChildFragmentContract {
        fun showToast(message: String)
    }

    val adapter = BindAdapter(
        id = R.layout.list_item,
        items = listOf<ModelItem>(),
        listener = this
    )

    fun btnClkEvent(model: ModelItem) {
        contract.showToast(model.btnText)
    }

}