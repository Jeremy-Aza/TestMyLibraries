package com.example.testmylibraries

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.vdid.ContentLibrary
import com.example.vdid.OnProcessListener

//import com.example.vdid.ContentLibrary
//import com.example.vdid_document.MyLibrary

class MainActivity : AppCompatActivity(), OnProcessListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myFragment = ContentLibrary.autocaptureFragment(this)

        supportFragmentManager.commit {
            replace(
                R.id.fragmentContainer, myFragment
            )
        }

        //Prueba SDK
        val buttonTestSdk: Button = this.findViewById(R.id.btnTestSdk)
        buttonTestSdk.setOnClickListener {
            val getId = ContentLibrary.getApplicationId(this)
            Toast.makeText(this, getId, Toast.LENGTH_SHORT).show()
        }

        // Stop process (async)
        val buttonStop: Button = this.findViewById(R.id.btnStop)
        buttonStop.setOnClickListener {
            ContentLibrary.stopDetection { message ->
                Toast.makeText(
                    this, message, Toast.LENGTH_SHORT
                ).show()
            }
        }

        //Liberar recursos (hay que tener cuidado con esta función porque puede romper el proceso si esta capturando la imagen)
        val buttonRelease: Button = this.findViewById(R.id.btnRelease)
        buttonRelease.setOnClickListener {
            ContentLibrary.releaseResources()
        }

        // Continue Detection
        val button: Button = this.findViewById(R.id.btnShowMessage)
        button.setOnClickListener {
            ContentLibrary.continueDetection()
            Toast.makeText(this, "Proceso iniciado", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCaptureFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDocumentCaptured(image: ByteArray) {
        println("#####ByteArray $image")
        val img = ContentLibrary.imageToBase64(image)
        println("#####Get image $img")
    }


}


