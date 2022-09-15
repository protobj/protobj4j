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
 * @date 2022/8/15
 */
public interface Output {

    void writeBOOL(int fieldNumber, boolean value) throws IOException;

    void writeBOOL(boolean value) throws IOException;

    void writeI8(int fieldNumber, byte value) throws IOException;

    void writeI8(byte value) throws IOException;

    void writeU8(int fieldNumber, byte value) throws IOException;

    void writeU8(byte value) throws IOException;

    void writeI16(int fieldNumber, short value) throws IOException;

    void writeI16(short value) throws IOException;

    void writeU16(int fieldNumber, short value) throws IOException;

    void writeU16(short value) throws IOException;

    void writeI32(int fieldNumber, int value) throws IOException;

    void writeI32(int value) throws IOException;

    void writeU32(int fieldNumber, int value) throws IOException;

    void writeU32(int value) throws IOException;

    void writeS32(int fieldNumber, int value) throws IOException;

    void writeS32(int value) throws IOException;

    void writeF32(int fieldNumber, int value) throws IOException;

    void writeF32(int value) throws IOException;

    void writeSF32(int fieldNumber, int value) throws IOException;

    void writeSF32(int value) throws IOException;

    void writeI64(int fieldNumber, long value) throws IOException;

    void writeI64(long value) throws IOException;

    void writeU64(int fieldNumber, long value) throws IOException;

    void writeU64(long value) throws IOException;

    void writeS64(int fieldNumber, long value) throws IOException;

    void writeS64(long value) throws IOException;

    void writeF64(int fieldNumber, long value) throws IOException;

    void writeF64(long value) throws IOException;

    void writeSF64(int fieldNumber, long value) throws IOException;

    void writeSF64(long value) throws IOException;

    void writeFLOAT(int fieldNumber, float value) throws IOException;

    void writeFLOAT(float value) throws IOException;

    void writeDOUBLE(int fieldNumber, double value) throws IOException;

    void writeDOUBLE(double value) throws IOException;

    void writeSTRING(int fieldNumber, String value) throws IOException;

    void writeSTRING(String value) throws IOException;


    void writeI8Array(int fieldNumber, byte[] value) throws IOException;

    void writeU8Array(int fieldNumber, byte[] value) throws IOException;

    void writeBOOLArray(int fieldNumber, boolean[] value) throws IOException;

    void writeI16Array(int fieldNumber, short[] value) throws IOException;

    void writeU16Array(int fieldNumber, short[] value) throws IOException;


    void writeI32Array(int fieldNumber, int[] value) throws IOException;

    void writeU32Array(int fieldNumber, int[] value) throws IOException;

    void writeS32Array(int fieldNumber, int[] value) throws IOException;

    void writeF32Array(int fieldNumber, int[] value) throws IOException;

    void writeSF32Array(int fieldNumber, int[] value) throws IOException;

    void writeI64Array(int fieldNumber, long[] value) throws IOException;

    void writeU64Array(int fieldNumber, long[] value) throws IOException;

    void writeS64Array(int fieldNumber, long[] value) throws IOException;

    void writeF64Array(int fieldNumber, long[] value) throws IOException;

    void writeSF64Array(int fieldNumber, long[] value) throws IOException;

    void writeFLOATArray(int fieldNumber, float[] value) throws IOException;

    void writeDOUBLEArray(int fieldNumber, double[] value) throws IOException;

    void writeSTRINGArray(int fieldNumber, String[] value) throws IOException;

    void writeI8List(int fieldNumber, ByteList value) throws IOException;

    void writeU8List(int fieldNumber, ByteList value) throws IOException;

    void writeBOOLList(int fieldNumber, BooleanList value) throws IOException;

    void writeI16List(int fieldNumber, ShortList value) throws IOException;

    void writeU16List(int fieldNumber, ShortList value) throws IOException;


    void writeI32List(int fieldNumber, IntList value) throws IOException;

    void writeU32List(int fieldNumber, IntList value) throws IOException;

    void writeS32List(int fieldNumber, IntList value) throws IOException;

    void writeF32List(int fieldNumber, IntList value) throws IOException;

