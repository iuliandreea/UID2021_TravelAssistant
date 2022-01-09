package com.example.travelassistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VisitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VisitFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val views = inflater.inflate(R.layout.fragment_visit, container, false)
        val btSearch: Button = views.findViewById(R.id.button5)
        val recyclerView: RecyclerView = views.findViewById(R.id.visit_recycler)
        recyclerView.visibility = View.INVISIBLE

        val context = context
        val recyclerAdapter: AttractionRecyclerAdapter = AttractionRecyclerAdapter(context)
        recyclerView.adapter = recyclerAdapter
        val listOfItems: List<Attraction> =
            listOf(
                Attraction(
                    "1",
                    "Museo D’Orsay",
                    "1 Rue de la Légion d'Honneur, 75007 Paris, France",
                    "9",
                    "The museum building was originally a railway station, Gare d'Orsay, located next to the Seine river. Built on the site of the old Palais d'Orsay, its central location was convenient for commuting travelers.",
                    "+33 1 55 37 20 00",
                    R.drawable.museam1
                ),
                Attraction(
                    "2",
                    "Parc naturel régional de la Forêt d'Orient",
                    " La Maison du Parc, 10220 Piney, France",
                    "-",
                    "The parkland encompasses the large Forêt d'Orient National Nature Reserve and three man-made lakes: Lac d'Orient, Lac du Temple, and Lac Amance.",
                    "+33 1 86 76 69 02",
                    R.drawable.parc
                ),
                Attraction(
                    "3",
                    "La Cité du Vin Skip-the-Line",
                    "Quai de Bacalan, 33300 Bordeaux, France",
                    "30",
                    "Located in the city of Bordeaux, on the banks of the Garonne, La Cité du Vin is a unique cultural venue open to all and dedicated to wine as a cultural, universal and living heritage. Take in views from the 8th-floor belvedere and taste some fine wines.",
                    "+33 1 86 76 69 02",
                    R.drawable.vin
                ),
                Attraction(
                    "4",
                    "Disneyland Paris ",
                    "Bd de Parc, 77700 Coupvray, France",
                    "100",
                    "Enjoy a magical time at Disneyland® Paris. Choose to access Walt Disney Studios® Park or Disneyland® Park or both if the option is selected.",
                    "+33 1 55 37 20 00",
                    R.drawable.disney
                )
            )
        recyclerAdapter.setAttractionListItems(listOfItems)
        recyclerView.layoutManager = LinearLayoutManager(activity);
        btSearch.setOnClickListener {
            recyclerView.visibility = View.VISIBLE
        }
        return views

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VisitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VisitFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}