package com.ezzy.socketstest.data.remote.requestbodies

import com.google.gson.annotations.SerializedName

data class RegisterRequestBody(
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password_confirmation")
    val passwordConfirmation: String
)
