package dev.secondsun.superfx3dmodeller.cpu


import dev.secondsun.superfx3dmodeller.cpu.SuperFX.Flags.B
import dev.secondsun.superfx3dmodeller.cpu.SuperFX.Flags.ALT1
import dev.secondsun.superfx3dmodeller.cpu.SuperFX.Flags.ALT2
import kotlin.experimental.and
import kotlin.experimental.or

class SuperFX {
    object Params {
        val MEMORY_SIZE = 512 * 1024
    }

    object Flags {
        val ALT1: UShort = 0x0100u
        val ALT2: UShort = 0x0200u
        val B: UShort = 0x1000u
    }

    val memory = ByteArray(Params.MEMORY_SIZE)

    val statusRegister = Register()
    val R15 = Register()

    fun nop() {
        statusRegister.value = statusRegister.value and (ALT1 or ALT2 or B).inv()
        R15.value++
    }

    fun alt1() {
        statusRegister.value = statusRegister.value or ALT1
        R15.value++
    }

    fun alt2() {
        statusRegister.value = statusRegister.value or ALT2
        R15.value++
    }

    fun alt3() {
        statusRegister.value = statusRegister.value or (ALT2 or ALT1)
        R15.value++
    }

    fun stop() {
        statusRegister.value = statusRegister.value and (ALT1 or ALT2 or B).inv()
        R15.value++
    }

}