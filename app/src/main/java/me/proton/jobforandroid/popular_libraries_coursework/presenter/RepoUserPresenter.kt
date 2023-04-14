package me.proton.jobforandroid.popular_libraries_coursework.presenter

import com.github.terrakok.cicerone.Router
import me.proton.jobforandroid.popular_libraries_coursework.core.App
import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto
import me.proton.jobforandroid.popular_libraries_coursework.view.userrepository.RepoUserView
import moxy.MvpPresenter
import javax.inject.Inject

class RepoUserPresenter(
    private val repo: ReposDto?,
) : MvpPresenter<RepoUserView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.appComponent.inject(this)
        repo?.let { viewState.showRepo(it) }
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}