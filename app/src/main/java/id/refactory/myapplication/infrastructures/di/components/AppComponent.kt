package id.refactory.myapplication.infrastructures.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import id.refactory.myapplication.infrastructures.di.modules.*
import id.refactory.myapplication.ui.presenters.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidModule::class,
    ApiModule::class,
    MapperModule::class,
    PersistenceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}