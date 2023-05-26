package com.example.test0422.game



class Game {
    var trie = Trie()
    private var wl = Wordlist()
    private var wordlist = wl.createWordList(trie)
    private val alph = AlphabetTable()
    val ans = Answer()
    private val pg = PlayerGuess()

    var loop4 = 4
    var round = 0
    private var gameover = false

    private fun initGame()
    {
        alph.initAlphabetTable()
        ans.setAnswer(wordlist)
        loop4 = 4
        round = 0
        gameover = false
    }
    fun startGame(gG :CharArray)
    {
        //init game
        initGame()
        //if gameover is TRUE, stop the game
        while (!gameover) {

            // Get player's next guess word
            while (!pg.getAndReasonableGuess(trie, gG)) {}
            pg.maskEachGuess(ans.answer)
            pg.printResultGraphic(alph)
            ++round

            // Determine whether the player has won!
            gameover = true
            for (i in 0 until len) {
                if (round < loop4 && pg.getMask()[i] < 2) {
                    gameover = false
                    //break
                }
            }

        }

    }
    fun finishGame()
    {
        this.gameover = true
        this.trie.trieClear()
    }
}