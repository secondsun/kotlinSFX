package dev.secondsun.superfx3dmodeller

import org.junit.Test

class InstructionTests {
    @Test
    fun testInstruction() {
        TODO("Not Implemented")
    }

    @Test
    fun nopInstruction() {
        TODO("""
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
        """.trimIndent())


    }

    @Test
    fun testPipeline() {
        TODO("Remember kids, the pipeline executes the next instruction after a jump")
    }

}