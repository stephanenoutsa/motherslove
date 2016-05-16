package com.babyandi.stephnoutsa.babyandi;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "lmp.db";
    public static final String TABLE_LMP = "lmp";
    public static final String LMP_COLUMN_ID = "_lmpid";
    public static final String LMP_COLUMN_DATE = "lmpdate";
    public static final String TABLE_RECEIVED = "received";
    public static final String R_COLUMN_ID = "_rid";
    public static final String R_COLUMN_NUMBER = "number";
    public static final  String TABLE_NOTIFICATIONS = "notifications";
    public static final String N_COLUMN_ID = "_nid";
    public static final String N_COLUMN_DAY = "nday";
    public static final String N_COLUMN_MESSAGE = "nmessage";
    public static final String TABLE_EDD = "edd";
    public static final String EDD_COLUMN_ID = "_eddid";
    public static final String EDD_COLUMN_DAY = "eddate";
    public static final String TABLE_SPECIAL_NEEDS = "special_needs";
    public static final String SN_COLUMN_ID = "_snid";
    public static final String SN_COLUMN_HIV = "hiv";
    public static final String SN_COLUMN_HEPATITIS = "hepatitis";
    public static final String TABLE_DOB = "dob";
    public static final String D_COLUMN_ID = "_did";
    public static final String D_COLUMN_DAY = "dday";
    public static final String D_COLUMN_R = "dreceived";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_LMP);
        String lmp = "CREATE TABLE " + TABLE_LMP + "(" +
                LMP_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                LMP_COLUMN_DATE + " DATE " +
                ")";
        db.execSQL(lmp);

        String notif = "CREATE TABLE " + TABLE_NOTIFICATIONS + "(" +
                N_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                N_COLUMN_DAY + " TEXT " + ", " +
                N_COLUMN_MESSAGE + " TEXT " +
                ")";
        db.execSQL(notif);

        String edd = "CREATE TABLE " + TABLE_EDD + "(" +
                EDD_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                EDD_COLUMN_DAY + " TEXT" + ")";
        db.execSQL(edd);

        String sn = "CREATE TABLE " + TABLE_SPECIAL_NEEDS + "(" +
                SN_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                SN_COLUMN_HIV + " TEXT" + ", " +
                SN_COLUMN_HEPATITIS + " TEXT" + ")";
        db.execSQL(sn);

        String r = "CREATE TABLE " + TABLE_RECEIVED + "(" +
                R_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                R_COLUMN_NUMBER + " INTEGER" + ")";
        db.execSQL(r);

        String dob = "CREATE TABLE " + TABLE_DOB + "(" +
                D_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + ", " +
                D_COLUMN_DAY + " TEXT" + ", " +
                D_COLUMN_R + " INTEGER" + ")";
        db.execSQL(dob);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LMP + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EDD + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPECIAL_NEEDS + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECEIVED + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOB + ";");
        onCreate(db);
    }

    // Add new LMP date to LMP table
    public void addLMP(LMP lmp) {
        ContentValues values = new ContentValues();
        values.put(LMP_COLUMN_DATE, String.valueOf(lmp.getLmpdate()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LMP, null, values);
        db.close();
    }

    // Get the LMP
    public String getLMP() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_LMP + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return null;
        c.moveToLast();
        String lmpDate = c.getString(c.getColumnIndex(LMP_COLUMN_DATE));
        try {
            return lmpDate;
        } finally {
            c.close();
            db.close();
        }
    }

    // Add new EDD to EDD table
    public void addEDD(EDD edd) {
        ContentValues values = new ContentValues();
        values.put(EDD_COLUMN_DAY, String.valueOf(edd.getEddate()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EDD, null, values);
        db.close();
    }

    // Get the EDD
    public String getEDD() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EDD + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return null;
        c.moveToLast();
        String eddate = c.getString(c.getColumnIndex(EDD_COLUMN_DAY));
        try {
            return eddate;
        } finally {
            c.close();
            db.close();
        }
    }

    // Add notification
    public void addNotification(Notification notification) {
        ContentValues values = new ContentValues();
        values.put(N_COLUMN_DAY, String.valueOf(notification.getNday()));
        values.put(N_COLUMN_MESSAGE, String.valueOf(notification.getNmessage()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NOTIFICATIONS, null, values);
        db.close();
    }

    // Get single notification from NOTIFICATION table
    public Notification getNotification(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_NOTIFICATIONS, new String[] {N_COLUMN_ID, N_COLUMN_DAY, N_COLUMN_MESSAGE},
                N_COLUMN_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(c != null)
            c.moveToFirst();

        Notification notification = new Notification(Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2));

        db.close();

        return notification;
    }

    // Get all notifications from NOTIFICATION table
    public List<Notification> getAllNotifications() {
        List<Notification> notificationList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NOTIFICATIONS + ";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c != null)
            c.moveToFirst();

        // Loop through all rows and each to list
        while(!c.isAfterLast()) {
            Notification notification = new Notification();
            notification.set_nid(Integer.parseInt(c.getString(0)));
            notification.setNday(c.getString(1));
            notification.setNmessage(c.getString(2));

            notificationList.add(notification);

            c.moveToNext();
        }

        return  notificationList;
    }

    // Get last notification date
    public String getLastNotifDay() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NOTIFICATIONS + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return null;
        c.moveToLast();
        String ndate = c.getString(c.getColumnIndex(N_COLUMN_DAY));
        try {
            return ndate;
        } finally {
            c.close();
            db.close();
        }
    }

    // Get notifications count
    public int getNotificationsCount() {
        String query = "SELECT * FROM " + TABLE_NOTIFICATIONS + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        try {
            return c.getCount();
        } finally {
            c.close();
            db.close();
        }
    }

    // Add Special Needs details to its table
    public void addSN(SpecialNeed specialNeed) {
        ContentValues values = new ContentValues();
        values.put(SN_COLUMN_HIV, String.valueOf(specialNeed.getHiv()));
        values.put(SN_COLUMN_HEPATITIS, String.valueOf(specialNeed.getHepatitis()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_SPECIAL_NEEDS, null, values);
        db.close();
    }

    // Get the HIV status
    public String getHivStatus() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SPECIAL_NEEDS + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return null;
        c.moveToLast();
        String hiv = c.getString(c.getColumnIndex(SN_COLUMN_HIV));
        try {
            return hiv;
        } finally {
            c.close();
            db.close();
        }
    }

    // Get the hepatitis status
    public String getHepatitisStatus() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SPECIAL_NEEDS + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return null;
        c.moveToLast();
        String hepatitis = c.getString(c.getColumnIndex(SN_COLUMN_HEPATITIS));
        try {
            return hepatitis;
        } finally {
            c.close();
            db.close();
        }
    }

    // Add new received number
    public void addReceived(int received) {
        ContentValues values = new ContentValues();
        values.put(R_COLUMN_NUMBER, received);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_RECEIVED, null, values);
        db.close();
    }

    // Get the received number
    public int getReceived() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_RECEIVED + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return 0;
        c.moveToLast();
        int received = Integer.parseInt(c.getString(c.getColumnIndex(R_COLUMN_NUMBER)));
        try {
            return received;
        } finally {
            c.close();
            db.close();
        }
    }

    // Delete the received number
    public void deleteReceived() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE * FROM " + TABLE_RECEIVED + " WHERE 1;";
        db.execSQL(query);
    }

    // Add new DOB to DOB table
    public void addDOB(DOB dob) {
        ContentValues values = new ContentValues();
        values.put(D_COLUMN_DAY, String.valueOf(dob.getDday()));
        values.put(D_COLUMN_R, dob.getDreceived());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DOB, null, values);
        db.close();
    }

    // Get the DOB
    public DOB getDOB() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DOB + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        if (c == null)
            return null;
        c.moveToLast();
        int _did = c.getInt(c.getColumnIndex(D_COLUMN_ID));
        String dday = c.getString(c.getColumnIndex(D_COLUMN_DAY));
        int dreceived = c.getInt(c.getColumnIndex(D_COLUMN_R));
        DOB dob = new DOB(_did, dday, dreceived);
        try {
            return dob;
        } finally {
            c.close();
            db.close();
        }
    }

    // Delete the DOB
    public void deleteDOB() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE * FROM " + TABLE_DOB + " WHERE 1;";
        db.execSQL(query);
    }

}
