package jp.co.andfactory.master.flux

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by watanabe on 2018/01/06.
 */
abstract class BaseActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()

    fun Disposable.disposeWhenDestroy() = disposable.add(this)

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}