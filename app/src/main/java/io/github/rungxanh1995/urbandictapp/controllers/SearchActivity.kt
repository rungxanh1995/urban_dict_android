package io.github.rungxanh1995.urbandictapp.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.rungxanh1995.urbandictapp.R
import io.github.rungxanh1995.urbandictapp.models.Term
import kotlinx.android.synthetic.main.activity_main.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton.setOnClickListener {
            navigateToResultsActivity(searchTextField.text.toString())
        }
    }

    private fun navigateToResultsActivity(phrase: String) {
        val intent = Intent(this, ResultsListActivity::class.java)
        intent.putExtra(Term.termKey, phrase)
        startActivity(intent)
    }
}