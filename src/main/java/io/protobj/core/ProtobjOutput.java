package io.protobj.core;

import it.unimi.dsi.fastutil.booleans.BooleanIterator;
import it.unimi.dsi.fastutil.booleans.BooleanList;
import it.unimi.dsi.fastutil.booleans.BooleanSet;
import it.unimi.dsi.fastutil.bytes.*;
import it.unimi.dsi.fastutil.doubles.*;
import it.unimi.dsi.fastutil.floats.*;
import it.unimi.dsi.fastutil.ints.*;
import it.unimi.dsi.fastutil.longs.*;
import it.unimi.dsi.fastutil.objects.*;
import it.unimi.dsi.fastutil.shorts.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @auther chenqiang
 * @date 2022/8/15
 */
public class ProtobjOutput extends WriteSession implements Output {
    public static final int LITTLE_ENDIAN_32_SIZE = 4, LITTLE_ENDIAN_64_SIZE = 8;

    public ProtobjOutput(LinkedBuffer head) {
        super(head);
    }

    @Override
    public void writeBOOL(int fieldNumber, boolean value) throws IOException {
        tail = sink.writeByte(value ? (byte) 0x01 : 0x00, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED8), this, tail));
    }

    @Override
    public void writeBOOL_Packed(boolean value) throws IOException {
        tail = sink.writeByte(value ? (byte) 0x01 : 0x00, this, tail);
    }

    @Override
    public void writeI8(int fieldNumber, byte value) throws IOException {
        tail = sink.writeByte(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED8), this, tail));
    }

    @Override
    public void writeI8_Packed(byte value) throws IOException {
        tail = sink.writeByte(value, this, tail);
    }

    @Override
    public void writeU8(int fieldNumber, byte value) throws IOException {
        tail = sink.writeByte(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED8), this, tail));
    }

    @Override
    public void writeU8_Packed(byte value) throws IOException {
        tail = sink.writeByte(value, this, tail);
    }

    @Override
    public void writeI16(int fieldNumber, short value) throws IOException {
        tail = sink.writeInt16LE(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED16), this, tail));
    }

    @Override
    public void writeI16_Packed(short value) throws IOException {
        tail = sink.writeInt16LE(value, this, tail);
    }

    @Override
    public void writeU16(int fieldNumber, short value) throws IOException {
        tail = sink.writeInt16LE(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED16), this, tail));
    }

    @Override
    public void writeU16_Packed(short value) throws IOException {
        tail = sink.writeInt16LE(value, this, tail);
    }

    @Override
    public void writeI32(int fieldNumber, int value) throws IOException {
        if (value < 0) {
            tail = sink.writeVarInt64(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));
        } else {
            tail = sink.writeVarInt32(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));
        }
    }

    public void writeI32_Packed(int value) throws IOException {
        if (value < 0) {
            tail = sink.writeVarInt64(value, this, tail);
        } else {
            tail = sink.writeVarInt32(value, this, tail);
        }
    }

    public void writeU32_Packed(int value) throws IOException {
        tail = sink.writeVarInt32(value, this, tail);
    }

    @Override
    public void writeU32(int fieldNumber, int value) throws IOException {
        tail = sink.writeVarInt32(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));
    }

    @Override
    public void writeS32(int fieldNumber, int value) throws IOException {
        tail = sink.writeVarInt32(encodeZigZag32(value), this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));
    }

    @Override
    public void writeS32_Packed(int value) throws IOException {
        tail = sink.writeVarInt32(encodeZigZag32(value), this, tail);
    }

    @Override
    public void writeF32(int fieldNumber, int value) throws IOException {
        tail = sink.writeInt32LE(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED32), this, tail));

    }

    @Override
    public void writeF32_Packed(int value) throws IOException {
        tail = sink.writeInt32LE(value, this, tail);
    }

    @Override
    public void writeSF32(int fieldNumber, int value) throws IOException {
        tail = sink.writeInt32LE(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED32), this, tail));

    }

    @Override
    public void writeSF32_Packed(int value) throws IOException {
        tail = sink.writeInt32LE(value, this, tail);

    }

    @Override
    public void writeI64(int fieldNumber, long value) throws IOException {
        tail = sink.writeVarInt64(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));
    }

    @Override
    public void writeI64_Packed(long value) throws IOException {
        tail = sink.writeVarInt64(value, this, tail);

    }

    @Override
    public void writeU64(int fieldNumber, long value) throws IOException {
        tail = sink.writeVarInt64(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));

    }

    @Override
    public void writeU64_Packed(long value) throws IOException {
        tail = sink.writeVarInt64(value, this, tail);

    }

    @Override
    public void writeS64(int fieldNumber, long value) throws IOException {
        tail = sink.writeVarInt64(encodeZigZag64(value), this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_VARINT), this, tail));

    }

    @Override
    public void writeS64_Packed(long value) throws IOException {
        tail = sink.writeVarInt64(encodeZigZag64(value), this, tail);

    }

    @Override
    public void writeF64(int fieldNumber, long value) throws IOException {
        tail = sink.writeInt64LE(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED64), this, tail));
    }

    @Override
    public void writeF64_Packed(long value) throws IOException {
        tail = sink.writeInt64LE(value, this, tail);

    }

    @Override
    public void writeSF64(int fieldNumber, long value) throws IOException {
        tail = sink.writeInt64LE(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED64), this, tail));
    }

    @Override
    public void writeSF64_Packed(long value) throws IOException {
        tail = sink.writeInt64LE(value, this, tail);
    }

    @Override
    public void writeFLOAT(int fieldNumber, float value) throws IOException {
        tail = sink.writeInt32LE(Float.floatToRawIntBits(value), this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED32), this, tail));
    }

    @Override
    public void writeFLOAT_Packed(float value) throws IOException {
        tail = sink.writeInt32LE(Float.floatToRawIntBits(value), this, tail);
    }

    @Override
    public void writeDOUBLE(int fieldNumber, double value) throws IOException {
        tail = sink.writeInt64LE(Double.doubleToRawLongBits(value), this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_FIXED64), this, tail));

    }

    @Override
    public void writeDOUBLE_Packed(double value) throws IOException {
        tail = sink.writeInt64LE(Double.doubleToRawLongBits(value), this, tail);

    }

    @Override
    public void writeSTRING(int fieldNumber, String value) throws IOException {
        tail = sink.writeStrUTF8VarDelimited(value, this, sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED), this, tail));
    }

    @Override
    public void writeBOOLArray(int fieldNumber, boolean[] value) throws IOException {
        int length = ((value.length + 7) & (-8)) >>> 3;
        byte[] bytes = new byte[length];
        for (int i = 0; i < value.length; i++) {
            if (value[i]) {
                bytes[i / 8] |= 1 << (i % 8);
            }
        }
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            tail = sink.writeByteArray(bytes, 0, bytes.length, ProtobjOutput.this, tail);
        });
    }


    @Override
    public void writeI16Array(int fieldNumber, short[] value) throws IOException {
        writeU16Array(fieldNumber, value);
    }

    @Override
    public void writeU16Array(int fieldNumber, short[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (short item : value) {
                writeU16_Packed(item);
            }
        });
    }

    @Override
    public void writeI32Array(int fieldNumber, int[] value) throws IOException {

        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (int item : value) {
                writeI32_Packed(item);
            }
        });
    }

    @Override
    public void writeU32Array(int fieldNumber, int[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (int item : value) {
                writeU32_Packed(item);
            }
        });
    }

    @Override
    public void writeS32Array(int fieldNumber, int[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (int item : value) {
                writeS32_Packed(item);
            }
        });
    }

    @Override
    public void writeF32Array(int fieldNumber, int[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (int item : value) {
                writeF32_Packed(item);
            }
        });
    }

    @Override
    public void writeSF32Array(int fieldNumber, int[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (int item : value) {
                writeSF32_Packed(item);
            }
        });
    }

    @Override
    public void writeI64Array(int fieldNumber, long[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (long item : value) {
                writeI64_Packed(item);
            }
        });
    }

    @Override
    public void writeU64Array(int fieldNumber, long[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (long item : value) {
                writeU64_Packed(item);
            }
        });
    }

    @Override
    public void writeS64Array(int fieldNumber, long[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (long item : value) {
                writeS64_Packed(item);
            }
        });
    }

    @Override
    public void writeF64Array(int fieldNumber, long[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (long item : value) {
                writeF64_Packed(item);
            }
        });
    }

    @Override
    public void writeSF64Array(int fieldNumber, long[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (long item : value) {
                writeSF64_Packed(item);
            }
        });
    }

    @Override
    public void writeFLOATArray(int fieldNumber, float[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (float item : value) {
                writeFLOAT_Packed(item);
            }
        });
    }

    @Override
    public void writeDOUBLEArray(int fieldNumber, double[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.length);
            for (double item : value) {
                writeDOUBLE_Packed(item);
            }
        });
    }

    @Override
    public void writeSTRINGArray(int fieldNumber, String[] value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = value.length - 1; i >= 0; i--) {
                if (value[i] == null) {
                    continue;
                }
                writeI32_Packed(i);
                writeSTRING_Packed(value[i]);
            }
        });
    }

    @Override
    public void writeI8List(int fieldNumber, ByteList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                writeI8_Packed(value.getByte(i));
            }
        });
    }

    @Override
    public void writeU8List(int fieldNumber, ByteList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                writeU8_Packed(value.getByte(i));
            }
        });
    }

    @Override
    public void writeBOOLList(int fieldNumber, BooleanList value) throws IOException {
        int length = ((value.size() + 7) & (-8)) >>> 3;
        byte[] bytes = new byte[length];
        for (int i = 0; i < value.size(); i++) {
            if (value.getBoolean(i)) {
                bytes[i / 8] |= 1 << (i % 8);
            }
        }
        writeMessage(fieldNumber, () -> {
            writeI32_Packed(value.size());
            tail = sink.writeByteArray(bytes, 0, bytes.length, ProtobjOutput.this, tail);
        });
    }

    @Override
    public void writeI16List(int fieldNumber, ShortList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                short valueShort = value.getShort(i);
                writeI16_Packed(valueShort);
            }
        });
    }

    @Override
    public void writeU16List(int fieldNumber, ShortList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                short valueShort = value.getShort(i);
                writeU16_Packed(valueShort);
            }
        });
    }

    @Override
    public void writeI32List(int fieldNumber, IntList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                int valueInt = value.getInt(i);
                writeI32_Packed(valueInt);
            }
        });
    }

    @Override
    public void writeU32List(int fieldNumber, IntList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                int valueInt = value.getInt(i);
                writeU32_Packed(valueInt);
            }
        });
    }

    @Override
    public void writeS32List(int fieldNumber, IntList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                int valueInt = value.getInt(i);
                writeS32_Packed(valueInt);
            }
        });
    }

    @Override
    public void writeF32List(int fieldNumber, IntList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                int valueInt = value.getInt(i);
                writeF32_Packed(valueInt);
            }
        });
    }

    @Override
    public void writeSF32List(int fieldNumber, IntList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                int valueInt = value.getInt(i);
                writeSF32_Packed(valueInt);
            }
        });
    }

    @Override
    public void writeI64List(int fieldNumber, LongList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                long valueLong = value.getLong(i);
                writeI64_Packed(valueLong);
            }
        });
    }

    @Override
    public void writeU64List(int fieldNumber, LongList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                long valueLong = value.getLong(i);
                writeU64_Packed(valueLong);
            }
        });
    }

    @Override
    public void writeS64List(int fieldNumber, LongList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                long valueLong = value.getLong(i);
                writeS64_Packed(valueLong);
            }
        });
    }

    @Override
    public void writeF64List(int fieldNumber, LongList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                long valueLong = value.getLong(i);
                writeF64_Packed(valueLong);
            }
        });
    }

    @Override
    public void writeSF64List(int fieldNumber, LongList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                long valueLong = value.getLong(i);
                writeSF64_Packed(valueLong);
            }
        });
    }

    @Override
    public void writeFLOATList(int fieldNumber, FloatList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                writeFLOAT_Packed(value.getFloat(i));
            }
        });
    }

    @Override
    public void writeDOUBLEList(int fieldNumber, DoubleList value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (int i = 0; i < value.size(); i++) {
                writeDOUBLE_Packed(value.getDouble(i));
            }
        });
    }

    @Override
    public void writeSTRINGList(int fieldNumber, List<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (String valueString : value) {
                if (valueString == null) {
                    continue;
                }
                writeSTRING_Packed(valueString);
            }
        });
    }

    public void writeSTRING_Packed(String value) throws IOException {
        this.tail = this.sink.writeStrUTF8VarDelimited(value, ProtobjOutput.this, this.tail);
    }

    @Override
    public void writeI8Set(int fieldNumber, ByteSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            ByteIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeI8_Packed(iterator.nextByte());
            }
        });
    }

    @Override
    public void writeU8Set(int fieldNumber, ByteSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            ByteIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                byte nextByte = iterator.nextByte();
                writeU8_Packed(nextByte);
            }
        });
    }

    @Override
    public void writeBOOLSet(int fieldNumber, BooleanSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            BooleanIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeBOOL_Packed(iterator.nextBoolean());
            }
        });
    }

    @Override
    public void writeI16Set(int fieldNumber, ShortSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            ShortIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                short nextShort = iterator.nextShort();
                writeI16_Packed(nextShort);
            }
        });
    }

    @Override
    public void writeU16Set(int fieldNumber, ShortSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            ShortIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeU16_Packed(iterator.nextShort());
            }
        });
    }

    @Override
    public void writeI32Set(int fieldNumber, IntSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            IntIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                int nextInt = iterator.nextInt();
                writeI32_Packed(nextInt);
            }
        });
    }

    @Override
    public void writeU32Set(int fieldNumber, IntSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            IntIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                int nextInt = iterator.nextInt();
                writeU32_Packed(nextInt);
            }
        });
    }

    @Override
    public void writeS32Set(int fieldNumber, IntSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            IntIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                int nextInt = iterator.nextInt();
                writeS32_Packed(nextInt);
            }
        });
    }

    @Override
    public void writeF32Set(int fieldNumber, IntSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            IntIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                int nextInt = iterator.nextInt();
                writeF32_Packed(nextInt);
            }
        });
    }

    @Override
    public void writeSF32Set(int fieldNumber, IntSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            IntIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                int nextInt = iterator.nextInt();
                writeSF32_Packed(nextInt);
            }
        });
    }

    @Override
    public void writeI64Set(int fieldNumber, LongSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            LongIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeI64_Packed(iterator.nextLong());
            }
        });
    }

    @Override
    public void writeU64Set(int fieldNumber, LongSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            LongIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeU64_Packed(iterator.nextLong());
            }
        });
    }

    @Override
    public void writeS64Set(int fieldNumber, LongSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            LongIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeS64_Packed(iterator.nextLong());
            }
        });
    }

    @Override
    public void writeF64Set(int fieldNumber, LongSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            LongIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeF64_Packed(iterator.nextLong());
            }
        });
    }

    @Override
    public void writeSF64Set(int fieldNumber, LongSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            LongIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeSF64_Packed(iterator.nextLong());
            }
        });
    }

    @Override
    public void writeFLOATSet(int fieldNumber, FloatSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            FloatIterator iterator = value.iterator();
            while (iterator.hasNext()) {
                writeFLOAT_Packed(iterator.nextFloat());
            }
        });

    }

    @Override
    public void writeDOUBLESet(int fieldNumber, DoubleSet value) throws IOException {
        writeMessage(fieldNumber, () -> {
            DoubleIterator doubleIterator = value.iterator();
            while (doubleIterator.hasNext()) {
                writeDOUBLE_Packed(doubleIterator.nextDouble());
            }
        });
    }

    @Override
    public void writeSTRINGSet(int fieldNumber, Set<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (String nextString : value) {
                if (nextString == null) {
                    continue;
                }
                writeSTRING_Packed(nextString);
            }
        });
    }

    public void writeI8BOOLMap(int fieldNumber, Byte2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2BooleanMap.Entry entry : value.byte2BooleanEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeI8I8Map(int fieldNumber, Byte2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ByteMap.Entry entry : value.byte2ByteEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI8U8Map(int fieldNumber, Byte2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ByteMap.Entry entry : value.byte2ByteEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI8I16Map(int fieldNumber, Byte2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ShortMap.Entry entry : value.byte2ShortEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI8U16Map(int fieldNumber, Byte2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ShortMap.Entry entry : value.byte2ShortEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI8I32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI8U32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI8S32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI8F32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI8SF32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI8I64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI8U64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI8S64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI8F64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI8SF64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI8STRINGMap(int fieldNumber, Byte2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ObjectMap.Entry<String> entry : value.byte2ObjectEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeI8DOUBLEMap(int fieldNumber, Byte2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2DoubleMap.Entry entry : value.byte2DoubleEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeI8FLOATMap(int fieldNumber, Byte2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2FloatMap.Entry entry : value.byte2FloatEntrySet()) {
                writeI8_Packed(entry.getByteKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeU8BOOLMap(int fieldNumber, Byte2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2BooleanMap.Entry entry : value.byte2BooleanEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeU8I8Map(int fieldNumber, Byte2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ByteMap.Entry entry : value.byte2ByteEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU8U8Map(int fieldNumber, Byte2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ByteMap.Entry entry : value.byte2ByteEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU8I16Map(int fieldNumber, Byte2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ShortMap.Entry entry : value.byte2ShortEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU8U16Map(int fieldNumber, Byte2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ShortMap.Entry entry : value.byte2ShortEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU8I32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU8U32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU8S32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU8F32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU8SF32Map(int fieldNumber, Byte2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2IntMap.Entry entry : value.byte2IntEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU8I64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU8U64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU8S64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU8F64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU8SF64Map(int fieldNumber, Byte2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2LongMap.Entry entry : value.byte2LongEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU8STRINGMap(int fieldNumber, Byte2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2ObjectMap.Entry<String> entry : value.byte2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeU8_Packed(entry.getByteKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeU8DOUBLEMap(int fieldNumber, Byte2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2DoubleMap.Entry entry : value.byte2DoubleEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeU8FLOATMap(int fieldNumber, Byte2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Byte2FloatMap.Entry entry : value.byte2FloatEntrySet()) {
                writeU8_Packed(entry.getByteKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeI16BOOLMap(int fieldNumber, Short2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2BooleanMap.Entry entry : value.short2BooleanEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeI16I8Map(int fieldNumber, Short2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ByteMap.Entry entry : value.short2ByteEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI16U8Map(int fieldNumber, Short2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ByteMap.Entry entry : value.short2ByteEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI16I16Map(int fieldNumber, Short2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ShortMap.Entry entry : value.short2ShortEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI16U16Map(int fieldNumber, Short2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ShortMap.Entry entry : value.short2ShortEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI16I32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI16U32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI16S32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI16F32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI16SF32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI16I64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI16U64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI16S64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI16F64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI16SF64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI16STRINGMap(int fieldNumber, Short2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ObjectMap.Entry<String> entry : value.short2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeI16_Packed(entry.getShortKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeI16DOUBLEMap(int fieldNumber, Short2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2DoubleMap.Entry entry : value.short2DoubleEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeI16FLOATMap(int fieldNumber, Short2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2FloatMap.Entry entry : value.short2FloatEntrySet()) {
                writeI16_Packed(entry.getShortKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeU16BOOLMap(int fieldNumber, Short2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2BooleanMap.Entry entry : value.short2BooleanEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeU16I8Map(int fieldNumber, Short2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ByteMap.Entry entry : value.short2ByteEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU16U8Map(int fieldNumber, Short2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ByteMap.Entry entry : value.short2ByteEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU16I16Map(int fieldNumber, Short2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ShortMap.Entry entry : value.short2ShortEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU16U16Map(int fieldNumber, Short2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ShortMap.Entry entry : value.short2ShortEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU16I32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU16U32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU16S32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU16F32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU16SF32Map(int fieldNumber, Short2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2IntMap.Entry entry : value.short2IntEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU16I64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU16U64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU16S64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU16F64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU16SF64Map(int fieldNumber, Short2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2LongMap.Entry entry : value.short2LongEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU16STRINGMap(int fieldNumber, Short2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2ObjectMap.Entry<String> entry : value.short2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeU16_Packed(entry.getShortKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeU16DOUBLEMap(int fieldNumber, Short2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2DoubleMap.Entry entry : value.short2DoubleEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeU16FLOATMap(int fieldNumber, Short2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Short2FloatMap.Entry entry : value.short2FloatEntrySet()) {
                writeU16_Packed(entry.getShortKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeI32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2BooleanMap.Entry entry : value.int2BooleanEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeI32I8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI32U8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI32I16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI32U16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI32I32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI32U32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI32S32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI32F32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI32SF32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI32I64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI32U64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI32S64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI32F64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI32SF64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ObjectMap.Entry<String> entry : value.int2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeI32_Packed(entry.getIntKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeI32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2DoubleMap.Entry entry : value.int2DoubleEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeI32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2FloatMap.Entry entry : value.int2FloatEntrySet()) {
                writeI32_Packed(entry.getIntKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeU32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2BooleanMap.Entry entry : value.int2BooleanEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeU32I8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU32U8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU32I16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU32U16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU32I32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU32U32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU32S32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }

    public void writeU32F32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU32SF32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU32I64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU32U64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU32S64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU32F64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU32SF64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ObjectMap.Entry<String> entry : value.int2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeU32_Packed(entry.getIntKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeU32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2DoubleMap.Entry entry : value.int2DoubleEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeU32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2FloatMap.Entry entry : value.int2FloatEntrySet()) {
                writeU32_Packed(entry.getIntKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeS32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2BooleanMap.Entry entry : value.int2BooleanEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeS32I8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeS32U8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeS32I16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeS32U16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeS32I32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS32U32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS32S32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS32F32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS32SF32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS32I64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS32U64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS32S64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS32F64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS32SF64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ObjectMap.Entry<String> entry : value.int2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeS32_Packed(entry.getIntKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeS32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2DoubleMap.Entry entry : value.int2DoubleEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeS32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2FloatMap.Entry entry : value.int2FloatEntrySet()) {
                writeS32_Packed(entry.getIntKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeF32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2BooleanMap.Entry entry : value.int2BooleanEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeF32I8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeF32U8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeF32I16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeF32U16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeF32I32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF32U32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF32S32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF32F32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF32SF32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF32I64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF32U64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF32S64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF32F64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF32SF64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ObjectMap.Entry<String> entry : value.int2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeF32_Packed(entry.getIntKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeF32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2DoubleMap.Entry entry : value.int2DoubleEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeF32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2FloatMap.Entry entry : value.int2FloatEntrySet()) {
                writeF32_Packed(entry.getIntKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeSF32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2BooleanMap.Entry entry : value.int2BooleanEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeSF32I8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeSF32U8Map(int fieldNumber, Int2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ByteMap.Entry entry : value.int2ByteEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeSF32I16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeSF32U16Map(int fieldNumber, Int2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ShortMap.Entry entry : value.int2ShortEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeSF32I32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF32U32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF32S32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF32F32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF32SF32Map(int fieldNumber, Int2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2IntMap.Entry entry : value.int2IntEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF32I64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF32U64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF32S64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF32F64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF32SF64Map(int fieldNumber, Int2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2LongMap.Entry entry : value.int2LongEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2ObjectMap.Entry<String> entry : value.int2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeSF32_Packed(entry.getIntKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeSF32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2DoubleMap.Entry entry : value.int2DoubleEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeSF32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Int2FloatMap.Entry entry : value.int2FloatEntrySet()) {
                writeSF32_Packed(entry.getIntKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeI64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2BooleanMap.Entry entry : value.long2BooleanEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeI64I8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI64U8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeI64I16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI64U16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeI64I32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI64U32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI64S32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI64F32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI64SF32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeI64I64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI64U64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI64S64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI64F64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI64SF64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeI64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ObjectMap.Entry<String> entry : value.long2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeI64_Packed(entry.getLongKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeI64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2DoubleMap.Entry entry : value.long2DoubleEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeI64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2FloatMap.Entry entry : value.long2FloatEntrySet()) {
                writeI64_Packed(entry.getLongKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeU64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2BooleanMap.Entry entry : value.long2BooleanEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeU64I8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU64U8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeU64I16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU64U16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeU64I32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU64U32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU64S32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU64F32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU64SF32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeU64I64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU64U64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU64S64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU64F64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU64SF64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeU64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ObjectMap.Entry<String> entry : value.long2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeU64_Packed(entry.getLongKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeU64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2DoubleMap.Entry entry : value.long2DoubleEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeU64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2FloatMap.Entry entry : value.long2FloatEntrySet()) {
                writeU64_Packed(entry.getLongKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeS64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2BooleanMap.Entry entry : value.long2BooleanEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeS64I8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeS64U8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeS64I16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeS64U16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeS64I32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS64U32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS64S32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS64F32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS64SF32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeS64I64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS64U64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS64S64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS64F64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS64SF64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeS64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ObjectMap.Entry<String> entry : value.long2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeS64_Packed(entry.getLongKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeS64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2DoubleMap.Entry entry : value.long2DoubleEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeS64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2FloatMap.Entry entry : value.long2FloatEntrySet()) {
                writeS64_Packed(entry.getLongKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeF64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2BooleanMap.Entry entry : value.long2BooleanEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeF64I8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeF64U8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeF64I16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeF64U16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeF64I32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF64U32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF64S32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF64F32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF64SF32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeF64I64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF64U64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF64S64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF64F64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF64SF64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeF64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ObjectMap.Entry<String> entry : value.long2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeF64_Packed(entry.getLongKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeF64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2DoubleMap.Entry entry : value.long2DoubleEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeF64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2FloatMap.Entry entry : value.long2FloatEntrySet()) {
                writeF64_Packed(entry.getLongKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeSF64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2BooleanMap.Entry entry : value.long2BooleanEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeSF64I8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeSF64U8Map(int fieldNumber, Long2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ByteMap.Entry entry : value.long2ByteEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeSF64I16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeSF64U16Map(int fieldNumber, Long2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ShortMap.Entry entry : value.long2ShortEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeSF64I32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF64U32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF64S32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF64F32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF64SF32Map(int fieldNumber, Long2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2IntMap.Entry entry : value.long2IntEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSF64I64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF64U64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF64S64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF64F64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF64SF64Map(int fieldNumber, Long2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2LongMap.Entry entry : value.long2LongEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSF64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2ObjectMap.Entry<String> entry : value.long2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeSF64_Packed(entry.getLongKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeSF64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2DoubleMap.Entry entry : value.long2DoubleEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeSF64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Long2FloatMap.Entry entry : value.long2FloatEntrySet()) {
                writeSF64_Packed(entry.getLongKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeSTRINGBOOLMap(int fieldNumber, Object2BooleanMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2BooleanMap.Entry<String> entry : value.object2BooleanEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeSTRINGI8Map(int fieldNumber, Object2ByteMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2ByteMap.Entry<String> entry : value.object2ByteEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeSTRINGU8Map(int fieldNumber, Object2ByteMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2ByteMap.Entry<String> entry : value.object2ByteEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeSTRINGI16Map(int fieldNumber, Object2ShortMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2ShortMap.Entry<String> entry : value.object2ShortEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeSTRINGU16Map(int fieldNumber, Object2ShortMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2ShortMap.Entry<String> entry : value.object2ShortEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeSTRINGI32Map(int fieldNumber, Object2IntMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2IntMap.Entry<String> entry : value.object2IntEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSTRINGU32Map(int fieldNumber, Object2IntMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2IntMap.Entry<String> entry : value.object2IntEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSTRINGS32Map(int fieldNumber, Object2IntMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2IntMap.Entry<String> entry : value.object2IntEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSTRINGF32Map(int fieldNumber, Object2IntMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2IntMap.Entry<String> entry : value.object2IntEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSTRINGSF32Map(int fieldNumber, Object2IntMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2IntMap.Entry<String> entry : value.object2IntEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeSTRINGI64Map(int fieldNumber, Object2LongMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2LongMap.Entry<String> entry : value.object2LongEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSTRINGU64Map(int fieldNumber, Object2LongMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2LongMap.Entry<String> entry : value.object2LongEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSTRINGS64Map(int fieldNumber, Object2LongMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2LongMap.Entry<String> entry : value.object2LongEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSTRINGF64Map(int fieldNumber, Object2LongMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2LongMap.Entry<String> entry : value.object2LongEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSTRINGSF64Map(int fieldNumber, Object2LongMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2LongMap.Entry<String> entry : value.object2LongEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeSTRINGSTRINGMap(int fieldNumber, Map<String, String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Map.Entry<String, String> entry : value.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeSTRINGDOUBLEMap(int fieldNumber, Object2DoubleMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2DoubleMap.Entry<String> entry : value.object2DoubleEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeSTRINGFLOATMap(int fieldNumber, Object2FloatMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Object2FloatMap.Entry<String> entry : value.object2FloatEntrySet()) {
                if (entry.getKey() == null) {
                    continue;
                }
                writeSTRING_Packed(entry.getKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeDOUBLEBOOLMap(int fieldNumber, Double2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2BooleanMap.Entry entry : value.double2BooleanEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeDOUBLEI8Map(int fieldNumber, Double2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2ByteMap.Entry entry : value.double2ByteEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeDOUBLEU8Map(int fieldNumber, Double2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2ByteMap.Entry entry : value.double2ByteEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeDOUBLEI16Map(int fieldNumber, Double2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2ShortMap.Entry entry : value.double2ShortEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeDOUBLEU16Map(int fieldNumber, Double2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2ShortMap.Entry entry : value.double2ShortEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeDOUBLEI32Map(int fieldNumber, Double2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2IntMap.Entry entry : value.double2IntEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeDOUBLEU32Map(int fieldNumber, Double2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2IntMap.Entry entry : value.double2IntEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeDOUBLES32Map(int fieldNumber, Double2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2IntMap.Entry entry : value.double2IntEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeDOUBLEF32Map(int fieldNumber, Double2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2IntMap.Entry entry : value.double2IntEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeDOUBLESF32Map(int fieldNumber, Double2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2IntMap.Entry entry : value.double2IntEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeDOUBLEI64Map(int fieldNumber, Double2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2LongMap.Entry entry : value.double2LongEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeDOUBLEU64Map(int fieldNumber, Double2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2LongMap.Entry entry : value.double2LongEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeDOUBLES64Map(int fieldNumber, Double2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2LongMap.Entry entry : value.double2LongEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeDOUBLEF64Map(int fieldNumber, Double2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2LongMap.Entry entry : value.double2LongEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeDOUBLESF64Map(int fieldNumber, Double2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2LongMap.Entry entry : value.double2LongEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeDOUBLESTRINGMap(int fieldNumber, Double2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2ObjectMap.Entry<String> entry : value.double2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeDOUBLEDOUBLEMap(int fieldNumber, Double2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2DoubleMap.Entry entry : value.double2DoubleEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeDOUBLEFLOATMap(int fieldNumber, Double2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Double2FloatMap.Entry entry : value.double2FloatEntrySet()) {
                writeDOUBLE_Packed(entry.getDoubleKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }


    public void writeFLOATBOOLMap(int fieldNumber, Float2BooleanMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2BooleanMap.Entry entry : value.float2BooleanEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeBOOL_Packed(entry.getBooleanValue());
            }
        });
    }


    public void writeFLOATI8Map(int fieldNumber, Float2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2ByteMap.Entry entry : value.float2ByteEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeI8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeFLOATU8Map(int fieldNumber, Float2ByteMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2ByteMap.Entry entry : value.float2ByteEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeU8_Packed(entry.getByteValue());
            }
        });
    }


    public void writeFLOATI16Map(int fieldNumber, Float2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2ShortMap.Entry entry : value.float2ShortEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeI16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeFLOATU16Map(int fieldNumber, Float2ShortMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2ShortMap.Entry entry : value.float2ShortEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeU16_Packed(entry.getShortValue());
            }
        });
    }


    public void writeFLOATI32Map(int fieldNumber, Float2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2IntMap.Entry entry : value.float2IntEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeI32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeFLOATU32Map(int fieldNumber, Float2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2IntMap.Entry entry : value.float2IntEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeU32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeFLOATS32Map(int fieldNumber, Float2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2IntMap.Entry entry : value.float2IntEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeS32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeFLOATF32Map(int fieldNumber, Float2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2IntMap.Entry entry : value.float2IntEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeFLOATSF32Map(int fieldNumber, Float2IntMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2IntMap.Entry entry : value.float2IntEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeSF32_Packed(entry.getIntValue());
            }
        });
    }


    public void writeFLOATI64Map(int fieldNumber, Float2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2LongMap.Entry entry : value.float2LongEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeI64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeFLOATU64Map(int fieldNumber, Float2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2LongMap.Entry entry : value.float2LongEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeU64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeFLOATS64Map(int fieldNumber, Float2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2LongMap.Entry entry : value.float2LongEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeS64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeFLOATF64Map(int fieldNumber, Float2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2LongMap.Entry entry : value.float2LongEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeFLOATSF64Map(int fieldNumber, Float2LongMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2LongMap.Entry entry : value.float2LongEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeSF64_Packed(entry.getLongValue());
            }
        });
    }


    public void writeFLOATSTRINGMap(int fieldNumber, Float2ObjectMap<String> value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2ObjectMap.Entry<String> entry : value.float2ObjectEntrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                writeFLOAT_Packed(entry.getFloatKey());
                writeSTRING_Packed(entry.getValue());
            }
        });
    }


    public void writeFLOATDOUBLEMap(int fieldNumber, Float2DoubleMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2DoubleMap.Entry entry : value.float2DoubleEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeDOUBLE_Packed(entry.getDoubleValue());
            }
        });
    }


    public void writeFLOATFLOATMap(int fieldNumber, Float2FloatMap value) throws IOException {
        writeMessage(fieldNumber, () -> {
            for (Float2FloatMap.Entry entry : value.float2FloatEntrySet()) {
                writeFLOAT_Packed(entry.getFloatKey());
                writeFLOAT_Packed(entry.getFloatValue());
            }
        });
    }

    @Override
    public void writeI8Array(int fieldNumber, byte[] bytes) throws IOException {
        tail = sink.writeByteArray(bytes, 0, bytes.length, this,
                sink.writeVarInt32(bytes.length, this,
                        sink.writeVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED), this, tail)));
    }

    @Override
    public void writeU8Array(int fieldNumber, byte[] value) throws IOException {
        writeI8Array(fieldNumber, value);
    }

    public static void writeRawVarInt32(int value, final byte[] buf, int offset) throws IOException {
        while (true) {
            if ((value & ~0x7F) == 0) {
                buf[offset] = (byte) value;
                return;
            } else {
                buf[offset++] = (byte) ((value & 0x7F) | 0x80);
                value >>>= 7;
            }
        }
    }

    public void writeMessage(int fieldNumber, OutputRunnable runnable) throws IOException {
        final LinkedBuffer lastBuffer;//尾端的buffer

        //写入 fieldNumber 如果小于 16 则只占用一个字节
        if (fieldNumber < 16 && tail.offset != tail.buffer.length) {
            lastBuffer = tail;
            size++;
            lastBuffer.buffer[lastBuffer.offset++] = (byte) WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
        } else {
            tail = lastBuffer = writeRawVarInt32(WireFormat.makeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED), this, tail);
        }

        final int lastOffset = tail.offset, lastSize = size;

        if (lastOffset == lastBuffer.buffer.length) {//如果写字段把lastBuffer写满了
            // not enough size for the 1-byte delimiter
            final LinkedBuffer nextBuffer = new LinkedBuffer(nextBufferSize);
            // new buffer for the content
            tail = nextBuffer;

            runnable.run();

            final int msgSize = size - lastSize;

            final byte[] delimited = new byte[computeRawVarint32Size(msgSize)];
            writeRawVarInt32(msgSize, delimited, 0);

            size += delimited.length;

            // wrap the byte array (delimited) and insert between the two buffers
            new LinkedBuffer(delimited, 0, delimited.length, lastBuffer).next = nextBuffer;
            return;
        }

        // we have enough space for the 1-byte delim
        lastBuffer.offset++;
        size++;


        runnable.run();

        final int msgSize = size - lastSize - 1;

        // optimize for small messages
        if (msgSize < 128) {
            // fits
            lastBuffer.buffer[lastOffset] = (byte) msgSize;
            return;
        }

        // split into two buffers

        // the second buffer (contains the message contents)
        final LinkedBuffer view = new LinkedBuffer(lastBuffer.buffer, lastOffset + 1, lastBuffer.offset);

        if (lastBuffer == tail) tail = view;
        else view.next = lastBuffer.next;

        // the first buffer (contains the tag)
        lastBuffer.offset = lastOffset;

        final byte[] delimited = new byte[computeRawVarint32Size(msgSize)];
        writeRawVarInt32(msgSize, delimited, 0);

        // add the difference
        size += (delimited.length - 1);

        // wrap the byte array (delimited) and insert between the two buffers
        new LinkedBuffer(delimited, 0, delimited.length, lastBuffer).next = view;
    }

    /**
     * Returns the buffer encoded with the variable int 32.
     */
    public static LinkedBuffer writeRawVarInt32(int value, final WriteSession session, LinkedBuffer lb) {
        final int size = computeRawVarint32Size(value);

        if (lb.offset + size > lb.buffer.length) lb = new LinkedBuffer(session.nextBufferSize, lb);

        final byte[] buffer = lb.buffer;
        int offset = lb.offset;
        lb.offset += size;
        session.size += size;

        if (size == 1) buffer[offset] = (byte) value;
        else {
            for (int i = 0, last = size - 1; i < last; i++, value >>>= 7)
                buffer[offset++] = (byte) ((value & 0x7F) | 0x80);

            buffer[offset] = (byte) value;
        }

        return lb;
    }

    @Override
    public ProtobjOutput clear() {
        super.clear();
        return this;
    }

    public static int encodeZigZag32(final int n) {
        return (n << 1) ^ (n >> 31);
    }

    public static long encodeZigZag64(final long n) {
        return (n << 1) ^ (n >> 63);
    }

    public static int computeRawVarint32Size(final int value) {
        if ((value & (0xffffffff << 7)) == 0) return 1;
        if ((value & (0xffffffff << 14)) == 0) return 2;
        if ((value & (0xffffffff << 21)) == 0) return 3;
        if ((value & (0xffffffff << 28)) == 0) return 4;
        return 5;
    }

    public static int computeRawVarint64Size(final long value) {
        if ((value & (0xffffffffffffffffL << 7)) == 0) return 1;
        if ((value & (0xffffffffffffffffL << 14)) == 0) return 2;
        if ((value & (0xffffffffffffffffL << 21)) == 0) return 3;
        if ((value & (0xffffffffffffffffL << 28)) == 0) return 4;
        if ((value & (0xffffffffffffffffL << 35)) == 0) return 5;
        if ((value & (0xffffffffffffffffL << 42)) == 0) return 6;
        if ((value & (0xffffffffffffffffL << 49)) == 0) return 7;
        if ((value & (0xffffffffffffffffL << 56)) == 0) return 8;
        if ((value & (0xffffffffffffffffL << 63)) == 0) return 9;
        return 10;
    }

}
