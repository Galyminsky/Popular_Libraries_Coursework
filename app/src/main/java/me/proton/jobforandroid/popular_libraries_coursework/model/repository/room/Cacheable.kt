package me.proton.jobforandroid.popular_libraries_coursework.model.repository.room

import io.reactivex.rxjava3.core.Completable
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UsersDBEntity

interface Cacheable {
    fun insertRepoList(list: List<UserRepoDBEntity>): Completable
    fun insertUserList(list: List<UsersDBEntity>): Completable
}