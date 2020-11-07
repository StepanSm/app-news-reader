package com.smerkis.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smerkis.news.ui.NewsFeedFragment
import com.smerkis.news.utils.inTransaction

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.inTransaction {
            replace(R.id.fragmentContainer, NewsFeedFragment())
        }
    }


}
