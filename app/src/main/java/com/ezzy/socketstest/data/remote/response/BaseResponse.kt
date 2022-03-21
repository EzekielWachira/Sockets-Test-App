package com.ezzy.socketstest.data.remote.response

data class BaseResponse(
    val message: String,
    val status: Int,
    val success: Boolean
)