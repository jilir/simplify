package org.cf.smalivm.opcode;

import gnu.trove.map.TIntObjectMap;

import org.cf.smalivm.VMTester;
import org.cf.smalivm.type.LocalInstance;
import org.cf.smalivm.type.UninitializedInstance;
import org.junit.Test;

public class TestNewInstanceOp {

    private static final String CLASS_NAME = "Lnew_instance_test;";

    @Test
    public void testLocalClass() {
        TIntObjectMap<Object> initial = VMTester.buildRegisterState(0, 1);
        TIntObjectMap<Object> expected = VMTester.buildRegisterState(0, new LocalInstance(CLASS_NAME));

        VMTester.testMethodState(CLASS_NAME, "TestLocalClass()V", initial, expected);
    }

    @Test
    public void testNonLocalClass() {
        TIntObjectMap<Object> initial = VMTester.buildRegisterState(0, 1);
        TIntObjectMap<Object> expected = VMTester.buildRegisterState(0,
                        new UninitializedInstance("Ljava/lang/Integer;"));

        VMTester.testMethodState(CLASS_NAME, "TestNonLocalClass()V", initial, expected);
    }

}
