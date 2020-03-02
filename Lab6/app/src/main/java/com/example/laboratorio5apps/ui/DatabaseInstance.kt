package com.example.laboratorio5.ui

import android.context.Context
import androidx.room.*

//CREACION DE BASE DE DATOS DONDE UNO MIS ENTIDADES Y MIS DAOS  Y ME DEVUELVEN LA INSTANCIA EN LA BASE DE DATOS
//Se instancia desde el viewModel

@Database(entities = [poll_id::class], version = 1, exportSchema = false)
abstract class QuestDB : RoomDataBase(){

    abstract val QuestDao: questDao

    companion object{//espacio para variables o metodos estaticos

        private var INSTANCE: QuestDB? = null

        fun getInstance(context: Context): QuestDB{

            synchronized(lock: this){
                var instance = INSTANCE

                if(instance == null){//patron singleton
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuestDB::class.java,
                        "questdb"
                    )
                        .fallbackToDestructiveMigration()
                        .build
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}