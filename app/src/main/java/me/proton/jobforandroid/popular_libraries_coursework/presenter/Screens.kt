package me.proton.jobforandroid.popular_libraries_coursework.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto
import me.proton.jobforandroid.popular_libraries_coursework.view.user.UsersFragment
import me.proton.jobforandroid.popular_libraries_coursework.view.userdetails.UserDetailsFragment
import me.proton.jobforandroid.popular_libraries_coursework.view.userrepository.RepoUserFragment
import me.proton.jobforandroid.popular_libraries_coursework.view.userrepository.RepoUserFragment.Companion.KEY_REPO

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UsersFragment.getInstance()
    }
}

data class UserScreen(private val userLogin: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserDetailsFragment.newInstance(userLogin)
    }
}

data class RepoScreen(private val repo: ReposDto) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return RepoUserFragment.getInstance(Bundle().apply {
            putParcelable(KEY_REPO, repo)
        })
    }
}