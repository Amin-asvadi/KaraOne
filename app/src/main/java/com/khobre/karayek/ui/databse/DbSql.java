package com.khobre.karayek.ui.databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.khobre.karayek.ui.model.PaymentModel;
import com.khobre.karayek.ui.model.Price;
import com.khobre.karayek.ui.sahmList.SahamListModel;

import java.util.ArrayList;

public class DbSql extends SQLiteOpenHelper {


    public static final String DBNAME = "DBNAME";

    public static final String TABLENAME = "TABLENAME";

    public static final String ID = "ID";
    public static final String BOURSESYMBOL="BOURSESYMBOL";
    public static  final String FULLTITLE="FULLTITLE";
    public static final String COUNT="COUNT";
    public static  final String LASTPRICE="LASTPRICE";
    public static  final String STOCKVALUE="STOCKVALUE";
    public static final String SUMPRICE="SUMPRICE";

    public static final String TABLENAME_ONE = "TABLENAME_ONE";

    public static final String ID_ONE = "ID_ONE";
    public static final String BOURSESYMBOL_ONE="BOURSESYMBOL_ONE";
    public static  final String FULLTITLE_ONE="FULLTITLE_ONE";
    public static final String COUNT_ONE="COUNT_ONE";
    public static  final String LASTPRICE_ONE="LASTPRICE_ONE";
    public static  final String STOCKVALUE_ONE="STOCKVALUE_ONE";
    public static final String SUMPRICE_ONE="SUMPRICE_ONE";

    public static final String PAYMENT_TABLE="PAYMENT_TABLE";
    public static final String P_ID="P_ID";
    public static  final String PERSON_NAME="PERSON_NAME";
    public static  final String PERSON_PHONE="PERSON_PHONE";
    public static final String PERSON_ID="PERSON_ID";


    public static final String PRICE_TABLE = "PRICETABLE";
    public static final String PRICE_ID = "PID";
    public static final String PRICE_SAHM = "PRICE";




    private interface Patch {
        void apply(SQLiteDatabase db);
        void revert(SQLiteDatabase db);
    }


