package com.rumeysaozer.rxjavaobservable.service

import com.rumeysaozer.rxjavaobservable.model.Account
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class AccountApiService {
    private val BASE_URL = "https://random-data-api.com/api/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AccountApi::class.java)
    fun getAccounts(): Observable<Account> {
       return api.getAccount()
    }
}