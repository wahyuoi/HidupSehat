package c03.ppl.hidupsehat.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import c03.ppl.hidupsehat.database.DatabaseField;

/**
 * Created by wahyuoi on 04/04/15.
 */
public class DatabaseInfo extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public DatabaseInfo(Context context) {
        super(context, DatabaseField.DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + DatabaseField.USER_TABLE + " (id integer, username text primary key, password text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String table, String user, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", user);
        contentValues.put("password", pass);

        long id = db.insert(table, null, contentValues);
        return id != -1;
    }

    public ArrayList getAllDataFromTable(String table, String column_name){
        ArrayList arr = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + table, null);

        res.moveToFirst();
        while(res.isAfterLast() == false){
            arr.add(res.getString(res.getColumnIndex(column_name)));
            res.moveToNext();
        }

        return arr;
    }
}
