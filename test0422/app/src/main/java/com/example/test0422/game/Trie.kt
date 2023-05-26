package com.example.test0422.game

class Trie {
    /* Initialize Node. */
    data class Node(
        //property
        var word: String? = null,
        val childNodes: MutableMap<Char, Node> = mutableMapOf() )

    /* Create a root for Trie */
    private val root = Node()

    /* Inserts a word into the trie. */
    fun trieInsert(word: String )
    {
        var currentNode = root
        for (char in word) {
            if (currentNode.childNodes[char] == null) {
                currentNode.childNodes[char] = Node()
            }
            currentNode = currentNode.childNodes[char]!!
        }
        currentNode.word = word
    }
    /* Returns TRUE if the word is in the trie. */
    fun trieSearch(word: String): Boolean
    {
        var currentNode = root
        for (char in word) {
            if (currentNode.childNodes[char] == null) {
                return false
            }
            currentNode = currentNode.childNodes[char]!!
        }
        return currentNode.word != null
    }
    /* Clear the trie. */
    fun trieClear()
    {
        val currentNode = root
        currentNode.childNodes.clear()
    }
}