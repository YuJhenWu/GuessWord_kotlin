package com.example.test0422

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.test0422.game.*

class StartGameActivity : AppCompatActivity() , OnClickListener {

    var game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)

        //listening btn...
        val returnBtn = findViewById<ImageButton>(R.id.returnBtn)
        returnBtn.setOnClickListener(this)
        val hintBtn = findViewById<ImageButton>(R.id.hintBtn)
        hintBtn.setOnClickListener(this)
        val edText = findViewById<EditText>(R.id.edText)
        val getGuess = edText.text.toString().toCharArray()
        //game beginning...
        game.startGame(getGuess)


        // Print win/lose message!
        if(game.round > game.loop4-1)
            Toast.makeText(this, "You Lose!\r\nYou Lose!\r\nYou Lose!\r\nThe word is ${game.ans.answer}\r\n", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "You Win!\r\nThe word is ${game.ans.answer}\r\n", Toast.LENGTH_LONG).show()
        //clean trie
        game.trie.trieClear()
        //go to Level_2
        val i= Intent(this, ResultActivity::class.java)
        startActivity(i)
    }
    override fun onClick(v: View)
    {
        when (v.id){
            //return last windows
            R.id.returnBtn -> {
                val message = "這場遊戲會結束，確定要離開嗎?"
                val builder = AlertDialog.Builder(this)
                //builder.setTitle(message)
                builder.setMessage(message)
                builder.setPositiveButton("Yes") { _, _ ->
                    //finish game
                    game.finishGame()
                    //go to Level_0(return last window)
                    val i= Intent(this, WelcomeActivity::class.java)
                    startActivity(i)
                }
                builder.setNegativeButton("No") { _, _ -> } //do nothing
                builder.show()
            }
            // show hint
            R.id.hintBtn -> {
                val hint = "規則如下...."
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Hint")
                builder.setMessage(hint)
                builder.setPositiveButton("OK") { _, _ -> }//do nothing
                builder.show()
            }
        }
    }
}