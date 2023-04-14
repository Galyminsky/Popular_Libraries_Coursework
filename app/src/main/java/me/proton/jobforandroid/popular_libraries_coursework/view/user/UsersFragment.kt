package me.proton.jobforandroid.popular_libraries_coursework.view.user

import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import me.proton.jobforandroid.popular_libraries_coursework.databinding.FragmentUserListBinding
import me.proton.jobforandroid.popular_libraries_coursework.model.GitHubUser
import me.proton.jobforandroid.popular_libraries_coursework.presenter.UsersPresenter
import me.proton.jobforandroid.popular_libraries_coursework.utils.hide
import me.proton.jobforandroid.popular_libraries_coursework.utils.show
import me.proton.jobforandroid.popular_libraries_coursework.view.main.OnBackPressedListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {

    private val adapter = UserAdapter {
        presenter.openUserScreen(it)
    }


    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter()
    }

    //   private val listener = object : ItemClickListener {
    //       override fun onUserClick(user: GitHubUser) {
    //           detailsPresenter.openUserScreen(user)
    //       }
    //   }

    private lateinit var binding: FragmentUserListBinding

    companion object {
        fun getInstance(): UsersFragment {
            return UsersFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // adapter.setOnUserClickListener(listener)
        binding.rvGitHubUsers.adapter = adapter
        binding.rvGitHubUsers.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun initList(list: List<GitHubUser>) {
        TransitionManager.beginDelayedTransition(binding.root)
        adapter.users = list
    }

    override fun showLoading() {
        binding.progressBarList.show()
    }

    override fun hideLoading() {
        binding.progressBarList.hide()
    }

    override fun errorGetUser(message: String?) {
        Log.d("TAG", "errorGetUser() called with: message = $message")
    }


    override fun onBackPressed() = presenter.onBackPressed()

}