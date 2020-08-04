package com.sample.jetpack.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sample.jetpack.R
import kotlinx.android.synthetic.main.activity_.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
        lifecycle.addObserver(MyLifecycle())
        lifecycle.addObserver(EventBusLifecycle.getInstance())
        btn.setOnClickListener {
            EventBus.getDefault().post(EventBean())
        }
        Log.e("sxq_act", "Activity：onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("sxq_act", "Activity：onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("sxq_act", "Activity：onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("sxq_act", "Activity：onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("sxq_act", "Activity：onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("sxq_act", "Activity：onDestroy")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onReceiveEvent(event: EventBean) {
        content.text = "收到了事件的消息"
    }



}
