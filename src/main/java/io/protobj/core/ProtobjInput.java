package io.protobj.core;

import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import it.unimi.dsi.fastutil.booleans.BooleanArraySet;
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
import java.util.*;
import java.util.function.Function;

import static io.protobj.core.WireFormat.*;

/**
 * @auther chenqiang
 * @date 2022/8/16
 */
public class ProtobjInput implements Input {


    private final byte[] buffer;
    private int offset, limit, lastTag = 0;
    private int packedLimit = 0;

    public ProtobjInput(byte[] buffer) {
        this(buffer, 0, buffer.length);
    }

    public ProtobjInput(byte[] buffer, int offset, int len) {
        this.buffer = buffer;
        this.offset = offset;
        this.limit = offset + len;
    }

    /**
     * Returns the current offset (the position).
     */
    public int currentOffset() {
        return offset;
    }

    /**
     * Returns the current limit (the end index).
     */
    public int currentLimit() {
        return limit;
    }

    /**
     * Return true if currently reading packed field
     */
    public boolean isCurrentFieldPacked() {
        return packedLimit != 0 && packedLimit != offset;
    }

    /**
     * Returns the last tag.
     */
    public int getLastTag() {
        return lastTag;
    }


    /**
     * Reads and discards a single field, given its tag value.
     *
     * @return {@code false} if the tag is an endgroup tag, in which case nothing is skipped. Otherwise, returns
     * {@code true}.
     */
    public boolean skipField(final int tag) throws IOException {
        switch (getTagWireType(tag)) {
            case WIRETYPE_VARINT:
                readI32();
                return true;
            case WIRETYPE_FIXED64:
                readRawLittleEndian64();
                return true;
            case WIRETYPE_LENGTH_DELIMITED: {
                final int size = readRawVarint32();
                if (size < 0) throw ProtobjException.negativeSize();
                offset += size;
                return true;
            }
            case WIRETYPE_FIXED8: {
                readI8();
                return true;
            }
            case WIRETYPE_FIXED16: {
                readI16();
                return true;
            }
            case WIRETYPE_FIXED32:
                readRawLittleEndian32();
                return true;
            default:
                throw ProtobjException.invalidWireType();
        }
    }

    @Override
    public void handleUnknownField(int fieldNumber) throws IOException {
        skipField(lastTag);
    }

    @Override
    public void handleUnknownPolymorphicField(int messageIndex) {
        this.lastTag = 0;
        this.offset = this.packedLimit;
    }

    @Override
    public int readFieldNumber() throws IOException {

        if (offset == limit) {
            lastTag = 0;
            return 0;
        }

        packedLimit = 0;
        final int tag = readRawVarint32();
        final int fieldNumber = tag >>> TAG_TYPE_BITS;
        if (fieldNumber == 0) {
            // If we actually read zero, that's not a valid tag.
            throw ProtobjException.invalidTag();
        }
        lastTag = tag;
        return fieldNumber;
    }

    @Override
    public boolean readBOOL() throws IOException {
        checkIfPackedField();
        return buffer[offset++] != 0;
    }

    @Override
    public boolean readBOOL_NoCheck() throws IOException {
        return buffer[offset++] != 0;
    }

    @Override
    public byte readI8() throws IOException {
        checkIfPackedField();
        return buffer[offset++];
    }

    @Override
    public byte readI8_NoCheck() throws IOException {
        return buffer[offset++];
    }

    @Override
    public byte readU8() throws IOException {
        checkIfPackedField();
        return buffer[offset++];
    }

    @Override
    public byte readU8_NoCheck() throws IOException {
        return buffer[offset++];
    }

    @Override
    public short readI16() throws IOException {
        checkIfPackedField();
        return readRawLittleEndian16();
    }

    @Override
    public short readI16_NoCheck() throws IOException {
        return readRawLittleEndian16();
    }

    @Override
    public short readU16() throws IOException {
        checkIfPackedField();
        return readRawLittleEndian16();
    }

    @Override
    public short readU16_NoCheck() throws IOException {
        return readRawLittleEndian16();
    }

    @Override
    public int readI32() throws IOException {
        checkIfPackedField();
        return readRawVarint32();
    }

    @Override
    public int readI32_NoCheck() throws IOException {
        return readRawVarint32();
    }

    @Override
    public int readU32() throws IOException {
        checkIfPackedField();
        return readRawVarint32();
    }

    @Override
    public int readU32_NoCheck() throws IOException {
        return readRawVarint32();
    }

    @Override
    public int readS32() throws IOException {
        checkIfPackedField();
        final int n = readRawVarint32();
        return (n >>> 1) ^ -(n & 1);
    }

    @Override
    public int readS32_NoCheck() throws IOException {
        final int n = readRawVarint32();
        return (n >>> 1) ^ -(n & 1);
    }

    @Override
    public int readF32() throws IOException {
        checkIfPackedField();
        return readRawLittleEndian32();
    }

    @Override
    public int readF32_NoCheck() throws IOException {
        return readRawLittleEndian32();
    }

    @Override
    public int readSF32() throws IOException {
        checkIfPackedField();
        return readRawLittleEndian32();
    }

    @Override
    public int readSF32_NoCheck() throws IOException {
        return readRawLittleEndian32();
    }

    @Override
    public long readI64() throws IOException {
        checkIfPackedField();
        return readRawVarint64();
    }

    @Override
    public long readI64_NoCheck() throws IOException {
        return readRawVarint64();
    }

    @Override
    public long readU64() throws IOException {
        checkIfPackedField();
        return readRawVarint64();
    }

    @Override
    public long readU64_NoCheck() throws IOException {
        return readRawVarint64();
    }

    @Override
    public long readS64() throws IOException {
        checkIfPackedField();
        final long n = readRawVarint64();
        return (n >>> 1) ^ -(n & 1);
    }

