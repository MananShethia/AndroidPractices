package com.example.dbdemo1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(var context: Context?): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private final var DATABASE_NAME = "DB"
        private final var DATABASE_VERSION = 1

        private const val TABLE_NAME = "student"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
        private const val KEY_PASSWORD = "password"
        private const val KEY_MOBILE = "mobile"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_EMAIL + " TEXT, "
                + KEY_PASSWORD + " TEXT, "
                + KEY_MOBILE + " TEXT"
                + " )")
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("YES")
    }

    fun insertData(studentModels: StudentModel): Long{
        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(KEY_NAME, studentModels.student_name)
        cv.put(KEY_EMAIL, studentModels.student_email)
        cv.put(KEY_PASSWORD, studentModels.student_password)
        cv.put(KEY_MOBILE, studentModels.student_mobile)
//        Log.d("mydata", "ins q: "+ studentModels.student_name)

        var insertData = db.insert(TABLE_NAME, null, cv)

        return insertData
    }

    @SuppressLint("Range")
    fun getAllData(): MutableList<StudentModel>{
        var studentList: MutableList<StudentModel> = ArrayList()
        var sql_query = "SELECT * FROM $TABLE_NAME"

        // FOR FETCH DATA
        var cursor: Cursor?
        var db = this.readableDatabase

        try{
            cursor = db.rawQuery(sql_query, null)
        }catch(Exception: SQLiteException) {
            db.execSQL(sql_query)
            return ArrayList()
        }

        var student_id:Int
        var student_name:String
        var student_email:String
        var student_password:String
        var student_mobile:String

        if(cursor.count > 0){
            Log.d("mydata", "->"+cursor.count)
            if(cursor.moveToFirst()){
                do{
                    Log.d("mydata", "check")
                    student_id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                    student_name = cursor.getString(cursor.getColumnIndex("name"))
                    student_email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL))
                    student_password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD))
                    student_mobile = cursor.getString(cursor.getColumnIndex(KEY_MOBILE))
                    Log.d("mydata", "name: "+student_name)
                    var studentdata = StudentModel(
                        student_id = student_id,
                        student_name = student_name,
                        student_email = student_email,
                        student_password = student_password,
                        student_mobile = student_mobile
                    )
                    studentList.add(studentdata)

                }while (cursor.moveToNext())
            }
        }
        return studentList
    }

    fun updateData(studentModel: StudentModel): Int{
        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(KEY_NAME, studentModel.student_name)
        cv.put(KEY_EMAIL, studentModel.student_email)
        cv.put(KEY_PASSWORD, studentModel.student_password)
        cv.put(KEY_MOBILE, studentModel.student_mobile)

        var id = db.update(TABLE_NAME, cv, KEY_ID + "=" + studentModel.student_id, null)
        db.close()

        return id
    }

    fun deleteData(studentModel: StudentModel): Int {
        var db = this.writableDatabase
        var delete_query = db.delete(TABLE_NAME, KEY_ID + " = " + studentModel.student_id, null)

        db.close()

        return delete_query
    }



}