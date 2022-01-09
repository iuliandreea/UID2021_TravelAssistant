package com.example.travelassistant

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_explore, container, false)
        val findViewById = views.findViewById<Button>(R.id.button3)


        findViewById?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {
                val intent = Intent(context, WardrobeActivity::class.java)
                validateInput(views, intent);
            }
        })
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
    }

    fun validateInput(views: View, intent: Intent) {
        val dateStr = views.findViewById<EditText>(R.id.checkIn)
        val dateStr1 = views.findViewById<EditText>(R.id.checkOut)
        val destination = views.findViewById<EditText>(R.id.destination)
        val dest = destination.text.toString()
        if (dest.equals("Destination") || dest.trim().equals("")) {

            displayErrorMessage("Invalid Destination!")

        } else {

            var formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
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
                            startActivity(intent)
                        } catch (e: Exception) {
                            displayErrorMessage("invalid date out")
                        }
                    }
                }
            } catch (e: Exception) {
                displayErrorMessage("invalid date in")
            }

        }
    }
}
