package io.protobj.core;

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
 * @date 2022/8/16
 */
public interface Input {

    void handleUnknownField(int fieldNumber) throws IOException;

    int readFieldNumber() throws IOException;

    boolean readBOOL() throws IOException;

    boolean readBOOL_NoCheck() throws IOException;

    byte readI8() throws IOException;

    byte readI8_NoCheck() throws IOException;

    byte readU8() throws IOException;

    byte readU8_NoCheck() throws IOException;

    short readI16() throws IOException;

    short readI16_NoCheck() throws IOException;

    short readU16() throws IOException;

    short readU16_NoCheck() throws IOException;

    int readI32() throws IOException;

    int readI32_NoCheck() throws IOException;

    int readU32() throws IOException;

    int readU32_NoCheck() throws IOException;

    int readS32() throws IOException;

    int readS32_NoCheck() throws IOException;

    int readF32() throws IOException;

    int readF32_NoCheck() throws IOException;

    int readSF32() throws IOException;

    int readSF32_NoCheck() throws IOException;

    long readI64() throws IOException;

    long readI64_NoCheck() throws IOException;

    long readU64() throws IOException;

    long readU64_NoCheck() throws IOException;

    long readS64() throws IOException;

    long readS64_NoCheck() throws IOException;

    long readF64() throws IOException;

    long readF64_NoCheck() throws IOException;

    long readSF64() throws IOException;

    long readSF64_NoCheck() throws IOException;

    float readFLOAT() throws IOException;

    float readFLOAT_NoCheck() throws IOException;

    double readDOUBLE() throws IOException;

    double readDOUBLE_NoCheck() throws IOException;

    String readSTRING() throws IOException;

    String readSTRING_NoCheck() throws IOException;

    boolean[] readBOOLArray() throws IOException;

    byte[] readI8Array() throws IOException;

    byte[] readU8Array() throws IOException;

    short[] readI16Array() throws IOException;

    short[] readU16Array() throws IOException;

    int[] readI32Array() throws IOException;

    int[] readU32Array() throws IOException;

    int[] readS32Array() throws IOException;

    int[] readF32Array() throws IOException;

    int[] readSF32Array() throws IOException;

    long[] readI64Array() throws IOException;

    long[] readU64Array() throws IOException;

    long[] readS64Array() throws IOException;

    long[] readF64Array() throws IOException;

    long[] readSF64Array() throws IOException;

    float[] readFLOATArray() throws IOException;

    double[] readDOUBLEArray() throws IOException;

    String[] readSTRINGArray() throws IOException;


    BooleanList readBOOLList() throws IOException;

    ByteList readI8List() throws IOException;

    ByteList readU8List() throws IOException;

    ShortList readI16List() throws IOException;

    ShortList readU16List() throws IOException;

    IntList readI32List() throws IOException;

    IntList readU32List() throws IOException;

    IntList readS32List() throws IOException;

    IntList readF32List() throws IOException;

    IntList readSF32List() throws IOException;

    LongList readI64List() throws IOException;

    LongList readU64List() throws IOException;

    LongList readS64List() throws IOException;

    LongList readF64List() throws IOException;

    LongList readSF64List() throws IOException;

    FloatList readFLOATList() throws IOException;

    DoubleList readDOUBLEList() throws IOException;

    List<String> readSTRINGList() throws IOException;

    BooleanSet readBOOLSet() throws IOException;

    ByteSet readI8Set() throws IOException;

    ByteSet readU8Set() throws IOException;

    ShortSet readI16Set() throws IOException;

    ShortSet readU16Set() throws IOException;

    IntSet readI32Set() throws IOException;

    IntSet readU32Set() throws IOException;

    IntSet readS32Set() throws IOException;

    IntSet readF32Set() throws IOException;

    IntSet readSF32Set() throws IOException;

    LongSet readI64Set() throws IOException;

    LongSet readU64Set() throws IOException;

    LongSet readS64Set() throws IOException;

    LongSet readF64Set() throws IOException;

