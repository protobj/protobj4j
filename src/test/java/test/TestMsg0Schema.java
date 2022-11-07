package test;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class TestMsg0Schema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (TestMsg0) message, polymorphic);
    }

    public static void writeTo(Output output, TestMsg0 message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32_Packed(0);
        }
        // TestMsg1 a1 = 1 ; 
        if (message.getA1() != null) {
            output.writeMessage(1, () -> TestMsg1Schema.writeTo(output, message.getA1(), false));
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (TestMsg0) message);
    }

    public static TestMsg0 mergeFrom(Input input, TestMsg0 msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new TestMsg0();
        }
        TestMsg0 message = msg;
        do {
            switch (fieldNumber) {
                // TestMsg1 a1 = 1 ; 
                case 1: {
                    final int oldLimit = input.readMessageStart();
                    message.setA1(TestMsg1Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
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

