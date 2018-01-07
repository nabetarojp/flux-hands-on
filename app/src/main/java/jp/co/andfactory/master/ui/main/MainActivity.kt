package jp.co.andfactory.master.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import jp.co.andfactory.master.R
import jp.co.andfactory.master.databinding.MainActivityBinding
import jp.co.andfactory.master.flux.BaseActivity
import javax.inject.Inject

/**
 * Created by watanabe on 2018/01/06.
 */
class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    @Inject lateinit var actionCreator: MainActionCreator
    @Inject lateinit var store: MainStore

    private val binding by lazy { DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity) }
    private val adapter = RepoNameAdapter()
    private val ownerName = "wataanaber"

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.onItemClicked = {
            actionCreator.showReadmeDialog(this, ownerName, it.name)
        }
        store.repos
                .subscribe {
                    adapter.run {
                        items.clear()
                        items.addAll(it)
                        notifyDataSetChanged()
                    }
                }
                .disposeWhenDestroy()
        actionCreator.fetchRepo(ownerName)
    }

}