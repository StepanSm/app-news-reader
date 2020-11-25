package com.smerkis.news.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\f\u0010\tR\'\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/smerkis/news/viewmodel/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/smerkis/news/repo/NewsRepo;", "(Lcom/smerkis/news/repo/NewsRepo;)V", "errorData", "Landroidx/lifecycle/MutableLiveData;", "", "getErrorData", "()Landroidx/lifecycle/MutableLiveData;", "errorData$delegate", "Lkotlin/Lazy;", "isDataLoaded", "", "isDataLoaded$delegate", "newsListLiveData", "", "Lcom/smerkis/news/model/ArticleStructure;", "getNewsListLiveData", "newsListLiveData$delegate", "getNewsForCategory", "", "category", "", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy newsListLiveData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy errorData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isDataLoaded$delegate = null;
    private final com.smerkis.news.repo.NewsRepo repo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.smerkis.news.model.ArticleStructure>> getNewsListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Throwable> getErrorData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isDataLoaded() {
        return null;
    }
    
    public final void getNewsForCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.repo.NewsRepo repo) {
        super();
    }
}