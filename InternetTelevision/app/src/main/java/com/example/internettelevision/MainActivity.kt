package com.example.internettelevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    companion object
    {
        private var instance : MainActivity? = null
        public fun getInstance() : MainActivity
        {
            return instance!!
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.homeFragment)
        //navController.

        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setupWithNavController(navController)
        //navController.navigate(R.id.homeFragment)

       /* bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.channelFragment -> {
                    navController.navigate(R.id.channelFragment)
                    true
                }
                R.id.configFragment -> {
                    navController.navigate(R.id.configFragment)
                    true
                }
                else -> false
            }
        }*/

    }


}