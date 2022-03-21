package com.ezzy.socketstest.data.remote.response

data class User(
    val created_at: String,
    val email: String,
    val email_verified_at: String?,
    val joined_date: String,
    val name: String,
    val updated_at: String,
    val username: String,
    val uuid: String
)