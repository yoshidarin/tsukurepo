package com.example.tsukurepo.data.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ui.calender.CalenderFragment
import com.example.tsukurepo.data.ui.currentWeek.CurrentWeekFragment
import com.example.tsukurepo.data.util.MainMenuTab
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment(private val viewModel: MainViewModel) : Fragment() {

    companion object {
        fun newInstance(viewModel: MainViewModel) = MainFragment(viewModel)
    }

    private lateinit var reportPagerAdapter: ReportPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager = view.findViewById(R.id.pager)
        reportPagerAdapter = ReportPagerAdapter(this)
        viewPager.adapter = reportPagerAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                MainMenuTab.CURRENT_WEEK.index ->
                    requireContext().getString(MainMenuTab.CURRENT_WEEK.tabTitleId)
                MainMenuTab.CALENDER.index ->
                    requireContext().getString(MainMenuTab.CALENDER.tabTitleId)
                else -> ""
            }
        }.attach()
    }
}

private class ReportPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int) =
        if (position == 0) CurrentWeekFragment.newInstance()
        else CalenderFragment.newInstance()
}
