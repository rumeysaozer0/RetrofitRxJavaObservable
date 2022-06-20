package com.rumeysaozer.rxjavaobservable.model


import com.google.gson.annotations.SerializedName

data class AccountItem(
    @SerializedName("account_number")
    val accountNumber: String,
    @SerializedName("bank_name")
    val bankName: String,
    @SerializedName("iban")
    val iban: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("routing_number")
    val routingNumber: String,
    @SerializedName("swift_bic")
    val swiftBic: String,
    @SerializedName("uid")
    val uid: String
)