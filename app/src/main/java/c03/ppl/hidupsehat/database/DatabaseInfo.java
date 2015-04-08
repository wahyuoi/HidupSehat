package c03.ppl.hidupsehat.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
                "create table " + DatabaseField.USER_TABLE + " (id integer, "+DatabaseField.USER_COLUMN_USERNAME
                        +" text primary key, "+ DatabaseField.USER_COLUMN_PASSWORD+" text, "+DatabaseField.USER_COLUMN_IS_LOGIN
                        +" number, "+DatabaseField.USER_COLUMN_NAMA+" text, "+DatabaseField.USER_COLUMN_TINGGI
                        +" number, "+DatabaseField.USER_COLUMN_BERAT+" number)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String table, ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.insert(table, null, contentValues);
        db.close();
        return id != -1;
    }

    public boolean update(String table, ContentValues contentValues, String where, String[] values){
        SQLiteDatabase db = this.getWritableDatabase();
        int ret = db.update(table, contentValues, where, values);
        db.close();
        return ret>0;
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
        res.close();
        db.close();
        return arr;
    }

    public boolean isLogin(String userTable, String userColumnIsLogin) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + userTable + " where " + userColumnIsLogin + " = 1", null);

        res.moveToFirst();
        boolean ret = false;
        if (res.isAfterLast() == false)
            ret = res.getInt(res.getColumnIndex(userColumnIsLogin)) == 1;
        res.close();
        db.close();
        return ret;
    }

    public Cursor getFromQuery(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(query, null);

        res.moveToFirst();
        return res;
    }
}
