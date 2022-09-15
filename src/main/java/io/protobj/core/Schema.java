package io.protobj.core;

import java.io.IOException;

public interface Schema {

    void writeTo(Output output, Object message, boolean polymorphic) throws IOException;

    Object mergeFrom(Input input, Object message) throws IOException;

}
