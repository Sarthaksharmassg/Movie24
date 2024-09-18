package com.example.movies24.movieList.data.movie;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDatabase_Impl extends MovieDatabase {
  private volatile MovieDao _movieDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `MovieEntity` (`adult` INTEGER NOT NULL, `backdrop_path` TEXT NOT NULL, `genre_ids` TEXT NOT NULL, `original_language` TEXT NOT NULL, `original_title` TEXT NOT NULL, `overview` TEXT NOT NULL, `popularity` REAL NOT NULL, `poster_path` TEXT NOT NULL, `release_date` TEXT NOT NULL, `title` TEXT NOT NULL, `video` INTEGER NOT NULL, `vote_average` REAL NOT NULL, `vote_count` INTEGER NOT NULL, `id` INTEGER NOT NULL, `category` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '54e5aeae32454194b9344fa65dc09257')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `MovieEntity`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsMovieEntity = new HashMap<String, TableInfo.Column>(15);
        _columnsMovieEntity.put("adult", new TableInfo.Column("adult", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("backdrop_path", new TableInfo.Column("backdrop_path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("genre_ids", new TableInfo.Column("genre_ids", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("original_language", new TableInfo.Column("original_language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("original_title", new TableInfo.Column("original_title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("overview", new TableInfo.Column("overview", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("popularity", new TableInfo.Column("popularity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("poster_path", new TableInfo.Column("poster_path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("release_date", new TableInfo.Column("release_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("video", new TableInfo.Column("video", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("vote_average", new TableInfo.Column("vote_average", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("vote_count", new TableInfo.Column("vote_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieEntity.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMovieEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMovieEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMovieEntity = new TableInfo("MovieEntity", _columnsMovieEntity, _foreignKeysMovieEntity, _indicesMovieEntity);
        final TableInfo _existingMovieEntity = TableInfo.read(db, "MovieEntity");
        if (!_infoMovieEntity.equals(_existingMovieEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "MovieEntity(com.example.movies24.movieList.data.movie.MovieEntity).\n"
                  + " Expected:\n" + _infoMovieEntity + "\n"
                  + " Found:\n" + _existingMovieEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "54e5aeae32454194b9344fa65dc09257", "df6b6733e68b841fc23a99385dc809c5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "MovieEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `MovieEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MovieDao.class, MovieDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MovieDao getMovieDao() {
    if (_movieDao != null) {
      return _movieDao;
    } else {
      synchronized(this) {
        if(_movieDao == null) {
          _movieDao = new MovieDao_Impl(this);
        }
        return _movieDao;
      }
    }
  }
}
