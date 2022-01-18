package com.affinityclick.mvvm

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import com.affinityclick.mvvm.R.id
import com.affinityclick.mvvm.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

  private lateinit var binding: ActivityMainBinding
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    navController = findNavController(this, id.nav_host_fragment)
    setupActionBarWithNavController(this, navController, binding.drawerLayout)
    binding.navView.setNavigationItemSelectedListener(this)
  }

  override fun onSupportNavigateUp(): Boolean {
    return navigateUp(navController, binding.drawerLayout)
  }

  override fun onBackPressed() {
    if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
      binding.drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    val id = item.itemId
    return if (id == R.id.action_settings) {
      true
    } else super.onOptionsItemSelected(
      item
    )
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    // Handle navigation view item clicks here.
    val id = item.itemId
    if (id == R.id.nav_top_rated) {
      navController.navigate(R.id.movieListFragment)
      // Handle the camera action
    } else if (id == R.id.nav_gallery) {
    }
    binding.drawerLayout.closeDrawer(GravityCompat.START)
    return true
  }
}