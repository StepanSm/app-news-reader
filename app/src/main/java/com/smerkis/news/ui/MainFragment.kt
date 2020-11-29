package com.smerkis.news.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentMainBinding
import com.smerkis.news.ui.adapter.VpAdapter
import com.smerkis.news.utils.Constants
import com.smerkis.news.utils.isNetworkAvailable

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isNetworkAvailable()) {
            showShortToast(getString(R.string.network_connect))
        }

        createToolbar(binding.tb, false, "NEWS")
        binding.vp.adapter = setAdapter()
        binding.vp.offscreenPageLimit = 2

        TabLayoutMediator(binding.tabs, binding.vp) { tab: TabLayout.Tab, i: Int ->
            tab.text = Constants.CATEGORIES[i]
        }.attach()
    }

    private fun setAdapter() = VpAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity().menuInflater.inflate(R.menu.main_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_app -> navigate(MainFragmentDirections.actionMainFragmentToAboutAppFragment())
            R.id.action_search -> navigate(MainFragmentDirections.actionMainFragmentToSearchFragment())
            R.id.app_source -> openBrowser("https://github.com/StepanSm")
        }
        return super.onOptionsItemSelected(item)
    }

}
