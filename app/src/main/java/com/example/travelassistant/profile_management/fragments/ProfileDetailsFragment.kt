package com.example.travelassistant.profile_management.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.travelassistant.R
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.profile_management.account.Account
import com.example.travelassistant.profile_management.account.AccountList
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.travelassistant.MainActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileDetailsFragment : Fragment() {

    lateinit var account: Account
    private var accountId: Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_profile_details, container, false)

        val args = arguments
        if(args != null) {
            accountId = args.getInt("accountId")
        }

        Log.println(Log.ERROR, "ACCOUNTID Details", accountId.toString())

        if(accountId != -1) {

            account = AccountList.getAccount(accountId)

            view.findViewById<TextView>(R.id.nameId).text = account.fullName
            view.findViewById<TextView>(R.id.emailId).text = account.email
            view.findViewById<ImageView>(R.id.imageId).setImageResource(R.drawable.woman_profile)

            val edit = view.findViewById<Button>(R.id.editProfileButton)
            val currentTrip = view.findViewById<TextView>(R.id.currentTripId)
            val budget = view.findViewById<TextView>(R.id.BudgetTrackerId)
            val signOut = view.findViewById<Button>(R.id.signOutButton)

            signOut.setOnClickListener {
                val myIntent = Intent(view.context, MainActivity::class.java)
                startActivity(myIntent)
            }


            edit.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("accountId", accountId)
                view.findNavController().navigate(R.id.editProfileFragment, bundle)
            }

            currentTrip.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("accountId", accountId)
                view.findNavController().navigate(R.id.organizationFragment, bundle)
            }

            budget.setOnClickListener {
                // add activity intent for budget tracker
            }
        }
        else {
            showNotLoggedInDialog(view)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(accountId: Int) =
            ProfileDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt("accountId", accountId)
                }
            }
    }

    private fun showNotLoggedInDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Cannot view profile")
            .setMessage("Please Sign In in order to view your account")
            .setPositiveButton("Sign In", DialogInterface.OnClickListener { _, _ ->
                val myIntent = Intent(view.context, SignInActivity::class.java)
                startActivity(myIntent)
            })
            .setNegativeButton("Dismiss", DialogInterface.OnClickListener { _, _ ->
                val navController = findNavController()
                navController.navigate(R.id.exploreFragment)
            })
        builder.create().show()
    }
}