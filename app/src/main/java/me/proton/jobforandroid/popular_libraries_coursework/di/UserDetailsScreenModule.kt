package me.proton.jobforandroid.popular_libraries_coursework.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import me.proton.jobforandroid.popular_libraries_coursework.core.ConnectivityListener
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApiRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.Cacheable
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.UserRepositoryRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen.UserDetailsRepoScreen
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen.UserDetailsRepoScreenImpl
import me.proton.jobforandroid.popular_libraries_coursework.presenter.UserDetailsPresenter
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RepositoryScope

@Module
open class UserDetailsScreenModule {

    @Provides
    @RepositoryScope
    fun provideUserDetailsRepository(
        githubApiRepo: GitHubApiRepo,
        userRepositoryRepo: UserRepositoryRepo,
        networkStatus: ConnectivityListener,
        cacheable: Cacheable,
    ): UserDetailsRepoScreen {
        return UserDetailsRepoScreenImpl(
            githubApiRepo,
            userRepositoryRepo,
            networkStatus.statusSingle(),
            cacheable,
        )
    }
}

@RepositoryScope
@Subcomponent(
    modules = [
        UserDetailsScreenModule::class
    ]
)

interface RepositorySubcomponent {
    fun inject(userPresenter: UserDetailsPresenter)
}
