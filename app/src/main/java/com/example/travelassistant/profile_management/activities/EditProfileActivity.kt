package com.example.travelassistant.profile_management.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.travelassistant.MainActivity
import com.example.travelassistant.R
import com.example.travelassistant.profile_management.account.Account
import com.example.travelassistant.profile_management.account.AccountList
import java.util.regex.Pattern

class EditProfileActivity : AppCompatActivity() {

    lateinit var account: Account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val accountId = intent.getIntExtra("accountId", -1)
        account = AccountList.getAccount(accountId)

        findViewById<TextView>(R.id.displayNameId).text = account.fullName
        findViewById<EditText>(R.id.nameId).setText(account.fullName)
        findViewById<EditText>(R.id.emailId).setText(account.email)
        findViewById<EditText>(R.id.currPasswordId).setText(account.password)

        val signOut = findViewById<Button>(R.id.signOutButton)
        val saveChanges = findViewById<Button>(R.id.saveButton)
        val deleteAccount = findViewById<Button>(R.id.deleteAccountButton)
        val changePhoto = findViewById<TextView>(R.id.changePhotoId)

        signOut.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

        saveChanges.setOnClickListener {
            val fullName = findViewById<EditText>(R.id.nameId)
            val email = findViewById<EditText>(R.id.emailId)
            val password = findViewById<EditText>(R.id.newPasswordId)

            if (validateCredentials(fullName, email, password)) {
                showUpdateDialog(accountId, email.text.toString(), password.text.toString(), fullName.text.toString())
            }
        }

        deleteAccount.setOnClickListener {
            showDeleteDialog(accountId)
        }

        changePhoto.setOnClickListener {
            // idk
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

    private fun showUpdateDialog(accountId: Int, email: String, password: String, fullName: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Save Changes")
            .setMessage("Are you sure you want to update your account?")
            .setPositiveButton("Confirm", DialogInterface.OnClickListener { _, _ ->
                AccountList.setAccount(accountId, Account(email, password, fullName))
                Toast.makeText(this, "Account updated successfully!", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }

    private fun showDeleteDialog(accountId: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Account")
            .setMessage("Are you sure you want to delete your account?")
            .setPositiveButton("Confirm", DialogInterface.OnClickListener { _, _ ->
                AccountList.removeAccount(accountId)
                Toast.makeText(this, "Account deleted successfully!", Toast.LENGTH_SHORT).show()
                /*val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)*/
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }

}