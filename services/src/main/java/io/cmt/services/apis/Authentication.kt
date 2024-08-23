package io.cmt.services.apis


import io.cmt.services.apiInterface.AuthoAPI
import io.cmt.services.helper.APIClient
import io.cmt.services.helper.APIResponse
import io.cmt.services.helper.RetroFitCallBack
import io.cmt.services.model.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class Authentication {
    private val classTAG = "AUTHENTICATION"

    fun loginUser(params: HashMap<String, String>, retroFitCallBack: RetroFitCallBack) {
        val authoAPI: AuthoAPI =
            APIClient().getInstance().create(AuthoAPI::class.java)

        val call: Call<APIResponse<UserModel>> = authoAPI.login(params)
        call.enqueue(object : Callback<APIResponse<UserModel>> {
            override fun onResponse(
                call: Call<APIResponse<UserModel>>,
                response: Response<APIResponse<UserModel>>
            ) {
                retroFitCallBack.responseListener(response = response.body())
            }

            override fun onFailure(call: Call<APIResponse<UserModel>>, t: Throwable) {
                val error = t.message ?: "Not found"
                retroFitCallBack.responseListener(response = null, error = error)
            }
        })
    }






}