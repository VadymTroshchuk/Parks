
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


    // Query to count distinct cities in the park table
    private val QUERY_COUNT_DISTINCT_CITIES = "SELECT COUNT(DISTINCT city) FROM park"


    // Query to sum park visitors in San Francisco
    private val QUERY_SUM_PARK_VISITORS_SF = "SELECT SUM(park_visitors) FROM park WHERE city = 'San Francisco'"


    // Query to select the top 5 parks with the highest number of visitors
    private val QUERY_TOP_5_PARKS = "SELECT name, park_visitors FROM park ORDER BY park_visitors DESC LIMIT 5"

}
