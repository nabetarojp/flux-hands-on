package jp.co.andfactory.master.ui.main

import android.support.v4.app.FragmentActivity
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import jp.co.andfactory.master.data.repository.GitHubRepository
import jp.co.andfactory.master.flux.Dispatcher
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by watanabe on 2018/01/06.
 */
class MainActionCreator @Inject constructor(
        private val dispatcher: Dispatcher,
        private val repository: GitHubRepository
) {

    fun fetchRepo(repoOwner: String)
            = repository.fetchUserRepos(repoOwner)
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                    onSuccess = {
                        dispatcher.dispatch(MainAction.RefreshRepo(it))
                    },
                    onError = {
                        Timber.e(it)
                    })

    fun fetchReadme(repoOwner: String, repoName: String)
            = repository.fetchReadme(repoOwner, repoName)
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                    onSuccess = {
                        dispatcher.dispatch(MainAction.ShowRepoReadme(it.html_url))
                    },
                    onError = {
                        Timber.e(it)
                    })

    fun showReadmeDialog(activity: FragmentActivity, repoOwner: String, repoName: String) {
        ReadmeDialogFragment.newInstance(repoOwner, repoName)
                .show(activity.supportFragmentManager, "MainAction.ReadmeDialog")
    }
}