package com.example.travelassistant.trip_generator.adapters

import android.view.View

interface OnItemLongClickListener {

    fun onItemLongClick(view: View, position: Int) : Boolean
}