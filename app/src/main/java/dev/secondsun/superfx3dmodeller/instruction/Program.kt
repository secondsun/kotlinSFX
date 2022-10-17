package dev.secondsun.superfx3dmodeller.instruction

class Program(bank:Byte, address:Short, instructions:()->Unit) {
    fun compile()  : ByteArray {
        return ByteArray(0)
    }
}