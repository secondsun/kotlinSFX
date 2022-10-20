package dev.secondsun.superfx3dmodeller

import dev.secondsun.superfx3dmodeller.cpu.SuperFX
import  org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.experimental.and

class InstructionTests {
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
            sfx.statusRegister.value and SuperFX.Flags.ALT1
        );
        assertEquals(
            "ALT2 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.Flags.ALT2
        );
        assertEquals("B is reset", 0.toUShort(), sfx.statusRegister.value and SuperFX.Flags.B);
    }

    @Test
    fun testAlt1Instruction() {
        val sfx = SuperFX().apply {
            alt1()//instruction
        };
        assertEquals("Increment PC by 1", 1.toUShort(), sfx.R15.value);
        assertEquals(
            "ALT1 is set",
            SuperFX.Flags.ALT1,
            sfx.statusRegister.value and SuperFX.Flags.ALT1
        );
        assertEquals(
            "ALT2 is reset",
            0.toUShort(),
            sfx.statusRegister.value and SuperFX.Flags.ALT2
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
            sfx.statusRegister.value and SuperFX.Flags.ALT1
        );
        assertEquals(
            "ALT2 is set",
            SuperFX.Flags.ALT2,
            sfx.statusRegister.value and SuperFX.Flags.ALT2
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
            SuperFX.Flags.ALT1,
            sfx.statusRegister.value and SuperFX.Flags.ALT1
        );
        assertEquals(
            "ALT2 is set",
            SuperFX.Flags.ALT2,
            sfx.statusRegister.value and SuperFX.Flags.ALT2
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