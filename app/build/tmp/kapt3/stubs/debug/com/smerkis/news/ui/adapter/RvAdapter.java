package com.smerkis.news.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/smerkis/news/ui/adapter/RvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/smerkis/news/ui/adapter/RvAdapter$Holder;", "newsList", "", "Lcom/smerkis/news/model/ArticleStructure;", "clickListener", "Lcom/smerkis/news/ui/adapter/RvAdapter$ClickListener;", "(Ljava/util/List;Lcom/smerkis/news/ui/adapter/RvAdapter$ClickListener;)V", "lastPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "news", "ClickListener", "Holder", "app_debug"})
public final class RvAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.smerkis.news.ui.adapter.RvAdapter.Holder> {
    private int lastPosition = -1;
    private java.util.List<com.smerkis.news.model.ArticleStructure> newsList;
    private final com.smerkis.news.ui.adapter.RvAdapter.ClickListener clickListener = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smerkis.news.ui.adapter.RvAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.ui.adapter.RvAdapter.Holder holder, int position) {
    }
    
    public final void updateList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smerkis.news.model.ArticleStructure> news) {
    }
    
    public RvAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smerkis.news.model.ArticleStructure> newsList, @org.jetbrains.annotations.NotNull()
    com.smerkis.news.ui.adapter.RvAdapter.ClickListener clickListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/smerkis/news/ui/adapter/RvAdapter$ClickListener;", "", "onClick", "", "article", "Lcom/smerkis/news/model/ArticleStructure;", "app_debug"})
    public static abstract interface ClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.smerkis.news.model.ArticleStructure article);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/smerkis/news/ui/adapter/RvAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smerkis/news/databinding/ItemArticleBinding;", "(Lcom/smerkis/news/ui/adapter/RvAdapter;Lcom/smerkis/news/databinding/ItemArticleBinding;)V", "getBinding", "()Lcom/smerkis/news/databinding/ItemArticleBinding;", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smerkis.news.databinding.ItemArticleBinding binding = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.smerkis.news.databinding.ItemArticleBinding getBinding() {
            return null;
        }
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.smerkis.news.databinding.ItemArticleBinding binding) {
            super(null);
        }
    }
}