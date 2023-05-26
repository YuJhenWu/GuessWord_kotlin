package com.example.test0422

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() , OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var showHello = findViewById<TextView >(R.id.showHello)
        val player = intent.getStringExtra("player")
        showHello.text = "欢迎你！$player"


    }
    override fun onClick(v: View) {
        var startBTN = findViewById<Button>(R.id.startBTN)
        var colorChBTN = findViewById<Button>(R.id.colorChBTN)

        startBTN.setOnClickListener(this)
        colorChBTN.setOnClickListener(this)

        when (v.id) {
            startBTN.id -> {
                val i= Intent(this, StartGameActivity::class.java)
                startActivity(i)
                Toast.makeText(this, "Let's go!!!\uD83D\uDE00", Toast.LENGTH_LONG).show()
            }
            colorChBTN.id -> {
                Toast.makeText(this,"更改配色！", Toast.LENGTH_SHORT).show()
            }

        }
    }
}