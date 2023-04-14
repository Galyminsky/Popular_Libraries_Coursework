package me.proton.jobforandroid.popular_libraries_coursework.view.userdetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import me.proton.jobforandroid.popular_libraries_coursework.databinding.FragmentUserScreenBinding
import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser
import me.proton.jobforandroid.popular_libraries_coursework.presenter.UserDetailsPresenter
import me.proton.jobforandroid.popular_libraries_coursework.utils.hide
import me.proton.jobforandroid.popular_libraries_coursework.utils.loadGlide
import me.proton.jobforandroid.popular_libraries_coursework.utils.show
import me.proton.jobforandroid.popular_libraries_coursework.view.main.OnBackPressedListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, OnBackPressedListener {

    private val reposAdapter = ReposAdapter {
        presenter.openRepoScreen(it)

    }


    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(arguments?.getString(KEY_USER))
    }

    private var binding: FragmentUserScreenBinding? = null

    companion object {
        const val KEY_USER = "KEY_USER"
        fun newInstance(userLogin: String) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_USER, userLogin)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentUserScreenBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvGitHubUserRepos?.adapter = reposAdapter
        binding?.rvGitHubUserRepos?.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onBackPressed() = presenter.onBackPressed()

    @SuppressLint("SetTextI18n")
    override fun showUser(user: GitHubUser) {
        TransitionManager.beginDelayedTransition(binding?.root)
        binding?.userName?.text = user.login
        binding?.ivUserAvatar?.loadGlide(user.avatarUrl)
        binding?.userRepos?.text = "Repo:" + user.repos?.size.toString()
        user.repos?.let { list ->
            reposAdapter.repos = list.sortedByDescending { it.createdAt }
        }
    }

    override fun showLoading() {
        TransitionManager.beginDelayedTransition(binding?.root)
        binding?.apply {
            progressBar.show()
            userName.hide()
            ivUserAvatar.hide()
            rvGitHubUserRepos.hide()
            userRepos.hide()
        }
    }

    override fun hideLoading() {
        binding?.apply {
            progressBar.hide()
            userName.show()
            ivUserAvatar.show()
            rvGitHubUserRepos.show()
            userRepos.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}