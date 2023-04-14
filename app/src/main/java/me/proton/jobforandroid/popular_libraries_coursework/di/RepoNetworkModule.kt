package me.proton.jobforandroid.popular_libraries_coursework.di

import dagger.Module
import dagger.Provides
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApi
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApiRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApiRepoImpl
import javax.inject.Singleton

@Module
object RepoNetworkModule {
    @Provides
    @Singleton
    fun provideRepoNetwork(githubApi: GitHubApi): GitHubApiRepo {
        return GitHubApiRepoImpl(githubApi)
    }
}