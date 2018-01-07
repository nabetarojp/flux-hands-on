package jp.co.andfactory.master.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.andfactory.master.ui.main.MainActivity
import jp.co.andfactory.master.ui.main.MainFragmentModule
import jp.co.andfactory.master.ui.main.MainModule

/**
 * Created by watanabe on 2018/01/05.
 */
@Module
internal abstract class UiModule {

    @PerActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}