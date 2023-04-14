package me.proton.jobforandroid.popular_libraries_coursework.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.proton.jobforandroid.popular_libraries_coursework.model.database.dao.UserRepoDao
import me.proton.jobforandroid.popular_libraries_coursework.model.database.dao.UsersDao
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UserRepoDBEntity
import me.proton.jobforandroid.popular_libraries_coursework.model.database.entity.UsersDBEntity

@Database(
    entities = [UsersDBEntity::class, UserRepoDBEntity::class],
    version = 1,
    exportSchema = false
)

abstract class GitHubDB : RoomDatabase() {
    abstract fun usersDao(): UsersDao
    abstract fun userRepoDao(): UserRepoDao

    companion object {
        fun create(context: Context): GitHubDB {
            return Room.databaseBuilder(context, GitHubDB::class.java, "github.db").build()
        }
    }
}