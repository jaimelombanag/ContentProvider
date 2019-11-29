package com.androidtutorialpoint.mycontacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "taximetro.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for table and columns
    public static final String TABLE_DATA = "datos";
    public static final String CONTACT_ID = "_id";
    public static final String CONTACT_DATA = "data";
    public static final String CONTACT_PHONE = "contactPhone";
    public static final String CONTACT_CREATED_ON = "contactCreationTimeStamp";

    public static final String[] ALL_COLUMNS =
            {CONTACT_ID,CONTACT_DATA,CONTACT_PHONE,CONTACT_CREATED_ON};

    //Create Table
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_DATA + " (" +
                    CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CONTACT_DATA + " TEXT, " +
                    CONTACT_PHONE + " TEXT, " +
                    CONTACT_CREATED_ON + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_DATA);
        onCreate(sqLiteDatabase);
    }
}
