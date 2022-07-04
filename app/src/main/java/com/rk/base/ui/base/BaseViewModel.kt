package com.rk.base.ui.base

import android.view.View
import androidx.lifecycle.ViewModel
import com.rk.base.di.base.SimpleApiResponse
import com.rk.base.utils.Resource
import com.rk.base.utils.event.SingleActionEvent
import com.rk.base.utils.event.SingleLiveEvent
import retrofit2.Response
import java.net.HttpURLConnection

open class BaseViewModel : ViewModel() {

    val onClick: SingleActionEvent<View> = SingleActionEvent()
    val onUnAuth: SingleLiveEvent<Int> = SingleLiveEvent()

    override fun onCleared() {
        super.onCleared()
    }

    open fun onClick(view: View?) {
        onClick.value = view
    }

    fun <T> setThrowableCode(resource: Response<SimpleApiResponse<T>>?): Resource<T>? {
        if (resource?.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            onUnAuth.postValue(resource.code())
            return null
        }
        return Resource.error(resource?.errorBody().toString(), null)
    }

   /* fun getErrorText(errorBody: ResponseBody?): String {
        val text: String? = errorBody?.string()
        if (!text.isNullOrEmpty()) {
            return try {
                val obj = JSONObject(text)
                obj.getString("message")
            } catch (e: Exception) {
                return text
            }
        }
        return errorBody.message().toString()
    }
*/


}