package com.johnnyconsole.android.firstaidcpr

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.johnnyconsole.android.firstaidcpr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val actionBar = supportActionBar!!
        actionBar.setBackgroundDrawable(ColorDrawable(getColor(R.color.SJAGreenContainer)))

        binding.lvMenu.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(this@MainActivity, binding.lvMenu.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            AlertDialog.Builder(this)
                .setTitle(R.string.aboutTitle)
                .setMessage(Html.fromHtml(getString(R.string.aboutMessage), 0))
                .setNeutralButton(R.string.dismiss, null)
                .create()
                .show()
        }
        return true
    }
}