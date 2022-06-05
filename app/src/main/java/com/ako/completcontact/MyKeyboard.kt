package com.ako.completcontact

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.key_board.view.*

class MyKeyboard : InputMethodService(),KeyboardView.OnKeyboardActionListener {

    @SuppressLint("ResourceType")
    override fun onCreateInputView(): View {
        val kv=layoutInflater.inflate(R.layout.key_board,null)
        val Keyboard=Keyboard(this,R.xml.keyboard)
        kv.setBackgroundResource(R.xml.keyboard)
        return kv
    }
    override fun swipeRight() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPress(primaryCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRelease(primaryCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun swipeLeft() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun swipeUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun swipeDown() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onText(text: CharSequence?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
