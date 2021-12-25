package io.github.rungxanh1995.urbandictapp.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.rungxanh1995.urbandictapp.R
import io.github.rungxanh1995.urbandictapp.models.Term
import kotlinx.android.synthetic.main.activity_definition.*
import kotlinx.android.synthetic.main.term_cell.*

class DefinitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definition)

        val term = intent.getSerializableExtra(Term.termKey) as? Term
        term?.let {
            supportActionBar?.title = "Definition for '${it.word}'"
            defDetailTextView.text  = it.htmlDefinition
            likesTextView.text      = "Likes: ${it.likes}"
            dislikesTextView.text   = "Dislikes: ${it.dislikes}"
        }
    }
}