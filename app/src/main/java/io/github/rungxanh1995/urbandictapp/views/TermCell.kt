package io.github.rungxanh1995.urbandictapp.views

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.rungxanh1995.urbandictapp.controllers.DefinitionActivity
import io.github.rungxanh1995.urbandictapp.models.Term
import kotlinx.android.synthetic.main.term_cell.view.*

class TermCell(
    termView: View,
    var term: Term? = null
): RecyclerView.ViewHolder(termView) {

    val wordTextView: TextView          = termView.wordTextView
    val definitionTextView: TextView    = termView.definitionTextView

    init {
        termView.setOnClickListener {
            term?.let {
                val intent = Intent(termView.context, DefinitionActivity::class.java)
                intent.putExtra(Term.termKey, it)
                termView.context.startActivity(intent)
            }
        }
    }
}