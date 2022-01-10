package com.example.travelassistant.transportation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.travelassistant.R
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

import androidx.annotation.NonNull
import androidx.navigation.findNavController


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransportFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var to: String = ""
    private var from: String = ""

    private var price: Int = 0
    private var type: String = ""

    private var accountId: Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_transport, container, false)

        val args = arguments
        if(args != null) {
            to = args.getString("to", "")
            from = args.getString("from", "")
            accountId = args.getInt("accountId")
        }

        if(to != "" && from != "") {
            view.findViewById<EditText>(R.id.destinationId).setText(to)
            view.findViewById<EditText>(R.id.yourLocationId).setText(from)

            val priceSlider: RangeSlider = view.findViewById(R.id.priceSliderId)
            val radios : RadioGroup = view.findViewById(R.id.radioGroup)

            priceSlider.addOnChangeListener(RangeSlider.OnChangeListener { slider, value, fromUser ->
                price = value.toInt()
            })

            val searchButton : Button = view.findViewById(R.id.searchButton)
            searchButton.setOnClickListener {
                val selected = view.findViewById<RadioButton>(radios.checkedRadioButtonId)
                if (selected != null)
                    type = selected.text.toString()

                val bundle = Bundle()
                bundle.putString("from", from)
                bundle.putString("to", to)
                bundle.putInt("price", price)
                bundle.putString("type", type)
                bundle.putInt("accountId", accountId)
                view.findNavController().navigate(R.id.transportDetailsFragment, bundle)
            }

            val btn: Button = view.findViewById(R.id.signOutButton)
            btn.setOnClickListener {
                view.findNavController().navigate(R.id.exploreFragment)
            }
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransportFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransportFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}