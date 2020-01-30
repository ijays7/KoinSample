package com.ijays.koinsample.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.ijays.koinsample.MainContract
import com.ijays.koinsample.R
import com.ijays.koinsample.model.Data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.androidx.scope.currentScope
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {

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
        parametersOf(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainPresenter.queryFromDB()

        initListener()
    }

    private fun initListener() {
        bt_save.setOnClickListener {
            mainPresenter.saveToDB(et_input.text.toString())
        }

        bt_query.setOnClickListener {
            mainPresenter.queryFromDB()
        }


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun displayDBList(list: MutableList<String>) {
        val builder = StringBuilder()
        list.forEach {
            builder.append(it).append("\n")
        }
        tv_text.text = builder.toString()
    }

    override fun queryDBError(str: String) {
        Log.e("ijays", "queryDB error==>$str")
    }
}
