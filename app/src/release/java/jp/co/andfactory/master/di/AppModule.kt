package jp.co.andfactory.master.di

import dagger.Module
import dagger.Provides
import jp.co.andfactory.master.AppLifecycleCallbacks
import jp.co.andfactory.master.data.di.DataModule
import javax.inject.Singleton

/**
 * Created by watanabe on 2018/01/06.
 */
@Module(includes = [DataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideAppLifeCycleCallbacks(): AppLifecycleCallbacks = ReleaseAppLifecycleCallbacks()
}