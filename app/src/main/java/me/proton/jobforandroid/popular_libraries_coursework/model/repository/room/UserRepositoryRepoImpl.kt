package me.proton.jobforandroid.popular_libraries_coursework.model.repository.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.database.UserWithReposDBObject
import me.proton.jobforandroid.popular_libraries_coursework.model.database.dao.UserRepoDao
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity

class UserRepositoryRepoImpl(private val userRepoDao: UserRepoDao) : UserRepositoryRepo {
    override fun insertAllRepos(userRepoDbEntity: List<UserRepoDBEntity>): Completable {
        return userRepoDao.insertAllRepos(userRepoDbEntity)
    }

    override fun queryForAllRepos(): Single<List<UserRepoDBEntity>> {
        return userRepoDao.queryForAllRepos()
    }

    override fun getUsersWithRepos(login: String): Single<UserWithReposDBObject> {
        return userRepoDao.getUsersWithRepos(login)
    }
}