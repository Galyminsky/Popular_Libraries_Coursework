package me.proton.jobforandroid.popular_libraries_coursework.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import me.proton.jobforandroid.popular_libraries_coursework.core.App
import me.proton.jobforandroid.popular_libraries_coursework.di.RepositorySubcomponent
import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen.UserDetailsRepoScreen
import me.proton.jobforandroid.popular_libraries_coursework.utils.disposebleBy
import me.proton.jobforandroid.popular_libraries_coursework.utils.subscribeByDefault
import me.proton.jobforandroid.popular_libraries_coursework.view.userdetails.UserDetailsView
import moxy.MvpPresenter
import javax.inject.Inject

class UserDetailsPresenter(private val string: String?) : MvpPresenter<UserDetailsView>() {
    var userSubcomponent: RepositorySubcomponent? = null

    @Inject
    lateinit var repository: UserDetailsRepoScreen

    @Inject
    lateinit var router: Router

    private val bag = CompositeDisposable()
    private var mLogin: String? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        userSubcomponent = App.instance.appComponent.userSubcomponent()
        userSubcomponent?.inject(this)
        loadUser(string!!)
    }


    fun loadUser(login: String) {
        mLogin = login
        viewState.showLoading()
        repository.getUserWithReposByLogin(login).subscribeByDefault().subscribe({
            viewState.hideLoading()
            viewState.showUser(it)
        }, {
            Log.d("TAG", it.localizedMessage)
        }).disposebleBy(bag)
    }

    fun onBackPressed(): Boolean {
        mLogin?.let {
            router.backTo(UserScreen(it))
        }
        return true
    }

    fun openRepoScreen(repo: ReposDto) {
        router.navigateTo(RepoScreen(repo))
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
        userSubcomponent = null
    }
}