package user;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;
import person.Person;
import person.PersonSchema;

import java.io.IOException;

public class UserSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (User) message, polymorphic);
    }

    public static void writeTo(Output output, User message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32(1);
        }
        //ext Person person = 1 ; 
        output.writeMessage(1, () -> PersonSchema.writeTo(output, message,false));
        //arr Person personArr = 2 ; 
        if (message.getPersonArr() != null && message.getPersonArr().length > 0) {
            Person[] personArr = message.getPersonArr();
            for (int i = message.getPersonArr().length-1; i >= 0; i--) {
                int index = i;
                if (personArr[index] == null) {
                    continue;
                }
                output.writeMessage(2, () -> {
                    output.writeI32(index);
                    PersonSchema.writeTo(output, personArr[index], false);
                });
            }
        }
        //arr Person personArrMorphic = 3 [ polymorphic=true ] ; 
        if (message.getPersonArrMorphic() != null && message.getPersonArrMorphic().length > 0) {
            Person[] personArrMorphic = message.getPersonArrMorphic();
            for (int i = message.getPersonArrMorphic().length-1; i >= 0; i--) {
                int index = i;
                if (personArrMorphic[index] == null) {
                    continue;
                }
                output.writeMessage(3, () -> {
                    output.writeI32(index);
                    if (personArrMorphic[index].getClass() == Person.class) {
                        PersonSchema.writeTo(output, personArrMorphic[index],true);
                    } else if (personArrMorphic[index].getClass() == Worker.class) {
                        WorkerSchema.writeTo(output, (Worker)personArrMorphic[index], true);
                    } else if (personArrMorphic[index].getClass() == User.class) {
                        UserSchema.writeTo(output, (User)personArrMorphic[index], true);
                    } else { 
                    throw new RuntimeException("undefine message"+ personArrMorphic[index].getClass().getName());}
                });
            }
        }
        //lst i32 i32List = 4 ; 
        if (message.getI32List() != null && message.getI32List().size() > 0) {
            output.writeI32List(4, message.getI32List());
        }
        //arr bool boolArr = 5 ; 
        if (message.getBoolArr() != null && message.getBoolArr().length > 0) {
            output.writeBOOLArray(5, message.getBoolArr());
        }
        //map<string,i32> stringI32Map = 6 ; 
        if (message.getStringI32Map() != null && message.getStringI32Map().size() > 0) {
            output.writeSTRINGI32Map(6, message.getStringI32Map());
        }
        //map<i8,i16> i8i16Map = 7 ; 
        if (message.getI8i16Map() != null && message.getI8i16Map().size() > 0) {
            output.writeI8I16Map(7, message.getI8i16Map());
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (User) message);
    }

    public static User mergeFrom(Input input, User msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new User();
        }
        User message = msg;
        do {
            switch (fieldNumber) {
                //ext Person person = 1 ; 
                case 1: {
                    final int oldLimit = input.readMessageStart();
                    PersonSchema.mergeFrom(input,message);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //arr Person personArr = 2 ; 
                case 2: {
                    final int oldLimit = input.readMessageStart();
                    int index = input.readI32();
                    if (message.getPersonArr() == null) {
                        message.setPersonArr(new Person[index + 1]);
                    }
                    message.getPersonArr()[index] = PersonSchema.mergeFrom(input,null);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //arr Person personArrMorphic = 3 [ polymorphic=true ] ; 
                case 3: {
                    final int oldLimit = input.readMessageStart();
                    int index = input.readI32();
                    if (message.getPersonArrMorphic() == null) {
                        message.setPersonArrMorphic(new Person[index + 1]);
                    }
                    int msgIndex = input.readI32();
                    Person packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = PersonSchema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = WorkerSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = UserSchema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getPersonArrMorphic()[index] = packValue;
                    input.readMessageStop(oldLimit);
                    break;
                }
                //lst i32 i32List = 4 ; 
                case 4: {
                    message.setI32List(input.readI32List());
                    break;
                }
                //arr bool boolArr = 5 ; 
                case 5: {
                    message.setBoolArr(input.readBOOLArray());
                    break;
                }
                //map<string,i32> stringI32Map = 6 ; 
                case 6: {
                    message.setStringI32Map(input.readSTRINGI32Map());
                    break;
                }
                //map<i8,i16> i8i16Map = 7 ; 
                case 7: {
                    message.setI8i16Map(input.readI8I16Map());
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

