package com.example.travelassistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WardrobeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WardrobeFragment : Fragment() {
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
        // Inflate the layout for this fragment
        val views = inflater.inflate(R.layout.fragment_wardrobe, container, false)
        val recyclerView: RecyclerView = views.findViewById(R.id.weather_recycler)
        val recyclerAdapter: WeatherRecyclerAdapter = WeatherRecyclerAdapter(context)
        recyclerView.adapter = recyclerAdapter
        val listOfItems: List<Weather> =
            listOf(
                Weather(1, 23, "23%", "78%", "34%"),
                Weather(2, 26, "29%", "75%", "23%"),
                Weather(3, 24, "30%", "73%", "31%"),
                Weather(4, 27, "14%", "68%", "37%")
            )
        recyclerAdapter.setWeatherListItems(listOfItems)
        recyclerView.layoutManager = LinearLayoutManager(context);
        return views
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WardrobeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WardrobeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}