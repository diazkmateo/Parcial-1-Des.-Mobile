package ar.com.ifts18.a1ertpintegrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.com.ifts18.a1ertpintegrador.TestActivity
import java.util.concurrent.Executors


class CalcularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.invest_activity)


        val buttonVolverI = findViewById<Button>(R.id.buttonVolverI)
        val buttonVerResultado = findViewById<Button>(R.id.buttonVerResultado)

        buttonVerResultado.setOnClickListener {

            val etmontoInvertirI = findViewById<EditText>(R.id.etmontoInvertirI)
            val etTasaInteresI = findViewById<EditText>(R.id.ettasaInteresI)
            val ettiempoDiasI = findViewById<EditText>(R.id.ettiempoDiasI)

            val etmontoInvertirII = findViewById<EditText>(R.id.etmontoInvertirII)
            val ettasaInteresII = findViewById<EditText>(R.id.ettasaInteresII)
            val ettiempoDiasII = findViewById<EditText>(R.id.ettiempoDiasII)

            if(etmontoInvertirI.text.isEmpty() || etTasaInteresI.text.isEmpty() || ettiempoDiasI.text.isEmpty() || etmontoInvertirII.text.isEmpty() || ettasaInteresII.text.isEmpty() || ettiempoDiasII.text.isEmpty())
            {
                mostrarToast("Por favor, ingrese datos en todos los campos")
            }
            else
            {
                val montoInvertirI = etmontoInvertirI.text.toString().toFloat()
                val tasaInteresI = etTasaInteresI.text.toString().toFloat()
                val tiempoDiasI = ettiempoDiasI.text.toString().toInt()


                val montoInvertirII = etmontoInvertirII.text.toString().toFloat()
                val tasaInteresII = ettasaInteresII.text.toString().toFloat()
                val tiempoDiasII = ettiempoDiasII.text.toString().toInt()


                val tasaInteresDiaIFloat = (tasaInteresI / 360 / 100)
                val rendimientoI = tasaInteresDiaIFloat * montoInvertirI * tiempoDiasI
                val montoTotalAObtenerI = montoInvertirI + rendimientoI

                val tasaInteresDiaIIFloat = (tasaInteresII / 360 / 100)
                val rendimientoII = tasaInteresDiaIIFloat * montoInvertirII * tiempoDiasII
                val montoTotalAObtenerII = montoInvertirII + rendimientoII


                var intent = Intent(this, ResultsActivity::class.java)
                if (rendimientoI > rendimientoII)
                {
                    val propI = "La propuesta de inversión más conveniente es la propuesta I"
                    intent.putExtra("propuesta", propI)
                }
                else if (rendimientoI < rendimientoII)
                {
                    val propII = "La propuesta de inversión más conveniente es la propuesta II"
                    intent.putExtra("propuesta", propII)
                }
                else
                {
                    val propIII = "Ambas propuestas de inversión tienen la misma rentabilidad"
                    intent.putExtra("propuesta", propIII)
                }

                intent.putExtra("montoTotalI", montoTotalAObtenerI)
                intent.putExtra("montoTotalII", montoTotalAObtenerII)
                startActivity(intent)
            }
        }

        buttonVolverI.setOnClickListener{
            finish()
        }
    }
    fun mostrarToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
