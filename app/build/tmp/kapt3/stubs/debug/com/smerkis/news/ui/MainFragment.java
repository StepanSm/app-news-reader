package com.smerkis.news.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0016J\u001a\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0014H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006."}, d2 = {"Lcom/smerkis/news/ui/MainFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/smerkis/news/ui/adapter/RvAdapter$ClickListener;", "Lcom/smerkis/news/ui/adapter/VpAdapter$LoaderNews;", "()V", "binding", "Lcom/smerkis/news/databinding/FragmentMainBinding;", "getBinding", "()Lcom/smerkis/news/databinding/FragmentMainBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "pageAdapter", "Lcom/smerkis/news/ui/adapter/VpAdapter;", "vModel", "Lcom/smerkis/news/viewmodel/NewsViewModel;", "getVModel", "()Lcom/smerkis/news/viewmodel/NewsViewModel;", "vModel$delegate", "Lkotlin/Lazy;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager$delegate", "nextCategory", "", "category", "", "onClick", "article", "Lcom/smerkis/news/model/ArticleStructure;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupPager", "app_debug"})
public final class MainFragment extends androidx.fragment.app.Fragment implements com.smerkis.news.ui.adapter.RvAdapter.ClickListener, com.smerkis.news.ui.adapter.VpAdapter.LoaderNews {
    private final kotlin.Lazy vModel$delegate = null;
    private final by.kirich1409.viewbindingdelegate.ViewBindingProperty binding$delegate = null;
    private final kotlin.Lazy viewPager$delegate = null;
    private final com.smerkis.news.ui.adapter.VpAdapter pageAdapter = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.smerkis.news.viewmodel.NewsViewModel getVModel() {
        return null;
    }
    
    private final com.smerkis.news.databinding.FragmentMainBinding getBinding() {
        return null;
    }
    
    private final androidx.viewpager2.widget.ViewPager2 getViewPager() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final androidx.viewpager2.widget.ViewPager2 setupPager() {
        return null;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    com.smerkis.news.model.ArticleStructure article) {
    }
    
    @java.lang.Override()
    public void nextCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public MainFragment() {
        super();
    }
}