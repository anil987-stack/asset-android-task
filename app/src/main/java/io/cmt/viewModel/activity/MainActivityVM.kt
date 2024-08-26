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
import io.cmt.services.apis.Authentication
import io.cmt.services.model.VehicleTypeModel
import io.cmt.viewModel.BaseViewModel
import kotlinx.coroutines.launch

class MainActivityVM : BaseViewModel() {




    private val repository = Authentication()

    private val _isExpanded = MutableLiveData(false)
    private val _vehicleTypes = MutableLiveData<List<VehicleType>>()
    val vehicleTypes: LiveData<List<VehicleType>> get() = _vehicleTypes

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


    fun toggleExpandCollapse() {
        _isExpanded.value = !(_isExpanded.value ?: false)
        updateDisplayedVehicleTypes()
    }
    private fun updateDisplayedVehicleTypes() {
        val expanded = _isExpanded.value ?: false
        val vehicleTypes = _vehicleTypes.value ?: emptyList()
        val displayedTypes = if (expanded) {
            vehicleTypes
        } else {
            vehicleTypes.take(3)
        }
        _vehicleTypes.value = displayedTypes
        _buttonText.value = if (expanded) "Less" else "More"
    }

    fun fetchVehicleConfigurations() {
        val params = hashMapOf(
            "clientid" to "11",
            "enterprise_code" to "1007",
            "mno" to "9889897789",
            "passcode" to "3476"
        )

        viewModelScope.launch {
            val response = repository.getVehicleConfigurations(params)
            if (response != null) {

                _vehicleTypes.value = response.vehicle_type
                _vehicleCapacities.value = response.vehicle_capacity
                _vehicleMakes.value = response.vehicle_make
                _manufactureYears.value = response.manufacture_year
                _fuelTypes.value = response.fuel_type
            } else {
                Log.e("MainActivityVM", "Failed to fetch vehicle configurations")
            }
        }

    }


}