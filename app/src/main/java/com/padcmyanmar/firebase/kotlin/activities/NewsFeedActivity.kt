package com.padcmyanmar.firebase.kotlin.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.padcmyanmar.firebase.kotlin.R
import com.padcmyanmar.firebase.kotlin.adapters.NewsFeedsAdapter
import kotlinx.android.synthetic.main.activity_news_feed.*
import org.mmtextview.MMFontUtils
import org.mmtextview.components.MMTextView

class NewsFeedActivity : AppCompatActivity() {

    private var mNewsFeedsAdapter: NewsFeedsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)
        MMFontUtils.initMMTextView(this)

        toolbar.title = getString(R.string.launcher_name)
        setSupportActionBar(toolbar)

        mNewsFeedsAdapter = NewsFeedsAdapter(applicationContext)
        rvNewsFeed.adapter = mNewsFeedsAdapter

        rvNewsFeed.setEmptyView(vpEmptyNewsFeed)

        fab.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_news_feed, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}