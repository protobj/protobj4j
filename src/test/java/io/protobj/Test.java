package io.protobj;


import io.protobj.core.LinkedBuffer;
import io.protobj.core.ProtobjInput;
import io.protobj.core.ProtobjOutput;
import io.protobj.core.Schema;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import test.FullMessage;
import test.FullMessageSchema;

import java.io.IOException;
import java.util.EnumSet;

import static io.protobj.util.ObjectEquals.compareObject;


/**
 * @auther chenqiang
 * @date 2022/8/30
 */
public class Test {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 1; i++) {
            testIO();
        }
    }

    private static void testIO() throws IOException {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters().scanClasspathForConcreteTypes(true);
        easyRandomParameters.setObjectPoolSize(200000);
        easyRandomParameters.bypassSetters(true);
        easyRandomParameters.randomize(field -> {
            if (field.getType() == EnumSet.class) {
                return true;
            }
            return false;
        }, () -> {
            return null;
        });

        EasyRandom easyRandom = new EasyRandom(easyRandomParameters);
        FullMessage fullMessage = easyRandom.nextObject(FullMessage.class);
        Schema schema = new FullMessageSchema();

//        person.setP25(new short[]{2, 33});

        ProtobjOutput output = new ProtobjOutput(LinkedBuffer.allocate());
        schema.writeTo(output, fullMessage, false);

        byte[] bytes = output.toByteArray();

        ProtobjInput protobjInput = new ProtobjInput(bytes);

        FullMessage o = (FullMessage) schema.mergeFrom(protobjInput, null);

        System.out.println(compareObject(fullMessage, o));
    }

}
