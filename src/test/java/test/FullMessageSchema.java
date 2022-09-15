package test;

import io.protobj.core.Input;
import io.protobj.core.Output;
import io.protobj.core.Schema;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.doubles.Double2ObjectMap;
import it.unimi.dsi.fastutil.doubles.Double2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import it.unimi.dsi.fastutil.floats.Float2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FullMessageSchema implements Schema {

    @Override
    public void writeTo(Output output, Object message, boolean polymorphic) throws IOException {
        writeTo(output, (FullMessage) message, polymorphic);
    }

    public static void writeTo(Output output, FullMessage message, boolean polymorphic) throws IOException {
        if (polymorphic) {
            output.writeI32(2);
        }
        // bool p1 = 1 ; 
        if (message.isP1() != false) {
            output.writeBOOL(1, message.isP1());
        }
        // i8 p2 = 2 ; 
        if (message.getP2() != 0) {
            output.writeI8(2, message.getP2());
        }
        // u8 p3 = 3 ; 
        if (message.getP3() != 0) {
            output.writeU8(3, message.getP3());
        }
        // i16 p4 = 4 ; 
        if (message.getP4() != 0) {
            output.writeI16(4, message.getP4());
        }
        // u16 p5 = 5 ; 
        if (message.getP5() != 0) {
            output.writeU16(5, message.getP5());
        }
        // i32 p6 = 6 ; 
        if (message.getP6() != 0) {
            output.writeI32(6, message.getP6());
        }
        // u32 p7 = 7 ; 
        if (message.getP7() != 0) {
            output.writeU32(7, message.getP7());
        }
        // s32 p8 = 8 ; 
        if (message.getP8() != 0) {
            output.writeS32(8, message.getP8());
        }
        // f32 p9 = 9 ; 
        if (message.getP9() != 0) {
            output.writeF32(9, message.getP9());
        }
        // sf32 p10 = 10 ; 
        if (message.getP10() != 0) {
            output.writeSF32(10, message.getP10());
        }
        // i64 p11 = 11 ; 
        if (message.getP11() != 0) {
            output.writeI64(11, message.getP11());
        }
        // u64 p12 = 12 ; 
        if (message.getP12() != 0) {
            output.writeU64(12, message.getP12());
        }
        // s64 p13 = 13 ; 
        if (message.getP13() != 0) {
            output.writeS64(13, message.getP13());
        }
        // f64 p14 = 14 ; 
        if (message.getP14() != 0) {
            output.writeF64(14, message.getP14());
        }
        // sf64 p15 = 15 ; 
        if (message.getP15() != 0) {
            output.writeSF64(15, message.getP15());
        }
        // string p16 = 16 ; 
        if (message.getP16() != null) {
            output.writeSTRING(16, message.getP16());
        }
        // double p17 = 17 ; 
        if (message.getP17() != 0) {
            output.writeDOUBLE(17, message.getP17());
        }
        // float p18 = 18 ; 
        if (message.getP18() != 0) {
            output.writeFLOAT(18, message.getP18());
        }
        // FullEnum0 p19 = 19 ; 
        if (message.getP19() != null) {
            FullEnum0Schema.writeWithFieldNumber(19, output, message.getP19());
        }
        // FullMessage0 p20 = 20 ; 
        if (message.getP20() != null) {
            output.writeMessage(20, () -> FullMessage0Schema.writeTo(output, message.getP20(), false));
        }
        //arr bool p21 = 21 ; 
        if (message.getP21() != null && message.getP21().length > 0) {
            output.writeBOOLArray(21, message.getP21());
        }
        //arr i8 p22 = 22 ; 
        if (message.getP22() != null && message.getP22().length > 0) {
            output.writeI8Array(22, message.getP22());
        }
        //arr u8 p23 = 23 ; 
        if (message.getP23() != null && message.getP23().length > 0) {
            output.writeU8Array(23, message.getP23());
        }
        //arr i16 p24 = 24 ; 
        if (message.getP24() != null && message.getP24().length > 0) {
            output.writeI16Array(24, message.getP24());
        }
        //arr u16 p25 = 25 ; 
        if (message.getP25() != null && message.getP25().length > 0) {
            output.writeU16Array(25, message.getP25());
        }
        //arr i32 p26 = 26 ; 
        if (message.getP26() != null && message.getP26().length > 0) {
            output.writeI32Array(26, message.getP26());
        }
        //arr u32 p27 = 27 ; 
        if (message.getP27() != null && message.getP27().length > 0) {
            output.writeU32Array(27, message.getP27());
        }
        //arr s32 p28 = 28 ; 
        if (message.getP28() != null && message.getP28().length > 0) {
            output.writeS32Array(28, message.getP28());
        }
        //arr f32 p29 = 29 ; 
        if (message.getP29() != null && message.getP29().length > 0) {
            output.writeF32Array(29, message.getP29());
        }
        //arr sf32 p30 = 30 ; 
        if (message.getP30() != null && message.getP30().length > 0) {
            output.writeSF32Array(30, message.getP30());
        }
        //arr i64 p31 = 31 ; 
        if (message.getP31() != null && message.getP31().length > 0) {
            output.writeI64Array(31, message.getP31());
        }
        //arr u64 p32 = 32 ; 
        if (message.getP32() != null && message.getP32().length > 0) {
            output.writeU64Array(32, message.getP32());
        }
        //arr s64 p33 = 33 ; 
        if (message.getP33() != null && message.getP33().length > 0) {
            output.writeS64Array(33, message.getP33());
        }
        //arr f64 p34 = 34 ; 
        if (message.getP34() != null && message.getP34().length > 0) {
            output.writeF64Array(34, message.getP34());
        }
        //arr sf64 p35 = 35 ; 
        if (message.getP35() != null && message.getP35().length > 0) {
            output.writeSF64Array(35, message.getP35());
        }
        //arr string p36 = 36 ; 
        if (message.getP36() != null && message.getP36().length > 0) {
            output.writeSTRINGArray(36, message.getP36());
        }
        //arr double p37 = 37 ; 
        if (message.getP37() != null && message.getP37().length > 0) {
            output.writeDOUBLEArray(37, message.getP37());
        }
        //arr float p38 = 38 ; 
        if (message.getP38() != null && message.getP38().length > 0) {
            output.writeFLOATArray(38, message.getP38());
        }
        //arr FullEnum0 p39 = 39 ; 
        if (message.getP39() != null && message.getP39().length > 0) {
            FullEnum0[] p39 = message.getP39();
            output.writeMessage(39, () -> {
                for (int i = message.getP39().length-1; i >= 0; i--) {
                    if (p39[i] == null) {
                        continue;
                    }
                    output.writeI32(i);
                    FullEnum0Schema.writeTo(output, p39[i], false);
                }
            });
        }
        //arr FullMessage0 p40 = 40 ; 
        if (message.getP40() != null && message.getP40().length > 0) {
            FullMessage0[] p40 = message.getP40();
            for (int i = message.getP40().length-1; i >= 0; i--) {
                int index = i;
                if (p40[index] == null) {
                    continue;
                }
                output.writeMessage(40, () -> {
                    output.writeI32(index);
                    FullMessage0Schema.writeTo(output, p40[index], false);
                });
            }
        }
        //set bool p41 = 41 ; 
        if (message.getP41() != null && message.getP41().size() > 0) {
            output.writeBOOLSet(41, message.getP41());
        }
        //set i8 p42 = 42 ; 
        if (message.getP42() != null && message.getP42().size() > 0) {
            output.writeI8Set(42, message.getP42());
        }
        //set u8 p43 = 43 ; 
        if (message.getP43() != null && message.getP43().size() > 0) {
            output.writeU8Set(43, message.getP43());
        }
        //set i16 p44 = 44 ; 
        if (message.getP44() != null && message.getP44().size() > 0) {
            output.writeI16Set(44, message.getP44());
        }
        //set u16 p45 = 45 ; 
        if (message.getP45() != null && message.getP45().size() > 0) {
            output.writeU16Set(45, message.getP45());
        }
        //set i32 p46 = 46 ; 
        if (message.getP46() != null && message.getP46().size() > 0) {
            output.writeI32Set(46, message.getP46());
        }
        //set u32 p47 = 47 ; 
        if (message.getP47() != null && message.getP47().size() > 0) {
            output.writeU32Set(47, message.getP47());
        }
        //set s32 p48 = 48 ; 
        if (message.getP48() != null && message.getP48().size() > 0) {
            output.writeS32Set(48, message.getP48());
        }
        //set f32 p49 = 49 ; 
        if (message.getP49() != null && message.getP49().size() > 0) {
            output.writeF32Set(49, message.getP49());
        }
        //set sf32 p50 = 50 ; 
        if (message.getP50() != null && message.getP50().size() > 0) {
            output.writeSF32Set(50, message.getP50());
        }
        //set i64 p51 = 51 ; 
        if (message.getP51() != null && message.getP51().size() > 0) {
            output.writeI64Set(51, message.getP51());
        }
        //set u64 p52 = 52 ; 
        if (message.getP52() != null && message.getP52().size() > 0) {
            output.writeU64Set(52, message.getP52());
        }
        //set s64 p53 = 53 ; 
        if (message.getP53() != null && message.getP53().size() > 0) {
            output.writeS64Set(53, message.getP53());
        }
        //set f64 p54 = 54 ; 
        if (message.getP54() != null && message.getP54().size() > 0) {
            output.writeF64Set(54, message.getP54());
        }
        //set sf64 p55 = 55 ; 
        if (message.getP55() != null && message.getP55().size() > 0) {
            output.writeSF64Set(55, message.getP55());
        }
        //set string p56 = 56 ; 
        if (message.getP56() != null && message.getP56().size() > 0) {
            output.writeSTRINGSet(56, message.getP56());
        }
        //set double p57 = 57 ; 
        if (message.getP57() != null && message.getP57().size() > 0) {
            output.writeDOUBLESet(57, message.getP57());
        }
        //set float p58 = 58 ; 
        if (message.getP58() != null && message.getP58().size() > 0) {
            output.writeFLOATSet(58, message.getP58());
        }
        //set FullEnum0 p59 = 59 ; 
        if (message.getP59() != null && message.getP59().size() > 0) {
            for(FullEnum0 p59Unit : message.getP59()){
                if (p59Unit != null) {
                    FullEnum0Schema.writeWithFieldNumber(59, output, p59Unit);
                }
            }
        }
        //set FullMessage0 p60 = 60 ; 
        if (message.getP60() != null && message.getP60().size() > 0) {
            for(FullMessage0 p60Unit : message.getP60()){
                if (p60Unit != null) {
                    output.writeMessage(60, () -> FullMessage0Schema.writeTo(output, p60Unit, false));
                }
            }
        }
        //lst bool p61 = 61 ; 
        if (message.getP61() != null && message.getP61().size() > 0) {
            output.writeBOOLList(61, message.getP61());
        }
        //lst i8 p62 = 62 ; 
        if (message.getP62() != null && message.getP62().size() > 0) {
            output.writeI8List(62, message.getP62());
        }
        //lst u8 p63 = 63 ; 
        if (message.getP63() != null && message.getP63().size() > 0) {
            output.writeU8List(63, message.getP63());
        }
        //lst i16 p64 = 64 ; 
        if (message.getP64() != null && message.getP64().size() > 0) {
            output.writeI16List(64, message.getP64());
        }
        //lst u16 p65 = 65 ; 
        if (message.getP65() != null && message.getP65().size() > 0) {
            output.writeU16List(65, message.getP65());
        }
        //lst i32 p66 = 66 ; 
        if (message.getP66() != null && message.getP66().size() > 0) {
            output.writeI32List(66, message.getP66());
        }
        //lst u32 p67 = 67 ; 
        if (message.getP67() != null && message.getP67().size() > 0) {
            output.writeU32List(67, message.getP67());
        }
        //lst s32 p68 = 68 ; 
        if (message.getP68() != null && message.getP68().size() > 0) {
            output.writeS32List(68, message.getP68());
        }
        //lst f32 p69 = 69 ; 
        if (message.getP69() != null && message.getP69().size() > 0) {
            output.writeF32List(69, message.getP69());
        }
        //lst sf32 p70 = 70 ; 
        if (message.getP70() != null && message.getP70().size() > 0) {
            output.writeSF32List(70, message.getP70());
        }
        //lst i64 p71 = 71 ; 
        if (message.getP71() != null && message.getP71().size() > 0) {
            output.writeI64List(71, message.getP71());
        }
        //lst u64 p72 = 72 ; 
        if (message.getP72() != null && message.getP72().size() > 0) {
            output.writeU64List(72, message.getP72());
        }
        //lst s64 p73 = 73 ; 
        if (message.getP73() != null && message.getP73().size() > 0) {
            output.writeS64List(73, message.getP73());
        }
        //lst f64 p74 = 74 ; 
        if (message.getP74() != null && message.getP74().size() > 0) {
            output.writeF64List(74, message.getP74());
        }
        //lst sf64 p75 = 75 ; 
        if (message.getP75() != null && message.getP75().size() > 0) {
            output.writeSF64List(75, message.getP75());
        }
        //lst string p76 = 76 ; 
        if (message.getP76() != null && message.getP76().size() > 0) {
            output.writeSTRINGList(76, message.getP76());
        }
        //lst double p77 = 77 ; 
        if (message.getP77() != null && message.getP77().size() > 0) {
            output.writeDOUBLEList(77, message.getP77());
        }
        //lst float p78 = 78 ; 
        if (message.getP78() != null && message.getP78().size() > 0) {
            output.writeFLOATList(78, message.getP78());
        }
        //lst FullEnum0 p79 = 79 ; 
        if (message.getP79() != null && message.getP79().size() > 0) {
            for(FullEnum0 p79Unit : message.getP79()){
                if (p79Unit != null) {
                    FullEnum0Schema.writeWithFieldNumber(79, output, p79Unit);
                }
            }
        }
        //lst FullMessage0 p80 = 80 ; 
        if (message.getP80() != null && message.getP80().size() > 0) {
            for(FullMessage0 p80Unit : message.getP80()){
                if (p80Unit != null) {
                    output.writeMessage(80, () -> FullMessage0Schema.writeTo(output, p80Unit, false));
                }
            }
        }
        //ext FullMessage0 p81 = 81 ; 
        output.writeMessage(81, () -> FullMessage0Schema.writeTo(output, message,false));
        //set FullMessage0 p82 = 82 [ polymorphic=true ] ; 
        if (message.getP82() != null && message.getP82().size() > 0) {
            for(FullMessage0 p82Unit : message.getP82()){
                if (p82Unit != null) {
                    if (p82Unit.getClass() == FullMessage0.class) {
                        output.writeMessage(82, () -> FullMessage0Schema.writeTo(output, p82Unit, true));
                    } else if (p82Unit.getClass() == FullMessage.class) {
                        output.writeMessage(82, () -> FullMessageSchema.writeTo(output, (FullMessage)p82Unit, true));
                    } else if (p82Unit.getClass() == FullMessage1.class) {
                        output.writeMessage(82, () -> FullMessage1Schema.writeTo(output, (FullMessage1)p82Unit, true));
                    } else { 
                    throw new RuntimeException("undefine message"+ p82Unit.getClass().getName());}
                }
            }
        }
        //arr FullMessage0 p83 = 83 [ polymorphic=true ] ; 
        if (message.getP83() != null && message.getP83().length > 0) {
            FullMessage0[] p83 = message.getP83();
            for (int i = message.getP83().length-1; i >= 0; i--) {
                int index = i;
                if (p83[index] == null) {
                    continue;
                }
                output.writeMessage(83, () -> {
                    output.writeI32(index);
                    if (p83[index].getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, p83[index],true);
                    } else if (p83[index].getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)p83[index], true);
                    } else if (p83[index].getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)p83[index], true);
                    } else { 
                    throw new RuntimeException("undefine message"+ p83[index].getClass().getName());}
                });
            }
        }
        //lst FullMessage0 p84 = 84 [ polymorphic=true ] ; 
        if (message.getP84() != null && message.getP84().size() > 0) {
            for(FullMessage0 p84Unit : message.getP84()){
                if (p84Unit != null) {
                    if (p84Unit.getClass() == FullMessage0.class) {
                        output.writeMessage(84, () -> FullMessage0Schema.writeTo(output, p84Unit, true));
                    } else if (p84Unit.getClass() == FullMessage.class) {
                        output.writeMessage(84, () -> FullMessageSchema.writeTo(output, (FullMessage)p84Unit, true));
                    } else if (p84Unit.getClass() == FullMessage1.class) {
                        output.writeMessage(84, () -> FullMessage1Schema.writeTo(output, (FullMessage1)p84Unit, true));
                    } else { 
                    throw new RuntimeException("undefine message"+ p84Unit.getClass().getName());}
                }
            }
        }
        //dft map<i8,i8> p85 = 85 ; 
        if (message.getP85() != null && message.getP85().size() > 0) {
            output.writeI8I8Map(85, message.getP85());
        }
        //dft map<i8,u8> p86 = 86 ; 
        if (message.getP86() != null && message.getP86().size() > 0) {
            output.writeI8U8Map(86, message.getP86());
        }
        //dft map<i8,i16> p87 = 87 ; 
        if (message.getP87() != null && message.getP87().size() > 0) {
            output.writeI8I16Map(87, message.getP87());
        }
        //dft map<i8,u16> p88 = 88 ; 
        if (message.getP88() != null && message.getP88().size() > 0) {
            output.writeI8U16Map(88, message.getP88());
        }
        //dft map<i8,i32> p89 = 89 ; 
        if (message.getP89() != null && message.getP89().size() > 0) {
            output.writeI8I32Map(89, message.getP89());
        }
        //dft map<i8,u32> p90 = 90 ; 
        if (message.getP90() != null && message.getP90().size() > 0) {
            output.writeI8U32Map(90, message.getP90());
        }
        //dft map<i8,s32> p91 = 91 ; 
        if (message.getP91() != null && message.getP91().size() > 0) {
            output.writeI8S32Map(91, message.getP91());
        }
        //dft map<i8,f32> p92 = 92 ; 
        if (message.getP92() != null && message.getP92().size() > 0) {
            output.writeI8F32Map(92, message.getP92());
        }
        //dft map<i8,sf32> p93 = 93 ; 
        if (message.getP93() != null && message.getP93().size() > 0) {
            output.writeI8SF32Map(93, message.getP93());
        }
        //dft map<i8,i64> p94 = 94 ; 
        if (message.getP94() != null && message.getP94().size() > 0) {
            output.writeI8I64Map(94, message.getP94());
        }
        //dft map<i8,u64> p95 = 95 ; 
        if (message.getP95() != null && message.getP95().size() > 0) {
            output.writeI8U64Map(95, message.getP95());
        }
        //dft map<i8,s64> p96 = 96 ; 
        if (message.getP96() != null && message.getP96().size() > 0) {
            output.writeI8S64Map(96, message.getP96());
        }
        //dft map<i8,f64> p97 = 97 ; 
        if (message.getP97() != null && message.getP97().size() > 0) {
            output.writeI8F64Map(97, message.getP97());
        }
        //dft map<i8,sf64> p98 = 98 ; 
        if (message.getP98() != null && message.getP98().size() > 0) {
            output.writeI8SF64Map(98, message.getP98());
        }
        //dft map<i8,string> p99 = 99 ; 
        if (message.getP99() != null && message.getP99().size() > 0) {
            output.writeI8STRINGMap(99, message.getP99());
        }
        //dft map<i8,double> p100 = 100 ; 
        if (message.getP100() != null && message.getP100().size() > 0) {
            output.writeI8DOUBLEMap(100, message.getP100());
        }
        //dft map<i8,float> p101 = 101 ; 
        if (message.getP101() != null && message.getP101().size() > 0) {
            output.writeI8FLOATMap(101, message.getP101());
        }
        //dft map<u8,i8> p102 = 102 ; 
        if (message.getP102() != null && message.getP102().size() > 0) {
            output.writeU8I8Map(102, message.getP102());
        }
        //dft map<u8,u8> p103 = 103 ; 
        if (message.getP103() != null && message.getP103().size() > 0) {
            output.writeU8U8Map(103, message.getP103());
        }
        //dft map<u8,i16> p104 = 104 ; 
        if (message.getP104() != null && message.getP104().size() > 0) {
            output.writeU8I16Map(104, message.getP104());
        }
        //dft map<u8,u16> p105 = 105 ; 
        if (message.getP105() != null && message.getP105().size() > 0) {
            output.writeU8U16Map(105, message.getP105());
        }
        //dft map<u8,i32> p106 = 106 ; 
        if (message.getP106() != null && message.getP106().size() > 0) {
            output.writeU8I32Map(106, message.getP106());
        }
        //dft map<u8,u32> p107 = 107 ; 
        if (message.getP107() != null && message.getP107().size() > 0) {
            output.writeU8U32Map(107, message.getP107());
        }
        //dft map<u8,s32> p108 = 108 ; 
        if (message.getP108() != null && message.getP108().size() > 0) {
            output.writeU8S32Map(108, message.getP108());
        }
        //dft map<u8,f32> p109 = 109 ; 
        if (message.getP109() != null && message.getP109().size() > 0) {
            output.writeU8F32Map(109, message.getP109());
        }
        //dft map<u8,sf32> p110 = 110 ; 
        if (message.getP110() != null && message.getP110().size() > 0) {
            output.writeU8SF32Map(110, message.getP110());
        }
        //dft map<u8,i64> p111 = 111 ; 
        if (message.getP111() != null && message.getP111().size() > 0) {
            output.writeU8I64Map(111, message.getP111());
        }
        //dft map<u8,u64> p112 = 112 ; 
        if (message.getP112() != null && message.getP112().size() > 0) {
            output.writeU8U64Map(112, message.getP112());
        }
        //dft map<u8,s64> p113 = 113 ; 
        if (message.getP113() != null && message.getP113().size() > 0) {
            output.writeU8S64Map(113, message.getP113());
        }
        //dft map<u8,f64> p114 = 114 ; 
        if (message.getP114() != null && message.getP114().size() > 0) {
            output.writeU8F64Map(114, message.getP114());
        }
        //dft map<u8,sf64> p115 = 115 ; 
        if (message.getP115() != null && message.getP115().size() > 0) {
            output.writeU8SF64Map(115, message.getP115());
        }
        //dft map<u8,string> p116 = 116 ; 
        if (message.getP116() != null && message.getP116().size() > 0) {
            output.writeU8STRINGMap(116, message.getP116());
        }
        //dft map<u8,double> p117 = 117 ; 
        if (message.getP117() != null && message.getP117().size() > 0) {
            output.writeU8DOUBLEMap(117, message.getP117());
        }
        //dft map<u8,float> p118 = 118 ; 
        if (message.getP118() != null && message.getP118().size() > 0) {
            output.writeU8FLOATMap(118, message.getP118());
        }
        //dft map<i16,i8> p119 = 119 ; 
        if (message.getP119() != null && message.getP119().size() > 0) {
            output.writeI16I8Map(119, message.getP119());
        }
        //dft map<i16,u8> p120 = 120 ; 
        if (message.getP120() != null && message.getP120().size() > 0) {
            output.writeI16U8Map(120, message.getP120());
        }
        //dft map<i16,i16> p121 = 121 ; 
        if (message.getP121() != null && message.getP121().size() > 0) {
            output.writeI16I16Map(121, message.getP121());
        }
        //dft map<i16,u16> p122 = 122 ; 
        if (message.getP122() != null && message.getP122().size() > 0) {
            output.writeI16U16Map(122, message.getP122());
        }
        //dft map<i16,i32> p123 = 123 ; 
        if (message.getP123() != null && message.getP123().size() > 0) {
            output.writeI16I32Map(123, message.getP123());
        }
        //dft map<i16,u32> p124 = 124 ; 
        if (message.getP124() != null && message.getP124().size() > 0) {
            output.writeI16U32Map(124, message.getP124());
        }
        //dft map<i16,s32> p125 = 125 ; 
        if (message.getP125() != null && message.getP125().size() > 0) {
            output.writeI16S32Map(125, message.getP125());
        }
        //dft map<i16,f32> p126 = 126 ; 
        if (message.getP126() != null && message.getP126().size() > 0) {
            output.writeI16F32Map(126, message.getP126());
        }
        //dft map<i16,sf32> p127 = 127 ; 
        if (message.getP127() != null && message.getP127().size() > 0) {
            output.writeI16SF32Map(127, message.getP127());
        }
        //dft map<i16,i64> p128 = 128 ; 
        if (message.getP128() != null && message.getP128().size() > 0) {
            output.writeI16I64Map(128, message.getP128());
        }
        //dft map<i16,u64> p129 = 129 ; 
        if (message.getP129() != null && message.getP129().size() > 0) {
            output.writeI16U64Map(129, message.getP129());
        }
        //dft map<i16,s64> p130 = 130 ; 
        if (message.getP130() != null && message.getP130().size() > 0) {
            output.writeI16S64Map(130, message.getP130());
        }
        //dft map<i16,f64> p131 = 131 ; 
        if (message.getP131() != null && message.getP131().size() > 0) {
            output.writeI16F64Map(131, message.getP131());
        }
        //dft map<i16,sf64> p132 = 132 ; 
        if (message.getP132() != null && message.getP132().size() > 0) {
            output.writeI16SF64Map(132, message.getP132());
        }
        //dft map<i16,string> p133 = 133 ; 
        if (message.getP133() != null && message.getP133().size() > 0) {
            output.writeI16STRINGMap(133, message.getP133());
        }
        //dft map<i16,double> p134 = 134 ; 
        if (message.getP134() != null && message.getP134().size() > 0) {
            output.writeI16DOUBLEMap(134, message.getP134());
        }
        //dft map<i16,float> p135 = 135 ; 
        if (message.getP135() != null && message.getP135().size() > 0) {
            output.writeI16FLOATMap(135, message.getP135());
        }
        //dft map<u16,i8> p136 = 136 ; 
        if (message.getP136() != null && message.getP136().size() > 0) {
            output.writeU16I8Map(136, message.getP136());
        }
        //dft map<u16,u8> p137 = 137 ; 
        if (message.getP137() != null && message.getP137().size() > 0) {
            output.writeU16U8Map(137, message.getP137());
        }
        //dft map<u16,i16> p138 = 138 ; 
        if (message.getP138() != null && message.getP138().size() > 0) {
            output.writeU16I16Map(138, message.getP138());
        }
        //dft map<u16,u16> p139 = 139 ; 
        if (message.getP139() != null && message.getP139().size() > 0) {
            output.writeU16U16Map(139, message.getP139());
        }
        //dft map<u16,i32> p140 = 140 ; 
        if (message.getP140() != null && message.getP140().size() > 0) {
            output.writeU16I32Map(140, message.getP140());
        }
        //dft map<u16,u32> p141 = 141 ; 
        if (message.getP141() != null && message.getP141().size() > 0) {
            output.writeU16U32Map(141, message.getP141());
        }
        //dft map<u16,s32> p142 = 142 ; 
        if (message.getP142() != null && message.getP142().size() > 0) {
            output.writeU16S32Map(142, message.getP142());
        }
        //dft map<u16,f32> p143 = 143 ; 
        if (message.getP143() != null && message.getP143().size() > 0) {
            output.writeU16F32Map(143, message.getP143());
        }
        //dft map<u16,sf32> p144 = 144 ; 
        if (message.getP144() != null && message.getP144().size() > 0) {
            output.writeU16SF32Map(144, message.getP144());
        }
        //dft map<u16,i64> p145 = 145 ; 
        if (message.getP145() != null && message.getP145().size() > 0) {
            output.writeU16I64Map(145, message.getP145());
        }
        //dft map<u16,u64> p146 = 146 ; 
        if (message.getP146() != null && message.getP146().size() > 0) {
            output.writeU16U64Map(146, message.getP146());
        }
        //dft map<u16,s64> p147 = 147 ; 
        if (message.getP147() != null && message.getP147().size() > 0) {
            output.writeU16S64Map(147, message.getP147());
        }
        //dft map<u16,f64> p148 = 148 ; 
        if (message.getP148() != null && message.getP148().size() > 0) {
            output.writeU16F64Map(148, message.getP148());
        }
        //dft map<u16,sf64> p149 = 149 ; 
        if (message.getP149() != null && message.getP149().size() > 0) {
            output.writeU16SF64Map(149, message.getP149());
        }
        //dft map<u16,string> p150 = 150 ; 
        if (message.getP150() != null && message.getP150().size() > 0) {
            output.writeU16STRINGMap(150, message.getP150());
        }
        //dft map<u16,double> p151 = 151 ; 
        if (message.getP151() != null && message.getP151().size() > 0) {
            output.writeU16DOUBLEMap(151, message.getP151());
        }
        //dft map<u16,float> p152 = 152 ; 
        if (message.getP152() != null && message.getP152().size() > 0) {
            output.writeU16FLOATMap(152, message.getP152());
        }
        //dft map<i32,i8> p153 = 153 ; 
        if (message.getP153() != null && message.getP153().size() > 0) {
            output.writeI32I8Map(153, message.getP153());
        }
        //dft map<i32,u8> p154 = 154 ; 
        if (message.getP154() != null && message.getP154().size() > 0) {
            output.writeI32U8Map(154, message.getP154());
        }
        //dft map<i32,i16> p155 = 155 ; 
        if (message.getP155() != null && message.getP155().size() > 0) {
            output.writeI32I16Map(155, message.getP155());
        }
        //dft map<i32,u16> p156 = 156 ; 
        if (message.getP156() != null && message.getP156().size() > 0) {
            output.writeI32U16Map(156, message.getP156());
        }
        //dft map<i32,i32> p157 = 157 ; 
        if (message.getP157() != null && message.getP157().size() > 0) {
            output.writeI32I32Map(157, message.getP157());
        }
        //dft map<i32,u32> p158 = 158 ; 
        if (message.getP158() != null && message.getP158().size() > 0) {
            output.writeI32U32Map(158, message.getP158());
        }
        //dft map<i32,s32> p159 = 159 ; 
        if (message.getP159() != null && message.getP159().size() > 0) {
            output.writeI32S32Map(159, message.getP159());
        }
        //dft map<i32,f32> p160 = 160 ; 
        if (message.getP160() != null && message.getP160().size() > 0) {
            output.writeI32F32Map(160, message.getP160());
        }
        //dft map<i32,sf32> p161 = 161 ; 
        if (message.getP161() != null && message.getP161().size() > 0) {
            output.writeI32SF32Map(161, message.getP161());
        }
        //dft map<i32,i64> p162 = 162 ; 
        if (message.getP162() != null && message.getP162().size() > 0) {
            output.writeI32I64Map(162, message.getP162());
        }
        //dft map<i32,u64> p163 = 163 ; 
        if (message.getP163() != null && message.getP163().size() > 0) {
            output.writeI32U64Map(163, message.getP163());
        }
        //dft map<i32,s64> p164 = 164 ; 
        if (message.getP164() != null && message.getP164().size() > 0) {
            output.writeI32S64Map(164, message.getP164());
        }
        //dft map<i32,f64> p165 = 165 ; 
        if (message.getP165() != null && message.getP165().size() > 0) {
            output.writeI32F64Map(165, message.getP165());
        }
        //dft map<i32,sf64> p166 = 166 ; 
        if (message.getP166() != null && message.getP166().size() > 0) {
            output.writeI32SF64Map(166, message.getP166());
        }
        //dft map<i32,string> p167 = 167 ; 
        if (message.getP167() != null && message.getP167().size() > 0) {
            output.writeI32STRINGMap(167, message.getP167());
        }
        //dft map<i32,double> p168 = 168 ; 
        if (message.getP168() != null && message.getP168().size() > 0) {
            output.writeI32DOUBLEMap(168, message.getP168());
        }
        //dft map<i32,float> p169 = 169 ; 
        if (message.getP169() != null && message.getP169().size() > 0) {
            output.writeI32FLOATMap(169, message.getP169());
        }
        //dft map<u32,i8> p170 = 170 ; 
        if (message.getP170() != null && message.getP170().size() > 0) {
            output.writeU32I8Map(170, message.getP170());
        }
        //dft map<u32,u8> p171 = 171 ; 
        if (message.getP171() != null && message.getP171().size() > 0) {
            output.writeU32U8Map(171, message.getP171());
        }
        //dft map<u32,i16> p172 = 172 ; 
        if (message.getP172() != null && message.getP172().size() > 0) {
            output.writeU32I16Map(172, message.getP172());
        }
        //dft map<u32,u16> p173 = 173 ; 
        if (message.getP173() != null && message.getP173().size() > 0) {
            output.writeU32U16Map(173, message.getP173());
        }
        //dft map<u32,i32> p174 = 174 ; 
        if (message.getP174() != null && message.getP174().size() > 0) {
            output.writeU32I32Map(174, message.getP174());
        }
        //dft map<u32,u32> p175 = 175 ; 
        if (message.getP175() != null && message.getP175().size() > 0) {
            output.writeU32U32Map(175, message.getP175());
        }
        //dft map<u32,s32> p176 = 176 ; 
        if (message.getP176() != null && message.getP176().size() > 0) {
            output.writeU32S32Map(176, message.getP176());
        }
        //dft map<u32,f32> p177 = 177 ; 
        if (message.getP177() != null && message.getP177().size() > 0) {
            output.writeU32F32Map(177, message.getP177());
        }
        //dft map<u32,sf32> p178 = 178 ; 
        if (message.getP178() != null && message.getP178().size() > 0) {
            output.writeU32SF32Map(178, message.getP178());
        }
        //dft map<u32,i64> p179 = 179 ; 
        if (message.getP179() != null && message.getP179().size() > 0) {
            output.writeU32I64Map(179, message.getP179());
        }
        //dft map<u32,u64> p180 = 180 ; 
        if (message.getP180() != null && message.getP180().size() > 0) {
            output.writeU32U64Map(180, message.getP180());
        }
        //dft map<u32,s64> p181 = 181 ; 
        if (message.getP181() != null && message.getP181().size() > 0) {
            output.writeU32S64Map(181, message.getP181());
        }
        //dft map<u32,f64> p182 = 182 ; 
        if (message.getP182() != null && message.getP182().size() > 0) {
            output.writeU32F64Map(182, message.getP182());
        }
        //dft map<u32,sf64> p183 = 183 ; 
        if (message.getP183() != null && message.getP183().size() > 0) {
            output.writeU32SF64Map(183, message.getP183());
        }
        //dft map<u32,string> p184 = 184 ; 
        if (message.getP184() != null && message.getP184().size() > 0) {
            output.writeU32STRINGMap(184, message.getP184());
        }
        //dft map<u32,double> p185 = 185 ; 
        if (message.getP185() != null && message.getP185().size() > 0) {
            output.writeU32DOUBLEMap(185, message.getP185());
        }
        //dft map<u32,float> p186 = 186 ; 
        if (message.getP186() != null && message.getP186().size() > 0) {
            output.writeU32FLOATMap(186, message.getP186());
        }
        //dft map<s32,i8> p187 = 187 ; 
        if (message.getP187() != null && message.getP187().size() > 0) {
            output.writeS32I8Map(187, message.getP187());
        }
        //dft map<s32,u8> p188 = 188 ; 
        if (message.getP188() != null && message.getP188().size() > 0) {
            output.writeS32U8Map(188, message.getP188());
        }
        //dft map<s32,i16> p189 = 189 ; 
        if (message.getP189() != null && message.getP189().size() > 0) {
            output.writeS32I16Map(189, message.getP189());
        }
        //dft map<s32,u16> p190 = 190 ; 
        if (message.getP190() != null && message.getP190().size() > 0) {
            output.writeS32U16Map(190, message.getP190());
        }
        //dft map<s32,i32> p191 = 191 ; 
        if (message.getP191() != null && message.getP191().size() > 0) {
            output.writeS32I32Map(191, message.getP191());
        }
        //dft map<s32,u32> p192 = 192 ; 
        if (message.getP192() != null && message.getP192().size() > 0) {
            output.writeS32U32Map(192, message.getP192());
        }
        //dft map<s32,s32> p193 = 193 ; 
        if (message.getP193() != null && message.getP193().size() > 0) {
            output.writeS32S32Map(193, message.getP193());
        }
        //dft map<s32,f32> p194 = 194 ; 
        if (message.getP194() != null && message.getP194().size() > 0) {
            output.writeS32F32Map(194, message.getP194());
        }
        //dft map<s32,sf32> p195 = 195 ; 
        if (message.getP195() != null && message.getP195().size() > 0) {
            output.writeS32SF32Map(195, message.getP195());
        }
        //dft map<s32,i64> p196 = 196 ; 
        if (message.getP196() != null && message.getP196().size() > 0) {
            output.writeS32I64Map(196, message.getP196());
        }
        //dft map<s32,u64> p197 = 197 ; 
        if (message.getP197() != null && message.getP197().size() > 0) {
            output.writeS32U64Map(197, message.getP197());
        }
        //dft map<s32,s64> p198 = 198 ; 
        if (message.getP198() != null && message.getP198().size() > 0) {
            output.writeS32S64Map(198, message.getP198());
        }
        //dft map<s32,f64> p199 = 199 ; 
        if (message.getP199() != null && message.getP199().size() > 0) {
            output.writeS32F64Map(199, message.getP199());
        }
        //dft map<s32,sf64> p200 = 200 ; 
        if (message.getP200() != null && message.getP200().size() > 0) {
            output.writeS32SF64Map(200, message.getP200());
        }
        //dft map<s32,string> p201 = 201 ; 
        if (message.getP201() != null && message.getP201().size() > 0) {
            output.writeS32STRINGMap(201, message.getP201());
        }
        //dft map<s32,double> p202 = 202 ; 
        if (message.getP202() != null && message.getP202().size() > 0) {
            output.writeS32DOUBLEMap(202, message.getP202());
        }
        //dft map<s32,float> p203 = 203 ; 
        if (message.getP203() != null && message.getP203().size() > 0) {
            output.writeS32FLOATMap(203, message.getP203());
        }
        //dft map<f32,i8> p204 = 204 ; 
        if (message.getP204() != null && message.getP204().size() > 0) {
            output.writeF32I8Map(204, message.getP204());
        }
        //dft map<f32,u8> p205 = 205 ; 
        if (message.getP205() != null && message.getP205().size() > 0) {
            output.writeF32U8Map(205, message.getP205());
        }
        //dft map<f32,i16> p206 = 206 ; 
        if (message.getP206() != null && message.getP206().size() > 0) {
            output.writeF32I16Map(206, message.getP206());
        }
        //dft map<f32,u16> p207 = 207 ; 
        if (message.getP207() != null && message.getP207().size() > 0) {
            output.writeF32U16Map(207, message.getP207());
        }
        //dft map<f32,i32> p208 = 208 ; 
        if (message.getP208() != null && message.getP208().size() > 0) {
            output.writeF32I32Map(208, message.getP208());
        }
        //dft map<f32,u32> p209 = 209 ; 
        if (message.getP209() != null && message.getP209().size() > 0) {
            output.writeF32U32Map(209, message.getP209());
        }
        //dft map<f32,s32> p210 = 210 ; 
        if (message.getP210() != null && message.getP210().size() > 0) {
            output.writeF32S32Map(210, message.getP210());
        }
        //dft map<f32,f32> p211 = 211 ; 
        if (message.getP211() != null && message.getP211().size() > 0) {
            output.writeF32F32Map(211, message.getP211());
        }
        //dft map<f32,sf32> p212 = 212 ; 
        if (message.getP212() != null && message.getP212().size() > 0) {
            output.writeF32SF32Map(212, message.getP212());
        }
        //dft map<f32,i64> p213 = 213 ; 
        if (message.getP213() != null && message.getP213().size() > 0) {
            output.writeF32I64Map(213, message.getP213());
        }
        //dft map<f32,u64> p214 = 214 ; 
        if (message.getP214() != null && message.getP214().size() > 0) {
            output.writeF32U64Map(214, message.getP214());
        }
        //dft map<f32,s64> p215 = 215 ; 
        if (message.getP215() != null && message.getP215().size() > 0) {
            output.writeF32S64Map(215, message.getP215());
        }
        //dft map<f32,f64> p216 = 216 ; 
        if (message.getP216() != null && message.getP216().size() > 0) {
            output.writeF32F64Map(216, message.getP216());
        }
        //dft map<f32,sf64> p217 = 217 ; 
        if (message.getP217() != null && message.getP217().size() > 0) {
            output.writeF32SF64Map(217, message.getP217());
        }
        //dft map<f32,string> p218 = 218 ; 
        if (message.getP218() != null && message.getP218().size() > 0) {
            output.writeF32STRINGMap(218, message.getP218());
        }
        //dft map<f32,double> p219 = 219 ; 
        if (message.getP219() != null && message.getP219().size() > 0) {
            output.writeF32DOUBLEMap(219, message.getP219());
        }
        //dft map<f32,float> p220 = 220 ; 
        if (message.getP220() != null && message.getP220().size() > 0) {
            output.writeF32FLOATMap(220, message.getP220());
        }
        //dft map<sf32,i8> p221 = 221 ; 
        if (message.getP221() != null && message.getP221().size() > 0) {
            output.writeSF32I8Map(221, message.getP221());
        }
        //dft map<sf32,u8> p222 = 222 ; 
        if (message.getP222() != null && message.getP222().size() > 0) {
            output.writeSF32U8Map(222, message.getP222());
        }
        //dft map<sf32,i16> p223 = 223 ; 
        if (message.getP223() != null && message.getP223().size() > 0) {
            output.writeSF32I16Map(223, message.getP223());
        }
        //dft map<sf32,u16> p224 = 224 ; 
        if (message.getP224() != null && message.getP224().size() > 0) {
            output.writeSF32U16Map(224, message.getP224());
        }
        //dft map<sf32,i32> p225 = 225 ; 
        if (message.getP225() != null && message.getP225().size() > 0) {
            output.writeSF32I32Map(225, message.getP225());
        }
        //dft map<sf32,u32> p226 = 226 ; 
        if (message.getP226() != null && message.getP226().size() > 0) {
            output.writeSF32U32Map(226, message.getP226());
        }
        //dft map<sf32,s32> p227 = 227 ; 
        if (message.getP227() != null && message.getP227().size() > 0) {
            output.writeSF32S32Map(227, message.getP227());
        }
        //dft map<sf32,f32> p228 = 228 ; 
        if (message.getP228() != null && message.getP228().size() > 0) {
            output.writeSF32F32Map(228, message.getP228());
        }
        //dft map<sf32,sf32> p229 = 229 ; 
        if (message.getP229() != null && message.getP229().size() > 0) {
            output.writeSF32SF32Map(229, message.getP229());
        }
        //dft map<sf32,i64> p230 = 230 ; 
        if (message.getP230() != null && message.getP230().size() > 0) {
            output.writeSF32I64Map(230, message.getP230());
        }
        //dft map<sf32,u64> p231 = 231 ; 
        if (message.getP231() != null && message.getP231().size() > 0) {
            output.writeSF32U64Map(231, message.getP231());
        }
        //dft map<sf32,s64> p232 = 232 ; 
        if (message.getP232() != null && message.getP232().size() > 0) {
            output.writeSF32S64Map(232, message.getP232());
        }
        //dft map<sf32,f64> p233 = 233 ; 
        if (message.getP233() != null && message.getP233().size() > 0) {
            output.writeSF32F64Map(233, message.getP233());
        }
        //dft map<sf32,sf64> p234 = 234 ; 
        if (message.getP234() != null && message.getP234().size() > 0) {
            output.writeSF32SF64Map(234, message.getP234());
        }
        //dft map<sf32,string> p235 = 235 ; 
        if (message.getP235() != null && message.getP235().size() > 0) {
            output.writeSF32STRINGMap(235, message.getP235());
        }
        //dft map<sf32,double> p236 = 236 ; 
        if (message.getP236() != null && message.getP236().size() > 0) {
            output.writeSF32DOUBLEMap(236, message.getP236());
        }
        //dft map<sf32,float> p237 = 237 ; 
        if (message.getP237() != null && message.getP237().size() > 0) {
            output.writeSF32FLOATMap(237, message.getP237());
        }
        //dft map<i64,i8> p238 = 238 ; 
        if (message.getP238() != null && message.getP238().size() > 0) {
            output.writeI64I8Map(238, message.getP238());
        }
        //dft map<i64,u8> p239 = 239 ; 
        if (message.getP239() != null && message.getP239().size() > 0) {
            output.writeI64U8Map(239, message.getP239());
        }
        //dft map<i64,i16> p240 = 240 ; 
        if (message.getP240() != null && message.getP240().size() > 0) {
            output.writeI64I16Map(240, message.getP240());
        }
        //dft map<i64,u16> p241 = 241 ; 
        if (message.getP241() != null && message.getP241().size() > 0) {
            output.writeI64U16Map(241, message.getP241());
        }
        //dft map<i64,i32> p242 = 242 ; 
        if (message.getP242() != null && message.getP242().size() > 0) {
            output.writeI64I32Map(242, message.getP242());
        }
        //dft map<i64,u32> p243 = 243 ; 
        if (message.getP243() != null && message.getP243().size() > 0) {
            output.writeI64U32Map(243, message.getP243());
        }
        //dft map<i64,s32> p244 = 244 ; 
        if (message.getP244() != null && message.getP244().size() > 0) {
            output.writeI64S32Map(244, message.getP244());
        }
        //dft map<i64,f32> p245 = 245 ; 
        if (message.getP245() != null && message.getP245().size() > 0) {
            output.writeI64F32Map(245, message.getP245());
        }
        //dft map<i64,sf32> p246 = 246 ; 
        if (message.getP246() != null && message.getP246().size() > 0) {
            output.writeI64SF32Map(246, message.getP246());
        }
        //dft map<i64,i64> p247 = 247 ; 
        if (message.getP247() != null && message.getP247().size() > 0) {
            output.writeI64I64Map(247, message.getP247());
        }
        //dft map<i64,u64> p248 = 248 ; 
        if (message.getP248() != null && message.getP248().size() > 0) {
            output.writeI64U64Map(248, message.getP248());
        }
        //dft map<i64,s64> p249 = 249 ; 
        if (message.getP249() != null && message.getP249().size() > 0) {
            output.writeI64S64Map(249, message.getP249());
        }
        //dft map<i64,f64> p250 = 250 ; 
        if (message.getP250() != null && message.getP250().size() > 0) {
            output.writeI64F64Map(250, message.getP250());
        }
        //dft map<i64,sf64> p251 = 251 ; 
        if (message.getP251() != null && message.getP251().size() > 0) {
            output.writeI64SF64Map(251, message.getP251());
        }
        //dft map<i64,string> p252 = 252 ; 
        if (message.getP252() != null && message.getP252().size() > 0) {
            output.writeI64STRINGMap(252, message.getP252());
        }
        //dft map<i64,double> p253 = 253 ; 
        if (message.getP253() != null && message.getP253().size() > 0) {
            output.writeI64DOUBLEMap(253, message.getP253());
        }
        //dft map<i64,float> p254 = 254 ; 
        if (message.getP254() != null && message.getP254().size() > 0) {
            output.writeI64FLOATMap(254, message.getP254());
        }
        //dft map<u64,i8> p255 = 255 ; 
        if (message.getP255() != null && message.getP255().size() > 0) {
            output.writeU64I8Map(255, message.getP255());
        }
        //dft map<u64,u8> p256 = 256 ; 
        if (message.getP256() != null && message.getP256().size() > 0) {
            output.writeU64U8Map(256, message.getP256());
        }
        //dft map<u64,i16> p257 = 257 ; 
        if (message.getP257() != null && message.getP257().size() > 0) {
            output.writeU64I16Map(257, message.getP257());
        }
        //dft map<u64,u16> p258 = 258 ; 
        if (message.getP258() != null && message.getP258().size() > 0) {
            output.writeU64U16Map(258, message.getP258());
        }
        //dft map<u64,i32> p259 = 259 ; 
        if (message.getP259() != null && message.getP259().size() > 0) {
            output.writeU64I32Map(259, message.getP259());
        }
        //dft map<u64,u32> p260 = 260 ; 
        if (message.getP260() != null && message.getP260().size() > 0) {
            output.writeU64U32Map(260, message.getP260());
        }
        //dft map<u64,s32> p261 = 261 ; 
        if (message.getP261() != null && message.getP261().size() > 0) {
            output.writeU64S32Map(261, message.getP261());
        }
        //dft map<u64,f32> p262 = 262 ; 
        if (message.getP262() != null && message.getP262().size() > 0) {
            output.writeU64F32Map(262, message.getP262());
        }
        //dft map<u64,sf32> p263 = 263 ; 
        if (message.getP263() != null && message.getP263().size() > 0) {
            output.writeU64SF32Map(263, message.getP263());
        }
        //dft map<u64,i64> p264 = 264 ; 
        if (message.getP264() != null && message.getP264().size() > 0) {
            output.writeU64I64Map(264, message.getP264());
        }
        //dft map<u64,u64> p265 = 265 ; 
        if (message.getP265() != null && message.getP265().size() > 0) {
            output.writeU64U64Map(265, message.getP265());
        }
        //dft map<u64,s64> p266 = 266 ; 
        if (message.getP266() != null && message.getP266().size() > 0) {
            output.writeU64S64Map(266, message.getP266());
        }
        //dft map<u64,f64> p267 = 267 ; 
        if (message.getP267() != null && message.getP267().size() > 0) {
            output.writeU64F64Map(267, message.getP267());
        }
        //dft map<u64,sf64> p268 = 268 ; 
        if (message.getP268() != null && message.getP268().size() > 0) {
            output.writeU64SF64Map(268, message.getP268());
        }
        //dft map<u64,string> p269 = 269 ; 
        if (message.getP269() != null && message.getP269().size() > 0) {
            output.writeU64STRINGMap(269, message.getP269());
        }
        //dft map<u64,double> p270 = 270 ; 
        if (message.getP270() != null && message.getP270().size() > 0) {
            output.writeU64DOUBLEMap(270, message.getP270());
        }
        //dft map<u64,float> p271 = 271 ; 
        if (message.getP271() != null && message.getP271().size() > 0) {
            output.writeU64FLOATMap(271, message.getP271());
        }
        //dft map<s64,i8> p272 = 272 ; 
        if (message.getP272() != null && message.getP272().size() > 0) {
            output.writeS64I8Map(272, message.getP272());
        }
        //dft map<s64,u8> p273 = 273 ; 
        if (message.getP273() != null && message.getP273().size() > 0) {
            output.writeS64U8Map(273, message.getP273());
        }
        //dft map<s64,i16> p274 = 274 ; 
        if (message.getP274() != null && message.getP274().size() > 0) {
            output.writeS64I16Map(274, message.getP274());
        }
        //dft map<s64,u16> p275 = 275 ; 
        if (message.getP275() != null && message.getP275().size() > 0) {
            output.writeS64U16Map(275, message.getP275());
        }
        //dft map<s64,i32> p276 = 276 ; 
        if (message.getP276() != null && message.getP276().size() > 0) {
            output.writeS64I32Map(276, message.getP276());
        }
        //dft map<s64,u32> p277 = 277 ; 
        if (message.getP277() != null && message.getP277().size() > 0) {
            output.writeS64U32Map(277, message.getP277());
        }
        //dft map<s64,s32> p278 = 278 ; 
        if (message.getP278() != null && message.getP278().size() > 0) {
            output.writeS64S32Map(278, message.getP278());
        }
        //dft map<s64,f32> p279 = 279 ; 
        if (message.getP279() != null && message.getP279().size() > 0) {
            output.writeS64F32Map(279, message.getP279());
        }
        //dft map<s64,sf32> p280 = 280 ; 
        if (message.getP280() != null && message.getP280().size() > 0) {
            output.writeS64SF32Map(280, message.getP280());
        }
        //dft map<s64,i64> p281 = 281 ; 
        if (message.getP281() != null && message.getP281().size() > 0) {
            output.writeS64I64Map(281, message.getP281());
        }
        //dft map<s64,u64> p282 = 282 ; 
        if (message.getP282() != null && message.getP282().size() > 0) {
            output.writeS64U64Map(282, message.getP282());
        }
        //dft map<s64,s64> p283 = 283 ; 
        if (message.getP283() != null && message.getP283().size() > 0) {
            output.writeS64S64Map(283, message.getP283());
        }
        //dft map<s64,f64> p284 = 284 ; 
        if (message.getP284() != null && message.getP284().size() > 0) {
            output.writeS64F64Map(284, message.getP284());
        }
        //dft map<s64,sf64> p285 = 285 ; 
        if (message.getP285() != null && message.getP285().size() > 0) {
            output.writeS64SF64Map(285, message.getP285());
        }
        //dft map<s64,string> p286 = 286 ; 
        if (message.getP286() != null && message.getP286().size() > 0) {
            output.writeS64STRINGMap(286, message.getP286());
        }
        //dft map<s64,double> p287 = 287 ; 
        if (message.getP287() != null && message.getP287().size() > 0) {
            output.writeS64DOUBLEMap(287, message.getP287());
        }
        //dft map<s64,float> p288 = 288 ; 
        if (message.getP288() != null && message.getP288().size() > 0) {
            output.writeS64FLOATMap(288, message.getP288());
        }
        //dft map<f64,i8> p289 = 289 ; 
        if (message.getP289() != null && message.getP289().size() > 0) {
            output.writeF64I8Map(289, message.getP289());
        }
        //dft map<f64,u8> p290 = 290 ; 
        if (message.getP290() != null && message.getP290().size() > 0) {
            output.writeF64U8Map(290, message.getP290());
        }
        //dft map<f64,i16> p291 = 291 ; 
        if (message.getP291() != null && message.getP291().size() > 0) {
            output.writeF64I16Map(291, message.getP291());
        }
        //dft map<f64,u16> p292 = 292 ; 
        if (message.getP292() != null && message.getP292().size() > 0) {
            output.writeF64U16Map(292, message.getP292());
        }
        //dft map<f64,i32> p293 = 293 ; 
        if (message.getP293() != null && message.getP293().size() > 0) {
            output.writeF64I32Map(293, message.getP293());
        }
        //dft map<f64,u32> p294 = 294 ; 
        if (message.getP294() != null && message.getP294().size() > 0) {
            output.writeF64U32Map(294, message.getP294());
        }
        //dft map<f64,s32> p295 = 295 ; 
        if (message.getP295() != null && message.getP295().size() > 0) {
            output.writeF64S32Map(295, message.getP295());
        }
        //dft map<f64,f32> p296 = 296 ; 
        if (message.getP296() != null && message.getP296().size() > 0) {
            output.writeF64F32Map(296, message.getP296());
        }
        //dft map<f64,sf32> p297 = 297 ; 
        if (message.getP297() != null && message.getP297().size() > 0) {
            output.writeF64SF32Map(297, message.getP297());
        }
        //dft map<f64,i64> p298 = 298 ; 
        if (message.getP298() != null && message.getP298().size() > 0) {
            output.writeF64I64Map(298, message.getP298());
        }
        //dft map<f64,u64> p299 = 299 ; 
        if (message.getP299() != null && message.getP299().size() > 0) {
            output.writeF64U64Map(299, message.getP299());
        }
        //dft map<f64,s64> p300 = 300 ; 
        if (message.getP300() != null && message.getP300().size() > 0) {
            output.writeF64S64Map(300, message.getP300());
        }
        //dft map<f64,f64> p301 = 301 ; 
        if (message.getP301() != null && message.getP301().size() > 0) {
            output.writeF64F64Map(301, message.getP301());
        }
        //dft map<f64,sf64> p302 = 302 ; 
        if (message.getP302() != null && message.getP302().size() > 0) {
            output.writeF64SF64Map(302, message.getP302());
        }
        //dft map<f64,string> p303 = 303 ; 
        if (message.getP303() != null && message.getP303().size() > 0) {
            output.writeF64STRINGMap(303, message.getP303());
        }
        //dft map<f64,double> p304 = 304 ; 
        if (message.getP304() != null && message.getP304().size() > 0) {
            output.writeF64DOUBLEMap(304, message.getP304());
        }
        //dft map<f64,float> p305 = 305 ; 
        if (message.getP305() != null && message.getP305().size() > 0) {
            output.writeF64FLOATMap(305, message.getP305());
        }
        //dft map<sf64,i8> p306 = 306 ; 
        if (message.getP306() != null && message.getP306().size() > 0) {
            output.writeSF64I8Map(306, message.getP306());
        }
        //dft map<sf64,u8> p307 = 307 ; 
        if (message.getP307() != null && message.getP307().size() > 0) {
            output.writeSF64U8Map(307, message.getP307());
        }
        //dft map<sf64,i16> p308 = 308 ; 
        if (message.getP308() != null && message.getP308().size() > 0) {
            output.writeSF64I16Map(308, message.getP308());
        }
        //dft map<sf64,u16> p309 = 309 ; 
        if (message.getP309() != null && message.getP309().size() > 0) {
            output.writeSF64U16Map(309, message.getP309());
        }
        //dft map<sf64,i32> p310 = 310 ; 
        if (message.getP310() != null && message.getP310().size() > 0) {
            output.writeSF64I32Map(310, message.getP310());
        }
        //dft map<sf64,u32> p311 = 311 ; 
        if (message.getP311() != null && message.getP311().size() > 0) {
            output.writeSF64U32Map(311, message.getP311());
        }
        //dft map<sf64,s32> p312 = 312 ; 
        if (message.getP312() != null && message.getP312().size() > 0) {
            output.writeSF64S32Map(312, message.getP312());
        }
        //dft map<sf64,f32> p313 = 313 ; 
        if (message.getP313() != null && message.getP313().size() > 0) {
            output.writeSF64F32Map(313, message.getP313());
        }
        //dft map<sf64,sf32> p314 = 314 ; 
        if (message.getP314() != null && message.getP314().size() > 0) {
            output.writeSF64SF32Map(314, message.getP314());
        }
        //dft map<sf64,i64> p315 = 315 ; 
        if (message.getP315() != null && message.getP315().size() > 0) {
            output.writeSF64I64Map(315, message.getP315());
        }
        //dft map<sf64,u64> p316 = 316 ; 
        if (message.getP316() != null && message.getP316().size() > 0) {
            output.writeSF64U64Map(316, message.getP316());
        }
        //dft map<sf64,s64> p317 = 317 ; 
        if (message.getP317() != null && message.getP317().size() > 0) {
            output.writeSF64S64Map(317, message.getP317());
        }
        //dft map<sf64,f64> p318 = 318 ; 
        if (message.getP318() != null && message.getP318().size() > 0) {
            output.writeSF64F64Map(318, message.getP318());
        }
        //dft map<sf64,sf64> p319 = 319 ; 
        if (message.getP319() != null && message.getP319().size() > 0) {
            output.writeSF64SF64Map(319, message.getP319());
        }
        //dft map<sf64,string> p320 = 320 ; 
        if (message.getP320() != null && message.getP320().size() > 0) {
            output.writeSF64STRINGMap(320, message.getP320());
        }
        //dft map<sf64,double> p321 = 321 ; 
        if (message.getP321() != null && message.getP321().size() > 0) {
            output.writeSF64DOUBLEMap(321, message.getP321());
        }
        //dft map<sf64,float> p322 = 322 ; 
        if (message.getP322() != null && message.getP322().size() > 0) {
            output.writeSF64FLOATMap(322, message.getP322());
        }
        //dft map<string,i8> p323 = 323 ; 
        if (message.getP323() != null && message.getP323().size() > 0) {
            output.writeSTRINGI8Map(323, message.getP323());
        }
        //dft map<string,u8> p324 = 324 ; 
        if (message.getP324() != null && message.getP324().size() > 0) {
            output.writeSTRINGU8Map(324, message.getP324());
        }
        //dft map<string,i16> p325 = 325 ; 
        if (message.getP325() != null && message.getP325().size() > 0) {
            output.writeSTRINGI16Map(325, message.getP325());
        }
        //dft map<string,u16> p326 = 326 ; 
        if (message.getP326() != null && message.getP326().size() > 0) {
            output.writeSTRINGU16Map(326, message.getP326());
        }
        //dft map<string,i32> p327 = 327 ; 
        if (message.getP327() != null && message.getP327().size() > 0) {
            output.writeSTRINGI32Map(327, message.getP327());
        }
        //dft map<string,u32> p328 = 328 ; 
        if (message.getP328() != null && message.getP328().size() > 0) {
            output.writeSTRINGU32Map(328, message.getP328());
        }
        //dft map<string,s32> p329 = 329 ; 
        if (message.getP329() != null && message.getP329().size() > 0) {
            output.writeSTRINGS32Map(329, message.getP329());
        }
        //dft map<string,f32> p330 = 330 ; 
        if (message.getP330() != null && message.getP330().size() > 0) {
            output.writeSTRINGF32Map(330, message.getP330());
        }
        //dft map<string,sf32> p331 = 331 ; 
        if (message.getP331() != null && message.getP331().size() > 0) {
            output.writeSTRINGSF32Map(331, message.getP331());
        }
        //dft map<string,i64> p332 = 332 ; 
        if (message.getP332() != null && message.getP332().size() > 0) {
            output.writeSTRINGI64Map(332, message.getP332());
        }
        //dft map<string,u64> p333 = 333 ; 
        if (message.getP333() != null && message.getP333().size() > 0) {
            output.writeSTRINGU64Map(333, message.getP333());
        }
        //dft map<string,s64> p334 = 334 ; 
        if (message.getP334() != null && message.getP334().size() > 0) {
            output.writeSTRINGS64Map(334, message.getP334());
        }
        //dft map<string,f64> p335 = 335 ; 
        if (message.getP335() != null && message.getP335().size() > 0) {
            output.writeSTRINGF64Map(335, message.getP335());
        }
        //dft map<string,sf64> p336 = 336 ; 
        if (message.getP336() != null && message.getP336().size() > 0) {
            output.writeSTRINGSF64Map(336, message.getP336());
        }
        //dft map<string,string> p337 = 337 ; 
        if (message.getP337() != null && message.getP337().size() > 0) {
            output.writeSTRINGSTRINGMap(337, message.getP337());
        }
        //dft map<string,double> p338 = 338 ; 
        if (message.getP338() != null && message.getP338().size() > 0) {
            output.writeSTRINGDOUBLEMap(338, message.getP338());
        }
        //dft map<string,float> p339 = 339 ; 
        if (message.getP339() != null && message.getP339().size() > 0) {
            output.writeSTRINGFLOATMap(339, message.getP339());
        }
        //dft map<double,i8> p340 = 340 ; 
        if (message.getP340() != null && message.getP340().size() > 0) {
            output.writeDOUBLEI8Map(340, message.getP340());
        }
        //dft map<double,u8> p341 = 341 ; 
        if (message.getP341() != null && message.getP341().size() > 0) {
            output.writeDOUBLEU8Map(341, message.getP341());
        }
        //dft map<double,i16> p342 = 342 ; 
        if (message.getP342() != null && message.getP342().size() > 0) {
            output.writeDOUBLEI16Map(342, message.getP342());
        }
        //dft map<double,u16> p343 = 343 ; 
        if (message.getP343() != null && message.getP343().size() > 0) {
            output.writeDOUBLEU16Map(343, message.getP343());
        }
        //dft map<double,i32> p344 = 344 ; 
        if (message.getP344() != null && message.getP344().size() > 0) {
            output.writeDOUBLEI32Map(344, message.getP344());
        }
        //dft map<double,u32> p345 = 345 ; 
        if (message.getP345() != null && message.getP345().size() > 0) {
            output.writeDOUBLEU32Map(345, message.getP345());
        }
        //dft map<double,s32> p346 = 346 ; 
        if (message.getP346() != null && message.getP346().size() > 0) {
            output.writeDOUBLES32Map(346, message.getP346());
        }
        //dft map<double,f32> p347 = 347 ; 
        if (message.getP347() != null && message.getP347().size() > 0) {
            output.writeDOUBLEF32Map(347, message.getP347());
        }
        //dft map<double,sf32> p348 = 348 ; 
        if (message.getP348() != null && message.getP348().size() > 0) {
            output.writeDOUBLESF32Map(348, message.getP348());
        }
        //dft map<double,i64> p349 = 349 ; 
        if (message.getP349() != null && message.getP349().size() > 0) {
            output.writeDOUBLEI64Map(349, message.getP349());
        }
        //dft map<double,u64> p350 = 350 ; 
        if (message.getP350() != null && message.getP350().size() > 0) {
            output.writeDOUBLEU64Map(350, message.getP350());
        }
        //dft map<double,s64> p351 = 351 ; 
        if (message.getP351() != null && message.getP351().size() > 0) {
            output.writeDOUBLES64Map(351, message.getP351());
        }
        //dft map<double,f64> p352 = 352 ; 
        if (message.getP352() != null && message.getP352().size() > 0) {
            output.writeDOUBLEF64Map(352, message.getP352());
        }
        //dft map<double,sf64> p353 = 353 ; 
        if (message.getP353() != null && message.getP353().size() > 0) {
            output.writeDOUBLESF64Map(353, message.getP353());
        }
        //dft map<double,string> p354 = 354 ; 
        if (message.getP354() != null && message.getP354().size() > 0) {
            output.writeDOUBLESTRINGMap(354, message.getP354());
        }
        //dft map<double,double> p355 = 355 ; 
        if (message.getP355() != null && message.getP355().size() > 0) {
            output.writeDOUBLEDOUBLEMap(355, message.getP355());
        }
        //dft map<double,float> p356 = 356 ; 
        if (message.getP356() != null && message.getP356().size() > 0) {
            output.writeDOUBLEFLOATMap(356, message.getP356());
        }
        //dft map<float,i8> p357 = 357 ; 
        if (message.getP357() != null && message.getP357().size() > 0) {
            output.writeFLOATI8Map(357, message.getP357());
        }
        //dft map<float,u8> p358 = 358 ; 
        if (message.getP358() != null && message.getP358().size() > 0) {
            output.writeFLOATU8Map(358, message.getP358());
        }
        //dft map<float,i16> p359 = 359 ; 
        if (message.getP359() != null && message.getP359().size() > 0) {
            output.writeFLOATI16Map(359, message.getP359());
        }
        //dft map<float,u16> p360 = 360 ; 
        if (message.getP360() != null && message.getP360().size() > 0) {
            output.writeFLOATU16Map(360, message.getP360());
        }
        //dft map<float,i32> p361 = 361 ; 
        if (message.getP361() != null && message.getP361().size() > 0) {
            output.writeFLOATI32Map(361, message.getP361());
        }
        //dft map<float,u32> p362 = 362 ; 
        if (message.getP362() != null && message.getP362().size() > 0) {
            output.writeFLOATU32Map(362, message.getP362());
        }
        //dft map<float,s32> p363 = 363 ; 
        if (message.getP363() != null && message.getP363().size() > 0) {
            output.writeFLOATS32Map(363, message.getP363());
        }
        //dft map<float,f32> p364 = 364 ; 
        if (message.getP364() != null && message.getP364().size() > 0) {
            output.writeFLOATF32Map(364, message.getP364());
        }
        //dft map<float,sf32> p365 = 365 ; 
        if (message.getP365() != null && message.getP365().size() > 0) {
            output.writeFLOATSF32Map(365, message.getP365());
        }
        //dft map<float,i64> p366 = 366 ; 
        if (message.getP366() != null && message.getP366().size() > 0) {
            output.writeFLOATI64Map(366, message.getP366());
        }
        //dft map<float,u64> p367 = 367 ; 
        if (message.getP367() != null && message.getP367().size() > 0) {
            output.writeFLOATU64Map(367, message.getP367());
        }
        //dft map<float,s64> p368 = 368 ; 
        if (message.getP368() != null && message.getP368().size() > 0) {
            output.writeFLOATS64Map(368, message.getP368());
        }
        //dft map<float,f64> p369 = 369 ; 
        if (message.getP369() != null && message.getP369().size() > 0) {
            output.writeFLOATF64Map(369, message.getP369());
        }
        //dft map<float,sf64> p370 = 370 ; 
        if (message.getP370() != null && message.getP370().size() > 0) {
            output.writeFLOATSF64Map(370, message.getP370());
        }
        //dft map<float,string> p371 = 371 ; 
        if (message.getP371() != null && message.getP371().size() > 0) {
            output.writeFLOATSTRINGMap(371, message.getP371());
        }
        //dft map<float,double> p372 = 372 ; 
        if (message.getP372() != null && message.getP372().size() > 0) {
            output.writeFLOATDOUBLEMap(372, message.getP372());
        }
        //dft map<float,float> p373 = 373 ; 
        if (message.getP373() != null && message.getP373().size() > 0) {
            output.writeFLOATFLOATMap(373, message.getP373());
        }
        //dft map<i8,FullEnum0> p374 = 374 ; 
        if (message.getP374() != null && message.getP374().size() > 0) {
            for(Byte2ObjectMap.Entry<FullEnum0> entry : message.getP374().byte2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(374,() -> {
                    output.writeI8(entry.getByteKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i8,FullMessage0> p375 = 375 ; 
        if (message.getP375() != null && message.getP375().size() > 0) {
            for(Byte2ObjectMap.Entry<FullMessage0> entry : message.getP375().byte2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(375,() -> {
                    output.writeI8(entry.getByteKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i8,FullMessage0> p376 = 376 [ polymorphic=true ] ; 
        if (message.getP376() != null && message.getP376().size() > 0) {
            for(Byte2ObjectMap.Entry<FullMessage0> entry : message.getP376().byte2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(376,() -> {
                    output.writeI8(entry.getByteKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<u8,FullEnum0> p377 = 377 ; 
        if (message.getP377() != null && message.getP377().size() > 0) {
            for(Byte2ObjectMap.Entry<FullEnum0> entry : message.getP377().byte2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(377,() -> {
                    output.writeU8(entry.getByteKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u8,FullMessage0> p378 = 378 ; 
        if (message.getP378() != null && message.getP378().size() > 0) {
            for(Byte2ObjectMap.Entry<FullMessage0> entry : message.getP378().byte2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(378,() -> {
                    output.writeU8(entry.getByteKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u8,FullMessage0> p379 = 379 [ polymorphic=true ] ; 
        if (message.getP379() != null && message.getP379().size() > 0) {
            for(Byte2ObjectMap.Entry<FullMessage0> entry : message.getP379().byte2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(379,() -> {
                    output.writeU8(entry.getByteKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<i16,FullEnum0> p380 = 380 ; 
        if (message.getP380() != null && message.getP380().size() > 0) {
            for(Short2ObjectMap.Entry<FullEnum0> entry : message.getP380().short2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(380,() -> {
                    output.writeI16(entry.getShortKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i16,FullMessage0> p381 = 381 ; 
        if (message.getP381() != null && message.getP381().size() > 0) {
            for(Short2ObjectMap.Entry<FullMessage0> entry : message.getP381().short2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(381,() -> {
                    output.writeI16(entry.getShortKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i16,FullMessage0> p382 = 382 [ polymorphic=true ] ; 
        if (message.getP382() != null && message.getP382().size() > 0) {
            for(Short2ObjectMap.Entry<FullMessage0> entry : message.getP382().short2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(382,() -> {
                    output.writeI16(entry.getShortKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<u16,FullEnum0> p383 = 383 ; 
        if (message.getP383() != null && message.getP383().size() > 0) {
            for(Short2ObjectMap.Entry<FullEnum0> entry : message.getP383().short2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(383,() -> {
                    output.writeU16(entry.getShortKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u16,FullMessage0> p384 = 384 ; 
        if (message.getP384() != null && message.getP384().size() > 0) {
            for(Short2ObjectMap.Entry<FullMessage0> entry : message.getP384().short2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(384,() -> {
                    output.writeU16(entry.getShortKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u16,FullMessage0> p385 = 385 [ polymorphic=true ] ; 
        if (message.getP385() != null && message.getP385().size() > 0) {
            for(Short2ObjectMap.Entry<FullMessage0> entry : message.getP385().short2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(385,() -> {
                    output.writeU16(entry.getShortKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<i32,FullEnum0> p386 = 386 ; 
        if (message.getP386() != null && message.getP386().size() > 0) {
            for(Int2ObjectMap.Entry<FullEnum0> entry : message.getP386().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(386,() -> {
                    output.writeI32(entry.getIntKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i32,FullMessage0> p387 = 387 ; 
        if (message.getP387() != null && message.getP387().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP387().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(387,() -> {
                    output.writeI32(entry.getIntKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i32,FullMessage0> p388 = 388 [ polymorphic=true ] ; 
        if (message.getP388() != null && message.getP388().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP388().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(388,() -> {
                    output.writeI32(entry.getIntKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<u32,FullEnum0> p389 = 389 ; 
        if (message.getP389() != null && message.getP389().size() > 0) {
            for(Int2ObjectMap.Entry<FullEnum0> entry : message.getP389().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(389,() -> {
                    output.writeU32(entry.getIntKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u32,FullMessage0> p390 = 390 ; 
        if (message.getP390() != null && message.getP390().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP390().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(390,() -> {
                    output.writeU32(entry.getIntKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u32,FullMessage0> p391 = 391 [ polymorphic=true ] ; 
        if (message.getP391() != null && message.getP391().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP391().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(391,() -> {
                    output.writeU32(entry.getIntKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<s32,FullEnum0> p392 = 392 ; 
        if (message.getP392() != null && message.getP392().size() > 0) {
            for(Int2ObjectMap.Entry<FullEnum0> entry : message.getP392().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(392,() -> {
                    output.writeS32(entry.getIntKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<s32,FullMessage0> p393 = 393 ; 
        if (message.getP393() != null && message.getP393().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP393().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(393,() -> {
                    output.writeS32(entry.getIntKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<s32,FullMessage0> p394 = 394 [ polymorphic=true ] ; 
        if (message.getP394() != null && message.getP394().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP394().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(394,() -> {
                    output.writeS32(entry.getIntKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<f32,FullEnum0> p395 = 395 ; 
        if (message.getP395() != null && message.getP395().size() > 0) {
            for(Int2ObjectMap.Entry<FullEnum0> entry : message.getP395().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(395,() -> {
                    output.writeF32(entry.getIntKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<f32,FullMessage0> p396 = 396 ; 
        if (message.getP396() != null && message.getP396().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP396().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(396,() -> {
                    output.writeF32(entry.getIntKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<f32,FullMessage0> p397 = 397 [ polymorphic=true ] ; 
        if (message.getP397() != null && message.getP397().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP397().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(397,() -> {
                    output.writeF32(entry.getIntKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<sf32,FullEnum0> p398 = 398 ; 
        if (message.getP398() != null && message.getP398().size() > 0) {
            for(Int2ObjectMap.Entry<FullEnum0> entry : message.getP398().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(398,() -> {
                    output.writeSF32(entry.getIntKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<sf32,FullMessage0> p399 = 399 ; 
        if (message.getP399() != null && message.getP399().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP399().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(399,() -> {
                    output.writeSF32(entry.getIntKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<sf32,FullMessage0> p400 = 400 [ polymorphic=true ] ; 
        if (message.getP400() != null && message.getP400().size() > 0) {
            for(Int2ObjectMap.Entry<FullMessage0> entry : message.getP400().int2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(400,() -> {
                    output.writeSF32(entry.getIntKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<i64,FullEnum0> p401 = 401 ; 
        if (message.getP401() != null && message.getP401().size() > 0) {
            for(Long2ObjectMap.Entry<FullEnum0> entry : message.getP401().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(401,() -> {
                    output.writeI64(entry.getLongKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i64,FullMessage0> p402 = 402 ; 
        if (message.getP402() != null && message.getP402().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP402().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(402,() -> {
                    output.writeI64(entry.getLongKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<i64,FullMessage0> p403 = 403 [ polymorphic=true ] ; 
        if (message.getP403() != null && message.getP403().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP403().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(403,() -> {
                    output.writeI64(entry.getLongKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<u64,FullEnum0> p404 = 404 ; 
        if (message.getP404() != null && message.getP404().size() > 0) {
            for(Long2ObjectMap.Entry<FullEnum0> entry : message.getP404().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(404,() -> {
                    output.writeU64(entry.getLongKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u64,FullMessage0> p405 = 405 ; 
        if (message.getP405() != null && message.getP405().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP405().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(405,() -> {
                    output.writeU64(entry.getLongKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<u64,FullMessage0> p406 = 406 [ polymorphic=true ] ; 
        if (message.getP406() != null && message.getP406().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP406().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(406,() -> {
                    output.writeU64(entry.getLongKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<s64,FullEnum0> p407 = 407 ; 
        if (message.getP407() != null && message.getP407().size() > 0) {
            for(Long2ObjectMap.Entry<FullEnum0> entry : message.getP407().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(407,() -> {
                    output.writeS64(entry.getLongKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<s64,FullMessage0> p408 = 408 ; 
        if (message.getP408() != null && message.getP408().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP408().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(408,() -> {
                    output.writeS64(entry.getLongKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<s64,FullMessage0> p409 = 409 [ polymorphic=true ] ; 
        if (message.getP409() != null && message.getP409().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP409().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(409,() -> {
                    output.writeS64(entry.getLongKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<f64,FullEnum0> p410 = 410 ; 
        if (message.getP410() != null && message.getP410().size() > 0) {
            for(Long2ObjectMap.Entry<FullEnum0> entry : message.getP410().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(410,() -> {
                    output.writeF64(entry.getLongKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<f64,FullMessage0> p411 = 411 ; 
        if (message.getP411() != null && message.getP411().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP411().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(411,() -> {
                    output.writeF64(entry.getLongKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<f64,FullMessage0> p412 = 412 [ polymorphic=true ] ; 
        if (message.getP412() != null && message.getP412().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP412().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(412,() -> {
                    output.writeF64(entry.getLongKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<sf64,FullEnum0> p413 = 413 ; 
        if (message.getP413() != null && message.getP413().size() > 0) {
            for(Long2ObjectMap.Entry<FullEnum0> entry : message.getP413().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(413,() -> {
                    output.writeSF64(entry.getLongKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<sf64,FullMessage0> p414 = 414 ; 
        if (message.getP414() != null && message.getP414().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP414().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(414,() -> {
                    output.writeSF64(entry.getLongKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<sf64,FullMessage0> p415 = 415 [ polymorphic=true ] ; 
        if (message.getP415() != null && message.getP415().size() > 0) {
            for(Long2ObjectMap.Entry<FullMessage0> entry : message.getP415().long2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(415,() -> {
                    output.writeSF64(entry.getLongKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<string,FullEnum0> p416 = 416 ; 
        if (message.getP416() != null && message.getP416().size() > 0) {
            for(Map.Entry<String,FullEnum0> entry : message.getP416().entrySet()){
                if (entry.getKey() == null || entry.getValue() == null){
                    continue;
                }
                output.writeMessage(416,() -> {
                    output.writeSTRING(entry.getKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<string,FullMessage0> p417 = 417 ; 
        if (message.getP417() != null && message.getP417().size() > 0) {
            for(Map.Entry<String,FullMessage0> entry : message.getP417().entrySet()){
                if (entry.getKey() == null || entry.getValue() == null){
                    continue;
                }
                output.writeMessage(417,() -> {
                    output.writeSTRING(entry.getKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<string,FullMessage0> p418 = 418 [ polymorphic=true ] ; 
        if (message.getP418() != null && message.getP418().size() > 0) {
            for(Map.Entry<String,FullMessage0> entry : message.getP418().entrySet()){
                if (entry.getKey() == null || entry.getValue() == null){
                    continue;
                }
                output.writeMessage(418,() -> {
                    output.writeSTRING(entry.getKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<double,FullEnum0> p419 = 419 ; 
        if (message.getP419() != null && message.getP419().size() > 0) {
            for(Double2ObjectMap.Entry<FullEnum0> entry : message.getP419().double2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(419,() -> {
                    output.writeDOUBLE(entry.getDoubleKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<double,FullMessage0> p420 = 420 ; 
        if (message.getP420() != null && message.getP420().size() > 0) {
            for(Double2ObjectMap.Entry<FullMessage0> entry : message.getP420().double2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(420,() -> {
                    output.writeDOUBLE(entry.getDoubleKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<double,FullMessage0> p421 = 421 [ polymorphic=true ] ; 
        if (message.getP421() != null && message.getP421().size() > 0) {
            for(Double2ObjectMap.Entry<FullMessage0> entry : message.getP421().double2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(421,() -> {
                    output.writeDOUBLE(entry.getDoubleKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }
        //dft map<float,FullEnum0> p422 = 422 ; 
        if (message.getP422() != null && message.getP422().size() > 0) {
            for(Float2ObjectMap.Entry<FullEnum0> entry : message.getP422().float2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(422,() -> {
                    output.writeFLOAT(entry.getFloatKey());
                    FullEnum0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<float,FullMessage0> p423 = 423 ; 
        if (message.getP423() != null && message.getP423().size() > 0) {
            for(Float2ObjectMap.Entry<FullMessage0> entry : message.getP423().float2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(423,() -> {
                    output.writeFLOAT(entry.getFloatKey());
                    FullMessage0Schema.writeTo(output, entry.getValue(), false);
                });
            }
        }
        //dft map<float,FullMessage0> p424 = 424 [ polymorphic=true ] ; 
        if (message.getP424() != null && message.getP424().size() > 0) {
            for(Float2ObjectMap.Entry<FullMessage0> entry : message.getP424().float2ObjectEntrySet()){
                if (entry.getValue() == null) {
                    continue;
                }
                output.writeMessage(424,() -> {
                    output.writeFLOAT(entry.getFloatKey());
                    if (entry.getValue().getClass() == FullMessage0.class) {
                        FullMessage0Schema.writeTo(output, entry.getValue(),true);
                    } else if (entry.getValue().getClass() == FullMessage.class) {
                        FullMessageSchema.writeTo(output, (FullMessage)entry.getValue(), true);
                    } else if (entry.getValue().getClass() == FullMessage1.class) {
                        FullMessage1Schema.writeTo(output, (FullMessage1)entry.getValue(), true);
                    } else { 
                    throw new RuntimeException("undefine message"+ entry.getValue().getClass().getName());}
                });
            }
        }

    }

    @Override
    public Object mergeFrom(Input input, Object message) throws IOException {
        return mergeFrom(input, (FullMessage) message);
    }

    public static FullMessage mergeFrom(Input input, FullMessage msg) throws IOException {
        int fieldNumber = input.readFieldNumber();
        if (fieldNumber == 0) {
            return null;
        }
        if (msg == null) {
            msg = new FullMessage();
        }
        FullMessage message = msg;
        do {
            switch (fieldNumber) {
                // bool p1 = 1 ; 
                case 1: {
                    message.setP1(input.readBOOL());
                    break;
                }
                // i8 p2 = 2 ; 
                case 2: {
                    message.setP2(input.readI8());
                    break;
                }
                // u8 p3 = 3 ; 
                case 3: {
                    message.setP3(input.readU8());
                    break;
                }
                // i16 p4 = 4 ; 
                case 4: {
                    message.setP4(input.readI16());
                    break;
                }
                // u16 p5 = 5 ; 
                case 5: {
                    message.setP5(input.readU16());
                    break;
                }
                // i32 p6 = 6 ; 
                case 6: {
                    message.setP6(input.readI32());
                    break;
                }
                // u32 p7 = 7 ; 
                case 7: {
                    message.setP7(input.readU32());
                    break;
                }
                // s32 p8 = 8 ; 
                case 8: {
                    message.setP8(input.readS32());
                    break;
                }
                // f32 p9 = 9 ; 
                case 9: {
                    message.setP9(input.readF32());
                    break;
                }
                // sf32 p10 = 10 ; 
                case 10: {
                    message.setP10(input.readSF32());
                    break;
                }
                // i64 p11 = 11 ; 
                case 11: {
                    message.setP11(input.readI64());
                    break;
                }
                // u64 p12 = 12 ; 
                case 12: {
                    message.setP12(input.readU64());
                    break;
                }
                // s64 p13 = 13 ; 
                case 13: {
                    message.setP13(input.readS64());
                    break;
                }
                // f64 p14 = 14 ; 
                case 14: {
                    message.setP14(input.readF64());
                    break;
                }
                // sf64 p15 = 15 ; 
                case 15: {
                    message.setP15(input.readSF64());
                    break;
                }
                // string p16 = 16 ; 
                case 16: {
                    message.setP16(input.readSTRING());
                    break;
                }
                // double p17 = 17 ; 
                case 17: {
                    message.setP17(input.readDOUBLE());
                    break;
                }
                // float p18 = 18 ; 
                case 18: {
                    message.setP18(input.readFLOAT());
                    break;
                }
                // FullEnum0 p19 = 19 ; 
                case 19: {
                    message.setP19(FullEnum0Schema.mergeFrom(input,null));
                    break;
                }
                // FullMessage0 p20 = 20 ; 
                case 20: {
                    final int oldLimit = input.readMessageStart();
                    message.setP20(FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //arr bool p21 = 21 ; 
                case 21: {
                    message.setP21(input.readBOOLArray());
                    break;
                }
                //arr i8 p22 = 22 ; 
                case 22: {
                    message.setP22(input.readI8Array());
                    break;
                }
                //arr u8 p23 = 23 ; 
                case 23: {
                    message.setP23(input.readU8Array());
                    break;
                }
                //arr i16 p24 = 24 ; 
                case 24: {
                    message.setP24(input.readI16Array());
                    break;
                }
                //arr u16 p25 = 25 ; 
                case 25: {
                    message.setP25(input.readU16Array());
                    break;
                }
                //arr i32 p26 = 26 ; 
                case 26: {
                    message.setP26(input.readI32Array());
                    break;
                }
                //arr u32 p27 = 27 ; 
                case 27: {
                    message.setP27(input.readU32Array());
                    break;
                }
                //arr s32 p28 = 28 ; 
                case 28: {
                    message.setP28(input.readS32Array());
                    break;
                }
                //arr f32 p29 = 29 ; 
                case 29: {
                    message.setP29(input.readF32Array());
                    break;
                }
                //arr sf32 p30 = 30 ; 
                case 30: {
                    message.setP30(input.readSF32Array());
                    break;
                }
                //arr i64 p31 = 31 ; 
                case 31: {
                    message.setP31(input.readI64Array());
                    break;
                }
                //arr u64 p32 = 32 ; 
                case 32: {
                    message.setP32(input.readU64Array());
                    break;
                }
                //arr s64 p33 = 33 ; 
                case 33: {
                    message.setP33(input.readS64Array());
                    break;
                }
                //arr f64 p34 = 34 ; 
                case 34: {
                    message.setP34(input.readF64Array());
                    break;
                }
                //arr sf64 p35 = 35 ; 
                case 35: {
                    message.setP35(input.readSF64Array());
                    break;
                }
                //arr string p36 = 36 ; 
                case 36: {
                    message.setP36(input.readSTRINGArray());
                    break;
                }
                //arr double p37 = 37 ; 
                case 37: {
                    message.setP37(input.readDOUBLEArray());
                    break;
                }
                //arr float p38 = 38 ; 
                case 38: {
                    message.setP38(input.readFLOATArray());
                    break;
                }
                //arr FullEnum0 p39 = 39 ; 
                case 39: {
                    int index = input.readI32();
                    if (message.getP39() == null) {
                        message.setP39(new FullEnum0[index + 1]);
                    }
                    do{
                        message.getP39()[index] = FullEnum0Schema.mergeFrom(input,null);
                        if (index == 0){
                            break;
                        }
                    } while ((index = input.readI32()) >=0);
                    break;
                }
                //arr FullMessage0 p40 = 40 ; 
                case 40: {
                    final int oldLimit = input.readMessageStart();
                    int index = input.readI32();
                    if (message.getP40() == null) {
                        message.setP40(new FullMessage0[index + 1]);
                    }
                    message.getP40()[index] = FullMessage0Schema.mergeFrom(input,null);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //set bool p41 = 41 ; 
                case 41: {
                    message.setP41(input.readBOOLSet());
                    break;
                }
                //set i8 p42 = 42 ; 
                case 42: {
                    message.setP42(input.readI8Set());
                    break;
                }
                //set u8 p43 = 43 ; 
                case 43: {
                    message.setP43(input.readU8Set());
                    break;
                }
                //set i16 p44 = 44 ; 
                case 44: {
                    message.setP44(input.readI16Set());
                    break;
                }
                //set u16 p45 = 45 ; 
                case 45: {
                    message.setP45(input.readU16Set());
                    break;
                }
                //set i32 p46 = 46 ; 
                case 46: {
                    message.setP46(input.readI32Set());
                    break;
                }
                //set u32 p47 = 47 ; 
                case 47: {
                    message.setP47(input.readU32Set());
                    break;
                }
                //set s32 p48 = 48 ; 
                case 48: {
                    message.setP48(input.readS32Set());
                    break;
                }
                //set f32 p49 = 49 ; 
                case 49: {
                    message.setP49(input.readF32Set());
                    break;
                }
                //set sf32 p50 = 50 ; 
                case 50: {
                    message.setP50(input.readSF32Set());
                    break;
                }
                //set i64 p51 = 51 ; 
                case 51: {
                    message.setP51(input.readI64Set());
                    break;
                }
                //set u64 p52 = 52 ; 
                case 52: {
                    message.setP52(input.readU64Set());
                    break;
                }
                //set s64 p53 = 53 ; 
                case 53: {
                    message.setP53(input.readS64Set());
                    break;
                }
                //set f64 p54 = 54 ; 
                case 54: {
                    message.setP54(input.readF64Set());
                    break;
                }
                //set sf64 p55 = 55 ; 
                case 55: {
                    message.setP55(input.readSF64Set());
                    break;
                }
                //set string p56 = 56 ; 
                case 56: {
                    message.setP56(input.readSTRINGSet());
                    break;
                }
                //set double p57 = 57 ; 
                case 57: {
                    message.setP57(input.readDOUBLESet());
                    break;
                }
                //set float p58 = 58 ; 
                case 58: {
                    message.setP58(input.readFLOATSet());
                    break;
                }
                //set FullEnum0 p59 = 59 ; 
                case 59: {
                    if (message.getP59() == null) {
                        message.setP59(EnumSet.noneOf(FullEnum0.class));
                    }
                    message.getP59().add(FullEnum0Schema.mergeFrom(input,null));;
                    break;
                }
                //set FullMessage0 p60 = 60 ; 
                case 60: {
                    if (message.getP60() == null) {
                        message.setP60(new HashSet<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    message.getP60().add(FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //lst bool p61 = 61 ; 
                case 61: {
                    message.setP61(input.readBOOLList());
                    break;
                }
                //lst i8 p62 = 62 ; 
                case 62: {
                    message.setP62(input.readI8List());
                    break;
                }
                //lst u8 p63 = 63 ; 
                case 63: {
                    message.setP63(input.readU8List());
                    break;
                }
                //lst i16 p64 = 64 ; 
                case 64: {
                    message.setP64(input.readI16List());
                    break;
                }
                //lst u16 p65 = 65 ; 
                case 65: {
                    message.setP65(input.readU16List());
                    break;
                }
                //lst i32 p66 = 66 ; 
                case 66: {
                    message.setP66(input.readI32List());
                    break;
                }
                //lst u32 p67 = 67 ; 
                case 67: {
                    message.setP67(input.readU32List());
                    break;
                }
                //lst s32 p68 = 68 ; 
                case 68: {
                    message.setP68(input.readS32List());
                    break;
                }
                //lst f32 p69 = 69 ; 
                case 69: {
                    message.setP69(input.readF32List());
                    break;
                }
                //lst sf32 p70 = 70 ; 
                case 70: {
                    message.setP70(input.readSF32List());
                    break;
                }
                //lst i64 p71 = 71 ; 
                case 71: {
                    message.setP71(input.readI64List());
                    break;
                }
                //lst u64 p72 = 72 ; 
                case 72: {
                    message.setP72(input.readU64List());
                    break;
                }
                //lst s64 p73 = 73 ; 
                case 73: {
                    message.setP73(input.readS64List());
                    break;
                }
                //lst f64 p74 = 74 ; 
                case 74: {
                    message.setP74(input.readF64List());
                    break;
                }
                //lst sf64 p75 = 75 ; 
                case 75: {
                    message.setP75(input.readSF64List());
                    break;
                }
                //lst string p76 = 76 ; 
                case 76: {
                    message.setP76(input.readSTRINGList());
                    break;
                }
                //lst double p77 = 77 ; 
                case 77: {
                    message.setP77(input.readDOUBLEList());
                    break;
                }
                //lst float p78 = 78 ; 
                case 78: {
                    message.setP78(input.readFLOATList());
                    break;
                }
                //lst FullEnum0 p79 = 79 ; 
                case 79: {
                    if (message.getP79() == null) {
                        message.setP79(new ArrayList<>());
                    }
                    message.getP79().add(FullEnum0Schema.mergeFrom(input,null));;
                    break;
                }
                //lst FullMessage0 p80 = 80 ; 
                case 80: {
                    if (message.getP80() == null) {
                        message.setP80(new ArrayList<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    message.getP80().add(FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //ext FullMessage0 p81 = 81 ; 
                case 81: {
                    final int oldLimit = input.readMessageStart();
                    FullMessage0Schema.mergeFrom(input,message);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //set FullMessage0 p82 = 82 [ polymorphic=true ] ; 
                case 82: {
                    if (message.getP82() == null) {
                        message.setP82(new HashSet<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP82().add(packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //arr FullMessage0 p83 = 83 [ polymorphic=true ] ; 
                case 83: {
                    final int oldLimit = input.readMessageStart();
                    int index = input.readI32();
                    if (message.getP83() == null) {
                        message.setP83(new FullMessage0[index + 1]);
                    }
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP83()[index] = packValue;
                    input.readMessageStop(oldLimit);
                    break;
                }
                //lst FullMessage0 p84 = 84 [ polymorphic=true ] ; 
                case 84: {
                    if (message.getP84() == null) {
                        message.setP84(new ArrayList<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP84().add(packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i8,i8> p85 = 85 ; 
                case 85: {
                    message.setP85(input.readI8I8Map());
                    break;
                }
                //dft map<i8,u8> p86 = 86 ; 
                case 86: {
                    message.setP86(input.readI8U8Map());
                    break;
                }
                //dft map<i8,i16> p87 = 87 ; 
                case 87: {
                    message.setP87(input.readI8I16Map());
                    break;
                }
                //dft map<i8,u16> p88 = 88 ; 
                case 88: {
                    message.setP88(input.readI8U16Map());
                    break;
                }
                //dft map<i8,i32> p89 = 89 ; 
                case 89: {
                    message.setP89(input.readI8I32Map());
                    break;
                }
                //dft map<i8,u32> p90 = 90 ; 
                case 90: {
                    message.setP90(input.readI8U32Map());
                    break;
                }
                //dft map<i8,s32> p91 = 91 ; 
                case 91: {
                    message.setP91(input.readI8S32Map());
                    break;
                }
                //dft map<i8,f32> p92 = 92 ; 
                case 92: {
                    message.setP92(input.readI8F32Map());
                    break;
                }
                //dft map<i8,sf32> p93 = 93 ; 
                case 93: {
                    message.setP93(input.readI8SF32Map());
                    break;
                }
                //dft map<i8,i64> p94 = 94 ; 
                case 94: {
                    message.setP94(input.readI8I64Map());
                    break;
                }
                //dft map<i8,u64> p95 = 95 ; 
                case 95: {
                    message.setP95(input.readI8U64Map());
                    break;
                }
                //dft map<i8,s64> p96 = 96 ; 
                case 96: {
                    message.setP96(input.readI8S64Map());
                    break;
                }
                //dft map<i8,f64> p97 = 97 ; 
                case 97: {
                    message.setP97(input.readI8F64Map());
                    break;
                }
                //dft map<i8,sf64> p98 = 98 ; 
                case 98: {
                    message.setP98(input.readI8SF64Map());
                    break;
                }
                //dft map<i8,string> p99 = 99 ; 
                case 99: {
                    message.setP99(input.readI8STRINGMap());
                    break;
                }
                //dft map<i8,double> p100 = 100 ; 
                case 100: {
                    message.setP100(input.readI8DOUBLEMap());
                    break;
                }
                //dft map<i8,float> p101 = 101 ; 
                case 101: {
                    message.setP101(input.readI8FLOATMap());
                    break;
                }
                //dft map<u8,i8> p102 = 102 ; 
                case 102: {
                    message.setP102(input.readU8I8Map());
                    break;
                }
                //dft map<u8,u8> p103 = 103 ; 
                case 103: {
                    message.setP103(input.readU8U8Map());
                    break;
                }
                //dft map<u8,i16> p104 = 104 ; 
                case 104: {
                    message.setP104(input.readU8I16Map());
                    break;
                }
                //dft map<u8,u16> p105 = 105 ; 
                case 105: {
                    message.setP105(input.readU8U16Map());
                    break;
                }
                //dft map<u8,i32> p106 = 106 ; 
                case 106: {
                    message.setP106(input.readU8I32Map());
                    break;
                }
                //dft map<u8,u32> p107 = 107 ; 
                case 107: {
                    message.setP107(input.readU8U32Map());
                    break;
                }
                //dft map<u8,s32> p108 = 108 ; 
                case 108: {
                    message.setP108(input.readU8S32Map());
                    break;
                }
                //dft map<u8,f32> p109 = 109 ; 
                case 109: {
                    message.setP109(input.readU8F32Map());
                    break;
                }
                //dft map<u8,sf32> p110 = 110 ; 
                case 110: {
                    message.setP110(input.readU8SF32Map());
                    break;
                }
                //dft map<u8,i64> p111 = 111 ; 
                case 111: {
                    message.setP111(input.readU8I64Map());
                    break;
                }
                //dft map<u8,u64> p112 = 112 ; 
                case 112: {
                    message.setP112(input.readU8U64Map());
                    break;
                }
                //dft map<u8,s64> p113 = 113 ; 
                case 113: {
                    message.setP113(input.readU8S64Map());
                    break;
                }
                //dft map<u8,f64> p114 = 114 ; 
                case 114: {
                    message.setP114(input.readU8F64Map());
                    break;
                }
                //dft map<u8,sf64> p115 = 115 ; 
                case 115: {
                    message.setP115(input.readU8SF64Map());
                    break;
                }
                //dft map<u8,string> p116 = 116 ; 
                case 116: {
                    message.setP116(input.readU8STRINGMap());
                    break;
                }
                //dft map<u8,double> p117 = 117 ; 
                case 117: {
                    message.setP117(input.readU8DOUBLEMap());
                    break;
                }
                //dft map<u8,float> p118 = 118 ; 
                case 118: {
                    message.setP118(input.readU8FLOATMap());
                    break;
                }
                //dft map<i16,i8> p119 = 119 ; 
                case 119: {
                    message.setP119(input.readI16I8Map());
                    break;
                }
                //dft map<i16,u8> p120 = 120 ; 
                case 120: {
                    message.setP120(input.readI16U8Map());
                    break;
                }
                //dft map<i16,i16> p121 = 121 ; 
                case 121: {
                    message.setP121(input.readI16I16Map());
                    break;
                }
                //dft map<i16,u16> p122 = 122 ; 
                case 122: {
                    message.setP122(input.readI16U16Map());
                    break;
                }
                //dft map<i16,i32> p123 = 123 ; 
                case 123: {
                    message.setP123(input.readI16I32Map());
                    break;
                }
                //dft map<i16,u32> p124 = 124 ; 
                case 124: {
                    message.setP124(input.readI16U32Map());
                    break;
                }
                //dft map<i16,s32> p125 = 125 ; 
                case 125: {
                    message.setP125(input.readI16S32Map());
                    break;
                }
                //dft map<i16,f32> p126 = 126 ; 
                case 126: {
                    message.setP126(input.readI16F32Map());
                    break;
                }
                //dft map<i16,sf32> p127 = 127 ; 
                case 127: {
                    message.setP127(input.readI16SF32Map());
                    break;
                }
                //dft map<i16,i64> p128 = 128 ; 
                case 128: {
                    message.setP128(input.readI16I64Map());
                    break;
                }
                //dft map<i16,u64> p129 = 129 ; 
                case 129: {
                    message.setP129(input.readI16U64Map());
                    break;
                }
                //dft map<i16,s64> p130 = 130 ; 
                case 130: {
                    message.setP130(input.readI16S64Map());
                    break;
                }
                //dft map<i16,f64> p131 = 131 ; 
                case 131: {
                    message.setP131(input.readI16F64Map());
                    break;
                }
                //dft map<i16,sf64> p132 = 132 ; 
                case 132: {
                    message.setP132(input.readI16SF64Map());
                    break;
                }
                //dft map<i16,string> p133 = 133 ; 
                case 133: {
                    message.setP133(input.readI16STRINGMap());
                    break;
                }
                //dft map<i16,double> p134 = 134 ; 
                case 134: {
                    message.setP134(input.readI16DOUBLEMap());
                    break;
                }
                //dft map<i16,float> p135 = 135 ; 
                case 135: {
                    message.setP135(input.readI16FLOATMap());
                    break;
                }
                //dft map<u16,i8> p136 = 136 ; 
                case 136: {
                    message.setP136(input.readU16I8Map());
                    break;
                }
                //dft map<u16,u8> p137 = 137 ; 
                case 137: {
                    message.setP137(input.readU16U8Map());
                    break;
                }
                //dft map<u16,i16> p138 = 138 ; 
                case 138: {
                    message.setP138(input.readU16I16Map());
                    break;
                }
                //dft map<u16,u16> p139 = 139 ; 
                case 139: {
                    message.setP139(input.readU16U16Map());
                    break;
                }
                //dft map<u16,i32> p140 = 140 ; 
                case 140: {
                    message.setP140(input.readU16I32Map());
                    break;
                }
                //dft map<u16,u32> p141 = 141 ; 
                case 141: {
                    message.setP141(input.readU16U32Map());
                    break;
                }
                //dft map<u16,s32> p142 = 142 ; 
                case 142: {
                    message.setP142(input.readU16S32Map());
                    break;
                }
                //dft map<u16,f32> p143 = 143 ; 
                case 143: {
                    message.setP143(input.readU16F32Map());
                    break;
                }
                //dft map<u16,sf32> p144 = 144 ; 
                case 144: {
                    message.setP144(input.readU16SF32Map());
                    break;
                }
                //dft map<u16,i64> p145 = 145 ; 
                case 145: {
                    message.setP145(input.readU16I64Map());
                    break;
                }
                //dft map<u16,u64> p146 = 146 ; 
                case 146: {
                    message.setP146(input.readU16U64Map());
                    break;
                }
                //dft map<u16,s64> p147 = 147 ; 
                case 147: {
                    message.setP147(input.readU16S64Map());
                    break;
                }
                //dft map<u16,f64> p148 = 148 ; 
                case 148: {
                    message.setP148(input.readU16F64Map());
                    break;
                }
                //dft map<u16,sf64> p149 = 149 ; 
                case 149: {
                    message.setP149(input.readU16SF64Map());
                    break;
                }
                //dft map<u16,string> p150 = 150 ; 
                case 150: {
                    message.setP150(input.readU16STRINGMap());
                    break;
                }
                //dft map<u16,double> p151 = 151 ; 
                case 151: {
                    message.setP151(input.readU16DOUBLEMap());
                    break;
                }
                //dft map<u16,float> p152 = 152 ; 
                case 152: {
                    message.setP152(input.readU16FLOATMap());
                    break;
                }
                //dft map<i32,i8> p153 = 153 ; 
                case 153: {
                    message.setP153(input.readI32I8Map());
                    break;
                }
                //dft map<i32,u8> p154 = 154 ; 
                case 154: {
                    message.setP154(input.readI32U8Map());
                    break;
                }
                //dft map<i32,i16> p155 = 155 ; 
                case 155: {
                    message.setP155(input.readI32I16Map());
                    break;
                }
                //dft map<i32,u16> p156 = 156 ; 
                case 156: {
                    message.setP156(input.readI32U16Map());
                    break;
                }
                //dft map<i32,i32> p157 = 157 ; 
                case 157: {
                    message.setP157(input.readI32I32Map());
                    break;
                }
                //dft map<i32,u32> p158 = 158 ; 
                case 158: {
                    message.setP158(input.readI32U32Map());
                    break;
                }
                //dft map<i32,s32> p159 = 159 ; 
                case 159: {
                    message.setP159(input.readI32S32Map());
                    break;
                }
                //dft map<i32,f32> p160 = 160 ; 
                case 160: {
                    message.setP160(input.readI32F32Map());
                    break;
                }
                //dft map<i32,sf32> p161 = 161 ; 
                case 161: {
                    message.setP161(input.readI32SF32Map());
                    break;
                }
                //dft map<i32,i64> p162 = 162 ; 
                case 162: {
                    message.setP162(input.readI32I64Map());
                    break;
                }
                //dft map<i32,u64> p163 = 163 ; 
                case 163: {
                    message.setP163(input.readI32U64Map());
                    break;
                }
                //dft map<i32,s64> p164 = 164 ; 
                case 164: {
                    message.setP164(input.readI32S64Map());
                    break;
                }
                //dft map<i32,f64> p165 = 165 ; 
                case 165: {
                    message.setP165(input.readI32F64Map());
                    break;
                }
                //dft map<i32,sf64> p166 = 166 ; 
                case 166: {
                    message.setP166(input.readI32SF64Map());
                    break;
                }
                //dft map<i32,string> p167 = 167 ; 
                case 167: {
                    message.setP167(input.readI32STRINGMap());
                    break;
                }
                //dft map<i32,double> p168 = 168 ; 
                case 168: {
                    message.setP168(input.readI32DOUBLEMap());
                    break;
                }
                //dft map<i32,float> p169 = 169 ; 
                case 169: {
                    message.setP169(input.readI32FLOATMap());
                    break;
                }
                //dft map<u32,i8> p170 = 170 ; 
                case 170: {
                    message.setP170(input.readU32I8Map());
                    break;
                }
                //dft map<u32,u8> p171 = 171 ; 
                case 171: {
                    message.setP171(input.readU32U8Map());
                    break;
                }
                //dft map<u32,i16> p172 = 172 ; 
                case 172: {
                    message.setP172(input.readU32I16Map());
                    break;
                }
                //dft map<u32,u16> p173 = 173 ; 
                case 173: {
                    message.setP173(input.readU32U16Map());
                    break;
                }
                //dft map<u32,i32> p174 = 174 ; 
                case 174: {
                    message.setP174(input.readU32I32Map());
                    break;
                }
                //dft map<u32,u32> p175 = 175 ; 
                case 175: {
                    message.setP175(input.readU32U32Map());
                    break;
                }
                //dft map<u32,s32> p176 = 176 ; 
                case 176: {
                    message.setP176(input.readU32S32Map());
                    break;
                }
                //dft map<u32,f32> p177 = 177 ; 
                case 177: {
                    message.setP177(input.readU32F32Map());
                    break;
                }
                //dft map<u32,sf32> p178 = 178 ; 
                case 178: {
                    message.setP178(input.readU32SF32Map());
                    break;
                }
                //dft map<u32,i64> p179 = 179 ; 
                case 179: {
                    message.setP179(input.readU32I64Map());
                    break;
                }
                //dft map<u32,u64> p180 = 180 ; 
                case 180: {
                    message.setP180(input.readU32U64Map());
                    break;
                }
                //dft map<u32,s64> p181 = 181 ; 
                case 181: {
                    message.setP181(input.readU32S64Map());
                    break;
                }
                //dft map<u32,f64> p182 = 182 ; 
                case 182: {
                    message.setP182(input.readU32F64Map());
                    break;
                }
                //dft map<u32,sf64> p183 = 183 ; 
                case 183: {
                    message.setP183(input.readU32SF64Map());
                    break;
                }
                //dft map<u32,string> p184 = 184 ; 
                case 184: {
                    message.setP184(input.readU32STRINGMap());
                    break;
                }
                //dft map<u32,double> p185 = 185 ; 
                case 185: {
                    message.setP185(input.readU32DOUBLEMap());
                    break;
                }
                //dft map<u32,float> p186 = 186 ; 
                case 186: {
                    message.setP186(input.readU32FLOATMap());
                    break;
                }
                //dft map<s32,i8> p187 = 187 ; 
                case 187: {
                    message.setP187(input.readS32I8Map());
                    break;
                }
                //dft map<s32,u8> p188 = 188 ; 
                case 188: {
                    message.setP188(input.readS32U8Map());
                    break;
                }
                //dft map<s32,i16> p189 = 189 ; 
                case 189: {
                    message.setP189(input.readS32I16Map());
                    break;
                }
                //dft map<s32,u16> p190 = 190 ; 
                case 190: {
                    message.setP190(input.readS32U16Map());
                    break;
                }
                //dft map<s32,i32> p191 = 191 ; 
                case 191: {
                    message.setP191(input.readS32I32Map());
                    break;
                }
                //dft map<s32,u32> p192 = 192 ; 
                case 192: {
                    message.setP192(input.readS32U32Map());
                    break;
                }
                //dft map<s32,s32> p193 = 193 ; 
                case 193: {
                    message.setP193(input.readS32S32Map());
                    break;
                }
                //dft map<s32,f32> p194 = 194 ; 
                case 194: {
                    message.setP194(input.readS32F32Map());
                    break;
                }
                //dft map<s32,sf32> p195 = 195 ; 
                case 195: {
                    message.setP195(input.readS32SF32Map());
                    break;
                }
                //dft map<s32,i64> p196 = 196 ; 
                case 196: {
                    message.setP196(input.readS32I64Map());
                    break;
                }
                //dft map<s32,u64> p197 = 197 ; 
                case 197: {
                    message.setP197(input.readS32U64Map());
                    break;
                }
                //dft map<s32,s64> p198 = 198 ; 
                case 198: {
                    message.setP198(input.readS32S64Map());
                    break;
                }
                //dft map<s32,f64> p199 = 199 ; 
                case 199: {
                    message.setP199(input.readS32F64Map());
                    break;
                }
                //dft map<s32,sf64> p200 = 200 ; 
                case 200: {
                    message.setP200(input.readS32SF64Map());
                    break;
                }
                //dft map<s32,string> p201 = 201 ; 
                case 201: {
                    message.setP201(input.readS32STRINGMap());
                    break;
                }
                //dft map<s32,double> p202 = 202 ; 
                case 202: {
                    message.setP202(input.readS32DOUBLEMap());
                    break;
                }
                //dft map<s32,float> p203 = 203 ; 
                case 203: {
                    message.setP203(input.readS32FLOATMap());
                    break;
                }
                //dft map<f32,i8> p204 = 204 ; 
                case 204: {
                    message.setP204(input.readF32I8Map());
                    break;
                }
                //dft map<f32,u8> p205 = 205 ; 
                case 205: {
                    message.setP205(input.readF32U8Map());
                    break;
                }
                //dft map<f32,i16> p206 = 206 ; 
                case 206: {
                    message.setP206(input.readF32I16Map());
                    break;
                }
                //dft map<f32,u16> p207 = 207 ; 
                case 207: {
                    message.setP207(input.readF32U16Map());
                    break;
                }
                //dft map<f32,i32> p208 = 208 ; 
                case 208: {
                    message.setP208(input.readF32I32Map());
                    break;
                }
                //dft map<f32,u32> p209 = 209 ; 
                case 209: {
                    message.setP209(input.readF32U32Map());
                    break;
                }
                //dft map<f32,s32> p210 = 210 ; 
                case 210: {
                    message.setP210(input.readF32S32Map());
                    break;
                }
                //dft map<f32,f32> p211 = 211 ; 
                case 211: {
                    message.setP211(input.readF32F32Map());
                    break;
                }
                //dft map<f32,sf32> p212 = 212 ; 
                case 212: {
                    message.setP212(input.readF32SF32Map());
                    break;
                }
                //dft map<f32,i64> p213 = 213 ; 
                case 213: {
                    message.setP213(input.readF32I64Map());
                    break;
                }
                //dft map<f32,u64> p214 = 214 ; 
                case 214: {
                    message.setP214(input.readF32U64Map());
                    break;
                }
                //dft map<f32,s64> p215 = 215 ; 
                case 215: {
                    message.setP215(input.readF32S64Map());
                    break;
                }
                //dft map<f32,f64> p216 = 216 ; 
                case 216: {
                    message.setP216(input.readF32F64Map());
                    break;
                }
                //dft map<f32,sf64> p217 = 217 ; 
                case 217: {
                    message.setP217(input.readF32SF64Map());
                    break;
                }
                //dft map<f32,string> p218 = 218 ; 
                case 218: {
                    message.setP218(input.readF32STRINGMap());
                    break;
                }
                //dft map<f32,double> p219 = 219 ; 
                case 219: {
                    message.setP219(input.readF32DOUBLEMap());
                    break;
                }
                //dft map<f32,float> p220 = 220 ; 
                case 220: {
                    message.setP220(input.readF32FLOATMap());
                    break;
                }
                //dft map<sf32,i8> p221 = 221 ; 
                case 221: {
                    message.setP221(input.readSF32I8Map());
                    break;
                }
                //dft map<sf32,u8> p222 = 222 ; 
                case 222: {
                    message.setP222(input.readSF32U8Map());
                    break;
                }
                //dft map<sf32,i16> p223 = 223 ; 
                case 223: {
                    message.setP223(input.readSF32I16Map());
                    break;
                }
                //dft map<sf32,u16> p224 = 224 ; 
                case 224: {
                    message.setP224(input.readSF32U16Map());
                    break;
                }
                //dft map<sf32,i32> p225 = 225 ; 
                case 225: {
                    message.setP225(input.readSF32I32Map());
                    break;
                }
                //dft map<sf32,u32> p226 = 226 ; 
                case 226: {
                    message.setP226(input.readSF32U32Map());
                    break;
                }
                //dft map<sf32,s32> p227 = 227 ; 
                case 227: {
                    message.setP227(input.readSF32S32Map());
                    break;
                }
                //dft map<sf32,f32> p228 = 228 ; 
                case 228: {
                    message.setP228(input.readSF32F32Map());
                    break;
                }
                //dft map<sf32,sf32> p229 = 229 ; 
                case 229: {
                    message.setP229(input.readSF32SF32Map());
                    break;
                }
                //dft map<sf32,i64> p230 = 230 ; 
                case 230: {
                    message.setP230(input.readSF32I64Map());
                    break;
                }
                //dft map<sf32,u64> p231 = 231 ; 
                case 231: {
                    message.setP231(input.readSF32U64Map());
                    break;
                }
                //dft map<sf32,s64> p232 = 232 ; 
                case 232: {
                    message.setP232(input.readSF32S64Map());
                    break;
                }
                //dft map<sf32,f64> p233 = 233 ; 
                case 233: {
                    message.setP233(input.readSF32F64Map());
                    break;
                }
                //dft map<sf32,sf64> p234 = 234 ; 
                case 234: {
                    message.setP234(input.readSF32SF64Map());
                    break;
                }
                //dft map<sf32,string> p235 = 235 ; 
                case 235: {
                    message.setP235(input.readSF32STRINGMap());
                    break;
                }
                //dft map<sf32,double> p236 = 236 ; 
                case 236: {
                    message.setP236(input.readSF32DOUBLEMap());
                    break;
                }
                //dft map<sf32,float> p237 = 237 ; 
                case 237: {
                    message.setP237(input.readSF32FLOATMap());
                    break;
                }
                //dft map<i64,i8> p238 = 238 ; 
                case 238: {
                    message.setP238(input.readI64I8Map());
                    break;
                }
                //dft map<i64,u8> p239 = 239 ; 
                case 239: {
                    message.setP239(input.readI64U8Map());
                    break;
                }
                //dft map<i64,i16> p240 = 240 ; 
                case 240: {
                    message.setP240(input.readI64I16Map());
                    break;
                }
                //dft map<i64,u16> p241 = 241 ; 
                case 241: {
                    message.setP241(input.readI64U16Map());
                    break;
                }
                //dft map<i64,i32> p242 = 242 ; 
                case 242: {
                    message.setP242(input.readI64I32Map());
                    break;
                }
                //dft map<i64,u32> p243 = 243 ; 
                case 243: {
                    message.setP243(input.readI64U32Map());
                    break;
                }
                //dft map<i64,s32> p244 = 244 ; 
                case 244: {
                    message.setP244(input.readI64S32Map());
                    break;
                }
                //dft map<i64,f32> p245 = 245 ; 
                case 245: {
                    message.setP245(input.readI64F32Map());
                    break;
                }
                //dft map<i64,sf32> p246 = 246 ; 
                case 246: {
                    message.setP246(input.readI64SF32Map());
                    break;
                }
                //dft map<i64,i64> p247 = 247 ; 
                case 247: {
                    message.setP247(input.readI64I64Map());
                    break;
                }
                //dft map<i64,u64> p248 = 248 ; 
                case 248: {
                    message.setP248(input.readI64U64Map());
                    break;
                }
                //dft map<i64,s64> p249 = 249 ; 
                case 249: {
                    message.setP249(input.readI64S64Map());
                    break;
                }
                //dft map<i64,f64> p250 = 250 ; 
                case 250: {
                    message.setP250(input.readI64F64Map());
                    break;
                }
                //dft map<i64,sf64> p251 = 251 ; 
                case 251: {
                    message.setP251(input.readI64SF64Map());
                    break;
                }
                //dft map<i64,string> p252 = 252 ; 
                case 252: {
                    message.setP252(input.readI64STRINGMap());
                    break;
                }
                //dft map<i64,double> p253 = 253 ; 
                case 253: {
                    message.setP253(input.readI64DOUBLEMap());
                    break;
                }
                //dft map<i64,float> p254 = 254 ; 
                case 254: {
                    message.setP254(input.readI64FLOATMap());
                    break;
                }
                //dft map<u64,i8> p255 = 255 ; 
                case 255: {
                    message.setP255(input.readU64I8Map());
                    break;
                }
                //dft map<u64,u8> p256 = 256 ; 
                case 256: {
                    message.setP256(input.readU64U8Map());
                    break;
                }
                //dft map<u64,i16> p257 = 257 ; 
                case 257: {
                    message.setP257(input.readU64I16Map());
                    break;
                }
                //dft map<u64,u16> p258 = 258 ; 
                case 258: {
                    message.setP258(input.readU64U16Map());
                    break;
                }
                //dft map<u64,i32> p259 = 259 ; 
                case 259: {
                    message.setP259(input.readU64I32Map());
                    break;
                }
                //dft map<u64,u32> p260 = 260 ; 
                case 260: {
                    message.setP260(input.readU64U32Map());
                    break;
                }
                //dft map<u64,s32> p261 = 261 ; 
                case 261: {
                    message.setP261(input.readU64S32Map());
                    break;
                }
                //dft map<u64,f32> p262 = 262 ; 
                case 262: {
                    message.setP262(input.readU64F32Map());
                    break;
                }
                //dft map<u64,sf32> p263 = 263 ; 
                case 263: {
                    message.setP263(input.readU64SF32Map());
                    break;
                }
                //dft map<u64,i64> p264 = 264 ; 
                case 264: {
                    message.setP264(input.readU64I64Map());
                    break;
                }
                //dft map<u64,u64> p265 = 265 ; 
                case 265: {
                    message.setP265(input.readU64U64Map());
                    break;
                }
                //dft map<u64,s64> p266 = 266 ; 
                case 266: {
                    message.setP266(input.readU64S64Map());
                    break;
                }
                //dft map<u64,f64> p267 = 267 ; 
                case 267: {
                    message.setP267(input.readU64F64Map());
                    break;
                }
                //dft map<u64,sf64> p268 = 268 ; 
                case 268: {
                    message.setP268(input.readU64SF64Map());
                    break;
                }
                //dft map<u64,string> p269 = 269 ; 
                case 269: {
                    message.setP269(input.readU64STRINGMap());
                    break;
                }
                //dft map<u64,double> p270 = 270 ; 
                case 270: {
                    message.setP270(input.readU64DOUBLEMap());
                    break;
                }
                //dft map<u64,float> p271 = 271 ; 
                case 271: {
                    message.setP271(input.readU64FLOATMap());
                    break;
                }
                //dft map<s64,i8> p272 = 272 ; 
                case 272: {
                    message.setP272(input.readS64I8Map());
                    break;
                }
                //dft map<s64,u8> p273 = 273 ; 
                case 273: {
                    message.setP273(input.readS64U8Map());
                    break;
                }
                //dft map<s64,i16> p274 = 274 ; 
                case 274: {
                    message.setP274(input.readS64I16Map());
                    break;
                }
                //dft map<s64,u16> p275 = 275 ; 
                case 275: {
                    message.setP275(input.readS64U16Map());
                    break;
                }
                //dft map<s64,i32> p276 = 276 ; 
                case 276: {
                    message.setP276(input.readS64I32Map());
                    break;
                }
                //dft map<s64,u32> p277 = 277 ; 
                case 277: {
                    message.setP277(input.readS64U32Map());
                    break;
                }
                //dft map<s64,s32> p278 = 278 ; 
                case 278: {
                    message.setP278(input.readS64S32Map());
                    break;
                }
                //dft map<s64,f32> p279 = 279 ; 
                case 279: {
                    message.setP279(input.readS64F32Map());
                    break;
                }
                //dft map<s64,sf32> p280 = 280 ; 
                case 280: {
                    message.setP280(input.readS64SF32Map());
                    break;
                }
                //dft map<s64,i64> p281 = 281 ; 
                case 281: {
                    message.setP281(input.readS64I64Map());
                    break;
                }
                //dft map<s64,u64> p282 = 282 ; 
                case 282: {
                    message.setP282(input.readS64U64Map());
                    break;
                }
                //dft map<s64,s64> p283 = 283 ; 
                case 283: {
                    message.setP283(input.readS64S64Map());
                    break;
                }
                //dft map<s64,f64> p284 = 284 ; 
                case 284: {
                    message.setP284(input.readS64F64Map());
                    break;
                }
                //dft map<s64,sf64> p285 = 285 ; 
                case 285: {
                    message.setP285(input.readS64SF64Map());
                    break;
                }
                //dft map<s64,string> p286 = 286 ; 
                case 286: {
                    message.setP286(input.readS64STRINGMap());
                    break;
                }
                //dft map<s64,double> p287 = 287 ; 
                case 287: {
                    message.setP287(input.readS64DOUBLEMap());
                    break;
                }
                //dft map<s64,float> p288 = 288 ; 
                case 288: {
                    message.setP288(input.readS64FLOATMap());
                    break;
                }
                //dft map<f64,i8> p289 = 289 ; 
                case 289: {
                    message.setP289(input.readF64I8Map());
                    break;
                }
                //dft map<f64,u8> p290 = 290 ; 
                case 290: {
                    message.setP290(input.readF64U8Map());
                    break;
                }
                //dft map<f64,i16> p291 = 291 ; 
                case 291: {
                    message.setP291(input.readF64I16Map());
                    break;
                }
                //dft map<f64,u16> p292 = 292 ; 
                case 292: {
                    message.setP292(input.readF64U16Map());
                    break;
                }
                //dft map<f64,i32> p293 = 293 ; 
                case 293: {
                    message.setP293(input.readF64I32Map());
                    break;
                }
                //dft map<f64,u32> p294 = 294 ; 
                case 294: {
                    message.setP294(input.readF64U32Map());
                    break;
                }
                //dft map<f64,s32> p295 = 295 ; 
                case 295: {
                    message.setP295(input.readF64S32Map());
                    break;
                }
                //dft map<f64,f32> p296 = 296 ; 
                case 296: {
                    message.setP296(input.readF64F32Map());
                    break;
                }
                //dft map<f64,sf32> p297 = 297 ; 
                case 297: {
                    message.setP297(input.readF64SF32Map());
                    break;
                }
                //dft map<f64,i64> p298 = 298 ; 
                case 298: {
                    message.setP298(input.readF64I64Map());
                    break;
                }
                //dft map<f64,u64> p299 = 299 ; 
                case 299: {
                    message.setP299(input.readF64U64Map());
                    break;
                }
                //dft map<f64,s64> p300 = 300 ; 
                case 300: {
                    message.setP300(input.readF64S64Map());
                    break;
                }
                //dft map<f64,f64> p301 = 301 ; 
                case 301: {
                    message.setP301(input.readF64F64Map());
                    break;
                }
                //dft map<f64,sf64> p302 = 302 ; 
                case 302: {
                    message.setP302(input.readF64SF64Map());
                    break;
                }
                //dft map<f64,string> p303 = 303 ; 
                case 303: {
                    message.setP303(input.readF64STRINGMap());
                    break;
                }
                //dft map<f64,double> p304 = 304 ; 
                case 304: {
                    message.setP304(input.readF64DOUBLEMap());
                    break;
                }
                //dft map<f64,float> p305 = 305 ; 
                case 305: {
                    message.setP305(input.readF64FLOATMap());
                    break;
                }
                //dft map<sf64,i8> p306 = 306 ; 
                case 306: {
                    message.setP306(input.readSF64I8Map());
                    break;
                }
                //dft map<sf64,u8> p307 = 307 ; 
                case 307: {
                    message.setP307(input.readSF64U8Map());
                    break;
                }
                //dft map<sf64,i16> p308 = 308 ; 
                case 308: {
                    message.setP308(input.readSF64I16Map());
                    break;
                }
                //dft map<sf64,u16> p309 = 309 ; 
                case 309: {
                    message.setP309(input.readSF64U16Map());
                    break;
                }
                //dft map<sf64,i32> p310 = 310 ; 
                case 310: {
                    message.setP310(input.readSF64I32Map());
                    break;
                }
                //dft map<sf64,u32> p311 = 311 ; 
                case 311: {
                    message.setP311(input.readSF64U32Map());
                    break;
                }
                //dft map<sf64,s32> p312 = 312 ; 
                case 312: {
                    message.setP312(input.readSF64S32Map());
                    break;
                }
                //dft map<sf64,f32> p313 = 313 ; 
                case 313: {
                    message.setP313(input.readSF64F32Map());
                    break;
                }
                //dft map<sf64,sf32> p314 = 314 ; 
                case 314: {
                    message.setP314(input.readSF64SF32Map());
                    break;
                }
                //dft map<sf64,i64> p315 = 315 ; 
                case 315: {
                    message.setP315(input.readSF64I64Map());
                    break;
                }
                //dft map<sf64,u64> p316 = 316 ; 
                case 316: {
                    message.setP316(input.readSF64U64Map());
                    break;
                }
                //dft map<sf64,s64> p317 = 317 ; 
                case 317: {
                    message.setP317(input.readSF64S64Map());
                    break;
                }
                //dft map<sf64,f64> p318 = 318 ; 
                case 318: {
                    message.setP318(input.readSF64F64Map());
                    break;
                }
                //dft map<sf64,sf64> p319 = 319 ; 
                case 319: {
                    message.setP319(input.readSF64SF64Map());
                    break;
                }
                //dft map<sf64,string> p320 = 320 ; 
                case 320: {
                    message.setP320(input.readSF64STRINGMap());
                    break;
                }
                //dft map<sf64,double> p321 = 321 ; 
                case 321: {
                    message.setP321(input.readSF64DOUBLEMap());
                    break;
                }
                //dft map<sf64,float> p322 = 322 ; 
                case 322: {
                    message.setP322(input.readSF64FLOATMap());
                    break;
                }
                //dft map<string,i8> p323 = 323 ; 
                case 323: {
                    message.setP323(input.readSTRINGI8Map());
                    break;
                }
                //dft map<string,u8> p324 = 324 ; 
                case 324: {
                    message.setP324(input.readSTRINGU8Map());
                    break;
                }
                //dft map<string,i16> p325 = 325 ; 
                case 325: {
                    message.setP325(input.readSTRINGI16Map());
                    break;
                }
                //dft map<string,u16> p326 = 326 ; 
                case 326: {
                    message.setP326(input.readSTRINGU16Map());
                    break;
                }
                //dft map<string,i32> p327 = 327 ; 
                case 327: {
                    message.setP327(input.readSTRINGI32Map());
                    break;
                }
                //dft map<string,u32> p328 = 328 ; 
                case 328: {
                    message.setP328(input.readSTRINGU32Map());
                    break;
                }
                //dft map<string,s32> p329 = 329 ; 
                case 329: {
                    message.setP329(input.readSTRINGS32Map());
                    break;
                }
                //dft map<string,f32> p330 = 330 ; 
                case 330: {
                    message.setP330(input.readSTRINGF32Map());
                    break;
                }
                //dft map<string,sf32> p331 = 331 ; 
                case 331: {
                    message.setP331(input.readSTRINGSF32Map());
                    break;
                }
                //dft map<string,i64> p332 = 332 ; 
                case 332: {
                    message.setP332(input.readSTRINGI64Map());
                    break;
                }
                //dft map<string,u64> p333 = 333 ; 
                case 333: {
                    message.setP333(input.readSTRINGU64Map());
                    break;
                }
                //dft map<string,s64> p334 = 334 ; 
                case 334: {
                    message.setP334(input.readSTRINGS64Map());
                    break;
                }
                //dft map<string,f64> p335 = 335 ; 
                case 335: {
                    message.setP335(input.readSTRINGF64Map());
                    break;
                }
                //dft map<string,sf64> p336 = 336 ; 
                case 336: {
                    message.setP336(input.readSTRINGSF64Map());
                    break;
                }
                //dft map<string,string> p337 = 337 ; 
                case 337: {
                    message.setP337(input.readSTRINGSTRINGMap());
                    break;
                }
                //dft map<string,double> p338 = 338 ; 
                case 338: {
                    message.setP338(input.readSTRINGDOUBLEMap());
                    break;
                }
                //dft map<string,float> p339 = 339 ; 
                case 339: {
                    message.setP339(input.readSTRINGFLOATMap());
                    break;
                }
                //dft map<double,i8> p340 = 340 ; 
                case 340: {
                    message.setP340(input.readDOUBLEI8Map());
                    break;
                }
                //dft map<double,u8> p341 = 341 ; 
                case 341: {
                    message.setP341(input.readDOUBLEU8Map());
                    break;
                }
                //dft map<double,i16> p342 = 342 ; 
                case 342: {
                    message.setP342(input.readDOUBLEI16Map());
                    break;
                }
                //dft map<double,u16> p343 = 343 ; 
                case 343: {
                    message.setP343(input.readDOUBLEU16Map());
                    break;
                }
                //dft map<double,i32> p344 = 344 ; 
                case 344: {
                    message.setP344(input.readDOUBLEI32Map());
                    break;
                }
                //dft map<double,u32> p345 = 345 ; 
                case 345: {
                    message.setP345(input.readDOUBLEU32Map());
                    break;
                }
                //dft map<double,s32> p346 = 346 ; 
                case 346: {
                    message.setP346(input.readDOUBLES32Map());
                    break;
                }
                //dft map<double,f32> p347 = 347 ; 
                case 347: {
                    message.setP347(input.readDOUBLEF32Map());
                    break;
                }
                //dft map<double,sf32> p348 = 348 ; 
                case 348: {
                    message.setP348(input.readDOUBLESF32Map());
                    break;
                }
                //dft map<double,i64> p349 = 349 ; 
                case 349: {
                    message.setP349(input.readDOUBLEI64Map());
                    break;
                }
                //dft map<double,u64> p350 = 350 ; 
                case 350: {
                    message.setP350(input.readDOUBLEU64Map());
                    break;
                }
                //dft map<double,s64> p351 = 351 ; 
                case 351: {
                    message.setP351(input.readDOUBLES64Map());
                    break;
                }
                //dft map<double,f64> p352 = 352 ; 
                case 352: {
                    message.setP352(input.readDOUBLEF64Map());
                    break;
                }
                //dft map<double,sf64> p353 = 353 ; 
                case 353: {
                    message.setP353(input.readDOUBLESF64Map());
                    break;
                }
                //dft map<double,string> p354 = 354 ; 
                case 354: {
                    message.setP354(input.readDOUBLESTRINGMap());
                    break;
                }
                //dft map<double,double> p355 = 355 ; 
                case 355: {
                    message.setP355(input.readDOUBLEDOUBLEMap());
                    break;
                }
                //dft map<double,float> p356 = 356 ; 
                case 356: {
                    message.setP356(input.readDOUBLEFLOATMap());
                    break;
                }
                //dft map<float,i8> p357 = 357 ; 
                case 357: {
                    message.setP357(input.readFLOATI8Map());
                    break;
                }
                //dft map<float,u8> p358 = 358 ; 
                case 358: {
                    message.setP358(input.readFLOATU8Map());
                    break;
                }
                //dft map<float,i16> p359 = 359 ; 
                case 359: {
                    message.setP359(input.readFLOATI16Map());
                    break;
                }
                //dft map<float,u16> p360 = 360 ; 
                case 360: {
                    message.setP360(input.readFLOATU16Map());
                    break;
                }
                //dft map<float,i32> p361 = 361 ; 
                case 361: {
                    message.setP361(input.readFLOATI32Map());
                    break;
                }
                //dft map<float,u32> p362 = 362 ; 
                case 362: {
                    message.setP362(input.readFLOATU32Map());
                    break;
                }
                //dft map<float,s32> p363 = 363 ; 
                case 363: {
                    message.setP363(input.readFLOATS32Map());
                    break;
                }
                //dft map<float,f32> p364 = 364 ; 
                case 364: {
                    message.setP364(input.readFLOATF32Map());
                    break;
                }
                //dft map<float,sf32> p365 = 365 ; 
                case 365: {
                    message.setP365(input.readFLOATSF32Map());
                    break;
                }
                //dft map<float,i64> p366 = 366 ; 
                case 366: {
                    message.setP366(input.readFLOATI64Map());
                    break;
                }
                //dft map<float,u64> p367 = 367 ; 
                case 367: {
                    message.setP367(input.readFLOATU64Map());
                    break;
                }
                //dft map<float,s64> p368 = 368 ; 
                case 368: {
                    message.setP368(input.readFLOATS64Map());
                    break;
                }
                //dft map<float,f64> p369 = 369 ; 
                case 369: {
                    message.setP369(input.readFLOATF64Map());
                    break;
                }
                //dft map<float,sf64> p370 = 370 ; 
                case 370: {
                    message.setP370(input.readFLOATSF64Map());
                    break;
                }
                //dft map<float,string> p371 = 371 ; 
                case 371: {
                    message.setP371(input.readFLOATSTRINGMap());
                    break;
                }
                //dft map<float,double> p372 = 372 ; 
                case 372: {
                    message.setP372(input.readFLOATDOUBLEMap());
                    break;
                }
                //dft map<float,float> p373 = 373 ; 
                case 373: {
                    message.setP373(input.readFLOATFLOATMap());
                    break;
                }
                //dft map<i8,FullEnum0> p374 = 374 ; 
                case 374: {
                    if (message.getP374() == null) {
                        message.setP374(new Byte2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    byte key = input.readI8();
                    message.getP374().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i8,FullMessage0> p375 = 375 ; 
                case 375: {
                    if (message.getP375() == null) {
                        message.setP375(new Byte2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    byte key = input.readI8();
                    message.getP375().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i8,FullMessage0> p376 = 376 [ polymorphic=true ] ; 
                case 376: {
                    if (message.getP376() == null) {
                        message.setP376(new Byte2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    byte key = input.readI8();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP376().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u8,FullEnum0> p377 = 377 ; 
                case 377: {
                    if (message.getP377() == null) {
                        message.setP377(new Byte2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    byte key = input.readU8();
                    message.getP377().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u8,FullMessage0> p378 = 378 ; 
                case 378: {
                    if (message.getP378() == null) {
                        message.setP378(new Byte2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    byte key = input.readU8();
                    message.getP378().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u8,FullMessage0> p379 = 379 [ polymorphic=true ] ; 
                case 379: {
                    if (message.getP379() == null) {
                        message.setP379(new Byte2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    byte key = input.readU8();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP379().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i16,FullEnum0> p380 = 380 ; 
                case 380: {
                    if (message.getP380() == null) {
                        message.setP380(new Short2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    short key = input.readI16();
                    message.getP380().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i16,FullMessage0> p381 = 381 ; 
                case 381: {
                    if (message.getP381() == null) {
                        message.setP381(new Short2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    short key = input.readI16();
                    message.getP381().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i16,FullMessage0> p382 = 382 [ polymorphic=true ] ; 
                case 382: {
                    if (message.getP382() == null) {
                        message.setP382(new Short2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    short key = input.readI16();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP382().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u16,FullEnum0> p383 = 383 ; 
                case 383: {
                    if (message.getP383() == null) {
                        message.setP383(new Short2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    short key = input.readU16();
                    message.getP383().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u16,FullMessage0> p384 = 384 ; 
                case 384: {
                    if (message.getP384() == null) {
                        message.setP384(new Short2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    short key = input.readU16();
                    message.getP384().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u16,FullMessage0> p385 = 385 [ polymorphic=true ] ; 
                case 385: {
                    if (message.getP385() == null) {
                        message.setP385(new Short2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    short key = input.readU16();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP385().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i32,FullEnum0> p386 = 386 ; 
                case 386: {
                    if (message.getP386() == null) {
                        message.setP386(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readI32();
                    message.getP386().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i32,FullMessage0> p387 = 387 ; 
                case 387: {
                    if (message.getP387() == null) {
                        message.setP387(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readI32();
                    message.getP387().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i32,FullMessage0> p388 = 388 [ polymorphic=true ] ; 
                case 388: {
                    if (message.getP388() == null) {
                        message.setP388(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readI32();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP388().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u32,FullEnum0> p389 = 389 ; 
                case 389: {
                    if (message.getP389() == null) {
                        message.setP389(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readU32();
                    message.getP389().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u32,FullMessage0> p390 = 390 ; 
                case 390: {
                    if (message.getP390() == null) {
                        message.setP390(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readU32();
                    message.getP390().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u32,FullMessage0> p391 = 391 [ polymorphic=true ] ; 
                case 391: {
                    if (message.getP391() == null) {
                        message.setP391(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readU32();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP391().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<s32,FullEnum0> p392 = 392 ; 
                case 392: {
                    if (message.getP392() == null) {
                        message.setP392(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readS32();
                    message.getP392().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<s32,FullMessage0> p393 = 393 ; 
                case 393: {
                    if (message.getP393() == null) {
                        message.setP393(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readS32();
                    message.getP393().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<s32,FullMessage0> p394 = 394 [ polymorphic=true ] ; 
                case 394: {
                    if (message.getP394() == null) {
                        message.setP394(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readS32();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP394().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<f32,FullEnum0> p395 = 395 ; 
                case 395: {
                    if (message.getP395() == null) {
                        message.setP395(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readF32();
                    message.getP395().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<f32,FullMessage0> p396 = 396 ; 
                case 396: {
                    if (message.getP396() == null) {
                        message.setP396(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readF32();
                    message.getP396().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<f32,FullMessage0> p397 = 397 [ polymorphic=true ] ; 
                case 397: {
                    if (message.getP397() == null) {
                        message.setP397(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readF32();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP397().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<sf32,FullEnum0> p398 = 398 ; 
                case 398: {
                    if (message.getP398() == null) {
                        message.setP398(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readSF32();
                    message.getP398().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<sf32,FullMessage0> p399 = 399 ; 
                case 399: {
                    if (message.getP399() == null) {
                        message.setP399(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readSF32();
                    message.getP399().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<sf32,FullMessage0> p400 = 400 [ polymorphic=true ] ; 
                case 400: {
                    if (message.getP400() == null) {
                        message.setP400(new Int2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    int key = input.readSF32();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP400().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i64,FullEnum0> p401 = 401 ; 
                case 401: {
                    if (message.getP401() == null) {
                        message.setP401(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readI64();
                    message.getP401().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i64,FullMessage0> p402 = 402 ; 
                case 402: {
                    if (message.getP402() == null) {
                        message.setP402(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readI64();
                    message.getP402().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<i64,FullMessage0> p403 = 403 [ polymorphic=true ] ; 
                case 403: {
                    if (message.getP403() == null) {
                        message.setP403(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readI64();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP403().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u64,FullEnum0> p404 = 404 ; 
                case 404: {
                    if (message.getP404() == null) {
                        message.setP404(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readU64();
                    message.getP404().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u64,FullMessage0> p405 = 405 ; 
                case 405: {
                    if (message.getP405() == null) {
                        message.setP405(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readU64();
                    message.getP405().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<u64,FullMessage0> p406 = 406 [ polymorphic=true ] ; 
                case 406: {
                    if (message.getP406() == null) {
                        message.setP406(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readU64();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP406().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<s64,FullEnum0> p407 = 407 ; 
                case 407: {
                    if (message.getP407() == null) {
                        message.setP407(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readS64();
                    message.getP407().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<s64,FullMessage0> p408 = 408 ; 
                case 408: {
                    if (message.getP408() == null) {
                        message.setP408(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readS64();
                    message.getP408().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<s64,FullMessage0> p409 = 409 [ polymorphic=true ] ; 
                case 409: {
                    if (message.getP409() == null) {
                        message.setP409(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readS64();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP409().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<f64,FullEnum0> p410 = 410 ; 
                case 410: {
                    if (message.getP410() == null) {
                        message.setP410(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readF64();
                    message.getP410().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<f64,FullMessage0> p411 = 411 ; 
                case 411: {
                    if (message.getP411() == null) {
                        message.setP411(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readF64();
                    message.getP411().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<f64,FullMessage0> p412 = 412 [ polymorphic=true ] ; 
                case 412: {
                    if (message.getP412() == null) {
                        message.setP412(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readF64();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP412().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<sf64,FullEnum0> p413 = 413 ; 
                case 413: {
                    if (message.getP413() == null) {
                        message.setP413(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readSF64();
                    message.getP413().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<sf64,FullMessage0> p414 = 414 ; 
                case 414: {
                    if (message.getP414() == null) {
                        message.setP414(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readSF64();
                    message.getP414().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<sf64,FullMessage0> p415 = 415 [ polymorphic=true ] ; 
                case 415: {
                    if (message.getP415() == null) {
                        message.setP415(new Long2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    long key = input.readSF64();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP415().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<string,FullEnum0> p416 = 416 ; 
                case 416: {
                    if (message.getP416() == null) {
                        message.setP416(new HashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    String key = input.readSTRING();
                    message.getP416().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<string,FullMessage0> p417 = 417 ; 
                case 417: {
                    if (message.getP417() == null) {
                        message.setP417(new HashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    String key = input.readSTRING();
                    message.getP417().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<string,FullMessage0> p418 = 418 [ polymorphic=true ] ; 
                case 418: {
                    if (message.getP418() == null) {
                        message.setP418(new HashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    String key = input.readSTRING();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP418().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<double,FullEnum0> p419 = 419 ; 
                case 419: {
                    if (message.getP419() == null) {
                        message.setP419(new Double2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    double key = input.readDOUBLE();
                    message.getP419().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<double,FullMessage0> p420 = 420 ; 
                case 420: {
                    if (message.getP420() == null) {
                        message.setP420(new Double2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    double key = input.readDOUBLE();
                    message.getP420().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<double,FullMessage0> p421 = 421 [ polymorphic=true ] ; 
                case 421: {
                    if (message.getP421() == null) {
                        message.setP421(new Double2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    double key = input.readDOUBLE();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP421().put(key, packValue);
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<float,FullEnum0> p422 = 422 ; 
                case 422: {
                    if (message.getP422() == null) {
                        message.setP422(new Float2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    float key = input.readFLOAT();
                    message.getP422().put(key, FullEnum0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<float,FullMessage0> p423 = 423 ; 
                case 423: {
                    if (message.getP423() == null) {
                        message.setP423(new Float2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    float key = input.readFLOAT();
                    message.getP423().put(key, FullMessage0Schema.mergeFrom(input,null));
                    input.readMessageStop(oldLimit);
                    break;
                }
                //dft map<float,FullMessage0> p424 = 424 [ polymorphic=true ] ; 
                case 424: {
                    if (message.getP424() == null) {
                        message.setP424(new Float2ObjectOpenHashMap<>());
                    }
                    final int oldLimit = input.readMessageStart();
                    float key = input.readFLOAT();
                    int msgIndex = input.readI32();
                    FullMessage0 packValue = null;
                    switch(msgIndex) {
                        case 0 :{
                            packValue = FullMessage0Schema.mergeFrom(input,null);
                            break;
                        }
                        case 2 :{
                            packValue = FullMessageSchema.mergeFrom(input,null);
                            break;
                        }
                        case 1 :{
                            packValue = FullMessage1Schema.mergeFrom(input,null);
                            break;
                        }
                        default: {
                            input.handleUnknownPolymorphicField(msgIndex);
                            break;
                        }
                    }
                    message.getP424().put(key, packValue);
                    input.readMessageStop(oldLimit);
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

