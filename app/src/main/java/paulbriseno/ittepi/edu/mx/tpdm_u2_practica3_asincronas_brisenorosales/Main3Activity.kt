package paulbriseno.ittepi.edu.mx.tpdm_u2_practica3_asincronas_brisenorosales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStreamReader

class Main3Activity : AppCompatActivity() {
    var abrir :Button?=null
    var contenido:TextView?=null
    var regresar :Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        abrir=findViewById(R.id.mostrarArch)
        contenido=findViewById(R.id.textoArch)
        regresar=findViewById(R.id.close2)

        abrir?.setOnClickListener {
            abrirArchivos()
        }
        regresar?.setOnClickListener {
            finish()
        }
    }
    fun abrirArchivos(){

        val abrirArchivo =BufferedReader(InputStreamReader(openFileInput("primos2000.txt")))
        var cadena =""

        cadena =abrirArchivo.readLine()

        val alerta= AlertDialog.Builder(this)

        alerta.setTitle("ATENCION").setMessage("SE LOGRO LEER ARCHIVO")
            .setPositiveButton("ACEPTAR"){dialog,which ->}.show()
        contenido?.setText(cadena)


    }
}
