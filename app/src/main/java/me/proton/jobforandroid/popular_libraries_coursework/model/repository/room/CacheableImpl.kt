package me.proton.jobforandroid.popular_libraries_coursework.model.repository.room

import io.reactivex.rxjava3.core.Completable
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UsersDBEntity

class CacheableImpl(
    private val usersRepo: UsersRepo,
    private val userRepositoryRepo: UserRepositoryRepo,
) : Cacheable {
    override fun insertUserList(list: List<UsersDBEntity>): Completable {
        return usersRepo.insertAll(list)
    }

    override fun insertRepoList(list: List<UserRepoDBEntity>): Completable {
        return userRepositoryRepo.insertAllRepos(list)
    }
}