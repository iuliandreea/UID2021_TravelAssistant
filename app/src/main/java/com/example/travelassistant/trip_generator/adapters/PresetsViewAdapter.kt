package com.example.travelassistant.trip_generator.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.transportation.adapters.OnItemClickListener
import com.example.travelassistant.transportation.adapters.TransportViewHolder
import com.example.travelassistant.transportation.transport.Transport
import com.example.travelassistant.trip_generator.trip.Trip

class PresetsViewAdapter(private val context: Context,
                         private val dataSource: ArrayList<Trip>) : RecyclerView.Adapter<PresetsViewHolder>() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private lateinit var mListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    private lateinit var lListener: OnItemLongClickListener

    fun setOnItemLongClickListener(listener: OnItemLongClickListener) {
        lListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresetsViewHolder {
        val view = inflater.inflate(viewType, parent, false)
        return PresetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PresetsViewHolder, position: Int) {
        holder.bindData(dataSource[position], mListener, lListener)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun getItemViewType(position: Int) : Int {
        return R.layout.activity_presets_elem
    }
}