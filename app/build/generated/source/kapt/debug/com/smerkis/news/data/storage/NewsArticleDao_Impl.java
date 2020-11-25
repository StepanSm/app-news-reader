package com.smerkis.news.data.storage;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.smerkis.news.model.ArticleStructure;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsArticleDao_Impl implements NewsArticleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArticleStructure> __insertionAdapterOfArticleStructure;

  private final EntityDeletionOrUpdateAdapter<ArticleStructure> __updateAdapterOfArticleStructure;

  private final SharedSQLiteStatement __preparedStmtOfClearAllArticles;

  public NewsArticleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticleStructure = new EntityInsertionAdapter<ArticleStructure>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `news_article` (`author`,`title`,`description`,`url`,`urlToImage`,`publishedAt`,`content`,`category`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArticleStructure value) {
        if (value.getAuthor() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAuthor());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrl());
        }
        if (value.getUrlToImage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrlToImage());
        }
        if (value.getPublishedAt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPublishedAt());
        }
        if (value.getContent() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContent());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCategory());
        }
      }
    };
    this.__updateAdapterOfArticleStructure = new EntityDeletionOrUpdateAdapter<ArticleStructure>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `news_article` SET `author` = ?,`title` = ?,`description` = ?,`url` = ?,`urlToImage` = ?,`publishedAt` = ?,`content` = ?,`category` = ? WHERE `title` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArticleStructure value) {
        if (value.getAuthor() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAuthor());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrl());
        }
        if (value.getUrlToImage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrlToImage());
        }
        if (value.getPublishedAt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPublishedAt());
        }
        if (value.getContent() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContent());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCategory());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTitle());
        }
      }
    };
    this.__preparedStmtOfClearAllArticles = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM news_article";
        return _query;
      }
    };
  }

  @Override
  public void insert(final List<ArticleStructure> articles) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfArticleStructure.insert(articles);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateArticle(final ArticleStructure articleModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfArticleStructure.handle(articleModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearAllArticles() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllArticles.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearAllArticles.release(_stmt);
    }
  }

  @Override
  public Flow<List<ArticleStructure>> getAllArticlesForCategory(final String category) {
    final String _sql = "select * from news_article where category = ? order by publishedAt desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"news_article"}, new Callable<List<ArticleStructure>>() {
      @Override
      public List<ArticleStructure> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<ArticleStructure> _result = new ArrayList<ArticleStructure>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ArticleStructure _item;
            _item = new ArticleStructure();
            final String _tmpAuthor;
            _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            _item.setAuthor(_tmpAuthor);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item.setTitle(_tmpTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            _item.setUrl(_tmpUrl);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            _item.setUrlToImage(_tmpUrlToImage);
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            _item.setPublishedAt(_tmpPublishedAt);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            _item.setContent(_tmpContent);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            _item.setCategory(_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
