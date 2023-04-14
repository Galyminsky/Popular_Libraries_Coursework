package me.proton.jobforandroid.popular_libraries_coursework.di

import dagger.Component
import me.proton.jobforandroid.popular_libraries_coursework.presenter.MainPresenter
import me.proton.jobforandroid.popular_libraries_coursework.presenter.RepoUserPresenter
import me.proton.jobforandroid.popular_libraries_coursework.presenter.UsersPresenter
import me.proton.jobforandroid.popular_libraries_coursework.view.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        DataBaseModule::class,
        NavigationModule::class,
        RepoNetworkModule::class,
        UsersScreenModule::class
    ]
)
interface AppComponent {
    fun userSubcomponent(): RepositorySubcomponent
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(repoUserPresenter: RepoUserPresenter)
}