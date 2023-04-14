package me.proton.jobforandroid.popular_libraries_coursework.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto

@Parcelize
data class GitHubUser(
    val id: Int,
    val login: String,
    val avatarUrl: String?,
    val reposUrl: String?,
    var repos: List<ReposDto>? = null
) : Parcelable