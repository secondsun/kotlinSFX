package dev.secondsun.superfx3dmodeller.assembler

import dev.secondsun.superfx3dmodeller.cpu.RegisterIndex
import dev.secondsun.superfx3dmodeller.cpu.SuperFX
import dev.secondsun.superfx3dmodeller.instruction.InstructionList

class SFXAssembler private constructor(): InstructionList {

    val memory = mutableListOf<UByte>()

    companion object {
        fun assembler(instructions: SFXAssembler.() -> Unit): SFXAssembler {
            return SFXAssembler().apply(instructions)
        }
    }


    override fun adc(index: RegisterIndex) {
        with(memory) {
            add(0x3du)
            add ((0x50 or index.toInt()).toUByte())
        }
    }

    override fun adc(operand: UByte) {
        with(memory) {
            add(0x3fu)
            add ((0x50 or operand.toInt()).toUByte())
        }
    }

    override fun add(index: RegisterIndex) {
        with(memory) {
            add ((0x50 or index.toInt()).toUByte())
        }
    }

    override fun add(operand: UByte) {
        with(memory) {
            add(0x3eu)
            add ((0x50 or operand.toInt()).toUByte())
        }
    }

    override fun alt1() {
        with(memory) {
            add(0x3du)
        }
    }

    override fun alt2() {
        with(memory) {
            add(0x3eu)
        }
    }

    override fun alt3() {
        with(memory) {
            add(0x3fu)
        }
    }

    override fun and(index: RegisterIndex) {
        with(memory) {

            add ((0x70 or index.toInt()).toUByte())
        }
    }

    override fun and(data: UByte) {
        with(memory) {
            add(0x3eu)
            add ((0x50 or data.toInt()).toUByte())
        }
    }

    override fun asr() {
        with(memory) {
            add(0x96u)
        }
    }
    override fun bcc(offset: Byte) {
        with(memory) {
            add(0x0cu)
            add(offset.toUByte())
        }
    }

    override fun bcs(offset: Byte) {
        with(memory) {
            add(0x0du)
            add(offset.toUByte())
        }
    }

    override fun beq(offset: Byte) {
        with(memory) {
            add(0x09u)
            add(offset.toUByte())
        }
    }

    override fun bge(offset: Byte) {
        with(memory) {
            add(0x07u)
            add(offset.toUByte())
        }
    }

    override fun bic(index: RegisterIndex) {
        with(memory) {
            add(0x3du)
            add((0x70 or index.toInt()).toUByte())
        }
    }

    override fun bic(index: UByte) {
        with(memory) {
            add(0x3fu)
            add((0x70 or index.toInt()).toUByte())
        }
    }

    override fun blt(offset: Byte) {
        with(memory) {
            add(0x06u)
            add((offset).toUByte())
        }
    }

    override fun bmi(offset: Byte) {
        with(memory) {
            add(0x0bu)
            add((offset).toUByte())
        }
    }

    override fun bne(offset: Byte) {
        with(memory) {
            add(0x08u)
            add((offset).toUByte())
        }
    }

    override fun bpl(offset: Byte) {
        with(memory) {
            add(0x0au)
            add((offset).toUByte())
        }
    }

    override fun bra(offset: Byte) {
        with(memory) {
            add(0x05u)
            add((offset).toUByte())
        }
    }

    override fun bvc(offset: Byte) {
        with(memory) {
            add(0x0eu)
            add((offset).toUByte())
        }
    }

    override fun bvs(offset: Byte) {
        with(memory) {
            add(0x0fu)
            add((offset).toUByte())
        }
    }

    override fun cache() {
        with(memory) {
            add(0x02u)
        }
    }

    override fun cmode() {
        with(memory) {
            add(0x3du)
            add(0x4eu)
        }
    }

    override fun cmp(index: RegisterIndex) {
        with(memory) {
            add(0x3fu)
            add((0x60u or index.toInt().toUInt()).toUByte())
        }
    }

    override fun color() {
        with(memory) {
            add(0x4eu)
        }
    }

    override fun dec(index: RegisterIndex) {
        with(memory) {
            add((0xe0u or index.toInt().toUInt()).toUByte())
        }
    }

    override fun div2() {
        with(memory) {
            add(0x3du)
            add(0x96u)
        }
    }

    override fun fmult() {
        with(memory) {
            add(0x9fu)
        }
    }

    override fun from(index: RegisterIndex) {
        with(memory) {
            add((0xb0u or index.index.toUInt()).toUByte())
        }
    }

    override fun getb() {
        with(memory) {
            add(0xefu)
        }
    }

    override fun getbh() {
        with(memory) {
            add(0x3du)
            add(0xefu)
        }
    }

    override fun getbl() {
        with(memory) {
            add(0x3eu)
            add(0xefu)
        }
    }

