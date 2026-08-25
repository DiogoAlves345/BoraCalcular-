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

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val distancia = intent.getIntExtra("DISTANCIA", 0)
        val editConsumo = findViewById<TextView>(R.id.editConsumo)
        val btnConsumoProxima = findViewById<Button>(R.id.btnConsumoProxima)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_Consumo)

        // função para mostrar toolbar na tela
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnConsumoProxima.setOnClickListener {
            val consumo = editConsumo.text.toString().toInt()
            val intent = Intent(this, PrecoActivity::class.java)
            intent.putExtra("DISTANCIA", distancia)
            intent.putExtra("CONSUMO",consumo)
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