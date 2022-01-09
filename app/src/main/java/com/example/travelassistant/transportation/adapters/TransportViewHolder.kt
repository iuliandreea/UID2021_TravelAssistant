package com.example.travelassistant.transportation.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.transportation.transport.Transport

class TransportViewHolder (private val view: View) : RecyclerView.ViewHolder(view)  {

        private var priceId: TextView = view.findViewById(R.id.priceId)
        private var companyId: TextView = view.findViewById(R.id.companyId)
        private var leavingTime: TextView = view.findViewById(R.id.leavingTimeId)
        private var arrivaltime: TextView = view.findViewById(R.id.arrivalTimeId)

        fun bindData(data: Transport, listener: OnItemClickListener) {
                priceId.text = data.price.toString()
                companyId.text = data.company
                leavingTime.text = data.leavingTime
                arrivaltime.text = data.arrivalTime

                view.setOnClickListener {
                        listener.onItemClick(view, adapterPosition)
                }
        }
}