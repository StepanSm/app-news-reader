package com.smerkis.news.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentMainBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.ui.adapter.VpAdapter
import com.smerkis.news.utils.Constants
import com.smerkis.news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.NullPointerException

class MainFragment : Fragment(R.layout.fragment_main) {

    private val vModel: NewsViewModel by viewModel()
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val viewPager: ViewPager2 by lazy { setupPager() }

    private val pageAdapter = VpAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TabLayoutMediator(binding.tabLayout, viewPager) { tab: TabLayout.Tab, i: Int ->
            tab.text = Constants.CATEGORIES[i]
        }.attach()

        vModel.newsListLiveData.observe(viewLifecycleOwner) {
            pageAdapter.news = it as ArrayList<ArticleStructure>
        }

        vModel.isDataLoaded.observe(viewLifecycleOwner) {
            binding.pb.visibility = if (it) View.GONE else View.VISIBLE
        }
    }

    fun nextCategory(category: String) {
        vModel.getNewsForCategory(category)
    }

    private fun setupPager(): ViewPager2 {

        val viewPager = context?.let {
            ViewPager2(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
                orientation = ViewPager2.ORIENTATION_HORIZONTAL
                adapter = pageAdapter
            }
        }


        val set = ConstraintSet()
        set.clone(binding.container)
        viewPager?.id = View.generateViewId()
        binding.container.addView(viewPager)

        if(viewPager !=null){
        set.connect(viewPager.id, ConstraintSet.TOP, binding.tabLayout.id, ConstraintSet.BOTTOM)
        set.connect(viewPager.id, ConstraintSet.BOTTOM, binding.container.id, ConstraintSet.BOTTOM)
        set.connect(viewPager.id, ConstraintSet.START, binding.container.id, ConstraintSet.START)
        set.connect(viewPager.id, ConstraintSet.END, binding.container.id, ConstraintSet.END)
        set.applyTo(binding.container)
        }
        return viewPager ?: throw NullPointerException()
    }

}