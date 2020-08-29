# kt_android_list_app

I am actually unfamiliar with Kotlin, this is my first time getting in touch with Kotlin.
So, debugging this application was a big challenge for me. However, I still didn't get
to fully understand how MVP Dagger2 works in Kotlin. As an addition to that, some of
the syntaxes are still new for me.
But from what I've seen from the app and also some changes that I made, I understand 
there might some variables or property that haven't been implemented or initialized yet.
To do this debugging, I read an article in Medium about MVP Dagger 2, and I realized that 
the app needs to inject the Presenter to the DaggerComponent itself. But when I looked into,
AppComponent.kt, the DaggerComponent returns error. I thought it was because of the dependency,
so I tried to update it, but I failed, and I stayed with the status quo of the old dependency for Dagger2.
And I changed the DaggerComponent to : 
@Component.Builder
 interface Builder {
 @BindsInstance
 fun application(application: Application): Builder
 fun build(): AppComponent
 }
 
And it works fine tho I still didn't know if it is the best approach or not, since this is all totally
new to me. As it works fine, I injected the presenter to the component builder. It still doesn't work,
because the variable getUsers in MainPresenter.kt was not initialized yet. So, what I did was,
I initialized the getUsers variable and it started showing the app container, but it soon becomes forced close.
I realize that the way I called the interface is still incorrect, as it returns the error as :
 lateinit property userApi has not been initialized
I stopped the development right there since I was running out of time at 5 in the morning, and I needed to have some rest.
And I just get the time to write this read.me down. So I am truly appreciate if you read all of these words.
As an addition to it, I am currently ready the Medium article, re-reading it to be more thorough.
And I wanted still to do the debugging. But I will do it on a separate branch so that it won't bother the test result.


Thank you.
Victoria