    void writeSF32List(int fieldNumber, IntList value) throws IOException;


    void writeI64List(int fieldNumber, LongList value) throws IOException;

    void writeU64List(int fieldNumber, LongList value) throws IOException;

    void writeS64List(int fieldNumber, LongList value) throws IOException;

    void writeF64List(int fieldNumber, LongList value) throws IOException;

    void writeSF64List(int fieldNumber, LongList value) throws IOException;

    void writeFLOATList(int fieldNumber, FloatList value) throws IOException;

    void writeDOUBLEList(int fieldNumber, DoubleList value) throws IOException;

    void writeSTRINGList(int fieldNumber, List<String> value) throws IOException;

    void writeI8Set(int fieldNumber, ByteSet value) throws IOException;

    void writeU8Set(int fieldNumber, ByteSet value) throws IOException;

    void writeBOOLSet(int fieldNumber, BooleanSet value) throws IOException;

    void writeI16Set(int fieldNumber, ShortSet value) throws IOException;

    void writeU16Set(int fieldNumber, ShortSet value) throws IOException;


    void writeI32Set(int fieldNumber, IntSet value) throws IOException;

    void writeU32Set(int fieldNumber, IntSet value) throws IOException;

    void writeS32Set(int fieldNumber, IntSet value) throws IOException;

    void writeF32Set(int fieldNumber, IntSet value) throws IOException;

    void writeSF32Set(int fieldNumber, IntSet value) throws IOException;

    void writeI64Set(int fieldNumber, LongSet value) throws IOException;

    void writeU64Set(int fieldNumber, LongSet value) throws IOException;

    void writeS64Set(int fieldNumber, LongSet value) throws IOException;

    void writeF64Set(int fieldNumber, LongSet value) throws IOException;

    void writeSF64Set(int fieldNumber, LongSet value) throws IOException;

    void writeFLOATSet(int fieldNumber, FloatSet value) throws IOException;

    void writeDOUBLESet(int fieldNumber, DoubleSet value) throws IOException;

    void writeSTRINGSet(int fieldNumber, Set<String> value) throws IOException;

    void writeI8BOOLMap(int fieldNumber, Byte2BooleanMap value) throws IOException;

    void writeI8I8Map(int fieldNumber, Byte2ByteMap value) throws IOException;

    void writeI8U8Map(int fieldNumber, Byte2ByteMap value) throws IOException;

    void writeI8I16Map(int fieldNumber, Byte2ShortMap value) throws IOException;

    void writeI8U16Map(int fieldNumber, Byte2ShortMap value) throws IOException;

    void writeI8I32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeI8U32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeI8S32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeI8F32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeI8SF32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeI8I64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeI8U64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeI8S64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeI8F64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeI8SF64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeI8STRINGMap(int fieldNumber, Byte2ObjectMap<String> value) throws IOException;

    void writeI8DOUBLEMap(int fieldNumber, Byte2DoubleMap value) throws IOException;

    void writeI8FLOATMap(int fieldNumber, Byte2FloatMap value) throws IOException;

    void writeU8BOOLMap(int fieldNumber, Byte2BooleanMap value) throws IOException;

    void writeU8I8Map(int fieldNumber, Byte2ByteMap value) throws IOException;

    void writeU8U8Map(int fieldNumber, Byte2ByteMap value) throws IOException;

    void writeU8I16Map(int fieldNumber, Byte2ShortMap value) throws IOException;

    void writeU8U16Map(int fieldNumber, Byte2ShortMap value) throws IOException;

    void writeU8I32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeU8U32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeU8S32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeU8F32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeU8SF32Map(int fieldNumber, Byte2IntMap value) throws IOException;

    void writeU8I64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeU8U64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeU8S64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeU8F64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeU8SF64Map(int fieldNumber, Byte2LongMap value) throws IOException;

    void writeU8STRINGMap(int fieldNumber, Byte2ObjectMap<String> value) throws IOException;

    void writeU8DOUBLEMap(int fieldNumber, Byte2DoubleMap value) throws IOException;

    void writeU8FLOATMap(int fieldNumber, Byte2FloatMap value) throws IOException;

