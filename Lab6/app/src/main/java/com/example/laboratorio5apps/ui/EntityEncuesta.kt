package com.example.laboratorio5.ui

@Entity
data class Encuesta(
    @PrimaryKey var id: Int,
    @ColumnInfo(create_date = "Fecha de creacion") val date: String?,
)