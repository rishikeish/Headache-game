package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Classes.Level1;
import Classes.User;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Headache.db";
    public DBHandler( Context context) {
        super(context, DATABASE_NAME, null , 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("DROP TABLE IF EXISTS "+UserMasters.Users.TABLE_NAME+ " ;");

        String QUERY1 = "CREATE TABLE " + UserMasters.Users.TABLE_NAME + " ( " +
                UserMasters.Users.COL_1 + " VARCHAR(20) PRIMARY KEY, " +
                UserMasters.Users.COL_2+ " VARCHAR(30) ) " ;

        db.execSQL(QUERY1);

        //level1 table
        String QUERY1a = "CREATE TABLE IF NOT EXISTS " + UserMasters.Level1.TABLE_NAME + " ( " +
                UserMasters.Level1._ID + " INTEGER PRIMARY KEY, " +
                UserMasters.Level1.COL_1+ " VARCHAR(30) ) " ;


        ContentValues values = new ContentValues();
        values.put(UserMasters.Level1.COL_1, "BUBBLES");
        values.put(UserMasters.Level1.COL_1, "SHAMPOO");
        values.put(UserMasters.Level1.COL_1, "TOILET");
        values.put(UserMasters.Level1.COL_1, "SOAP");


        long newRowId = db.insert(UserMasters.Level1.TABLE_NAME, null, values);

//        String QUERY2 = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" (ANSWERS) VALUES('BUBBLES')";
//        String QUERY3 = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('SHAMPOO')";
//        String QUERY4 = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('TOILET')";
//        String QUERY5 = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('SOAP')";

        db.execSQL(QUERY1a);
//        db.execSQL(QUERY2);
//        db.execSQL(QUERY3);
//        db.execSQL(QUERY4);
//        db.execSQL(QUERY5);

        //level2 table

        //db.execSQL("DROP TABLE IF EXISTS "+UserMasters.Level2.TABLE_NAME+ " ;");

        String QUERY1b = "CREATE TABLE IF NOT EXISTS " + UserMasters.Level2.TABLE_NAME + " ( " +
                UserMasters.Level2._ID + " INTEGER PRIMARY KEY, " +
                UserMasters.Level2.COL_1+ " VARCHAR(30) ) " ;

        //String QUERY2b = "INSERT INTO " +UserMasters.Level2.TABLE_NAME+" ("+ UserMasters.Level2.COL_1+ ") VALUES('SALT')";


        db.execSQL(QUERY1b);
       // db.execSQL(QUERY2b);

        //level03 table

 //       db.execSQL("DROP TABLE IF EXISTS "+UserMasters.Level3.TABLE_NAME+ " ;");
        String QUERY1c = "CREATE TABLE IF NOT EXISTS " + UserMasters.Level3.TABLE_NAME + " ( " +
                UserMasters.Level3._ID + " INTEGER PRIMARY KEY, " +
                UserMasters.Level3.COL_1+ " VARCHAR(30) ) " ;

//        String QUERY2c = "INSERT INTO " +UserMasters.Level3.TABLE_NAME+" ("+ UserMasters.Level3.COL_1+ ") VALUES(BUBBLES)";
//        String QUERY3c = "INSERT INTO " +UserMasters.Level3.TABLE_NAME+" ("+ UserMasters.Level3.COL_1+ ") VALUES(SHAMPOO)";
//        String QUERY4c = "INSERT INTO " +UserMasters.Level3.TABLE_NAME+" ("+ UserMasters.Level3.COL_1+ ") VALUES(TOILET)";
//        String QUERY5c = "INSERT INTO " +UserMasters.Level3.TABLE_NAME+" ("+ UserMasters.Level3.COL_1+ ") VALUES(SOAP)";
//
        db.execSQL(QUERY1c);
//        db.execSQL(QUERY2c);
//        db.execSQL(QUERY3c);
//        db.execSQL(QUERY4c);
//        db.execSQL(QUERY5c);

        //level04 table

       // db.execSQL("DROP TABLE IF EXISTS "+UserMasters.Level4.TABLE_NAME+ " ;");
        String QUERY1d = "CREATE TABLE IF NOT EXISTS " + UserMasters.Level4.TABLE_NAME + " ( " +
                UserMasters.Level4._ID + " INTEGER PRIMARY KEY, " +
                UserMasters.Level4.COL_1+ " VARCHAR(100),"+
                UserMasters.Level4.COL_2+ " VARCHAR(100) )";

//        String QUERY2d = "INSERT INTO " +UserMasters.Level4.TABLE_NAME+" ("+ UserMasters.Level4.COL_1+ " ," +UserMasters.Level4.COL_2+ ") VALUES('' , '')";
//        String QUERY3d = "INSERT INTO " +UserMasters.Level4.TABLE_NAME+" ("+ UserMasters.Level4.COL_1+ " ," +UserMasters.Level4.COL_2+ ") VALUES('', '')";
//        String QUERY4d = "INSERT INTO " +UserMasters.Level4.TABLE_NAME+" ("+ UserMasters.Level4.COL_1+ " ," +UserMasters.Level4.COL_2+ ") VALUES('', '')";
//        String QUERY5d = "INSERT INTO " +UserMasters.Level4.TABLE_NAME+" ("+ UserMasters.Level4.COL_1+ " ," +UserMasters.Level4.COL_2+ ") VALUES('', '')";
//
        db.execSQL(QUERY1d);
//        db.execSQL(QUERY2d);
//        db.execSQL(QUERY3d);
//        db.execSQL(QUERY4d);
//        db.execSQL(QUERY5d);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUser(String username, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMasters.Users.COL_1, username);
        values.put(UserMasters.Users.COL_2, password);

        long newRowId = db.insert(UserMasters.Users.TABLE_NAME, null, values);
        return true;
    }

    public List readAllUsers() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UserMasters.Users.COL_1,
                UserMasters.Users.COL_2
        };

        String sortOrder = UserMasters.Users.COL_1 + " DESC";


        Cursor cursor = db.query(
                UserMasters.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        ArrayList<User> users = new ArrayList<>();


        while(cursor.moveToNext()){

            String username = cursor.getString( cursor.getColumnIndexOrThrow(UserMasters.Users.COL_1));
            String password = cursor.getString( cursor.getColumnIndexOrThrow(UserMasters.Users.COL_2));

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            users.add(user);

        }

        cursor.close();
        return users;

    }


    public void deleteInfo(String userName){

        SQLiteDatabase db = getReadableDatabase();

        String selection = UserMasters.Users.COL_1 + " LIKE ?";

        String[] selectionArgs = { userName } ;

        db.delete(UserMasters.Users.TABLE_NAME, selection,selectionArgs);

    }

    public void updateInfo(String userName , String password){

        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMasters.Users.COL_2,password);

        String selection = UserMasters.Users.COL_1;
        String[] selectionArgs = {userName};

        int count = db.update(
                UserMasters.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }


}




