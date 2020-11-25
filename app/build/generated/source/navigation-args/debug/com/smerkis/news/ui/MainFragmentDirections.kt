package com.smerkis.news.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.smerkis.news.R
import com.smerkis.news.model.ArticleStructure
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class MainFragmentDirections private constructor() {
  private data class ActionMainFragmentToArticleFragment(
    val article: ArticleStructure
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_mainFragment_to_articleFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(ArticleStructure::class.java)) {
        result.putParcelable("article", this.article as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(ArticleStructure::class.java)) {
        result.putSerializable("article", this.article as Serializable)
      } else {
        throw UnsupportedOperationException(ArticleStructure::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionMainFragmentToArticleFragment(article: ArticleStructure): NavDirections =
        ActionMainFragmentToArticleFragment(article)

    fun actionMainFragmentToAboutAppFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_aboutAppFragment)

    fun actionMainFragmentToSearchFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_searchFragment)
  }
}
