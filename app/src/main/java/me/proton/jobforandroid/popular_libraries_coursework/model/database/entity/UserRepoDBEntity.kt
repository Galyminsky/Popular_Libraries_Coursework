package me.proton.jobforandroid.popular_libraries_coursework.model.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class UserRepoDBEntity(
    @PrimaryKey
    @ColumnInfo(name = PRIMARY_KEY) // можно менять название
    val id: Int,
    val forks: Int? = null,
    val name: String? = null,
    val nodeId: String? = null,
    val description: String? = null,
    var createdAt: String? = null,
    val updatedAt: String? = null,
    val language: String? = null,
    @ColumnInfo(name = FOREIGN_USER_KEY)
    val userId: Int,
) {
    companion object {
        const val PRIMARY_KEY = "id"
        const val FOREIGN_USER_KEY = "userId"
    }
}