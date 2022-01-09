package com.example.travelassistant.favorites.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.transportation.adapters.OnItemClickListener
import com.example.travelassistant.trip_generator.adapters.PresetsViewHolder
import com.example.travelassistant.trip_generator.trip.Trip

class FavoritesViewAdapter(private val context: Context,
                           private val dataSource: ArrayList<Trip>) : RecyclerView.Adapter<FavoritesViewHolder>() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = inflater.inflate(viewType, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bindData(dataSource[position])
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.activity_favorites_elem
    }
}