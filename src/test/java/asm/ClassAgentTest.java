package asm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassAgentTest {
    @Test
    public void agent() throws Exception {
        new ClassAgent().agent();
    }

}