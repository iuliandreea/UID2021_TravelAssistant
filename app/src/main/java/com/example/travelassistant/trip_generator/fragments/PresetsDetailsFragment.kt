package com.example.travelassistant.trip_generator.fragments

import android.content.DialogInterface
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.travelassistant.R
import com.example.travelassistant.favorites.favorite.FavoritesList
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.trip_generator.trip.Trip
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PresetsDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PresetsDetailsFragment : Fragment() {
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

    /*
    bundle.putString("name", preset.name)
                bundle.putInt("price", preset.price)
                bundle.putString("activities", preset.activities)
                bundle.putString("transport", preset.transport)
                bundle.putString("restaurants", preset.restaurants)
                bundle.putString("locations", preset.locations)
                bundle.putInt("image", preset.image)
     */

    var name: String = ""
    var price: Int = 0
    var activities: String = ""
    var transport: String = ""
    var restaurants: String = ""
    var locations: String = ""
    var image: Int = 0

    private var accountId: Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_presets_details, container, false)

        val args = arguments
        if(args != null) {
            accountId = args.getInt("accountId")
            name = args.getString("name" ,"")
            price = args.getInt("price")
            activities = args.getString("activities", "")
            transport = args.getString("transport", "")
            restaurants = args.getString("restaurants", "")
            locations = args.getString("locations", "")
            image = args.getInt("image")
        }

        view.findViewById<TextView>(R.id.nameId).text = name
        view.findViewById<TextView>(R.id.priceId).text = (price.toString() + " EUR")
        view.findViewById<TextView>(R.id.activitiesId).text = activities
        view.findViewById<TextView>(R.id.transportId).text = transport
        view.findViewById<TextView>(R.id.restaurantsId).text = restaurants
        view.findViewById<TextView>(R.id.locationsId).text = locations
        view.findViewById<ImageView>(R.id.imageId).setImageResource(image)

        val btn: Button = view.findViewById(R.id.saveButton)
        btn.setOnClickListener {
            if(accountId == -1) {
                showErrorDialog(view)
            }
            else {
                showDialog(view)
            }
        }

        val btn2: Button = view.findViewById(R.id.signOutButton)
        btn2.setOnClickListener {
            view.findNavController().navigate(R.id.presetsFragment)
        }

        return view
    }

    private fun showDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Add to Favorites")
            .setMessage("Would you like to add this trip to favorites?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                FavoritesList.addFavorite(Trip(name, price, locations, activities, transport, restaurants, image))
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
         * @return A new instance of fragment PresetsDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PresetsDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}