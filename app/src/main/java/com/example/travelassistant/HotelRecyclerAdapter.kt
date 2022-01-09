package com.example.travelassistant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HotelRecyclerAdapter(val context: Context?) : RecyclerView.Adapter<HotelRecyclerAdapter.MyViewHolder>() {
    var hotelsList: List<Accommodation> = listOf()

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val id: TextView = itemView!!.findViewById(R.id.id)
        val name: TextView = itemView!!.findViewById(R.id.name)
        val address: TextView = itemView!!.findViewById(R.id.adress)
        val price: TextView = itemView!!.findViewById(R.id.price)
        val contact: TextView = itemView!!.findViewById(R.id.contact)
        val image:ImageView = itemView!!.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.accommodation_content, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = hotelsList.get(position).id
        holder.name.text = hotelsList.get(position).name
        holder.address.text = hotelsList.get(position).address
        holder.price.text = hotelsList.get(position).price + " EUR"
        holder.contact.text = hotelsList.get(position).contact
        holder.image.setImageResource(hotelsList.get(position).image)
    }

    override fun getItemCount(): Int {
        return hotelsList.size
    }

    fun setHotelsListItems(list: List<Accommodation>) {
        this.hotelsList = list;
        notifyDataSetChanged()
    }
}