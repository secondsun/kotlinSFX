package dev.secondsun.superfx3dmodeller

import dev.secondsun.superfx3dmodeller.cpu.SuperFX
import  org.junit.Assert.assertEquals
import org.junit.Test

class InstructionTests {

    @Test
    fun testADC() {
        var sfx = SuperFX().apply {

        };

    }


    @Test
    fun testToFromWithInstruction() {
        var sfx = SuperFX().apply {
            from(2)
        };

        assertEquals(sfx.R2, sfx.Sreg)
        assertEquals(sfx.R0, sfx.Dreg)
        sfx = SuperFX().apply {
            to(9)
        };
        assertEquals(sfx.R0, sfx.Sreg)
        assertEquals(sfx.R9, sfx.Dreg)

        sfx = SuperFX().apply {
            with(5)
        };

        assertEquals(sfx.R5, sfx.Sreg)
        assertEquals(sfx.R5, sfx.Dreg)

    }

    @Test
    fun testIBT(){
        var sfx = SuperFX().apply {
            statusRegister.value = 0xFFFFu;//We're setting all flags to test resets
            ibt(1, 0x01u)//instruction
        };

        assertEquals(1.toUShort(), sfx.R1.value)
        assertEquals(
            "ALT1 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT1
        );
        assertEquals(
            "ALT2 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT2
        );
        assertEquals("B is reset", 0.toUShort(), sfx.statusRegister.value and SuperFX.FlagMasks.B);
        assertEquals(0x0002u.toUShort(), sfx.R15.value)

        //TestSignExtend
        sfx = SuperFX().apply {
            statusRegister.value = 0xFFFFu;//We're setting all flags to test resets
            ibt(1, 0xFFu)//instruction

        };
        assertEquals(0xFFFFu.toUShort(), sfx.R1.value)

    }

    @Test
    fun testIWT(){
        val sfx = SuperFX().apply {
            statusRegister.value = 0xFFFFu;//We're setting all flags to test resets
            iwt(1u, 0x1234u)//instruction
        };
        assertEquals(0x1234u.toUShort(), sfx.R1.value)
        assertEquals(
            "ALT1 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT1
        );
        assertEquals(
            "ALT2 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT2
        );
        assertEquals("B is reset", 0.toUShort(), sfx.statusRegister.value and SuperFX.FlagMasks.B);
        assertEquals(0x0003u.toUShort(), sfx.R15.value)
    }

    @Test
    fun testNopInstruction() {
        val sfx = SuperFX().apply {
            statusRegister.value = 0xFFFFu;//We're setting all flags to test resets
            nop()//instruction
        };
        assertEquals("Increment PC by 1", 1.toUShort(), sfx.R15.value);
        assertEquals(
            "ALT1 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT1
        );
        assertEquals(
            "ALT2 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT2
        );
        assertEquals("B is reset", 0.toUShort(), sfx.statusRegister.value and SuperFX.FlagMasks.B);
    }

    @Test
    fun testAlt1Instruction() {
        val sfx = SuperFX().apply {
            alt1()//instruction
        };
        assertEquals("Increment PC by 1", 1.toUShort(), sfx.R15.value);
        assertEquals(
            "ALT1 is set",
            SuperFX.FlagMasks.ALT1,
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT1
        );
        assertEquals(
            "ALT2 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT2
        );

    }

    @Test
    fun testAlt2Instruction() {
        val sfx = SuperFX().apply {
            alt2()//instruction
        };
        assertEquals("Increment PC by 1", 1.toUShort(), sfx.R15.value);
        assertEquals(
            "ALT1 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT1
        );
        assertEquals(
            "ALT2 is set",
            SuperFX.FlagMasks.ALT2,
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT2
        );

    }

    @Test
    fun testAlt3Instruction() {
        val sfx = SuperFX().apply {
            alt3()//instruction
        };

        assertEquals("Increment PC by 1", 1.toUShort(), sfx.R15.value);
        assertEquals(
            "ALT1 is set",
            SuperFX.FlagMasks.ALT1,
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT1
        );
        assertEquals(
            "ALT2 is set",
            SuperFX.FlagMasks.ALT2,
            sfx.statusRegister.value and SuperFX.FlagMasks.ALT2
        );

    }


    @Test
    fun `Instructions should be loaded correctly`() {
        TODO(
            """
            Read Instruction from RAM or ROM via PBR + PC (R15)
            Check cache
                if cache (r15 is in cache area and cache is valid (check CBR)
                   read from cache ram and execute
                else   
                    Check RON flag
                        ron = 0 do wait after load from ROM
                        RAN =1 Read from Ram
                        RAN = 0 do wait after read from ram
            Also incr r15                               
        """.trimIndent()
        )


    }

    @Test
    fun testPipeline() {
        TODO("Remember kids, the pipeline executes the next instruction after a jump")
    }

}