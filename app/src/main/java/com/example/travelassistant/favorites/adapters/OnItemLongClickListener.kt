package com.example.travelassistant.favorites.adapters

import android.view.View

interface OnItemLongClickListener {

    fun onItemLongClick(view: View, position: Int) : Boolean
}