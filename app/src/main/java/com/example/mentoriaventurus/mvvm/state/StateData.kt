package com.example.mentoriaventurus.mvvm.state

import androidx.annotation.Nullable


class StateData<T> {

    private var status: DataStatus? = null

    @Nullable
    private var data: Int = 0

    private var error: Throwable? = null

    fun StateData() {
        status = DataStatus.CREATED
        data = 0
        error = null
    }

    fun loading(): StateData<T>? {
        status = DataStatus.LOADING
        data = 0
        error = null
        return this
    }

    fun success(data: Int): StateData<T>? {
        status = DataStatus.SUCCESS
        this.data = data
        error = null
        return this
    }

    fun error(error: Throwable): StateData<T>? {
        status = DataStatus.ERROR
        data = 0
        this.error = error
        return this
    }

    fun complete(): StateData<T>? {
        status = DataStatus.COMPLETE
        return this
    }

    fun getStatus(): DataStatus? {
        return status
    }

    fun getData(): Int {
        return data
    }

    fun getError(): Throwable? {
        return error
    }

    enum class DataStatus {
        CREATED, SUCCESS, ERROR, LOADING, COMPLETE
    }




}