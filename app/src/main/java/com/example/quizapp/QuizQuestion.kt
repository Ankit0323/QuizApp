package com.example.quizapp

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity() {
    private var mindex: Int=1
    private var count:Int=0

    private var mlist :ArrayList<question>? =null
    private  var mselectedoption:Int=0;
    private lateinit var one :TextView
    private lateinit var two :TextView
    private lateinit var three :TextView
    private lateinit var four :TextView
    private lateinit var button :Button
  private  var username:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        username=intent.getStringExtra("hello")
        //username=getIntent().getStringExtra("hello")
        //username=intent.getStringExtra(constant.username)
        mlist=constant.getquestion()

        one  =findViewById<TextView>(R.id.one1)
       two =findViewById<TextView>(R.id.two2)
         three=findViewById<TextView>(R.id.three3)
         four=findViewById<TextView>(R.id.four4)
        button=findViewById(R.id.button)
        myquestion()


          //one.setOnClickListener(this)
        //two.setOnClickListener(this)
        //three.setOnClickListener(this)
        //four.setOnClickListener(this)
        one.setOnClickListener(object:View.OnClickListener {
            override fun onClick(view: View?) {
                selected(one, 1)
            }
        }
        )

                two.setOnClickListener(object:View.OnClickListener {
            override fun onClick(view: View?) {
                selected(two, 2)
            }
        }
                )
                three.setOnClickListener(object:View.OnClickListener {
            override fun onClick(view: View?) {
                selected(three, 3)
            }
        }
                )
                four.setOnClickListener(object:View.OnClickListener {
            override fun onClick(view: View?) {
                selected(four, 4)
            }
        }
                )
        button.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                if(mselectedoption==0)
                {
                    mindex++

                    if(mindex<=mlist!!.size){
                        myquestion()
                    }
                    else{
                        val intent= Intent(this@QuizQuestion,champions::class.java)
                        intent.putExtra("hello",username)
                        intent.putExtra(constant.score,count)
                        intent.putExtra(constant.total,mlist!!.size)
                        startActivity(intent)
                    }



                }
                else
                {   val question=mlist!![mindex-1]
                    if(question.ans!=mselectedoption)
                    {
                        answer(mselectedoption,R.drawable.wrong_resourse)
                    }else
                    {
                        count++
                    }
                    answer(question.ans,R.drawable.correct_resourse)
                    if(mindex==mlist!!.size){
                      button.text="Finish"
                   }
                   else {
                        button.text = "go to next question"

                    }
                    mselectedoption = 0
                }

            }
        }

        )







    }
    

    private fun myquestion(){
        //default()


              button.text = "Submit"
        default()

        val first=mlist!![mindex-1]
        val  progress=findViewById<ProgressBar>(R.id.progressbar)
        progress.progress=mindex

        findViewById<TextView>(R.id.progresstext).text="${mindex} / ${progress.max}"
        findViewById<TextView>(R.id.text2).text=first!!.problem
        findViewById<ImageView>(R.id.image).setImageResource(first.image)

       one.text =first!!.o1
        two.text=first!!.o2
        three.text=first!!.o3
       four.text=first!!.o4
    }
    private fun default(){
        var list=ArrayList<TextView>()
        list.add(0,one)
        list.add(1,two)
        list.add(2,three)
        list.add(3,four)
        for(x in list)
        {
            x.setTextColor(Color.parseColor("#FFFFFFFF"))
            x.typeface= Typeface.DEFAULT
            x.background=ContextCompat.getDrawable(this,R.drawable.default_first_resourse)
        }
    }

   private fun selected(v:TextView,index:Int){
        default()
        mselectedoption=index

        v.setTextColor(Color.parseColor("#FFFFFFFF"))
        v.setTypeface(v.typeface,Typeface.BOLD)
        v.background=ContextCompat.getDrawable(this,R.drawable.selected_resource)


    }
    private fun answer(value :Int,draw:Int){
        when(value){
            1->{
                one.background=ContextCompat.getDrawable(
                        this,draw
                )
            }
            2->{
                two.background=ContextCompat.getDrawable(
                        this,draw
                )
            }
            3->{
                three.background=ContextCompat.getDrawable(
                        this,draw
                )
            }
            4->{
                four.background=ContextCompat.getDrawable(
                        this,draw
                )
            }
        }


    }
  //this is another method for OnClick::: here first we have to extend View.OnClickListener
     /*override fun onClick(v: View?) {
       when(v?.id){
           R.id.one1->{
               selected(one,
                       1)

           }
           R.id.two2->{
               selected(two,2)

           }
           R.id.three3->{
               selected(three,3)

           }
           R.id.four4->{
               selected(four,4)

           }
       }
    }*/
}