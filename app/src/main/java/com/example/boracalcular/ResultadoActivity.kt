package com.example.boracalcular

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvDistancia = findViewById<TextView>(R.id.tvResultadoDistancia)
        val tvConsumo = findViewById<TextView>(R.id.tvResultadoConsumo)
        val tvPreco = findViewById<TextView>(R.id.tvResultadoPreco)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnNovoCalculo = findViewById<Button>(R.id.btnNovoCalculo)

        val distancia = intent.getIntExtra("DISTANCIA",0)
        val consumo = intent.getIntExtra("CONSUMO",0)
        val preco = intent.getDoubleExtra("PRECO",0.0)
         val custoTotal = intent.getDoubleExtra("CUSTO_TOTAL",0.0)

        tvResultado.text = "R$ $custoTotal"
        tvDistancia.text = distancia.toString()
        tvConsumo.text = consumo.toString()
        tvPreco.text = preco.toString()

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}