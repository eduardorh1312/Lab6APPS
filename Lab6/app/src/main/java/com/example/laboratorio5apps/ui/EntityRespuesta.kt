package com.example.laboratorio5.ui

@Entity
data class Respuesta(
    @PrimaryKey var id: Int,
    @ColumnInfo(poll_id = "ForeignKey1"foreignKeys = [ ForeignKey(entity = Respuesta::class, parentColumns = ["someCol"], childColumns = ["someOtherCol"], onDelete = CASCADE)])) val date: String?,
    )