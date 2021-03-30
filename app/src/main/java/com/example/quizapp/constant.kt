package com.example.quizapp

object constant {
    const val username:String="name"
    const val score:String="score"
    const val total:String="total"
    fun getquestion():ArrayList<question>{
        val questionList=ArrayList<question>()
        val q1=question(1,
                "What country this flag belong to",
                R.drawable.i1,
                "Albania",
                "China",
                "Myanmar",
                "Vietnam",
                4
        )
        questionList.add(q1)
        val q2=question(2,
                "What country this flag belong to",
                R.drawable.i2,
                "Belgium",
                "Germany",
                "India",
                "Vietnam",
                1
        )
        questionList.add(q2)
        val q3=question(3,
                "What country this flag belong to",
                R.drawable.i3,
                "Euthopia",
                "Lebanon",
                "Myanmar",
                "Uganda",
                2
        )
        questionList.add(q3)
        val q4=question(4,
                "What country this flag belong to",
                R.drawable.i4,
                "cuba",
                "russia",
                "brazil",
                "japan",
                3
        )
        questionList.add(q4)
        val q5=question(5,
                "What country this flag belong to",
                R.drawable.i5,
                "Pakistan",
                "Algeria",
                "Myanmar",
                "Iran",
                2
        )
        questionList.add(q5)
       return questionList
    }
}