package jp.co.andfactory.master.ui.main

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import jp.co.andfactory.master.di.Injectable
import jp.co.andfactory.master.view.WebViewDialog
import javax.inject.Inject

/**
 * Created by watanabe on 2018/01/06.
 */
class ReadmeDialogFragment : DialogFragment(), Injectable {

    companion object {
        private const val ARGS_REPO_OWNER = "repo_owner"
        private const val ARGS_REPO_NAME = "repo_name"
        fun newInstance(repoOwner: String, repoName: String) = ReadmeDialogFragment().apply {
            arguments = Bundle().apply {
                putString(ARGS_REPO_OWNER, repoOwner)
                putString(ARGS_REPO_NAME, repoName)
            }
        }
    }

    @Inject lateinit var actionCreator: MainActionCreator
    @Inject lateinit var store: MainStore
    private val disposable = CompositeDisposable()

    fun Disposable.disposeWhenDestroy() = disposable.add(this)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = WebViewDialog(activity!!)
        store.repoReadmeUrl
                .subscribe {
                    dialog.webView.loadUrl(it)
                }
                .disposeWhenDestroy()
        return dialog
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val owner = arguments?.getString(ARGS_REPO_OWNER) ?: return
        val name = arguments?.getString(ARGS_REPO_NAME) ?: return
        actionCreator.fetchReadme(owner, name)
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}