    LongSet readSF64Set() throws IOException;

    FloatSet readFLOATSet() throws IOException;

    DoubleSet readDOUBLESet() throws IOException;

    Set<String> readSTRINGSet() throws IOException;

    Byte2BooleanMap readI8BOOLMap() throws IOException;

    Byte2ByteMap readI8I8Map() throws IOException;

    Byte2ByteMap readI8U8Map() throws IOException;

    Byte2ShortMap readI8I16Map() throws IOException;

    Byte2ShortMap readI8U16Map() throws IOException;

    Byte2IntMap readI8I32Map() throws IOException;

    Byte2IntMap readI8U32Map() throws IOException;

    Byte2IntMap readI8S32Map() throws IOException;

    Byte2IntMap readI8F32Map() throws IOException;

    Byte2IntMap readI8SF32Map() throws IOException;

    Byte2LongMap readI8I64Map() throws IOException;

    Byte2LongMap readI8U64Map() throws IOException;

    Byte2LongMap readI8S64Map() throws IOException;

    Byte2LongMap readI8F64Map() throws IOException;

    Byte2LongMap readI8SF64Map() throws IOException;

    Byte2ObjectMap<String> readI8STRINGMap() throws IOException;

    Byte2DoubleMap readI8DOUBLEMap() throws IOException;

    Byte2FloatMap readI8FLOATMap() throws IOException;

    Byte2BooleanMap readU8BOOLMap() throws IOException;

    Byte2ByteMap readU8I8Map() throws IOException;

    Byte2ByteMap readU8U8Map() throws IOException;

    Byte2ShortMap readU8I16Map() throws IOException;

    Byte2ShortMap readU8U16Map() throws IOException;

    Byte2IntMap readU8I32Map() throws IOException;

    Byte2IntMap readU8U32Map() throws IOException;

    Byte2IntMap readU8S32Map() throws IOException;

    Byte2IntMap readU8F32Map() throws IOException;

    Byte2IntMap readU8SF32Map() throws IOException;

    Byte2LongMap readU8I64Map() throws IOException;

    Byte2LongMap readU8U64Map() throws IOException;

    Byte2LongMap readU8S64Map() throws IOException;

    Byte2LongMap readU8F64Map() throws IOException;

    Byte2LongMap readU8SF64Map() throws IOException;

    Byte2ObjectMap<String> readU8STRINGMap() throws IOException;

    Byte2DoubleMap readU8DOUBLEMap() throws IOException;

    Byte2FloatMap readU8FLOATMap() throws IOException;

    Short2BooleanMap readI16BOOLMap() throws IOException;

    Short2ByteMap readI16I8Map() throws IOException;

    Short2ByteMap readI16U8Map() throws IOException;

    Short2ShortMap readI16I16Map() throws IOException;

    Short2ShortMap readI16U16Map() throws IOException;

    Short2IntMap readI16I32Map() throws IOException;

    Short2IntMap readI16U32Map() throws IOException;

    Short2IntMap readI16S32Map() throws IOException;

    Short2IntMap readI16F32Map() throws IOException;

    Short2IntMap readI16SF32Map() throws IOException;

    Short2LongMap readI16I64Map() throws IOException;

    Short2LongMap readI16U64Map() throws IOException;

    Short2LongMap readI16S64Map() throws IOException;

    Short2LongMap readI16F64Map() throws IOException;

    Short2LongMap readI16SF64Map() throws IOException;

    Short2ObjectMap<String> readI16STRINGMap() throws IOException;

    Short2DoubleMap readI16DOUBLEMap() throws IOException;

    Short2FloatMap readI16FLOATMap() throws IOException;

    Short2BooleanMap readU16BOOLMap() throws IOException;

    Short2ByteMap readU16I8Map() throws IOException;

    Short2ByteMap readU16U8Map() throws IOException;

    Short2ShortMap readU16I16Map() throws IOException;

    Short2ShortMap readU16U16Map() throws IOException;

    Short2IntMap readU16I32Map() throws IOException;

