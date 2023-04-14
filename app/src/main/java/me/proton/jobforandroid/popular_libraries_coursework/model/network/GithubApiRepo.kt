package me.proton.jobforandroid.popular_libraries_coursework.model.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.Path

interface GitHubApiRepo {

    fun getAllUsers(): Single<List<UsersDto>>

    fun getUser(@Path("login") login: String): Single<UsersDto>

    fun getRepos(@Path("login") login: String): Single<List<ReposDto>>
}