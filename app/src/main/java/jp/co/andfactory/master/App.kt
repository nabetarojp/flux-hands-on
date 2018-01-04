package jp.co.andfactory.master

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.co.andfactory.master.di.applyAutoInjector

/**
 * Created by watanabe on 2018/01/05.
 */
class App : DaggerApplication() {

    lateinit var appLifecycleCallbacks: AppLifecycleCallbacks

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
        appLifecycleCallbacks.onCreate(this)
    }

    override fun onTerminate() {
        appLifecycleCallbacks.onTerminate(this)
        super.onTerminate()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}