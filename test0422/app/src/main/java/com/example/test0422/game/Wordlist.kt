package com.example.test0422.game

import java.io.File
import java.io.IOException
import java.util.*

//const
const val len = 4
const val rows = 427
const val cols = len

class Wordlist {

    private val w = arrayOf(CharArray(rows),CharArray(cols))

    /* Create a  Wordlist< 2DArray >
    and Build "Trie" data structure */
    fun createWordList(t: Trie): Array<CharArray>
    {
        val fp = "wordlist.txt"
        try {
            val sc = Scanner(File(fp))
            /*if(fp == NULL)
               {
                   perror("Error fopen!");
                   // error
                   return false;
               }*/
            var item= 0
            while (sc.hasNextLine()) {
                val str = sc.nextLine()
                println("$item*")
                println("$str-")
                for (i  in 0 until len +1) {
                    w[item][i] = str[i]
                }
                t.trieInsert(str)
                item++
            }
        } catch (e: IOException) {
            //print error address and error message
            e.printStackTrace()
        }
        return w
    }
}