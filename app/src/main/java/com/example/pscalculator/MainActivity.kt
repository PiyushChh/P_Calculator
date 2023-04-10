package com.example.pscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech.Engine
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import javax.script.ScriptEngine
import javax.script.ScriptEngineFactory
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    var chec=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tex:String
        one.setOnClickListener {
            tex=input.text.toString()+"1"
            input.text = tex
            resultfun(tex)
        }

        two.setOnClickListener {
            tex=input.text.toString()+"2"
            input.text = tex
            resultfun(tex)
        }

        three.setOnClickListener {

            tex=input.text.toString()+"3"
            input.text = tex
            resultfun(tex)
        }

        four.setOnClickListener {
            tex=input.text.toString()+"4"
            input.text = tex
            resultfun(tex)
        }

        five.setOnClickListener {
            tex=input.text.toString()+"5"
            input.text = tex
            resultfun(tex)
        }

        six.setOnClickListener {
            tex=input.text.toString()+"6"
            input.text = tex
            resultfun(tex)
        }

        seven.setOnClickListener {
            tex=input.text.toString()+"7"
            input.text = tex
            resultfun(tex)
        }

        eight.setOnClickListener {
            tex=input.text.toString()+"8"
            input.text = tex
            resultfun(tex)
        }

        nine.setOnClickListener {
            tex=input.text.toString()+"9"
            input.text = tex
            resultfun(tex)
        }
        zero.setOnClickListener {
            tex=input.text.toString()+"0"
            input.text = tex
            resultfun(tex)
        }

        dot.setOnClickListener {
            tex=input.text.toString()+"."
            input.text = tex
            resultfun(tex)
        }

        clear.setOnClickListener {
            input.text=""
            result.text=""
        }

        plus.setOnClickListener {
            tex=input.text.toString()+"+"
            input.text=tex
            chec=chec+1
        }

        minus.setOnClickListener {
            tex=input.text.toString()+"-"
            input.text=tex
            chec=chec+1
        }

        mult.setOnClickListener {
            tex=input.text.toString()+"*"
            input.text=tex
            chec=chec+1
        }

        divide.setOnClickListener {
            tex=input.text.toString()+"/"
            input.text=tex
            chec=chec+1
        }

        percent.setOnClickListener {
            tex=input.text.toString()+"%"
            input.text=tex
            chec=chec+1
        }

        equal.setOnClickListener {
            tex=result.text.toString()
            input.text=tex
            result.text=""
        }

        back.setOnClickListener {
            var BackSpace: String?=null
            if(input.text.length>0){
                val stringBuilder: java.lang.StringBuilder=StringBuilder(input.text)
                val find=input.text.toString()
                val find2=find.last()

                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%')){
                    chec=chec-1
                }

                stringBuilder.deleteCharAt(input.text.length-1)
                BackSpace=stringBuilder.toString()
                input.text=BackSpace
                resultfun(BackSpace)
            }
        }
    }

    private fun resultfun(tex: String) {
        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val results: Any=engine.eval(tex)
            var mainResult=results.toString()
            if (chec==0){
                result.text=""
            }
            else{
                result.text=mainResult
            }
        }catch (e:ScriptException){
            Log.d("Tag","Error")
        }
    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            result.text = ""
            input.append(string)
        } else {
            input.append(result.text)
            input.append(string)
            result.text = ""
        }
    }
}


