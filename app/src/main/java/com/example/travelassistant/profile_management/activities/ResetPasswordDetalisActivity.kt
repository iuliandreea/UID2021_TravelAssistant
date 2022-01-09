package com.example.travelassistant.profile_management.activities

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.travelassistant.MainActivity
import com.example.travelassistant.R

class ResetPasswordDetalisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password_detalis)

        val reset = findViewById<Button>(R.id.resetButton)
        val cancel = findViewById<TextView>(R.id.cancelId)

        reset.setOnClickListener {
            val newPassword = findViewById<EditText>(R.id.newPasswordId)
            val confirmNewPass = findViewById<EditText>(R.id.confirmNewPassId)
            println(newPassword.text.toString() + " " + confirmNewPass.text.toString())
            val result = validateCredentials(newPassword, confirmNewPass)
            if (result == 0) {
                showDialog()
            }
            else if (result == -1) {
                val notif = findViewById<TextView>(R.id.notifId)
                notif.text = "Passwords do not match"
                notif.setTextColor(Color.parseColor("#ff0000"))
                notif.requestFocus()
            }
        }

        cancel.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun validateCredentials(newPass: EditText, confirmNewPass: EditText): Int {
        val newPassText = newPass.text.toString()
        val confirmNewPassText = confirmNewPass.text.toString()

        if (newPassText == "" || newPassText.length < 5) {
            newPass.error = "Make sure this field is not empty and has at least 5 characters"
            newPass.requestFocus()
            return -2
        }

        else if (newPassText != confirmNewPassText) {
            return -1
        }

        return 0
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Password reset successfully")
            .setMessage("Press 'Dismiss' to return to the Sign In page")
            .setNeutralButton("Dismiss", DialogInterface.OnClickListener { dialog, _ ->
                val myIntent = Intent(this, SignInActivity::class.java)
                startActivity(myIntent)
                // dialog.dismiss()
            })
        builder.create().show()
    }
}