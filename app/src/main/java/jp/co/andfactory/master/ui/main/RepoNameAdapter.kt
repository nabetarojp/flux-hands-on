package jp.co.andfactory.master.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import jp.co.andfactory.master.R
import jp.co.andfactory.master.data.entity.Repo
import jp.co.andfactory.master.databinding.ListItemRepoNameBinding

/**
 * Created by watanabe on 2018/01/06.
 * RecyclerViewでDataBindingを使う -> http://starzero.hatenablog.com/entry/2016/05/06/215907
 * DataBindingを使っていてexecutePendingBindingsを呼び出さないとどうなるか -> https://android.gcreate.jp/358
 */
class RepoNameAdapter : RecyclerView.Adapter<RepoNameAdapter.ViewHolder>() {

    val items = ArrayList<Repo>()
    var onItemClicked: ((item: Repo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoNameAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.list_item_repo_name,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: RepoNameAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.repo = item
        holder.binding.root.setOnClickListener { onItemClicked?.invoke(item) }
        // Viewへの反映を即座に行う
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ListItemRepoNameBinding) : RecyclerView.ViewHolder(binding.root)
}