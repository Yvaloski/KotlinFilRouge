package com.example.myapp_filrouge.utils

import android.icu.text.SimpleDateFormat
import java.util.Date

object DateConverter  {

    @JvmStatic
    fun dateToSimpleString(date: Date?): String {

        if (date != null) {
            val format = SimpleDateFormat("dd/MM/yyyy")
            return  format.format(date)
        }else{
            return ""
        }


    }
}