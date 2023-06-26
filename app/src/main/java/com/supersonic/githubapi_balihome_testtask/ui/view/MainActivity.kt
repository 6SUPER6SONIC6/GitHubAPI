package com.supersonic.githubapi_balihome_testtask.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.supersonic.githubapi_balihome_testtask.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}