package com.example.travelassistant.attraction

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R

class AttractionRecyclerAdapter(val context: Context?) :
    RecyclerView.Adapter<AttractionRecyclerAdapter.MyViewHolder>() {
    var attractionList: List<Attraction> = listOf()

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val id: TextView = itemView!!.findViewById(R.id.id)
        val name: TextView = itemView!!.findViewById(R.id.name)
        val address: TextView = itemView!!.findViewById(R.id.address)
        val price: TextView = itemView!!.findViewById(R.id.entryPrice)
        val contact: TextView = itemView!!.findViewById(R.id.contact)
        val description: TextView = itemView!!.findViewById(R.id.description)
        val image: ImageView = itemView!!.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.attraction_content, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = attractionList.get(position).id
        holder.name.text = attractionList.get(position).name
        holder.address.text = attractionList.get(position).address
        holder.price.text = attractionList.get(position).price + " EUR"
        holder.contact.text = attractionList.get(position).contact
        holder.description.text = attractionList.get(position).description
        holder.image.setImageResource(attractionList.get(position).image)
    }

    override fun getItemCount(): Int {
        return attractionList.size
    }

    fun setAttractionListItems(list: List<Attraction>) {
        this.attractionList = list;
        notifyDataSetChanged()
    }
}