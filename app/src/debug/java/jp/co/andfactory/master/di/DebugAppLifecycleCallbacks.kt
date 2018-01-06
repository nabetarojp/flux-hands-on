package jp.co.andfactory.master.di

import android.app.Application
import jp.co.andfactory.master.AppLifecycleCallbacks
import timber.log.Timber

/**
 * Created by watanabe on 2018/01/06.
 */
class DebugAppLifecycleCallbacks : AppLifecycleCallbacks {

    override fun onCreate(application: Application) {
        Timber.plant(Timber.DebugTree())
    }

    override fun onTerminate(application: Application) {

    }
}