package io.cmt.services.apiInterface


import ApiResponse
import io.cmt.services.helper.CMServiceConstant
import io.cmt.services.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface AuthoAPI {


    @POST(CMServiceConstant.API.task)
    suspend fun getVehicleConfigurations(
        @Body params: HashMap<String, String>
    ): Response<ApiResponse>


}

