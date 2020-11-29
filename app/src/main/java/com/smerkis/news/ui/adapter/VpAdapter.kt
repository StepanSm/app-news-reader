package com.smerkis.news.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.smerkis.news.ui.NewsListFragment
import com.smerkis.news.utils.Constants.Companion.CATEGORIES

class VpAdapter(
    private val fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val currentPageIds = ArrayList<Int>()

    override fun getItemCount() = 7


    override fun createFragment(position: Int): Fragment {
        val pageFragment = NewsListFragment.newInstance(CATEGORIES[position])
        currentPageIds.add(position)
        return pageFragment
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun containsItem(itemId: Long): Boolean {
        for (id in currentPageIds) {
            if (id.toLong() == itemId) {
                currentPageIds.remove(itemId.toInt())
                clearFragment(id)
                break
            }
        }
        return super.containsItem(itemId)
    }

    private fun clearFragment(fragmentId: Int) {
        val transaction = fragmentManager.beginTransaction()
        val fragment = fragmentManager.findFragmentByTag("f$fragmentId")
        fragment?.let { transaction.remove(it) }
        transaction.commitNowAllowingStateLoss()
    }
}

