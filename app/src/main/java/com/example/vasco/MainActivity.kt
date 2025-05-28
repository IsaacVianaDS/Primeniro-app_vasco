package com.example.vasco

import android.Manifest
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_LOCATION_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Solicitação da permissão de localização (caso vá usar GPS no futuro)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            REQUEST_LOCATION_CODE
        )

        val jogadores = listOf(
            Pair(1, "Léo Jardim"),
            Pair(2, "Puma Rodríguez"),
            Pair(3, "Léo"),
            Pair(4, "Medel"),
            Pair(5, "Zé Gabriel"),
            Pair(6, "Payet"),
            Pair(7, "Galdames"),
            Pair(9, "David"),
            Pair(10, "Adson"),
            Pair(11, "Rossi")
        )

        val botaoSortear = findViewById<Button>(R.id.buttonSortear)
        val textResultado = findViewById<TextView>(R.id.textResultado)

        botaoSortear.setOnClickListener {
            val jogadorSorteado = jogadores.random()
            textResultado.text = "Número ${jogadorSorteado.first}: ${jogadorSorteado.second}"
        }
    }
}
