package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Headache.db";
    public DBHandler( Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY1 = "CREATE TABLE " + UserMasters.Users.TABLE_NAME + " ( " +
                UserMasters.Users.COL_1 + " VARCHAR(20) PRIMARY KEY, " +
                UserMasters.Users.COL_2+ " VARCHAR(30) ) " ;

        db.execSQL(QUERY1);

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

        String sortOrder = UserMasters.Users.COL_1 + "DESC";


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