    void writeI16BOOLMap(int fieldNumber, Short2BooleanMap value) throws IOException;

    void writeI16I8Map(int fieldNumber, Short2ByteMap value) throws IOException;

    void writeI16U8Map(int fieldNumber, Short2ByteMap value) throws IOException;

    void writeI16I16Map(int fieldNumber, Short2ShortMap value) throws IOException;

    void writeI16U16Map(int fieldNumber, Short2ShortMap value) throws IOException;

    void writeI16I32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeI16U32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeI16S32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeI16F32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeI16SF32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeI16I64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeI16U64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeI16S64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeI16F64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeI16SF64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeI16STRINGMap(int fieldNumber, Short2ObjectMap<String> value) throws IOException;

    void writeI16DOUBLEMap(int fieldNumber, Short2DoubleMap value) throws IOException;

    void writeI16FLOATMap(int fieldNumber, Short2FloatMap value) throws IOException;

    void writeU16BOOLMap(int fieldNumber, Short2BooleanMap value) throws IOException;

    void writeU16I8Map(int fieldNumber, Short2ByteMap value) throws IOException;

    void writeU16U8Map(int fieldNumber, Short2ByteMap value) throws IOException;

    void writeU16I16Map(int fieldNumber, Short2ShortMap value) throws IOException;

    void writeU16U16Map(int fieldNumber, Short2ShortMap value) throws IOException;

    void writeU16I32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeU16U32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeU16S32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeU16F32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeU16SF32Map(int fieldNumber, Short2IntMap value) throws IOException;

    void writeU16I64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeU16U64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeU16S64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeU16F64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeU16SF64Map(int fieldNumber, Short2LongMap value) throws IOException;

    void writeU16STRINGMap(int fieldNumber, Short2ObjectMap<String> value) throws IOException;

    void writeU16DOUBLEMap(int fieldNumber, Short2DoubleMap value) throws IOException;

    void writeU16FLOATMap(int fieldNumber, Short2FloatMap value) throws IOException;

    void writeI32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException;

    void writeI32I8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeI32U8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeI32I16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeI32U16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeI32I32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeI32U32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeI32S32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeI32F32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeI32SF32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeI32I64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeI32U64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeI32S64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeI32F64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeI32SF64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeI32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException;

    void writeI32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException;

    void writeI32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException;

    void writeU32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException;

    void writeU32I8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeU32U8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeU32I16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeU32U16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeU32I32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeU32U32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeU32S32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeU32F32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeU32SF32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeU32I64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeU32U64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeU32S64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeU32F64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeU32SF64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeU32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException;

    void writeU32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException;

    void writeU32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException;

    void writeS32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException;

    void writeS32I8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeS32U8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeS32I16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeS32U16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeS32I32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeS32U32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeS32S32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeS32F32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeS32SF32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeS32I64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeS32U64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeS32S64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeS32F64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeS32SF64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeS32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException;

    void writeS32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException;

    void writeS32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException;

    void writeF32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException;

    void writeF32I8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeF32U8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeF32I16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeF32U16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeF32I32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeF32U32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeF32S32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeF32F32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeF32SF32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeF32I64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeF32U64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeF32S64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeF32F64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeF32SF64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeF32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException;

    void writeF32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException;

    void writeF32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException;

    void writeSF32BOOLMap(int fieldNumber, Int2BooleanMap value) throws IOException;

    void writeSF32I8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeSF32U8Map(int fieldNumber, Int2ByteMap value) throws IOException;

    void writeSF32I16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeSF32U16Map(int fieldNumber, Int2ShortMap value) throws IOException;

    void writeSF32I32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeSF32U32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeSF32S32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeSF32F32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeSF32SF32Map(int fieldNumber, Int2IntMap value) throws IOException;

    void writeSF32I64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeSF32U64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeSF32S64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeSF32F64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeSF32SF64Map(int fieldNumber, Int2LongMap value) throws IOException;

    void writeSF32STRINGMap(int fieldNumber, Int2ObjectMap<String> value) throws IOException;

