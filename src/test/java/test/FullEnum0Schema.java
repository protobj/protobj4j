package test;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;

import java.io.IOException;

public class FullEnum0Schema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (FullEnum0) message, polymorphic);
    }

    public static void writeTo(Output output, FullEnum0 message, boolean polymorphic) throws IOException {
        if (message == null) {
            output.writeI32_Packed(0);
            return;
        }
        switch (message) {
            case other: {
                output.writeI32_Packed(0);
                break;
            }
            default: {
                throw new RuntimeException("undefine enum " + message);
            }
        }

    }
    public static void writeWithFieldNumber(int fieldNum, Output output, FullEnum0 message) throws IOException {
        if (message == null) {
            output.writeI32_Packed(0);
            return;
        }
        switch (message) {
            case other: {
                output.writeI32(fieldNum,0);
                break;
            }
            default: {
                throw new RuntimeException("undefine enum " + message);
            }
        }

    }
    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (FullEnum0) message);
    }

    public static FullEnum0 mergeFrom(Input input, FullEnum0 message) throws IOException {
        int value = input.readI32();
        switch (value) {
            case 0: {
                return FullEnum0.other;
            }
            default: {
                return null;
            }
        }

    }

}

