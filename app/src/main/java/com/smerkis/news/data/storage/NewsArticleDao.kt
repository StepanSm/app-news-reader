package com.smerkis.news.data.storage

import androidx.room.*
import com.smerkis.news.model.ArticleStructure
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsArticleDao {

    @Query("select * from news_article where category = :category order by publishedAt desc")
    fun getAllArticlesForCategory(category: String): Flow<List<ArticleStructure>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(articles: List<ArticleStructure>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateArticle(articleModel: ArticleStructure)

    @Query("DELETE FROM news_article")
    fun clearAllArticles()

}