package com.miguelcanton.unitconverter.ui.field

import androidx.lifecycle.ViewModel
import com.miguelcanton.unitconverter.domain.SingleUnit
import com.miguelcanton.unitconverter.domain.UnitField
import com.miguelcanton.unitconverter.data.UnitFieldListProvider.Companion.unitFieldList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FieldViewModel : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    data class UiState(
        val unitField: UnitField? = null,
        val navigateToHomeScreen: Boolean = false,
        val singleUnitFrom: SingleUnit? = null,
        val singleUnitTo: SingleUnit? = null,
        val arrowsRotation: Boolean = false,
        val valueFrom: Double? = null,
        val valueTo: Double? = null
    )

    fun onReceivedUnitField(unitFieldPosition: Int) {
        _state.update { it.copy(unitField = unitFieldList[unitFieldPosition]) }
    }

    fun onNavigateToHomeScreen() {
        _state.update { it.copy(navigateToHomeScreen = true) }
    }

    fun onNavigateToHomeScreenCompleted() {
        _state.update { it.copy(navigateToHomeScreen = false) }
    }

    fun onUnitFromChanged(unitFromPosition: Int) {
        _state.update {
            it.copy(singleUnitFrom = state.value.unitField?.unitList?.get(unitFromPosition))
        }
        if (state.value.valueFrom != null && state.value.singleUnitTo != null) {
            _state.update { it.copy(valueTo = calculateValueTo(state.value.valueFrom!!)) }
        }
    }

    fun onUnitToChanged(unitToPosition: Int) {
        _state.update {
            it.copy(singleUnitTo = state.value.unitField?.unitList?.get(unitToPosition))
        }
        if (state.value.valueFrom != null && state.value.singleUnitFrom != null) {
            _state.update { it.copy(valueTo = calculateValueTo(state.value.valueFrom!!)) }
        }

    }

    fun onUnitExchange() {
        _state.update {
            it.copy(
                singleUnitFrom = state.value.singleUnitTo,
                singleUnitTo = state.value.singleUnitFrom,
                arrowsRotation = true
            )
        }

        if (state.value.valueFrom != null && state.value.singleUnitFrom != null && state.value.singleUnitTo != null) {
            _state.update { it.copy(valueTo = calculateValueTo(state.value.valueFrom!!)) }
        }
    }

    fun onArrowsRotationCompleted() {
        _state.update { it.copy(arrowsRotation = false) }
    }

    fun onValueFromEntered(valueFrom: Double?) {
        if (valueFrom != null && state.value.singleUnitFrom != null && state.value.singleUnitTo != null) {
            _state.update { it.copy(valueFrom = valueFrom, valueTo = calculateValueTo(valueFrom)) }

        } else {
            _state.update { it.copy(valueFrom = valueFrom, valueTo = null) }
        }
    }


    fun onClearValue() {
        _state.update { it.copy(valueFrom = null, valueTo = null) }
    }

    private fun calculateValueTo(valueFrom: Double): Double {
        val formToBaseFunction = state.value.singleUnitFrom!!.toBase
        val baseToToFunction = state.value.singleUnitTo!!.fromBase
        val valueBase = formToBaseFunction(valueFrom)
        return baseToToFunction(valueBase)
    }
}