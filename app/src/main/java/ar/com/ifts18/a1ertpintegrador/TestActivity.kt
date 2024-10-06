package ar.com.ifts18.a1ertpintegrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.com.ifts18.a1ertpintegrador.TestActivity
import java.util.concurrent.Executors

class TestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)

        val etNombre = findViewById<EditText>(R.id.ingresarNombre)
        val etApellido = findViewById<EditText>(R.id.ingresarApellido)
        val etEmail = findViewById<EditText>(R.id.ingresarEmail)

        val pregunta1 = findViewById<RadioGroup>(R.id.pregunta1)
        val pregunta2 = findViewById<RadioGroup>(R.id.pregunta2)
        val pregunta3 = findViewById<RadioGroup>(R.id.pregunta3)

        val botonVolver = findViewById<Button>(R.id.btTestVolver)
        val botonEvaluar = findViewById<Button>(R.id.btTestEvaluar)

        val datosAlmacenados = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
        botonEvaluar.setOnClickListener{

            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val email = etEmail.text.toString()

            if(nombre.isEmpty() || apellido.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                mostrarToast("Nombre, apellido o Email inválido")
            }
            else
            {
                if(pregunta1.getCheckedRadioButtonId() == -1 || pregunta2.getCheckedRadioButtonId() == -1 || pregunta3.getCheckedRadioButtonId() == -1)
                {
                    mostrarToast("Por favor, complete el test")
                }
                else
                {
                    val respuesta1 = obtenerValorRespuesta(pregunta1.checkedRadioButtonId)
                    val respuesta2 = obtenerValorRespuesta(pregunta2.checkedRadioButtonId)
                    val respuesta3 = obtenerValorRespuesta(pregunta3.checkedRadioButtonId)

                    val resultado = respuesta1 + respuesta2 + respuesta3
                    var categoria: String = ""

                    when(resultado){
                        in 1..4 -> categoria = "Conservador"
                        in 5..7 -> categoria = "Moderado"
                        in 8..9 -> categoria = "Agresivo"
                    }
                    mostrarToast("Tu estilo de inversión es "+categoria)

                    datosAlmacenados.edit().apply {
                        putBoolean("hizoTest", true)
                        putString("nombre", nombre)
                        putString("apellido", apellido)
                        putString("email", email)
                        putString("categoria", categoria)
                        commit()
                    }

                }
            }
        }
        botonVolver.setOnClickListener{
            finish()
        }

    }
    fun mostrarToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun obtenerValorRespuesta(radioButtonId: Int): Int {
        return when (radioButtonId) {
            // A1, A2, A3
            R.id.radioButton1 -> 1 // A1
            R.id.radioButton2 -> 2 // A2
            R.id.radioButton3 -> 3 // A3
            // B1, B2, B3
            R.id.radioButton4 -> 1 // B1
            R.id.radioButton5 -> 2 // B2
            R.id.radioButton6 -> 3 // B3
            // C1, C2, C3
            R.id.radioButton7 -> 1 // C1
            R.id.radioButton8 -> 2 // C2
            R.id.radioButton9 -> 3 // C3
            else -> 0
        }
    }
}