package me.proton.jobforandroid.popular_libraries_coursework.model.repository.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.database.dao.UsersDao
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UsersDBEntity

class UsersRepoImpl(private val usersDao: UsersDao) : UsersRepo {
    override fun insertAll(usersDbEntity: List<UsersDBEntity>): Completable {
        return usersDao.insertAll(usersDbEntity)
    }

    override fun queryForAllUsers(): Single<List<UsersDBEntity>> {
        return usersDao.queryForAllUsers()
    }
}