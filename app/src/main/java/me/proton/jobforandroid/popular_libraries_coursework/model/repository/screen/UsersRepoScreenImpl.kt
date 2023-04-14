package me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen

import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApiRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.Cacheable
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.UsersRepo
import me.proton.jobforandroid.popular_libraries_coursework.utils.doCompletableIf
import me.proton.jobforandroid.popular_libraries_coursework.utils.mapToDBObject
import me.proton.jobforandroid.popular_libraries_coursework.utils.mapToEntity

class UsersRepoScreenImpl(
    private val githubApiRepo: GitHubApiRepo,
    private val usersRepo: UsersRepo,
    private val networkStatus: Single<Boolean>,
    private val roomCache: Cacheable,
) : UsersRepoScreen {
    override fun getUsers(): Single<List<GitHubUser>> {
        return networkStatus.flatMap { hasConnection ->
            if (hasConnection) getUsersApi(true)
            else getUsersBD()
        }
    }

    private fun getUsersApi(shouldPersist: Boolean): Single<List<GitHubUser>> {
        return githubApiRepo.getAllUsers().doCompletableIf(shouldPersist) {
            roomCache.insertUserList(it.map(::mapToDBObject))
        }.map { it.map(::mapToEntity) }
    }

    private fun getUsersBD(): Single<List<GitHubUser>> {
        return usersRepo.queryForAllUsers().map { it.map(::mapToEntity) }
    }
}