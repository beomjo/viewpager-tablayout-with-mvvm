package com.example.viewpagerandtablayoutwithmvvm

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(fragmentManager: FragmentManager, private val titles: List<CharSequence>, private val conetent: List<Fragment>)
    : FragmentStatePagerAdapter(fragmentManager) {

    private val numOfTabs: Int = titles.size

    private val PAGE1 = 0
    private val PAGE2 = 1
    private val PAGE3 = 2

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null

        when (position) {
            PAGE1 -> fragment = conetent[0]
            PAGE2 -> fragment = conetent[1]
            PAGE3 -> fragment = conetent[2]
            else -> fragment = conetent[3]
        }
        return fragment
    }

    override fun getCount(): Int {
        return numOfTabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}