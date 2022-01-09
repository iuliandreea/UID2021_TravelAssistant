package com.example.travelassistant.profile_management

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.travelassistant.R
import com.example.travelassistant.profile_management.account.Account
import com.example.travelassistant.profile_management.account.AccountList

class SignInActivity : AppCompatActivity() {

    private val accounts : ArrayList<Account> = AccountList.getAccounts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signInButton = findViewById<Button>(R.id.signInButton)
        val forgotPassword = findViewById<TextView>(R.id.forgotPasswordId)
        val signUp = findViewById<TextView>(R.id.signUpId)

        signInButton.setOnClickListener {
            val id = validateCredentials()
            if (id == -1) {
                val notif = findViewById<TextView>(R.id.notifId)
                notif.text = "Invalid username or password!"
                notif.setTextColor(Color.parseColor("#ff0000"))
                notif.requestFocus()
            }
            /*else {
                val myIntent = Intent(this, ExploreActivity::class.java)
                myIntent.putExtra("accountId", id)
                startActivity(myIntent)
            }*/
        }

        forgotPassword.setOnClickListener {
            val myIntent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(myIntent)
        }

        signUp.setOnClickListener {
            val myIntent = Intent(this, SignUpActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun validateCredentials(): Int {
        val currEmail = findViewById<EditText>(R.id.emailId).text.toString()
        val currPass = findViewById<EditText>(R.id.passwordId).text.toString()

        for (account in accounts) {
            if (account.email == currEmail && account.password == currPass) {
                return accounts.indexOf(account)
            }
        }

        return -1
    }

}