package com.example.myapp_filrouge.bo

import java.util.Date

data class Article(
    var id:Long,
    var titre:String,
    var description:String,
    var prix:Double,
    var urlImage: String,
    var dateSortie:Date
) {

}