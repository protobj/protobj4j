package empty;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class EmptyMessageSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (EmptyMessage) message, polymorphic);
    }

    public static void writeTo(Output output, EmptyMessage message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32(0);
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (EmptyMessage) message);
    }

    public static EmptyMessage mergeFrom(Input input, EmptyMessage msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new EmptyMessage();
        }
        EmptyMessage message = msg;
        do {
            switch (fieldNumber) {

                default: {
                    input.handleUnknownField(fieldNumber);
                    break;
                }
            }

        } while ((fieldNumber = input.readFieldNumber()) != 0);
        return message;
    }
}

