package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Level4Handler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Headache.db";

    public Level4Handler( Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public String GetAnswer(String question) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UserMasters.Level4._ID,
                UserMasters.Level4.COL_1

        };

        String selection = UserMasters.Level4.COL_1 + " =?";
        String[] selectionArgs = {question};

        String sortOrder = UserMasters.Level4._ID + " DESC";


        Cursor cursor = db.query(
                UserMasters.Level4.TABLE_NAME,
                projection,
                selection,
                null,
                null,
                null,
                sortOrder
        );

            String Answer = cursor.getString( cursor.getColumnIndexOrThrow(UserMasters.Level4.COL_1));

        return Answer;

    }
}
