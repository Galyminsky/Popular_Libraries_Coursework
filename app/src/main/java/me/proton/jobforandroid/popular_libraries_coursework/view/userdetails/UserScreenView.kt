package me.proton.jobforandroid.popular_libraries_coursework.view.userdetails

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserScreenView : MvpView {
    fun setUser(login: String?)
}