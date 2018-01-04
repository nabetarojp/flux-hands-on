package jp.co.andfactory.master

import android.app.Application

/**
 * Created by watanabe on 2018/01/05.
 */
interface AppLifecycleCallbacks {

    fun onCreate(application : Application)

    fun onTerminate(application: Application)
}