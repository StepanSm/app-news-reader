package com.smerkis.news.data.storage;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/smerkis/news/data/storage/NewsArticleDao;", "", "clearAllArticles", "", "getAllArticlesForCategory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/smerkis/news/model/ArticleStructure;", "category", "", "insert", "articles", "updateArticle", "articleModel", "app_debug"})
public abstract interface NewsArticleDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from news_article where category = :category order by publishedAt desc")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.smerkis.news.model.ArticleStructure>> getAllArticlesForCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smerkis.news.model.ArticleStructure> articles);
    
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void updateArticle(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.model.ArticleStructure articleModel);
    
    @androidx.room.Query(value = "DELETE FROM news_article")
    public abstract void clearAllArticles();
}