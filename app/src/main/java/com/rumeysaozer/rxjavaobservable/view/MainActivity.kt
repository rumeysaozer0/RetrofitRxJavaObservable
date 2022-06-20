package com.rumeysaozer.rxjavaobservable.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.rxjavaobservable.R
import com.rumeysaozer.rxjavaobservable.adapter.AccountAdapter
import com.rumeysaozer.rxjavaobservable.databinding.ActivityMainBinding
import com.rumeysaozer.rxjavaobservable.model.Account
import com.rumeysaozer.rxjavaobservable.service.AccountApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val disposable = CompositeDisposable()
    private val accountApiService = AccountApiService()
    private var adapter : AccountAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()
    }
    private fun loadData(){
        disposable.add(
            accountApiService.getAccounts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )
    }
    private fun handleResponse(accountList : Account){
        adapter = AccountAdapter(accountList)
        binding.recyclerView.adapter = adapter
    }
}