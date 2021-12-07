package com.ainsigne.personsdemoapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ainsigne.domain.features.User
import com.ainsigne.personsdemoapp.R
import com.ainsigne.personsdemoapp.databinding.ItemPersonBinding
import com.google.android.material.shape.CornerFamily

class PersonsAdapter(val onClick: (User) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var users: List<User> = emptyList()

    fun updateDailyForecasts(users: List<User>) {
        this.users = users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_person, parent, false)
        return PersonViewHolder(ItemPersonBinding.bind(view), onClick)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonViewHolder?)?.bind(user = users[position])
    }


    class PersonViewHolder(val binding: ItemPersonBinding, val onClick: (User) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.tvUserFullname.text = user.fullName
        }
    }

}
