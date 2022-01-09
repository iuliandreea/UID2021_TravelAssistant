package com.example.travelassistant.trip_generator.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.transportation.adapters.OnItemClickListener
import com.example.travelassistant.transportation.transport.Transport
import com.example.travelassistant.trip_generator.trip.Trip
import org.w3c.dom.Text

class PresetsViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {

    private var nameId: TextView = view.findViewById(R.id.nameId)
    private var priceId: TextView = view.findViewById(R.id.priceId)
    private var imageId: ImageView = view.findViewById(R.id.imageId)

    fun bindData(data: Trip, listener: OnItemClickListener, listener2: OnItemLongClickListener) {
        nameId.text = data.name
        priceId.text = (data.price.toString() + " EUR")
        imageId.setImageResource(data.image)

        view.setOnClickListener {
            listener.onItemClick(view, adapterPosition)
        }

        view.setOnLongClickListener {
            listener2.onItemLongClick(view, adapterPosition)
        }
    }
}