package com.example.jobfindme.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.example.jobfindme.R
import com.example.jobfindme.fragment.ContactFragment
import com.example.jobfindme.fragment.HomeFragment
import com.example.jobfindme.fragment.TimelineFragment
import com.example.jobfindme.fragment.WorkFragment
import com.example.jobfindme.activity.HomeActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragment: HomeFragment
    lateinit var workFragment: WorkFragment
    lateinit var contactFragment: ContactFragment
    lateinit var timelineFragment: TimelineFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting the intent from SignInActivity
        val intt = intent
        val output = intt.getStringExtra("username")
        welcome.text = output

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Job Find Me!"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            R.string.open,
            R.string.close

        ) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        // Default fragment
        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()



    }

    // Implementation of Navigation Item Selected Listener
    override fun onNavigationItemSelected(menuitem: MenuItem): Boolean {
        when(menuitem.itemId) {
            // Home Fragment calling
            R.id.home -> {
//                homeFragment = HomeFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame_layout, homeFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    .commit()
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }

            // Work Fragment calling
            R.id.profile -> {
              /*  workFragment = WorkFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, workFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()*/

                var intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }

            // Contact Fragment calling
            R.id.aboutApp -> {
                contactFragment = ContactFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, contactFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            // Timeline Fragment calling
            R.id.timeline -> {
                timelineFragment = TimelineFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, timelineFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}