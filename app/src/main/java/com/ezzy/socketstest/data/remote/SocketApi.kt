package com.ezzy.socketstest.data.remote

import com.ezzy.socketstest.data.remote.requestbodies.LoginRequestBody
import com.ezzy.socketstest.data.remote.requestbodies.RegisterRequestBody
import com.ezzy.socketstest.data.remote.response.BaseResponse
import com.ezzy.socketstest.data.remote.response.LoginResponse
import com.ezzy.socketstest.utils.Constants.LOGIN
import com.ezzy.socketstest.utils.Constants.REGISTER
import retrofit2.http.Body
import retrofit2.http.POST

interface SocketApi {

    @POST(REGISTER)
    suspend fun register(
        @Body registerRequestBody: RegisterRequestBody
    ): BaseResponse

    @POST(LOGIN)
    suspend fun login(
        @Body loginRequestBody: LoginRequestBody
    ): LoginResponse

}