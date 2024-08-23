package io.cmt.services.apiInterface


import io.cmt.services.helper.APIResponse
import io.cmt.services.helper.CMServiceConstant
import io.cmt.services.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface AuthoAPI {


    @POST(CMServiceConstant.API.login)
    @FormUrlEncoded
    fun login(@FieldMap map: HashMap<String, String>): Call<APIResponse<UserModel>>


}

