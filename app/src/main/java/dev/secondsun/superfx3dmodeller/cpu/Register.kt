package dev.secondsun.superfx3dmodeller.cpu

import kotlin.experimental.and

class Register(private var _value: UShort = 0u) {

    var value: UShort
        get() = _value and 0xFFFFu
        set(it) { _value = (it and 0xFFFFu) }

    fun setValue(it: Int) {
        _value = (it.toUShort() and 0xFFFFu)
    }



}