package com.supersonic.githubapi_balihome_testtask.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supersonic.githubapi_balihome_testtask.R
import com.supersonic.githubapi_balihome_testtask.adapter.UserAdapter
import com.supersonic.githubapi_balihome_testtask.data.api.RetrofitInstance
import com.supersonic.githubapi_balihome_testtask.data.repository.UserRepositoryImpl
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModel
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModelFactory

class UserListFragment : Fragment() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.usersRecyclerView)
        userAdapter = UserAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }

        val apiService = RetrofitInstance.api
        val userRepository = UserRepositoryImpl(apiService)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userRepository))[UserViewModel::class.java]
        userViewModel.users.observe(viewLifecycleOwner) {users ->
            userAdapter.submitList(users)
        }


        return view
    }
}