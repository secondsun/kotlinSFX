package dev.secondsun.superfx3dmodeller.instruction

import dev.secondsun.superfx3dmodeller.cpu.RegisterIndex
import org.jetbrains.annotations.NotNull

interface InstructionList {
    /**
     * This instruction adds the source register, the operand, and the
     * carry flag. The result is stored in the destination register.
     * Source and destination registers are specified in advance using
     * a WITH, FROM, or TO instruction. When not specified, these
     * registers default to R0
     * The operand can be any of registers R0-R15
     */
    fun adc(index :RegisterIndex)


    fun adc(operand :UByte)

    fun add(index: RegisterIndex)
    fun add(operand:UByte)
    fun alt1()
    fun alt2()
    fun alt3()
    fun and(index:RegisterIndex)
    fun and(data : UByte)
    fun asr()

    fun bcc(offset:Byte)
    fun bcs(offset:Byte)
    fun beq(offset:Byte)
    fun bge(offset:Byte)


    fun bic(index:RegisterIndex)
    fun bic(index:UByte)

    fun blt(offset:Byte)
    fun bmi(offset:Byte)
    fun bne(offset:Byte)
    fun bpl(offset:Byte)
    fun bra(offset:Byte)
    fun bvc(offset:Byte)
    fun bvs(offset:Byte)

    fun cache()
    fun cmode()
    fun cmp(index: RegisterIndex)
    fun color()
    fun dec(index: RegisterIndex)
    fun div2()
    fun fmult()
    fun from (index: RegisterIndex)
    fun getb()
    fun getbh()
    fun getbl()
    fun getbs()
    fun getc()
    fun hib()
    fun ibt(index: RegisterIndex, x:UByte)
    fun inc(index: RegisterIndex)
    fun iwt(index: RegisterIndex, x:UShort)
    fun jmp(index: RegisterIndex)
    fun ldb(index: RegisterIndex)
    fun ldw(index: RegisterIndex)
    fun lea (index: RegisterIndex, data : UShort)
    fun link(data:UByte)
    fun ljmp(index: RegisterIndex)
    fun lm (index: RegisterIndex, data:UShort)
    fun lms(index: RegisterIndex, data:UByte)
    fun lmult()
    fun lob()
    fun loop()
    fun lsr()
    fun merge()
    fun move(index1: RegisterIndex, index2: RegisterIndex)
    fun move(index: RegisterIndex, data: Integer)
    fun moveFromAddress(index: RegisterIndex, data: UShort)
    fun moveToAddress(data: UShort, index: RegisterIndex)

    fun movebFromMemory(index1: RegisterIndex, index2: RegisterIndex)
    fun movebToMemory(index1: RegisterIndex, index2: RegisterIndex)
    fun moves(index1: RegisterIndex, index2: RegisterIndex)
    fun movewFromMemory(index1: RegisterIndex, index2: RegisterIndex)
    fun movewToMemory(index1: RegisterIndex, index2: RegisterIndex)

    fun mult(index: RegisterIndex)
    fun mult(data: UByte)
    fun nop()
    fun not()
    fun or(index: RegisterIndex)
    fun or(data: UByte)
    fun plot()
    fun ramb()
    fun rol()
    fun romb()
    fun ror()
    fun rpix()
    fun sbc(index: RegisterIndex)
    fun sbk()
    fun sex()
    fun sm(data: UShort, index: RegisterIndex)
    fun sms(data: UShort, index: RegisterIndex)
    fun stb(index: RegisterIndex)
    fun stop()
    fun stw(index: RegisterIndex)
    fun rub(index: RegisterIndex)
    fun sub(data: UByte)
    fun swap()
    fun to(index: RegisterIndex)
    fun umult(index: RegisterIndex)



}