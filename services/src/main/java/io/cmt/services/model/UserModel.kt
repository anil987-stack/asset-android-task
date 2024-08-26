data class VehicleType(
    val text: String,
    val value: Int,
    val images: String
)

data class VehicleCapacity(
    val text: String,
    val value: Int,
    val images: String
)

data class VehicleMake(
    val text: String,
    val value: Int,
    val images: String
)

data class ManufactureYear(
    val text: String,
    val value: Int,
    val images: String
)

data class FuelType(
    val text: String,
    val value: Int,
    val images: String
)

data class ApiResponse(
    val status: Int,
    val message: String,
    val vehicle_type: List<VehicleType>,
    val vehicle_capacity: List<VehicleCapacity>,
    val vehicle_make: List<VehicleMake>,
    val manufacture_year: List<ManufactureYear>,
    val fuel_type: List<FuelType>
)
