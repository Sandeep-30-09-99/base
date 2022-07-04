package com.rk.base.utils.location

import android.location.Location

interface LocationResultListener {
    fun getLocation(location: Location)
}