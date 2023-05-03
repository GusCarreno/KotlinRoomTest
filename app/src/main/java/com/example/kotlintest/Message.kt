package com.example.kotlintest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "created_at") val createdAt: Long,
    @ColumnInfo(name = "to_field") val toField: String,
    @ColumnInfo(name = "message_field") val messageField: String
)

@Entity(
    tableName = "sent_messages",
    foreignKeys = [ForeignKey(
        entity = Message::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("message_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class SentMessage(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "message_id") val messageId: Long,
    @ColumnInfo(name = "sent_at") val sentAt: Long,
    @ColumnInfo(name = "confirmation_code") val confirmationCode: String
)