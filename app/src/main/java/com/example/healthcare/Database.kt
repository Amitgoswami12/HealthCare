package com.example.healthcare

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.service.autofill.UserData
import androidx.annotation.RequiresApi
import androidx.core.content.contentValuesOf

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "my_database.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS user (
                username TEXT,
                email TEXT,
                password TEXT
            );
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades here
    }

    fun register(username: String, email: String, password: String) {
        val values = ContentValues()
        values.put("username", username)
        values.put("email", email)
        values.put("password", password)

        val db = writableDatabase
        db.insert("user", null, values)
        db.close()
    }



        @RequiresApi(Build.VERSION_CODES.P)
        @SuppressLint("Range")
        fun getUserData(): UserData? {
            val db = this.readableDatabase
            val query = "SELECT username, password FROM user WHERE your_condition_here"
            val cursor = db.rawQuery(query, null)

            return if (cursor.moveToFirst()) {
                val username = cursor.getString(cursor.getColumnIndex("username"))
                val password = cursor.getString(cursor.getColumnIndex("password"))
                UserData(username,password)
            } else {
                null // Return null if no data is found
            }
        }
    data class UserData(val username: String, val password: String)

}



