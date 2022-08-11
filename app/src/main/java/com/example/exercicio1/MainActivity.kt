package com.example.exercicio1

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
        * Abrindo conexao com o banco de dados
        * para primeiro remover e depois inserir o nome
        * */

        val db = DataBaseManager(this, "saudacoes")

        btnSalvar.setOnClickListener {
            db.removeSaudacao()
            db.insereSaudacao(
                1,
                txtNome.text.toString().trim(),
                listaTratamento.selectedItem.toString()
            )
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        btnExibit.setOnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }
    }
}