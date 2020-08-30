package com.atahar.germanschool.view

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.NavHeaderMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(navController.graph, drawerLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val headerView = navView.inflateHeaderView(R.layout.nav_header_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        setupNavigation()
        setupViews()
/*
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
*/
    }

    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
        }
    }

    override fun onResume() {
        super.onResume()
        invalidateOptionsMenu()
    }

    private fun setupViews() {
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||  super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_letter_structure_fragment -> {
                navController.popBackStack(R.id.letterStructureFragment, true)
                navController.popBackStack(R.id.aboutFragment, true)

                navController.navigate(R.id.letterStructureFragment)
            }

            R.id.nav_about_fragment -> {
                navController.popBackStack(R.id.aboutFragment, true)
                navController.popBackStack(R.id.letterStructureFragment, true)

                navController.navigate(R.id.aboutFragment)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}