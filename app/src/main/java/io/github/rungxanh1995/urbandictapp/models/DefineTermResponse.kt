package io.github.rungxanh1995.urbandictapp.models

import com.google.gson.annotations.SerializedName

data class DefineTermResponse(
    @SerializedName("list")
    val terms: List<Term>
) {
}