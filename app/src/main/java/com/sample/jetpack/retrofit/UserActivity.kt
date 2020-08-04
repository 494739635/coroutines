package com.sample.jetpack.retrofit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.sample.jetpack.R
import com.sample.jetpack.databinding.ActivityUserBinding
import kotlinx.android.synthetic.main.activity_user.*


class UserActivity : AppCompatActivity() {

    val viewModel: UserViewModel by viewModels { UserVMFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityUserBinding>(
            this, R.layout.activity_user
        )
        binding.lifecycleOwner = this

        // Bind ViewModel
        binding.viewModel = viewModel
        completeBtn.setOnClickListener {
            viewModel.login(mobileEt.text.toString(), codeEt.text.toString())
                .observe(this, Observer {
                    userId.text = it.user_id.toString()
                    viewModel.getUserInfo(it.user_id)
                        .observe(this, Observer { user ->
                            userName.text = user.nickName
                        })
                })
        }
    }
}
