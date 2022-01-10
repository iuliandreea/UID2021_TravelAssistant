package com.example.travelassistant.transportation.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.favorites.favorite.FavoritesList
import com.example.travelassistant.profile_management.SignInActivity
import com.example.travelassistant.transportation.adapters.OnItemClickListener
import com.example.travelassistant.transportation.adapters.OnItemLongClickListener
import com.example.travelassistant.transportation.adapters.TransportViewAdapter
import com.example.travelassistant.transportation.transport.Transport
import com.example.travelassistant.transportation.transport.TransportList
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.stream.Collectors

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransportDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransportDetailsFragment : Fragment(), OnMapReadyCallback  {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var data: ArrayList<Transport>
    private lateinit var adapter: TransportViewAdapter

    private lateinit var from: String
    private lateinit var to: String
    private var price: Int = 0
    private lateinit var type: String

    private var accountId: Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_transport_details, container, false)

        view.findViewById<ImageView>(R.id.mapView).setImageResource(R.drawable.map)

        val args = arguments
        if(args != null) {
            to = args.getString("to", "")
            from = args.getString("from", "")
            price = args.getInt("price")
            type = args.getString("type", "")
            accountId = args.getInt("accountId")
        }

        Log.println(Log.ERROR, "to", to)
        Log.println(Log.ERROR, "from", from)
        Log.println(Log.ERROR, "price", price.toString())
        Log.println(Log.ERROR, "type", type)

        data = TransportList.getTransport()
        val dataSource = filterDataSource()
        var recyclerView: RecyclerView = view.findViewById(R.id.transportView)

        val layoutManager: LinearLayoutManager = LinearLayoutManager(view.context)
        adapter = TransportViewAdapter(view.context, dataSource)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                if (accountId == -1) {
                    showErrorDialog(view)
                }
                else {
                    showAddToTripDialog(view)
                }
            }
        })

        adapter.setOnItemLongClickListener(object : OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int): Boolean {
                if (accountId == -1) {
                    showErrorDialog(view)
                }
                else {
                    showDialog(view)
                }
                return true
            }

        })


        val btn: Button = view.findViewById(R.id.signOutButton)
        btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("from", from)
            bundle.putString("to", to)
            view.findNavController().navigate(R.id.transportFragment, bundle)
        }

        /*
        Button btn = (Button) findViewById(R.id.btn_clickme);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.anddev.org"));
                    startActivity(myWebLink);
             }
        });
         */

        return view
    }

    private fun showDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Add to Favorites")
            .setMessage("Would you like to add this transportation to favorites?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(view.context, "Transportation added to favorites", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }

    private fun showAddToTripDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Add to My Trip")
            .setMessage("Would you like to add this transportation to your current trip?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(view.context, "Transportation added to My Trip", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }

    private fun showErrorDialog(view: View) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Cannot add Trip")
            .setMessage("Please Sign In in order to add to add the Trip")
            .setPositiveButton("Sign In", DialogInterface.OnClickListener { _, _ ->
                val myIntent = Intent(view.context, com.example.travelassistant.profile_management.activities.SignInActivity::class.java)
                startActivity(myIntent)
            })
            .setNegativeButton("Dismiss", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
        builder.create().show()
    }

    private fun filterDataSource(): ArrayList<Transport> {
        var dataSource = data.stream().filter {
            it.price <= price && it.from.lowercase() == from.lowercase() && it.to.lowercase() == to.lowercase()
                    && it.type.lowercase() == type.lowercase()
        }.collect(Collectors.toList())
        var dataArrayList = arrayListOf<Transport>()
        dataArrayList.addAll(dataSource)
        return dataArrayList
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransportDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransportDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(0.0, 0.0))
                .title("Marker")
        )
    }
}