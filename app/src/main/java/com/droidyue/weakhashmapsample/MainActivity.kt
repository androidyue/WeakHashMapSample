package com.droidyue.weakhashmapsample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val weakHashMap = WeakHashMap<Any, Int>()
    var count : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        dumpWeakInfo()
        fab.setOnClickListener { view ->
            //System.gc()// this seldom works use Android studio force gc stop
            weakHashMap.put(MyObject(count.toString()), count)
            count ++
            dumpWeakInfo()
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun dumpWeakInfo() {
        Log.i("MainActivity", "dumpWeakInfo weakInfo.size=${weakHashMap.size}")
    }

}
