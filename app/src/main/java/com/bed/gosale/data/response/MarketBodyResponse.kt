package com.bed.gosale.data.response

import com.bed.gosale.data.model.Market

data class MarketBodyResponse (
    val img: String? = "",
    val name: String? = "",
    val email: String? = "",
    val phone: String? = "",
    val address: String? = "",
    val description: String? = ""
)