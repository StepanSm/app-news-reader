package com.smerkis.news.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005H\'J/\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/smerkis/news/api/NewsApi;", "", "getSearchResults", "Lcom/smerkis/news/model/NewsResponse;", "query", "", "sortBy", "language", "apiKey", "getTopHeadLinesForCategory", "category", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface NewsApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "top-headlines")
    public abstract java.lang.Object getTopHeadLinesForCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "category")
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "country")
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smerkis.news.model.NewsResponse> p3);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "everything")
    public abstract com.smerkis.news.model.NewsResponse getSearchResults(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "q")
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "sortBy")
    java.lang.String sortBy, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey);
}