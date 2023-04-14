package me.proton.jobforandroid.popular_libraries_coursework.model.repository.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.database.UserWithReposDBObject
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity

interface UserRepositoryRepo {
    fun insertAllRepos(userRepoDbEntity: List<UserRepoDBEntity>): Completable
    fun queryForAllRepos(): Single<List<UserRepoDBEntity>>
    fun getUsersWithRepos(login: String): Single<UserWithReposDBObject>
}