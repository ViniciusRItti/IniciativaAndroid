package br.unipar.iniciativaandroid_01

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Dentro da Activity principal

        val editTextIdade = findViewById<EditText>(R.id.editTextIdade)
        val buttonVerificar = findViewById<Button>(R.id.buttonVerificar)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        buttonVerificar.setOnClickListener {
            val idadeTexto = editTextIdade.text.toString()

            if (idadeTexto.isNotEmpty()) {
                val idade = idadeTexto.toInt()

                val mensagem = when {
                    idade < 18 -> "Você é menor de idade."
                    idade in 18..60 -> "Você está na meia idade."
                    else -> "Você é idoso."
                }

                textViewResultado.text = mensagem
            } else {
                textViewResultado.text = "Por favor, insira sua idade."
            }
        }


    }
}


