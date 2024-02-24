package com.example.geraicafe

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory:
SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, dbName, factory, dbVersion){

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase?) {
// below is a sqlite query, where column names
// along with their data types is given
        val query = "CREATE TABLE" + tbName + "("+ ColId + "INTEGER PRIMARY KEY," +
                ColUname + "TEXT," + ColEmail + "TEXT UNIQUE, " +
                ColPass + "TEXT" + ")"

// we are calling sqlite
// method for executing our query
        db?.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
// this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + tbName)
        onCreate(db)
    }
    // This method is for adding data in our database
    fun addData(username : String, email : String, password : String)
            : Boolean{

// below we are creating
// a content values variable
        val values = ContentValues()
// we are inserting our values
// in the form of key-value pair
        values.put(ColUname, username)
        values.put(ColEmail, email)
        values.put(ColPass, password)
// here we are creating a
// writable variable of
// our database as we want to
// insert value in our database
        val db = this.writableDatabase
        val result = db.insert(tbName, null, values) != -1L
//closing database
        db.close()
        return result
    }
    // below method is to get
// all data from our database
    fun getData(username: String, password: String): Cursor? {
        val db = this.readableDatabase
        val selection = "$ColUname = ? AND $ColPass = ?"
        val selectionArgs = arrayOf(username, password)

        return db.query(tbName, null, selection, selectionArgs, null, null, null)

    }
    companion object{
        private val dbName = "PRAKPBM"
        private val dbVersion = 1
        val tbName = "user"
        val ColId = "id"
        val ColUname ="username"
        val ColEmail = "email"
        val ColPass = "password"
    }
}