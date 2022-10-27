package com.miguelcanton.unitconverter.data

import com.miguelcanton.unitconverter.R
import com.miguelcanton.unitconverter.domain.SingleUnit
import com.miguelcanton.unitconverter.domain.UnitField

class UnitFieldListProvider {
    companion object {
        val unitFieldList = listOf(
            UnitField(
                R.string.field_temperature,
                R.drawable.icon_temperature,
                arrayListOf(
                    SingleUnit(
                        R.string.c_name,
                        R.string.c_unit,
                        { value -> value },
                        { value -> value }),
                    SingleUnit(
                        R.string.k_name,
                        R.string.k_unit,
                        { value -> value - 273.15 },
                        { value -> value + 273.15 }),
                    SingleUnit(
                        R.string.f_name,
                        R.string.f_unit,
                        { value -> (value - 32) * 5 / 9 },
                        { value -> (value * 9 / 5) + 32 })
                )
            ),
            UnitField(
                R.string.field_time,
                R.drawable.icon_time,
                arrayListOf(
                    SingleUnit(
                        R.string.nanosecond_name,
                        R.string.nanosecond_unit,
                        { value -> value / 1.0E+9 },
                        { value -> value * 1.0E+9 }),
                    SingleUnit(
                        R.string.microsecond_name,
                        R.string.microsecond_unit,
                        { value -> value / 1.0E+6 },
                        { value -> value * 1.0E+6 }),
                    SingleUnit(
                        R.string.millisecond_name,
                        R.string.millisecond_unit,
                        { value -> value / 1000 },
                        { value -> value * 1000 }),
                    SingleUnit(
                        R.string.second_name,
                        R.string.second_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.minute_name,
                        R.string.minute_unit,
                        { value -> value * 60 },
                        { value -> value / 60 }),
                    SingleUnit(
                        R.string.hour_name,
                        R.string.hour_unit,
                        { value -> value * 3600 },
                        { value -> value / 3600 }),
                    SingleUnit(
                        R.string.day_name,
                        R.string.day_unit,
                        { value -> value * 3600 * 24 },
                        { value -> value / 3600 / 24 }),
                    SingleUnit(
                        R.string.week_name,
                        R.string.week_unit,
                        { value -> value * 3600 * 24 * 7 },
                        { value -> value / 3600 / 24 / 7 }),
                    SingleUnit(
                        R.string.month_name,
                        R.string.month_unit,
                        { value -> value * 3600 * 24 * 30 },
                        { value -> value / 3600 / 24 / 30 }),
                    SingleUnit(
                        R.string.year_name,
                        R.string.year_unit,
                        { value -> value * 3600 * 24 * 365 },
                        { value -> value / 3600 / 24 / 365 }),
                    SingleUnit(
                        R.string.lustrum_name,
                        R.string.lustrum_unit,
                        { value -> value * 3600 * 24 * 365 * 5 },
                        { value -> value / 3600 / 24 / 365 / 5 }),
                    SingleUnit(
                        R.string.decade_name,
                        R.string.decade_unit,
                        { value -> value * 3600 * 24 * 365 * 10 },
                        { value -> value / 3600 / 24 / 365 / 10 }),
                    SingleUnit(
                        R.string.century_name,
                        R.string.century_unit,
                        { value -> value * 3600 * 24 * 365 * 100 },
                        { value -> value / 3600 / 24 / 365 / 100 }),
                    SingleUnit(
                        R.string.millennium_name,
                        R.string.millennium_unit,
                        { value -> value * 3600 * 24 * 7 * 365 * 1000 },
                        { value -> value / 3600 / 24 / 7 / 365 / 1000 }),
                )
            ),
            UnitField(
                R.string.field_length,
                R.drawable.icon_length,
                arrayListOf(
                    SingleUnit(
                        R.string.pm_name,
                        R.string.pm_unit,
                        { value -> value / 1e+12 },
                        { value -> value * 1e+12 }),
                    SingleUnit(
                        R.string.a_name,
                        R.string.a_unit,
                        { value -> value / 1e+10 },
                        { value -> value * 1e+10 }),
                    SingleUnit(
                        R.string.nm_name,
                        R.string.nm_unit,
                        { value -> value / 1e+9 },
                        { value -> value * 1e+9 }),
                    SingleUnit(
                        R.string.μm_name,
                        R.string.μm_unit,
                        { value -> value / 1e+6 },
                        { value -> value * 1e+6 }),
                    SingleUnit(
                        R.string.mm_name,
                        R.string.mm_unit,
                        { value -> value / 1000 },
                        { value -> value * 1000 }),
                    SingleUnit(
                        R.string.cm_name,
                        R.string.cm_unit,
                        { value -> value / 100 },
                        { value -> value * 100 }),
                    SingleUnit(
                        R.string.dm_name,
                        R.string.dm_unit,
                        { value -> value / 10 },
                        { value -> value * 10 }),
                    SingleUnit(
                        R.string.m_name,
                        R.string.m_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.dam_name,
                        R.string.dam_unit,
                        { value -> value / 0.1 },
                        { value -> value * 0.1 }),
                    SingleUnit(
                        R.string.hm_name,
                        R.string.hm_unit,
                        { value -> value / 0.01 },
                        { value -> value * 0.01 }),
                    SingleUnit(
                        R.string.km_name,
                        R.string.km_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.in_name,
                        R.string.in_unit,
                        { value -> value / 39.37008 },
                        { value -> value * 39.37008 }),
                    SingleUnit(
                        R.string.ft_name,
                        R.string.ft_unit,
                        { value -> value / 3.28084 },
                        { value -> value * 3.28084 }),
                    SingleUnit(
                        R.string.yd_name,
                        R.string.yd_unit,
                        { value -> value / 1.0936133 },
                        { value -> value * 1.0936133 }),
                    SingleUnit(
                        R.string.mi_name,
                        R.string.mi_unit,
                        { value -> value / 0.000621371 },
                        { value -> value * 0.000621371 }),
                    SingleUnit(
                        R.string.nmi_name,
                        R.string.nmi_unit,
                        { value -> value / 0.000539957 },
                        { value -> value * 0.000539957 }),
                    SingleUnit(
                        R.string.ly_name,
                        R.string.ly_unit,
                        { value -> value / 1.05700083E-16 },
                        { value -> value * 1.05700083E-16 })
                )
            ),
            UnitField(
                R.string.field_mass,
                R.drawable.icon_mass,
                arrayListOf(
                    SingleUnit(
                        R.string.pg_name,
                        R.string.pg_unit,
                        { value -> value / 1e+12 },
                        { value -> value * 1e+12 }),
                    SingleUnit(
                        R.string.ng_name,
                        R.string.ng_unit,
                        { value -> value / 1e+9 },
                        { value -> value * 1e+9 }),
                    SingleUnit(
                        R.string.μg_name,
                        R.string.μg_unit,
                        { value -> value / 1e+6 },
                        { value -> value * 1e+6 }),
                    SingleUnit(
                        R.string.mg_name,
                        R.string.mg_unit,
                        { value -> value / 1000 },
                        { value -> value * 1000 }),
                    SingleUnit(
                        R.string.cg_name,
                        R.string.cg_unit,
                        { value -> value / 100 },
                        { value -> value * 100 }),
                    SingleUnit(
                        R.string.dg_name,
                        R.string.dg_unit,
                        { value -> value / 10 },
                        { value -> value * 10 }),
                    SingleUnit(
                        R.string.g_name,
                        R.string.g_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.dag_name,
                        R.string.dag_unit,
                        { value -> value / 0.1 },
                        { value -> value * 0.1 }),
                    SingleUnit(
                        R.string.hg_name,
                        R.string.hg_unit,
                        { value -> value / 0.01 },
                        { value -> value * 0.01 }),
                    SingleUnit(
                        R.string.kg_name,
                        R.string.kg_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.t_name,
                        R.string.t_unit,
                        { value -> value / 0.000001 },
                        { value -> value * 0.000001 }),
                    SingleUnit(
                        R.string.lbs_name,
                        R.string.lbs_unit,
                        { value -> value / 0.0022046226 },
                        { value -> value * 0.0022046226 }),
                    SingleUnit(
                        R.string.oz_name,
                        R.string.oz_unit,
                        { value -> value / 0.03527396 },
                        { value -> value * 0.03527396 })
                )
            ),
            UnitField(
                R.string.field_velocity,
                R.drawable.icon_velocity,
                arrayListOf(
                    SingleUnit(
                        R.string.mets_name,
                        R.string.mets_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kilh_name,
                        R.string.kilh_unit,
                        { value -> value / 3.6 },
                        { value -> value * 3.6 }),
                    SingleUnit(
                        R.string.milh_name,
                        R.string.milh_unit,
                        { value -> value / 2.23694 },
                        { value -> value * 2.23694 }),
                    SingleUnit(
                        R.string.foos_name,
                        R.string.foos_unit,
                        { value -> value / 3.28084 },
                        { value -> value * 3.28084 }),
                    SingleUnit(
                        R.string.foom_name,
                        R.string.foom_unit,
                        { value -> value / 196.850394 },
                        { value -> value * 196.850394 }),
                    SingleUnit(
                        R.string.knot_name,
                        R.string.knot_unit,
                        { value -> value / 196.850394 },
                        { value -> value * 196.850394 })
                )
            ),
            UnitField(
                R.string.field_acceleration,
                R.drawable.icon_acceleration,
                arrayListOf(
                    SingleUnit(
                        R.string.mets2_name,
                        R.string.mets2_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kils2_name,
                        R.string.kils2_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.mils2_name,
                        R.string.mils2_unit,
                        { value -> value / 0.000621371 },
                        { value -> value * 0.000621371 }),
                    SingleUnit(
                        R.string.foos2_name,
                        R.string.foos2_unit,
                        { value -> value / 3.28084 },
                        { value -> value * 3.28084 })
                )
            ),
            UnitField(
                R.string.field_energy,
                R.drawable.icon_energy,
                arrayListOf(
                    SingleUnit(
                        R.string.j_name,
                        R.string.j_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kj_name,
                        R.string.kj_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.wh_name,
                        R.string.wh_unit,
                        { value -> value / 0.0002777778 },
                        { value -> value * 0.0002777778 }),
                    SingleUnit(
                        R.string.kwh_name,
                        R.string.kwh_unit,
                        { value -> value / 2.777778e-7 },
                        { value -> value * 2.777778e-7 }),
                    SingleUnit(
                        R.string.ev_name,
                        R.string.ev_unit,
                        { value -> value / 6.2415063630939996E18 },
                        { value -> value * 6.2415063630939996E18 }),
                    SingleUnit(
                        R.string.cal_name,
                        R.string.cal_unit,
                        { value -> value / 0.2388458966 },
                        { value -> value * 0.2388458966 }),
                    SingleUnit(
                        R.string.er_name,
                        R.string.er_unit,
                        { value -> value / 1e+7 },
                        { value -> value * 1e+7 })
                )
            ),
            UnitField(
                R.string.field_data,
                R.drawable.icon_data,
                arrayListOf(
                    SingleUnit(
                        R.string.b_name,
                        R.string.b_unit,
                        { value -> value / 8 },
                        { value -> value * 8 }),
                    SingleUnit(
                        R.string.by_name,
                        R.string.by_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kb_name,
                        R.string.kb_unit,
                        { value -> value / 0.0009765625 },
                        { value -> value * 0.0009765625 }),
                    SingleUnit(
                        R.string.mb_name,
                        R.string.mb_unit,
                        { value -> value / 9.536743164E-7 },
                        { value -> value * 9.536743164E-7 }),
                    SingleUnit(
                        R.string.gb_name,
                        R.string.gb_unit,
                        { value -> value / 9.313225746E-10 },
                        { value -> value * 9.313225746E-10 }),
                    SingleUnit(
                        R.string.tb_name,
                        R.string.tb_unit,
                        { value -> value / 9.094947017E-13 },
                        { value -> value * 9.094947017E-13 }),
                    SingleUnit(
                        R.string.pb_name,
                        R.string.pb_unit,
                        { value -> value / 8.881784197E-16 },
                        { value -> value * 8.881784197E-16 }),
                    SingleUnit(
                        R.string.eb_name,
                        R.string.eb_unit,
                        { value -> value / 8.673617379E-19 },
                        { value -> value * 8.673617379E-19 })
                )
            ),
            UnitField(
                R.string.field_area,
                R.drawable.icon_area,
                arrayListOf(
                    SingleUnit(
                        R.string.cm2_name,
                        R.string.cm2_unit,
                        { value -> value / 10000 },
                        { value -> value * 10000 }),
                    SingleUnit(
                        R.string.m2_name,
                        R.string.m2_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.ha_name,
                        R.string.ha_unit,
                        { value -> value / 0.0001 },
                        { value -> value * 0.0001 }),
                    SingleUnit(
                        R.string.km2_name,
                        R.string.km2_unit,
                        { value -> value / 0.000001 },
                        { value -> value * 0.000001 }),
                    SingleUnit(
                        R.string.mi2_name,
                        R.string.mi2_unit,
                        { value -> value / 3.861021585E-7 },
                        { value -> value * 3.861021585E-7 }),
                    SingleUnit(
                        R.string.yd2_name,
                        R.string.yd2_unit,
                        { value -> value / 1.1959900463 },
                        { value -> value * 1.1959900463 }),
                    SingleUnit(
                        R.string.ft2_name,
                        R.string.ft2_unit,
                        { value -> value / 10.763910417 },
                        { value -> value * 10.763910417 }),
                    SingleUnit(
                        R.string.in2_name,
                        R.string.in2_unit,
                        { value -> value / 1550.0031 },
                        { value -> value * 1550.0031 })
                )
            ),
            UnitField(
                R.string.field_volume,
                R.drawable.icon_volume,
                arrayListOf(
                    SingleUnit(
                        R.string.cm3_name,
                        R.string.cm3_unit,
                        { value -> value / 1000000 },
                        { value -> value * 1000000 }),
                    SingleUnit(
                        R.string.dm3_name,
                        R.string.dm3_unit,
                        { value -> value / 1000 },
                        { value -> value * 1000 }),
                    SingleUnit(
                        R.string.l_name,
                        R.string.l_unit,
                        { value -> value / 1000 },
                        { value -> value * 1000 }),
                    SingleUnit(
                        R.string.m3_name,
                        R.string.m3_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.gal_name,
                        R.string.gal_unit,
                        { value -> value / 264.17205236 },
                        { value -> value * 264.17205236 }),
                    SingleUnit(
                        R.string.yd3_name,
                        R.string.yd3_unit,
                        { value -> value / 1.3079506193 },
                        { value -> value * 1.3079506193 }),
                    SingleUnit(
                        R.string.ft3_name,
                        R.string.ft3_unit,
                        { value -> value / 35.314666721 },
                        { value -> value * 35.314666721 }),
                    SingleUnit(
                        R.string.in3_name,
                        R.string.in3_unit,
                        { value -> value / 61023.744095 },
                        { value -> value * 61023.744095 })
                )
            ),
            UnitField(
                R.string.field_pressure,
                R.drawable.icon_pressure,
                arrayListOf(
                    SingleUnit(
                        R.string.pa_name,
                        R.string.pa_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kpa_name,
                        R.string.kpa_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.bar_name,
                        R.string.bar_unit,
                        { value -> value / 0.00001 },
                        { value -> value * 0.00001 }),
                    SingleUnit(
                        R.string.nm2_name,
                        R.string.nm2_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.atm_name,
                        R.string.atm_unit,
                        { value -> value / 0.0000098692 },
                        { value -> value * 0.0000098692 })
                )
            ),
            UnitField(
                R.string.field_density,
                R.drawable.icon_density,
                arrayListOf(
                    SingleUnit(
                        R.string.kgl_name,
                        R.string.kgl_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.kgm3_name,
                        R.string.kgm3_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.gcm3_name,
                        R.string.gcm3_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.gl_name,
                        R.string.gl_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.gm3_name,
                        R.string.gm3_unit,
                        { value -> value / 1000 },
                        { value -> value * 1000 })
                )
            ),
            UnitField(
                R.string.field_frequency,
                R.drawable.icon_frequency,
                arrayListOf(
                    SingleUnit(
                        R.string.h_name,
                        R.string.h_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kh_name,
                        R.string.kh_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.mh_name,
                        R.string.mh_unit,
                        { value -> value / 0.000001 },
                        { value -> value * 0.000001 }),
                    SingleUnit(
                        R.string.gh_name,
                        R.string.gh_unit,
                        { value -> value / 1E-9 },
                        { value -> value * 1E-9 }),
                    SingleUnit(
                        R.string.rps_name,
                        R.string.rps_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.rpm_name,
                        R.string.rpm_unit,
                        { value -> value / 60 },
                        { value -> value * 60 })
                )
            ),
            UnitField(
                R.string.field_resolution,
                R.drawable.icon_resolution,
                arrayListOf(
                    SingleUnit(
                        R.string.dpm_name,
                        R.string.dpm_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.dpmm_name,
                        R.string.dpmm_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.dpi_name,
                        R.string.dpi_unit,
                        { value -> value / 0.0254 },
                        { value -> value * 0.0254 }),
                    SingleUnit(
                        R.string.ppi_name,
                        R.string.ppi_unit,
                        { value -> value / 0.0254 },
                        { value -> value * 0.0254 })
                )
            ),
            UnitField(
                R.string.field_force,
                R.drawable.icon_force,
                arrayListOf(
                    SingleUnit(
                        R.string.n_name,
                        R.string.n_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.kn_name,
                        R.string.kn_unit,
                        { value -> value / 0.001 },
                        { value -> value * 0.001 }),
                    SingleUnit(
                        R.string.p_name,
                        R.string.p_unit,
                        { value -> value / 101.9716213 },
                        { value -> value * 101.9716213 }),
                    SingleUnit(
                        R.string.kp_name,
                        R.string.kp_unit,
                        { value -> value / 0.1019716213 },
                        { value -> value * 0.1019716213 }),
                    SingleUnit(
                        R.string.jm_name,
                        R.string.jm_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.d_name,
                        R.string.d_unit,
                        { value -> value / 100000 },
                        { value -> value * 100000 }),
                    SingleUnit(
                        R.string.gf_name,
                        R.string.gf_unit,
                        { value -> value / 101.9716213 },
                        { value -> value * 101.9716213 }),
                    SingleUnit(
                        R.string.kgf_name,
                        R.string.kgf_unit,
                        { value -> value / 0.1019716213 },
                        { value -> value * 0.1019716213 }),
                    SingleUnit(
                        R.string.tf_name,
                        R.string.tf_unit,
                        { value -> value / 0.0001019716 },
                        { value -> value * 0.0001019716 })
                )
            ),
            UnitField(
                R.string.field_angle,
                R.drawable.icon_angle,
                arrayListOf(
                    SingleUnit(
                        R.string.deg_name,
                        R.string.deg_unit,
                        { value -> value / 1 },
                        { value -> value * 1 }),
                    SingleUnit(
                        R.string.rad_name,
                        R.string.rad_unit,
                        { value -> value / 0.0174532925 },
                        { value -> value * 0.0174532925 }),
                    SingleUnit(
                        R.string.min_name,
                        R.string.min_unit,
                        { value -> value / 60 },
                        { value -> value * 60 }),
                    SingleUnit(
                        R.string.sec_name,
                        R.string.sec_unit,
                        { value -> value / 3600 },
                        { value -> value * 3600 })
                )
            )
        )
    }
}