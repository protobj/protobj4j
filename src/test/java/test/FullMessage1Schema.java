package test;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class FullMessage1Schema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (FullMessage1) message, polymorphic);
    }

    public static void writeTo(Output output, FullMessage1 message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32_Packed(1);
        }
        //ext FullMessage0 p1 = 1 ; 
        output.writeMessage(1, () -> FullMessage0Schema.writeTo(output, message,false));

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (FullMessage1) message);
    }

    public static FullMessage1 mergeFrom(Input input, FullMessage1 msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new FullMessage1();
        }
        FullMessage1 message = msg;
        do {
            switch (fieldNumber) {
                //ext FullMessage0 p1 = 1 ; 
                case 1: {
                    final int oldLimit = input.readMessageStart();
                    FullMessage0Schema.mergeFrom(input,message);
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

