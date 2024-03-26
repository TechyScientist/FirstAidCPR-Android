package com.johnnyconsole.android.firstaidcpr

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar!!
        actionBar.setBackgroundDrawable(ColorDrawable(getColor(R.color.SJAGreenContainer)))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            AlertDialog.Builder(this)
                .setTitle(R.string.aboutTitle)
                .setMessage(Html.fromHtml(getString(R.string.aboutMessage)))
                .setNeutralButton(R.string.dismiss, null)
                .create()
                .show()
        }
        return true
    }
}