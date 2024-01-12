package com.example.trabalho_pmeu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalho_pmeu.R
import androidx.navigation.fragment.NavHostFragment
import com.example.trabalho_pmeu.databinding.ActivityMainBinding
//import com.example.trabalho_pmeu.helper.initToolbar

class  MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
}