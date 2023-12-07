package com.example.myapp_filrouge.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Article(
    var id:Long,
    var titre:String,
    var description:String,
    var prix:Double,
    var urlImage: String,
    var dateSortie:Date
) : Parcelable{

}