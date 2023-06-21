package com.supersonic.githubapi_balihome_testtask.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
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
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView){

        init {
            itemView.rootView.setOnClickListener{
                val user = userList[adapterPosition]
                onItemClick.invoke(user)
            }
        }

        private val avatar: ImageView = itemView.findViewById(R.id.avatar_imageView)
        private val userName: TextView = itemView.findViewById(R.id.user_name_textView)
        private val id: TextView = itemView.findViewById(R.id.id_textView)

        fun bind(user: User) {
            userName.text = user.login
            id.text = "Id: ${user.id}"
            val avatarUrl = user.avatarUrl
            Glide.with(itemView.context)
                .load(avatarUrl)
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(80)))
                .circleCrop()
                .into(avatar)
        }
    }



    fun submitList(users: List<User>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }
}