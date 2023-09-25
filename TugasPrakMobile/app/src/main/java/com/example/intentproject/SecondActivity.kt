package com.example.intentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.example.intentproject.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val mReply = findViewById<EditText>(R.id.editText_second)
        val btnKirimSecond = findViewById<Button>(R.id.button_second)

        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message

        btnKirimSecond.setOnClickListener(View.OnClickListener {
            val reply = mReply?.text.toString()
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply)
            setResult(RESULT_OK, replyIntent)
            finish()
        })
    }
}
