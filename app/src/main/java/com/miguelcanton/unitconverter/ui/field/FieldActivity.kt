package com.miguelcanton.unitconverter.ui.field

import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.miguelcanton.unitconverter.R
import com.miguelcanton.unitconverter.ui.main.MainActivity.Companion.UNIT_FIELD_POSITION
import com.miguelcanton.unitconverter.databinding.ActivityFieldBinding
import com.miguelcanton.unitconverter.utils.toWhiteIcon
import kotlinx.coroutines.launch


class FieldActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFieldBinding
    private val viewModel: FieldViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFieldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val unitFieldPosition = intent.getIntExtra(UNIT_FIELD_POSITION, 0)

        viewModel.onReceivedUnitField(unitFieldPosition)

        binding.btArrows.setOnClickListener {
            viewModel.onUnitExchange()
        }

        binding.btArrows2.setOnClickListener {
            viewModel.onUnitExchange()
        }

        //Hide keyboard if it's previously open (editText keyboard)
        binding.tvUnitFrom.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.tvUnitFrom.applicationWindowToken, 0)
            }
        }

        binding.tvUnitFrom.threshold = 100 //To disable TextView autocomplete mode
        binding.tvUnitFrom.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            viewModel.onUnitFromChanged(position)
            binding.tvUnitFrom.clearFocus()
        }

        //Hide keyboard if it's previously open (editText keyboard)
        binding.tvUnitTo.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.tvUnitTo.applicationWindowToken, 0)
            }
        }

        binding.tvUnitTo.threshold = 100 //To disable TextView autocomplete mode
        binding.tvUnitTo.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            viewModel.onUnitToChanged(position)
            binding.tvUnitTo.clearFocus()
        }

        binding.btBack.setOnClickListener {
            viewModel.onNavigateToHomeScreen()
        }

        if (!binding.etValueFrom.isFocused) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.etValueFrom.windowToken, 0)
        }
        binding.etValueFrom.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.etValueFrom.clearFocus()
            }
            false
        }

        binding.etValueFrom.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                viewModel.onValueFromEntered(null)
            } else {
                viewModel.onValueFromEntered(it.toString().toDoubleOrNull())
            }
        }

        binding.btClear.setOnClickListener {
            viewModel.onClearValue()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->

                    if (state.unitField != null) {
                        binding.fieldName.text = getString(state.unitField.name)
                        binding.fieldIcon.setImageResource(state.unitField.icon.toWhiteIcon())
                        val list = mutableListOf<String>()
                        for (singleUnit in state.unitField.unitList) {
                            list.add(getString(singleUnit.name))
                        }
                        val unitsFromAdapter =
                            ArrayAdapter(this@FieldActivity, R.layout.list_item, list)
                        binding.tvUnitFrom.setAdapter(unitsFromAdapter)
                        binding.tvUnitTo.setAdapter(unitsFromAdapter)
                    }

                    if (state.navigateToHomeScreen) {
                        viewModel.onNavigateToHomeScreenCompleted()
                        finish()
                    }

                    if (state.singleUnitFrom != null) {
                        binding.tvUnitFrom.setText(getString(state.singleUnitFrom.unit), false)
                        binding.tvNameFrom.text = getString(state.singleUnitFrom.name)
                        binding.tvUnitFromDetail.text = getString(state.singleUnitFrom.unit)
                    } else {
                        binding.tvUnitFrom.text = null
                        binding.tvNameFrom.text = null
                        binding.tvUnitFromDetail.text = null
                    }

                    if (state.singleUnitTo != null) {
                        binding.tvUnitTo.setText(getString(state.singleUnitTo.unit), false)
                        binding.tvNameTo.text = getString(state.singleUnitTo.name)
                        binding.tvUnitToDetail.text = getString(state.singleUnitTo.unit)
                    } else {
                        binding.tvUnitTo.text = null
                        binding.tvNameTo.text = null
                        binding.tvUnitToDetail.text = null
                    }

                    if (state.arrowsRotation) {
                        val imageRotation =
                            AnimationUtils.loadAnimation(this@FieldActivity, R.anim.rotation)
                        binding.btArrows.startAnimation(imageRotation)
                        binding.btArrows2.startAnimation(imageRotation)
                        viewModel.onArrowsRotationCompleted()
                    }

                    if (state.valueFrom != null) {
                        binding.btClear.visibility = View.VISIBLE
                    } else {
                        binding.btClear.visibility = View.INVISIBLE
                        binding.etValueFrom.text = null
                        binding.tvValueTo.text = null
                    }

                    if (state.valueTo != null) {
                        binding.tvValueTo.text = state.valueTo.toFloat().toString()
                    } else {
                        binding.tvValueTo.text = null
                    }
                }
            }
        }
    }
}