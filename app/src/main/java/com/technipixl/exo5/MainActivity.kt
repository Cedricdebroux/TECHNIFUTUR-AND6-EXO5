package com.technipixl.exo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.technipixl.exo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        drawerLayout = binding.drawerLayout


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        setSupportActionBar(binding.toolbar)
        val appBarConfiguration: AppBarConfiguration?
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.tennisFragment,
                R.id.basketFragment,
                R.id.handFragment
            ), drawerLayout
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navigationView, navController)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.tennisFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.tennis)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.VISIBLE
                }
                R.id.basketFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.basket_bottom)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.VISIBLE
                }
                R.id.infoFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.info)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.GONE
                }
                R.id.pratiqueFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.pratique_title)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.GONE
                }
                R.id.entrainementFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.entrainement_title)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.GONE
                }
                R.id.planningFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.planning_title)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.GONE
                }
                R.id.contactFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.contact_title)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.GONE
                }
                R.id.handFragment -> {
                    findViewById<TextView>(R.id.toolbarTitle).text =
                        resources.getString(R.string.hand_bottom)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                        View.VISIBLE
                }


                else -> findViewById<TextView>(R.id.toolbarTitle).text = null
            }
        }
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    //    permet l'affichage de la fleche de retours
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp()
    }


}