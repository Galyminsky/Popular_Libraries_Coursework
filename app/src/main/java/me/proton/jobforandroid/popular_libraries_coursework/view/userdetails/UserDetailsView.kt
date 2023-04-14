package me.proton.jobforandroid.popular_libraries_coursework.view.userdetails

import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : MvpView {
    fun showUser(user: GitHubUser)
    fun showLoading()
    fun hideLoading()
}