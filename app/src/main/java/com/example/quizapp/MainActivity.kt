package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.quizapp.R.style.NoActionBar
import com.example.quizapp.R.style.quizApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setTheme(NoActionBar)
        setContentView(R.layout.activity_main)
     //   window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val btn=findViewById<Button>(R.id.btnclick)
        val btntxt=findViewById<AppCompatEditText>(R.id.txt)
        btn.setOnClickListener {
            if(btntxt.text.toString().isEmpty())
            {
                Toast.makeText(this,"enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,QuizQuestion::class.java)
                intent.putExtra("hello",btntxt.text.toString())

                startActivity(intent)
                finish()
            }
        }
    }


}