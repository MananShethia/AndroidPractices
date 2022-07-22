package com.example.memorygame

import android.animation.ArgbEvaluator
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygame.models.BoardSize
import com.example.memorygame.models.MemoryCard
import com.example.memorygame.models.MemoryGame
import com.example.memorygame.utils.DEFAULT_ICONS
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var clRoot: ConstraintLayout
    private lateinit var board: RecyclerView
    private lateinit var moves: TextView
    private lateinit var pairs: TextView

    private lateinit var memoryGame: MemoryGame
    private lateinit var adapter: MemoryBoardAdapter
    private var boardSize:BoardSize = BoardSize.EASY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clRoot = findViewById(R.id.clRoot)
        board = findViewById(R.id.board)
        moves = findViewById(R.id.moves)
        pairs = findViewById(R.id.pairs)

        setupBoard()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_refresh -> {
                //setup the game again
                if(memoryGame.getNumMoves() > 0 && !memoryGame.haveWonGame()){
                    showAlertDialog("Are You Sure You Want To Refresh", null, View.OnClickListener {
                        setupBoard()
                    })
                }
                else{
                    setupBoard()
                }
                return true
            }
            R.id.mi_board_size -> {
                showBoardSizeDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showBoardSizeDialog() {
        val boardSizeView  =  LayoutInflater.from(this).inflate(R.layout.dialog_board_size, null)
        val radioGroup = boardSizeView.findViewById<RadioGroup>(R.id.radioGroup)
        when(boardSize){
            BoardSize.EASY -> radioGroup.check(R.id.rbEasy)
            BoardSize.MEDIUM -> radioGroup.check(R.id.rbMedium)
            BoardSize.HARD -> radioGroup.check(R.id.rbHard)
        }//To make current board radio select

        showAlertDialog("Choose Board Size", boardSizeView, View.OnClickListener {
            //set a new value for board size
            boardSize = when(radioGroup.checkedRadioButtonId){
                R.id.rbEasy -> BoardSize.EASY
                R.id.rbMedium -> BoardSize.MEDIUM
                else -> BoardSize.HARD
            }
            setupBoard()
        })
    }

    private fun showAlertDialog(title: String, view: View?, positiveClickListner: View.OnClickListener) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setView(view)
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Yes", { _, _ ->
                positiveClickListner.onClick(null)
            })
            .setCancelable(false)
            .show()
    }

    private fun setupBoard() {

        when(boardSize){
            BoardSize.EASY -> {
                moves.text = "Easy: 4 x 2"
                pairs.text = "Pairs: 0 / 4"
            }
            BoardSize.MEDIUM -> {
                moves.text = "Medium: 6 x 3"
                pairs.text = "Pairs: 0 / 9"
            }
            BoardSize.HARD -> {
                moves.text = "HARD: 6 x 4"
                pairs.text = "Pairs: 0 / 12"
            }
        }

        pairs.setTextColor(ContextCompat.getColor(this, R.color.color_progress_none))

//        var chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
//        var randomizedImages = (chosenImages + chosenImages).shuffled()
//        val memoryCards: List<MemoryCard> = randomizedImages.map{ MemoryCard(it) }
        memoryGame = MemoryGame(boardSize)

//        Log.i("test", boardSize.getWidth().toString())
//        board.adapter = MemoryBoardAdapter(this, boardSize, randomizedImages) // bind the data to page // 8
//        board.adapter = MemoryBoardAdapter(this, boardSize, memoryCards)
        adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards, object: MemoryBoardAdapter.CardClickListener{
            override fun onCardClicked(position: Int) {
                Log.i(TAG, "Img Position $position")
                updateGameWithFlip(position)
            }
        })
        board.adapter = adapter
        board.setHasFixedSize(true)
        board.layoutManager = GridLayoutManager(this, boardSize.getWidth()) // position efficiently // 2
    }

    private fun updateGameWithFlip(position: Int) {
        //Error Handling
        if(memoryGame.haveWonGame()){
            //Alert the user of an invalid move
            Snackbar.make(clRoot, "You Already Won!", Snackbar.LENGTH_LONG).show()
            return
        }
        if(memoryGame.isCardFacedUp(position)){
            //Alert the user of an invalid move
            Snackbar.make(clRoot, "Invalid move!", Snackbar.LENGTH_SHORT).show()
            return
        }

        //Actually Flip over the card
        if(memoryGame.flipCard(position)){
            Log.i(TAG, "Found match! NumPairs = ${memoryGame.numPairsFound}")

            //Color Pairs text
            val color = ArgbEvaluator().evaluate(
                memoryGame.numPairsFound.toFloat() / boardSize.getNumPairs(),
                ContextCompat.getColor(this, R.color.color_progress_none),
                ContextCompat.getColor(this, R.color.color_progress_full)
            ) as Int
            pairs.setTextColor(color)

            pairs.text = "Pairs: ${memoryGame.numPairsFound} / ${boardSize.getNumPairs()}"
            if(memoryGame.haveWonGame()){
                Snackbar.make(clRoot, "You Won The Game!!!", Snackbar.LENGTH_LONG).show()
            }
        }
        moves.text = "Mos: ${memoryGame.getNumMoves()}"
        adapter.notifyDataSetChanged()
    }
}