package com.example.testmylibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.vdid.ContentLibrary

//import com.example.vdid.ContentLibrary
//import com.example.vdid_document.MyLibrary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myFragment = ContentLibrary.newFragment()

        supportFragmentManager.commit {
            replace(
                R.id.fragmentContainer,
                myFragment
            )
        }

    }
}


