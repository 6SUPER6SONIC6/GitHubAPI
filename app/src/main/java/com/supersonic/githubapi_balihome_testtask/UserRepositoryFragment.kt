package com.supersonic.githubapi_balihome_testtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.supersonic.githubapi_balihome_testtask.data.api.RetrofitInstance
import com.supersonic.githubapi_balihome_testtask.data.repository.UserRepositoryImpl
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModel
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModelFactory


class UserRepositoryFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_repository, container, false)

        val apiService = RetrofitInstance.api
        val userRepository = UserRepositoryImpl(apiService)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userRepository))[UserViewModel::class.java]

        val login = arguments?.getString("login")
        view.findViewById<TextView>(R.id.rep).text = login

        return view
    }


}