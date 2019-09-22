package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Classes.User;

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

        //level1 table

        String QUERY1a = "CREATE TABLE " + UserMasters.Level1.TABLE_NAME + " ( " +
                UserMasters.Level1._ID + " INTEGER PRIMARY KEY, " +
                UserMasters.Level1.COL_1+ " VARCHAR(30) ) " ;



        String QUERY2a = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('BUBBLES'),('BUBBLE'),('BUB'),('Hob'),('Two'),('Oak'),('Tit'),('Rush'),('Beak')";
        String QUERY3a = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('SHAMPOO'),('Poo'),('Pooh'),('Sham'),('Pal'),('Paly'),('Tar'),('Dry'),('Dryer')";
        String QUERY4a = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('TOILET'),('Tsk'),('Toil'),('Let'),('Oil'),('Bad'),('Ado'),('Bob'),('Bait'),('Wot')";
        String QUERY5a = "INSERT INTO " +UserMasters.Level1.TABLE_NAME+" ("+ UserMasters.Level1.COL_1+ ") VALUES('SOAP'),('Ham'),('Amp'),('Lot'),('Loth'),('Cloth'),('Brush'),('Bat'),('Bath'),('Baths')";

        db.execSQL(QUERY1a);
        db.execSQL(QUERY2a);
        db.execSQL(QUERY3a);
        db.execSQL(QUERY4a);
        db.execSQL(QUERY5a);

        //level2 table



        String QUERY1b = "CREATE TABLE " + UserMasters.Level2.TABLE_NAME + " ( " +
                UserMasters.Level2._ID + " INTEGER PRIMARY KEY, " +
                UserMasters.Level2.COL_1+ " VARCHAR(30) ) " ;

        String QUERY2b = "INSERT INTO " +UserMasters.Level2.TABLE_NAME+" ("+ UserMasters.Level2.COL_1+ ") VALUES('SALT')";

        db.execSQL(QUERY1b);
        db.execSQL(QUERY2b);

        //level03 table


        String QUERY1c = "CREATE TABLE " + UserMasters.Level3.TABLE_NAME + " ( " +
                UserMasters.Level3.COL_1 + " INTEGER PRIMARY KEY, " +
                UserMasters.Level3.COL_2+ " VARCHAR(30) ) " ;


        String QUERY_CRYPTO1 = "INSERT INTO " + UserMasters.Level3.TABLE_NAME + " ("+ UserMasters.Level3.COL_1 + ", " + UserMasters.Level3.COL_2 + ") VALUES (1,'LYRIC'); " ;
        String QUERY_CRYPTO2 = "INSERT INTO " + UserMasters.Level3.TABLE_NAME + " ("+ UserMasters.Level3.COL_1 + ", " + UserMasters.Level3.COL_2 + ") VALUES (2,'RHYME'); " ;
        String QUERY_CRYPTO3 = "INSERT INTO " + UserMasters.Level3.TABLE_NAME + " ("+ UserMasters.Level3.COL_1 + ", " + UserMasters.Level3.COL_2 + ") VALUES (3,'NURSERY'); ";

        db.execSQL(QUERY1c);
        db.execSQL(QUERY_CRYPTO1);
        db.execSQL(QUERY_CRYPTO2);
        db.execSQL(QUERY_CRYPTO3);


        //level04 table

        String QUERY1d = "CREATE TABLE " + UserMasters.Level4.TABLE_NAME + " ( " +
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




