package com.example.movies24.movieList.data.movie;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<MovieEntity> __upsertionAdapterOfMovieEntity;

  public MovieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfMovieEntity = new EntityUpsertionAdapter<MovieEntity>(new EntityInsertionAdapter<MovieEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `MovieEntity` (`adult`,`backdrop_path`,`genre_ids`,`original_language`,`original_title`,`overview`,`popularity`,`poster_path`,`release_date`,`title`,`video`,`vote_average`,`vote_count`,`id`,`category`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final MovieEntity entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        if (entity.getBackdrop_path() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getBackdrop_path());
        }
        if (entity.getGenre_ids() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getGenre_ids());
        }
        if (entity.getOriginal_language() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getOriginal_language());
        }
        if (entity.getOriginal_title() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getOriginal_title());
        }
        if (entity.getOverview() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getOverview());
        }
        statement.bindDouble(7, entity.getPopularity());
        if (entity.getPoster_path() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPoster_path());
        }
        if (entity.getRelease_date() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getRelease_date());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTitle());
        }
        final int _tmp_1 = entity.getVideo() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindDouble(12, entity.getVote_average());
        statement.bindLong(13, entity.getVote_count());
        statement.bindLong(14, entity.getId());
        if (entity.getCategory() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getCategory());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<MovieEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `MovieEntity` SET `adult` = ?,`backdrop_path` = ?,`genre_ids` = ?,`original_language` = ?,`original_title` = ?,`overview` = ?,`popularity` = ?,`poster_path` = ?,`release_date` = ?,`title` = ?,`video` = ?,`vote_average` = ?,`vote_count` = ?,`id` = ?,`category` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final MovieEntity entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        if (entity.getBackdrop_path() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getBackdrop_path());
        }
        if (entity.getGenre_ids() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getGenre_ids());
        }
        if (entity.getOriginal_language() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getOriginal_language());
        }
        if (entity.getOriginal_title() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getOriginal_title());
        }
        if (entity.getOverview() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getOverview());
        }
        statement.bindDouble(7, entity.getPopularity());
        if (entity.getPoster_path() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPoster_path());
        }
        if (entity.getRelease_date() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getRelease_date());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTitle());
        }
        final int _tmp_1 = entity.getVideo() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindDouble(12, entity.getVote_average());
        statement.bindLong(13, entity.getVote_count());
        statement.bindLong(14, entity.getId());
        if (entity.getCategory() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getCategory());
        }
        statement.bindLong(16, entity.getId());
      }
    });
  }

  @Override
  public Object upsertMovieList(final List<MovieEntity> movieList,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfMovieEntity.upsert(movieList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMovieById(final int id, final Continuation<? super MovieEntity> $completion) {
    final String _sql = "Select * from MovieEntity where id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MovieEntity>() {
      @Override
      @NonNull
      public MovieEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdult = CursorUtil.getColumnIndexOrThrow(_cursor, "adult");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfGenreIds = CursorUtil.getColumnIndexOrThrow(_cursor, "genre_ids");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "original_title");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final MovieEntity _result;
          if (_cursor.moveToFirst()) {
            final boolean _tmpAdult;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAdult);
            _tmpAdult = _tmp != 0;
            final String _tmpBackdrop_path;
            if (_cursor.isNull(_cursorIndexOfBackdropPath)) {
              _tmpBackdrop_path = null;
            } else {
              _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
            }
            final String _tmpGenre_ids;
            if (_cursor.isNull(_cursorIndexOfGenreIds)) {
              _tmpGenre_ids = null;
            } else {
              _tmpGenre_ids = _cursor.getString(_cursorIndexOfGenreIds);
            }
            final String _tmpOriginal_language;
            if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
              _tmpOriginal_language = null;
            } else {
              _tmpOriginal_language = _cursor.getString(_cursorIndexOfOriginalLanguage);
            }
            final String _tmpOriginal_title;
            if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
              _tmpOriginal_title = null;
            } else {
              _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final String _tmpRelease_date;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpRelease_date = null;
            } else {
              _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpVideo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVideo);
            _tmpVideo = _tmp_1 != 0;
            final double _tmpVote_average;
            _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final int _tmpVote_count;
            _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _result = new MovieEntity(_tmpAdult,_tmpBackdrop_path,_tmpGenre_ids,_tmpOriginal_language,_tmpOriginal_title,_tmpOverview,_tmpPopularity,_tmpPoster_path,_tmpRelease_date,_tmpTitle,_tmpVideo,_tmpVote_average,_tmpVote_count,_tmpId,_tmpCategory);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMovieListByCategory(final String category,
      final Continuation<? super List<MovieEntity>> $completion) {
    final String _sql = "Select * from MovieEntity where category=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<MovieEntity>>() {
      @Override
      @NonNull
      public List<MovieEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdult = CursorUtil.getColumnIndexOrThrow(_cursor, "adult");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfGenreIds = CursorUtil.getColumnIndexOrThrow(_cursor, "genre_ids");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "original_title");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<MovieEntity> _result = new ArrayList<MovieEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MovieEntity _item;
            final boolean _tmpAdult;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAdult);
            _tmpAdult = _tmp != 0;
            final String _tmpBackdrop_path;
            if (_cursor.isNull(_cursorIndexOfBackdropPath)) {
              _tmpBackdrop_path = null;
            } else {
              _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
            }
            final String _tmpGenre_ids;
            if (_cursor.isNull(_cursorIndexOfGenreIds)) {
              _tmpGenre_ids = null;
            } else {
              _tmpGenre_ids = _cursor.getString(_cursorIndexOfGenreIds);
            }
            final String _tmpOriginal_language;
            if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
              _tmpOriginal_language = null;
            } else {
              _tmpOriginal_language = _cursor.getString(_cursorIndexOfOriginalLanguage);
            }
            final String _tmpOriginal_title;
            if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
              _tmpOriginal_title = null;
            } else {
              _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final String _tmpRelease_date;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpRelease_date = null;
            } else {
              _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final boolean _tmpVideo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVideo);
            _tmpVideo = _tmp_1 != 0;
            final double _tmpVote_average;
            _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final int _tmpVote_count;
            _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new MovieEntity(_tmpAdult,_tmpBackdrop_path,_tmpGenre_ids,_tmpOriginal_language,_tmpOriginal_title,_tmpOverview,_tmpPopularity,_tmpPoster_path,_tmpRelease_date,_tmpTitle,_tmpVideo,_tmpVote_average,_tmpVote_count,_tmpId,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
