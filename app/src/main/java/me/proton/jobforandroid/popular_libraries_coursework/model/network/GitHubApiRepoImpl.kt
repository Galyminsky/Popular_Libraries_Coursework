package me.proton.jobforandroid.popular_libraries_coursework.model.network

import io.reactivex.rxjava3.core.Single


class GitHubApiRepoImpl(private val githubApi: GitHubApi) : GitHubApiRepo {
    override fun getAllUsers(): Single<List<UsersDto>> {
        return githubApi.getAllUsers()
    }

    override fun getUser(login: String): Single<UsersDto> {
        return githubApi.getUser(login)
    }

    override fun getRepos(login: String): Single<List<ReposDto>> {
        return githubApi.getRepos(login)
    }
}