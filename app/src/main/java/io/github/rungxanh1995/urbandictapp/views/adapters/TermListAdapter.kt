package io.github.rungxanh1995.urbandictapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.rungxanh1995.urbandictapp.R
import io.github.rungxanh1995.urbandictapp.models.Term
import io.github.rungxanh1995.urbandictapp.views.TermCell

class TermListAdapter: RecyclerView.Adapter<TermCell>() {

    private var terms = emptyList<Term>()


    override fun getItemCount(): Int = terms.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermCell {
        val termView = LayoutInflater.from(parent.context).inflate(R.layout.term_cell, parent, false)
        return TermCell(termView)
    }


    override fun onBindViewHolder(holder: TermCell, position: Int) {
        val term                        = terms[position]
        holder.wordTextView.text        = term.word
        holder.definitionTextView.text  = term.htmlDefinition
        holder.term                     = term
    }


    fun update(terms: List<Term>) {
        this.terms = terms
        notifyDataSetChanged()
    }
}