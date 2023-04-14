package me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen

import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser

interface UsersRepoScreen {
    fun getUsers(): Single<List<GitHubUser>>
}