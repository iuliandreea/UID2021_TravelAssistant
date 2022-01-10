package com.example.travelassistant.transportation.adapters

import android.content.DialogInterface
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.transportation.transport.Transport

class TransportViewHolder (private val view: View) : RecyclerView.ViewHolder(view)  {

        private var priceId: TextView = view.findViewById(R.id.priceId)
        private var companyId: TextView = view.findViewById(R.id.companyId)
        private var leavingTime: TextView = view.findViewById(R.id.leavingTimeId)
        private var arrivaltime: TextView = view.findViewById(R.id.arrivalTimeId)
        // private var button: Button = view.findViewById(R.id.officialButton)

        fun bindData(data: Transport, listener: OnItemClickListener, listener2: OnItemLongClickListener) {
                priceId.text = data.price.toString()
                companyId.text = data.company
                leavingTime.text = data.leavingTime
                arrivaltime.text = data.arrivalTime

                view.setOnClickListener {
                        listener.onItemClick(view, adapterPosition)
                }

                view.setOnLongClickListener {
                        listener2.onItemLongClick(view, adapterPosition)
                }

                /*button.setOnClickListener {
                        val builder = AlertDialog.Builder(view.context)
                        builder.setTitle("")
                                .setMessage("Would you like to add this transportation to favorites?")
                                .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                                        Toast.makeText(view.context, "Transportation added to favorites", Toast.LENGTH_SHORT).show()
                                })
                                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                                        dialog.dismiss()
                                })
                        builder.create().show()
                }*/
        }
}