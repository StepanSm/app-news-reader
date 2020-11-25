package com.smerkis.news.data.storage;

import java.lang.System;

@androidx.room.Database(entities = {com.smerkis.news.model.ArticleStructure.class}, version = 1, exportSchema = true)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/smerkis/news/data/storage/NewsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "newsArticlesDao", "Lcom/smerkis/news/data/storage/NewsArticleDao;", "Companion", "app_debug"})
public abstract class NewsDatabase extends androidx.room.RoomDatabase {
    public static final int DB_VERSION = 1;
    private static final java.lang.String DB_NAME = "news_article";
    private static volatile com.smerkis.news.data.storage.NewsDatabase INSTANCE;
    private static final androidx.room.migration.Migration MIGRATION_1_TO_2 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.smerkis.news.data.storage.NewsDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smerkis.news.data.storage.NewsArticleDao newsArticlesDao();
    
    public NewsDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/smerkis/news/data/storage/NewsDatabase$Companion;", "", "()V", "DB_NAME", "", "DB_VERSION", "", "INSTANCE", "Lcom/smerkis/news/data/storage/NewsDatabase;", "MIGRATION_1_TO_2", "Landroidx/room/migration/Migration;", "build", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.smerkis.news.data.storage.NewsDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.smerkis.news.data.storage.NewsDatabase build(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}