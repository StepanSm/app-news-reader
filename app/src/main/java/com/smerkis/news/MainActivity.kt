package com.smerkis.news

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.cookpad.watson.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var bottomNavigationView: BottomNavigationView
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_NEWS)
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_main_activity)
      //  setSupportActionBar(toolbar)


        bottomNavigationView = findViewById(R.id.bottomNavigation)

        bottomNavigationView.setupWithNavController(
            graphResId = R.navigation.navigation,
            activity = this,
            initialSelectedTabId = R.id.news_feed_fragment,
            enabledTabs = listOf(
                R.id.news_feed_fragment,
                R.id.sourcesFragment,
                R.id.aboutAppFragment
            ),
            containerId = R.id.nav_host_fragment
        )
    }


}

