//========================================================================
//Copyright 2007-2010 David Yu dyuproject@gmail.com
//------------------------------------------------------------------------
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at 
//http://www.apache.org/licenses/LICENSE-2.0
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//========================================================================

package io.protobj.core;

import java.io.IOException;

/**
 * The flexible output for outputs that use {@link WriteSession}.
 *
 * @author David Yu
 * @created Sep 20, 2010
 */
public enum WriteSink {
    BUFFERED {
        @Override
        public LinkedBuffer writeByteArray(final byte[] value,
                                           final int offset, final int valueLen,
                                           final WriteSession session, LinkedBuffer lb) throws IOException {
            if (valueLen == 0)
                return lb;

            session.size += valueLen;

            final int available = lb.buffer.length - lb.offset;
            if (valueLen > available) {
                if (available + session.nextBufferSize < valueLen) {
                    // too large ... so we wrap and insert (zero-copy)
                    if (available == 0) {
                        // buffer was actually full ... return a fresh buffer
                        return new LinkedBuffer(session.nextBufferSize,
                                new LinkedBuffer(value, offset, offset + valueLen, lb));
                    }

                    // continue with the existing byte array of the previous buffer
                    return new LinkedBuffer(lb,
                            new LinkedBuffer(value, offset, offset + valueLen, lb));
                }

                // copy what can fit
                System.arraycopy(value, offset, lb.buffer, lb.offset, available);

                lb.offset += available;

                // grow
                lb = new LinkedBuffer(session.nextBufferSize, lb);

                final int leftover = valueLen - available;

                // copy what's left
                System.arraycopy(value, offset + available, lb.buffer, 0, leftover);

                lb.offset += leftover;

                return lb;
            }

            // it fits
            System.arraycopy(value, offset, lb.buffer, lb.offset, valueLen);

            lb.offset += valueLen;

            return lb;
        }

        @Override
        public LinkedBuffer writeByte(final byte value,
                                      final WriteSession session, LinkedBuffer lb) throws IOException {
            session.size++;

            if (lb.offset == lb.buffer.length) {
                // grow
                lb = new LinkedBuffer(session.nextBufferSize, lb);
            }
            lb.buffer[lb.offset++] = value;

            return lb;
        }

        @Override
        public LinkedBuffer writeInt32LE(final int value,
                                         final WriteSession session, LinkedBuffer lb) throws IOException {
            session.size += 4;

            if (lb.offset + 4 > lb.buffer.length) {
                // grow
                lb = new LinkedBuffer(session.nextBufferSize, lb);
            }

            IntSerializer.writeInt32LE(value, lb.buffer, lb.offset);
            lb.offset += 4;

            return lb;
        }

        @Override
        public LinkedBuffer writeInt64LE(final long value,
                                         final WriteSession session, LinkedBuffer lb) throws IOException {
            session.size += 8;

            if (lb.offset + 8 > lb.buffer.length) {
                // grow
                lb = new LinkedBuffer(session.nextBufferSize, lb);
            }

            IntSerializer.writeInt64LE(value, lb.buffer, lb.offset);
            lb.offset += 8;

            return lb;
        }

        @Override
        public LinkedBuffer writeVarInt32(int value,
                                          final WriteSession session, LinkedBuffer lb) throws IOException {
            while (true) {
                session.size++;
                if (lb.offset == lb.buffer.length) {
                    // grow
                    lb = new LinkedBuffer(session.nextBufferSize, lb);
                }

                if ((value & ~0x7F) == 0) {
                    lb.buffer[lb.offset++] = (byte) value;
                    return lb;
                }

                lb.buffer[lb.offset++] = (byte) ((value & 0x7F) | 0x80);
                value >>>= 7;
            }
        }

        @Override
        public LinkedBuffer writeVarInt64(long value,
                                          final WriteSession session, LinkedBuffer lb) throws IOException {
            while (true) {
                session.size++;
                if (lb.offset == lb.buffer.length) {
                    // grow
                    lb = new LinkedBuffer(session.nextBufferSize, lb);
                }

                if ((value & ~0x7FL) == 0) {
                    lb.buffer[lb.offset++] = (byte) value;
                    return lb;
                }

                lb.buffer[lb.offset++] = (byte) (((int) value & 0x7F) | 0x80);
                value >>>= 7;
            }
        }


        @Override
        public LinkedBuffer writeStrUTF8VarDelimited(final CharSequence value,
                                                     final WriteSession session, LinkedBuffer lb) throws IOException {
            return StringSerializer.writeUTF8VarDelimited(value, session, lb);
        }

        @Override
        public LinkedBuffer writeInt16LE(short value, WriteSession session, LinkedBuffer lb) throws IOException {
            session.size += 2;

            if (lb.offset + 2 > lb.buffer.length) {
                // grow
                lb = new LinkedBuffer(session.nextBufferSize, lb);
            }

            IntSerializer.writeInt16LE(value, lb.buffer, lb.offset);
            lb.offset += 2;

            return lb;
        }


    },
    ;

    public abstract LinkedBuffer writeByteArray(final byte[] value,
                                                final int offset, final int length, final WriteSession session, final LinkedBuffer lb)
            throws IOException;

    public abstract LinkedBuffer writeByte(final byte value,
                                           final WriteSession session, final LinkedBuffer lb) throws IOException;

    public abstract LinkedBuffer writeInt32LE(final int value,
                                              final WriteSession session, final LinkedBuffer lb) throws IOException;

    public abstract LinkedBuffer writeInt64LE(final long value,
                                              final WriteSession session, final LinkedBuffer lb) throws IOException;


    public abstract LinkedBuffer writeVarInt32(final int value,
                                               final WriteSession session, final LinkedBuffer lb) throws IOException;

    public abstract LinkedBuffer writeVarInt64(final long value,
                                               final WriteSession session, final LinkedBuffer lb) throws IOException;

    public abstract LinkedBuffer writeStrUTF8VarDelimited(final CharSequence value,
                                                          final WriteSession session, final LinkedBuffer lb) throws IOException;

    public abstract LinkedBuffer writeInt16LE(final short value,
                                              final WriteSession session, final LinkedBuffer lb) throws IOException;

}
