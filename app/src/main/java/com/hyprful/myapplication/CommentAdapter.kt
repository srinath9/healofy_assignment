package com.hyprful.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyprful.myapplication.databinding.CommentItemLayoutBinding
import com.hyprful.myapplication.databinding.PostItemLayoutBinding


class CommentAdapter(
    var context: Context,
    var commentList: ArrayList<Comment>
) : ListAdapter<Comment, CommentAdapter.CommentViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding: CommentItemLayoutBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context), R.layout.comment_item_layout,
                parent, false
            )

        return CommentViewHolder(binding);
    }

    override fun getItemCount(): Int {
        if (commentList == null)
            return 0;
        return commentList.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.binding.setComment(commentList[position])

        Glide.with(context).load( commentList[position].image ).into(holder.binding.image);
        holder.binding.executePendingBindings()
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Comment>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldComment: Comment,
                                         newConcert: Comment) = oldComment.id == newConcert.id

            override fun areContentsTheSame(oldComment: Comment,
                                            newConcert: Comment) = oldComment == newConcert
        }
    }


    inner class CommentViewHolder(var binding: CommentItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}