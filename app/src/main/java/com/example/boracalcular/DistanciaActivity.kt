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

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editDistancia = findViewById<TextView>(R.id.editDistancia)
        val btnDistanciaProxima = findViewById<Button>(R.id.btnDistanciaProxima)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_distancia)

        // função para mostrar toolbar na tela
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnDistanciaProxima.setOnClickListener {
            val distancia = editDistancia.text.toString().toInt()

            val intent = Intent(this, ConsumoActivity::class.java)
            intent.putExtra("DISTANCIA",distancia)
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