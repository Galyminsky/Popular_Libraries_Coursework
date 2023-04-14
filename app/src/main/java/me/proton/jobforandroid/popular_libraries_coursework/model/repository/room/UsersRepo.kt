package me.proton.jobforandroid.popular_libraries_coursework.model.repository.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UsersDBEntity

interface UsersRepo {
    fun insertAll(usersDbEntity: List<UsersDBEntity>): Completable
    fun queryForAllUsers(): Single<List<UsersDBEntity>>
}