package com.smerkis.news.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\n\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/smerkis/news/repo/NewsRepo;", "", "getNewsArticlesByCategory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/smerkis/news/model/ArticleStructure;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchResult", "searchRequest", "getTopHeadLinesForCategory", "Lcom/smerkis/news/model/NewsResponse;", "app_debug"})
public abstract interface NewsRepo {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewsArticlesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.smerkis.news.model.ArticleStructure>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopHeadLinesForCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smerkis.news.model.NewsResponse> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSearchResult(@org.jetbrains.annotations.NotNull()
    java.lang.String searchRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.smerkis.news.model.ArticleStructure>>> p1);
}