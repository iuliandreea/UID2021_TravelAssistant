package com.example.travelassistant.trip_generator.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.favorites.favorite.FavoritesList
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.transportation.adapters.OnItemClickListener
import com.example.travelassistant.transportation.adapters.TransportViewAdapter
import com.example.travelassistant.transportation.transport.Transport
import com.example.travelassistant.trip_generator.adapters.OnItemLongClickListener
import com.example.travelassistant.trip_generator.adapters.PresetsViewAdapter
import com.example.travelassistant.trip_generator.trip.PresetsList
import com.example.travelassistant.trip_generator.trip.Trip

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PresetsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PresetsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var data: ArrayList<Trip>
    private lateinit var adapter: PresetsViewAdapter
    private var accountId: Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_presets, container, false)

        val args = arguments
        if(args != null) {
            accountId = args.getInt("accountId")
        }

        var recyclerView: RecyclerView = view.findViewById(R.id.presetsView)

        data = PresetsList.getPresets()
        val layoutManager: LinearLayoutManager = LinearLayoutManager(view.context)
        adapter = PresetsViewAdapter(view.context, data)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val preset = data[position]

                val bundle = Bundle()
                bundle.putString("name", preset.name)
                bundle.putInt("price", preset.price)
                bundle.putString("activities", preset.activities)
                bundle.putString("transport", preset.transport)
                bundle.putString("restaurants", preset.restaurants)
                bundle.putString("locations", preset.locations)
                bundle.putInt("image", preset.image)
                bundle.putInt("accountId", accountId)
                view.findNavController().navigate(R.id.presetsDetailsFragment, bundle)
            }
        })

        adapter.setOnItemLongClickListener(object : OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int): Boolean {
                if (accountId == -1) {
                    showErrorDialog(view)
                }
                else {
                    showDialog(view, position)
                }
                return true
            }
        })

        return view
    }

    private fun showDialog(view: View, position: Int) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Add to Favorites")
            .setMessage("Would you like to add this trip to favorites?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                FavoritesList.addFavorite(data[position])
                Toast.makeText(view.context, "Trip added to favorites", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }

    private fun showErrorDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Cannot add to Favorites")
            .setMessage("Please Sign In in order to add to favorites")
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PresetsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PresetsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}