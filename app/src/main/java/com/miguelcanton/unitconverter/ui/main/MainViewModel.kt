package com.miguelcanton.unitconverter.ui.main

import android.app.Application
import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import com.miguelcanton.unitconverter.domain.UnitField
import com.miguelcanton.unitconverter.data.UnitFieldListProvider.Companion.unitFieldList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//Extends AndroidViewModel instead of ViewModel because of the need to access R.strings for filtering fieldList
//Testing if is best option
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    data class UiState(
        val unitList: List<UnitField> = unitFieldList,
        val spanCount: Int = 2,
        val searching: Boolean = false,
        val searchText: String? = null,
        val navigateToConverterScreen: Boolean = false,
        val unitFieldPosition: Int = 0,
        val openKeyboard: Boolean = false
    )

    fun onGridButtonClicked() {
        if (state.value.spanCount == 3) {
            _state.update { it.copy(spanCount = 1) }
        } else {
            _state.update { it.copy(spanCount = state.value.spanCount + 1) }
        }
    }

    fun onSearchButtonClicked() {
        _state.update { it.copy(searching = !state.value.searching, openKeyboard = true) }
    }

    fun onClearButtonClicked() {
        _state.update { it.copy(searchText = null) }
    }

    fun onSearchTextChanged(searchText: Editable?) {
        if (searchText.isNullOrEmpty()) {
            _state.update { it.copy(searchText = null, unitList = unitFieldList) }
        } else {
            _state.update {
                it.copy(
                    searchText = searchText.toString(),
                    unitList = unitFieldList.filter { unitConverter ->
                        getApplication<Application?>().getString(unitConverter.name).lowercase()
                            .contains(searchText.toString().lowercase())
                    })
            }
        }
    }

    fun onNavigateToConverterScreen(unitFieldPosition: Int) {
        _state.update {
            it.copy(
                navigateToConverterScreen = true,
                unitFieldPosition = unitFieldPosition
            )
        }
    }

    fun onNavigateToConverterScreenCompleted() {
        _state.update { it.copy(navigateToConverterScreen = false, unitFieldPosition = 0) }
    }

    fun onOpenKeyboardCompleted() {
        _state.update { it.copy(openKeyboard = false) }
    }

}