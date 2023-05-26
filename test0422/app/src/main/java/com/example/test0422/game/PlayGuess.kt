package com.example.test0422.game


class PlayerGuess{

    private var guess = CharArray(1000){'\u0000'}
    private var mask = IntArray(len) { 0 }

    /* initialize Mask. */
    private fun initMask()
    {
        mask = IntArray(len) { 0 }
    }
    /* initialize Guess. */
    private fun initGuess()
    {
        guess = CharArray(1000){'\u0000'}
    }
    fun getMask() :IntArray
    {
        return mask
    }
    private fun setGuess(g :CharArray)
    {
        for (i in 0 until g.size)
            guess[i] = g[i]
    }

    /* Return TRUE if this word has at least one non-lowercase. */
    private fun nonLowercase(): Boolean
    {
        var low = true
        for (i in 0 until len) {
            //not in [a-z]
            if (guess[i] > 'z' || guess[i] < 'a') low = false
        }
        return !low
    }

    /* Return TRUE if it is a reasonable guess. */
    fun getAndReasonableGuess(t: Trie, gG :CharArray) :Boolean
    {
        //get player's guess
        initGuess()
        setGuess(gG)

        //Non-four letters words
        if(guess.size != len) {
            //Toast.makeText(, "Oh!No! Not a four letters word.請再次輸入4個【小寫】英文字母", Toast.LENGTH_LONG).show()
            return false
        }
        //Non lowercase words
        else if(nonLowercase()) {
           // Toast.makeText(, "Oh!No! Not lowercase letter.請再次輸入4個【小寫】英文字母", Toast.LENGTH_LONG).show()
            return false
        }
        //Not in word list
        else if(!t.trieSearch(guess.toString())) {
            //Toast.makeText(, "Oh!No! Not in word list.請再次輸入4個【小寫】英文字母", Toast.LENGTH_LONG).show()
            return false
        }else
            return true
    }

    /* Mark true all mask positions corresponding to guess. */
    fun maskEachGuess(ansArr: CharArray)
    {
        initMask()
        /*
        0 : incorrect answer
        □(1) : correct letter, but incorrect position
        ■(2) : correct letter, correct position
        */
        for (i  in 0 until len) {
            for (j in 0 until len) {
                if (ansArr[i] == guess[j]) {
                    if (i == j || mask[j] == 2) mask[j] = 2
                    else mask[j] = 1
                }
            }
        }
    }

    /* Print word with ■/□ for non-guessed letters. */
    fun printResultGraphic(alt: AlphabetTable) {
       // Toast.makeText( "Oh!No! You guessed wrong.請再次輸入4個【小寫】英文字母", Toast.LENGTH_LONG).show()
        for (i in 0 until len) {
            if (mask[i] >0 ) {
                if (mask[i] > 1) {
                    println("■")
                    alt.maskLetter(guess[i])
                } else println("□")
            } else {
                println("?")
                alt.deletedLetter(guess[i])
            }
        }
        //alt.printAlphabetTable()
    }
}