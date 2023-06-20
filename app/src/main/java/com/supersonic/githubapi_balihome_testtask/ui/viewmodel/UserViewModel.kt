package com.supersonic.githubapi_balihome_testtask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.model.User
import com.supersonic.githubapi_balihome_testtask.data.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> get() = _repositories

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
       viewModelScope.launch {
            try {
                val fetchedUsers = userRepository.getUsers()
                _users.postValue(fetchedUsers)
            } catch (_: Exception){
                //ERROR
            }
        }

    }

    fun fetchRepositories(login: String) {
        viewModelScope.launch {
            try {
                val fetchedRepositories = userRepository.getUserRepositories(login)
                _repositories.postValue(fetchedRepositories)
            } catch (_: Exception){
                //ERROR
            }
        }
    }
}