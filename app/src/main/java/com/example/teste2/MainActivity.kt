package com.example.teste2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Guarda a opção escolhida: "janta", "festa", "filme" ou null (nenhuma)
    private var opcaoSelecionada: String? = null

    private val opcoesJanta = listOf("Pizza", "Lasanha", "Churrasco", "Sushi", "Hambúrguer")
    private val opcoesFesta = listOf("Música ao vivo", "Karaokê", "Jogos", "Open bar", "Dança")
    private val opcoesFilme = listOf("Comédia", "Terror", "Ação", "Romance", "Ficção científica")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun Janta(view: View) {
        opcaoSelecionada = "janta"
    }

    fun Festa(view: View) {
        opcaoSelecionada = "festa"
    }

    fun Filme(view: View) {
        opcaoSelecionada = "filme"
    }

    fun Sortear(view: View) {
        val textResultado = findViewById<TextView>(R.id.textResultado)

        when (opcaoSelecionada) {
            "janta" -> {
                val item = opcoesJanta[Random.nextInt(opcoesJanta.size)]
                textResultado.text = "Para a janta, sorteamos: $item"
            }
            "festa" -> {
                val item = opcoesFesta[Random.nextInt(opcoesFesta.size)]
                textResultado.text = "Para a festa, sorteamos: $item"
            }
            "filme" -> {
                val item = opcoesFilme[Random.nextInt(opcoesFilme.size)]
                textResultado.text = "Para o filme, sorteamos: $item"
            }
            else -> {
                textResultado.text = "Escolha Janta, Festa ou Filme primeiro!"
            }
        }
    }
}