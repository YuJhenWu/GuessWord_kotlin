package com.example.test0422

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View.OnClickListener
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() ,OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

    }
    override fun onClick(v: View) {
        var nameET = findViewById<EditText>(R.id.nameET)
        var pwdET = findViewById<EditText>(R.id.pwdET)
        var pwd2ET = findViewById<EditText>(R.id.pwd2ET)
        var submitBTN = findViewById<Button>(R.id.submitBTN)
        val mysql = Mysql()

        submitBTN.setOnClickListener(this)
        // connect database
        mysql.connectDB()

        var name = nameET.text.toString()
        var pwd01 = pwdET.text.toString()
        var pwd02 = pwd2ET.text.toString()
        var sex = ""
        if (name.equals("") || pwd01.equals("") || pwd02.equals("")) {
            Toast.makeText(this, "用户名或密码不能为空!！", Toast.LENGTH_LONG).show()
        } else {
            if(!mysql.searchTable(name, pwd01)!!){
                if (pwd01 == pwd02) {
                    mysql.insertTable(name, pwd01)
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    Toast.makeText(this, "注册成功！", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "密码不一致！", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "用户已存在！", Toast.LENGTH_LONG).show()
            }
        }
    }
}