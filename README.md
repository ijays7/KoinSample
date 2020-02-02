[![CircleCI](https://circleci.com/gh/ijays7/KoinSample.svg?style=svg)](https://circleci.com/gh/ijays7/KoinSample)

此项目演示如何使用 [koin](https://github.com/InsertKoinIO/koin) 进行依赖注入，目前采用的是 MVP + RxJava 的架构。

## 什么是koin

koin 是一个针对 Kotlin 的轻量级的依赖注入框架。

## 如何使用

相对于 **Dagger** 之类的依赖注入框架，它使用起来确实很简单，没有前者那么繁琐的配置，koin 的使用一般只有三个步骤：

1. 声明一个 koin module
2. 注册 koin
3. 在代码中使用 koin 进行注入

下面将分别介绍这三个步骤。

### 声明koin module

```kotlin
val applicationModule = module(override = true) {
   single {
        AppDatabase.getInstance()
    }  
   
  // 声明一个和 MainActivity 绑定的注入对象
   scope<MainActivity> {
        scoped<MainContract.Presenter<Data>> { (v: MainContract.View) ->
            MainPresenter(view = v)
        }
    }
}
```

在上面的的代码中，我们定义了一个 koin module，具体参数是什么意思呢？

1. module 被标记为为了 **override**，表示它的内容会应用内每次其他的定义所覆盖。

2. **single** 表示注入的是一个单例对象，即在应用生命周内返回的都是唯一的实例，通常用在 database 或者 repository 的实例中。

3. **scope** API 是2.0版本后新加入的 API，它的作者是这样描述的：

   > A scope is a context with a fixed duration of time, in which an object exists. When the scope ends, any objects bound under that scope cannot be injected again. To better have an image of that, think that a scope is like a box: a space where you put things and throw it when you don’t need it anymore.

   即这个对象只有在某个固定的时间才能被注入，比如在 Activity 中，使用 scope 注入的对象在首次使用时被注入，之后再次注入返回的也是同一个对象，即这个对象在这段时间是暂时单例的，直到 Activity 收到 **ON_DESTROY** 的回调（这里参考 Lifecycle 框架）。

### 注册 koin

我们可以直接在 App 的 onCreate 方法中 去 startKoin。

```kotlin
 override fun onCreate() {
        super.onCreate()
        sInstance = this

        startKoin {
            // use Koin Andorid Logger
            androidLogger()
            // declare Android context
            androidContext(this@App)
            // declare modules to use
            modules(listOf(applicationModule))
        }

    }
```

当然也可以使用 **loadKoinModules** 和 **unloadKoinModules** 方法去动态加载和取消 module。

```kotlin
val coffeeAppModule = module {
    single { CoffeeMaker(get(), get()) }
    single<Pump> { Thermosiphon(get()) }
    single<Heater> { ElectricHeater() }
}

// starting your module either by startKoin
startKoin { modules(coffeeAppModule) }
// or after start
loadKoinModules(coffeeAppModule)

// resolve CoffeeMaker
get()<CoffeeMaker>

// drop module's definitions & instances when you don't need it anymore
unloadKoinModules(coffeeAppModule)
```



### 在代码中注入

完成前面两步之后，就可以直接在代码中进行注入了。需要注意的是，在非 Activity 和 fragment 中使用 Koin 注入类需要实现 KoinComponent 接口。

```kotlin
   /**
     * 使用默认初始化方式
     */
//    private val mainPresenter: MainContract.Presenter<Data> by lazy {
//        MainPresenter(this)
//    }

    /**
     * 使用 Koin 依赖注入, mainPresenter 仅在 MainActivity 的生命周期内有效
     */
    private val mainPresenter: MainContract.Presenter<Data> by currentScope.inject {
        parametersOf(this) }
```

实现 KoinComponent 接口：

```kotlin
object AppRepository : KoinComponent {
    /**
     * 使用默认方式初始化 database
     */
//    private val database: AppDatabase by lazy {
//        AppDatabase.getInstance()
//    }

    /**
     * 使用 Koin 进行注入
     */
    private val database: AppDatabase by inject()

  //...    
}
```



## 使用感受

Koin 的一套流程走下来，发现确实使用起来很简单，不仅如此，它没有使用像 Dagger 一样使用注解，也就是说不会额外的生成代码和使用 kapt，都是 Kotlin 的原生代码，这样也就不会增加编译项目的时间了。

Koin 使用下来一个不好的地方就是只要有配置错误，程序就会立马崩溃（这一点在刚开始写的时候经常遇到），比如 module 中依赖配置错误，同样的情况使用 Dagger 就能在编译期进行警告，而不是等到运行的时候崩溃。

总的来说，Koin 还是一个很好的 DI 工具，基于 DSL，纯 Kotlin，上手快，配置简单，如果是自己的项目的话就大胆的上吧。