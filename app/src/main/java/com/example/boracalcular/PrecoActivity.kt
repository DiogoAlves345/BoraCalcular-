package com.example.boracalcular

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distancia = intent.getIntExtra("DISTANCIA",0)
        val consumo = intent.getIntExtra("CONSUMO",0)
        val editPreco = findViewById<TextView>(R.id.editPreco)
        val btnPrecoCalcular = findViewById<Button>(R.id.btnPrecoCalcular)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_Preco)

        // função para mostrar toolbar na tela
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnPrecoCalcular.setOnClickListener {
            val preco = editPreco.text.toString().toDouble()
            val litrosNecessarios = distancia/consumo
            val custoTotal= litrosNecessarios * preco

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("DISTANCIA",distancia)
            intent.putExtra("CONSUMO",consumo)
            intent.putExtra("PRECO",preco)
            intent.putExtra("LLITROS_NECESSARIOS", litrosNecessarios)
            intent.putExtra("CUSTO_TOTAL",custoTotal)

            startActivity(intent)


        }
    }
    // função volta para tela anterior
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}