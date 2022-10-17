package dev.secondsun.superfx3dmodeller.cpu

class SuperFX {
    object Params {
        val MEMORY_SIZE = 512 * 1024
    }

    val memory = ByteArray(Params.MEMORY_SIZE)

    val statusRegister = Register()


}