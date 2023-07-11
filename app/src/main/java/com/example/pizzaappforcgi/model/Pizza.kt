package com.example.pizzaappforcgi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Pizza(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    @ColumnInfo val title: String,
    @ColumnInfo val description: String
)
