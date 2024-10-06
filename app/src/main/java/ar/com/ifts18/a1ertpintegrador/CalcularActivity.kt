package ar.com.ifts18.a1ertpintegrador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class CalcularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.invest_activity)


        val buttonVolverI = findViewById<Button>(R.id.buttonVolverI)
        val buttonVerResultado = findViewById<Button>(R.id.buttonVerResultado)

        buttonVerResultado.setOnClickListener {

            val etmontoInvertirI = findViewById<EditText>(R.id.etmontoInvertirI)
            val montoInvertirI = etmontoInvertirI.text.toString().toFloat()

            val etTasaInteresI = findViewById<EditText>(R.id.ettasaInteresI)
            val tasaInteresI = etTasaInteresI.text.toString().toFloat()

            val ettiempoDiasI = findViewById<EditText>(R.id.ettiempoDiasI)
            val tiempoDiasI = ettiempoDiasI.text.toString().toInt()


            val etmontoInvertirII = findViewById<EditText>(R.id.etmontoInvertirII)
            val montoInvertirII = etmontoInvertirII.text.toString().toFloat()

            val ettasaInteresII = findViewById<EditText>(R.id.ettasaInteresII)
            val tasaInteresII = ettasaInteresII.text.toString().toFloat()

            val ettiempoDiasII = findViewById<EditText>(R.id.ettiempoDiasII)
            val tiempoDiasII = ettiempoDiasII.text.toString().toInt()


            val tasaInteresDiaIFloat = (tasaInteresI / 360 / 100)
            val rendimientoI = tasaInteresDiaIFloat * montoInvertirI * tiempoDiasI
            val montoTotalAObtenerI = montoInvertirI + rendimientoI

            val tasaInteresDiaIIFloat = (tasaInteresII / 360 / 100)
            val rendimientoII = tasaInteresDiaIIFloat * montoInvertirII * tiempoDiasII
            val montoTotalAObtenerII = montoInvertirII + rendimientoII

            val intent = Intent(this, ResultsActivity::class.java)
            if (rendimientoI > rendimientoII)
            {
                val propI = ("La propuesta de inversión más conveniente es la propuesta I")
                intent.putExtra("propuesta", propI)
            }
            else if (rendimientoI < rendimientoII)
            {
                val propII = ("La propuesta de inversión más conveniente es la propuesta II")
                intent.putExtra("propuesta", propII)
            }
            else
            {
                val propIII = ("Ambas propuestas de inversión tienen la misma rentabilidad")
                intent.putExtra("propuesta", propIII)
            }

            intent.putExtra("montoTotalI", montoTotalAObtenerI)
            intent.putExtra("montoTotalII", montoTotalAObtenerII)
            startActivity(intent)

        }

        buttonVolverI.setOnClickListener{
            finish()
        }
    }

}
