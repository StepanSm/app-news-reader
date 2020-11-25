package com.smerkis.news.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/smerkis/news/ui/adapter/VpAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/smerkis/news/ui/adapter/VpAdapter$Holder;", "loader", "Lcom/smerkis/news/ui/adapter/VpAdapter$LoaderNews;", "(Lcom/smerkis/news/ui/adapter/VpAdapter$LoaderNews;)V", "getLoader", "()Lcom/smerkis/news/ui/adapter/VpAdapter$LoaderNews;", "setLoader", "news", "Ljava/util/ArrayList;", "Lcom/smerkis/news/model/ArticleStructure;", "getNews", "()Ljava/util/ArrayList;", "setNews", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "LoaderNews", "app_debug"})
public final class VpAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.smerkis.news.ui.adapter.VpAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.smerkis.news.model.ArticleStructure> news;
    @org.jetbrains.annotations.NotNull()
    private com.smerkis.news.ui.adapter.VpAdapter.LoaderNews loader;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.smerkis.news.model.ArticleStructure> getNews() {
        return null;
    }
    
    public final void setNews(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.smerkis.news.model.ArticleStructure> p0) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smerkis.news.ui.adapter.VpAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.ui.adapter.VpAdapter.Holder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smerkis.news.ui.adapter.VpAdapter.LoaderNews getLoader() {
        return null;
    }
    
    public final void setLoader(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.ui.adapter.VpAdapter.LoaderNews p0) {
    }
    
    public VpAdapter(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.ui.adapter.VpAdapter.LoaderNews loader) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/smerkis/news/ui/adapter/VpAdapter$LoaderNews;", "", "nextCategory", "", "category", "", "app_debug"})
    public static abstract interface LoaderNews {
        
        public abstract void nextCategory(@org.jetbrains.annotations.NotNull()
        java.lang.String category);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/smerkis/news/ui/adapter/VpAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smerkis/news/databinding/RvNewsFeedBinding;", "(Lcom/smerkis/news/ui/adapter/VpAdapter;Lcom/smerkis/news/databinding/RvNewsFeedBinding;)V", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.smerkis.news.databinding.RvNewsFeedBinding binding) {
            super(null);
        }
    }
}