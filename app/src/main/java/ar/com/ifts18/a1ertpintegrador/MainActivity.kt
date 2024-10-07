package ar.com.ifts18.a1ertpintegrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonTest = findViewById<Button>(R.id.btTest)
        val botonCalcular = findViewById<Button>(R.id.btCalcular)
        val botonHistorial = findViewById<Button>(R.id.btHistorial)
        val botonLegal = findViewById<Button>(R.id.btLegal)

        val datosAlmacenados = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
        val usuarioTesteado = datosAlmacenados.getBoolean("hizoTest", false)

        if(usuarioTesteado)
        {
            val tvNombre = findViewById<TextView>(R.id.tvMainNombre)
            tvNombre.setText(datosAlmacenados.getString("nombre", null))

            val tvApellido = findViewById<TextView>(R.id.tvMainApellido)
            tvApellido.setText(datosAlmacenados.getString("apellido", null))

            val tvEmail = findViewById<TextView>(R.id.tvMainEmail)
            tvEmail.setText(datosAlmacenados.getString("email", null))

            val tvCategoria = findViewById<TextView>(R.id.textoCategoria)
            tvCategoria.setText("Su estilo de inversión es: "+(datosAlmacenados.getString("categoria", null)))
        }

        botonTest.setOnClickListener{
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
            finish()
        }

        botonCalcular.setOnClickListener{
            if(usuarioTesteado)
            {
                val intent = Intent(this, CalcularActivity::class.java)
                startActivity(intent)
            }
            else
            {
                mostrarToast("Primero debe hacer el test del inversor!")
            }
        }

        botonHistorial.setOnClickListener{
            if(usuarioTesteado)
            {
                val intent = Intent(this, HistorialActivity::class.java)
                startActivity(intent)
            }
            else
            {
                mostrarToast("Primero debe hacer el test del inversor!")
            }
        }

        botonLegal.setOnClickListener{
            val intent = Intent(this, LegalActivity::class.java)
            startActivity(intent)
        }

    }

    fun mostrarToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}

