package me.proton.jobforandroid.popular_libraries_coursework.presenter

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import me.proton.jobforandroid.popular_libraries_coursework.core.App
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen.UsersRepoScreen
import me.proton.jobforandroid.popular_libraries_coursework.utils.subscribeByDefault
import me.proton.jobforandroid.popular_libraries_coursework.view.user.UserView
import moxy.MvpPresenter
import javax.inject.Inject


class UsersPresenter() : MvpPresenter<UserView>() {

    @Inject
    lateinit var repository: UsersRepoScreen

    @Inject
    lateinit var router: Router

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        App.instance.appComponent.inject(this)
        repository.getUsers().subscribeByDefault()
            .subscribe({
                viewState.initList(it)
                viewState.hideLoading()
            },
                {
                    viewState.errorGetUser(it.message)
                })
    }

    fun openUserScreen(userLogin: String) {
        router.navigateTo(UserScreen(userLogin))
    }

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }
}