package com.smerkis.news.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/smerkis/news/viewmodel/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/smerkis/news/repo/NewsRepo;", "(Lcom/smerkis/news/repo/NewsRepo;)V", "errorData", "Landroidx/lifecycle/MutableLiveData;", "", "getErrorData", "()Landroidx/lifecycle/MutableLiveData;", "errorData$delegate", "Lkotlin/Lazy;", "searchListResult", "", "Lcom/smerkis/news/model/ArticleStructure;", "getSearchListResult", "searchListResult$delegate", "getSearchResult", "", "searchRequest", "", "app_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy searchListResult$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy errorData$delegate = null;
    private final com.smerkis.news.repo.NewsRepo repo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.smerkis.news.model.ArticleStructure>> getSearchListResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Throwable> getErrorData() {
        return null;
    }
    
    public final void getSearchResult(@org.jetbrains.annotations.NotNull()
    java.lang.String searchRequest) {
    }
    
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.repo.NewsRepo repo) {
        super();
    }
}