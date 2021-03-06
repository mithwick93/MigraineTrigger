package shehan.com.migrainetrigger.utility.database;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import shehan.com.migrainetrigger.utility.MigraineTriggerApplication;

/**
 * This singleton class is used to get connection to SQLiteDatabase
 * Created by Shehan on 4/13/2016.
 */
public class DatabaseHandler implements DatabaseDefinition {

    //Used to open database in synchronized way (singleton)
    private static DataBaseHelper DBHelper = null;

    //Do not instantiate this class
    private DatabaseHandler() {
    }

    /**
     * Open database for read
     *
     * @return - SQLiteDatabase
     * @throws SQLiteException
     */
    public static SQLiteDatabase getReadableDatabase() throws SQLiteException {
        if (DBHelper == null) {
            synchronized (DatabaseHandler.class) {
                DBHelper = new DataBaseHelper();
                Log.d("DatabaseHandler", "new DataBaseHelper()");
            }
        }
        Log.d("DatabaseHandler", "return getReadableDatabase");
        return DBHelper.getReadableDatabase();
    }

    /**
     * Open database for insert,update,delete in synchronized manner
     *
     * @return - SQLiteDatabase
     * @throws SQLiteException
     */
    public static SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (DBHelper == null) {
            synchronized (DatabaseHandler.class) {
                DBHelper = new DataBaseHelper();
                Log.d("DatabaseHandler", "new DataBaseHelper()");
            }
        }
        Log.d("DatabaseHandler", "return getWritableDatabase");
        return DBHelper.getWritableDatabase();
    }

    /**
     * Initialize or test database
     */
    public static void testDatabase() throws Exception {
        Log.d("DatabaseHandler", "testing database");

        getReadableDatabase();
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.getVersion();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    /**
     * Inner class to actually handle Database
     */
    public static class DataBaseHelper extends SQLiteOpenHelper {
        public DataBaseHelper() {
            super(MigraineTriggerApplication.getAppContext(), DATABASE_NAME, null, DATABASE_VERSION);
            Log.d("DataBaseHelper", "constructor called");
        }

        @SuppressLint("NewApi")
        @Override
        public void onConfigure(SQLiteDatabase database) {
            Log.d("DataBaseHelper", "onConfigure");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                database.setForeignKeyConstraintsEnabled(true);
            } else {
                database.execSQL("PRAGMA foreign_keys=ON");
            }
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("DataBaseHelper", "onCreate");
            try {
                //Create the tables on the first run
                db.execSQL(RECORD_CREATE);
                db.execSQL(ACTIVITY_CREATE);
                db.execSQL(BODY_AREA_CREATE);
                db.execSQL(LOCATION_CREATE);
                db.execSQL(MEDICINE_CREATE);
                db.execSQL(RELIEF_CREATE);
                db.execSQL(SYMPTOM_CREATE);
                db.execSQL(TRIGGER_CREATE);
                db.execSQL(WEATHER_DATA_CREATE);

                db.execSQL(ACTIVITY_RECORD_CREATE);
                db.execSQL(BODY_AREA_RECORD_CREATE);
                db.execSQL(MEDICINE_RECORD_CREATE);
                db.execSQL(RELIEF_RECORD_CREATE);
                db.execSQL(SYMPTOM_RECORD_CREATE);
                db.execSQL(TRIGGER_RECORD_CREATE);

                //Add default data
                db.execSQL(ACTIVITY_INSERT);
                db.execSQL(BODY_AREA_INSERT);
                db.execSQL(LOCATION_INSERT);
                db.execSQL(MEDICINE_INSERT);
                db.execSQL(RELIEF_INSERT);
                db.execSQL(SYMPTOM_INSERT);
                db.execSQL(TRIGGER_INSERT);
                Log.d("DatabaseHandler", "Create queries run successfully");
            } catch (Exception exception) {
                Log.i("DatabaseHandler", "Exception onCreate() exception : " + exception.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            for (String table : ALL_TABLES) {
                db.execSQL("DROP TABLE IF EXISTS " + table); //On upgrade drop tables
            }
            onCreate(db);
        }
    }
}
