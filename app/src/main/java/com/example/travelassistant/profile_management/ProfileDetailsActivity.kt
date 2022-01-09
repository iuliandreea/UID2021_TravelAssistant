package com.example.travelassistant.profile_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.travelassistant.R
import com.example.travelassistant.profile_management.account.Account
import com.example.travelassistant.profile_management.account.AccountList

class ProfileDetailsActivity : AppCompatActivity() {

    lateinit var account: Account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)

        val accountId = intent.getIntExtra("accountId", -1)
        account = AccountList.getAccount(accountId)

        findViewById<TextView>(R.id.nameId).text = account.fullName
        findViewById<TextView>(R.id.emailId).text = account.email

        val edit = findViewById<Button>(R.id.editProfileButton)
        val currentTrip = findViewById<TextView>(R.id.currentTripId)
        val budget = findViewById<TextView>(R.id.BudgetTrackerId)

        edit.setOnClickListener {
            val myIntent = Intent(this, EditProfileActivity::class.java)
            myIntent.putExtra("accountId", accountId)
            startActivity(myIntent)
        }

        currentTrip.setOnClickListener {
            // add activity intent for current trip
        }

        budget.setOnClickListener {
            // add activity intent for budget tracker
        }
    }
}