package com.sample.jetpack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.jetpack.databinding.ActivityMainBinding
import com.sample.jetpack.lifecycle.Activity
import com.sample.jetpack.retrofit.UserActivity

class MainActivity : AppCompatActivity() {

    private val viewmodel: LiveDataModel by viewModels { LiveDataVMFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )
        binding.lifecycleOwner = this

        // Bind ViewModel
        binding.viewmodel = viewmodel
    }

    fun gotoMain2(view: View) {
        startActivity(Intent(this, Activity::class.java))
    }

    fun gotoUser(view: View) {
        startActivity(Intent(this, UserActivity::class.java))
    }


}
