package io.github.rungxanh1995.urbandictapp.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.rungxanh1995.urbandictapp.R
import io.github.rungxanh1995.urbandictapp.api_networking.NetworkingService
import io.github.rungxanh1995.urbandictapp.models.Term
import io.github.rungxanh1995.urbandictapp.views.adapters.TermListAdapter
import kotlinx.android.synthetic.main.activity_results.*

class ResultsListActivity : AppCompatActivity() {

    private val networkingService   = NetworkingService()
    private val adapter             = TermListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        resultList.layoutManager    = LinearLayoutManager(this)
        resultList.adapter          = adapter

        val term                    = intent.getStringExtra(Term.termKey)
        supportActionBar?.title     = "Search results for '$term'"
        term?.let { getResultsForTerm(it) }
    }


    private fun getResultsForTerm(term: String) {
        networkingService.defineTerm(term).observe(this, { terms ->
            adapter.update(terms)
        })
    }
}