    Short2IntMap readU16U32Map() throws IOException;

    Short2IntMap readU16S32Map() throws IOException;

    Short2IntMap readU16F32Map() throws IOException;

    Short2IntMap readU16SF32Map() throws IOException;

    Short2LongMap readU16I64Map() throws IOException;

    Short2LongMap readU16U64Map() throws IOException;

    Short2LongMap readU16S64Map() throws IOException;

    Short2LongMap readU16F64Map() throws IOException;

    Short2LongMap readU16SF64Map() throws IOException;

    Short2ObjectMap<String> readU16STRINGMap() throws IOException;

    Short2DoubleMap readU16DOUBLEMap() throws IOException;

    Short2FloatMap readU16FLOATMap() throws IOException;

    Int2BooleanMap readI32BOOLMap() throws IOException;

    Int2ByteMap readI32I8Map() throws IOException;

    Int2ByteMap readI32U8Map() throws IOException;

    Int2ShortMap readI32I16Map() throws IOException;

    Int2ShortMap readI32U16Map() throws IOException;

    Int2IntMap readI32I32Map() throws IOException;

    Int2IntMap readI32U32Map() throws IOException;

    Int2IntMap readI32S32Map() throws IOException;

    Int2IntMap readI32F32Map() throws IOException;

    Int2IntMap readI32SF32Map() throws IOException;

    Int2LongMap readI32I64Map() throws IOException;

    Int2LongMap readI32U64Map() throws IOException;

    Int2LongMap readI32S64Map() throws IOException;

    Int2LongMap readI32F64Map() throws IOException;

    Int2LongMap readI32SF64Map() throws IOException;

    Int2ObjectMap<String> readI32STRINGMap() throws IOException;

    Int2DoubleMap readI32DOUBLEMap() throws IOException;

    Int2FloatMap readI32FLOATMap() throws IOException;

    Int2BooleanMap readU32BOOLMap() throws IOException;

    Int2ByteMap readU32I8Map() throws IOException;

    Int2ByteMap readU32U8Map() throws IOException;

    Int2ShortMap readU32I16Map() throws IOException;

    Int2ShortMap readU32U16Map() throws IOException;

    Int2IntMap readU32I32Map() throws IOException;

    Int2IntMap readU32U32Map() throws IOException;

    Int2IntMap readU32S32Map() throws IOException;

    Int2IntMap readU32F32Map() throws IOException;

    Int2IntMap readU32SF32Map() throws IOException;

    Int2LongMap readU32I64Map() throws IOException;

    Int2LongMap readU32U64Map() throws IOException;

    Int2LongMap readU32S64Map() throws IOException;

    Int2LongMap readU32F64Map() throws IOException;

    Int2LongMap readU32SF64Map() throws IOException;

    Int2ObjectMap<String> readU32STRINGMap() throws IOException;

    Int2DoubleMap readU32DOUBLEMap() throws IOException;

    Int2FloatMap readU32FLOATMap() throws IOException;

    Int2BooleanMap readS32BOOLMap() throws IOException;

    Int2ByteMap readS32I8Map() throws IOException;

    Int2ByteMap readS32U8Map() throws IOException;

    Int2ShortMap readS32I16Map() throws IOException;

    Int2ShortMap readS32U16Map() throws IOException;

    Int2IntMap readS32I32Map() throws IOException;

    Int2IntMap readS32U32Map() throws IOException;

    Int2IntMap readS32S32Map() throws IOException;

    Int2IntMap readS32F32Map() throws IOException;

    Int2IntMap readS32SF32Map() throws IOException;

    Int2LongMap readS32I64Map() throws IOException;

    Int2LongMap readS32U64Map() throws IOException;

    Int2LongMap readS32S64Map() throws IOException;

    Int2LongMap readS32F64Map() throws IOException;

    Int2LongMap readS32SF64Map() throws IOException;

    Int2ObjectMap<String> readS32STRINGMap() throws IOException;

    Int2DoubleMap readS32DOUBLEMap() throws IOException;

