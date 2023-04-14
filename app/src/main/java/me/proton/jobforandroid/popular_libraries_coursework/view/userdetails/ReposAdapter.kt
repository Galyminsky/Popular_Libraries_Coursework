package me.proton.jobforandroid.popular_libraries_coursework.view.userdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.proton.jobforandroid.popular_libraries_coursework.databinding.ItemReposBinding
import me.proton.jobforandroid.popular_libraries_coursework.model.network.ReposDto

typealias OnUserClickListener = (repo: ReposDto) -> Unit

class ReposAdapter(
    private val onUserClickListener: OnUserClickListener,
) : RecyclerView.Adapter<GitHubUserReposViewHolder>() {

    var repos: List<ReposDto> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserReposViewHolder {
        return GitHubUserReposViewHolder(
            ItemReposBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onUserClickListener
        )
    }

    override fun onBindViewHolder(holder: GitHubUserReposViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount() = repos.size
}

class GitHubUserReposViewHolder(
    private val binding: ItemReposBinding,
    private val onUserClickListener: OnUserClickListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ReposDto) = with(binding) {

        nameRepo.text = item.name

        dateCreating.text = item.createdAt

        languageRepo.text = item.language
        root.setOnClickListener {
            onUserClickListener.invoke(item)
        }
    }
}