package com.smerkis.news.ui

import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smerkis.news.MainActivity
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentMainBinding
import com.smerkis.news.databinding.ItemArticleBinding
import com.smerkis.news.databinding.RvNewsFeedBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.ui.adapter.RvAdapter
import com.smerkis.news.ui.adapter.VpAdapter
import com.smerkis.news.utils.Constants
import com.smerkis.news.viewmodel.NewsViewModel
import com.utsman.recycling.extentions.Recycling
import com.utsman.recycling.setupAdapter
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.rv_news_feed.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main), RvAdapter.ClickListener,
    VpAdapter.LoaderNews {

    private val vModel: NewsViewModel by viewModel()
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewPager: ViewPager2 by lazy { setupPager() }
    private val pageAdapter = VpAdapter(this as VpAdapter.LoaderNews)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)

        vModel.newsListLiveData.observe(viewLifecycleOwner) {
            //recycling?.submitList(it)
            rv.adapter = RvAdapter(it, this as RvAdapter.ClickListener)
        }

        vModel.isDataLoaded.observe(viewLifecycleOwner) {
            binding.pb.visibility = if (it) View.GONE else View.VISIBLE
        }

        TabLayoutMediator(binding.tabs, viewPager) { tab: TabLayout.Tab, i: Int ->
            tab.text = Constants.CATEGORIES[i]
        }.attach()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.main_main, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_menu -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToAboutAppFragment())
            R.id.action_search -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToSearchFragment())
        }


        return super.onOptionsItemSelected(item)
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

        if (viewPager != null) {
            set.connect(viewPager.id, ConstraintSet.TOP, binding.tabs.id, ConstraintSet.BOTTOM)
            set.connect(
                viewPager.id,
                ConstraintSet.BOTTOM,
                binding.container.id,
                ConstraintSet.BOTTOM
            )
            set.connect(
                viewPager.id,
                ConstraintSet.START,
                binding.container.id,
                ConstraintSet.START
            )
            set.connect(viewPager.id, ConstraintSet.END, binding.container.id, ConstraintSet.END)
            set.applyTo(binding.container)
        }
        return viewPager ?: throw NullPointerException()
    }

    override fun onClick(article: ArticleStructure) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToArticleFragment(
                article
            )
        )
    }

    override fun nextCategory(category: String) {
        vModel.getNewsForCategory(category)
    }
}


//    inner class VpAdapter :
//        RecyclerView.Adapter<VpAdapter.Holder>() {
//
//        override fun getItemCount() = Constants.CATEGORIES.size
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//            return Holder(
//                RvNewsFeedBinding.inflate(
//                    LayoutInflater.from(parent.context),
//                    parent,
//                    false
//                )
//            )
//        }
//
//        override fun onBindViewHolder(holder: Holder, position: Int) {
//            this@MainFragment.nextCategory(Constants.CATEGORIES[position])
//
//            recycling = null
//
//            holder.binding.rv.setupAdapter<ArticleStructure>(R.layout.item_article) { _, context, _ ->
//
//                bind { itemView, positionq, item ->
//                    ItemArticleBinding.bind(itemView).apply {
//                        tvCardMainTitle.text = item?.title
//                        imgCardMain.load(item?.urlToImage)
//
//                        if (positionq > lastPosition) {
//                            val animation = AnimationUtils.loadAnimation(
//                                context,
//                                R.anim.item_animation_fall_down
//                            )
//                            cardRow.startAnimation(animation)
//                            lastPosition = position
//                        }
//
//                    }
//                }
//                recycling = this
//                // setupData(this)
//            }
//        }
//
//        inner class Holder(val binding: RvNewsFeedBinding) :
//            RecyclerView.ViewHolder(binding.root) {
//        }
//    }

//private fun setupData(recycling: Recycling<ArticleStructure>) {
//        vModel.newsListLiveData.observe(viewLifecycleOwner) {
//            recycling.submitList(it)
//        }
//
//        vModel.isDataLoaded.observe(viewLifecycleOwner) {
//            binding.pb.visibility = if (it) View.GONE else View.VISIBLE
//        }
//    }