package com.example.healthcare

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class MyDatabaseHelper(context: Context, healthcare: String, nothing: Nothing?, i: Int) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "my_database.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS user (
                username TEXT ,
                email TEXT,
                password TEXT
            );
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun register(username: String, email: String, password: String) {
        val username = "your_username"
        val email = "your_email@example.com"
        val password = "your_password"

        val values = contentValuesOf()
        values.put(
            "username", username
        ) // Replace "username_column" with the actual column name in your table
        values.put(
            "email", email
        )       // Replace "email_column" with the actual column name in your table
        values.put(
            "password", password
        ) // Replace "password_column" with the actual column name in your table


        val db = this.writableDatabase
        db.insert("user", null, values)
        db.close()

    }

    fun login(username: String, password: String): Int {
        var result = 0

        val str = Array(2) { "" }

        str[0] = username
        str[1] = password

        val db = readableDatabase
        val query = "SELECT * FROM user WHERE username = ? AND password = ?"
        val cursor = db.rawQuery(query, arrayOf(username, password))

        if (cursor.moveToFirst()) {


            result = 1
        } else {
            // No matching user found
            result = 0
        }

        cursor.close()
        return result
    }

}
