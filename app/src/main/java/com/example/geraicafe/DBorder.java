package com.example.geraicafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.geraicafe.Data;

import java.util.ArrayList;

public class DBorder extends SQLiteOpenHelper {
    private static final String dbName = "PRAKPBM";
    private static final int dbVersion = 1;
    private static final String tblName = "cartOrder";
    private static final String keyId = "id";
    private static final String keyProductName = "product_name";
    private static final String keyImagesProduct = "images";
    private static final String key_proid = "id_produk";
    private static final String keyPrice = "price";
    private static final String[] project = {
            keyId,
            key_proid,
            keyProductName,
            keyImagesProduct,
            keyProductName
    };
    SQLiteDatabase db;
    public DBorder(Context context){
        super(context, dbName, null, dbVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+tblName+"("+ keyId+" INTEGER PRIMARY KEY AUTOINCREMENT,"+key_proid+" VARCHAR, "+tblName+" TEXT, "+keyProductName+" TEXT, "+keyImagesProduct+" TEXT, "+ keyPrice+" TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+dbName);
        onCreate(sqLiteDatabase);
    }

    public long addOrder(int id, String productName, int imagesProduct, String priceProduct){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_proid, id);
        values.put(keyProductName, productName);
        values.put(keyImagesProduct, imagesProduct);
        values.put(keyPrice, priceProduct);
        return db.insert(tblName, null, values);
    }

    public void getReadProduct(ArrayList<Data> data) {
        db = this.getReadableDatabase();
        Cursor cursor = db.query(tblName, new String[]{
                keyId, key_proid, keyImagesProduct, keyPrice, keyProductName
        }, null, null, null, null, null);
        int eid = cursor.getColumnIndex(keyId);
        int ename = cursor.getColumnIndex(keyProductName);
        int eimages = cursor.getColumnIndex(keyImagesProduct);
        int eprice = cursor.getColumnIndex(keyPrice);
        while (cursor.moveToNext()) {
            System.out.println("\n");
            data.add(new Data(Integer.parseInt(cursor.getString(eid)), cursor.getString(ename), cursor.getString(eprice), Integer.parseInt(cursor.getString(eimages))));
            System.out.println("Id Produk: " + cursor.getString(eid));
            System.out.println("Name Produk: " + cursor.getString(ename));
            System.out.println("Images Produk: " + cursor.getString(eimages));
            System.out.println("Price: " + cursor.getString(eprice));
            System.out.println("\n");
        }
        cursor.close();
        db.close();
    }

    public void setDelete(int id){
        db = this.getWritableDatabase();
        db.delete(tblName, keyId + " ="+id, null);
    }
    public String totalHarga() {
        db = this.getReadableDatabase();
        Cursor cursor = db.query(tblName, new String[]{
                keyId, key_proid, keyImagesProduct, keyPrice, keyProductName
        }, null, null, null, null, null);
        int harga_ = cursor.getColumnIndex(keyPrice);
        int harga = 0;
        while (cursor.moveToNext()) {
            harga += cursor.getInt(harga_);
        }
        cursor.close();
        db.close();
        return String.valueOf(harga);
    }
    public String totalPesanan() {
        db = this.getReadableDatabase();
        Cursor cursor = db.query(tblName, new String[]{
                keyId, key_proid, keyImagesProduct, keyPrice, keyProductName
        }, null, null, null, null, null);
        int harga_ = cursor.getColumnIndex(keyId);
        int harga = 0;
        int i = 0;
        while (cursor.moveToNext()) {
            harga = i++;
        }
        cursor.close();
        db.close();
        return String.valueOf(harga);
    }

}