    @Override
    public long readS64_NoCheck() throws IOException {
        final long n = readRawVarint64();
        return (n >>> 1) ^ -(n & 1);
    }

    @Override
    public long readF64() throws IOException {
        checkIfPackedField();
        return readRawLittleEndian64();
    }

    @Override
    public long readF64_NoCheck() throws IOException {
        return readRawLittleEndian64();
    }

    @Override
    public long readSF64() throws IOException {
        checkIfPackedField();
        return readRawLittleEndian64();
    }

    @Override
    public long readSF64_NoCheck() throws IOException {
        return readRawLittleEndian64();
    }

    @Override
    public float readFLOAT() throws IOException {
        checkIfPackedField();
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    @Override
    public float readFLOAT_NoCheck() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    @Override
    public double readDOUBLE() throws IOException {
        checkIfPackedField();
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    @Override
    public double readDOUBLE_NoCheck() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    @Override
    public String readSTRING() throws IOException {
        final int length = readRawVarint32();

        if (length < 0) throw ProtobjException.negativeSize();

        if (offset + length > limit) throw ProtobjException.misreportedSize();

        final int offset = this.offset;

        this.offset += length;

        return StringSerializer.STRING.deser(buffer, offset, length);
    }

    @Override
    public String readSTRING_NoCheck() throws IOException {
        return readSTRING();
    }

    @Override
    public boolean[] readBOOLArray() throws IOException {
        checkIfPackedField();
        int len = readI32();
        int bytesLen = this.packedLimit - this.offset;
        final byte[] bytes = new byte[bytesLen];
        System.arraycopy(buffer, offset, bytes, 0, bytesLen);
        offset += bytesLen;
        boolean[] values = new boolean[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = ((bytes[i >>> 3]) & (1 << (i % 8))) != 0;
        }
        return values;
    }

    @Override
    public byte[] readI8Array() throws IOException {
        final int length = readRawVarint32();
        if (length < 0) throw ProtobjException.negativeSize();

        if (offset + length > limit) throw ProtobjException.misreportedSize();

        final byte[] copy = new byte[length];
        System.arraycopy(buffer, offset, copy, 0, length);

        offset += length;

        return copy;
    }

    @Override
    public byte[] readU8Array() throws IOException {
        return readI8Array();
    }

    @Override
    public short[] readI16Array() throws IOException {
        int len = readI32();
        short[] values = new short[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readI16_NoCheck();
        }
        return values;
    }

    @Override
    public short[] readU16Array() throws IOException {
        return readI16Array();
    }

    @Override
    public int[] readI32Array() throws IOException {
        int len = readI32();
        int[] values = new int[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readI32_NoCheck();
        }
        return values;
    }

    @Override
    public int[] readU32Array() throws IOException {
        int len = readI32();
        int[] values = new int[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readU32_NoCheck();
        }
        return values;
    }

    @Override
    public int[] readS32Array() throws IOException {
        int len = readI32();
        int[] values = new int[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readS32_NoCheck();
        }
        return values;
    }

    @Override
    public int[] readF32Array() throws IOException {
        int len = readI32();
        int[] values = new int[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readF32_NoCheck();
        }
        return values;
    }

    @Override
    public int[] readSF32Array() throws IOException {
        int len = readI32();
        int[] values = new int[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readSF32_NoCheck();
        }
        return values;
    }

    @Override
    public long[] readI64Array() throws IOException {
        int len = readI32();
        long[] values = new long[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readI64_NoCheck();
        }
        return values;
    }

    @Override
    public long[] readU64Array() throws IOException {
        int len = readI32();
        long[] values = new long[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readU64_NoCheck();
        }
        return values;
    }

    @Override
    public long[] readS64Array() throws IOException {
        int len = readI32();
        long[] values = new long[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readS64_NoCheck();
        }
        return values;
    }

    @Override
    public long[] readF64Array() throws IOException {
        int len = readI32();
        long[] values = new long[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readF64_NoCheck();
        }
        return values;
    }

    @Override
    public long[] readSF64Array() throws IOException {
        int len = readI32();
        long[] values = new long[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readSF64_NoCheck();
        }
        return values;
    }

    @Override
    public float[] readFLOATArray() throws IOException {
        int len = readI32();
        float[] values = new float[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readFLOAT_NoCheck();
        }
        return values;
    }

    @Override
    public double[] readDOUBLEArray() throws IOException {
        int len = readI32();
        double[] values = new double[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = readDOUBLE_NoCheck();
        }
        return values;
    }

    @Override
    public String[] readSTRINGArray() throws IOException {
        checkIfPackedField();
        String[] value = null;
        do {
            int index = readI32();
            if (value == null) {
                value = new String[index + 1];
            }
            value[index] = readSTRING_NoCheck();
        } while (offset < packedLimit);
        return value;
    }

    @Override
    public BooleanList readBOOLList() throws IOException {
        checkIfPackedField();
        int len = readI32();
        int bytesLen = this.packedLimit - this.offset;
        final byte[] bytes = new byte[bytesLen];
        System.arraycopy(buffer, offset, bytes, 0, bytesLen);
        offset += bytesLen;
        BooleanList booleans = new BooleanArrayList(len);
        for (int i = 0; i < len; i++) {
            booleans.add(((bytes[i >>> 3]) & (1 << (i % 8))) != 0);
        }
        return booleans;
    }

    @Override
    public ByteList readI8List() throws IOException {
        return new ByteArrayList(readI8Array());
    }

    @Override
    public ByteList readU8List() throws IOException {
        return new ByteArrayList(readI8Array());
    }

    @Override
    public ShortList readI16List() throws IOException {
        checkIfPackedField();
        ShortList shorts = new ShortArrayList();
        do {
            shorts.add(readI16_NoCheck());
        } while (offset < packedLimit);
        return shorts;
    }

    @Override
    public ShortList readU16List() throws IOException {
        checkIfPackedField();
        ShortList shorts = new ShortArrayList();
        do {
            shorts.add(readU16_NoCheck());
        } while (offset < packedLimit);
        return shorts;
    }

    @Override
    public IntList readI32List() throws IOException {
        checkIfPackedField();
        IntList ints = new IntArrayList();
        do {
            ints.add(readI32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public IntList readU32List() throws IOException {
        checkIfPackedField();
        IntList ints = new IntArrayList();
        do {
            ints.add(readU32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public IntList readS32List() throws IOException {
        checkIfPackedField();
        IntList ints = new IntArrayList();
        do {
            ints.add(readS32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public IntList readF32List() throws IOException {
        checkIfPackedField();
        IntList ints = new IntArrayList();
        do {
            ints.add(readF32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public IntList readSF32List() throws IOException {
        checkIfPackedField();
        IntList ints = new IntArrayList();
        do {
            ints.add(readSF32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public LongList readI64List() throws IOException {
        checkIfPackedField();
        LongList longs = new LongArrayList();
        while (offset < packedLimit) {
            longs.add(readI64_NoCheck());
        }
        return longs;
    }

    @Override
    public LongList readU64List() throws IOException {
        checkIfPackedField();
        LongList longs = new LongArrayList();
        while (offset < packedLimit) {
            longs.add(readU64_NoCheck());
        }
        return longs;
    }

    @Override
    public LongList readS64List() throws IOException {
        checkIfPackedField();
        LongList longs = new LongArrayList();
        do {
            longs.add(readS64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public LongList readF64List() throws IOException {
        checkIfPackedField();
        LongList longs = new LongArrayList();
        do {
            longs.add(readF64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public LongList readSF64List() throws IOException {
        checkIfPackedField();
        LongList longs = new LongArrayList();
        do {
            longs.add(readSF64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public FloatList readFLOATList() throws IOException {
        checkIfPackedField();
        FloatList floats = new FloatArrayList();
        do {
            floats.add(readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return floats;
    }

    @Override
    public DoubleList readDOUBLEList() throws IOException {
        checkIfPackedField();
        DoubleList doubles = new DoubleArrayList();
        do {
            doubles.add(readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return doubles;
    }

    @Override
    public List<String> readSTRINGList() throws IOException {
        checkIfPackedField();
        List<String> strings = new ArrayList<>();
        do {
            strings.add(readSTRING_NoCheck());
        } while (offset < packedLimit);
        return strings;
    }

    @Override
    public BooleanSet readBOOLSet() throws IOException {
        checkIfPackedField();
        BooleanSet booleans = new BooleanArraySet(2);
        do {
            booleans.add(readBOOL_NoCheck());
        } while (offset < packedLimit);
        return booleans;
    }

    @Override
    public ByteSet readI8Set() throws IOException {
        return new ByteOpenHashSet(readI8Array());
    }

    @Override
    public ByteSet readU8Set() throws IOException {
        return new ByteOpenHashSet(readI8Array());
    }

    @Override
    public ShortSet readI16Set() throws IOException {
        checkIfPackedField();
        ShortSet shorts = new ShortOpenHashSet();
        do {
            shorts.add(readI16_NoCheck());
        } while (offset < packedLimit);
        return shorts;
    }

    @Override
    public ShortSet readU16Set() throws IOException {
        checkIfPackedField();
        ShortSet shorts = new ShortOpenHashSet();
        do {
            shorts.add(readU16_NoCheck());
        } while (offset < packedLimit);
        return shorts;
    }

    @Override
    public IntSet readI32Set() throws IOException {
        checkIfPackedField();
        IntSet ints = new IntOpenHashSet();
        while (offset < packedLimit) {
            ints.add(readI32_NoCheck());
        }
        return ints;
    }

    @Override
    public IntSet readU32Set() throws IOException {
        checkIfPackedField();
        IntSet ints = new IntOpenHashSet();
        do {
            ints.add(readU32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public IntSet readS32Set() throws IOException {
        checkIfPackedField();
        IntSet ints = new IntOpenHashSet();
        do {
            ints.add(readS32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public IntSet readF32Set() throws IOException {
        checkIfPackedField();
        IntSet ints = new IntOpenHashSet();
        while (offset < packedLimit) {
            ints.add(readF32_NoCheck());
        }
        return ints;
    }

    @Override
    public IntSet readSF32Set() throws IOException {
        checkIfPackedField();
        IntSet ints = new IntOpenHashSet();
        do {
            ints.add(readSF32_NoCheck());
        } while (offset < packedLimit);
        return ints;
    }

    @Override
    public LongSet readI64Set() throws IOException {
        checkIfPackedField();
        LongSet longs = new LongOpenHashSet();
        while (offset < packedLimit) {
            longs.add(readI64_NoCheck());
        }
        return longs;
    }

    @Override
    public LongSet readU64Set() throws IOException {
        checkIfPackedField();
        LongSet longs = new LongOpenHashSet();
        do {
            longs.add(readU64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public LongSet readS64Set() throws IOException {
        checkIfPackedField();
        LongSet longs = new LongOpenHashSet();
        do {
            longs.add(readS64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public LongSet readF64Set() throws IOException {
        checkIfPackedField();
        LongSet longs = new LongOpenHashSet();
        do {
            longs.add(readF64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public LongSet readSF64Set() throws IOException {
        checkIfPackedField();
        LongSet longs = new LongOpenHashSet();
        do {
            longs.add(readSF64_NoCheck());
        } while (offset < packedLimit);
        return longs;
    }

    @Override
    public FloatSet readFLOATSet() throws IOException {
        checkIfPackedField();
        FloatSet floats = new FloatOpenHashSet();
        while (offset < packedLimit) {
            floats.add(readFLOAT_NoCheck());
        }
        return floats;
    }

    @Override
    public DoubleSet readDOUBLESet() throws IOException {
        checkIfPackedField();
        DoubleSet doubles = new DoubleOpenHashSet();
        do {
            doubles.add(readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return doubles;
    }

    @Override
    public Set<String> readSTRINGSet() throws IOException {
        checkIfPackedField();
        Set<String> strings = new HashSet<>();
        do {
            strings.add(readSTRING_NoCheck());
        } while (offset < packedLimit);
        return strings;
    }

    public Byte2BooleanMap readI8BOOLMap() throws IOException {
        checkIfPackedField();
        Byte2BooleanMap value = new Byte2BooleanOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }


    public Byte2ByteMap readI8I8Map() throws IOException {
        checkIfPackedField();
        Byte2ByteMap value = new Byte2ByteOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }


    public Byte2ByteMap readI8U8Map() throws IOException {
        checkIfPackedField();
        Byte2ByteMap value = new Byte2ByteOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ShortMap readI8I16Map() throws IOException {
        checkIfPackedField();
        Byte2ShortMap value = new Byte2ShortOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ShortMap readI8U16Map() throws IOException {
        checkIfPackedField();
        Byte2ShortMap value = new Byte2ShortOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readI8I32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readI8U32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readI8S32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readI8F32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readI8SF32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readI8I64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readI8U64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readI8S64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readI8F64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readI8SF64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ObjectMap<String> readI8STRINGMap() throws IOException {
        checkIfPackedField();
        Byte2ObjectMap<String> value = new Byte2ObjectOpenHashMap<String>();
        do {
            value.put(readI8_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2DoubleMap readI8DOUBLEMap() throws IOException {
        checkIfPackedField();
        Byte2DoubleMap value = new Byte2DoubleOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2FloatMap readI8FLOATMap() throws IOException {
        checkIfPackedField();
        Byte2FloatMap value = new Byte2FloatOpenHashMap();
        do {
            value.put(readI8_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2BooleanMap readU8BOOLMap() throws IOException {
        checkIfPackedField();
        Byte2BooleanMap value = new Byte2BooleanOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ByteMap readU8I8Map() throws IOException {
        checkIfPackedField();
        Byte2ByteMap value = new Byte2ByteOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ByteMap readU8U8Map() throws IOException {
        checkIfPackedField();
        Byte2ByteMap value = new Byte2ByteOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ShortMap readU8I16Map() throws IOException {
        checkIfPackedField();
        Byte2ShortMap value = new Byte2ShortOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ShortMap readU8U16Map() throws IOException {
        checkIfPackedField();
        Byte2ShortMap value = new Byte2ShortOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readU8I32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readU8U32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readU8S32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readU8F32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2IntMap readU8SF32Map() throws IOException {
        checkIfPackedField();
        Byte2IntMap value = new Byte2IntOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readU8I64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readU8U64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readU8S64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readU8F64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2LongMap readU8SF64Map() throws IOException {
        checkIfPackedField();
        Byte2LongMap value = new Byte2LongOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2ObjectMap<String> readU8STRINGMap() throws IOException {
        checkIfPackedField();
        Byte2ObjectMap<String> value = new Byte2ObjectOpenHashMap<String>();
        do {
            value.put(readU8_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2DoubleMap readU8DOUBLEMap() throws IOException {
        checkIfPackedField();
        Byte2DoubleMap value = new Byte2DoubleOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Byte2FloatMap readU8FLOATMap() throws IOException {
        checkIfPackedField();
        Byte2FloatMap value = new Byte2FloatOpenHashMap();
        do {
            value.put(readU8_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2BooleanMap readI16BOOLMap() throws IOException {
        checkIfPackedField();
        Short2BooleanMap value = new Short2BooleanOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ByteMap readI16I8Map() throws IOException {
        checkIfPackedField();
        Short2ByteMap value = new Short2ByteOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ByteMap readI16U8Map() throws IOException {
        checkIfPackedField();
        Short2ByteMap value = new Short2ByteOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ShortMap readI16I16Map() throws IOException {
        checkIfPackedField();
        Short2ShortMap value = new Short2ShortOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ShortMap readI16U16Map() throws IOException {
        checkIfPackedField();
        Short2ShortMap value = new Short2ShortOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readI16I32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readI16U32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readI16S32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readI16F32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readI16SF32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readI16I64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readI16U64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readI16S64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readI16F64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readI16SF64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ObjectMap<String> readI16STRINGMap() throws IOException {
        checkIfPackedField();
        Short2ObjectMap<String> value = new Short2ObjectOpenHashMap<String>();
        do {
            value.put(readI16_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2DoubleMap readI16DOUBLEMap() throws IOException {
        checkIfPackedField();
        Short2DoubleMap value = new Short2DoubleOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2FloatMap readI16FLOATMap() throws IOException {
        checkIfPackedField();
        Short2FloatMap value = new Short2FloatOpenHashMap();
        do {
            value.put(readI16_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2BooleanMap readU16BOOLMap() throws IOException {
        checkIfPackedField();
        Short2BooleanMap value = new Short2BooleanOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ByteMap readU16I8Map() throws IOException {
        checkIfPackedField();
        Short2ByteMap value = new Short2ByteOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ByteMap readU16U8Map() throws IOException {
        checkIfPackedField();
        Short2ByteMap value = new Short2ByteOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ShortMap readU16I16Map() throws IOException {
        checkIfPackedField();
        Short2ShortMap value = new Short2ShortOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ShortMap readU16U16Map() throws IOException {
        checkIfPackedField();
        Short2ShortMap value = new Short2ShortOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readU16I32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readU16U32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readU16S32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readU16F32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2IntMap readU16SF32Map() throws IOException {
        checkIfPackedField();
        Short2IntMap value = new Short2IntOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readU16I64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readU16U64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readU16S64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readU16F64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2LongMap readU16SF64Map() throws IOException {
        checkIfPackedField();
        Short2LongMap value = new Short2LongOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2ObjectMap<String> readU16STRINGMap() throws IOException {
        checkIfPackedField();
        Short2ObjectMap<String> value = new Short2ObjectOpenHashMap<String>();
        do {
            value.put(readU16_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2DoubleMap readU16DOUBLEMap() throws IOException {
        checkIfPackedField();
        Short2DoubleMap value = new Short2DoubleOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Short2FloatMap readU16FLOATMap() throws IOException {
        checkIfPackedField();
        Short2FloatMap value = new Short2FloatOpenHashMap();
        do {
            value.put(readU16_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2BooleanMap readI32BOOLMap() throws IOException {
        checkIfPackedField();
        Int2BooleanMap value = new Int2BooleanOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readI32I8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readI32U8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readI32I16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readI32U16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readI32I32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readI32U32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readI32S32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readI32F32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readI32SF32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readI32I64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readI32U64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readI32S64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readI32F64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readI32SF64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ObjectMap<String> readI32STRINGMap() throws IOException {
        checkIfPackedField();
        Int2ObjectMap<String> value = new Int2ObjectOpenHashMap<String>();
        do {
            value.put(readI32_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2DoubleMap readI32DOUBLEMap() throws IOException {
        checkIfPackedField();
        Int2DoubleMap value = new Int2DoubleOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2FloatMap readI32FLOATMap() throws IOException {
        checkIfPackedField();
        Int2FloatMap value = new Int2FloatOpenHashMap();
        do {
            value.put(readI32_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2BooleanMap readU32BOOLMap() throws IOException {
        checkIfPackedField();
        Int2BooleanMap value = new Int2BooleanOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readU32I8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readU32U8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readU32I16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readU32U16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readU32I32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readU32U32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readU32S32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readU32F32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readU32SF32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readU32I64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readU32U64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readU32S64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readU32F64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readU32SF64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ObjectMap<String> readU32STRINGMap() throws IOException {
        checkIfPackedField();
        Int2ObjectMap<String> value = new Int2ObjectOpenHashMap<String>();
        do {
            value.put(readU32_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2DoubleMap readU32DOUBLEMap() throws IOException {
        checkIfPackedField();
        Int2DoubleMap value = new Int2DoubleOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2FloatMap readU32FLOATMap() throws IOException {
        checkIfPackedField();
        Int2FloatMap value = new Int2FloatOpenHashMap();
        do {
            value.put(readU32_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2BooleanMap readS32BOOLMap() throws IOException {
        checkIfPackedField();
        Int2BooleanMap value = new Int2BooleanOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readS32I8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readS32U8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readS32I16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readS32U16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readS32I32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readS32U32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readS32S32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readS32F32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readS32SF32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readS32I64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readS32U64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readS32S64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readS32F64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readS32SF64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ObjectMap<String> readS32STRINGMap() throws IOException {
        checkIfPackedField();
        Int2ObjectMap<String> value = new Int2ObjectOpenHashMap<String>();
        do {
            value.put(readS32_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2DoubleMap readS32DOUBLEMap() throws IOException {
        checkIfPackedField();
        Int2DoubleMap value = new Int2DoubleOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2FloatMap readS32FLOATMap() throws IOException {
        checkIfPackedField();
        Int2FloatMap value = new Int2FloatOpenHashMap();
        do {
            value.put(readS32_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2BooleanMap readF32BOOLMap() throws IOException {
        checkIfPackedField();
        Int2BooleanMap value = new Int2BooleanOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readF32I8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readF32U8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readF32I16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readF32U16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readF32I32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readF32U32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readF32S32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readF32F32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readF32SF32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readF32I64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readF32U64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readF32S64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readF32F64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readF32SF64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ObjectMap<String> readF32STRINGMap() throws IOException {
        checkIfPackedField();
        Int2ObjectMap<String> value = new Int2ObjectOpenHashMap<String>();
        do {
            value.put(readF32_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2DoubleMap readF32DOUBLEMap() throws IOException {
        checkIfPackedField();
        Int2DoubleMap value = new Int2DoubleOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2FloatMap readF32FLOATMap() throws IOException {
        checkIfPackedField();
        Int2FloatMap value = new Int2FloatOpenHashMap();
        do {
            value.put(readF32_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2BooleanMap readSF32BOOLMap() throws IOException {
        checkIfPackedField();
        Int2BooleanMap value = new Int2BooleanOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readSF32I8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ByteMap readSF32U8Map() throws IOException {
        checkIfPackedField();
        Int2ByteMap value = new Int2ByteOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readSF32I16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ShortMap readSF32U16Map() throws IOException {
        checkIfPackedField();
        Int2ShortMap value = new Int2ShortOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readSF32I32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readSF32U32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readSF32S32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readSF32F32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2IntMap readSF32SF32Map() throws IOException {
        checkIfPackedField();
        Int2IntMap value = new Int2IntOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readSF32I64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readSF32U64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readSF32S64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readSF32F64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2LongMap readSF32SF64Map() throws IOException {
        checkIfPackedField();
        Int2LongMap value = new Int2LongOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2ObjectMap<String> readSF32STRINGMap() throws IOException {
        checkIfPackedField();
        Int2ObjectMap<String> value = new Int2ObjectOpenHashMap<String>();
        do {
            value.put(readSF32_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2DoubleMap readSF32DOUBLEMap() throws IOException {
        checkIfPackedField();
        Int2DoubleMap value = new Int2DoubleOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Int2FloatMap readSF32FLOATMap() throws IOException {
        checkIfPackedField();
        Int2FloatMap value = new Int2FloatOpenHashMap();
        do {
            value.put(readSF32_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2BooleanMap readI64BOOLMap() throws IOException {
        checkIfPackedField();
        Long2BooleanMap value = new Long2BooleanOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readI64I8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readI64U8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readI64I16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readI64U16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readI64I32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readI64U32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readI64S32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readI64F32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readI64SF32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readI64I64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readI64U64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readI64S64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readI64F64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readI64SF64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ObjectMap<String> readI64STRINGMap() throws IOException {
        checkIfPackedField();
        Long2ObjectMap<String> value = new Long2ObjectOpenHashMap<String>();
        do {
            value.put(readI64_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2DoubleMap readI64DOUBLEMap() throws IOException {
        checkIfPackedField();
        Long2DoubleMap value = new Long2DoubleOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2FloatMap readI64FLOATMap() throws IOException {
        checkIfPackedField();
        Long2FloatMap value = new Long2FloatOpenHashMap();
        do {
            value.put(readI64_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2BooleanMap readU64BOOLMap() throws IOException {
        checkIfPackedField();
        Long2BooleanMap value = new Long2BooleanOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readU64I8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readU64U8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readU64I16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readU64U16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readU64I32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readU64U32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readU64S32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readU64F32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readU64SF32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readU64I64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readU64U64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readU64S64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readU64F64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readU64SF64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ObjectMap<String> readU64STRINGMap() throws IOException {
        checkIfPackedField();
        Long2ObjectMap<String> value = new Long2ObjectOpenHashMap<String>();
        do {
            value.put(readU64_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2DoubleMap readU64DOUBLEMap() throws IOException {
        checkIfPackedField();
        Long2DoubleMap value = new Long2DoubleOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2FloatMap readU64FLOATMap() throws IOException {
        checkIfPackedField();
        Long2FloatMap value = new Long2FloatOpenHashMap();
        do {
            value.put(readU64_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2BooleanMap readS64BOOLMap() throws IOException {
        checkIfPackedField();
        Long2BooleanMap value = new Long2BooleanOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readS64I8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readS64U8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readS64I16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readS64U16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readS64I32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readS64U32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readS64S32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readS64F32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readS64SF32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readS64I64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readS64U64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readS64S64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readS64F64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readS64SF64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ObjectMap<String> readS64STRINGMap() throws IOException {
        checkIfPackedField();
        Long2ObjectMap<String> value = new Long2ObjectOpenHashMap<String>();
        do {
            value.put(readS64_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2DoubleMap readS64DOUBLEMap() throws IOException {
        checkIfPackedField();
        Long2DoubleMap value = new Long2DoubleOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2FloatMap readS64FLOATMap() throws IOException {
        checkIfPackedField();
        Long2FloatMap value = new Long2FloatOpenHashMap();
        do {
            value.put(readS64_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2BooleanMap readF64BOOLMap() throws IOException {
        checkIfPackedField();
        Long2BooleanMap value = new Long2BooleanOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readF64I8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readF64U8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readF64I16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readF64U16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readF64I32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readF64U32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readF64S32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readF64F32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readF64SF32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readF64I64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readF64U64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readF64S64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readF64F64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readF64SF64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ObjectMap<String> readF64STRINGMap() throws IOException {
        checkIfPackedField();
        Long2ObjectMap<String> value = new Long2ObjectOpenHashMap<String>();
        do {
            value.put(readF64_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2DoubleMap readF64DOUBLEMap() throws IOException {
        checkIfPackedField();
        Long2DoubleMap value = new Long2DoubleOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2FloatMap readF64FLOATMap() throws IOException {
        checkIfPackedField();
        Long2FloatMap value = new Long2FloatOpenHashMap();
        do {
            value.put(readF64_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2BooleanMap readSF64BOOLMap() throws IOException {
        checkIfPackedField();
        Long2BooleanMap value = new Long2BooleanOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readSF64I8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ByteMap readSF64U8Map() throws IOException {
        checkIfPackedField();
        Long2ByteMap value = new Long2ByteOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readSF64I16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ShortMap readSF64U16Map() throws IOException {
        checkIfPackedField();
        Long2ShortMap value = new Long2ShortOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readSF64I32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readSF64U32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readSF64S32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readSF64F32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2IntMap readSF64SF32Map() throws IOException {
        checkIfPackedField();
        Long2IntMap value = new Long2IntOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readSF64I64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readSF64U64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readSF64S64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readSF64F64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2LongMap readSF64SF64Map() throws IOException {
        checkIfPackedField();
        Long2LongMap value = new Long2LongOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2ObjectMap<String> readSF64STRINGMap() throws IOException {
        checkIfPackedField();
        Long2ObjectMap<String> value = new Long2ObjectOpenHashMap<>();
        do {
            value.put(readSF64_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2DoubleMap readSF64DOUBLEMap() throws IOException {
        checkIfPackedField();
        Long2DoubleMap value = new Long2DoubleOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Long2FloatMap readSF64FLOATMap() throws IOException {
        checkIfPackedField();
        Long2FloatMap value = new Long2FloatOpenHashMap();
        do {
            value.put(readSF64_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2BooleanMap<String> readSTRINGBOOLMap() throws IOException {
        checkIfPackedField();
        Object2BooleanMap<String> value = new Object2BooleanOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2ByteMap<String> readSTRINGI8Map() throws IOException {
        checkIfPackedField();
        Object2ByteMap<String> value = new Object2ByteOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2ByteMap<String> readSTRINGU8Map() throws IOException {
        checkIfPackedField();
        Object2ByteMap<String> value = new Object2ByteOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2ShortMap<String> readSTRINGI16Map() throws IOException {
        checkIfPackedField();
        Object2ShortMap<String> value = new Object2ShortOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2ShortMap<String> readSTRINGU16Map() throws IOException {
        checkIfPackedField();
        Object2ShortMap<String> value = new Object2ShortOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2IntMap<String> readSTRINGI32Map() throws IOException {
        checkIfPackedField();
        Object2IntMap<String> value = new Object2IntOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2IntMap<String> readSTRINGU32Map() throws IOException {
        checkIfPackedField();
        Object2IntMap<String> value = new Object2IntOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2IntMap<String> readSTRINGS32Map() throws IOException {
        checkIfPackedField();
        Object2IntMap<String> value = new Object2IntOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2IntMap<String> readSTRINGF32Map() throws IOException {
        checkIfPackedField();
        Object2IntMap<String> value = new Object2IntOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2IntMap<String> readSTRINGSF32Map() throws IOException {
        checkIfPackedField();
        Object2IntMap<String> value = new Object2IntOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2LongMap<String> readSTRINGI64Map() throws IOException {
        checkIfPackedField();
        Object2LongMap<String> value = new Object2LongOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2LongMap<String> readSTRINGU64Map() throws IOException {
        checkIfPackedField();
        Object2LongMap<String> value = new Object2LongOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2LongMap<String> readSTRINGS64Map() throws IOException {
        checkIfPackedField();
        Object2LongMap<String> value = new Object2LongOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2LongMap<String> readSTRINGF64Map() throws IOException {
        checkIfPackedField();
        Object2LongMap<String> value = new Object2LongOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2LongMap<String> readSTRINGSF64Map() throws IOException {
        checkIfPackedField();
        Object2LongMap<String> value = new Object2LongOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Map<String, String> readSTRINGSTRINGMap() throws IOException {
        checkIfPackedField();
        Map<String, String> value = new HashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2DoubleMap<String> readSTRINGDOUBLEMap() throws IOException {
        checkIfPackedField();
        Object2DoubleMap<String> value = new Object2DoubleOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Object2FloatMap<String> readSTRINGFLOATMap() throws IOException {
        checkIfPackedField();
        Object2FloatMap<String> value = new Object2FloatOpenHashMap<>();
        do {
            value.put(readSTRING_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2BooleanMap readDOUBLEBOOLMap() throws IOException {
        checkIfPackedField();
        Double2BooleanMap value = new Double2BooleanOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2ByteMap readDOUBLEI8Map() throws IOException {
        checkIfPackedField();
        Double2ByteMap value = new Double2ByteOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2ByteMap readDOUBLEU8Map() throws IOException {
        checkIfPackedField();
        Double2ByteMap value = new Double2ByteOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2ShortMap readDOUBLEI16Map() throws IOException {
        checkIfPackedField();
        Double2ShortMap value = new Double2ShortOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2ShortMap readDOUBLEU16Map() throws IOException {
        checkIfPackedField();
        Double2ShortMap value = new Double2ShortOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2IntMap readDOUBLEI32Map() throws IOException {
        checkIfPackedField();
        Double2IntMap value = new Double2IntOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2IntMap readDOUBLEU32Map() throws IOException {
        checkIfPackedField();
        Double2IntMap value = new Double2IntOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2IntMap readDOUBLES32Map() throws IOException {
        checkIfPackedField();
        Double2IntMap value = new Double2IntOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2IntMap readDOUBLEF32Map() throws IOException {
        checkIfPackedField();
        Double2IntMap value = new Double2IntOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2IntMap readDOUBLESF32Map() throws IOException {
        checkIfPackedField();
        Double2IntMap value = new Double2IntOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2LongMap readDOUBLEI64Map() throws IOException {
        checkIfPackedField();
        Double2LongMap value = new Double2LongOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2LongMap readDOUBLEU64Map() throws IOException {
        checkIfPackedField();
        Double2LongMap value = new Double2LongOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2LongMap readDOUBLES64Map() throws IOException {
        checkIfPackedField();
        Double2LongMap value = new Double2LongOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2LongMap readDOUBLEF64Map() throws IOException {
        checkIfPackedField();
        Double2LongMap value = new Double2LongOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2LongMap readDOUBLESF64Map() throws IOException {
        checkIfPackedField();
        Double2LongMap value = new Double2LongOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2ObjectMap<String> readDOUBLESTRINGMap() throws IOException {
        checkIfPackedField();
        Double2ObjectMap<String> value = new Double2ObjectOpenHashMap<>();
        do {
            value.put(readDOUBLE_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2DoubleMap readDOUBLEDOUBLEMap() throws IOException {
        checkIfPackedField();
        Double2DoubleMap value = new Double2DoubleOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Double2FloatMap readDOUBLEFLOATMap() throws IOException {
        checkIfPackedField();
        Double2FloatMap value = new Double2FloatOpenHashMap();
        do {
            value.put(readDOUBLE_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2BooleanMap readFLOATBOOLMap() throws IOException {
        checkIfPackedField();
        Float2BooleanMap value = new Float2BooleanOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readBOOL_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2ByteMap readFLOATI8Map() throws IOException {
        checkIfPackedField();
        Float2ByteMap value = new Float2ByteOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readI8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2ByteMap readFLOATU8Map() throws IOException {
        checkIfPackedField();
        Float2ByteMap value = new Float2ByteOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readU8_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2ShortMap readFLOATI16Map() throws IOException {
        checkIfPackedField();
        Float2ShortMap value = new Float2ShortOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readI16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2ShortMap readFLOATU16Map() throws IOException {
        checkIfPackedField();
        Float2ShortMap value = new Float2ShortOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readU16_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2IntMap readFLOATI32Map() throws IOException {
        checkIfPackedField();
        Float2IntMap value = new Float2IntOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readI32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2IntMap readFLOATU32Map() throws IOException {
        checkIfPackedField();
        Float2IntMap value = new Float2IntOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readU32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2IntMap readFLOATS32Map() throws IOException {
        checkIfPackedField();
        Float2IntMap value = new Float2IntOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readS32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2IntMap readFLOATF32Map() throws IOException {
        checkIfPackedField();
        Float2IntMap value = new Float2IntOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2IntMap readFLOATSF32Map() throws IOException {
        checkIfPackedField();
        Float2IntMap value = new Float2IntOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readSF32_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2LongMap readFLOATI64Map() throws IOException {
        checkIfPackedField();
        Float2LongMap value = new Float2LongOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readI64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2LongMap readFLOATU64Map() throws IOException {
        checkIfPackedField();
        Float2LongMap value = new Float2LongOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readU64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2LongMap readFLOATS64Map() throws IOException {
        checkIfPackedField();
        Float2LongMap value = new Float2LongOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readS64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2LongMap readFLOATF64Map() throws IOException {
        checkIfPackedField();
        Float2LongMap value = new Float2LongOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2LongMap readFLOATSF64Map() throws IOException {
        checkIfPackedField();
        Float2LongMap value = new Float2LongOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readSF64_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2ObjectMap<String> readFLOATSTRINGMap() throws IOException {
        checkIfPackedField();
        Float2ObjectMap<String> value = new Float2ObjectOpenHashMap<>();
        do {
            value.put(readFLOAT_NoCheck(), readSTRING_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2DoubleMap readFLOATDOUBLEMap() throws IOException {
        checkIfPackedField();
        Float2DoubleMap value = new Float2DoubleOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readDOUBLE_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    public Float2FloatMap readFLOATFLOATMap() throws IOException {
        checkIfPackedField();
        Float2FloatMap value = new Float2FloatOpenHashMap();
        do {
            value.put(readFLOAT_NoCheck(), readFLOAT_NoCheck());
        } while (offset < packedLimit);
        return value;
    }

    @Override
    public int readMessageStart() throws IOException {
        final int length = readRawVarint32();
        if (length < 0)
            throw ProtobjException.negativeSize();
        // save old limit
        final int oldLimit = this.limit;
        this.limit = offset + length;
        this.packedLimit = this.limit;
        return oldLimit;
    }

    @Override
    public void readMessageStop(final int oldLimit) throws IOException {
        if (this.offset != this.limit) {
            throw ProtobjException.misreportedSize();
        }
        //restore limit
        this.limit = oldLimit;
        this.lastTag = 0;
    }

    public void checkIfPackedField() throws IOException {
        // Do we have the start of a packed field?
        if (packedLimit == 0 && getTagWireType(lastTag) == WIRETYPE_LENGTH_DELIMITED) {
            final int length = readRawVarint32();
            if (length < 0) throw ProtobjException.negativeSize();

            if (offset + length > limit) throw ProtobjException.misreportedSize();

            this.packedLimit = this.offset + length;
        }
    }

    /**
     * Reads a var int 32 from the internal byte buffer.
     */
    public int readRawVarint32() throws IOException {
        byte tmp = buffer[offset++];
        if (tmp >= 0) {
            return tmp;
        }
        int result = tmp & 0x7f;
        if ((tmp = buffer[offset++]) >= 0) {
            result |= tmp << 7;
        } else {
            result |= (tmp & 0x7f) << 7;
            if ((tmp = buffer[offset++]) >= 0) {
                result |= tmp << 14;
            } else {
                result |= (tmp & 0x7f) << 14;
                if ((tmp = buffer[offset++]) >= 0) {
                    result |= tmp << 21;
                } else {
                    result |= (tmp & 0x7f) << 21;
                    result |= (tmp = buffer[offset++]) << 28;
                    if (tmp < 0) {
                        // Discard upper 32 bits.
                        for (int i = 0; i < 5; i++) {
                            if (buffer[offset++] >= 0) {
                                return result;
                            }
                        }
                        throw ProtobjException.malformedVarint();
                    }
                }
            }
        }
        return result;
    }

    /**
     * Reads a var int 64 from the internal byte buffer.
     */
    public long readRawVarint64() throws IOException {
        final byte[] buffer = this.buffer;
        int offset = this.offset;

        int shift = 0;
        long result = 0;
        while (shift < 64) {
            final byte b = buffer[offset++];
            result |= (long) (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                this.offset = offset;
                return result;
            }
            shift += 7;
        }
        throw ProtobjException.malformedVarint();
    }

    /**
     * Read a 32-bit little-endian integer from the internal buffer.
     */
    public int readRawLittleEndian32() throws IOException {
        final byte[] buffer = this.buffer;
        int offset = this.offset;

        final byte b1 = buffer[offset++];
        final byte b2 = buffer[offset++];
        final byte b3 = buffer[offset++];
        final byte b4 = buffer[offset++];

        this.offset = offset;

        return (((int) b1 & 0xff)) | (((int) b2 & 0xff) << 8) | (((int) b3 & 0xff) << 16) | (((int) b4 & 0xff) << 24);
    }

    /**
     * Read a 16-bit little-endian integer from the internal buffer.
     */
    public short readRawLittleEndian16() throws IOException {
        final byte[] buffer = this.buffer;
        int offset = this.offset;

        final byte b1 = buffer[offset++];
        final byte b2 = buffer[offset++];
        this.offset = offset;

        return (short) (((b1 & 0xff)) | ((b2 & 0xff) << 8));
    }

    /**
     * Read a 64-bit little-endian integer from the internal byte buffer.
     */
    public long readRawLittleEndian64() throws IOException {
        final byte[] buffer = this.buffer;
        int offset = this.offset;

        final byte b1 = buffer[offset++];
        final byte b2 = buffer[offset++];
        final byte b3 = buffer[offset++];
        final byte b4 = buffer[offset++];
        final byte b5 = buffer[offset++];
        final byte b6 = buffer[offset++];
        final byte b7 = buffer[offset++];
        final byte b8 = buffer[offset++];

        this.offset = offset;

        return (((long) b1 & 0xff)) | (((long) b2 & 0xff) << 8) | (((long) b3 & 0xff) << 16) | (((long) b4 & 0xff) << 24) | (((long) b5 & 0xff) << 32) | (((long) b6 & 0xff) << 40) | (((long) b7 & 0xff) << 48) | (((long) b8 & 0xff) << 56);
    }

}
