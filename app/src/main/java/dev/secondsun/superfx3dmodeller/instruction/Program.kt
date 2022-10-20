package dev.secondsun.superfx3dmodeller.instruction

import dev.secondsun.superfx3dmodeller.cpu.SuperFX

class Program(val bank: Byte = 0,val  address: Short = 0,val  instructions: SuperFX.() -> Unit) {

    lateinit var state:SuperFX;

    fun execute() {
        state = SuperFX()
        instructions.invoke(state)


    }
}