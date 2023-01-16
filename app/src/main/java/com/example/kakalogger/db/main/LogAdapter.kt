package com.example.kakalogger.db.main

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

internal class LogAdapter : ListAdapter<Log?, UserViewHolder?>(User.DIFF_CALLBACK) {
    fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<User> = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                @NonNull oldUser: User, @NonNull newUser: User
            ): Boolean {
                // User properties may have changed if reloaded from the DB, but ID is fixed
                return oldUser.getId() === newUser.getId()
            }

            override fun areContentsTheSame(
                @NonNull oldUser: User, @NonNull newUser: User
            ): Boolean {
                // NOTE: if you use equals, your object must properly override Object#equals()
                // Incorrectly returning false here will result in too many animations.
                return oldUser.equals(newUser)
            }
        }
    }
}