    private static final Patch[] PATCHES = new Patch[] {
            new Patch() {
                public void apply(SQLiteDatabase db) {
                    String SAHAMLIST ="CREATE TABLE " + TABLENAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + BOURSESYMBOL + " TEXT,"
                            + FULLTITLE + " TEXT,"
                            + COUNT + " TEXT,"
                            + LASTPRICE + " TEXT,"
                            + STOCKVALUE + " TEXT,"
                            + SUMPRICE + " TEXT);";




                    String SAHAMLIST_ONE ="CREATE TABLE " + TABLENAME_ONE + "(" + ID_ONE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + BOURSESYMBOL_ONE + " TEXT,"
                            + FULLTITLE_ONE + " TEXT,"
                            + COUNT_ONE + " TEXT,"
                            + LASTPRICE_ONE + " TEXT,"
                            + STOCKVALUE_ONE + " TEXT,"
                            + SUMPRICE_ONE + " TEXT);";


                    String PERSON_INFO ="CREATE TABLE " + PAYMENT_TABLE + "(" + P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + PERSON_NAME + " TEXT,"
                            + PERSON_PHONE + " TEXT,"
                            + PERSON_ID + " TEXT);";

                    String PRICE ="CREATE TABLE " + PRICE_TABLE + "(" + PRICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + PRICE_SAHM + " TEXT);";



                    db.execSQL(SAHAMLIST);
                    db.execSQL(SAHAMLIST_ONE);
                    db.execSQL(PERSON_INFO);
                    db.execSQL(PRICE);
                }
                public void revert(SQLiteDatabase db) {
                    db.execSQL("DROP TABLE " + TABLENAME + ";");
                    db.execSQL("DROP TABLE " + TABLENAME_ONE + ";");
                    db.execSQL("DROP TABLE " + PAYMENT_TABLE + ";");
                    db.execSQL("DROP TABLE " + PRICE_TABLE + ";");
                }
            }
            , new Patch() {
        public void apply(SQLiteDatabase db) {
            db.beginTransaction();

            String RENAME_SAHAM_LIST = "ALTER TABLE " + TABLENAME + " RENAME TO "+ TABLENAME + "_old;";
            String SAHAMLIST ="CREATE TABLE " + TABLENAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + BOURSESYMBOL + " TEXT,"
                    + FULLTITLE + " TEXT,"
                    + COUNT + " TEXT,"
                    + LASTPRICE + " TEXT,"
                    + STOCKVALUE + " TEXT,"
                    + SUMPRICE + " TEXT);";

            String COPY_TABLE_NAME = "INSERT INTO "+ TABLENAME +
                    "(" + ID + "," + BOURSESYMBOL + "," + FULLTITLE + "," + COUNT + "," + LASTPRICE + "," + STOCKVALUE + ","
                    + SUMPRICE + ")" +
                    " SELECT " + ID + "," + BOURSESYMBOL + "," + FULLTITLE + "," + COUNT + "," + LASTPRICE + "," + STOCKVALUE +"," + SUMPRICE +
                    " FROM " + TABLENAME + "_old;";

            db.execSQL(RENAME_SAHAM_LIST);
            db.execSQL(SAHAMLIST);
            db.execSQL(COPY_TABLE_NAME);

            db.setTransactionSuccessful();
            db.endTransaction();
        }
        public void revert(SQLiteDatabase db) {
            db.beginTransaction();
            String RENAME_SAHAM_LIST = "ALTER TABLE " + TABLENAME + " RENAME TO "+ TABLENAME + "_old;";
            String SAHAMLIST ="CREATE TABLE " + TABLENAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + BOURSESYMBOL + " TEXT,"
                    + FULLTITLE + " TEXT,"
                    + COUNT + " TEXT,"
                    + LASTPRICE + " TEXT,"
                    + STOCKVALUE + " TEXT,"
                    + SUMPRICE + " TEXT);";

            String COPY_TABLE_NAME = "INSERT INTO "+ TABLENAME +
                    "(" + ID + "," + BOURSESYMBOL + "," + FULLTITLE + "," + COUNT +  "," + LASTPRICE +  "," +  STOCKVALUE +  ","  + SUMPRICE + ")" +
                    " SELECT " + ID + "," + BOURSESYMBOL + "," + FULLTITLE + ","  + COUNT +"," + LASTPRICE +","+ STOCKVALUE +","+ SUMPRICE +
                    " FROM " + TABLENAME + "_old;";

            db.execSQL(RENAME_SAHAM_LIST);
            db.execSQL(SAHAMLIST);
            db.execSQL(COPY_TABLE_NAME);

            db.setTransactionSuccessful();
            db.endTransaction();
        }
    }
    };





