package com.rk.base.utils.event

import androidx.lifecycle.viewModelScope
import com.rk.base.data.local.SharedPrefManager
import com.rk.base.utils.Resource
import com.rk.base.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

fun <T> BaseViewModel.apiSubscription(
    method: Method<T>,
    liveData: SingleLiveEvent<Resource<T>>
) {
    viewModelScope.launch(Dispatchers.IO) {
        liveData.postValue(Resource.loading(null))
        try {
            var token: String? = null
            SharedPrefManager.getToken()?.let { it ->
                token = "Bearer $it"
            }

            method.getSimpleApiMethod(token).let {
                if (it?.body()?.isStatus == true) {
                    it.body()?.success?.let {
                        liveData.postValue(Resource.success(it.data, it.message))
                    }
                } else {
                    liveData.postValue(setThrowableCode(it))
                }
            }
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                liveData.postValue(Resource.error("No Internet Connection", null))
            } else {

            }
        }
    }
}



