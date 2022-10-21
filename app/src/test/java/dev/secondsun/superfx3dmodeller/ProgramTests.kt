package dev.secondsun.superfx3dmodeller

import dev.secondsun.superfx3dmodeller.cpu.SuperFX.FlagMasks.ALT1
import dev.secondsun.superfx3dmodeller.instruction.Program
import org.junit.Assert.assertEquals
import org.junit.Test

class ProgramTests {
    @Test
    fun executeNopBasicProgram() {
        var machine = Program {
            nop()
            alt1()
        }.also { it.execute() }.state
        assert(machine.R15.value == 2.toUShort())
        assert(machine.statusRegister.value == ALT1)
    }


    @Test
    fun executeBasicProgram() {
        var machine = Program {
            nop()
            nop()
            alt1()
            nop()
            alt2()
            nop()
            nop()
            alt3()
            nop()
            stop()
        }.also { it.execute() }.state
        assert(machine.R15.value == 10.toUShort())
        assertEquals(0.toUShort(), machine.statusRegister.value )
        /*
        * Program(address) {
        *  nop
        *  ...
        *  stop
        * }
        *
        * SuperFx.PBR(bank, address).start() ?
        *
        * */
    }

    @Test
    fun assembleBasicProgram() {
        TODO(
            """
            Assemble
                nop
                nop
                alt1
                nop
                alt2
                nop
                nop
                alt3
                nop
                stop
        """.trimIndent()
        )
        /*
        * Program(address) {
        *  nop
        *  ...
        *  stop
        * }
        *
        * SuperFx.PBR(bank, address).start() ?
        *
        * */
    }

}