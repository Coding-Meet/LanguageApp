package com.example.languageapp

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import java.util.Locale

class LanguageShowActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        val sharedPreferences = newBase.getSharedPreferences(newBase.packageName, MODE_PRIVATE)
        val locale = Locale(sharedPreferences.getString("code","en")!!)
        Locale.setDefault(locale)
        val context = languageChange(newBase,locale)
        super.attachBaseContext(context)
    }

    private fun languageChange(context: Context, locale: Locale): Context {
        var tempContext = context
        val res = tempContext.resources
        val configuration =res.configuration

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            configuration.setLocale(locale)
            val localList = LocaleList(locale)
            LocaleList.setDefault(localList)
            configuration.setLocales(localList)
            tempContext = tempContext.createConfigurationContext(configuration)
        }else{
            configuration.locale = locale
            res.updateConfiguration(configuration,res.displayMetrics)
        }
        return tempContext
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_show)
    }
}