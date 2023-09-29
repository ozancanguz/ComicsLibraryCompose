package com.example.comicslbrarycompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comicslbrarycompose.model.api.MarvelApi
import com.example.comicslbrarycompose.repository.MarvelRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

import javax.inject.Inject
@HiltViewModel
class LibraryViewModel@Inject constructor(private val repo:MarvelRepo): ViewModel() {


    val result=repo.characters
    val queryText= MutableStateFlow("")
    private val queryInput= Channel<String>(Channel.CONFLATED)

    init {
        retriveCharacters()
    }

    private fun retriveCharacters() {

        viewModelScope.launch {
            queryInput.receiveAsFlow()
                .filter { validateQuery(it) }
                .debounce(1000)
                .collect{
                    repo.query(it)
                }
        }


    }

    private fun validateQuery(query: String) :Boolean= query.length >= 2


    fun onQueryUpdate(input:String){
        queryText.value=input
        queryInput.trySend(input)
    }



}