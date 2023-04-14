package me.proton.jobforandroid.popular_libraries_coursework.view.user

import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : MvpView {

    fun initList(list: List<GitHubUser>)
    fun showLoading()
    fun hideLoading()
    fun errorGetUser(message: String?)
}

interface ItemClickListener {
    fun onUserClick(userLogin: String)
}