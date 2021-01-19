package com.hyprful.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyprful.myapplication.databinding.PostItemLayoutBinding


class PostAdapter(
    var context: Context,
    var postList: ArrayList<Post>,
    var clickListner : PostClickListner
) : ListAdapter<Post, PostAdapter.PostViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: PostItemLayoutBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context), R.layout.post_item_layout,
                parent, false
            )

        return PostViewHolder(binding);
    }

    override fun getItemCount(): Int {
        if (postList == null)
            return 0;
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.setPost(postList[position])
        holder.binding.setClickListner(clickListner)

        Glide.with(context).load( postList[position].image ).into(holder.binding.image);
        holder.binding.executePendingBindings()
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Post>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldPost: Post,
                                         newConcert: Post) = oldPost.id == newConcert.id

            override fun areContentsTheSame(oldPost: Post,
                                            newConcert: Post) = oldPost == newConcert
        }
    }


    inner class PostViewHolder(var binding: PostItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}