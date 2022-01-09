package com.example.travelassistant

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.travelassistant.profile_management.fragments.EditProfileFragment
import com.example.travelassistant.profile_management.fragments.ProfileDetailsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_fragment)
        // bottomNavigationView.setupWithNavController(navController)


        val id = intent.getIntExtra("accountId", -1)
        Log.println(Log.ERROR, "ACCOUNTID Explore", id.toString())
        val bundle = Bundle()
        bundle.putInt("accountId", id)
        navController.setGraph(R.navigation.nav_graph, bundle)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            navController.navigate(item.itemId, bundle)
            true
        }
        //Initialize the bottom navigation view
        //create bottom navigation view object

    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = fragment.childFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}