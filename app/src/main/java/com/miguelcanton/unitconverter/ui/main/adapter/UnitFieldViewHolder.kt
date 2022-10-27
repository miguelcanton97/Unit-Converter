package com.miguelcanton.unitconverter.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.miguelcanton.unitconverter.domain.UnitField
import com.miguelcanton.unitconverter.databinding.ItemFieldBinding

class UnitFieldViewHolder(private val binding: ItemFieldBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(unitField: UnitField, unitClickListener: (UnitField) -> Unit) {
        binding.tvName.text = binding.root.context.getString(unitField.name)
        binding.ivIcon.setImageResource(unitField.icon)
        itemView.setOnClickListener { unitClickListener(unitField) }
    }
}