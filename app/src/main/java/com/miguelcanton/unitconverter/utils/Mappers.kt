package com.miguelcanton.unitconverter.utils

import com.miguelcanton.unitconverter.R

fun Int.toWhiteIcon(): Int {
    return when (this) {
        R.drawable.icon_temperature -> R.drawable.icon_temperature_white
        R.drawable.icon_time -> R.drawable.icon_time_white
        R.drawable.icon_force -> R.drawable.icon_force_white
        R.drawable.icon_area -> R.drawable.icon_area_white
        R.drawable.icon_volume -> R.drawable.icon_volume_white
        R.drawable.icon_mass -> R.drawable.icon_mass_white
        R.drawable.icon_pressure -> R.drawable.icon_pressure_white
        R.drawable.icon_energy -> R.drawable.icon_energy_white
        R.drawable.icon_data -> R.drawable.icon_data_white
        R.drawable.icon_velocity -> R.drawable.icon_velocity_white
        R.drawable.icon_acceleration -> R.drawable.icon_acceleration_white
        R.drawable.icon_density -> R.drawable.icon_density_white
        R.drawable.icon_frequency -> R.drawable.icon_frequency_white
        R.drawable.icon_resolution -> R.drawable.icon_resolution_white
        R.drawable.icon_length -> R.drawable.icon_length_white
        R.drawable.icon_angle -> R.drawable.icon_angle_white
        else -> 0
    }
}