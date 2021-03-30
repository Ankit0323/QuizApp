package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class champions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champions)
        //val name=getIntent().getStringExtra("hello")
        val name=intent.getStringExtra("hello")
       val score= intent.getIntExtra(constant.score,0)
        val total=intent.getIntExtra(constant.total,0)

        findViewById<TextView>(R.id.final1).text=name
        findViewById<TextView>(R.id.final2).text= " your score is $score out of   $total"


    }
    fun setClick(view: View){
        startActivity(Intent(this,MainActivity::class.java))
        finish()

    }
}