package me.proton.jobforandroid.popular_libraries_coursework.view.userrepository

import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepoUserView : MvpView {
    fun showRepo(repo: ReposDto)
}