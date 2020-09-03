package com.bed.gosale.data.model

data class Products (
    val code: String? = "",
    val name: String? = "",
    val image: String? = "",
    val price: Float? = 0.0f,
    val validate: String? = "",
    val marketId: String? = "",
    val createdOn: String? = "",
    val description: String? = ""
)