package com.example.viewpagerandtablayoutwithmvvm

import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager

class MainViewModel(val contract: MainActivityContract) {
    interface MainActivityContract {
        fun getFragmentManger(): FragmentManager
    }

    var adapter = PagerAdapter(
        contract.getFragmentManger(),
        listOf("Tab1", "Tab2", "Tab3", "Tab4"),
        listOf(
            ChildFragment.newInstance("1"),
            ChildFragment.newInstance("2"),
            ChildFragment.newInstance("3"),
            ChildFragment.newInstance("4")
        )
    )

    var currentPosition = 0

    var pageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(p0: Int) {
        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            currentPosition = p0
        }
    }

}