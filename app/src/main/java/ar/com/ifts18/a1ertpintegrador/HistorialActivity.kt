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
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.com.ifts18.a1ertpintegrador.TestActivity
import java.util.concurrent.Executors

class HistorialActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)

        val historial1 = findViewById<TextView>(R.id.tvHistorial1)
        val historial2 = findViewById<TextView>(R.id.tvHistorial2)
        val historial3 = findViewById<TextView>(R.id.tvHistorial3)
        val historial4 = findViewById<TextView>(R.id.tvHistorial4)
        val historial5 = findViewById<TextView>(R.id.tvHistorial5)

        val datosAlmacenados = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
        val ultimaActividad = datosAlmacenados.getString("ultimaActividad", null)

        historial1.text = datosAlmacenados.getString("historial1", null)
        historial2.text = datosAlmacenados.getString("historial2", null)
        historial3.text = datosAlmacenados.getString("historial3", null)
        historial4.text = datosAlmacenados.getString("historial4", null)
        historial5.text = datosAlmacenados.getString("historial5", null)

        if(ultimaActividad != historial1.text)
        {
            historial5.text = historial4.text
            historial4.text = historial3.text
            historial3.text = historial2.text
            historial2.text = historial1.text
            historial1.text = ultimaActividad
        }

        datosAlmacenados.edit().apply{
            putString("historial1", historial1.text.toString())
            putString("historial2", historial2.text.toString())
            putString("historial3", historial3.text.toString())
            putString("historial4", historial4.text.toString())
            putString("historial5", historial5.text.toString())
            apply()
        }


        val buttonVolver = findViewById<Button>(R.id.btHistorialVolver)
        buttonVolver.setOnClickListener{
            finish()
        }
    }

}