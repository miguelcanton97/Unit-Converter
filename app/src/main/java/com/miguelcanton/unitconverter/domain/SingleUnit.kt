package com.miguelcanton.unitconverter.domain

data class SingleUnit(
    val name: Int,
    val unit: Int,
    val toBase: (Double) -> Double,
    val fromBase: (Double) -> Double
)