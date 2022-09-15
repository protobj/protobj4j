package person;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class PersonSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (Person) message, polymorphic);
    }

    public static void writeTo(Output output, Person message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32(0);
        }
        // i32 type = 1 ;  字段描述
        if (message.getType() != 0) {
            output.writeI32(1, message.getType());
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (Person) message);
    }

    public static Person mergeFrom(Input input, Person msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new Person();
        }
        Person message = msg;
        do {
            switch (fieldNumber) {
                // i32 type = 1 ;  字段描述
                case 1: {
                    message.setType(input.readI32());
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

