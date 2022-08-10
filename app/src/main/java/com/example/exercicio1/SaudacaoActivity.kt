package com.example.exercicio1

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val data = recoveryFileData()
        val tokenizer = StringTokenizer(data, ":")
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem tratamento"
        if (tratamento.equals("Sem Tratamento")) {
            lbSaudacao.text = nome
        } else {
            lbSaudacao.text = tratamento + " " + nome
        }


    }

    private fun recoveryFileData(): String {
        return try {
            val fi = openFileInput("saudacao")
            val data = fi.readBytes()
            fi.close()
            data.toString()
            data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException) {
            ""
        } catch (e: IOException) {
            ""
        }
    }
}
