package com.miguelcanton.unitconverter.domain

data class UnitField(
    val name: Int,
    val icon: Int,
    val unitList: ArrayList<SingleUnit>
)