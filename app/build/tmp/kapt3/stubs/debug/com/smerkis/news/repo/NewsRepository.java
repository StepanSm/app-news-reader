package com.smerkis.news.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000f\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/smerkis/news/repo/NewsRepository;", "Lcom/smerkis/news/repo/NewsRepo;", "newsApi", "Lcom/smerkis/news/api/NewsApi;", "newsArticleDao", "Lcom/smerkis/news/data/storage/NewsArticleDao;", "(Lcom/smerkis/news/api/NewsApi;Lcom/smerkis/news/data/storage/NewsArticleDao;)V", "getNewsArticlesByCategory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/smerkis/news/model/ArticleStructure;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchResult", "searchRequest", "getTopHeadLinesForCategory", "Lcom/smerkis/news/model/NewsResponse;", "app_debug"})
public final class NewsRepository implements com.smerkis.news.repo.NewsRepo {
    private final com.smerkis.news.api.NewsApi newsApi = null;
    private final com.smerkis.news.data.storage.NewsArticleDao newsArticleDao = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNewsArticlesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.smerkis.news.model.ArticleStructure>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getTopHeadLinesForCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smerkis.news.model.NewsResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getSearchResult(@org.jetbrains.annotations.NotNull()
    java.lang.String searchRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.smerkis.news.model.ArticleStructure>>> p1) {
        return null;
    }
    
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.api.NewsApi newsApi, @org.jetbrains.annotations.NotNull()
    com.smerkis.news.data.storage.NewsArticleDao newsArticleDao) {
        super();
    }
}