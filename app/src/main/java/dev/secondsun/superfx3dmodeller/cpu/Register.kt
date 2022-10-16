package dev.secondsun.superfx3dmodeller.cpu

data class Register(var value:Short = 0.toShort()) {
    object STATUS{
        /*Zero, Carry, Sign, overflow, go (1 = GSU running),
        R (1 when reading ROM)
        ALT1, ALT2 (mode flags),
        IL (immediate lower 8-bit)
        IH (immediate higher 8 bit)
        B (1 when WITH is executed)
        IRQ (interupt)
        * */
    }
}