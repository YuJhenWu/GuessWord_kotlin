package com.example.test0422

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onClick(v: View) {
        var usernameET = findViewById<EditText>(R.id.usernameET)
        var passwordET = findViewById<EditText>(R.id.passwordET)
        var loginBTN = findViewById<Button>(R.id.loginBTN)
        var regBTN = findViewById<Button>(R.id.regBTN)
        val mysql = Mysql()

        loginBTN.setOnClickListener(this)
        regBTN.setOnClickListener(this)
        // connect database
        mysql.connectDB()
        when (v.id) {
            loginBTN.id -> {
                val username = usernameET.text.toString()
                val password = passwordET.text.toString()

                if(mysql.searchTable(username, password) == true){
                    val i= Intent(this, WelcomeActivity::class.java)
                    i.putExtra("player", username)
                    startActivity(i)
                }
                else{
                    Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_LONG).show()
                }

            }
            regBTN.id -> {
                val i= Intent(this, RegisterActivity::class.java)
                startActivity(i)
                Toast.makeText(this,"前往注册！",Toast.LENGTH_SHORT).show()
            }
        }
    }
}