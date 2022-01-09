package com.example.travelassistant

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.travelassistant.profile_management.fragments.EditProfileFragment
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var from: EditText
    private lateinit var to: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val args: ExploreFragmentArgs by navArgs()
        Log.println(Log.ERROR, "HELLO", args.toString())
        val accountId = args.accountId
        Log.println(Log.ERROR, "ACCOUNTID", accountId.toString())

        from = view.findViewById(R.id.yourLocationId)
        to = view.findViewById(R.id.destinationId)

        val transportButton: Button = view.findViewById(R.id.transportButton)
        transportButton.setOnClickListener {
            if (validateLocations(view)) {
                val bundle = Bundle()
                bundle.putString("from", from.text.toString())
                bundle.putString("to", to.text.toString())
                view.findNavController().navigate(R.id.transportFragment, bundle)
            }
        }

        val foodButton: Button = view.findViewById(R.id.foodButton)
        foodButton.setOnClickListener {
            if (validateLocations(view)) {
                view.findNavController().navigate(R.id.foodFragment)
            }
        }

        val accomodationBtn = view.findViewById<Button>(R.id.accommodationButton)
        accomodationBtn.setOnClickListener {
            if (validateInput(view)) {
                view.findNavController().navigate(R.id.accommodationFragment)
            }
        }

        val wardrobeBtn = view.findViewById<Button>(R.id.wardrobeButton)
        wardrobeBtn.setOnClickListener {
            if (validateInput(view)) {
                view.findNavController().navigate(R.id.wardrobeFragment)
            }
        }

        val visitBtn = view.findViewById<Button>(R.id.button4)
        visitBtn.setOnClickListener {
            if (validateInput(view)) {
                view.findNavController().navigate(R.id.visitFragment)
            }
        }
        return view
    }

    fun displayErrorMessage(message: String) {
        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {

                    }
                }
            }
        println(message)
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setMessage(message)
            .setPositiveButton("OK", dialogClickListener)
            .show()
    }

    private fun validateLocations(view: View): Boolean {
        var valid = true

        if (from.text.toString() == "") {
            from.error = "Cannot be empty"
            from.requestFocus()
            valid = false
        }

        if (to.text.toString() == "") {
            to.error = "Cannot be empty"
            to.requestFocus()
            valid = false
        }

        return valid
    }

    fun validateInput(views: View): Boolean {
        val dateStr = views.findViewById<EditText>(R.id.checkIn)
        val dateStr1 = views.findViewById<EditText>(R.id.checkOut)
        val destination = views.findViewById<EditText>(R.id.destinationId)
        val dest = destination.text.toString()
        if (dest.equals("Destination") || dest.trim().equals("")) {

            displayErrorMessage("Invalid Destination!")

        } else {

            /*var formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            try {

                val date = formatter.parse(dateStr.text.toString())
                if (dateStr.text.toString().length != 10) {
                    displayErrorMessage("Invalid date in")

                } else {
                    println(date.toString())

                    if (dateStr1.text.toString().length != 10) {

                        displayErrorMessage("Invalid date out")

                    } else {
                        try {
                            val date1 = formatter.parse(dateStr1.text.toString())
                            println(date1.toString())
                            return true
                        } catch (e: Exception) {
                            displayErrorMessage("invalid date out")

                        }
                    }
                }
            } catch (e: Exception) {
                displayErrorMessage("invalid date in")

            }
                    }*/

             /*catch (e: Exception) {
                displayErrorMessage("invalid date in")

            }*/
            return true

        }
        return false
    }
}
