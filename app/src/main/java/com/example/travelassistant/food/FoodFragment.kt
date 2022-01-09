package com.example.travelassistant.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.food.RestaurantRecyclerViewAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [favouriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var restaurantRecyclerViewAdapter: RestaurantRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val views = inflater.inflate(R.layout.activity_food, container, false)
        recyclerView = views.findViewById(R.id.restaurantRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(views.context, RecyclerView.VERTICAL, false)
        restaurantRecyclerViewAdapter = RestaurantRecyclerViewAdapter()
        restaurantRecyclerViewAdapter.loadRestaurants()
        recyclerView.adapter = restaurantRecyclerViewAdapter
        restaurantRecyclerViewAdapter.notifyDataSetChanged()


        /*
        var recyclerView: RecyclerView = view.findViewById(R.id.transportView)

        val layoutManager: LinearLayoutManager = LinearLayoutManager(view.context)
        adapter = TransportViewAdapter(view.context, dataSource)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
         */
        return views
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    /*companion object {
        *//**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment favouriteFragment.
         *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            *//*favouriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*//*
    }*/

}