package com.example.comicslbrarycompose.view

sealed class Destination(val route:String){
    object LibrarScreen:Destination("library_screen")
    object CollectionScreen:Destination("collection_screen")
    object CharacterDetailScreen:Destination("character_detail_screen/{characterId}"){
        fun createRoute(characterId:Int?)="character/$characterId"

    }

}
