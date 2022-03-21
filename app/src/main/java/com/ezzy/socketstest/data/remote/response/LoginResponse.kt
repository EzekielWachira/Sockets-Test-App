package com.ezzy.socketstest.data.remote.response

data class LoginResponse(
    val message: String,
    val status: Int,
    val success: Boolean,
    val token: String,
    val user: User
)