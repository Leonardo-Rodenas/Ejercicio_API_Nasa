package com.example.ejercicio_api_nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.ejercicio_api_nasa.databinding.ActivityMainBinding
import com.example.ejercicio_api_nasa.viewmodel.TerrenosViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navegador: NavController
    val vmodel: TerrenosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var o val, val o var?
        //vmodel = ViewModelProvider(this).get(TerrenosViewModel::class.java)

        var navhost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragContainer) as NavHostFragment
        navegador = navhost.navController;

        NavigationUI.setupActionBarWithNavController(this, navegador)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navegador, null)
    }


}