    void writeSF32DOUBLEMap(int fieldNumber, Int2DoubleMap value) throws IOException;

    void writeSF32FLOATMap(int fieldNumber, Int2FloatMap value) throws IOException;

    void writeI64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException;

    void writeI64I8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeI64U8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeI64I16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeI64U16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeI64I32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeI64U32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeI64S32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeI64F32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeI64SF32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeI64I64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeI64U64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeI64S64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeI64F64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeI64SF64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeI64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException;

    void writeI64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException;

    void writeI64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException;

    void writeU64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException;

    void writeU64I8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeU64U8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeU64I16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeU64U16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeU64I32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeU64U32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeU64S32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeU64F32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeU64SF32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeU64I64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeU64U64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeU64S64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeU64F64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeU64SF64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeU64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException;

    void writeU64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException;

    void writeU64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException;

    void writeS64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException;

    void writeS64I8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeS64U8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeS64I16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeS64U16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeS64I32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeS64U32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeS64S32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeS64F32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeS64SF32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeS64I64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeS64U64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeS64S64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeS64F64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeS64SF64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeS64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException;

    void writeS64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException;

    void writeS64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException;

    void writeF64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException;

    void writeF64I8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeF64U8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeF64I16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeF64U16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeF64I32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeF64U32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeF64S32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeF64F32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeF64SF32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeF64I64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeF64U64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeF64S64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeF64F64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeF64SF64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeF64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException;

    void writeF64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException;

    void writeF64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException;

    void writeSF64BOOLMap(int fieldNumber, Long2BooleanMap value) throws IOException;

    void writeSF64I8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeSF64U8Map(int fieldNumber, Long2ByteMap value) throws IOException;

    void writeSF64I16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeSF64U16Map(int fieldNumber, Long2ShortMap value) throws IOException;

    void writeSF64I32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeSF64U32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeSF64S32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeSF64F32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeSF64SF32Map(int fieldNumber, Long2IntMap value) throws IOException;

    void writeSF64I64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeSF64U64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeSF64S64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeSF64F64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeSF64SF64Map(int fieldNumber, Long2LongMap value) throws IOException;

    void writeSF64STRINGMap(int fieldNumber, Long2ObjectMap<String> value) throws IOException;

    void writeSF64DOUBLEMap(int fieldNumber, Long2DoubleMap value) throws IOException;

    void writeSF64FLOATMap(int fieldNumber, Long2FloatMap value) throws IOException;

    void writeSTRINGBOOLMap(int fieldNumber, Object2BooleanMap<String> value) throws IOException;

    void writeSTRINGI8Map(int fieldNumber, Object2ByteMap<String> value) throws IOException;

    void writeSTRINGU8Map(int fieldNumber, Object2ByteMap<String> value) throws IOException;

    void writeSTRINGI16Map(int fieldNumber, Object2ShortMap<String> value) throws IOException;

    void writeSTRINGU16Map(int fieldNumber, Object2ShortMap<String> value) throws IOException;

    void writeSTRINGI32Map(int fieldNumber, Object2IntMap<String> value) throws IOException;

    void writeSTRINGU32Map(int fieldNumber, Object2IntMap<String> value) throws IOException;

    void writeSTRINGS32Map(int fieldNumber, Object2IntMap<String> value) throws IOException;

    void writeSTRINGF32Map(int fieldNumber, Object2IntMap<String> value) throws IOException;

    void writeSTRINGSF32Map(int fieldNumber, Object2IntMap<String> value) throws IOException;

    void writeSTRINGI64Map(int fieldNumber, Object2LongMap<String> value) throws IOException;

    void writeSTRINGU64Map(int fieldNumber, Object2LongMap<String> value) throws IOException;

    void writeSTRINGS64Map(int fieldNumber, Object2LongMap<String> value) throws IOException;

    void writeSTRINGF64Map(int fieldNumber, Object2LongMap<String> value) throws IOException;

    void writeSTRINGSF64Map(int fieldNumber, Object2LongMap<String> value) throws IOException;

