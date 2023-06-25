package com.supersonic.githubapi_balihome_testtask.ui.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.supersonic.githubapi_balihome_testtask.R
import com.supersonic.githubapi_balihome_testtask.data.api.RetrofitInstance
import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.repository.UserRepositoryImpl
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModel
import com.supersonic.githubapi_balihome_testtask.ui.viewmodel.UserViewModelFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale


class UserRepositoryFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_repository, container, false)

        val apiService = RetrofitInstance.api
        val userRepository = UserRepositoryImpl(apiService)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userRepository))[UserViewModel::class.java]

        val login = arguments?.getString("login")

        if (login != null) {
            userViewModel.fetchRepositories(login)
        }

        userViewModel.repositories.observe(viewLifecycleOwner) { repositories ->
            view?.findViewById<ComposeView>(R.id.composeView)?.setContent {
                UserRepositoryList(repositories)
            }
        }



        return view
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun UserRepositoryItem(repository: Repository) {

        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
            elevation = 4.dp) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text( text = repository.name ?: "No name",
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    ) // Name

                    Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))

                    Text(text = repository.description ?: "This repository has no description ",
                        fontSize = 18.sp,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    ) // Description
                    
                    Spacer(modifier = Modifier.fillMaxWidth().height(32.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier
                            .padding(4.dp)
                            .weight(1f)
                            , horizontalArrangement = Arrangement.Start) {
                            Text(text = "Language: ")
                            Text(text = repository.language ?: "No information") // Language
                        }
                        Row(modifier = Modifier
                            .padding(4.dp)
                            .weight(1f)
                            , horizontalArrangement = Arrangement.End) {
                            Text(text = "Created: ")
                            Text(text = convertDate(repository.createdAt ?: "No information")) // Date

                        }
                    }

                    
                }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun UserRepositoryList(repositories: List<Repository>) {
        LazyColumn {
            items(repositories) { repository ->
                UserRepositoryItem(repository = repository)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun convertDate(date: String) : String{

        val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.getDefault())

        try {
            val outputDate = LocalDateTime.parse(date, inputFormat)
            return outputFormat.format(outputDate)
        } catch (e: DateTimeParseException) {
            e.printStackTrace()
        }
        return date
    }


}