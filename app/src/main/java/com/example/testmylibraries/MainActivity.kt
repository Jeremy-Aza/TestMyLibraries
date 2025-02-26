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
                R.id.fragmentContainer,
                myFragment
            )
        }


        val button: Button = this.findViewById(R.id.btnShowMessage)
        button.setOnClickListener {
            ContentLibrary.continueDetection()
            Toast.makeText(this, "Proceso iniciado", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCaptureFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDocumentCaptured(image: String) {
        println("####################Get image $image")
    }


}


