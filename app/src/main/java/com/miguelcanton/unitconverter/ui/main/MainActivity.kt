package com.miguelcanton.unitconverter.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View.*
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.miguelcanton.unitconverter.R
import com.miguelcanton.unitconverter.data.UnitFieldListProvider.Companion.unitFieldList
import com.miguelcanton.unitconverter.databinding.ActivityMainBinding
import com.miguelcanton.unitconverter.ui.field.FieldActivity
import com.miguelcanton.unitconverter.ui.main.adapter.UnitConverterAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    companion object {
        const val UNIT_FIELD_POSITION = "UNIT_FIELD_POSITION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UnitConverterAdapter { unitFieldClicked ->
            for ((index,unitField) in unitFieldList.withIndex()){
                if (unitFieldClicked == unitField){
                    viewModel.onNavigateToConverterScreen(index)
                    break
                }
            }
        }

        binding.unitList.adapter = adapter

        binding.etSearch.addTextChangedListener {
            viewModel.onSearchTextChanged(it)
        }

        binding.btGrid.setOnClickListener {
            viewModel.onGridButtonClicked()
        }

        binding.btClear.setOnClickListener {
            viewModel.onClearButtonClicked()
        }

        binding.btSearch.setOnClickListener {
            viewModel.onSearchButtonClicked()
        }



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->

                    adapter.submitList(state.unitList)

                    binding.unitList.layoutManager =
                        GridLayoutManager(this@MainActivity, state.spanCount)

                    when (state.spanCount) {
                        1 -> binding.btGrid.setImageResource(R.drawable.icon_grid_white_1)
                        2 -> binding.btGrid.setImageResource(R.drawable.icon_grid_white_4)
                        3 -> binding.btGrid.setImageResource(R.drawable.icon_grid_white_6)
                    }

                    if (state.searching) {
                        binding.etSearch.visibility = VISIBLE
                        binding.etSearch.requestFocus()

                    } else {
                        binding.etSearch.visibility = GONE
                        binding.etSearch.text?.clear()
                        binding.btClear.visibility = INVISIBLE
                        closeKeyboard()
                    }

                    if (state.openKeyboard) {
                        openKeyboard()
                        viewModel.onOpenKeyboardCompleted()
                    }

                    if (state.searchText == null) {
                        binding.btClear.visibility = INVISIBLE
                        binding.etSearch.text = null
                    } else {
                        binding.btClear.visibility = VISIBLE
                        adapter.submitList(state.unitList)
                    }

                    if (state.navigateToConverterScreen) {
                        val intent = Intent(this@MainActivity, FieldActivity::class.java)
                        intent.putExtra(UNIT_FIELD_POSITION, state.unitFieldPosition)
                        startActivity(intent)
                        viewModel.onNavigateToConverterScreenCompleted()
                    }
                }

            }
        }
    }

    private fun closeKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
    }

    private fun openKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etSearch, InputMethodManager.SHOW_IMPLICIT)
    }
}