package com.example.fithcmusinfo.domain.mail

import android.content.Context
import android.content.Intent
import android.net.Uri

fun composeEmail(context: Context, address: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:") // Only email apps handle this.
        putExtra(Intent.EXTRA_EMAIL, arrayOf(address))
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}