package com.daniel11.nequi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random
class Dash_Board : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        val retirar = findViewById<Button>(R.id.Retirar)
        val recargar = findViewById<Button>(R.id.Recargar)
        val consignar=findViewById<Button>(R.id.Consignar)
        val saldo=findViewById<TextView>(R.id.ValorSaldo)
        val telefonoConsig=findViewById<EditText>(R.id.Telefonito)
        val valorCon=findViewById<EditText>(R.id.valorCon)
        val valorReca=findViewById<EditText>(R.id.valorReca)
        val valorReti=findViewById<EditText>(R.id.ValorReti)
        val numeroCod=findViewById<TextView>(R.id.numeroCo)
        retirar.setOnClickListener{
            if (valorReca.text.toString().toInt() >saldo.text.toString().toInt()){
                Toast.makeText(this, "¡No puede ser mayor al saldo!", Toast.LENGTH_LONG).show()
            }
            else{
                val instanciaRandom= Random()
                var Codigo=instanciaRandom.nextInt(999999)
                numeroCod.text=Codigo.toString()
            }
        }
        recargar.setOnClickListener {
            var saldo2=saldo.text.toString().toInt()+valorReca.text.toString().toInt()
            saldo.text=saldo2.toString()
        }
        consignar.setOnClickListener {
            if (valorCon.text.toString().toInt() >saldo.text.toString().toInt()){
                Toast.makeText(this, "¡No puede ser mayor al saldo!", Toast.LENGTH_LONG).show()
            }
            else{
                var saldo2=saldo.text.toString().toInt()-valorCon.text.toString().toInt()
                Toast.makeText(this, "Se consigno ${valorCon.text.toString()}, al numero ${telefonoConsig.text.toString()}", Toast.LENGTH_LONG).show()
                saldo.text=saldo2.toString()
            }
        }
    }
}
