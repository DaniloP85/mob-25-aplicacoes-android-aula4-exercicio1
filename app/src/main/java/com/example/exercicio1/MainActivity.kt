package com.example.exercicio1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        *
        * nessa primeira versão não estavamos consistindo as informações somente trafegando entre
        * as tela
        *
        * */

        btnSalvar.setOnClickListener {
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listaTratamento.selectedItem.toString())
            editor.apply()

            /*
            * Um Toast é uma mensagem de alerta curta exibida na tela
            * do Android por um curto intervalo de tempo.
            * */

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        /*
        * aqui podemos ver a troca de tela
        * ao clicar no botão exibir
        * */

        btnExibir.setOnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }
    }
}