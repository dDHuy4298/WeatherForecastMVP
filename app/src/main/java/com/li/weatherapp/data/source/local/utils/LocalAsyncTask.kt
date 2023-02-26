package com.li.weatherapp.data.source.local.utils

import android.os.AsyncTask
import com.li.weatherapp.data.source.utils.OnDataLoadCallback

@Suppress("DEPRECATION")
class LocalAsyncTask<T, U>(
    private val callback: OnDataLoadCallback<U>,
    private val handle: (T) -> U
) : AsyncTask<T, Unit, U?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: T): U? =
        try {
            handle(params[0])
        } catch (e: Exception) {
            exception = e
            null
        }

    override fun onPostExecute(result: U?) {
        super.onPostExecute(result)
        result?.let(callback::onSuccess) ?: (callback::onFail)
    }
}
