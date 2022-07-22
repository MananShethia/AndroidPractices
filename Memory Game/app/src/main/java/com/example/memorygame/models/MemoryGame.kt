package com.example.memorygame.models

import com.example.memorygame.utils.DEFAULT_ICONS

class MemoryGame( private val boardSize: BoardSize ) {

    val cards: List<MemoryCard>
    var numPairsFound = 0

    private var numCardFlip = 0
    private var indexOfSingleSelectedCard: Int? = null

    init{
        var chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        var randomizedImages = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map{ MemoryCard(it) }
    }

    //GameLogic
    fun flipCard(position: Int): Boolean {
        numCardFlip++
        val card = cards[position]

        //Three Cases
        //0 card previously flipped over => (restore cards +) flip over the selected card
        //1 card previously flipped over => flip over the selected card + check if the image match
        //2 cards previously flipped over => restore cards + flip over the selected card

        // 0 and 2 is quite similar
        var foundMatch = false
        if(indexOfSingleSelectedCard == null){
            // 0 or 2 cards previously flipped over case
            restoreCards()
            indexOfSingleSelectedCard = position
        }
        else{
            // 1 cars previously flipped over case
            foundMatch = checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
        return foundMatch
    }

    private fun checkForMatch(position1: Int, position2: Int): Boolean {
        if(cards[position1].identifier != cards[position2].identifier){
            return false
        }
        cards[position1].isMatched = true
        cards[position2].isMatched = true
        numPairsFound++
        return true
    }

    private fun restoreCards() {
        for (card in cards){
            if(!card.isMatched){
                card.isFaceUp = false
            }
        }
    }

    fun haveWonGame(): Boolean {
        return numPairsFound == boardSize.getNumPairs()
    }

    fun isCardFacedUp(position: Int): Boolean {
        return cards[position].isFaceUp
    }

    fun getNumMoves(): Int {
        return numCardFlip / 2
    }
}