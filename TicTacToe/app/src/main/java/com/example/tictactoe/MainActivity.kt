package com.example.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var buttonsArray=ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonsArray.add(button2)
        buttonsArray.add(button3)
        buttonsArray.add(button4)
        buttonsArray.add(button5)
        buttonsArray.add(button6)
        buttonsArray.add(button7)
        buttonsArray.add(button8)
        buttonsArray.add(button9)
        buttonsArray.add(button10)

    }
    fun buttonClick(view: View){
        var button = view as Button
        game(button)
    }

    var activePlay=true
    private fun game(button: Button) {
        if(activePlay==true){
            button.text="X"
            activePlay=false
        }
        else{
            button.text="O"
            activePlay=true
        }
        button.isEnabled=false
        isGameFinished()
    }
    fun buttonFalse(){
        for(button in buttonsArray){
            button.isEnabled=false
        }
    }

    fun buttonBackground(b1:Button,b2:Button,b3:Button){
        b1.setBackgroundColor(Color.parseColor("#FF8989"))
        b2.setBackgroundColor(Color.parseColor("#FF8989"))
        b3.setBackgroundColor(Color.parseColor("#FF8989"))
    }


    private fun isGameFinished() {
        var winner = -1
        if(button2.text=="X" && button3.text=="X" && button4.text=="X"){
            winner = 1
            buttonBackground(button2,button3,button4)
            buttonFalse()
        }
        else if(button5.text=="X" && button6.text=="X" && button7.text=="X"){
            winner = 1
            buttonBackground(button5, button6, button7)
            buttonFalse()
        }
        else if(button8.text=="X" && button9.text=="X" && button10.text=="X"){
            winner = 1
            buttonBackground(button8, button9, button10)
            buttonFalse()
        }
        else if(button2.text=="X" && button5.text=="X" && button8.text=="X"){
            winner = 1
            buttonBackground(button2, button5, button8)
            buttonFalse()
        }
        else if(button3.text=="X" && button6.text=="X" && button9.text=="X"){
            winner = 1
            buttonBackground(button3, button6,button9)
            buttonFalse()
        }
        else if(button4.text=="X" && button7.text=="X" && button10.text=="X"){
            winner = 1
            buttonBackground(button4, button7, button10)
            buttonFalse()
        }
        else if(button2.text=="X" && button6.text=="X" && button10.text=="X"){
            winner = 1
            buttonBackground(button2, button6, button10)
            buttonFalse()
        }
        else if(button4.text=="X" && button6.text=="X" && button8.text=="X"){
            winner = 1
            buttonBackground(button4, button6, button8)
            buttonFalse()
        }


        else if(button2.text=="O" && button3.text=="O" && button4.text=="O"){
            winner = 2
            buttonBackground(button2, button3, button4)
            buttonFalse()
        }
        else if(button5.text=="O" && button6.text=="O" && button7.text=="O"){
            winner = 2
            buttonBackground(button5, button6, button7)
            buttonFalse()
        }
        else if(button8.text=="O" && button9.text=="O" && button10.text=="O"){
            winner = 2
            buttonBackground(button8, button9, button10)
            buttonFalse()
        }
        else if(button2.text=="O" && button5.text=="O" && button8.text=="O"){
            winner = 2
            buttonBackground(button2, button5, button8)
            buttonFalse()
        }
        else if(button3.text=="O" && button6.text=="O" && button9.text=="O"){
            winner = 2
            buttonBackground(button3, button6, button9)
            buttonFalse()
        }
        else if(button4.text=="O" && button7.text=="O" && button10.text=="O"){
            winner = 2
            buttonBackground(button4, button7, button10)
            buttonFalse()
        }
        else if(button2.text=="O" && button6.text=="O" && button10.text=="O"){
            winner = 2
            buttonBackground(button2, button6, button10)
            buttonFalse()
        }
        else if(button4.text=="O" && button6.text=="O" && button8.text=="O"){
            winner = 2
            buttonBackground(button4, button6, button8)
            buttonFalse()
        }

        if(winner!=-1){
                textView.text="Game finished!\nThe winner is"+winner
        }

    }

    fun restart(view: View){

        for(button in buttonsArray){
            button.text = ""
            activePlay = true
            button.isEnabled=true
            button.setBackgroundColor(Color.parseColor("#F6F6F6"))
        }
        textView.text=""


    }



}
