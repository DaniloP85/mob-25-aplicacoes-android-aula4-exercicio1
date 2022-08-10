package com.example.exercicio1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar.setOnClickListener {
            val data = txtNome.text.toString() + ":" + listaTratamento.selectedItem.toString()
            saveFileData("saudacao", data)
            /*
            * exibindo o Toast
            *
            * */
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        btnExibit.setOnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }
    }

    /*
    * nesta versão vamos utilizar um arquivo para persistir as informações entre as telas
    *
    * */
    private fun saveFileData(filename: String, data: String) {
        try {
            val fs = openFileOutput(filename, Context.MODE_PRIVATE)
            fs.write(data.toByteArray())
            fs.close()
        } catch (e: FileNotFoundException) {
            Log.i("saveFileData", "FileNotFoundException")
        } catch (e: IOException) {
            Log.i("saveFileData", "IOException")
        }
    }
}