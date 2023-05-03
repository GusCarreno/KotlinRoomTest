package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var messageDao: MessageDao
    private lateinit var sentMessageDao: SentMessageDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toEditText = findViewById<EditText>(R.id.toEditText)
        val messageEditText = findViewById<EditText>(R.id.messageEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)

        val db = AppDatabase.getDatabase(this)
        messageDao = db.messageDao()
        sentMessageDao = db.sentMessageDao()

        sendButton.setOnClickListener {
            val toField = toEditText.text.toString()
            val messageField = messageEditText.text.toString()

            if (toField.isNotEmpty() && messageField.isNotEmpty()) {
                val message = Message(
                    createdAt = System.currentTimeMillis(),
                    toField = toField,
                    messageField = messageField
                )
                GlobalScope.launch {
                    messageDao.insert(message)
                }
            } else {
                // Show error message
            }
        }
    }
}