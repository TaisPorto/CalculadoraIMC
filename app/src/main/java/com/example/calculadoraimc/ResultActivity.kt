package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView



class ResultActivity :AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //Botao de voltar

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*TABELA IMC
    MENOR QUE 18,5       ABAIXO DO PESO 0
    ENTRE 18,5 E 24,9    NORMAL 0
    ENTRE 25,0 E 29,9    SOBREPESO I
    ENTRE 30,0 E 39,9    OBESIDADE II
    MAIOR QUE  40,0      OBESIDADE GRAVE III
    */
                var classificao = ""

                if (result < 18.5f) {

        classificao = "ABAIXO DO PESO"
        tvClassificacao.setTextColor ( resources.getColor(R.color.blue_200))
        tvResult.setTextColor ( resources.getColor(R.color.blue_200))

        } else if (result >= 18.5f && result <= 24.9f) {

        classificao = "NORMAL"
        tvClassificacao.setTextColor( resources.getColor(R.color.green))
        tvResult.setTextColor ( resources.getColor(R.color.green))

        } else if (result >= 25f && result <= 29.9f) {

        classificao = "SOBREPESO"
        tvClassificacao.setTextColor(resources.getColor(R.color.yellow))
        tvResult.setTextColor ( resources.getColor(R.color.yellow))

        } else if (result >= 30f && result <= 39.9f) {

        classificao = "OBESIDADE"
        tvClassificacao.setTextColor(resources.getColor(R.color.orange))
        tvResult.setTextColor ( resources.getColor(R.color.orange))

        } else{

        classificao = "OBESIDADE MÓRBIDA"
        tvClassificacao.setTextColor(resources.getColor(R.color.red))
        tvResult.setTextColor ( resources.getColor(R.color.red))
        }


        tvClassificacao.text = getString(R.string.message_classificacao, classificao)

        }

        //Ação de Retornar ao cliclar no botão
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
                finish()


       return super.onOptionsItemSelected(item)


                }

        }








