package com.example.travelassistant.profile_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.travelassistant.R
import com.example.travelassistant.profile_management.account.Account
import com.example.travelassistant.profile_management.account.AccountList
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUp = findViewById<Button>(R.id.signUpButton)
        val signIn = findViewById<TextView>(R.id.signInId)

        signUp.setOnClickListener {
            val fullName = findViewById<EditText>(R.id.fullNameId)
            val email = findViewById<EditText>(R.id.emailId)
            val password = findViewById<EditText>(R.id.passwordId)

            if (validateCredentials(fullName, email, password)) {
                AccountList.addAccount(Account(email.text.toString(), password.text.toString(), fullName.text.toString()))
                val myIntent = Intent(this, SignInActivity::class.java)
                startActivity(myIntent)
            }
        }

        signIn.setOnClickListener {
            val myIntent = Intent(this, SignInActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun validateCredentials(fullName: EditText, email: EditText, password: EditText): Boolean {
        val nameText = fullName.text.toString()
        val emailText = email.text.toString()
        val passText = password.text.toString()

        var validCount = 3

        val p: Pattern = Pattern.compile("^[ A-Za-z]+$")
        if (nameText == "" || !p.matcher(nameText).matches()) {
            fullName.error = "Make sure this field is not empty and only contains letters and spaces"
            fullName.requestFocus()
            validCount -= 1
        }

        if (TextUtils.isEmpty(emailText) || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            email.error = "Make sure this field is not empty and represents a valid email address"
            email.requestFocus()
            validCount -= 1
        }

        if (passText == "" || passText.length < 5) {
            password.error = "Make sure this field is not empty and has at least 5 characters"
            password.requestFocus()
            validCount -= 1
        }

        if (validCount == 3)
            return true
        return false
    }
}