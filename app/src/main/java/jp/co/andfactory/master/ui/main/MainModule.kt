package jp.co.andfactory.master.ui.main

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.co.andfactory.master.di.PerActivityScope
import jp.co.andfactory.master.flux.Dispatcher

/**
 * Created by watanabe on 2018/01/05.
 */
@Module
internal class MainModule{
    @PerActivityScope
    @Provides
    fun provideMainStore(dispatcher: Dispatcher) = MainStore(dispatcher)
}

@Module
internal abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeRepoDetailDialogFragment(): ReadmeDialogFragment
}