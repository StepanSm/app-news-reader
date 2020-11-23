package com.smerkis.news.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.smerkis.news.model.ArticleStructure

@Database(
    entities = [ArticleStructure::class],
    version = 1,
    exportSchema = true
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsArticlesDao(): NewsArticleDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "news_article"
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        //In case app has to migrate to a new DBDao
        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}