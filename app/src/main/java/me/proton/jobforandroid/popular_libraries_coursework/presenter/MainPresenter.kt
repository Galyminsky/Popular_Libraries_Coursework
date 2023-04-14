package me.proton.jobforandroid.popular_libraries_coursework.presenter

import com.github.terrakok.cicerone.Router
import me.proton.jobforandroid.popular_libraries_coursework.view.main.MainView
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}