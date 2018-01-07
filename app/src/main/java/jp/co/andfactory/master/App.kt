package jp.co.andfactory.master

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.co.andfactory.master.di.DaggerAppComponent
import jp.co.andfactory.master.di.applyAutoInjector
import javax.inject.Inject

/**
 * Created by watanabe on 2018/01/05.
 */
class App : DaggerApplication() {


    @Inject lateinit var appLifecycleCallbacks: AppLifecycleCallbacks

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
        return DaggerAppComponent.builder()
                .application(this)
                .builder()
    }


}