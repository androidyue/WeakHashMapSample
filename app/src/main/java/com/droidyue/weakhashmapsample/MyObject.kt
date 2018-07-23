package com.droidyue.weakhashmapsample

import android.util.Log

class MyObject(val id: String) : Any() {
    protected fun finalize() {
        Log.i("MainActivity", "Object($id) finalize method is called")
    }
}