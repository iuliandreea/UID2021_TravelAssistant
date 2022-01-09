package com.example.travelassistant.trip_generator.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.travelassistant.R
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_presets_details, container, false)

        val args = arguments
        if(args != null) {
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

        return view
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