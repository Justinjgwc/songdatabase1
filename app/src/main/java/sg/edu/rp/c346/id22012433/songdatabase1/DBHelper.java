package sg.edu.rp.c346.id22012433.songdatabase1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    // Filename of the database
    private static final String DATABASE_NAME = "songs.db";

    private static final String TABLE_SONG = "song";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGERS = "singers";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_STAR = "star";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_SONG +  "("
                + COLUMN_TITLE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SINGERS + " TEXT,"
                + COLUMN_YEAR + " INT,"
                + COLUMN_STAR + "INT)";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        // Create table(s) again
        onCreate(db);

    }
    public void insertSong(String title, String singers, Integer year, Integer star){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_TITLE, title);
        // Store the column name as key and the date as value
        values.put(COLUMN_SINGERS, singers);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_STAR, star);
        db.insert(TABLE_SONG, null, values);
        // Close the database connection
        db.close();
    }
    public ArrayList<String> getsong() {
        // Create an ArrayList that holds String objects
        ArrayList<String> tasks = new ArrayList<String>();
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_TITLE,COLUMN_SINGERS, COLUMN_YEAR, COLUMN_STAR};
        // Run the query and get back the Cursor object
        Cursor cursor = db.query(TABLE_SONG, columns, null, null, null, null, null, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                tasks.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return tasks;
    }

}
