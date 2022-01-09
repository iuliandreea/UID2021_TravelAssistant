package com.example.travelassistant.favorites.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.favorites.adapters.FavoritesViewAdapter
import com.example.travelassistant.favorites.favorite.FavoritesList
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.transportation.adapters.OnItemClickListener
import com.example.travelassistant.trip_generator.adapters.PresetsViewAdapter
import com.example.travelassistant.trip_generator.trip.PresetsList
import com.example.travelassistant.trip_generator.trip.Trip

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var data: ArrayList<Trip>
    private lateinit var adapter: FavoritesViewAdapter
    private var accountId: Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_favorites, container, false)

        var recyclerView: RecyclerView = view.findViewById(R.id.favoritesView)

        data = FavoritesList.getFavorites()
        val layoutManager: LinearLayoutManager = LinearLayoutManager(view.context)
        adapter = FavoritesViewAdapter(view.context, data)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        val args = arguments
        if(args != null) {
            accountId = args.getInt("accountId")
        }

        if (accountId == -1) {
            showNotLoggedInDialog(view)
        }

        return view
    }

    private fun showNotLoggedInDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Cannot view Favorites")
            .setMessage("Please Sign In in order to view your saved favorites")
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
         * @return A new instance of fragment FavoritesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoritesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}