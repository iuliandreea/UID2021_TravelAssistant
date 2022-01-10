package com.example.travelassistant.transportation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R
import com.example.travelassistant.transportation.transport.Transport

class TransportViewAdapter(
    private val context: Context,
    private val dataSource: ArrayList<Transport>) : RecyclerView.Adapter<TransportViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportViewHolder {
        val view = inflater.inflate(viewType, parent, false)
        return TransportViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransportViewHolder, position: Int) {
        holder.bindData(dataSource[position], mListener, lListener)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun getItemViewType(position: Int) : Int {
        return R.layout.transport_details_elem
    }
}