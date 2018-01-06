package jp.co.andfactory.master.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.co.andfactory.master.App
import javax.inject.Singleton


/**
 * Created by watanabe on 2018/01/05.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    UiModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun builder(): AppComponent
    }

    override fun inject(instance: App)

}