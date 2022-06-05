package com.ako.completcontact.Notes

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHealper(context: Context):SQLiteOpenHelper(context,"Notesdb",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(
                "create table notes(" +
                        "_id integer primary key autoincrement,"
                        +"date text,"
                        +"title text,"
                        + "body text)"
            )
        }
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun savenote(date:String,title:String,body:String):Boolean{
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("date",date)
        values.put("title", title)
        values.put("body", body)
        var cursor=db.insert("notes", null, values)
        if(cursor.equals(-1))
            return false
        return true
    }
    fun update(date:String,_id:Int,title:String,body: String) {
        var db = writableDatabase
        var values = ContentValues()
        values.put("_id", _id)
        values.put("date",date)
        values.put("title", title)
        values.put("body", body)
        db.update("notes", values, "_id=" + _id, null)
    }
    @SuppressLint("Recycle")
    fun readnote(): Cursor{
        val db=readableDatabase
     //   val query="select * from notes"
        val cursor=db.query("notes", arrayOf("_id","title")
            ,null,null,null,null,null)
                return cursor
    }
    @SuppressLint("Recycle")
    fun readdata():ArrayList<db>{
        val db=readableDatabase
        val query = "select * from notes"
        val cursor=db.rawQuery(query,null)
        val note = ArrayList<db>()
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex("_id")).toInt()
                val date = cursor.getString(cursor.getColumnIndex("date"))
                val title = cursor.getString(cursor.getColumnIndex("title"))
                val body = cursor.getString(cursor.getColumnIndex("body"))
                note.add(db(id,date, title, body))
            } while (cursor.moveToNext())
        }
        return note
    }
    @SuppressLint("Recycle")
    fun readtitle(id:Int):String{
        val db=readableDatabase
        val query = "select * from notes where _id = $id"
        val cursor=db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            val title = cursor.getString(cursor.getColumnIndex("title"))
            return title
        }
        return "Error"
    }
    fun readbody(id:Int):String{
        val db=readableDatabase
        val query = "select * from notes where _id=$id"
        val cursor=db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            val body = cursor.getString(cursor.getColumnIndex("body"))
            return body
        }
        return "Error"
    }
    fun readdate(id:Int):String{
        val db=readableDatabase
        val query = "select * from notes where _id=$id"
        val cursor=db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            val date = cursor.getString(cursor.getColumnIndex("date"))
            return date
        }
        return "Error"
    }
    fun delete(id:Int){
        val db=writableDatabase
        val query="delets * from notes where _id=$id"
     //   val cursor=db.delete("notes",null,null)
        val cursor=db.delete("notes","_id=$id",null)
    }
    fun deleteselect(select:ArrayList<Int>){
        val db=writableDatabase
        for (i in select){
            val cursor=db.delete("notes","_id=$i",null)
        }
    }
}