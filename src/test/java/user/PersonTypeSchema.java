package user;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class PersonTypeSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (PersonType) message, polymorphic);
    }

    public static void writeTo(Output output, PersonType message, boolean polymorphic) throws IOException {
        if (message == null) {
            output.writeI32(0);
            return;
        }
        switch (message) {
            case other: {
                output.writeI32(0);
                break;
            }
            case worker: {
                output.writeI32(1);
                break;
            }
            case boss: {
                output.writeI32(2);
                break;
            }
            default: {
                throw new RuntimeException("undefine enum " + message);
            }
        }

    }
    public static void writeWithFieldNumber(int fieldNum, Output output, PersonType message) throws IOException {
        if (message == null) {
            output.writeI32(0);
            return;
        }
        switch (message) {
            case other: {
                output.writeI32(fieldNum,0);
                break;
            }
            case worker: {
                output.writeI32(fieldNum,1);
                break;
            }
            case boss: {
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
        return mergeFrom(input, (PersonType) message);
    }

    public static PersonType mergeFrom(Input input, PersonType message) throws IOException {
        int value = input.readI32();
        switch (value) {
            case 0: {
                return PersonType.other;
            }
            case 1: {
                return PersonType.worker;
            }
            case 2: {
                return PersonType.boss;
            }
            default: {
                return null;
            }
        }

    }

}

