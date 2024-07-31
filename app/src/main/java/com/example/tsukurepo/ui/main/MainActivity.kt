package com.example.tsukurepo.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tsukurepo.R
import com.example.tsukurepo.ui.createReport.CreateReportFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // MainFragmentを開く
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main, MainFragment.newInstance(viewModel))
            .commit()
    }

    fun moveToCreateReportFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main, CreateReportFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
