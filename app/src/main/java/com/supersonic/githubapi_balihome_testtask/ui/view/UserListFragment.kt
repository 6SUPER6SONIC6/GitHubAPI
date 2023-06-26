package com.supersonic.githubapi_balihome_testtask.ui.view

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.supersonic.githubapi_balihome_testtask.R
import com.supersonic.githubapi_balihome_testtask.adapter.UserAdapter
import com.supersonic.githubapi_balihome_testtask.data.api.RetrofitInstance
import com.supersonic.githubapi_balihome_testtask.data.db.AppDatabase
import com.supersonic.githubapi_balihome_testtask.data.repository.UserRepositoryImpl
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModel
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var userViewModel: UserViewModel
    private lateinit var navController: NavController

    @Inject
    lateinit var db: AppDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.usersRecyclerView)
        userAdapter = UserAdapter { user ->
            user.login?.let { navigateToUserRepositoryFragment(it) }
        }

        recyclerView.apply {

            when (resources.configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT ->
                    layoutManager = GridLayoutManager(requireContext(), 2)

                Configuration.ORIENTATION_LANDSCAPE -> {
                    layoutManager = GridLayoutManager(requireContext(), 4)
                }
            }

            adapter = userAdapter
        }

        val apiService = RetrofitInstance.api
        val userDao = db.userDao()
        val repositoryDao = db.repositoryDao()
        val userRepository = UserRepositoryImpl(apiService, userDao, repositoryDao)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userRepository))[UserViewModel::class.java]
        userViewModel.users.observe(viewLifecycleOwner) {users ->
            userAdapter.submitList(users)
        }



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

    private fun navigateToUserRepositoryFragment(login: String) {
        val userRepositoryFragment = UserRepositoryFragment()

        val args = Bundle()
        args.putString("login", login)

        navController.navigate(R.id.action_userListFragment_to_userRepositoryFragment, args)
    }
}