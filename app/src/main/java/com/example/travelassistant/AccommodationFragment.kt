package com.example.travelassistant

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccommodationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccommodationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val views = inflater.inflate(R.layout.fragment_accommodation, container, false)
        val btSearch: Button = views.findViewById(R.id.button5)
        val noAdults: EditText = views.findViewById(R.id.editTextNumber3)

        val recyclerView: RecyclerView = views.findViewById(R.id.hotel_recycler)
        recyclerView.visibility = View.INVISIBLE

        val context = context
        val recyclerAdapter: HotelRecyclerAdapter = HotelRecyclerAdapter(context)
        recyclerView.adapter = recyclerAdapter
        val listOfItems: List<Accommodation> =
            listOf(
                Accommodation(
                    "1",
                    "Hotel Harvey",
                    "Hotel Harvey 7 Bis Rue du Debarcadère Paris 75017 France",
                    "156",
                    "+33 1 55 37 20 00",
                    R.drawable.hotel1
                ),
                Accommodation(
                    "2",
                    "Hotel de Londres Eiffel",
                    "1 rue Augereau, 75007 Paris France",
                    "230",
                    "+33 1 86 76 69 02",
                    R.drawable.hotel2
                ),
                Accommodation(
                    "3",
                    "The Hoxton",
                    "30-32 Rue du Sentier, 75002 Paris France",
                    "320",
                    "+33 1 86 76 69 02",
                    R.drawable.hotel3
                ),
                Accommodation(
                    "4",
                    "Hotel Soft",
                    "52 B rue des Vinaigriers, 75010 Paris France",
                    "100",
                    "+33 1 55 37 20 00",
                    R.drawable.hotel4
                )
            )
        recyclerAdapter.setHotelsListItems(listOfItems)
        recyclerView.layoutManager = LinearLayoutManager(activity);
        btSearch.setOnClickListener {
            if (!noAdults.text.toString().equals("")) {
                recyclerView.visibility = View.VISIBLE
            } else {

                displayErrorMessage("Set the number of persons!")
            }
        }
        return views


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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccommodationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccommodationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}