package com.li.weatherapp.data.source.utils

import java.lang.Exception

interface OnDataLoadCallback<T> {
    fun onSuccess(data: T)
    fun onFail(exception: Exception)
}
