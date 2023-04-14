package me.proton.jobforandroid.popular_libraries_coursework.di

import dagger.Module
import dagger.Provides
import me.proton.jobforandroid.popular_libraries_coursework.core.ConnectivityListener
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApiRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.Cacheable
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.UsersRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen.UsersRepoScreen
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen.UsersRepoScreenImpl
import javax.inject.Singleton

@Module()
object UsersScreenModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        githubApiRepo: GitHubApiRepo,
        usersRepo: UsersRepo,
        networkStatus: ConnectivityListener,
        cacheable: Cacheable,
    ): UsersRepoScreen {
        return UsersRepoScreenImpl(
            githubApiRepo,
            usersRepo,
            networkStatus.statusSingle(),
            cacheable,
        )
    }
}