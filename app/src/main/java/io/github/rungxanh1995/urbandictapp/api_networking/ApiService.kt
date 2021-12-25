package io.github.rungxanh1995.urbandictapp.api_networking

import io.github.rungxanh1995.urbandictapp.models.DefineTermResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
    "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
    "x-rapidapi-key: 902d50479cmsh223f2dc0ccfa9d4p18cac4jsn09c95df0c395"
    )
    @GET("define")
    suspend fun defineTerm(
        @Query("term")
        term: String
    ): DefineTermResponse
}