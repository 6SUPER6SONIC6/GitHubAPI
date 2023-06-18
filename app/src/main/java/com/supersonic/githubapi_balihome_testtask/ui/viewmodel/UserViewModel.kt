package com.supersonic.githubapi_balihome_testtask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supersonic.githubapi_balihome_testtask.data.model.UserData
import com.supersonic.githubapi_balihome_testtask.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<UserData>>()
    val users: LiveData<List<UserData>> get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
       viewModelScope.launch {
            try {
                val fetchedUsers = userRepository.getUsers()
                _users.postValue(fetchedUsers)
            } catch (_: Exception){

            }
        }

    }
}