    Int2FloatMap readS32FLOATMap() throws IOException;

    Int2BooleanMap readF32BOOLMap() throws IOException;

    Int2ByteMap readF32I8Map() throws IOException;

    Int2ByteMap readF32U8Map() throws IOException;

    Int2ShortMap readF32I16Map() throws IOException;

    Int2ShortMap readF32U16Map() throws IOException;

    Int2IntMap readF32I32Map() throws IOException;

    Int2IntMap readF32U32Map() throws IOException;

    Int2IntMap readF32S32Map() throws IOException;

    Int2IntMap readF32F32Map() throws IOException;

    Int2IntMap readF32SF32Map() throws IOException;

    Int2LongMap readF32I64Map() throws IOException;

    Int2LongMap readF32U64Map() throws IOException;

    Int2LongMap readF32S64Map() throws IOException;

    Int2LongMap readF32F64Map() throws IOException;

    Int2LongMap readF32SF64Map() throws IOException;

    Int2ObjectMap<String> readF32STRINGMap() throws IOException;

    Int2DoubleMap readF32DOUBLEMap() throws IOException;

    Int2FloatMap readF32FLOATMap() throws IOException;

    Int2BooleanMap readSF32BOOLMap() throws IOException;

    Int2ByteMap readSF32I8Map() throws IOException;

    Int2ByteMap readSF32U8Map() throws IOException;

    Int2ShortMap readSF32I16Map() throws IOException;

    Int2ShortMap readSF32U16Map() throws IOException;

    Int2IntMap readSF32I32Map() throws IOException;

    Int2IntMap readSF32U32Map() throws IOException;

    Int2IntMap readSF32S32Map() throws IOException;

    Int2IntMap readSF32F32Map() throws IOException;

    Int2IntMap readSF32SF32Map() throws IOException;

    Int2LongMap readSF32I64Map() throws IOException;

    Int2LongMap readSF32U64Map() throws IOException;

    Int2LongMap readSF32S64Map() throws IOException;

    Int2LongMap readSF32F64Map() throws IOException;

    Int2LongMap readSF32SF64Map() throws IOException;

    Int2ObjectMap<String> readSF32STRINGMap() throws IOException;

    Int2DoubleMap readSF32DOUBLEMap() throws IOException;

    Int2FloatMap readSF32FLOATMap() throws IOException;

    Long2BooleanMap readI64BOOLMap() throws IOException;

    Long2ByteMap readI64I8Map() throws IOException;

    Long2ByteMap readI64U8Map() throws IOException;

    Long2ShortMap readI64I16Map() throws IOException;

    Long2ShortMap readI64U16Map() throws IOException;

    Long2IntMap readI64I32Map() throws IOException;

    Long2IntMap readI64U32Map() throws IOException;

    Long2IntMap readI64S32Map() throws IOException;

    Long2IntMap readI64F32Map() throws IOException;

    Long2IntMap readI64SF32Map() throws IOException;

    Long2LongMap readI64I64Map() throws IOException;

    Long2LongMap readI64U64Map() throws IOException;

    Long2LongMap readI64S64Map() throws IOException;

    Long2LongMap readI64F64Map() throws IOException;

    Long2LongMap readI64SF64Map() throws IOException;

    Long2ObjectMap<String> readI64STRINGMap() throws IOException;

    Long2DoubleMap readI64DOUBLEMap() throws IOException;

    Long2FloatMap readI64FLOATMap() throws IOException;

    Long2BooleanMap readU64BOOLMap() throws IOException;

    Long2ByteMap readU64I8Map() throws IOException;

    Long2ByteMap readU64U8Map() throws IOException;

    Long2ShortMap readU64I16Map() throws IOException;

    Long2ShortMap readU64U16Map() throws IOException;

    Long2IntMap readU64I32Map() throws IOException;

    Long2IntMap readU64U32Map() throws IOException;

    Long2IntMap readU64S32Map() throws IOException;

    Long2IntMap readU64F32Map() throws IOException;

    Long2IntMap readU64SF32Map() throws IOException;

