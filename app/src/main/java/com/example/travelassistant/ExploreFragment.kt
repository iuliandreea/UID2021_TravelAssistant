package com.example.travelassistant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.travelassistant.profile_management.fragments.EditProfileFragment

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

    private lateinit var from: EditText
    private lateinit var to: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val args: ExploreFragmentArgs by navArgs()
        Log.println(Log.ERROR, "HELLO", args.toString())
        val accountId = args.accountId
        Log.println(Log.ERROR, "ACCOUNTID", accountId.toString())

        from = view.findViewById(R.id.yourLocationId)
        to = view.findViewById(R.id.destinationId)

        val transportButton: Button = view.findViewById(R.id.transportButton)
        transportButton.setOnClickListener {
            if (validateLocations(view)) {
                val bundle = Bundle()
                bundle.putString("from", from.text.toString())
                bundle.putString("to", to.text.toString())
                view.findNavController().navigate(R.id.transportFragment, bundle)
            }
        }

        val foodButton: Button = view.findViewById(R.id.foodButton)
        foodButton.setOnClickListener {
            if (validateLocations(view)) {
                view.findNavController().navigate(R.id.foodFragment)
            }
        }

        return view
    }

    private fun validateLocations(view: View): Boolean {
        var valid = true

        if (from.text.toString() == "") {
            from.error = "Cannot be empty"
            from.requestFocus()
            valid = false
        }

        if (to.text.toString() == "") {
            to.error = "Cannot be empty"
            to.requestFocus()
            valid = false
        }

        return valid
        val views = inflater.inflate(R.layout.fragment_explore, container, false)
        val findViewById = views.findViewById<Button>(R.id.button2)
        findViewById?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {
                val intent = Intent(context, AccommodationActivity::class.java)
                startActivity(intent)
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


}
