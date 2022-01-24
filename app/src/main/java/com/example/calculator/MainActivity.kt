package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonClear.setOnClickListener{
            input.text=""
            output.text=""
        }

        buttonLeftBracket.setOnClickListener {
            input.text= addToInputText("(")
        }

        buttonRightBracket.setOnClickListener {
            input.text= addToInputText(")")
        }

        buttonZero.setOnClickListener {
            input.text= addToInputText("0")
        }

        buttonDoubleZero.setOnClickListener {
            input.text= addToInputText("00")
        }

        buttonOne.setOnClickListener {
            input.text= addToInputText("1")
        }

        buttonTwo.setOnClickListener {
            input.text= addToInputText("2")
        }

        buttonThree.setOnClickListener {
            input.text= addToInputText("3")
        }

        buttonFour.setOnClickListener {
            input.text= addToInputText("4")
        }

        buttonFive.setOnClickListener {
            input.text= addToInputText("5")
        }

        buttonSix.setOnClickListener {
            input.text= addToInputText("0")
        }

        buttonSeven.setOnClickListener {
            input.text= addToInputText("7")
        }

        buttonEight.setOnClickListener {
            input.text= addToInputText("8")
        }

        buttonNine.setOnClickListener {
            input.text= addToInputText("9")
        }

        buttonDecimal.setOnClickListener {
            input.text= addToInputText(".")
        }

        buttonDivide.setOnClickListener {
            input.text= addToInputText("÷")
        }

        buttonMultiply.setOnClickListener {
            input.text= addToInputText("×")
        }

        buttonSubtract.setOnClickListener {
            input.text= addToInputText("-")
        }

        buttonAdd.setOnClickListener {
            input.text= addToInputText("+")
        }

        buttonEquals.setOnClickListener {
            showResult()
        }


    }

    private fun addToInputText(buttonValue:String):String{
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String{
        var expression= input.text.replace(Regex("÷"), "/")
        expression=input.text.replace(Regex("×"),"*")
        return expression
    }

    private fun showResult(){
        try{
            val expression= getInputExpression()
            val result= Expression(expression).calculate()
            if(result.isNaN()){
                //Show Error Message
                output.text="Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }else{
                //Show Result
                output.text=DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }catch(e: Exception){
            //Show Error Message
            output.text="Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.green))
        }
    }
}