package com.example.test0422.game

class Answer {
    var answer = CharArray(len)

    /* Set an answer in Wordlist[0,426]. */
    fun setAnswer(wArr: Array<CharArray>)
    {
        // Create a random integer in [0,426]
        val min = 0
        val max = 426
        val seed = (Math.random() * (max - min + 1)).toInt() + min

        for (i  in 0 until len) {
            answer[i] = wArr[seed][i]
            //val ch = String.format("%c\n",answer[i])
            //println(ch)
            println(answer)
        }
    }
}