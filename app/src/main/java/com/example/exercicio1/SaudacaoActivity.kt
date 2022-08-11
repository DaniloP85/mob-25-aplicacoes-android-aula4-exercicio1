package com.example.exercicio1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("Range", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        /*
        * Abrindo conexao com o banco de dados
        * a variavel curso controla se temos ou não conteudo no banco de dados
        * */

        val db = DataBaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        var nome = ""
        var tratamento = ""

        if (cursor.count > 0){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }

        if (tratamento == "Sem Tratamento") {
            lbSaudacao.text = nome
        } else {
            lbSaudacao.text = "$tratamento $nome"
        }
    }
}
