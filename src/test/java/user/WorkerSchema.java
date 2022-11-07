package user;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;
import person.PersonSchema;

import java.io.IOException;

public class WorkerSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (Worker) message, polymorphic);
    }

    public static void writeTo(Output output, Worker message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32_Packed(2);
        }
        //ext Person person = 2 ; 
        output.writeMessage(2, () -> PersonSchema.writeTo(output, message,false));
        //set i32 num = 1 ; 
        if (message.getNum() != null && message.getNum().size() > 0) {
            output.writeI32Set(1, message.getNum());
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (Worker) message);
    }

    public static Worker mergeFrom(Input input, Worker msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new Worker();
        }
        Worker message = msg;
        do {
            switch (fieldNumber) {
                //ext Person person = 2 ; 
                case 2: {
                    final int oldLimit = input.readMessageStart();
                    PersonSchema.mergeFrom(input,message);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //set i32 num = 1 ; 
                case 1: {
                    message.setNum(input.readI32Set());
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

