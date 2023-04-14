package me.proton.jobforandroid.popular_libraries_coursework.model.database.dao

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.proton.jobforandroid.popular_libraries_coursework.model.database.UserWithReposDBObject
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity

@Dao
abstract class UserRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllRepos(userRepoDbEntity: List<UserRepoDBEntity>): Completable

    @Query("Select * from repos")
    abstract fun queryForAllRepos(): Single<List<UserRepoDBEntity>>

    @Transaction
    @Query("Select * from users where login =:login")
    abstract fun getUsersWithRepos(login: String): Single<UserWithReposDBObject>
}