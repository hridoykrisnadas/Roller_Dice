package com.hridoykrisna.rollerdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage : ImageView;
    private var animate = true
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollerDiceBtn = findViewById<Button>(R.id.diceRollerBtnId);
        diceImage = findViewById(R.id.diceResultId);


        rollerDiceBtn.setOnClickListener { roller(animate) }
    }

    private fun roller(animation: Boolean) {
        Glide.with(this).asGif().load(R.drawable.dice).into(diceImage)
        handler.postDelayed({
            var result = (1..6).random()
            val image =
                when(result){
                    1 -> R.drawable.d_1
                    2 -> R.drawable.d_2
                    3 -> R.drawable.d_3
                    4 -> R.drawable.d_4
                    5 -> R.drawable.d_5
                    6 -> R.drawable.d_6
                    else -> R.drawable.default_0
                }
            Toast.makeText(this, "$result", Toast.LENGTH_SHORT).show()
            diceImage.setImageResource(image)
        }, 2500)

    }
}