    override fun getbs() {
        with(memory) {
            add(0x3fu)
            add(0xefu)
        }
    }

    override fun getc() {
        with(memory) {
            add(0xdfu)
        }
    }

    override fun hib() {
        with(memory) {
            add(0xc0u)
        }
    }

    override fun ibt(index: RegisterIndex, x: UByte) {
        with(memory) {
            add((0xa0u or index.index.toUInt()).toUByte())
            add(x)
        }
    }

    override fun inc(index: RegisterIndex) {
        with(memory) {
            add((0xd0u or index.index.toUInt()).toUByte())

        }
    }

    override fun iwt(index: RegisterIndex, x: UShort) {
        with(memory) {
            add((0xf0u or index.index.toUInt()).toUByte())
            add(x.toUByte())
            add((x.toInt() ushr 8).toUByte())
        }
    }

    override fun jmp(index: RegisterIndex) {
        with(memory) {
            add((0x90u or index.index.toUInt()).toUByte())

        }
    }

    override fun ldb(index: RegisterIndex) {
        with(memory) {
            add(0x3du)
            add((0x40u or index.index.toUInt()).toUByte())
        }
    }

    override fun ldw(index: RegisterIndex) {
        with(memory) {
            add((0x40u or index.index.toUInt()).toUByte())
        }
    }

    override fun lea(index: RegisterIndex, data: UShort) {
        with(memory) {
            add((0xF0u or index.index.toUInt()).toUByte())
            add(data.toUByte())
            add((data.toInt() ushr 8).toUByte())
        }
    }

    override fun link(data: UByte) {
        with(memory) {
            add((0x90u or ((data and 0x3u).toUInt())).toUByte())
        }
    }

    override fun ljmp(index: RegisterIndex) {
        with(memory) {
            add(0x3du)
            add((0x90u or ((index.index.toUInt()))).toUByte())
        }
    }

    override fun lm(index: RegisterIndex, data: UShort) {
        with(memory) {
            add(0x3du)
            add((0xF0u or ((index.index.toUInt()))).toUByte())
            add(data.toUByte())
            add((data.toInt() ushr 8).toUByte())
        }
    }

    override fun lms(index: RegisterIndex, data: UByte) {
        with(memory) {
            add(0x3du)
            add((0xA0u or ((index.index.toUInt()))).toUByte())
            add(data)
        }
    }

    override fun lmult() {
        with(memory) {
            add(0x3du)
            add((0x9Fu))
        }
    }

    override fun lob() {
        with(memory) {
            add(0x9eu)
        }
    }

    override fun loop() {
        with(memory) {
            add(0x3cu)
        }
    }

    override fun lsr() {
        with(memory) {
            add(0x3u)
        }
    }

    override fun merge() {
        with(memory) {
            add(0x70u)
        }
    }

    override fun move(index1: RegisterIndex, index2: RegisterIndex) {
        with(memory) {
            add((0x20 or index2.index).toUByte())
            add((0x10 or index1.index).toUByte())
        }
    }

    override fun move(index: RegisterIndex, data: Integer) {
        TODO("Not yet implemented")
    }

    override fun move(data: UShort, index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun movebFromMemory(index1: RegisterIndex, index2: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun movebToMemory(index1: RegisterIndex, index2: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun moves(index1: RegisterIndex, index2: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun movewFromMemory(index1: RegisterIndex, index2: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun movewToMemory(index1: RegisterIndex, index2: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun mult(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun mult(data: UByte) {
        TODO("Not yet implemented")
    }

    override fun nop() {
        TODO("Not yet implemented")
    }

    override fun not() {
        TODO("Not yet implemented")
    }

    override fun or(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun or(data: UByte) {
        TODO("Not yet implemented")
    }

    override fun plot() {
        TODO("Not yet implemented")
    }

    override fun ramb() {
        TODO("Not yet implemented")
    }

    override fun rol() {
        TODO("Not yet implemented")
    }

    override fun romb() {
        TODO("Not yet implemented")
    }

    override fun ror() {
        TODO("Not yet implemented")
    }

    override fun rpix() {
        TODO("Not yet implemented")
    }

    override fun sbc(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun sbk() {
        TODO("Not yet implemented")
    }

    override fun sex() {
        TODO("Not yet implemented")
    }

    override fun sm(data: UShort, index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun sms(data: UShort, index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun stb(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun stw(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun rub(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun sub(data: UByte) {
        TODO("Not yet implemented")
    }

    override fun swap() {
        TODO("Not yet implemented")
    }

    override fun to(index: RegisterIndex) {
        TODO("Not yet implemented")
    }

    override fun umult(index: RegisterIndex) {
        TODO("Not yet implemented")
    }
}