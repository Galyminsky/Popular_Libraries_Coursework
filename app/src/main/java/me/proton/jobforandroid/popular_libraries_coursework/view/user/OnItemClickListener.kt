package me.proton.jobforandroid.popular_libraries_coursework.view.user

import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser

interface OnItemClickListener {
    fun onItemClick(gitHubUser: GitHubUser)
}