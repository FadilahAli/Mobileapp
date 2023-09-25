package com.example.intentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    val EXTRA_MESSAGE = "com.example.intentproject.extra.MESSAGE"
    val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mMessageEditText = findViewById<EditText>(R.id.editText_main)
        val btnKirim = findViewById<Button>(R.id.button_main)

        btnKirim?.setOnClickListener(View.OnClickListener {
            Log.d(LOG_TAG, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            val message = mMessageEditText?.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult(intent, TEXT_REQUEST)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val mReplyHeadTextView = findViewById<TextView>(R.id.text_header_reply)
                val mReplyTextView = findViewById<TextView>(R.id.text_message_reply)
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        const val EXTRA_MESSAGE = "com.example.intentproject.extra.MESSAGE"
    }
}
