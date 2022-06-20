package com.rumeysaozer.rxjavaobservable.service


import com.rumeysaozer.rxjavaobservable.model.Account
import io.reactivex.Observable
import retrofit2.http.GET


interface AccountApi {

    @GET("bank/random_bank?size=20")
    fun getAccount(): Observable<Account>
}