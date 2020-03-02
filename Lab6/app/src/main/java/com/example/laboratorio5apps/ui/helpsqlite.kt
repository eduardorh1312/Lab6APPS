package com.example.laboratorio5.ui

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConexionSQLiteHelper (context: Context): SQLiteOpenHelper(context,
    DATABASE_NAME, null,
    DATABASE_VERSION
){
    private val db: SQLiteDatabase
    private val values: ContentValues

    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="question_Table"
    }

    init {
        db=this.writableDatabase
        values= ContentValues()

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE " + question.question.tabla +" (" +
                question.question.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                question.question.Name + " TEXT NOT NULL," +
                question.question.type + " TEXT NOT NULL,"+
                question.question.default + " TEXT NOT NULL,");

        db!!.execSQL("CREATE TABLE " + question.poll.tabla +" (" +
                question.poll.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                question.poll.create_date + " TEXT NOT NULL,");

        db!!.execSQL("CREATE TABLE " + question.respuesta.tabla +" (" +
                question.respuesta.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                question.respuesta.poll_id + " TEXT NOT NULL," +
                question.respuesta.question_id + " TEXT NOT NULL,"+
                question.respuesta.answer_number + " TEXT NOT NULL,"+
                question.respuesta.answer_text + " TEXT NOT NULL,");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insert(question: List<question>){
        values.put(com.example.laboratorio5.Entidades.question.question.ID,question[0].toString())
        values.put(com.example.laboratorio5.Entidades.question.question.Name,question[0].toString())
        values.put(com.example.laboratorio5.Entidades.question.question.type,question[0].toString())
        values.put(com.example.laboratorio5.Entidades.question.question.default,question[0].toString())
        db.insert(com.example.laboratorio5.Entidades.question.question.tabla, null, values)
    }

    fun insert1(poll: List<poll>){
        values.put(question.poll.ID, poll[0].toString())
        values.put(question.poll.create_date, poll[0].toString())
        db.insert(question.question.tabla, null, values)
    }

    fun insert2(respuesta: List<question.respuesta>){
        values.put(question.respuesta.ID,respuesta[0].toString())
        values.put(question.respuesta.poll_id,respuesta[0].toString())
        values.put(question.respuesta.question_id,respuesta[0].toString())
        values.put(question.respuesta.answer_number,respuesta[0].toString())
        values.put(question.respuesta.answer_text,respuesta[0].toString())
        db.insert(question.respuesta.tabla, null, values)
    }
}