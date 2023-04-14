package me.proton.jobforandroid.popular_libraries_coursework.model.repository.screen

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser
import me.proton.jobforandroid.popular_libraries_coursework.model.network.GitHubApiRepo
import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.Cacheable
import me.proton.jobforandroid.popular_libraries_coursework.model.repository.room.UserRepositoryRepo
import me.proton.jobforandroid.popular_libraries_coursework.utils.doCompletableIf
import me.proton.jobforandroid.popular_libraries_coursework.utils.mapRepos
import me.proton.jobforandroid.popular_libraries_coursework.utils.mapReposToObject
import me.proton.jobforandroid.popular_libraries_coursework.utils.mapToEntity


class UserDetailsRepoScreenImpl(
    private val githubApiRepo: GitHubApiRepo,
    private val userRepositoryRepo: UserRepositoryRepo,
    private val networkStatus: Single<Boolean>,
    private val roomCache: Cacheable,
) : UserDetailsRepoScreen {

    override fun getUserWithReposByLogin(login: String): Single<GitHubUser> {
        return networkStatus.flatMap { hasConnection ->
            if (hasConnection) {
                getUserWithRepoApi(login)
            } else {
                getUserWithReposBD(login)
            }
        }
    }


    private fun getUserWithReposBD(login: String): Single<GitHubUser> {
        return userRepositoryRepo.getUsersWithRepos(login).map { userWithRepos ->
            val user = mapToEntity(userWithRepos.usersDbEntity)
            user.repos = userWithRepos.repos.map {
                it.createdAt = it.createdAt?.substring(0, 10)
                mapRepos(it)
            }
            user
        }
    }

    private fun getUserWithRepoApi(login: String): Single<GitHubUser> {
        return Single.zip(
            getUserByLogin(login),
            getReposByLogin(login)
        ) { user, repos ->
            repos.map {
                it.createdAt = it.createdAt?.substring(0, 10)
                it
            }
            user.repos = repos
            user
        }.doCompletableIf(true) { user ->
            user.repos?.let { repos ->
                roomCache.insertRepoList(repos.map { repo ->
                    mapReposToObject(repo, user.id)
                })
            } ?: Completable.create {
                it.onError(Throwable(message = "Repos is Empty"))
            }
        }
    }

    private fun getUserByLogin(login: String): Single<GitHubUser> {
        return githubApiRepo.getUser(login).map(::mapToEntity)
    }

    private fun getReposByLogin(login: String): Single<List<ReposDto>> {
        return githubApiRepo.getRepos(login)
    }
}