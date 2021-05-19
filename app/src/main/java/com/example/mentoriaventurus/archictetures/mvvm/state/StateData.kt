package com.example.mentoriaventurus.archictetures.mvvm.state

import androidx.annotation.Nullable

enum class DataStatus {
    CREATED, SUCCESS, ERROR, LOADING, COMPLETE
}

class StateData<T> {

    var status: DataStatus? = null

    @Nullable
    var data: T? = null

    var error: Throwable? = null

    fun StateData() {
        status = DataStatus.CREATED
        error = null
    }

    fun loading(): StateData<T>? {
        status = DataStatus.LOADING
        data = null
        error = null

        return this
    }

    fun success(data: T): StateData<T>? {
        status = DataStatus.SUCCESS
        this.data = data
        error = null

        return this
    }

    fun error(error: Throwable): StateData<T>? {
        status = DataStatus.ERROR
        data = null
        this.error = error

        return this
    }

    fun complete(): StateData<T> {
        status = DataStatus.COMPLETE

        return this
    }
}