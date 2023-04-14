package me.proton.jobforandroid.popular_libraries_coursework.model.database

import androidx.room.Embedded
import androidx.room.Relation
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UsersDBEntity

data class UserWithReposDBObject(
    @Embedded
    val usersDbEntity: UsersDBEntity,
    @Relation(
        parentColumn = UsersDBEntity.PRIMARY_KEY,
        entityColumn = UserRepoDBEntity.FOREIGN_USER_KEY
    )
    val repos: List<UserRepoDBEntity>,
)