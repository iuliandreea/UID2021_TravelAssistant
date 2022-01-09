package com.example.travelassistant

import android.app.AlertDialog
import android.content.DialogInterface
<<<<<<< HEAD
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
=======
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import androidx.navigation.findNavController
=======
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.travelassistant.profile_management.fragments.EditProfileFragment
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
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

<<<<<<< HEAD
=======
    private lateinit var from: EditText
    private lateinit var to: EditText

>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(

<<<<<<< HEAD
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_explore, container, false)
        val findViewById = views.findViewById<Button>(R.id.button3)

        findViewById.setOnClickListener {
            if (validateInput(views)) {
                views.findNavController().navigate(R.id.wardrobeFragment)
            }
        }

        return views
//        // Inflate the layout for this fragment
        return views
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExploreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExploreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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
=======
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
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

        return view
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
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
    }

    fun validateInput(views: View): Boolean {
        val dateStr = views.findViewById<EditText>(R.id.checkIn)
        val dateStr1 = views.findViewById<EditText>(R.id.checkOut)
<<<<<<< HEAD
        val destination = views.findViewById<EditText>(R.id.destination)
=======
        val destination = views.findViewById<EditText>(R.id.destinationId)
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
        val dest = destination.text.toString()
        if (dest.equals("Destination") || dest.trim().equals("")) {

            displayErrorMessage("Invalid Destination!")

        } else {

<<<<<<< HEAD
            var formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
=======
            /*var formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
            try {

                val date = formatter.parse(dateStr.text.toString())
                if (dateStr.text.toString().length != 10) {

<<<<<<< HEAD
                    displayErrorMessage("Invalid date in")
=======
                    // displayErrorMessage("Invalid date in")
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae

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
<<<<<<< HEAD
                    }
                }
            } catch (e: Exception) {
                displayErrorMessage("invalid date in")

            }
=======
                    }*/

             /*catch (e: Exception) {
                displayErrorMessage("invalid date in")

            }*/
            return true
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae

        }
        return false
    }
<<<<<<< HEAD
=======

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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExploreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExploreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
}
