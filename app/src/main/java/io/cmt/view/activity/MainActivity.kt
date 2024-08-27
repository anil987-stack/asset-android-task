package io.cmt.view.activity


import VehicleTypeAdapter
import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import io.cmt.databinding.ActivityMainBinding
import io.cmt.internet.BaseActivity
import io.cmt.viewModel.activity.MainActivityVM

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: VehicleTypeAdapter
    private lateinit var viewModel: MainActivityVM

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityVM::class.java]


        initOtpTextWatchers()

        binding.imeiScan.setOnClickListener {
            startQrScanner()
        }

        viewModel.vehicleCapacities.observe(this) { vehicleCapacities ->
            val adapter = ArrayAdapter(
                this,
                R.layout.simple_spinner_item,
                vehicleCapacities.map { it.text }
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.capacitySpinner.adapter = adapter
        }

        viewModel.fuelTypes.observe(this) { vehicleCapacities ->
            val adapter = ArrayAdapter(
                this,
                R.layout.simple_spinner_item,
                vehicleCapacities.map { it.text }
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.fuelTypeSpinner.adapter = adapter
        }
        viewModel.manufactureYears.observe(this) { vehicleCapacities ->
            val adapter = ArrayAdapter(
                this,
                R.layout.simple_spinner_item,
                vehicleCapacities.map { it.text }
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.yearSpinner.adapter = adapter
        }
        viewModel.vehicleMakes.observe(this) { vehicleCapacities ->
            val adapter = ArrayAdapter(
                this,
                R.layout.simple_spinner_item,
                vehicleCapacities.map { it.text }
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.spinnerBrand.adapter = adapter
        }

        viewModel.vehicleMakes.observe(this) { vehicleCapacities ->
            val adapter = ArrayAdapter(
                this,
                R.layout.simple_spinner_item,
                vehicleCapacities.map { it.text }
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            binding.spinnerBrand.adapter = adapter
        }
        binding.btnMoreLess.setOnClickListener {
            viewModel.toggleExpandCollapse()
        }
        binding.more.setOnClickListener {
            viewModel.toggleExpandCollapse()
        }

        val items = listOf("Grand Vitara", "Ertiga", "Dezire", "Baleno", "Alto")
        val adapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item,
            items
        )
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerModel.adapter = adapter

        val itemsDriver = listOf("Driver", "Customer", "Owner")
        val adapters = ArrayAdapter(
            this,
            R.layout.simple_spinner_item,
            itemsDriver
        )
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.driver.adapter = adapters

        viewModel.buttonImage.observe(this) { imageResId ->
            binding.more.setImageResource(imageResId)
        }
        viewModel.showLoader.observe(this) { show ->
            binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        }

        setupRecyclerView()
        observeViewModel()

        viewModel.fetchVehicleConfigurations()

    }

    private fun setupRecyclerView() {
        adapter = VehicleTypeAdapter()
        binding.recyclerVehicleTypes.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerVehicleTypes.adapter = adapter
    }
    private fun observeViewModel() {
        viewModel.vehicleTypes.observe(this) { vehicleTypes ->
            adapter.submitList(vehicleTypes)
        }

        viewModel.buttonText.observe(this) { text ->
            binding.btnMoreLess.text = text
        }
    }


    private fun initOtpTextWatchers() {
        val otpTextWatchers = arrayOf(
            binding.etOtp1, binding.etOtp2, binding.etOtp3,
            binding.etOtp4, binding.etOtp5, binding.etOtp6
        )

        otpTextWatchers.forEachIndexed { index, editText ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1 && index < otpTextWatchers.size - 1) {
                        otpTextWatchers[index + 1].requestFocus()
                    } else if (s?.length == 0 && index > 0) {
                        otpTextWatchers[index - 1].requestFocus()
                    }
                }
            })

            editText.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_DEL && editText.text?.length == 0 && index > 0) {
                    otpTextWatchers[index - 1].requestFocus()
                }
                false
            }
        }
    }

    private fun startQrScanner() {
        val intent = Intent(this, QrScannerActivity::class.java)
        qrResultLauncher.launch(intent)
    }

    private val qrResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.getStringExtra("QR_CODE_RESULT")?.let { qrCode ->
                    binding.imeiInput.setText(qrCode)
                }
            } else {
                Toast.makeText(this, "QR scan failed!", Toast.LENGTH_SHORT).show()
            }
        }


}

