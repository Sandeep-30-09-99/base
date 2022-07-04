package com.rk.base.ui.welcome

import androidx.activity.viewModels
import com.rk.base.R
import com.rk.base.databinding.ActivityWelcomeBinding
import com.rk.base.ui.base.BaseActivity
import com.rk.base.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    private val viewmodel: WelcomeActivityVM by viewModels()

    override fun getLayoutResource(): Int {
        return R.layout.activity_welcome
    }

    override fun getViewModel(): BaseViewModel {
        return viewmodel
    }

    override fun onCreateView() {

    }

}