package jp.co.andfactory.master.ui.main

import jp.co.andfactory.master.data.entity.Repo
import jp.co.andfactory.master.flux.Action

/**
 * Created by watanabe on 2018/01/06.
 */
sealed class MainAction<out T>(override val type: String) : Action<T> {
    class RefreshRepo(override val data: List<Repo>)
        : MainAction<List<Repo>>(TYPE) {
        companion object {
            const val TYPE = "MainAction.RefreshRepo"
        }
    }

    class ShowRepoReadme(override val data: String)
        : MainAction<String>(TYPE) {
        companion object {
            const val TYPE = "MainAction.ShowRepoReadme"
        }
    }
}