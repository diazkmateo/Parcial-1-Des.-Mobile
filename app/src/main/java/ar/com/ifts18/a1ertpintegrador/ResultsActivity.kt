package ar.com.ifts18.a1ertpintegrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.com.ifts18.a1ertpintegrador.TestActivity
import java.util.concurrent.Executors


class ResultsActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.results_activity)

        // Obtener los datos enviados mediante el Intent
        val extras = intent.extras
        if (extras != null)
        {
            val montoTotalI = extras.getFloat("montoTotalI", 0.0f)
            val montoTotalII = extras.getFloat("montoTotalII", 0.0f)
            val resultado = extras.getString("propuesta", "ERROR")

            // Mostrar los resultados en las vistas correspondientes
            val textViewPropuestaI = findViewById<TextView>(R.id.textViewPropuestaI)
            val textoPropuestaI = getString(R.string.texto_monto_total_propuestaI, montoTotalI)
            textViewPropuestaI.text = textoPropuestaI

            val textViewPropuestaII = findViewById<TextView>(R.id.textViewPropuestaII)
            val textoPropuestaII = getString(R.string.texto_monto_total_propuestaII, montoTotalII)
            textViewPropuestaII.text = textoPropuestaII

            val tvResultado = findViewById<TextView>(R.id.tvResultado)
            val textoResultado = getString(R.string.texto_resultado, resultado)
            tvResultado.text = getString(R.string.texto_resultado, textoResultado)


            val datosAlmacenados = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
            datosAlmacenados.edit().apply {
                putString("ultimaActividad", resultado+": %.2f".format(montoTotalI)+" vs %.2f".format(montoTotalII))
                commit()
            }
        }

        // Asignar una acción al botón "Volver"
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)
        buttonVolver.setOnClickListener{
            finish()
        }
    }
}