package com.supersonic.githubapi_balihome_testtask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.supersonic.githubapi_balihome_testtask.R
import com.supersonic.githubapi_balihome_testtask.data.model.User

class UserAdapter(private val onItemClick: (User) -> Unit): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val userList: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return  UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)

        holder.itemView.rootView.setOnClickListener{
            onItemClick.invoke(user)
        }
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView){

//        init {
//            itemView.rootView.setOnClickListener{
//                val user = userList[adapterPosition]
//                onItemClick.invoke(user)
//            }
//        }

        val userName: TextView = itemView.findViewById(R.id.user_name_textView)

        fun bind(user: User) {
            userName.text = user.login
        }
    }



    fun submitList(users: List<User>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }
}