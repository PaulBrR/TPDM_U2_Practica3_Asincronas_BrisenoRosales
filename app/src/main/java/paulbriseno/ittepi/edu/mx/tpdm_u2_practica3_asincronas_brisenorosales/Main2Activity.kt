package paulbriseno.ittepi.edu.mx.tpdm_u2_practica3_asincronas_brisenorosales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.app.Activity
import android.app.AlertDialog
import android.os.AsyncTask
import android.widget.Button
import android.widget.EditText
import java.io.OutputStreamWriter
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {
    var numeroN: EditText?=null
    var numeroM :EditText?= null
    var btn : Button?=null
    var btreg:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        contexto=this
        btn=findViewById(R.id.btnExec)
        btreg=findViewById(R.id.close1)
        numeroN=findViewById(R.id.numN)
        numeroM=findViewById(R.id.numM)


        btn?.setOnClickListener {

       var n=numeroN?.text.toString().toInt()
        var m=numeroM?.text.toString().toInt()

            if(!numeroM?.text!!.isEmpty() && !numeroN?.text!!.isEmpty()){
        if(n < m){

            Asincrona().execute(n,m)

        }else{
            mensaje("Necesitas tener el primer numero mayor al segundo")
        }


        }else{
                mensaje("Necesita llenar los campos")
            }

        }

        btreg?.setOnClickListener {
            finish()
        }
    }



    class Asincrona : AsyncTask<Int, Void, List<Int>>() {
        override fun doInBackground(vararg p0: Int?): List<Int> {

            var n = p0.get(0)
            var m = p0.get(1)

            /*
            var numeros : ArrayList<Int> ?= null
            (1..2000).forEach {
                numeros?.add((Math.random()*m!! + n!!).toInt())         //Llenado secuencial
            }
            */

            var numeros = List(2000){ Random.nextInt(n!!,m!!)}   // Con numeros RANDOMS

            return numeros
        }

        override fun onPostExecute(result: List<Int>?) {
            super.onPostExecute(result)

            var numeros = ""

            (0..result!!.size-1).forEach {
                var numero = result.get(it)
                var contador = 0
                (1..numero).forEach {i->
                    if (numero % i == 0){
                        contador++
                    }
                }
                if (contador == 2){
                    numeros = numeros + numero + "\n"

                }

            }

            val archivo = OutputStreamWriter(Main2Activity.contexto.openFileOutput("primos2000.txt", Activity.MODE_PRIVATE))
            archivo.write(numeros)
            archivo.flush()
            archivo.close()
            mensaje("Guardado !!!")
        }
    }
companion object {
    lateinit var contexto :Main2Activity

    fun mensaje(texto: String) {
        Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show()
    }
}
}
