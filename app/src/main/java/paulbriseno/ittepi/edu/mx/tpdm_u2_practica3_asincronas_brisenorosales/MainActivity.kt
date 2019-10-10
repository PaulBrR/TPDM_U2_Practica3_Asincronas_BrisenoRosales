package paulbriseno.ittepi.edu.mx.tpdm_u2_practica3_asincronas_brisenorosales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var boton: Button?=null
    var boton2 : Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton=findViewById(R.id.btnEscribe)
        boton2=findViewById(R.id.btnArchivos)



        boton?.setOnClickListener {


                var los2000numeros =Intent(this,Main2Activity::class.java)
                startActivity(los2000numeros)
        }
        boton2?.setOnClickListener {
            val losArchivos=Intent(this,Main3Activity::class.java)
            startActivity(losArchivos)
        }
    }
}