    public DbSql(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        for (Patch patch : PATCHES) {
            patch.apply(db);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = oldVersion; i < newVersion; i++) {
            PATCHES[i].apply(db);
        }

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = oldVersion; i > newVersion; i--) {
            PATCHES[i].revert(db);
        }
    }

    public void Delete(int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLENAME, "id=" + id, null);
    }
    public void Update_price(Price data, int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRICE_SAHM, data.getPrice());
        database.update(PRICE_TABLE,values,"PID=" + id,null);
        database.close();
    }
    public void Update_One(SahamListModel data, int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOURSESYMBOL_ONE, data.getGroup());
        values.put(FULLTITLE_ONE, data.getTitle());
        values.put(COUNT_ONE, data.getCount());
        values.put(LASTPRICE_ONE, data.getLivePrice());
        values.put(STOCKVALUE_ONE, data.getStocksValue());
        values.put(SUMPRICE_ONE, data.getSum_price());


        database.update(TABLENAME_ONE,values,"id_one=" + id,null);
        database.close();
    }
    public void Update(SahamListModel data, int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOURSESYMBOL, data.getGroup());
        values.put(FULLTITLE, data.getTitle());
        values.put(COUNT, data.getCount());
        values.put(LASTPRICE, data.getLivePrice());
        values.put(STOCKVALUE, data.getStocksValue());
        values.put(SUMPRICE, data.getSum_price());


        database.update(TABLENAME,values,"id=" + id,null);
        database.close();
    }

    public long InsertDataSahamList(SahamListModel data)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOURSESYMBOL, data.getGroup());
        values.put(FULLTITLE, data.getTitle());
        values.put(COUNT, data.getCount());
        values.put(LASTPRICE, data.getLivePrice());
        values.put(STOCKVALUE, data.getStocksValue());
        values.put(SUMPRICE, data.getSum_price());
        long id = database.insert(TABLENAME, null, values);
        database.close();
        return id;
    }
    public long InsertDataSahamList_ONE(SahamListModel data)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOURSESYMBOL_ONE, data.getGroup());
        values.put(FULLTITLE_ONE, data.getTitle());
        values.put(COUNT_ONE, data.getCount());
        values.put(LASTPRICE_ONE, data.getLivePrice());
        values.put(STOCKVALUE_ONE, data.getStocksValue());
        values.put(SUMPRICE_ONE, data.getSum_price());
        long id = database.insert(TABLENAME_ONE, null, values);
        database.close();
        return id;
    }
    public long InsertPersonPayment(PaymentModel data)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PERSON_NAME, data.getName());
        values.put(PERSON_PHONE, data.getPhone());
        values.put(PERSON_ID, data.getPersonid());

        long id = database.insert(PAYMENT_TABLE, null, values);
        database.close();
        return id;
    }
    public long InsertPrice(Price data)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRICE_SAHM, data.getPrice());

        long id = database.insert(PRICE_TABLE, null, values);
        database.close();
        return id;
    }
    public ArrayList<Price> ShowPrice()
    {
        ArrayList<Price> data = new ArrayList<>();
        String query = "SELECT * FROM " + PRICE_TABLE;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Price modelItem = new Price();
                modelItem.setId(Integer.parseInt(cursor.getString(0)));
                modelItem.setPrice(cursor.getString(1));
                data.add(modelItem);
            }
            while (cursor.moveToNext());
        }

        return data;
    }

    public ArrayList<PaymentModel> ShowPersonPayment()
    {
        ArrayList<PaymentModel> data = new ArrayList<>();
        String query = "SELECT * FROM " + PAYMENT_TABLE;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                PaymentModel modelItem = new PaymentModel();
                modelItem.setId(Integer.parseInt(cursor.getString(0)));
                modelItem.setName(cursor.getString(1));
                modelItem.setPhone(cursor.getString(2));
                modelItem.setPersonid(cursor.getString(3));
                data.add(modelItem);
            }
            while (cursor.moveToNext());
        }

        return data;
    }

    public ArrayList<SahamListModel> ShowData()
    {
        ArrayList<SahamListModel> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLENAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                SahamListModel modelItem = new SahamListModel();
                modelItem.setId(Integer.parseInt(cursor.getString(0)));
                modelItem.setGroup(cursor.getString(1));
                modelItem.setTitle(cursor.getString(2));
                modelItem.setCount(cursor.getString(3));
                modelItem.setLivePrice(cursor.getString(4));
                modelItem.setStocksValue(cursor.getString(5));
                modelItem.setSum_price(cursor.getString(6));

                data.add(modelItem);
            }
            while (cursor.moveToNext());
        }

        return data;
    }
    public ArrayList<SahamListModel> ShowDataOne()
    {
        ArrayList<SahamListModel> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLENAME_ONE;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                SahamListModel modelItem = new SahamListModel();
                modelItem.setId(Integer.parseInt(cursor.getString(0)));
                modelItem.setGroup(cursor.getString(1));
                modelItem.setTitle(cursor.getString(2));
                modelItem.setCount(cursor.getString(3));
                modelItem.setLivePrice(cursor.getString(4));
                modelItem.setStocksValue(cursor.getString(5));
                modelItem.setSum_price(cursor.getString(6));

                data.add(modelItem);
            }
            while (cursor.moveToNext());
        }

        return data;
    }
    public ArrayList<SahamListModel> ShowSum()
    {
        ArrayList<SahamListModel> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLENAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                SahamListModel modelItem = new SahamListModel();
                modelItem.setStocksValue(cursor.getString(5));
                // modelItem.setSum_price(cursor.getString(6));

                data.add(modelItem);
            }
            while (cursor.moveToNext());
        }

        return data;
    }


}
