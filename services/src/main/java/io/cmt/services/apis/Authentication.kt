package io.cmt.services.apis


import ApiResponse
import io.cmt.services.apiInterface.AuthoAPI
import io.cmt.services.helper.APIClient

class Authentication {


    private val authoAPI: AuthoAPI = APIClient().getInstance().create(AuthoAPI::class.java)

    suspend fun getVehicleConfigurations(params: HashMap<String, String>): ApiResponse? {
        return try {
            val response = authoAPI.getVehicleConfigurations(params)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}






