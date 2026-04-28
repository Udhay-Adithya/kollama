package com.udhay.kollama.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(dateString: String?): String {
    if (dateString == null) return "N/A"

    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val date: Date = inputFormat.parse(dateString)!!
        outputFormat.format(date)
    } catch (e: Exception) {
        dateString
    }
}