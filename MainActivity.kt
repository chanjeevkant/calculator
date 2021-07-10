package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

//import Kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
    var lastnum = false
    var lastdot = true
    fun onDigit(view:View){
        val tvfinal = findViewById<TextView>(R.id.tvfinal)
        tvfinal.append((view as Button).text)
        lastnum = true

    }
    fun clear(view:View){
        val tvfinal = findViewById<TextView>(R.id.tvfinal)
        tvfinal.text=""
        lastdot=true
        lastnum = false
    }
    fun decimal(view:View){
        if (lastnum && lastdot) {
            tvfinal.append(".")
            lastdot = false

        }
    }
    fun operator(view:View) {
        if (lastnum && !isthereoperator(tvfinal.text.toString())) {
            tvfinal.append((view as Button).text)
            lastnum = false
            lastdot = false
        }
    }

        fun isthereoperator(value: String): Boolean {
            return if (value.startsWith("-")) {
                false
            } else {
                value.contains("/") || value.contains("-") || value.contains("+") || value.contains(
                    "*"
                )
            }
        }
    fun equal(view:View){
        if (lastnum){
            var fullinput = tvfinal.text.toString()
            var prefix = ""
//            minus operation
            try{
                try{
                    if (fullinput.startsWith("-")){
                        prefix="-"
                        fullinput = fullinput.substring(1)
                    }
                }catch (e:ArithmeticException){
                    e.printStackTrace()
                }
                if (fullinput.contains("-")){
                    var split = fullinput.split("-")
                    var bef = split[0]
                    var aft = split[1]
                    if (!prefix.isEmpty()){
                        bef = prefix+bef
                    }

                    var res =removezero((bef.toDouble() - aft.toDouble()).toString())
                    tvfinal.text = "$res"

                }

            }catch(e:ArithmeticException){
                e.printStackTrace()
            }
            //plus operation
            try{
                try{
                    if (fullinput.startsWith("-")){
                        prefix="-"
                        fullinput = fullinput.substring(1)
                    }
                }catch (e:ArithmeticException){
                    e.printStackTrace()
                }
                if (fullinput.contains("+")){
                    var split = fullinput.split("+")
                    var bef = split[0]
                    var aft = split[1]
                    if (!prefix.isEmpty()){
                        bef = prefix+bef
                    }

                    var res =removezero((bef.toDouble() + aft.toDouble()).toString())
                    tvfinal.text = "$res"

                }

            }catch(e:ArithmeticException){
                e.printStackTrace()
            }

            //Division operation
            try{
                try{
                    if (fullinput.startsWith("-")){
                        prefix="-"
                        fullinput = fullinput.substring(1)
                    }
                }catch (e:ArithmeticException){
                    e.printStackTrace()
                }
                if (fullinput.contains("/")){
                    var split = fullinput.split("/")
                    var bef = split[0]
                    var aft = split[1]
                    if (!prefix.isEmpty()){
                        bef = prefix+bef
                    }

                    var res =removezero((bef.toDouble() / aft.toDouble()).toString())
                    tvfinal.text = "$res"

                }

            }catch(e:ArithmeticException){
                e.printStackTrace()
            }

            //multiplication operation

            try{
                try{
                    if (fullinput.startsWith("-")){
                        prefix="-"
                        fullinput = fullinput.substring(1)
                    }
                }catch (e:ArithmeticException){
                    e.printStackTrace()
                }
                if (fullinput.contains("*")){
                    var split = fullinput.split("*")
                    var bef = split[0]
                    var aft = split[1]
                    if (!prefix.isEmpty()){
                        bef = prefix+bef
                    }

                    var res =removezero((bef.toDouble() * aft.toDouble()).toString())
                    tvfinal.text = "$res"

                }

            }catch(e:ArithmeticException){
                e.printStackTrace()
            }

        }
    }
    fun removezero(result:String):String {
        var value = result
        if (value.contains(".0"))
            value = value.substring(0, value.length - 2)
        return value
    }
}