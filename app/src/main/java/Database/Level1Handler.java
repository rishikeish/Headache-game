package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Classes.Level1;

public class Level1Handler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Headache.db";

    public Level1Handler( Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }

    public List readAnswers() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UserMasters.Level1._ID,
                UserMasters.Level1.COL_1

        };

        String sortOrder = UserMasters.Level1._ID + " DESC";


        Cursor cursor = db.query(
                UserMasters.Level1.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        ArrayList Answers = new ArrayList<>();


        while(cursor.moveToNext()){

            String Answer = cursor.getString( cursor.getColumnIndexOrThrow(UserMasters.Level1.COL_1));

            Answers.add(Answer);

        }

        cursor.close();
        return Answers;

    }
}
