package com.example.travelassistant.transportation.adapters

import android.view.View

interface OnItemLongClickListener {

    fun onItemLongClick(view: View, position: Int) : Boolean
}