package test;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class TestMsg1Schema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (TestMsg1) message, polymorphic);
    }

    public static void writeTo(Output output, TestMsg1 message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32_Packed(0);
        }
        // bool a1 = 1 ; 
        if (message.isA1() != false) {
            output.writeBOOL(1, message.isA1());
        }
        // i8 a2 = 2 ; 
        if (message.getA2() != 0) {
            output.writeI8(2, message.getA2());
        }
        // i16 a3 = 3 ; 
        if (message.getA3() != 0) {
            output.writeI16(3, message.getA3());
        }
        // i32 a4 = 4 ; 
        if (message.getA4() != 0) {
            output.writeI32(4, message.getA4());
        }
        // f32 a5 = 5 ; 
        if (message.getA5() != 0) {
            output.writeF32(5, message.getA5());
        }
        // i64 a6 = 6 ; 
        if (message.getA6() != 0) {
            output.writeI64(6, message.getA6());
        }
        // f64 a9 = 7 ; 
        if (message.getA9() != 0) {
            output.writeF64(7, message.getA9());
        }
        // string a10 = 8 ; 
        if (message.getA10() != null) {
            output.writeSTRING(8, message.getA10());
        }
        // double a11 = 9 ; 
        if (message.getA11() != 0) {
            output.writeDOUBLE(9, message.getA11());
        }
        // float a12 = 10 ; 
        if (message.getA12() != 0) {
            output.writeFLOAT(10, message.getA12());
        }
        //arr i8 a14 = 11 ; 
        if (message.getA14() != null && message.getA14().length > 0) {
            output.writeI8Array(11, message.getA14());
        }
        //lst string a15 = 12 ; 
        if (message.getA15() != null && message.getA15().size() > 0) {
            output.writeSTRINGList(12, message.getA15());
        }
        //set string a16 = 13 ; 
        if (message.getA16() != null && message.getA16().size() > 0) {
            output.writeSTRINGSet(13, message.getA16());
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (TestMsg1) message);
    }

    public static TestMsg1 mergeFrom(Input input, TestMsg1 msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new TestMsg1();
        }
        TestMsg1 message = msg;
        do {
            switch (fieldNumber) {
                // bool a1 = 1 ; 
                case 1: {
                    message.setA1(input.readBOOL());
                    break;
                }
                // i8 a2 = 2 ; 
                case 2: {
                    message.setA2(input.readI8());
                    break;
                }
                // i16 a3 = 3 ; 
                case 3: {
                    message.setA3(input.readI16());
                    break;
                }
                // i32 a4 = 4 ; 
                case 4: {
                    message.setA4(input.readI32());
                    break;
                }
                // f32 a5 = 5 ; 
                case 5: {
                    message.setA5(input.readF32());
                    break;
                }
                // i64 a6 = 6 ; 
                case 6: {
                    message.setA6(input.readI64());
                    break;
                }
                // f64 a9 = 7 ; 
                case 7: {
                    message.setA9(input.readF64());
                    break;
                }
                // string a10 = 8 ; 
                case 8: {
                    message.setA10(input.readSTRING());
                    break;
                }
                // double a11 = 9 ; 
                case 9: {
                    message.setA11(input.readDOUBLE());
                    break;
                }
                // float a12 = 10 ; 
                case 10: {
                    message.setA12(input.readFLOAT());
                    break;
                }
                //arr i8 a14 = 11 ; 
                case 11: {
                    message.setA14(input.readI8Array());
                    break;
                }
                //lst string a15 = 12 ; 
                case 12: {
                    message.setA15(input.readSTRINGList());
                    break;
                }
                //set string a16 = 13 ; 
                case 13: {
                    message.setA16(input.readSTRINGSet());
                    break;
                }

                default: {
                    input.handleUnknownField(fieldNumber);
                    break;
                }
            }

        } while ((fieldNumber = input.readFieldNumber()) != 0);
        return message;
    }
}

