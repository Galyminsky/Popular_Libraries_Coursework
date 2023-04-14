package me.proton.jobforandroid.popular_libraries_coursework.model.network

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReposDto(
    @Expose
    @SerializedName("id")
    var id: Int,

    @Expose
    @SerializedName("node_id")
    val nodeId: String? = null,

    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("description")
    val description: String? = null,

    @Expose
    @SerializedName("created_at")
    var createdAt: String? = null,

    @Expose
    @SerializedName("updated_at")
    val updatedAt: String? = null,


    @Expose
    @SerializedName("language")
    val language: String? = null,


    @Expose
    @SerializedName("forks_count")
    val forksCount: Int? = null,
) : Parcelable

@Parcelize
data class UsersDto(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("login")
    val login: String,

    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String,

    @Expose
    @SerializedName("repos_url")
    val reposUrl: String,
) : Parcelable