package com.supersonic.githubapi_balihome_testtask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.supersonic.githubapi_balihome_testtask.R
import com.supersonic.githubapi_balihome_testtask.data.model.UserData

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val userList: MutableList<UserData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return  UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.login
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView){
        val userName: TextView = itemView.findViewById(R.id.user_name_textView)
    }

    fun submitList(users: List<UserData>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }
}