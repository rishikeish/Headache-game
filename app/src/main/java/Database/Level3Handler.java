package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Level3Handler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Headache.db";

    public Level3Handler( Context context) {
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
                UserMasters.Level3.COL_1,
                UserMasters.Level3.COL_2

        };

        String sortOrder = UserMasters.Level3.COL_1 + " ASC";


        Cursor cursor = db.query(
                UserMasters.Level3.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        ArrayList<String> Answers = new ArrayList<>();


        while(cursor.moveToNext()){

            String Answer = cursor.getString( cursor.getColumnIndexOrThrow(UserMasters.Level3.COL_2));

            Answers.add(Answer);

        }

        cursor.close();
        return Answers;

    }
}
