package id.refactory.myapplication.ui.presenters

import id.refactory.data.persistences.contracts.UserPersistenceInterface
import id.refactory.data.persistences.mappers.UserDataMapper
import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.domain.User
import id.refactory.myapplication.infrastructures.api.UserApi
import id.refactory.myapplication.infrastructures.persistences.api.UserApiPersistence
import id.refactory.myapplication.ui.views.MainView
import id.refactory.usecases.GetUsers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class MainPresenter(var view: MainView.View?) : MainView.Presenter {
    lateinit var userApi: UserApi
    lateinit var dataMapper: UserDataMapper
    var getUsers = GetUsers(
        UserRepository(UserApiPersistence(userApi), dataMapper),
        CompositeDisposable(),
        AndroidSchedulers.mainThread()
    )

    override fun onLoadUsers(params: Map<String, String>) {
        getUsers.getUsers(GetUsersObserver(), params)
    }

    override fun onDestroy() {
        view = null
        getUsers.dispose()
    }

    inner class GetUsersObserver : DisposableObserver<List<User>>() {
        override fun onComplete() {}
        override fun onNext(t: List<User>) {
            view?.onSuccessLoadUsers(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }
}