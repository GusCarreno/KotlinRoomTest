package com.example.kotlintest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: Message)
}

@Dao
interface SentMessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sentMessage: SentMessage)
}