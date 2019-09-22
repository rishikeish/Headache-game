package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Level3Handler extends SQLiteOpenHelper {

    //create database object
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
    //list method to read all stored answers
    public List readAnswers() {
        SQLiteDatabase db = getReadableDatabase(); //open database link
        //read table data
        String[] projection = { 

                UserMasters.Level3.COL_2 //read answer column

        };



        //select table data
        Cursor cursor = db.query(
                UserMasters.Level3.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        //array list to store retrieved data
        ArrayList<String> Answers = new ArrayList<>();

        //while loop - read table data
        while(cursor.moveToNext()){

            String Answer = cursor.getString( cursor.getColumnIndexOrThrow(UserMasters.Level3.COL_2));

            Answers.add(Answer);

        }//end of while loop

        cursor.close(); //end cursor
        return Answers; //return values

    }
}
