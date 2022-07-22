package com.example.dbdemotask1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {

    companion object{
        private final var DATABASE_NAME = "DB"
        private final var DATABASE_VERSION = 1

        private const val TABLE_NAME = "TransactionDetail"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_MOBILE = "mobile"
        private const val KEY_AMOUNT = "amount"
        private const val KEY_DATE = "date"
        private const val KEY_TYPE = "type"
    }

    override fun onCreate(db: SQLiteDatabase?) {

//        var CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + KEY_NAME + " TEXT, "
//                + KEY_MOBILE + " TEXT, "
//                + KEY_AMOUNT + " TEXT, "
//                + KEY_DATE + " TEXT, "
//                + KEY_TYPE + " TEXT "
//                + " )")
//        db?.execSQL(CREATE_TABLE)
    }

    fun deleteTable() {
        var db: SQLiteDatabase? = null
        var DELETE_TABLE = ("DROP TABLE " + TABLE_NAME)
        db?.execSQL(DELETE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(transactionModel: TransactionModel): Long{
        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(KEY_NAME, transactionModel.transaction_name)
        cv.put(KEY_MOBILE, transactionModel.transaction_mobile)
        cv.put(KEY_AMOUNT, transactionModel.transaction_amount)
        cv.put(KEY_DATE, transactionModel.transaction_date)
        cv.put(KEY_TYPE, transactionModel.transaction_type)
//        Log.d("mydata", "ins q: "+ studentModels.student_name)

        var insertData = db.insert(TABLE_NAME, null, cv)

        return insertData
    }

    @SuppressLint("Range")
    fun getAllData(): MutableList<TransactionModel>{
        var transactionList: MutableList<TransactionModel> = ArrayList()
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

        var transaction_id:Int
        var transaction_name:String
        var transaction_mobile:String
        var transaction_amount:String
        var transaction_date:String
        var transaction_type:String

        if(cursor.count > 0){
            if(cursor.moveToFirst()){
                do{
                    transaction_id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                    transaction_name = cursor.getString(cursor.getColumnIndex("name"))
                    transaction_mobile = cursor.getString(cursor.getColumnIndex(KEY_MOBILE))
                    transaction_amount = cursor.getString(cursor.getColumnIndex(KEY_AMOUNT))
                    transaction_date = cursor.getString(cursor.getColumnIndex(KEY_DATE))
                    transaction_type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
                    var transactiondata = TransactionModel(
                        transaction_id = transaction_id,
                        transaction_name = transaction_name,
                        transaction_mobile = transaction_mobile,
                        transaction_amount = transaction_amount,
                        transaction_date = transaction_date,
                        transaction_type = transaction_type,
                    )
                    transactionList.add(transactiondata)

                }while (cursor.moveToNext())
            }
        }
        return transactionList
    }
}