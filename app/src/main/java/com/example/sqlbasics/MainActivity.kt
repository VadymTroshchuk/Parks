
package com.example.sqlbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            AppDatabase.getDatabase(applicationContext).californiaParkDao().getAll()
        }
    }

    // Query to get parks with visitors less than 1,000,000
    private val QUERY_PARKS_LESS_THAN_MILLION = "SELECT * FROM park WHERE park_visitors < 1000000"

}
