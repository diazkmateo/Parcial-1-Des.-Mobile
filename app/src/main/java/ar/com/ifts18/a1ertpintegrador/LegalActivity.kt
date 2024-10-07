package ar.com.ifts18.a1ertpintegrador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LegalActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.legal_activity)

        val botonVolver = findViewById<Button>(R.id.btVolver)
        botonVolver.setOnClickListener{
            finish()
        }
    }
}