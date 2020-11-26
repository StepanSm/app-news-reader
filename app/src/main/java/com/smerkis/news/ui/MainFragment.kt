package com.smerkis.news.ui

import android.os.Bundle
import android.view.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentMainBinding
import com.smerkis.news.model.Article
import com.smerkis.news.ui.adapter.VpAdapter
import com.smerkis.news.utils.Constants
import com.smerkis.news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.fragment_main),
    VpAdapter.LoaderNews {

    private val vModel: NewsViewModel by viewModel()
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private var category = Constants.CATEGORIES[0]
    private val pageAdapter = VpAdapter(
        onClick = { article -> onClick(article) },
        loader = { category -> nextCategory(category) })


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)
        binding.vp.adapter = pageAdapter

        vModel.newsListLiveData.observe(viewLifecycleOwner) {
            pageAdapter.newsByCategory[category] = it
            pageAdapter.notifyItemChanged(Constants.CATEGORIES.indexOf(category))
        }

        vModel.isDataLoaded.observe(viewLifecycleOwner) {
            binding.pb.visibility = if (it) View.GONE else View.VISIBLE
        }

        vModel.errorData.observe(viewLifecycleOwner){
            showLongToast("Something went wrong ¯\\_(ツ)_/¯ => ${it.message}")
        }

        TabLayoutMediator(binding.tabs, binding.vp) { tab: TabLayout.Tab, i: Int ->
            tab.text = Constants.CATEGORIES[i]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity.menuInflater.inflate(R.menu.main_main, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_menu -> navigate(MainFragmentDirections.actionMainFragmentToAboutAppFragment())
            R.id.action_search -> navigate(MainFragmentDirections.actionMainFragmentToSearchFragment())
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onClick(article: Article) {
        navigate(
            MainFragmentDirections.actionMainFragmentToArticleFragment(article)
        )
    }

    override fun nextCategory(category: String) {
        this.category = category
        vModel.getNewsForCategory(category)
    }

}
