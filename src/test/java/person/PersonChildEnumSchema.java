package person;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class PersonChildEnumSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (PersonChildEnum) message, polymorphic);
    }

    public static void writeTo(Output output, PersonChildEnum message, boolean polymorphic) throws IOException {
        if (message == null) {
            output.writeI32(0);
            return;
        }
        switch (message) {
            case Person: {
                output.writeI32(0);
                break;
            }
            case User: {
                output.writeI32(1);
                break;
            }
            case Worker: {
                output.writeI32(2);
                break;
            }
            default: {
                throw new RuntimeException("undefine enum " + message);
            }
        }

    }
    public static void writeWithFieldNumber(int fieldNum, Output output, PersonChildEnum message) throws IOException {
        if (message == null) {
            output.writeI32(0);
            return;
        }
        switch (message) {
            case Person: {
                output.writeI32(fieldNum,0);
                break;
            }
            case User: {
                output.writeI32(fieldNum,1);
                break;
            }
            case Worker: {
                output.writeI32(fieldNum,2);
                break;
            }
            default: {
                throw new RuntimeException("undefine enum " + message);
            }
        }

    }
    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (PersonChildEnum) message);
    }

    public static PersonChildEnum mergeFrom(Input input, PersonChildEnum message) throws IOException {
        int value = input.readI32();
        switch (value) {
            case 0: {
                return PersonChildEnum.Person;
            }
            case 1: {
                return PersonChildEnum.User;
            }
            case 2: {
                return PersonChildEnum.Worker;
            }
            default: {
                return null;
            }
        }

    }

}

