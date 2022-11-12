package dev.secondsun.superfx3dmodeller.cpu


import dev.secondsun.superfx3dmodeller.cpu.SuperFX.FlagMasks.B
import dev.secondsun.superfx3dmodeller.cpu.SuperFX.FlagMasks.ALT1
import dev.secondsun.superfx3dmodeller.cpu.SuperFX.FlagMasks.ALT2


class SuperFX {
    object Params {
        val MEMORY_SIZE = 512 * 1024
    }

    object FlagMasks {
        val ALT1: UShort = 0x0100u
        val ALT2: UShort = 0x0200u
        val B: UShort = 0x1000u
        val Z: UShort = 2u
        val CY:UShort  = 4u
        val S:UShort  = 8u
        val OV:UShort  = 16u
        val G:UShort  = 32u
        val R:UShort  = 64u
        val IL:UShort  = 0x0400u
        val IH:UShort  = 0x0800u
        val IRQ:UShort  = 0x8000u
    }


    val GENERAL_REGISTER = Array(16) {Register()}

    val memory = ByteArray(Params.MEMORY_SIZE)

    val statusRegister = Register()
    val R0 = GENERAL_REGISTER[0]
    val R1 = GENERAL_REGISTER[1]
    val R2 = GENERAL_REGISTER[2]
    val R3 = GENERAL_REGISTER[3]
    val R4 = GENERAL_REGISTER[4]
    val R5 = GENERAL_REGISTER[5]
    val R6 = GENERAL_REGISTER[6]
    val R7 = GENERAL_REGISTER[7]
    val R8 = GENERAL_REGISTER[8]
    val R9 = GENERAL_REGISTER[9]
    val R10 = GENERAL_REGISTER[10]
    val R11 = GENERAL_REGISTER[11]
    val R12 = GENERAL_REGISTER[12]
    val R13 = GENERAL_REGISTER[13]
    val R14 = GENERAL_REGISTER[14]
    val R15 = GENERAL_REGISTER[15]

    var Dreg: Register = R0
    var Sreg: Register = R0

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

    fun adc() {
        statusRegister.value = statusRegister.value and (ALT1 or ALT2 or B).inv()



        R15.value = (R15.value + 2.toUShort()).toUShort()
    }

    fun stop() {
        statusRegister.value = statusRegister.value and (ALT1 or ALT2 or B).inv()
        R15.value++
    }

    fun with(param: Int) {
        Dreg = GENERAL_REGISTER[param]
        Sreg = GENERAL_REGISTER[param]
        R15.value++
    }

    fun from(param: Int) {
        Sreg = GENERAL_REGISTER[param]
        R15.value++
    }
    fun to(param: Int) {
        Dreg = GENERAL_REGISTER[param]
        R15.value++
    }

    fun iwt(register: RegisterIndex, twoByte: UShort) {
        GENERAL_REGISTER[register].value = twoByte
        R15.value= (R15.value+3u).toUShort()
        statusRegister.value = statusRegister.value and (ALT1 or ALT2 or B).inv()
    }

    /**
     *
     * Sign extended load of data into register. 2 byte instruction
     *
     * @param register the register to load data into
     * @param data the data to load
     */
    fun ibt(register: RegisterIndex, data: UByte) {
        GENERAL_REGISTER[register].value = data.signExtend()
        statusRegister.value = statusRegister.value and (ALT1 or ALT2 or B).inv()
        R15.value= (R15.value+2u).toUShort()
    }

}

inline fun UByte.signExtend(): UShort {
    val byte = this;
    val sign = (byte and 0b10000000u);
    if (sign == 0x0.toUByte()) {
        return byte.toUShort();
    } else {
        return (byte.toUShort() or 0xFF00.toUShort())
    }

}

private operator fun <Register> Array<Register>.get(register: RegisterIndex): Register {
    return this[register.toInt()]
}
