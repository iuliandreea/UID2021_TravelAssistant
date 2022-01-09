package com.example.travelassistant.profile_management

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.travelassistant.R

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val resetButton = findViewById<Button>(R.id.resetPassword)
        val signIn = findViewById<TextView>(R.id.signInId)

        resetButton.setOnClickListener {
            val emailField = findViewById<EditText>(R.id.emailId)
            if (validateEmail(emailField.text.toString()))
                showDialog()
            else {
                emailField.error = "Invalid email address"
                emailField.requestFocus()
            }
        }

        resetButton.setOnLongClickListener {
            val myIntent = Intent(this, ResetPasswordDetalisActivity::class.java)
            startActivity(myIntent)
            true
        }

        signIn.setOnClickListener {
            val myIntent = Intent(this, SignInActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun validateEmail(emailField: String) : Boolean {
        return !TextUtils.isEmpty(emailField) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailField).matches()
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Request sent successfully")
            .setMessage("An email with information on how to change your password will be sent to you shortly")
            .setNeutralButton("Dismiss", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }
}