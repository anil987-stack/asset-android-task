package io.cmt.viewModel.activity

import FuelType
import ManufactureYear
import VehicleCapacity
import VehicleMake
import VehicleType
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.cmt.R
import io.cmt.services.apis.Authentication
import io.cmt.services.model.VehicleTypeModel
import io.cmt.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityVM : BaseViewModel() {

    private val repository = Authentication()

    private val _isExpanded = MutableLiveData(false)
    private val _vehicleTypes = MutableLiveData<List<VehicleType>>()
    val vehicleTypes: LiveData<List<VehicleType>> get() = _vehicleTypes
    private val _fullVehicleTypes = MutableLiveData<List<VehicleType>>()

    private val _vehicleCapacities = MutableLiveData<List<VehicleCapacity>>()
    val vehicleCapacities: LiveData<List<VehicleCapacity>> get() = _vehicleCapacities

    private val _vehicleMakes = MutableLiveData<List<VehicleMake>>()
    val vehicleMakes: LiveData<List<VehicleMake>> get() = _vehicleMakes

    private val _manufactureYears = MutableLiveData<List<ManufactureYear>>()
    val manufactureYears: LiveData<List<ManufactureYear>> get() = _manufactureYears

    private val _fuelTypes = MutableLiveData<List<FuelType>>()
    val fuelTypes: LiveData<List<FuelType>> get() = _fuelTypes

    private val _buttonText = MutableLiveData("More")
    val buttonText: LiveData<String> get() = _buttonText

    private val _showLoader = MutableLiveData(false)
    val showLoader: LiveData<Boolean> get() = _showLoader

    private val _buttonImage = MutableLiveData(R.drawable.add_button)
    val buttonImage: LiveData<Int> get() = _buttonImage



    fun toggleExpandCollapse() {
        _buttonText.value = ""
        _showLoader.value = true
        viewModelScope.launch {
            delay(500)
            _isExpanded.value = !(_isExpanded.value ?: false)
            updateDisplayedVehicleTypes()
            _showLoader.value = false
        }
    }
    private fun updateDisplayedVehicleTypes() {
        val expanded = _isExpanded.value ?: false
        val vehicleTypes = _fullVehicleTypes.value ?: emptyList()
        val displayedTypes = if (expanded) {
            vehicleTypes
        } else {
            vehicleTypes.take(3)
        }
        _vehicleTypes.value = displayedTypes
        _buttonText.value = if (expanded) "Less" else "More"
        _buttonImage.value = if (expanded) R.drawable.less else R.drawable.add_button
    }


    fun fetchVehicleConfigurations() {
        _showLoader.value = true
        val params = hashMapOf(
            "clientid" to "11",
            "enterprise_code" to "1007",
            "mno" to "9889897789",
            "passcode" to "3476"
        )

        viewModelScope.launch {
            val response = repository.getVehicleConfigurations(params)
            if (response != null) {
                _showLoader.value = false
                _fullVehicleTypes.value = response.vehicle_type
                _vehicleTypes.value = response.vehicle_type.take(3)
                _vehicleCapacities.value = response.vehicle_capacity
                _vehicleMakes.value = response.vehicle_make
                _manufactureYears.value = response.manufacture_year
                _fuelTypes.value = response.fuel_type
            } else {
                _showLoader.value = false
                Log.e("MainActivityVM", "Failed to fetch vehicle configurations")
            }
        }

    }


}