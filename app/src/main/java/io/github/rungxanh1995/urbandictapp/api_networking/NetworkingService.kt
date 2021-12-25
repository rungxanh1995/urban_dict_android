package io.github.rungxanh1995.urbandictapp.api_networking

import androidx.lifecycle.LiveData
import io.github.rungxanh1995.urbandictapp.models.Term
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingService {

    val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


    fun defineTerm(term: String): LiveData<List<Term>> {
        return object: LiveData<List<Term>>() {
            override fun onActive() {
                super.onActive()
                CoroutineScope(Dispatchers.IO).launch {
                    val response = apiService.defineTerm(term)
                    withContext(Dispatchers.Main) {
                        value = response.terms
                    }
                }
            }
        }
    }
}
