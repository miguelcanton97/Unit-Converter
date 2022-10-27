package com.miguelcanton.unitconverter.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.miguelcanton.unitconverter.domain.UnitField
import com.miguelcanton.unitconverter.databinding.ItemFieldBinding

class UnitConverterAdapter(private val unitClickListener: (UnitField) -> Unit) :
    ListAdapter<UnitField, UnitFieldViewHolder>(DiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitFieldViewHolder {
        val binding = ItemFieldBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UnitFieldViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UnitFieldViewHolder, position: Int) {
        val unitConverter = getItem(position)
        holder.bind(unitConverter, unitClickListener)
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<UnitField>() {
    override fun areItemsTheSame(oldItem: UnitField, newItem: UnitField): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: UnitField, newItem: UnitField): Boolean {
        return oldItem == newItem
    }
}
