package test;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class FullMessage0Schema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (FullMessage0) message, polymorphic);
    }

    public static void writeTo(Output output, FullMessage0 message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32_Packed(0);
        }
        // FullEnum0 p0 = 1 ; 
        if (message.getP0() != null) {
            FullEnum0Schema.writeWithFieldNumber(1, output, message.getP0());
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (FullMessage0) message);
    }

    public static FullMessage0 mergeFrom(Input input, FullMessage0 msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new FullMessage0();
        }
        FullMessage0 message = msg;
        do {
            switch (fieldNumber) {
                // FullEnum0 p0 = 1 ; 
                case 1: {
                    message.setP0(FullEnum0Schema.mergeFrom(input,null));
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

