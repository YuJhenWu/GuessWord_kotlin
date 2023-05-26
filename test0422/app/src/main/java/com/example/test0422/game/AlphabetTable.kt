package com.example.test0422.game

//const
const val ALPHABET_SIZE = 26

class AlphabetTable{

    private val alpha = CharArray(ALPHABET_SIZE)

    /* initialize an AlphabetTable . */
    fun initAlphabetTable()
    {
        for (i in 0 until ALPHABET_SIZE)
        {
            alpha[i] = ('a' + i)
        }
    }
    /* Deleted letter in the Alphabet Table. */
    fun deletedLetter(g: Char)
    {
        alpha[g.code - 'a'.code] = '/'
    }
    /* Mask letter in the Alphabet Table. */
    fun maskLetter(g: Char)
    {
        alpha[g.code - 'a'.code] = '0'
    }
}