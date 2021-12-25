package io.github.rungxanh1995.urbandictapp.models

import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Term(
    @SerializedName("word")
    val word: String,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("thumbs_up")
    val likes: String,
    @SerializedName("thumbs_down")
    val dislikes: String
): Serializable {
    val htmlDefinition: Spanned
    get() {
        val nonBracedDefinition = this.definition
            .replace("[", "<b>")
            .replace("]", "</b>")
        return HtmlCompat.fromHtml(nonBracedDefinition, HtmlCompat.FROM_HTML_MODE_COMPACT)
    }

    companion object {
        const val termKey = "termKey"
    }
}