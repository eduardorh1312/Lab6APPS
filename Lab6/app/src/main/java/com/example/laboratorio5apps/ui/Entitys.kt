package com.example.laboratorio5.ui

@Entity(tableName = "question_table")
data class Pregunta(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Pregunta") val pregunta1: String?,
    @ColumnInfo(type = "Tipo de pregunta (texto, número, rating)") val tipo: String?,
    @ColumnInfo(default = "boolean") val deft: Boolean?
)