    Long2LongMap readU64I64Map() throws IOException;

    Long2LongMap readU64U64Map() throws IOException;

    Long2LongMap readU64S64Map() throws IOException;

    Long2LongMap readU64F64Map() throws IOException;

    Long2LongMap readU64SF64Map() throws IOException;

    Long2ObjectMap<String> readU64STRINGMap() throws IOException;

    Long2DoubleMap readU64DOUBLEMap() throws IOException;

    Long2FloatMap readU64FLOATMap() throws IOException;

    Long2BooleanMap readS64BOOLMap() throws IOException;

    Long2ByteMap readS64I8Map() throws IOException;

    Long2ByteMap readS64U8Map() throws IOException;

    Long2ShortMap readS64I16Map() throws IOException;

    Long2ShortMap readS64U16Map() throws IOException;

    Long2IntMap readS64I32Map() throws IOException;

    Long2IntMap readS64U32Map() throws IOException;

    Long2IntMap readS64S32Map() throws IOException;

    Long2IntMap readS64F32Map() throws IOException;

    Long2IntMap readS64SF32Map() throws IOException;

    Long2LongMap readS64I64Map() throws IOException;

    Long2LongMap readS64U64Map() throws IOException;

    Long2LongMap readS64S64Map() throws IOException;

    Long2LongMap readS64F64Map() throws IOException;

    Long2LongMap readS64SF64Map() throws IOException;

    Long2ObjectMap<String> readS64STRINGMap() throws IOException;

    Long2DoubleMap readS64DOUBLEMap() throws IOException;

    Long2FloatMap readS64FLOATMap() throws IOException;

    Long2BooleanMap readF64BOOLMap() throws IOException;

    Long2ByteMap readF64I8Map() throws IOException;

    Long2ByteMap readF64U8Map() throws IOException;

    Long2ShortMap readF64I16Map() throws IOException;

    Long2ShortMap readF64U16Map() throws IOException;

    Long2IntMap readF64I32Map() throws IOException;

    Long2IntMap readF64U32Map() throws IOException;

    Long2IntMap readF64S32Map() throws IOException;

    Long2IntMap readF64F32Map() throws IOException;

    Long2IntMap readF64SF32Map() throws IOException;

    Long2LongMap readF64I64Map() throws IOException;

    Long2LongMap readF64U64Map() throws IOException;

    Long2LongMap readF64S64Map() throws IOException;

    Long2LongMap readF64F64Map() throws IOException;

    Long2LongMap readF64SF64Map() throws IOException;

    Long2ObjectMap<String> readF64STRINGMap() throws IOException;

    Long2DoubleMap readF64DOUBLEMap() throws IOException;

    Long2FloatMap readF64FLOATMap() throws IOException;

    Long2BooleanMap readSF64BOOLMap() throws IOException;

    Long2ByteMap readSF64I8Map() throws IOException;

    Long2ByteMap readSF64U8Map() throws IOException;

    Long2ShortMap readSF64I16Map() throws IOException;

    Long2ShortMap readSF64U16Map() throws IOException;

    Long2IntMap readSF64I32Map() throws IOException;

    Long2IntMap readSF64U32Map() throws IOException;

    Long2IntMap readSF64S32Map() throws IOException;

    Long2IntMap readSF64F32Map() throws IOException;

    Long2IntMap readSF64SF32Map() throws IOException;

    Long2LongMap readSF64I64Map() throws IOException;

    Long2LongMap readSF64U64Map() throws IOException;

    Long2LongMap readSF64S64Map() throws IOException;

    Long2LongMap readSF64F64Map() throws IOException;

    Long2LongMap readSF64SF64Map() throws IOException;

    Long2ObjectMap<String> readSF64STRINGMap() throws IOException;

    Long2DoubleMap readSF64DOUBLEMap() throws IOException;

    Long2FloatMap readSF64FLOATMap() throws IOException;

    Object2BooleanMap<String> readSTRINGBOOLMap() throws IOException;

