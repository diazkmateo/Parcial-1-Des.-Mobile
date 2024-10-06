package ar.com.ifts18.a1ertpintegrador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

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


            // Mostrar los resultados en las vistas correspondientes
            val textViewPropuestaI = findViewById<TextView>(R.id.textViewPropuestaI)
            val textoPropuestaI = getString(R.string.texto_monto_total_propuestaI, montoTotalI)
            textViewPropuestaI.text = textoPropuestaI

            val textViewPropuestaII = findViewById<TextView>(R.id.textViewPropuestaII)
            val textoPropuestaII = getString(R.string.texto_monto_total_propuestaII, montoTotalII)
            textViewPropuestaII.text = textoPropuestaII
        }
        // Asignar una acción al botón "Volver"
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)
        buttonVolver.setOnClickListener{
            finish()
        }
    }
}