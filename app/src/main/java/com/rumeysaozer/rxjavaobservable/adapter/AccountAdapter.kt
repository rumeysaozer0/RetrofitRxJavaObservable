package com.rumeysaozer.rxjavaobservable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.rxjavaobservable.databinding.ItemRowBinding
import com.rumeysaozer.rxjavaobservable.model.AccountItem

class AccountAdapter(val accountList : ArrayList<AccountItem>) : RecyclerView.Adapter<AccountAdapter.AccountHolder>() {
    class AccountHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountHolder {
     val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        return AccountHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountHolder, position: Int) {
        holder.binding.name.text = accountList[position].bankName
    }

    override fun getItemCount(): Int {
        return accountList.size
    }
}