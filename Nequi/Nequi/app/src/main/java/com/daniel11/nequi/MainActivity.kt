package com.daniel11.nequi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun verificarCadena(cadena: String): Boolean {
            for (indice in cadena) {
                if (indice.isDigit()) {
                    return false
                }
            }
            return true
        }

        val telefono = findViewById<EditText>(R.id.Telefono)
        val contrasena = findViewById<EditText>(R.id.Contrasena)
        val mensajito= findViewById<TextView>(R.id.mensaje)
        val boton = findViewById<Button>(R.id.Ingresar)
        val verificar = verificarCadena(contrasena.text.toString())
        boton.setOnClickListener {
            if (!verificar) {
                val nuevoTexto = "La contraseña es netamente numerica"
                mensajito.text=nuevoTexto
            }
            else if (contrasena.text.toString().length < 4 || contrasena.text.toString().length > 4){
                val nuevoTexto = "La conraseña debe tener 4 digitos"
                mensajito.text=nuevoTexto
            }
            else {
                if (telefono.text.toString().equals("3208434852") && contrasena.text.toString().equals("3245")){
                    // Redirige a otra actividad si la cadena no contiene números
                    val intent = Intent(this, Dash_Board::class.java)
                    startActivity(intent)
                }
                else{
                    val nuevoTexto = "Datos de acceso incorrectos"
                    mensajito.text=nuevoTexto
                }
            }
        }
    }
}