    void writeSTRINGSTRINGMap(int fieldNumber, Map<String, String> value) throws IOException;

    void writeSTRINGDOUBLEMap(int fieldNumber, Object2DoubleMap<String> value) throws IOException;

    void writeSTRINGFLOATMap(int fieldNumber, Object2FloatMap<String> value) throws IOException;

    void writeDOUBLEBOOLMap(int fieldNumber, Double2BooleanMap value) throws IOException;

    void writeDOUBLEI8Map(int fieldNumber, Double2ByteMap value) throws IOException;

    void writeDOUBLEU8Map(int fieldNumber, Double2ByteMap value) throws IOException;

    void writeDOUBLEI16Map(int fieldNumber, Double2ShortMap value) throws IOException;

    void writeDOUBLEU16Map(int fieldNumber, Double2ShortMap value) throws IOException;

    void writeDOUBLEI32Map(int fieldNumber, Double2IntMap value) throws IOException;

    void writeDOUBLEU32Map(int fieldNumber, Double2IntMap value) throws IOException;

    void writeDOUBLES32Map(int fieldNumber, Double2IntMap value) throws IOException;

    void writeDOUBLEF32Map(int fieldNumber, Double2IntMap value) throws IOException;

    void writeDOUBLESF32Map(int fieldNumber, Double2IntMap value) throws IOException;

    void writeDOUBLEI64Map(int fieldNumber, Double2LongMap value) throws IOException;

    void writeDOUBLEU64Map(int fieldNumber, Double2LongMap value) throws IOException;

    void writeDOUBLES64Map(int fieldNumber, Double2LongMap value) throws IOException;

    void writeDOUBLEF64Map(int fieldNumber, Double2LongMap value) throws IOException;

    void writeDOUBLESF64Map(int fieldNumber, Double2LongMap value) throws IOException;

    void writeDOUBLESTRINGMap(int fieldNumber, Double2ObjectMap<String> value) throws IOException;

    void writeDOUBLEDOUBLEMap(int fieldNumber, Double2DoubleMap value) throws IOException;

    void writeDOUBLEFLOATMap(int fieldNumber, Double2FloatMap value) throws IOException;

    void writeFLOATBOOLMap(int fieldNumber, Float2BooleanMap value) throws IOException;

    void writeFLOATI8Map(int fieldNumber, Float2ByteMap value) throws IOException;

    void writeFLOATU8Map(int fieldNumber, Float2ByteMap value) throws IOException;

    void writeFLOATI16Map(int fieldNumber, Float2ShortMap value) throws IOException;

    void writeFLOATU16Map(int fieldNumber, Float2ShortMap value) throws IOException;

    void writeFLOATI32Map(int fieldNumber, Float2IntMap value) throws IOException;

    void writeFLOATU32Map(int fieldNumber, Float2IntMap value) throws IOException;

    void writeFLOATS32Map(int fieldNumber, Float2IntMap value) throws IOException;

    void writeFLOATF32Map(int fieldNumber, Float2IntMap value) throws IOException;

    void writeFLOATSF32Map(int fieldNumber, Float2IntMap value) throws IOException;

    void writeFLOATI64Map(int fieldNumber, Float2LongMap value) throws IOException;

    void writeFLOATU64Map(int fieldNumber, Float2LongMap value) throws IOException;

    void writeFLOATS64Map(int fieldNumber, Float2LongMap value) throws IOException;

    void writeFLOATF64Map(int fieldNumber, Float2LongMap value) throws IOException;

    void writeFLOATSF64Map(int fieldNumber, Float2LongMap value) throws IOException;

    void writeFLOATSTRINGMap(int fieldNumber, Float2ObjectMap<String> value) throws IOException;

    void writeFLOATDOUBLEMap(int fieldNumber, Float2DoubleMap value) throws IOException;

    void writeFLOATFLOATMap(int fieldNumber, Float2FloatMap value) throws IOException;

    void writeMessage(int fieldNumber, OutputRunnable runnable) throws IOException;

    @FunctionalInterface
    interface OutputRunnable {
        void run() throws IOException;
    }
}

