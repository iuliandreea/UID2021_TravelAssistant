package com.example.travelassistant.wardrobe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R

class WeatherRecyclerAdapter(val context: Context?) : RecyclerView.Adapter<WeatherRecyclerAdapter.MyViewHolder>() {
    var weatherList: List<Weather> = listOf()

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val day: TextView = itemView!!.findViewById(R.id.dayID)
        val rain: TextView = itemView!!.findViewById(R.id.rainID)
        val wind: TextView = itemView!!.findViewById(R.id.windID)
        val sun: TextView = itemView!!.findViewById(R.id.sunID)
        val grade: TextView = itemView!!.findViewById(R.id.gradeID)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.content_weather, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.day.text = weatherList.get(position).id.toString()
        holder.sun.text = weatherList.get(position).sun
        holder.rain.text = weatherList.get(position).rain
        holder.wind.text = weatherList.get(position).wind
        holder.grade.text = weatherList.get(position).grade.toString()
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun setWeatherListItems(questionsList: List<Weather>) {
        this.weatherList = questionsList;
        notifyDataSetChanged()
    }
}