    Object2ByteMap<String> readSTRINGI8Map() throws IOException;

    Object2ByteMap<String> readSTRINGU8Map() throws IOException;

    Object2ShortMap<String> readSTRINGI16Map() throws IOException;

    Object2ShortMap<String> readSTRINGU16Map() throws IOException;

    Object2IntMap<String> readSTRINGI32Map() throws IOException;

    Object2IntMap<String> readSTRINGU32Map() throws IOException;

    Object2IntMap<String> readSTRINGS32Map() throws IOException;

    Object2IntMap<String> readSTRINGF32Map() throws IOException;

    Object2IntMap<String> readSTRINGSF32Map() throws IOException;

    Object2LongMap<String> readSTRINGI64Map() throws IOException;

    Object2LongMap<String> readSTRINGU64Map() throws IOException;

    Object2LongMap<String> readSTRINGS64Map() throws IOException;

    Object2LongMap<String> readSTRINGF64Map() throws IOException;

    Object2LongMap<String> readSTRINGSF64Map() throws IOException;

    Map<String, String> readSTRINGSTRINGMap() throws IOException;

    Object2DoubleMap<String> readSTRINGDOUBLEMap() throws IOException;

    Object2FloatMap<String> readSTRINGFLOATMap() throws IOException;

    Double2BooleanMap readDOUBLEBOOLMap() throws IOException;

    Double2ByteMap readDOUBLEI8Map() throws IOException;

    Double2ByteMap readDOUBLEU8Map() throws IOException;

    Double2ShortMap readDOUBLEI16Map() throws IOException;

    Double2ShortMap readDOUBLEU16Map() throws IOException;

    Double2IntMap readDOUBLEI32Map() throws IOException;

    Double2IntMap readDOUBLEU32Map() throws IOException;

    Double2IntMap readDOUBLES32Map() throws IOException;

    Double2IntMap readDOUBLEF32Map() throws IOException;

    Double2IntMap readDOUBLESF32Map() throws IOException;

    Double2LongMap readDOUBLEI64Map() throws IOException;

    Double2LongMap readDOUBLEU64Map() throws IOException;

    Double2LongMap readDOUBLES64Map() throws IOException;

    Double2LongMap readDOUBLEF64Map() throws IOException;

    Double2LongMap readDOUBLESF64Map() throws IOException;

    Double2ObjectMap<String> readDOUBLESTRINGMap() throws IOException;

    Double2DoubleMap readDOUBLEDOUBLEMap() throws IOException;

    Double2FloatMap readDOUBLEFLOATMap() throws IOException;

    Float2BooleanMap readFLOATBOOLMap() throws IOException;

    Float2ByteMap readFLOATI8Map() throws IOException;

    Float2ByteMap readFLOATU8Map() throws IOException;

    Float2ShortMap readFLOATI16Map() throws IOException;

    Float2ShortMap readFLOATU16Map() throws IOException;

    Float2IntMap readFLOATI32Map() throws IOException;

    Float2IntMap readFLOATU32Map() throws IOException;

    Float2IntMap readFLOATS32Map() throws IOException;

    Float2IntMap readFLOATF32Map() throws IOException;

    Float2IntMap readFLOATSF32Map() throws IOException;

    Float2LongMap readFLOATI64Map() throws IOException;

    Float2LongMap readFLOATU64Map() throws IOException;

    Float2LongMap readFLOATS64Map() throws IOException;

    Float2LongMap readFLOATF64Map() throws IOException;

    Float2LongMap readFLOATSF64Map() throws IOException;

    Float2ObjectMap<String> readFLOATSTRINGMap() throws IOException;

    Float2DoubleMap readFLOATDOUBLEMap() throws IOException;

    Float2FloatMap readFLOATFLOATMap() throws IOException;

    void handleUnknownPolymorphicField(int messageIndex);

    int readMessageStart()throws IOException;;

    void readMessageStop(int oldPacketLimit)throws IOException;

    @FunctionalInterface
    interface InputRunnable {
        void run() throws IOException;
    }
}
