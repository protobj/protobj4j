package test;

import it.unimi.dsi.fastutil.booleans.BooleanList;
import it.unimi.dsi.fastutil.booleans.BooleanSet;
import it.unimi.dsi.fastutil.bytes.Byte2ByteMap;
import it.unimi.dsi.fastutil.bytes.Byte2DoubleMap;
import it.unimi.dsi.fastutil.bytes.Byte2FloatMap;
import it.unimi.dsi.fastutil.bytes.Byte2IntMap;
import it.unimi.dsi.fastutil.bytes.Byte2LongMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import it.unimi.dsi.fastutil.bytes.ByteList;
import it.unimi.dsi.fastutil.bytes.ByteSet;
import it.unimi.dsi.fastutil.doubles.Double2ByteMap;
import it.unimi.dsi.fastutil.doubles.Double2DoubleMap;
import it.unimi.dsi.fastutil.doubles.Double2FloatMap;
import it.unimi.dsi.fastutil.doubles.Double2IntMap;
import it.unimi.dsi.fastutil.doubles.Double2LongMap;
import it.unimi.dsi.fastutil.doubles.Double2ObjectMap;
import it.unimi.dsi.fastutil.doubles.Double2ShortMap;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.floats.Float2ByteMap;
import it.unimi.dsi.fastutil.floats.Float2DoubleMap;
import it.unimi.dsi.fastutil.floats.Float2FloatMap;
import it.unimi.dsi.fastutil.floats.Float2IntMap;
import it.unimi.dsi.fastutil.floats.Float2LongMap;
import it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import it.unimi.dsi.fastutil.floats.Float2ShortMap;
import it.unimi.dsi.fastutil.floats.FloatList;
import it.unimi.dsi.fastutil.floats.FloatSet;
import it.unimi.dsi.fastutil.ints.Int2ByteMap;
import it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import it.unimi.dsi.fastutil.ints.Int2FloatMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2LongMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ShortMap;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.longs.Long2ByteMap;
import it.unimi.dsi.fastutil.longs.Long2DoubleMap;
import it.unimi.dsi.fastutil.longs.Long2FloatMap;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.Long2LongMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ShortMap;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.Object2ByteMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2ShortMap;
import it.unimi.dsi.fastutil.shorts.Short2ByteMap;
import it.unimi.dsi.fastutil.shorts.Short2DoubleMap;
import it.unimi.dsi.fastutil.shorts.Short2FloatMap;
import it.unimi.dsi.fastutil.shorts.Short2IntMap;
import it.unimi.dsi.fastutil.shorts.Short2LongMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ShortMap;
import it.unimi.dsi.fastutil.shorts.ShortList;
import it.unimi.dsi.fastutil.shorts.ShortSet;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//ext FullMessage0 p81 = 81 ; 
public class FullMessage extends FullMessage0 {

    // bool p1 = 1 ; 
    private boolean p1;

    // i8 p2 = 2 ; 
    private byte p2;

    // u8 p3 = 3 ; 
    private byte p3;

    // i16 p4 = 4 ; 
    private short p4;

    // u16 p5 = 5 ; 
    private short p5;

    // i32 p6 = 6 ; 
    private int p6;

    // u32 p7 = 7 ; 
    private int p7;

    // s32 p8 = 8 ; 
    private int p8;

    // f32 p9 = 9 ; 
    private int p9;

    // sf32 p10 = 10 ; 
    private int p10;

    // i64 p11 = 11 ; 
    private long p11;

    // u64 p12 = 12 ; 
    private long p12;

    // s64 p13 = 13 ; 
    private long p13;

    // f64 p14 = 14 ; 
    private long p14;

    // sf64 p15 = 15 ; 
    private long p15;

    // string p16 = 16 ; 
    private String p16;

    // double p17 = 17 ; 
    private double p17;

    // float p18 = 18 ; 
    private float p18;

    // FullEnum0 p19 = 19 ; 
    private FullEnum0 p19;

    // FullMessage0 p20 = 20 ; 
    private FullMessage0 p20;

    //arr bool p21 = 21 ; 
    private boolean[] p21;

    //arr i8 p22 = 22 ; 
    private byte[] p22;

    //arr u8 p23 = 23 ; 
    private byte[] p23;

    //arr i16 p24 = 24 ; 
    private short[] p24;

    //arr u16 p25 = 25 ; 
    private short[] p25;

    //arr i32 p26 = 26 ; 
    private int[] p26;

    //arr u32 p27 = 27 ; 
    private int[] p27;

    //arr s32 p28 = 28 ; 
    private int[] p28;

    //arr f32 p29 = 29 ; 
    private int[] p29;

    //arr sf32 p30 = 30 ; 
    private int[] p30;

    //arr i64 p31 = 31 ; 
    private long[] p31;

    //arr u64 p32 = 32 ; 
    private long[] p32;

    //arr s64 p33 = 33 ; 
    private long[] p33;

    //arr f64 p34 = 34 ; 
    private long[] p34;

    //arr sf64 p35 = 35 ; 
    private long[] p35;

    //arr string p36 = 36 ; 
    private String[] p36;

    //arr double p37 = 37 ; 
    private double[] p37;

    //arr float p38 = 38 ; 
    private float[] p38;

    //arr FullEnum0 p39 = 39 ; 
    private FullEnum0[] p39;

    //arr FullMessage0 p40 = 40 ; 
    private FullMessage0[] p40;

    //set bool p41 = 41 ; 
    private BooleanSet p41;

    //set i8 p42 = 42 ; 
    private ByteSet p42;

    //set u8 p43 = 43 ; 
    private ByteSet p43;

    //set i16 p44 = 44 ; 
    private ShortSet p44;

    //set u16 p45 = 45 ; 
    private ShortSet p45;

    //set i32 p46 = 46 ; 
    private IntSet p46;

    //set u32 p47 = 47 ; 
    private IntSet p47;

    //set s32 p48 = 48 ; 
    private IntSet p48;

    //set f32 p49 = 49 ; 
    private IntSet p49;

    //set sf32 p50 = 50 ; 
    private IntSet p50;

    //set i64 p51 = 51 ; 
    private LongSet p51;

    //set u64 p52 = 52 ; 
    private LongSet p52;

    //set s64 p53 = 53 ; 
    private LongSet p53;

    //set f64 p54 = 54 ; 
    private LongSet p54;

    //set sf64 p55 = 55 ; 
    private LongSet p55;

    //set string p56 = 56 ; 
    private Set<String> p56;

    //set double p57 = 57 ; 
    private DoubleSet p57;

    //set float p58 = 58 ; 
    private FloatSet p58;

    //set FullEnum0 p59 = 59 ; 
    private EnumSet<FullEnum0> p59;

    //set FullMessage0 p60 = 60 ; 
    private Set<FullMessage0> p60;

    //lst bool p61 = 61 ; 
    private BooleanList p61;

    //lst i8 p62 = 62 ; 
    private ByteList p62;

    //lst u8 p63 = 63 ; 
    private ByteList p63;

    //lst i16 p64 = 64 ; 
    private ShortList p64;

    //lst u16 p65 = 65 ; 
    private ShortList p65;

    //lst i32 p66 = 66 ; 
    private IntList p66;

    //lst u32 p67 = 67 ; 
    private IntList p67;

    //lst s32 p68 = 68 ; 
    private IntList p68;

    //lst f32 p69 = 69 ; 
    private IntList p69;

    //lst sf32 p70 = 70 ; 
    private IntList p70;

    //lst i64 p71 = 71 ; 
    private LongList p71;

    //lst u64 p72 = 72 ; 
    private LongList p72;

    //lst s64 p73 = 73 ; 
    private LongList p73;

    //lst f64 p74 = 74 ; 
    private LongList p74;

    //lst sf64 p75 = 75 ; 
    private LongList p75;

    //lst string p76 = 76 ; 
    private List<String> p76;

    //lst double p77 = 77 ; 
    private DoubleList p77;

    //lst float p78 = 78 ; 
    private FloatList p78;

    //lst FullEnum0 p79 = 79 ; 
    private List<FullEnum0> p79;

    //lst FullMessage0 p80 = 80 ; 
    private List<FullMessage0> p80;

    //set FullMessage0 p82 = 82 [ polymorphic=true ] ; 
    private Set<FullMessage0> p82;

    //arr FullMessage0 p83 = 83 [ polymorphic=true ] ; 
    private FullMessage0[] p83;

    //lst FullMessage0 p84 = 84 [ polymorphic=true ] ; 
    private List<FullMessage0> p84;

    //dft map<i8,i8> p85 = 85 ; 
    private Byte2ByteMap p85;

    //dft map<i8,u8> p86 = 86 ; 
    private Byte2ByteMap p86;

    //dft map<i8,i16> p87 = 87 ; 
    private Byte2ShortMap p87;

    //dft map<i8,u16> p88 = 88 ; 
    private Byte2ShortMap p88;

    //dft map<i8,i32> p89 = 89 ; 
    private Byte2IntMap p89;

    //dft map<i8,u32> p90 = 90 ; 
    private Byte2IntMap p90;

    //dft map<i8,s32> p91 = 91 ; 
    private Byte2IntMap p91;

    //dft map<i8,f32> p92 = 92 ; 
    private Byte2IntMap p92;

    //dft map<i8,sf32> p93 = 93 ; 
    private Byte2IntMap p93;

    //dft map<i8,i64> p94 = 94 ; 
    private Byte2LongMap p94;

    //dft map<i8,u64> p95 = 95 ; 
    private Byte2LongMap p95;

    //dft map<i8,s64> p96 = 96 ; 
    private Byte2LongMap p96;

    //dft map<i8,f64> p97 = 97 ; 
    private Byte2LongMap p97;

    //dft map<i8,sf64> p98 = 98 ; 
    private Byte2LongMap p98;

    //dft map<i8,string> p99 = 99 ; 
    private Byte2ObjectMap<String> p99;

    //dft map<i8,double> p100 = 100 ; 
    private Byte2DoubleMap p100;

    //dft map<i8,float> p101 = 101 ; 
    private Byte2FloatMap p101;

    //dft map<u8,i8> p102 = 102 ; 
    private Byte2ByteMap p102;

    //dft map<u8,u8> p103 = 103 ; 
    private Byte2ByteMap p103;

    //dft map<u8,i16> p104 = 104 ; 
    private Byte2ShortMap p104;

    //dft map<u8,u16> p105 = 105 ; 
    private Byte2ShortMap p105;

    //dft map<u8,i32> p106 = 106 ; 
    private Byte2IntMap p106;

    //dft map<u8,u32> p107 = 107 ; 
    private Byte2IntMap p107;

    //dft map<u8,s32> p108 = 108 ; 
    private Byte2IntMap p108;

    //dft map<u8,f32> p109 = 109 ; 
    private Byte2IntMap p109;

    //dft map<u8,sf32> p110 = 110 ; 
    private Byte2IntMap p110;

    //dft map<u8,i64> p111 = 111 ; 
    private Byte2LongMap p111;

    //dft map<u8,u64> p112 = 112 ; 
    private Byte2LongMap p112;

    //dft map<u8,s64> p113 = 113 ; 
    private Byte2LongMap p113;

    //dft map<u8,f64> p114 = 114 ; 
    private Byte2LongMap p114;

    //dft map<u8,sf64> p115 = 115 ; 
    private Byte2LongMap p115;

    //dft map<u8,string> p116 = 116 ; 
    private Byte2ObjectMap<String> p116;

    //dft map<u8,double> p117 = 117 ; 
    private Byte2DoubleMap p117;

    //dft map<u8,float> p118 = 118 ; 
    private Byte2FloatMap p118;

    //dft map<i16,i8> p119 = 119 ; 
    private Short2ByteMap p119;

    //dft map<i16,u8> p120 = 120 ; 
    private Short2ByteMap p120;

    //dft map<i16,i16> p121 = 121 ; 
    private Short2ShortMap p121;

    //dft map<i16,u16> p122 = 122 ; 
    private Short2ShortMap p122;

    //dft map<i16,i32> p123 = 123 ; 
    private Short2IntMap p123;

    //dft map<i16,u32> p124 = 124 ; 
    private Short2IntMap p124;

    //dft map<i16,s32> p125 = 125 ; 
    private Short2IntMap p125;

    //dft map<i16,f32> p126 = 126 ; 
    private Short2IntMap p126;

    //dft map<i16,sf32> p127 = 127 ; 
    private Short2IntMap p127;

    //dft map<i16,i64> p128 = 128 ; 
    private Short2LongMap p128;

    //dft map<i16,u64> p129 = 129 ; 
    private Short2LongMap p129;

    //dft map<i16,s64> p130 = 130 ; 
    private Short2LongMap p130;

    //dft map<i16,f64> p131 = 131 ; 
    private Short2LongMap p131;

    //dft map<i16,sf64> p132 = 132 ; 
    private Short2LongMap p132;

    //dft map<i16,string> p133 = 133 ; 
    private Short2ObjectMap<String> p133;

    //dft map<i16,double> p134 = 134 ; 
    private Short2DoubleMap p134;

    //dft map<i16,float> p135 = 135 ; 
    private Short2FloatMap p135;

    //dft map<u16,i8> p136 = 136 ; 
    private Short2ByteMap p136;

    //dft map<u16,u8> p137 = 137 ; 
    private Short2ByteMap p137;

    //dft map<u16,i16> p138 = 138 ; 
    private Short2ShortMap p138;

    //dft map<u16,u16> p139 = 139 ; 
    private Short2ShortMap p139;

    //dft map<u16,i32> p140 = 140 ; 
    private Short2IntMap p140;

    //dft map<u16,u32> p141 = 141 ; 
    private Short2IntMap p141;

    //dft map<u16,s32> p142 = 142 ; 
    private Short2IntMap p142;

    //dft map<u16,f32> p143 = 143 ; 
    private Short2IntMap p143;

    //dft map<u16,sf32> p144 = 144 ; 
    private Short2IntMap p144;

    //dft map<u16,i64> p145 = 145 ; 
    private Short2LongMap p145;

    //dft map<u16,u64> p146 = 146 ; 
    private Short2LongMap p146;

    //dft map<u16,s64> p147 = 147 ; 
    private Short2LongMap p147;

    //dft map<u16,f64> p148 = 148 ; 
    private Short2LongMap p148;

    //dft map<u16,sf64> p149 = 149 ; 
    private Short2LongMap p149;

    //dft map<u16,string> p150 = 150 ; 
    private Short2ObjectMap<String> p150;

    //dft map<u16,double> p151 = 151 ; 
    private Short2DoubleMap p151;

    //dft map<u16,float> p152 = 152 ; 
    private Short2FloatMap p152;

    //dft map<i32,i8> p153 = 153 ; 
    private Int2ByteMap p153;

    //dft map<i32,u8> p154 = 154 ; 
    private Int2ByteMap p154;

    //dft map<i32,i16> p155 = 155 ; 
    private Int2ShortMap p155;

    //dft map<i32,u16> p156 = 156 ; 
    private Int2ShortMap p156;

    //dft map<i32,i32> p157 = 157 ; 
    private Int2IntMap p157;

    //dft map<i32,u32> p158 = 158 ; 
    private Int2IntMap p158;

    //dft map<i32,s32> p159 = 159 ; 
    private Int2IntMap p159;

    //dft map<i32,f32> p160 = 160 ; 
    private Int2IntMap p160;

    //dft map<i32,sf32> p161 = 161 ; 
    private Int2IntMap p161;

    //dft map<i32,i64> p162 = 162 ; 
    private Int2LongMap p162;

    //dft map<i32,u64> p163 = 163 ; 
    private Int2LongMap p163;

    //dft map<i32,s64> p164 = 164 ; 
    private Int2LongMap p164;

    //dft map<i32,f64> p165 = 165 ; 
    private Int2LongMap p165;

    //dft map<i32,sf64> p166 = 166 ; 
    private Int2LongMap p166;

    //dft map<i32,string> p167 = 167 ; 
    private Int2ObjectMap<String> p167;

    //dft map<i32,double> p168 = 168 ; 
    private Int2DoubleMap p168;

    //dft map<i32,float> p169 = 169 ; 
    private Int2FloatMap p169;

    //dft map<u32,i8> p170 = 170 ; 
    private Int2ByteMap p170;

    //dft map<u32,u8> p171 = 171 ; 
    private Int2ByteMap p171;

    //dft map<u32,i16> p172 = 172 ; 
    private Int2ShortMap p172;

    //dft map<u32,u16> p173 = 173 ; 
    private Int2ShortMap p173;

    //dft map<u32,i32> p174 = 174 ; 
    private Int2IntMap p174;

    //dft map<u32,u32> p175 = 175 ; 
    private Int2IntMap p175;

    //dft map<u32,s32> p176 = 176 ; 
    private Int2IntMap p176;

    //dft map<u32,f32> p177 = 177 ; 
    private Int2IntMap p177;

    //dft map<u32,sf32> p178 = 178 ; 
    private Int2IntMap p178;

    //dft map<u32,i64> p179 = 179 ; 
    private Int2LongMap p179;

    //dft map<u32,u64> p180 = 180 ; 
    private Int2LongMap p180;

    //dft map<u32,s64> p181 = 181 ; 
    private Int2LongMap p181;

    //dft map<u32,f64> p182 = 182 ; 
    private Int2LongMap p182;

    //dft map<u32,sf64> p183 = 183 ; 
    private Int2LongMap p183;

    //dft map<u32,string> p184 = 184 ; 
    private Int2ObjectMap<String> p184;

    //dft map<u32,double> p185 = 185 ; 
    private Int2DoubleMap p185;

    //dft map<u32,float> p186 = 186 ; 
    private Int2FloatMap p186;

    //dft map<s32,i8> p187 = 187 ; 
    private Int2ByteMap p187;

    //dft map<s32,u8> p188 = 188 ; 
    private Int2ByteMap p188;

    //dft map<s32,i16> p189 = 189 ; 
    private Int2ShortMap p189;

    //dft map<s32,u16> p190 = 190 ; 
    private Int2ShortMap p190;

    //dft map<s32,i32> p191 = 191 ; 
    private Int2IntMap p191;

    //dft map<s32,u32> p192 = 192 ; 
    private Int2IntMap p192;

    //dft map<s32,s32> p193 = 193 ; 
    private Int2IntMap p193;

    //dft map<s32,f32> p194 = 194 ; 
    private Int2IntMap p194;

    //dft map<s32,sf32> p195 = 195 ; 
    private Int2IntMap p195;

    //dft map<s32,i64> p196 = 196 ; 
    private Int2LongMap p196;

    //dft map<s32,u64> p197 = 197 ; 
    private Int2LongMap p197;

    //dft map<s32,s64> p198 = 198 ; 
    private Int2LongMap p198;

    //dft map<s32,f64> p199 = 199 ; 
    private Int2LongMap p199;

    //dft map<s32,sf64> p200 = 200 ; 
    private Int2LongMap p200;

    //dft map<s32,string> p201 = 201 ; 
    private Int2ObjectMap<String> p201;

    //dft map<s32,double> p202 = 202 ; 
    private Int2DoubleMap p202;

    //dft map<s32,float> p203 = 203 ; 
    private Int2FloatMap p203;

    //dft map<f32,i8> p204 = 204 ; 
    private Int2ByteMap p204;

    //dft map<f32,u8> p205 = 205 ; 
    private Int2ByteMap p205;

    //dft map<f32,i16> p206 = 206 ; 
    private Int2ShortMap p206;

    //dft map<f32,u16> p207 = 207 ; 
    private Int2ShortMap p207;

    //dft map<f32,i32> p208 = 208 ; 
    private Int2IntMap p208;

    //dft map<f32,u32> p209 = 209 ; 
    private Int2IntMap p209;

    //dft map<f32,s32> p210 = 210 ; 
    private Int2IntMap p210;

    //dft map<f32,f32> p211 = 211 ; 
    private Int2IntMap p211;

    //dft map<f32,sf32> p212 = 212 ; 
    private Int2IntMap p212;

    //dft map<f32,i64> p213 = 213 ; 
    private Int2LongMap p213;

    //dft map<f32,u64> p214 = 214 ; 
    private Int2LongMap p214;

    //dft map<f32,s64> p215 = 215 ; 
    private Int2LongMap p215;

    //dft map<f32,f64> p216 = 216 ; 
    private Int2LongMap p216;

    //dft map<f32,sf64> p217 = 217 ; 
    private Int2LongMap p217;

    //dft map<f32,string> p218 = 218 ; 
    private Int2ObjectMap<String> p218;

    //dft map<f32,double> p219 = 219 ; 
    private Int2DoubleMap p219;

    //dft map<f32,float> p220 = 220 ; 
    private Int2FloatMap p220;

    //dft map<sf32,i8> p221 = 221 ; 
    private Int2ByteMap p221;

    //dft map<sf32,u8> p222 = 222 ; 
    private Int2ByteMap p222;

    //dft map<sf32,i16> p223 = 223 ; 
    private Int2ShortMap p223;

    //dft map<sf32,u16> p224 = 224 ; 
    private Int2ShortMap p224;

    //dft map<sf32,i32> p225 = 225 ; 
    private Int2IntMap p225;

    //dft map<sf32,u32> p226 = 226 ; 
    private Int2IntMap p226;

    //dft map<sf32,s32> p227 = 227 ; 
    private Int2IntMap p227;

    //dft map<sf32,f32> p228 = 228 ; 
    private Int2IntMap p228;

    //dft map<sf32,sf32> p229 = 229 ; 
    private Int2IntMap p229;

    //dft map<sf32,i64> p230 = 230 ; 
    private Int2LongMap p230;

    //dft map<sf32,u64> p231 = 231 ; 
    private Int2LongMap p231;

    //dft map<sf32,s64> p232 = 232 ; 
    private Int2LongMap p232;

    //dft map<sf32,f64> p233 = 233 ; 
    private Int2LongMap p233;

    //dft map<sf32,sf64> p234 = 234 ; 
    private Int2LongMap p234;

    //dft map<sf32,string> p235 = 235 ; 
    private Int2ObjectMap<String> p235;

    //dft map<sf32,double> p236 = 236 ; 
    private Int2DoubleMap p236;

    //dft map<sf32,float> p237 = 237 ; 
    private Int2FloatMap p237;

    //dft map<i64,i8> p238 = 238 ; 
    private Long2ByteMap p238;

    //dft map<i64,u8> p239 = 239 ; 
    private Long2ByteMap p239;

    //dft map<i64,i16> p240 = 240 ; 
    private Long2ShortMap p240;

    //dft map<i64,u16> p241 = 241 ; 
    private Long2ShortMap p241;

    //dft map<i64,i32> p242 = 242 ; 
    private Long2IntMap p242;

    //dft map<i64,u32> p243 = 243 ; 
    private Long2IntMap p243;

    //dft map<i64,s32> p244 = 244 ; 
    private Long2IntMap p244;

    //dft map<i64,f32> p245 = 245 ; 
    private Long2IntMap p245;

    //dft map<i64,sf32> p246 = 246 ; 
    private Long2IntMap p246;

    //dft map<i64,i64> p247 = 247 ; 
    private Long2LongMap p247;

    //dft map<i64,u64> p248 = 248 ; 
    private Long2LongMap p248;

    //dft map<i64,s64> p249 = 249 ; 
    private Long2LongMap p249;

    //dft map<i64,f64> p250 = 250 ; 
    private Long2LongMap p250;

    //dft map<i64,sf64> p251 = 251 ; 
    private Long2LongMap p251;

    //dft map<i64,string> p252 = 252 ; 
    private Long2ObjectMap<String> p252;

    //dft map<i64,double> p253 = 253 ; 
    private Long2DoubleMap p253;

    //dft map<i64,float> p254 = 254 ; 
    private Long2FloatMap p254;

    //dft map<u64,i8> p255 = 255 ; 
    private Long2ByteMap p255;

    //dft map<u64,u8> p256 = 256 ; 
    private Long2ByteMap p256;

    //dft map<u64,i16> p257 = 257 ; 
    private Long2ShortMap p257;

    //dft map<u64,u16> p258 = 258 ; 
    private Long2ShortMap p258;

    //dft map<u64,i32> p259 = 259 ; 
    private Long2IntMap p259;

    //dft map<u64,u32> p260 = 260 ; 
    private Long2IntMap p260;

    //dft map<u64,s32> p261 = 261 ; 
    private Long2IntMap p261;

    //dft map<u64,f32> p262 = 262 ; 
    private Long2IntMap p262;

    //dft map<u64,sf32> p263 = 263 ; 
    private Long2IntMap p263;

    //dft map<u64,i64> p264 = 264 ; 
    private Long2LongMap p264;

    //dft map<u64,u64> p265 = 265 ; 
    private Long2LongMap p265;

    //dft map<u64,s64> p266 = 266 ; 
    private Long2LongMap p266;

    //dft map<u64,f64> p267 = 267 ; 
    private Long2LongMap p267;

    //dft map<u64,sf64> p268 = 268 ; 
    private Long2LongMap p268;

    //dft map<u64,string> p269 = 269 ; 
    private Long2ObjectMap<String> p269;

    //dft map<u64,double> p270 = 270 ; 
    private Long2DoubleMap p270;

    //dft map<u64,float> p271 = 271 ; 
    private Long2FloatMap p271;

    //dft map<s64,i8> p272 = 272 ; 
    private Long2ByteMap p272;

    //dft map<s64,u8> p273 = 273 ; 
    private Long2ByteMap p273;

    //dft map<s64,i16> p274 = 274 ; 
    private Long2ShortMap p274;

    //dft map<s64,u16> p275 = 275 ; 
    private Long2ShortMap p275;

    //dft map<s64,i32> p276 = 276 ; 
    private Long2IntMap p276;

    //dft map<s64,u32> p277 = 277 ; 
    private Long2IntMap p277;

    //dft map<s64,s32> p278 = 278 ; 
    private Long2IntMap p278;

    //dft map<s64,f32> p279 = 279 ; 
    private Long2IntMap p279;

    //dft map<s64,sf32> p280 = 280 ; 
    private Long2IntMap p280;

    //dft map<s64,i64> p281 = 281 ; 
    private Long2LongMap p281;

    //dft map<s64,u64> p282 = 282 ; 
    private Long2LongMap p282;

    //dft map<s64,s64> p283 = 283 ; 
    private Long2LongMap p283;

    //dft map<s64,f64> p284 = 284 ; 
    private Long2LongMap p284;

    //dft map<s64,sf64> p285 = 285 ; 
    private Long2LongMap p285;

    //dft map<s64,string> p286 = 286 ; 
    private Long2ObjectMap<String> p286;

    //dft map<s64,double> p287 = 287 ; 
    private Long2DoubleMap p287;

    //dft map<s64,float> p288 = 288 ; 
    private Long2FloatMap p288;

    //dft map<f64,i8> p289 = 289 ; 
    private Long2ByteMap p289;

    //dft map<f64,u8> p290 = 290 ; 
    private Long2ByteMap p290;

    //dft map<f64,i16> p291 = 291 ; 
    private Long2ShortMap p291;

    //dft map<f64,u16> p292 = 292 ; 
    private Long2ShortMap p292;

    //dft map<f64,i32> p293 = 293 ; 
    private Long2IntMap p293;

    //dft map<f64,u32> p294 = 294 ; 
    private Long2IntMap p294;

    //dft map<f64,s32> p295 = 295 ; 
    private Long2IntMap p295;

    //dft map<f64,f32> p296 = 296 ; 
    private Long2IntMap p296;

    //dft map<f64,sf32> p297 = 297 ; 
    private Long2IntMap p297;

    //dft map<f64,i64> p298 = 298 ; 
    private Long2LongMap p298;

    //dft map<f64,u64> p299 = 299 ; 
    private Long2LongMap p299;

    //dft map<f64,s64> p300 = 300 ; 
    private Long2LongMap p300;

    //dft map<f64,f64> p301 = 301 ; 
    private Long2LongMap p301;

    //dft map<f64,sf64> p302 = 302 ; 
    private Long2LongMap p302;

    //dft map<f64,string> p303 = 303 ; 
    private Long2ObjectMap<String> p303;

    //dft map<f64,double> p304 = 304 ; 
    private Long2DoubleMap p304;

    //dft map<f64,float> p305 = 305 ; 
    private Long2FloatMap p305;

    //dft map<sf64,i8> p306 = 306 ; 
    private Long2ByteMap p306;

    //dft map<sf64,u8> p307 = 307 ; 
    private Long2ByteMap p307;

    //dft map<sf64,i16> p308 = 308 ; 
    private Long2ShortMap p308;

    //dft map<sf64,u16> p309 = 309 ; 
    private Long2ShortMap p309;

    //dft map<sf64,i32> p310 = 310 ; 
    private Long2IntMap p310;

    //dft map<sf64,u32> p311 = 311 ; 
    private Long2IntMap p311;

    //dft map<sf64,s32> p312 = 312 ; 
    private Long2IntMap p312;

    //dft map<sf64,f32> p313 = 313 ; 
    private Long2IntMap p313;

    //dft map<sf64,sf32> p314 = 314 ; 
    private Long2IntMap p314;

    //dft map<sf64,i64> p315 = 315 ; 
    private Long2LongMap p315;

    //dft map<sf64,u64> p316 = 316 ; 
    private Long2LongMap p316;

    //dft map<sf64,s64> p317 = 317 ; 
    private Long2LongMap p317;

    //dft map<sf64,f64> p318 = 318 ; 
    private Long2LongMap p318;

    //dft map<sf64,sf64> p319 = 319 ; 
    private Long2LongMap p319;

    //dft map<sf64,string> p320 = 320 ; 
    private Long2ObjectMap<String> p320;

    //dft map<sf64,double> p321 = 321 ; 
    private Long2DoubleMap p321;

    //dft map<sf64,float> p322 = 322 ; 
    private Long2FloatMap p322;

    //dft map<string,i8> p323 = 323 ; 
    private Object2ByteMap<String> p323;

    //dft map<string,u8> p324 = 324 ; 
    private Object2ByteMap<String> p324;

    //dft map<string,i16> p325 = 325 ; 
    private Object2ShortMap<String> p325;

    //dft map<string,u16> p326 = 326 ; 
    private Object2ShortMap<String> p326;

    //dft map<string,i32> p327 = 327 ; 
    private Object2IntMap<String> p327;

    //dft map<string,u32> p328 = 328 ; 
    private Object2IntMap<String> p328;

    //dft map<string,s32> p329 = 329 ; 
    private Object2IntMap<String> p329;

    //dft map<string,f32> p330 = 330 ; 
    private Object2IntMap<String> p330;

    //dft map<string,sf32> p331 = 331 ; 
    private Object2IntMap<String> p331;

    //dft map<string,i64> p332 = 332 ; 
    private Object2LongMap<String> p332;

    //dft map<string,u64> p333 = 333 ; 
    private Object2LongMap<String> p333;

    //dft map<string,s64> p334 = 334 ; 
    private Object2LongMap<String> p334;

    //dft map<string,f64> p335 = 335 ; 
    private Object2LongMap<String> p335;

    //dft map<string,sf64> p336 = 336 ; 
    private Object2LongMap<String> p336;

    //dft map<string,string> p337 = 337 ; 
    private Map<String,String> p337;

    //dft map<string,double> p338 = 338 ; 
    private Object2DoubleMap<String> p338;

    //dft map<string,float> p339 = 339 ; 
    private Object2FloatMap<String> p339;

    //dft map<double,i8> p340 = 340 ; 
    private Double2ByteMap p340;

    //dft map<double,u8> p341 = 341 ; 
    private Double2ByteMap p341;

    //dft map<double,i16> p342 = 342 ; 
    private Double2ShortMap p342;

    //dft map<double,u16> p343 = 343 ; 
    private Double2ShortMap p343;

    //dft map<double,i32> p344 = 344 ; 
    private Double2IntMap p344;

    //dft map<double,u32> p345 = 345 ; 
    private Double2IntMap p345;

    //dft map<double,s32> p346 = 346 ; 
    private Double2IntMap p346;

    //dft map<double,f32> p347 = 347 ; 
    private Double2IntMap p347;

    //dft map<double,sf32> p348 = 348 ; 
    private Double2IntMap p348;

    //dft map<double,i64> p349 = 349 ; 
    private Double2LongMap p349;

    //dft map<double,u64> p350 = 350 ; 
    private Double2LongMap p350;

    //dft map<double,s64> p351 = 351 ; 
    private Double2LongMap p351;

    //dft map<double,f64> p352 = 352 ; 
    private Double2LongMap p352;

    //dft map<double,sf64> p353 = 353 ; 
    private Double2LongMap p353;

    //dft map<double,string> p354 = 354 ; 
    private Double2ObjectMap<String> p354;

    //dft map<double,double> p355 = 355 ; 
    private Double2DoubleMap p355;

    //dft map<double,float> p356 = 356 ; 
    private Double2FloatMap p356;

    //dft map<float,i8> p357 = 357 ; 
    private Float2ByteMap p357;

    //dft map<float,u8> p358 = 358 ; 
    private Float2ByteMap p358;

    //dft map<float,i16> p359 = 359 ; 
    private Float2ShortMap p359;

    //dft map<float,u16> p360 = 360 ; 
    private Float2ShortMap p360;

    //dft map<float,i32> p361 = 361 ; 
    private Float2IntMap p361;

    //dft map<float,u32> p362 = 362 ; 
    private Float2IntMap p362;

    //dft map<float,s32> p363 = 363 ; 
    private Float2IntMap p363;

    //dft map<float,f32> p364 = 364 ; 
    private Float2IntMap p364;

    //dft map<float,sf32> p365 = 365 ; 
    private Float2IntMap p365;

    //dft map<float,i64> p366 = 366 ; 
    private Float2LongMap p366;

    //dft map<float,u64> p367 = 367 ; 
    private Float2LongMap p367;

    //dft map<float,s64> p368 = 368 ; 
    private Float2LongMap p368;

    //dft map<float,f64> p369 = 369 ; 
    private Float2LongMap p369;

    //dft map<float,sf64> p370 = 370 ; 
    private Float2LongMap p370;

    //dft map<float,string> p371 = 371 ; 
    private Float2ObjectMap<String> p371;

    //dft map<float,double> p372 = 372 ; 
    private Float2DoubleMap p372;

    //dft map<float,float> p373 = 373 ; 
    private Float2FloatMap p373;

    //dft map<i8,FullEnum0> p374 = 374 ; 
    private Byte2ObjectMap<FullEnum0> p374;

    //dft map<i8,FullMessage0> p375 = 375 ; 
    private Byte2ObjectMap<FullMessage0> p375;

    //dft map<i8,FullMessage0> p376 = 376 [ polymorphic=true ] ; 
    private Byte2ObjectMap<FullMessage0> p376;

    //dft map<u8,FullEnum0> p377 = 377 ; 
    private Byte2ObjectMap<FullEnum0> p377;

    //dft map<u8,FullMessage0> p378 = 378 ; 
    private Byte2ObjectMap<FullMessage0> p378;

    //dft map<u8,FullMessage0> p379 = 379 [ polymorphic=true ] ; 
    private Byte2ObjectMap<FullMessage0> p379;

    //dft map<i16,FullEnum0> p380 = 380 ; 
    private Short2ObjectMap<FullEnum0> p380;

    //dft map<i16,FullMessage0> p381 = 381 ; 
    private Short2ObjectMap<FullMessage0> p381;

    //dft map<i16,FullMessage0> p382 = 382 [ polymorphic=true ] ; 
    private Short2ObjectMap<FullMessage0> p382;

    //dft map<u16,FullEnum0> p383 = 383 ; 
    private Short2ObjectMap<FullEnum0> p383;

    //dft map<u16,FullMessage0> p384 = 384 ; 
    private Short2ObjectMap<FullMessage0> p384;

    //dft map<u16,FullMessage0> p385 = 385 [ polymorphic=true ] ; 
    private Short2ObjectMap<FullMessage0> p385;

    //dft map<i32,FullEnum0> p386 = 386 ; 
    private Int2ObjectMap<FullEnum0> p386;

    //dft map<i32,FullMessage0> p387 = 387 ; 
    private Int2ObjectMap<FullMessage0> p387;

    //dft map<i32,FullMessage0> p388 = 388 [ polymorphic=true ] ; 
    private Int2ObjectMap<FullMessage0> p388;

    //dft map<u32,FullEnum0> p389 = 389 ; 
    private Int2ObjectMap<FullEnum0> p389;

    //dft map<u32,FullMessage0> p390 = 390 ; 
    private Int2ObjectMap<FullMessage0> p390;

    //dft map<u32,FullMessage0> p391 = 391 [ polymorphic=true ] ; 
    private Int2ObjectMap<FullMessage0> p391;

    //dft map<s32,FullEnum0> p392 = 392 ; 
    private Int2ObjectMap<FullEnum0> p392;

    //dft map<s32,FullMessage0> p393 = 393 ; 
    private Int2ObjectMap<FullMessage0> p393;

    //dft map<s32,FullMessage0> p394 = 394 [ polymorphic=true ] ; 
    private Int2ObjectMap<FullMessage0> p394;

    //dft map<f32,FullEnum0> p395 = 395 ; 
    private Int2ObjectMap<FullEnum0> p395;

    //dft map<f32,FullMessage0> p396 = 396 ; 
    private Int2ObjectMap<FullMessage0> p396;

    //dft map<f32,FullMessage0> p397 = 397 [ polymorphic=true ] ; 
    private Int2ObjectMap<FullMessage0> p397;

    //dft map<sf32,FullEnum0> p398 = 398 ; 
    private Int2ObjectMap<FullEnum0> p398;

    //dft map<sf32,FullMessage0> p399 = 399 ; 
    private Int2ObjectMap<FullMessage0> p399;

    //dft map<sf32,FullMessage0> p400 = 400 [ polymorphic=true ] ; 
    private Int2ObjectMap<FullMessage0> p400;

    //dft map<i64,FullEnum0> p401 = 401 ; 
    private Long2ObjectMap<FullEnum0> p401;

    //dft map<i64,FullMessage0> p402 = 402 ; 
    private Long2ObjectMap<FullMessage0> p402;

    //dft map<i64,FullMessage0> p403 = 403 [ polymorphic=true ] ; 
    private Long2ObjectMap<FullMessage0> p403;

    //dft map<u64,FullEnum0> p404 = 404 ; 
    private Long2ObjectMap<FullEnum0> p404;

    //dft map<u64,FullMessage0> p405 = 405 ; 
    private Long2ObjectMap<FullMessage0> p405;

    //dft map<u64,FullMessage0> p406 = 406 [ polymorphic=true ] ; 
    private Long2ObjectMap<FullMessage0> p406;

    //dft map<s64,FullEnum0> p407 = 407 ; 
    private Long2ObjectMap<FullEnum0> p407;

    //dft map<s64,FullMessage0> p408 = 408 ; 
    private Long2ObjectMap<FullMessage0> p408;

    //dft map<s64,FullMessage0> p409 = 409 [ polymorphic=true ] ; 
    private Long2ObjectMap<FullMessage0> p409;

    //dft map<f64,FullEnum0> p410 = 410 ; 
    private Long2ObjectMap<FullEnum0> p410;

    //dft map<f64,FullMessage0> p411 = 411 ; 
    private Long2ObjectMap<FullMessage0> p411;

    //dft map<f64,FullMessage0> p412 = 412 [ polymorphic=true ] ; 
    private Long2ObjectMap<FullMessage0> p412;

    //dft map<sf64,FullEnum0> p413 = 413 ; 
    private Long2ObjectMap<FullEnum0> p413;

    //dft map<sf64,FullMessage0> p414 = 414 ; 
    private Long2ObjectMap<FullMessage0> p414;

    //dft map<sf64,FullMessage0> p415 = 415 [ polymorphic=true ] ; 
    private Long2ObjectMap<FullMessage0> p415;

    //dft map<string,FullEnum0> p416 = 416 ; 
    private Map<String,FullEnum0> p416;

    //dft map<string,FullMessage0> p417 = 417 ; 
    private Map<String,FullMessage0> p417;

    //dft map<string,FullMessage0> p418 = 418 [ polymorphic=true ] ; 
    private Map<String,FullMessage0> p418;

    //dft map<double,FullEnum0> p419 = 419 ; 
    private Double2ObjectMap<FullEnum0> p419;

    //dft map<double,FullMessage0> p420 = 420 ; 
    private Double2ObjectMap<FullMessage0> p420;

    //dft map<double,FullMessage0> p421 = 421 [ polymorphic=true ] ; 
    private Double2ObjectMap<FullMessage0> p421;

    //dft map<float,FullEnum0> p422 = 422 ; 
    private Float2ObjectMap<FullEnum0> p422;

    //dft map<float,FullMessage0> p423 = 423 ; 
    private Float2ObjectMap<FullMessage0> p423;

    //dft map<float,FullMessage0> p424 = 424 [ polymorphic=true ] ; 
    private Float2ObjectMap<FullMessage0> p424;

    public void setP1(boolean p1) {
        this.p1 = p1;
    }

    public boolean isP1() {
        return p1;
    }

    public void setP2(byte p2) {
        this.p2 = p2;
    }

    public byte getP2() {
        return p2;
    }

    public void setP3(byte p3) {
        this.p3 = p3;
    }

    public byte getP3() {
        return p3;
    }

    public void setP4(short p4) {
        this.p4 = p4;
    }

    public short getP4() {
        return p4;
    }

    public void setP5(short p5) {
        this.p5 = p5;
    }

    public short getP5() {
        return p5;
    }

    public void setP6(int p6) {
        this.p6 = p6;
    }

    public int getP6() {
        return p6;
    }

    public void setP7(int p7) {
        this.p7 = p7;
    }

    public int getP7() {
        return p7;
    }

    public void setP8(int p8) {
        this.p8 = p8;
    }

    public int getP8() {
        return p8;
    }

    public void setP9(int p9) {
        this.p9 = p9;
    }

    public int getP9() {
        return p9;
    }

    public void setP10(int p10) {
        this.p10 = p10;
    }

    public int getP10() {
        return p10;
    }

    public void setP11(long p11) {
        this.p11 = p11;
    }

    public long getP11() {
        return p11;
    }

    public void setP12(long p12) {
        this.p12 = p12;
    }

    public long getP12() {
        return p12;
    }

    public void setP13(long p13) {
        this.p13 = p13;
    }

    public long getP13() {
        return p13;
    }

    public void setP14(long p14) {
        this.p14 = p14;
    }

    public long getP14() {
        return p14;
    }

    public void setP15(long p15) {
        this.p15 = p15;
    }

    public long getP15() {
        return p15;
    }

    public void setP16(String p16) {
        this.p16 = p16;
    }

    public String getP16() {
        return p16;
    }

    public void setP17(double p17) {
        this.p17 = p17;
    }

    public double getP17() {
        return p17;
    }

    public void setP18(float p18) {
        this.p18 = p18;
    }

    public float getP18() {
        return p18;
    }

    public void setP19(FullEnum0 p19) {
        this.p19 = p19;
    }

    public FullEnum0 getP19() {
        return p19;
    }

    public void setP20(FullMessage0 p20) {
        this.p20 = p20;
    }

    public FullMessage0 getP20() {
        return p20;
    }

    public void setP21(boolean[] p21) {
        this.p21 = p21;
    }

    public boolean[] getP21() {
        return p21;
    }

    public void setP22(byte[] p22) {
        this.p22 = p22;
    }

    public byte[] getP22() {
        return p22;
    }

    public void setP23(byte[] p23) {
        this.p23 = p23;
    }

    public byte[] getP23() {
        return p23;
    }

    public void setP24(short[] p24) {
        this.p24 = p24;
    }

    public short[] getP24() {
        return p24;
    }

    public void setP25(short[] p25) {
        this.p25 = p25;
    }

    public short[] getP25() {
        return p25;
    }

    public void setP26(int[] p26) {
        this.p26 = p26;
    }

    public int[] getP26() {
        return p26;
    }

    public void setP27(int[] p27) {
        this.p27 = p27;
    }

    public int[] getP27() {
        return p27;
    }

    public void setP28(int[] p28) {
        this.p28 = p28;
    }

    public int[] getP28() {
        return p28;
    }

    public void setP29(int[] p29) {
        this.p29 = p29;
    }

    public int[] getP29() {
        return p29;
    }

    public void setP30(int[] p30) {
        this.p30 = p30;
    }

    public int[] getP30() {
        return p30;
    }

    public void setP31(long[] p31) {
        this.p31 = p31;
    }

    public long[] getP31() {
        return p31;
    }

    public void setP32(long[] p32) {
        this.p32 = p32;
    }

    public long[] getP32() {
        return p32;
    }

    public void setP33(long[] p33) {
        this.p33 = p33;
    }

    public long[] getP33() {
        return p33;
    }

    public void setP34(long[] p34) {
        this.p34 = p34;
    }

    public long[] getP34() {
        return p34;
    }

    public void setP35(long[] p35) {
        this.p35 = p35;
    }

    public long[] getP35() {
        return p35;
    }

    public void setP36(String[] p36) {
        this.p36 = p36;
    }

    public String[] getP36() {
        return p36;
    }

    public void setP37(double[] p37) {
        this.p37 = p37;
    }

    public double[] getP37() {
        return p37;
    }

    public void setP38(float[] p38) {
        this.p38 = p38;
    }

    public float[] getP38() {
        return p38;
    }

    public void setP39(FullEnum0[] p39) {
        this.p39 = p39;
    }

    public FullEnum0[] getP39() {
        return p39;
    }

    public void setP40(FullMessage0[] p40) {
        this.p40 = p40;
    }

    public FullMessage0[] getP40() {
        return p40;
    }

    public void setP41(BooleanSet p41) {
        this.p41 = p41;
    }

    public BooleanSet getP41() {
        return p41;
    }

    public void setP42(ByteSet p42) {
        this.p42 = p42;
    }

    public ByteSet getP42() {
        return p42;
    }

    public void setP43(ByteSet p43) {
        this.p43 = p43;
    }

    public ByteSet getP43() {
        return p43;
    }

    public void setP44(ShortSet p44) {
        this.p44 = p44;
    }

    public ShortSet getP44() {
        return p44;
    }

    public void setP45(ShortSet p45) {
        this.p45 = p45;
    }

    public ShortSet getP45() {
        return p45;
    }

    public void setP46(IntSet p46) {
        this.p46 = p46;
    }

    public IntSet getP46() {
        return p46;
    }

    public void setP47(IntSet p47) {
        this.p47 = p47;
    }

    public IntSet getP47() {
        return p47;
    }

    public void setP48(IntSet p48) {
        this.p48 = p48;
    }

    public IntSet getP48() {
        return p48;
    }

    public void setP49(IntSet p49) {
        this.p49 = p49;
    }

    public IntSet getP49() {
        return p49;
    }

    public void setP50(IntSet p50) {
        this.p50 = p50;
    }

    public IntSet getP50() {
        return p50;
    }

    public void setP51(LongSet p51) {
        this.p51 = p51;
    }

    public LongSet getP51() {
        return p51;
    }

    public void setP52(LongSet p52) {
        this.p52 = p52;
    }

    public LongSet getP52() {
        return p52;
    }

    public void setP53(LongSet p53) {
        this.p53 = p53;
    }

    public LongSet getP53() {
        return p53;
    }

    public void setP54(LongSet p54) {
        this.p54 = p54;
    }

    public LongSet getP54() {
        return p54;
    }

    public void setP55(LongSet p55) {
        this.p55 = p55;
    }

    public LongSet getP55() {
        return p55;
    }

    public void setP56(Set<String> p56) {
        this.p56 = p56;
    }

    public Set<String> getP56() {
        return p56;
    }

    public void setP57(DoubleSet p57) {
        this.p57 = p57;
    }

    public DoubleSet getP57() {
        return p57;
    }

    public void setP58(FloatSet p58) {
        this.p58 = p58;
    }

    public FloatSet getP58() {
        return p58;
    }

    public void setP59(EnumSet<FullEnum0> p59) {
        this.p59 = p59;
    }

    public EnumSet<FullEnum0> getP59() {
        return p59;
    }

    public void setP60(Set<FullMessage0> p60) {
        this.p60 = p60;
    }

    public Set<FullMessage0> getP60() {
        return p60;
    }

    public void setP61(BooleanList p61) {
        this.p61 = p61;
    }

    public BooleanList getP61() {
        return p61;
    }

    public void setP62(ByteList p62) {
        this.p62 = p62;
    }

    public ByteList getP62() {
        return p62;
    }

    public void setP63(ByteList p63) {
        this.p63 = p63;
    }

    public ByteList getP63() {
        return p63;
    }

    public void setP64(ShortList p64) {
        this.p64 = p64;
    }

    public ShortList getP64() {
        return p64;
    }

    public void setP65(ShortList p65) {
        this.p65 = p65;
    }

    public ShortList getP65() {
        return p65;
    }

    public void setP66(IntList p66) {
        this.p66 = p66;
    }

    public IntList getP66() {
        return p66;
    }

    public void setP67(IntList p67) {
        this.p67 = p67;
    }

    public IntList getP67() {
        return p67;
    }

    public void setP68(IntList p68) {
        this.p68 = p68;
    }

    public IntList getP68() {
        return p68;
    }

    public void setP69(IntList p69) {
        this.p69 = p69;
    }

    public IntList getP69() {
        return p69;
    }

    public void setP70(IntList p70) {
        this.p70 = p70;
    }

    public IntList getP70() {
        return p70;
    }

    public void setP71(LongList p71) {
        this.p71 = p71;
    }

    public LongList getP71() {
        return p71;
    }

    public void setP72(LongList p72) {
        this.p72 = p72;
    }

    public LongList getP72() {
        return p72;
    }

    public void setP73(LongList p73) {
        this.p73 = p73;
    }

    public LongList getP73() {
        return p73;
    }

    public void setP74(LongList p74) {
        this.p74 = p74;
    }

    public LongList getP74() {
        return p74;
    }

    public void setP75(LongList p75) {
        this.p75 = p75;
    }

    public LongList getP75() {
        return p75;
    }

    public void setP76(List<String> p76) {
        this.p76 = p76;
    }

    public List<String> getP76() {
        return p76;
    }

    public void setP77(DoubleList p77) {
        this.p77 = p77;
    }

    public DoubleList getP77() {
        return p77;
    }

    public void setP78(FloatList p78) {
        this.p78 = p78;
    }

    public FloatList getP78() {
        return p78;
    }

    public void setP79(List<FullEnum0> p79) {
        this.p79 = p79;
    }

    public List<FullEnum0> getP79() {
        return p79;
    }

    public void setP80(List<FullMessage0> p80) {
        this.p80 = p80;
    }

    public List<FullMessage0> getP80() {
        return p80;
    }

    public void setP82(Set<FullMessage0> p82) {
        this.p82 = p82;
    }

    public Set<FullMessage0> getP82() {
        return p82;
    }

    public void setP83(FullMessage0[] p83) {
        this.p83 = p83;
    }

    public FullMessage0[] getP83() {
        return p83;
    }

    public void setP84(List<FullMessage0> p84) {
        this.p84 = p84;
    }

    public List<FullMessage0> getP84() {
        return p84;
    }

    public void setP85(Byte2ByteMap p85) {
        this.p85 = p85;
    }

    public Byte2ByteMap getP85() {
        return p85;
    }

    public void setP86(Byte2ByteMap p86) {
        this.p86 = p86;
    }

    public Byte2ByteMap getP86() {
        return p86;
    }

    public void setP87(Byte2ShortMap p87) {
        this.p87 = p87;
    }

    public Byte2ShortMap getP87() {
        return p87;
    }

    public void setP88(Byte2ShortMap p88) {
        this.p88 = p88;
    }

    public Byte2ShortMap getP88() {
        return p88;
    }

    public void setP89(Byte2IntMap p89) {
        this.p89 = p89;
    }

    public Byte2IntMap getP89() {
        return p89;
    }

    public void setP90(Byte2IntMap p90) {
        this.p90 = p90;
    }

    public Byte2IntMap getP90() {
        return p90;
    }

    public void setP91(Byte2IntMap p91) {
        this.p91 = p91;
    }

    public Byte2IntMap getP91() {
        return p91;
    }

    public void setP92(Byte2IntMap p92) {
        this.p92 = p92;
    }

    public Byte2IntMap getP92() {
        return p92;
    }

    public void setP93(Byte2IntMap p93) {
        this.p93 = p93;
    }

    public Byte2IntMap getP93() {
        return p93;
    }

    public void setP94(Byte2LongMap p94) {
        this.p94 = p94;
    }

    public Byte2LongMap getP94() {
        return p94;
    }

    public void setP95(Byte2LongMap p95) {
        this.p95 = p95;
    }

    public Byte2LongMap getP95() {
        return p95;
    }

    public void setP96(Byte2LongMap p96) {
        this.p96 = p96;
    }

    public Byte2LongMap getP96() {
        return p96;
    }

    public void setP97(Byte2LongMap p97) {
        this.p97 = p97;
    }

    public Byte2LongMap getP97() {
        return p97;
    }

    public void setP98(Byte2LongMap p98) {
        this.p98 = p98;
    }

    public Byte2LongMap getP98() {
        return p98;
    }

    public void setP99(Byte2ObjectMap<String> p99) {
        this.p99 = p99;
    }

    public Byte2ObjectMap<String> getP99() {
        return p99;
    }

    public void setP100(Byte2DoubleMap p100) {
        this.p100 = p100;
    }

    public Byte2DoubleMap getP100() {
        return p100;
    }

    public void setP101(Byte2FloatMap p101) {
        this.p101 = p101;
    }

    public Byte2FloatMap getP101() {
        return p101;
    }

    public void setP102(Byte2ByteMap p102) {
        this.p102 = p102;
    }

    public Byte2ByteMap getP102() {
        return p102;
    }

    public void setP103(Byte2ByteMap p103) {
        this.p103 = p103;
    }

    public Byte2ByteMap getP103() {
        return p103;
    }

    public void setP104(Byte2ShortMap p104) {
        this.p104 = p104;
    }

    public Byte2ShortMap getP104() {
        return p104;
    }

    public void setP105(Byte2ShortMap p105) {
        this.p105 = p105;
    }

    public Byte2ShortMap getP105() {
        return p105;
    }

    public void setP106(Byte2IntMap p106) {
        this.p106 = p106;
    }

    public Byte2IntMap getP106() {
        return p106;
    }

    public void setP107(Byte2IntMap p107) {
        this.p107 = p107;
    }

    public Byte2IntMap getP107() {
        return p107;
    }

    public void setP108(Byte2IntMap p108) {
        this.p108 = p108;
    }

    public Byte2IntMap getP108() {
        return p108;
    }

    public void setP109(Byte2IntMap p109) {
        this.p109 = p109;
    }

    public Byte2IntMap getP109() {
        return p109;
    }

    public void setP110(Byte2IntMap p110) {
        this.p110 = p110;
    }

    public Byte2IntMap getP110() {
        return p110;
    }

    public void setP111(Byte2LongMap p111) {
        this.p111 = p111;
    }

    public Byte2LongMap getP111() {
        return p111;
    }

    public void setP112(Byte2LongMap p112) {
        this.p112 = p112;
    }

    public Byte2LongMap getP112() {
        return p112;
    }

    public void setP113(Byte2LongMap p113) {
        this.p113 = p113;
    }

    public Byte2LongMap getP113() {
        return p113;
    }

    public void setP114(Byte2LongMap p114) {
        this.p114 = p114;
    }

    public Byte2LongMap getP114() {
        return p114;
    }

    public void setP115(Byte2LongMap p115) {
        this.p115 = p115;
    }

    public Byte2LongMap getP115() {
        return p115;
    }

    public void setP116(Byte2ObjectMap<String> p116) {
        this.p116 = p116;
    }

    public Byte2ObjectMap<String> getP116() {
        return p116;
    }

    public void setP117(Byte2DoubleMap p117) {
        this.p117 = p117;
    }

    public Byte2DoubleMap getP117() {
        return p117;
    }

    public void setP118(Byte2FloatMap p118) {
        this.p118 = p118;
    }

    public Byte2FloatMap getP118() {
        return p118;
    }

    public void setP119(Short2ByteMap p119) {
        this.p119 = p119;
    }

    public Short2ByteMap getP119() {
        return p119;
    }

    public void setP120(Short2ByteMap p120) {
        this.p120 = p120;
    }

    public Short2ByteMap getP120() {
        return p120;
    }

    public void setP121(Short2ShortMap p121) {
        this.p121 = p121;
    }

    public Short2ShortMap getP121() {
        return p121;
    }

    public void setP122(Short2ShortMap p122) {
        this.p122 = p122;
    }

    public Short2ShortMap getP122() {
        return p122;
    }

    public void setP123(Short2IntMap p123) {
        this.p123 = p123;
    }

    public Short2IntMap getP123() {
        return p123;
    }

    public void setP124(Short2IntMap p124) {
        this.p124 = p124;
    }

    public Short2IntMap getP124() {
        return p124;
    }

    public void setP125(Short2IntMap p125) {
        this.p125 = p125;
    }

    public Short2IntMap getP125() {
        return p125;
    }

    public void setP126(Short2IntMap p126) {
        this.p126 = p126;
    }

    public Short2IntMap getP126() {
        return p126;
    }

    public void setP127(Short2IntMap p127) {
        this.p127 = p127;
    }

    public Short2IntMap getP127() {
        return p127;
    }

    public void setP128(Short2LongMap p128) {
        this.p128 = p128;
    }

    public Short2LongMap getP128() {
        return p128;
    }

    public void setP129(Short2LongMap p129) {
        this.p129 = p129;
    }

    public Short2LongMap getP129() {
        return p129;
    }

    public void setP130(Short2LongMap p130) {
        this.p130 = p130;
    }

    public Short2LongMap getP130() {
        return p130;
    }

    public void setP131(Short2LongMap p131) {
        this.p131 = p131;
    }

    public Short2LongMap getP131() {
        return p131;
    }

    public void setP132(Short2LongMap p132) {
        this.p132 = p132;
    }

    public Short2LongMap getP132() {
        return p132;
    }

    public void setP133(Short2ObjectMap<String> p133) {
        this.p133 = p133;
    }

    public Short2ObjectMap<String> getP133() {
        return p133;
    }

    public void setP134(Short2DoubleMap p134) {
        this.p134 = p134;
    }

    public Short2DoubleMap getP134() {
        return p134;
    }

    public void setP135(Short2FloatMap p135) {
        this.p135 = p135;
    }

    public Short2FloatMap getP135() {
        return p135;
    }

    public void setP136(Short2ByteMap p136) {
        this.p136 = p136;
    }

    public Short2ByteMap getP136() {
        return p136;
    }

    public void setP137(Short2ByteMap p137) {
        this.p137 = p137;
    }

    public Short2ByteMap getP137() {
        return p137;
    }

    public void setP138(Short2ShortMap p138) {
        this.p138 = p138;
    }

    public Short2ShortMap getP138() {
        return p138;
    }

    public void setP139(Short2ShortMap p139) {
        this.p139 = p139;
    }

    public Short2ShortMap getP139() {
        return p139;
    }

    public void setP140(Short2IntMap p140) {
        this.p140 = p140;
    }

    public Short2IntMap getP140() {
        return p140;
    }

    public void setP141(Short2IntMap p141) {
        this.p141 = p141;
    }

    public Short2IntMap getP141() {
        return p141;
    }

    public void setP142(Short2IntMap p142) {
        this.p142 = p142;
    }

    public Short2IntMap getP142() {
        return p142;
    }

    public void setP143(Short2IntMap p143) {
        this.p143 = p143;
    }

    public Short2IntMap getP143() {
        return p143;
    }

    public void setP144(Short2IntMap p144) {
        this.p144 = p144;
    }

    public Short2IntMap getP144() {
        return p144;
    }

    public void setP145(Short2LongMap p145) {
        this.p145 = p145;
    }

    public Short2LongMap getP145() {
        return p145;
    }

    public void setP146(Short2LongMap p146) {
        this.p146 = p146;
    }

    public Short2LongMap getP146() {
        return p146;
    }

    public void setP147(Short2LongMap p147) {
        this.p147 = p147;
    }

    public Short2LongMap getP147() {
        return p147;
    }

    public void setP148(Short2LongMap p148) {
        this.p148 = p148;
    }

    public Short2LongMap getP148() {
        return p148;
    }

    public void setP149(Short2LongMap p149) {
        this.p149 = p149;
    }

    public Short2LongMap getP149() {
        return p149;
    }

    public void setP150(Short2ObjectMap<String> p150) {
        this.p150 = p150;
    }

    public Short2ObjectMap<String> getP150() {
        return p150;
    }

    public void setP151(Short2DoubleMap p151) {
        this.p151 = p151;
    }

    public Short2DoubleMap getP151() {
        return p151;
    }

    public void setP152(Short2FloatMap p152) {
        this.p152 = p152;
    }

    public Short2FloatMap getP152() {
        return p152;
    }

    public void setP153(Int2ByteMap p153) {
        this.p153 = p153;
    }

    public Int2ByteMap getP153() {
        return p153;
    }

    public void setP154(Int2ByteMap p154) {
        this.p154 = p154;
    }

    public Int2ByteMap getP154() {
        return p154;
    }

    public void setP155(Int2ShortMap p155) {
        this.p155 = p155;
    }

    public Int2ShortMap getP155() {
        return p155;
    }

    public void setP156(Int2ShortMap p156) {
        this.p156 = p156;
    }

    public Int2ShortMap getP156() {
        return p156;
    }

    public void setP157(Int2IntMap p157) {
        this.p157 = p157;
    }

    public Int2IntMap getP157() {
        return p157;
    }

    public void setP158(Int2IntMap p158) {
        this.p158 = p158;
    }

    public Int2IntMap getP158() {
        return p158;
    }

    public void setP159(Int2IntMap p159) {
        this.p159 = p159;
    }

    public Int2IntMap getP159() {
        return p159;
    }

    public void setP160(Int2IntMap p160) {
        this.p160 = p160;
    }

    public Int2IntMap getP160() {
        return p160;
    }

    public void setP161(Int2IntMap p161) {
        this.p161 = p161;
    }

    public Int2IntMap getP161() {
        return p161;
    }

    public void setP162(Int2LongMap p162) {
        this.p162 = p162;
    }

    public Int2LongMap getP162() {
        return p162;
    }

    public void setP163(Int2LongMap p163) {
        this.p163 = p163;
    }

    public Int2LongMap getP163() {
        return p163;
    }

    public void setP164(Int2LongMap p164) {
        this.p164 = p164;
    }

    public Int2LongMap getP164() {
        return p164;
    }

    public void setP165(Int2LongMap p165) {
        this.p165 = p165;
    }

    public Int2LongMap getP165() {
        return p165;
    }

    public void setP166(Int2LongMap p166) {
        this.p166 = p166;
    }

    public Int2LongMap getP166() {
        return p166;
    }

    public void setP167(Int2ObjectMap<String> p167) {
        this.p167 = p167;
    }

    public Int2ObjectMap<String> getP167() {
        return p167;
    }

    public void setP168(Int2DoubleMap p168) {
        this.p168 = p168;
    }

    public Int2DoubleMap getP168() {
        return p168;
    }

    public void setP169(Int2FloatMap p169) {
        this.p169 = p169;
    }

    public Int2FloatMap getP169() {
        return p169;
    }

    public void setP170(Int2ByteMap p170) {
        this.p170 = p170;
    }

    public Int2ByteMap getP170() {
        return p170;
    }

    public void setP171(Int2ByteMap p171) {
        this.p171 = p171;
    }

    public Int2ByteMap getP171() {
        return p171;
    }

    public void setP172(Int2ShortMap p172) {
        this.p172 = p172;
    }

    public Int2ShortMap getP172() {
        return p172;
    }

    public void setP173(Int2ShortMap p173) {
        this.p173 = p173;
    }

    public Int2ShortMap getP173() {
        return p173;
    }

    public void setP174(Int2IntMap p174) {
        this.p174 = p174;
    }

    public Int2IntMap getP174() {
        return p174;
    }

    public void setP175(Int2IntMap p175) {
        this.p175 = p175;
    }

    public Int2IntMap getP175() {
        return p175;
    }

    public void setP176(Int2IntMap p176) {
        this.p176 = p176;
    }

    public Int2IntMap getP176() {
        return p176;
    }

    public void setP177(Int2IntMap p177) {
        this.p177 = p177;
    }

    public Int2IntMap getP177() {
        return p177;
    }

    public void setP178(Int2IntMap p178) {
        this.p178 = p178;
    }

    public Int2IntMap getP178() {
        return p178;
    }

    public void setP179(Int2LongMap p179) {
        this.p179 = p179;
    }

    public Int2LongMap getP179() {
        return p179;
    }

    public void setP180(Int2LongMap p180) {
        this.p180 = p180;
    }

    public Int2LongMap getP180() {
        return p180;
    }

    public void setP181(Int2LongMap p181) {
        this.p181 = p181;
    }

    public Int2LongMap getP181() {
        return p181;
    }

    public void setP182(Int2LongMap p182) {
        this.p182 = p182;
    }

    public Int2LongMap getP182() {
        return p182;
    }

    public void setP183(Int2LongMap p183) {
        this.p183 = p183;
    }

    public Int2LongMap getP183() {
        return p183;
    }

    public void setP184(Int2ObjectMap<String> p184) {
        this.p184 = p184;
    }

    public Int2ObjectMap<String> getP184() {
        return p184;
    }

    public void setP185(Int2DoubleMap p185) {
        this.p185 = p185;
    }

    public Int2DoubleMap getP185() {
        return p185;
    }

    public void setP186(Int2FloatMap p186) {
        this.p186 = p186;
    }

    public Int2FloatMap getP186() {
        return p186;
    }

    public void setP187(Int2ByteMap p187) {
        this.p187 = p187;
    }

    public Int2ByteMap getP187() {
        return p187;
    }

    public void setP188(Int2ByteMap p188) {
        this.p188 = p188;
    }

    public Int2ByteMap getP188() {
        return p188;
    }

    public void setP189(Int2ShortMap p189) {
        this.p189 = p189;
    }

    public Int2ShortMap getP189() {
        return p189;
    }

    public void setP190(Int2ShortMap p190) {
        this.p190 = p190;
    }

    public Int2ShortMap getP190() {
        return p190;
    }

    public void setP191(Int2IntMap p191) {
        this.p191 = p191;
    }

    public Int2IntMap getP191() {
        return p191;
    }

    public void setP192(Int2IntMap p192) {
        this.p192 = p192;
    }

    public Int2IntMap getP192() {
        return p192;
    }

    public void setP193(Int2IntMap p193) {
        this.p193 = p193;
    }

    public Int2IntMap getP193() {
        return p193;
    }

    public void setP194(Int2IntMap p194) {
        this.p194 = p194;
    }

    public Int2IntMap getP194() {
        return p194;
    }

    public void setP195(Int2IntMap p195) {
        this.p195 = p195;
    }

    public Int2IntMap getP195() {
        return p195;
    }

    public void setP196(Int2LongMap p196) {
        this.p196 = p196;
    }

    public Int2LongMap getP196() {
        return p196;
    }

    public void setP197(Int2LongMap p197) {
        this.p197 = p197;
    }

    public Int2LongMap getP197() {
        return p197;
    }

    public void setP198(Int2LongMap p198) {
        this.p198 = p198;
    }

    public Int2LongMap getP198() {
        return p198;
    }

    public void setP199(Int2LongMap p199) {
        this.p199 = p199;
    }

    public Int2LongMap getP199() {
        return p199;
    }

    public void setP200(Int2LongMap p200) {
        this.p200 = p200;
    }

    public Int2LongMap getP200() {
        return p200;
    }

    public void setP201(Int2ObjectMap<String> p201) {
        this.p201 = p201;
    }

    public Int2ObjectMap<String> getP201() {
        return p201;
    }

    public void setP202(Int2DoubleMap p202) {
        this.p202 = p202;
    }

    public Int2DoubleMap getP202() {
        return p202;
    }

    public void setP203(Int2FloatMap p203) {
        this.p203 = p203;
    }

    public Int2FloatMap getP203() {
        return p203;
    }

    public void setP204(Int2ByteMap p204) {
        this.p204 = p204;
    }

    public Int2ByteMap getP204() {
        return p204;
    }

    public void setP205(Int2ByteMap p205) {
        this.p205 = p205;
    }

    public Int2ByteMap getP205() {
        return p205;
    }

    public void setP206(Int2ShortMap p206) {
        this.p206 = p206;
    }

    public Int2ShortMap getP206() {
        return p206;
    }

    public void setP207(Int2ShortMap p207) {
        this.p207 = p207;
    }

    public Int2ShortMap getP207() {
        return p207;
    }

    public void setP208(Int2IntMap p208) {
        this.p208 = p208;
    }

    public Int2IntMap getP208() {
        return p208;
    }

    public void setP209(Int2IntMap p209) {
        this.p209 = p209;
    }

    public Int2IntMap getP209() {
        return p209;
    }

    public void setP210(Int2IntMap p210) {
        this.p210 = p210;
    }

    public Int2IntMap getP210() {
        return p210;
    }

    public void setP211(Int2IntMap p211) {
        this.p211 = p211;
    }

    public Int2IntMap getP211() {
        return p211;
    }

    public void setP212(Int2IntMap p212) {
        this.p212 = p212;
    }

    public Int2IntMap getP212() {
        return p212;
    }

    public void setP213(Int2LongMap p213) {
        this.p213 = p213;
    }

    public Int2LongMap getP213() {
        return p213;
    }

    public void setP214(Int2LongMap p214) {
        this.p214 = p214;
    }

    public Int2LongMap getP214() {
        return p214;
    }

    public void setP215(Int2LongMap p215) {
        this.p215 = p215;
    }

    public Int2LongMap getP215() {
        return p215;
    }

    public void setP216(Int2LongMap p216) {
        this.p216 = p216;
    }

    public Int2LongMap getP216() {
        return p216;
    }

    public void setP217(Int2LongMap p217) {
        this.p217 = p217;
    }

    public Int2LongMap getP217() {
        return p217;
    }

    public void setP218(Int2ObjectMap<String> p218) {
        this.p218 = p218;
    }

    public Int2ObjectMap<String> getP218() {
        return p218;
    }

    public void setP219(Int2DoubleMap p219) {
        this.p219 = p219;
    }

    public Int2DoubleMap getP219() {
        return p219;
    }

    public void setP220(Int2FloatMap p220) {
        this.p220 = p220;
    }

    public Int2FloatMap getP220() {
        return p220;
    }

    public void setP221(Int2ByteMap p221) {
        this.p221 = p221;
    }

    public Int2ByteMap getP221() {
        return p221;
    }

    public void setP222(Int2ByteMap p222) {
        this.p222 = p222;
    }

    public Int2ByteMap getP222() {
        return p222;
    }

    public void setP223(Int2ShortMap p223) {
        this.p223 = p223;
    }

    public Int2ShortMap getP223() {
        return p223;
    }

    public void setP224(Int2ShortMap p224) {
        this.p224 = p224;
    }

    public Int2ShortMap getP224() {
        return p224;
    }

    public void setP225(Int2IntMap p225) {
        this.p225 = p225;
    }

    public Int2IntMap getP225() {
        return p225;
    }

    public void setP226(Int2IntMap p226) {
        this.p226 = p226;
    }

    public Int2IntMap getP226() {
        return p226;
    }

    public void setP227(Int2IntMap p227) {
        this.p227 = p227;
    }

    public Int2IntMap getP227() {
        return p227;
    }

    public void setP228(Int2IntMap p228) {
        this.p228 = p228;
    }

    public Int2IntMap getP228() {
        return p228;
    }

    public void setP229(Int2IntMap p229) {
        this.p229 = p229;
    }

    public Int2IntMap getP229() {
        return p229;
    }

    public void setP230(Int2LongMap p230) {
        this.p230 = p230;
    }

    public Int2LongMap getP230() {
        return p230;
    }

    public void setP231(Int2LongMap p231) {
        this.p231 = p231;
    }

    public Int2LongMap getP231() {
        return p231;
    }

    public void setP232(Int2LongMap p232) {
        this.p232 = p232;
    }

    public Int2LongMap getP232() {
        return p232;
    }

    public void setP233(Int2LongMap p233) {
        this.p233 = p233;
    }

    public Int2LongMap getP233() {
        return p233;
    }

    public void setP234(Int2LongMap p234) {
        this.p234 = p234;
    }

    public Int2LongMap getP234() {
        return p234;
    }

    public void setP235(Int2ObjectMap<String> p235) {
        this.p235 = p235;
    }

    public Int2ObjectMap<String> getP235() {
        return p235;
    }

    public void setP236(Int2DoubleMap p236) {
        this.p236 = p236;
    }

    public Int2DoubleMap getP236() {
        return p236;
    }

    public void setP237(Int2FloatMap p237) {
        this.p237 = p237;
    }

    public Int2FloatMap getP237() {
        return p237;
    }

    public void setP238(Long2ByteMap p238) {
        this.p238 = p238;
    }

    public Long2ByteMap getP238() {
        return p238;
    }

    public void setP239(Long2ByteMap p239) {
        this.p239 = p239;
    }

    public Long2ByteMap getP239() {
        return p239;
    }

    public void setP240(Long2ShortMap p240) {
        this.p240 = p240;
    }

    public Long2ShortMap getP240() {
        return p240;
    }

    public void setP241(Long2ShortMap p241) {
        this.p241 = p241;
    }

    public Long2ShortMap getP241() {
        return p241;
    }

    public void setP242(Long2IntMap p242) {
        this.p242 = p242;
    }

    public Long2IntMap getP242() {
        return p242;
    }

    public void setP243(Long2IntMap p243) {
        this.p243 = p243;
    }

    public Long2IntMap getP243() {
        return p243;
    }

    public void setP244(Long2IntMap p244) {
        this.p244 = p244;
    }

    public Long2IntMap getP244() {
        return p244;
    }

    public void setP245(Long2IntMap p245) {
        this.p245 = p245;
    }

    public Long2IntMap getP245() {
        return p245;
    }

    public void setP246(Long2IntMap p246) {
        this.p246 = p246;
    }

    public Long2IntMap getP246() {
        return p246;
    }

    public void setP247(Long2LongMap p247) {
        this.p247 = p247;
    }

    public Long2LongMap getP247() {
        return p247;
    }

    public void setP248(Long2LongMap p248) {
        this.p248 = p248;
    }

    public Long2LongMap getP248() {
        return p248;
    }

    public void setP249(Long2LongMap p249) {
        this.p249 = p249;
    }

    public Long2LongMap getP249() {
        return p249;
    }

    public void setP250(Long2LongMap p250) {
        this.p250 = p250;
    }

    public Long2LongMap getP250() {
        return p250;
    }

    public void setP251(Long2LongMap p251) {
        this.p251 = p251;
    }

    public Long2LongMap getP251() {
        return p251;
    }

    public void setP252(Long2ObjectMap<String> p252) {
        this.p252 = p252;
    }

    public Long2ObjectMap<String> getP252() {
        return p252;
    }

    public void setP253(Long2DoubleMap p253) {
        this.p253 = p253;
    }

    public Long2DoubleMap getP253() {
        return p253;
    }

    public void setP254(Long2FloatMap p254) {
        this.p254 = p254;
    }

    public Long2FloatMap getP254() {
        return p254;
    }

    public void setP255(Long2ByteMap p255) {
        this.p255 = p255;
    }

    public Long2ByteMap getP255() {
        return p255;
    }

    public void setP256(Long2ByteMap p256) {
        this.p256 = p256;
    }

    public Long2ByteMap getP256() {
        return p256;
    }

    public void setP257(Long2ShortMap p257) {
        this.p257 = p257;
    }

    public Long2ShortMap getP257() {
        return p257;
    }

    public void setP258(Long2ShortMap p258) {
        this.p258 = p258;
    }

    public Long2ShortMap getP258() {
        return p258;
    }

    public void setP259(Long2IntMap p259) {
        this.p259 = p259;
    }

    public Long2IntMap getP259() {
        return p259;
    }

    public void setP260(Long2IntMap p260) {
        this.p260 = p260;
    }

    public Long2IntMap getP260() {
        return p260;
    }

    public void setP261(Long2IntMap p261) {
        this.p261 = p261;
    }

    public Long2IntMap getP261() {
        return p261;
    }

    public void setP262(Long2IntMap p262) {
        this.p262 = p262;
    }

    public Long2IntMap getP262() {
        return p262;
    }

    public void setP263(Long2IntMap p263) {
        this.p263 = p263;
    }

    public Long2IntMap getP263() {
        return p263;
    }

    public void setP264(Long2LongMap p264) {
        this.p264 = p264;
    }

    public Long2LongMap getP264() {
        return p264;
    }

    public void setP265(Long2LongMap p265) {
        this.p265 = p265;
    }

    public Long2LongMap getP265() {
        return p265;
    }

    public void setP266(Long2LongMap p266) {
        this.p266 = p266;
    }

    public Long2LongMap getP266() {
        return p266;
    }

    public void setP267(Long2LongMap p267) {
        this.p267 = p267;
    }

    public Long2LongMap getP267() {
        return p267;
    }

    public void setP268(Long2LongMap p268) {
        this.p268 = p268;
    }

    public Long2LongMap getP268() {
        return p268;
    }

    public void setP269(Long2ObjectMap<String> p269) {
        this.p269 = p269;
    }

    public Long2ObjectMap<String> getP269() {
        return p269;
    }

    public void setP270(Long2DoubleMap p270) {
        this.p270 = p270;
    }

    public Long2DoubleMap getP270() {
        return p270;
    }

    public void setP271(Long2FloatMap p271) {
        this.p271 = p271;
    }

    public Long2FloatMap getP271() {
        return p271;
    }

    public void setP272(Long2ByteMap p272) {
        this.p272 = p272;
    }

    public Long2ByteMap getP272() {
        return p272;
    }

    public void setP273(Long2ByteMap p273) {
        this.p273 = p273;
    }

    public Long2ByteMap getP273() {
        return p273;
    }

    public void setP274(Long2ShortMap p274) {
        this.p274 = p274;
    }

    public Long2ShortMap getP274() {
        return p274;
    }

    public void setP275(Long2ShortMap p275) {
        this.p275 = p275;
    }

    public Long2ShortMap getP275() {
        return p275;
    }

    public void setP276(Long2IntMap p276) {
        this.p276 = p276;
    }

    public Long2IntMap getP276() {
        return p276;
    }

    public void setP277(Long2IntMap p277) {
        this.p277 = p277;
    }

    public Long2IntMap getP277() {
        return p277;
    }

    public void setP278(Long2IntMap p278) {
        this.p278 = p278;
    }

    public Long2IntMap getP278() {
        return p278;
    }

    public void setP279(Long2IntMap p279) {
        this.p279 = p279;
    }

    public Long2IntMap getP279() {
        return p279;
    }

    public void setP280(Long2IntMap p280) {
        this.p280 = p280;
    }

    public Long2IntMap getP280() {
        return p280;
    }

    public void setP281(Long2LongMap p281) {
        this.p281 = p281;
    }

    public Long2LongMap getP281() {
        return p281;
    }

    public void setP282(Long2LongMap p282) {
        this.p282 = p282;
    }

    public Long2LongMap getP282() {
        return p282;
    }

    public void setP283(Long2LongMap p283) {
        this.p283 = p283;
    }

    public Long2LongMap getP283() {
        return p283;
    }

    public void setP284(Long2LongMap p284) {
        this.p284 = p284;
    }

    public Long2LongMap getP284() {
        return p284;
    }

    public void setP285(Long2LongMap p285) {
        this.p285 = p285;
    }

    public Long2LongMap getP285() {
        return p285;
    }

    public void setP286(Long2ObjectMap<String> p286) {
        this.p286 = p286;
    }

    public Long2ObjectMap<String> getP286() {
        return p286;
    }

    public void setP287(Long2DoubleMap p287) {
        this.p287 = p287;
    }

    public Long2DoubleMap getP287() {
        return p287;
    }

    public void setP288(Long2FloatMap p288) {
        this.p288 = p288;
    }

    public Long2FloatMap getP288() {
        return p288;
    }

    public void setP289(Long2ByteMap p289) {
        this.p289 = p289;
    }

    public Long2ByteMap getP289() {
        return p289;
    }

    public void setP290(Long2ByteMap p290) {
        this.p290 = p290;
    }

    public Long2ByteMap getP290() {
        return p290;
    }

    public void setP291(Long2ShortMap p291) {
        this.p291 = p291;
    }

    public Long2ShortMap getP291() {
        return p291;
    }

    public void setP292(Long2ShortMap p292) {
        this.p292 = p292;
    }

    public Long2ShortMap getP292() {
        return p292;
    }

    public void setP293(Long2IntMap p293) {
        this.p293 = p293;
    }

    public Long2IntMap getP293() {
        return p293;
    }

    public void setP294(Long2IntMap p294) {
        this.p294 = p294;
    }

    public Long2IntMap getP294() {
        return p294;
    }

    public void setP295(Long2IntMap p295) {
        this.p295 = p295;
    }

    public Long2IntMap getP295() {
        return p295;
    }

    public void setP296(Long2IntMap p296) {
        this.p296 = p296;
    }

    public Long2IntMap getP296() {
        return p296;
    }

    public void setP297(Long2IntMap p297) {
        this.p297 = p297;
    }

    public Long2IntMap getP297() {
        return p297;
    }

    public void setP298(Long2LongMap p298) {
        this.p298 = p298;
    }

    public Long2LongMap getP298() {
        return p298;
    }

    public void setP299(Long2LongMap p299) {
        this.p299 = p299;
    }

    public Long2LongMap getP299() {
        return p299;
    }

    public void setP300(Long2LongMap p300) {
        this.p300 = p300;
    }

    public Long2LongMap getP300() {
        return p300;
    }

    public void setP301(Long2LongMap p301) {
        this.p301 = p301;
    }

    public Long2LongMap getP301() {
        return p301;
    }

    public void setP302(Long2LongMap p302) {
        this.p302 = p302;
    }

    public Long2LongMap getP302() {
        return p302;
    }

    public void setP303(Long2ObjectMap<String> p303) {
        this.p303 = p303;
    }

    public Long2ObjectMap<String> getP303() {
        return p303;
    }

    public void setP304(Long2DoubleMap p304) {
        this.p304 = p304;
    }

    public Long2DoubleMap getP304() {
        return p304;
    }

    public void setP305(Long2FloatMap p305) {
        this.p305 = p305;
    }

    public Long2FloatMap getP305() {
        return p305;
    }

    public void setP306(Long2ByteMap p306) {
        this.p306 = p306;
    }

    public Long2ByteMap getP306() {
        return p306;
    }

    public void setP307(Long2ByteMap p307) {
        this.p307 = p307;
    }

    public Long2ByteMap getP307() {
        return p307;
    }

    public void setP308(Long2ShortMap p308) {
        this.p308 = p308;
    }

    public Long2ShortMap getP308() {
        return p308;
    }

    public void setP309(Long2ShortMap p309) {
        this.p309 = p309;
    }

    public Long2ShortMap getP309() {
        return p309;
    }

    public void setP310(Long2IntMap p310) {
        this.p310 = p310;
    }

    public Long2IntMap getP310() {
        return p310;
    }

    public void setP311(Long2IntMap p311) {
        this.p311 = p311;
    }

    public Long2IntMap getP311() {
        return p311;
    }

    public void setP312(Long2IntMap p312) {
        this.p312 = p312;
    }

    public Long2IntMap getP312() {
        return p312;
    }

    public void setP313(Long2IntMap p313) {
        this.p313 = p313;
    }

    public Long2IntMap getP313() {
        return p313;
    }

    public void setP314(Long2IntMap p314) {
        this.p314 = p314;
    }

    public Long2IntMap getP314() {
        return p314;
    }

    public void setP315(Long2LongMap p315) {
        this.p315 = p315;
    }

    public Long2LongMap getP315() {
        return p315;
    }

    public void setP316(Long2LongMap p316) {
        this.p316 = p316;
    }

    public Long2LongMap getP316() {
        return p316;
    }

    public void setP317(Long2LongMap p317) {
        this.p317 = p317;
    }

    public Long2LongMap getP317() {
        return p317;
    }

    public void setP318(Long2LongMap p318) {
        this.p318 = p318;
    }

    public Long2LongMap getP318() {
        return p318;
    }

    public void setP319(Long2LongMap p319) {
        this.p319 = p319;
    }

    public Long2LongMap getP319() {
        return p319;
    }

    public void setP320(Long2ObjectMap<String> p320) {
        this.p320 = p320;
    }

    public Long2ObjectMap<String> getP320() {
        return p320;
    }

    public void setP321(Long2DoubleMap p321) {
        this.p321 = p321;
    }

    public Long2DoubleMap getP321() {
        return p321;
    }

    public void setP322(Long2FloatMap p322) {
        this.p322 = p322;
    }

    public Long2FloatMap getP322() {
        return p322;
    }

    public void setP323(Object2ByteMap<String> p323) {
        this.p323 = p323;
    }

    public Object2ByteMap<String> getP323() {
        return p323;
    }

    public void setP324(Object2ByteMap<String> p324) {
        this.p324 = p324;
    }

    public Object2ByteMap<String> getP324() {
        return p324;
    }

    public void setP325(Object2ShortMap<String> p325) {
        this.p325 = p325;
    }

    public Object2ShortMap<String> getP325() {
        return p325;
    }

    public void setP326(Object2ShortMap<String> p326) {
        this.p326 = p326;
    }

    public Object2ShortMap<String> getP326() {
        return p326;
    }

    public void setP327(Object2IntMap<String> p327) {
        this.p327 = p327;
    }

    public Object2IntMap<String> getP327() {
        return p327;
    }

    public void setP328(Object2IntMap<String> p328) {
        this.p328 = p328;
    }

    public Object2IntMap<String> getP328() {
        return p328;
    }

    public void setP329(Object2IntMap<String> p329) {
        this.p329 = p329;
    }

    public Object2IntMap<String> getP329() {
        return p329;
    }

    public void setP330(Object2IntMap<String> p330) {
        this.p330 = p330;
    }

    public Object2IntMap<String> getP330() {
        return p330;
    }

    public void setP331(Object2IntMap<String> p331) {
        this.p331 = p331;
    }

    public Object2IntMap<String> getP331() {
        return p331;
    }

    public void setP332(Object2LongMap<String> p332) {
        this.p332 = p332;
    }

    public Object2LongMap<String> getP332() {
        return p332;
    }

    public void setP333(Object2LongMap<String> p333) {
        this.p333 = p333;
    }

    public Object2LongMap<String> getP333() {
        return p333;
    }

    public void setP334(Object2LongMap<String> p334) {
        this.p334 = p334;
    }

    public Object2LongMap<String> getP334() {
        return p334;
    }

    public void setP335(Object2LongMap<String> p335) {
        this.p335 = p335;
    }

    public Object2LongMap<String> getP335() {
        return p335;
    }

    public void setP336(Object2LongMap<String> p336) {
        this.p336 = p336;
    }

    public Object2LongMap<String> getP336() {
        return p336;
    }

    public void setP337(Map<String,String> p337) {
        this.p337 = p337;
    }

    public Map<String,String> getP337() {
        return p337;
    }

    public void setP338(Object2DoubleMap<String> p338) {
        this.p338 = p338;
    }

    public Object2DoubleMap<String> getP338() {
        return p338;
    }

    public void setP339(Object2FloatMap<String> p339) {
        this.p339 = p339;
    }

    public Object2FloatMap<String> getP339() {
        return p339;
    }

    public void setP340(Double2ByteMap p340) {
        this.p340 = p340;
    }

    public Double2ByteMap getP340() {
        return p340;
    }

    public void setP341(Double2ByteMap p341) {
        this.p341 = p341;
    }

    public Double2ByteMap getP341() {
        return p341;
    }

    public void setP342(Double2ShortMap p342) {
        this.p342 = p342;
    }

    public Double2ShortMap getP342() {
        return p342;
    }

    public void setP343(Double2ShortMap p343) {
        this.p343 = p343;
    }

    public Double2ShortMap getP343() {
        return p343;
    }

    public void setP344(Double2IntMap p344) {
        this.p344 = p344;
    }

    public Double2IntMap getP344() {
        return p344;
    }

    public void setP345(Double2IntMap p345) {
        this.p345 = p345;
    }

    public Double2IntMap getP345() {
        return p345;
    }

    public void setP346(Double2IntMap p346) {
        this.p346 = p346;
    }

    public Double2IntMap getP346() {
        return p346;
    }

    public void setP347(Double2IntMap p347) {
        this.p347 = p347;
    }

    public Double2IntMap getP347() {
        return p347;
    }

    public void setP348(Double2IntMap p348) {
        this.p348 = p348;
    }

    public Double2IntMap getP348() {
        return p348;
    }

    public void setP349(Double2LongMap p349) {
        this.p349 = p349;
    }

    public Double2LongMap getP349() {
        return p349;
    }

    public void setP350(Double2LongMap p350) {
        this.p350 = p350;
    }

    public Double2LongMap getP350() {
        return p350;
    }

    public void setP351(Double2LongMap p351) {
        this.p351 = p351;
    }

    public Double2LongMap getP351() {
        return p351;
    }

    public void setP352(Double2LongMap p352) {
        this.p352 = p352;
    }

    public Double2LongMap getP352() {
        return p352;
    }

    public void setP353(Double2LongMap p353) {
        this.p353 = p353;
    }

    public Double2LongMap getP353() {
        return p353;
    }

    public void setP354(Double2ObjectMap<String> p354) {
        this.p354 = p354;
    }

    public Double2ObjectMap<String> getP354() {
        return p354;
    }

    public void setP355(Double2DoubleMap p355) {
        this.p355 = p355;
    }

    public Double2DoubleMap getP355() {
        return p355;
    }

    public void setP356(Double2FloatMap p356) {
        this.p356 = p356;
    }

    public Double2FloatMap getP356() {
        return p356;
    }

    public void setP357(Float2ByteMap p357) {
        this.p357 = p357;
    }

    public Float2ByteMap getP357() {
        return p357;
    }

    public void setP358(Float2ByteMap p358) {
        this.p358 = p358;
    }

    public Float2ByteMap getP358() {
        return p358;
    }

    public void setP359(Float2ShortMap p359) {
        this.p359 = p359;
    }

    public Float2ShortMap getP359() {
        return p359;
    }

    public void setP360(Float2ShortMap p360) {
        this.p360 = p360;
    }

    public Float2ShortMap getP360() {
        return p360;
    }

    public void setP361(Float2IntMap p361) {
        this.p361 = p361;
    }

    public Float2IntMap getP361() {
        return p361;
    }

    public void setP362(Float2IntMap p362) {
        this.p362 = p362;
    }

    public Float2IntMap getP362() {
        return p362;
    }

    public void setP363(Float2IntMap p363) {
        this.p363 = p363;
    }

    public Float2IntMap getP363() {
        return p363;
    }

    public void setP364(Float2IntMap p364) {
        this.p364 = p364;
    }

    public Float2IntMap getP364() {
        return p364;
    }

    public void setP365(Float2IntMap p365) {
        this.p365 = p365;
    }

    public Float2IntMap getP365() {
        return p365;
    }

    public void setP366(Float2LongMap p366) {
        this.p366 = p366;
    }

    public Float2LongMap getP366() {
        return p366;
    }

    public void setP367(Float2LongMap p367) {
        this.p367 = p367;
    }

    public Float2LongMap getP367() {
        return p367;
    }

    public void setP368(Float2LongMap p368) {
        this.p368 = p368;
    }

    public Float2LongMap getP368() {
        return p368;
    }

    public void setP369(Float2LongMap p369) {
        this.p369 = p369;
    }

    public Float2LongMap getP369() {
        return p369;
    }

    public void setP370(Float2LongMap p370) {
        this.p370 = p370;
    }

    public Float2LongMap getP370() {
        return p370;
    }

    public void setP371(Float2ObjectMap<String> p371) {
        this.p371 = p371;
    }

    public Float2ObjectMap<String> getP371() {
        return p371;
    }

    public void setP372(Float2DoubleMap p372) {
        this.p372 = p372;
    }

    public Float2DoubleMap getP372() {
        return p372;
    }

    public void setP373(Float2FloatMap p373) {
        this.p373 = p373;
    }

    public Float2FloatMap getP373() {
        return p373;
    }

    public void setP374(Byte2ObjectMap<FullEnum0> p374) {
        this.p374 = p374;
    }

    public Byte2ObjectMap<FullEnum0> getP374() {
        return p374;
    }

    public void setP375(Byte2ObjectMap<FullMessage0> p375) {
        this.p375 = p375;
    }

    public Byte2ObjectMap<FullMessage0> getP375() {
        return p375;
    }

    public void setP376(Byte2ObjectMap<FullMessage0> p376) {
        this.p376 = p376;
    }

    public Byte2ObjectMap<FullMessage0> getP376() {
        return p376;
    }

    public void setP377(Byte2ObjectMap<FullEnum0> p377) {
        this.p377 = p377;
    }

    public Byte2ObjectMap<FullEnum0> getP377() {
        return p377;
    }

    public void setP378(Byte2ObjectMap<FullMessage0> p378) {
        this.p378 = p378;
    }

    public Byte2ObjectMap<FullMessage0> getP378() {
        return p378;
    }

    public void setP379(Byte2ObjectMap<FullMessage0> p379) {
        this.p379 = p379;
    }

    public Byte2ObjectMap<FullMessage0> getP379() {
        return p379;
    }

    public void setP380(Short2ObjectMap<FullEnum0> p380) {
        this.p380 = p380;
    }

    public Short2ObjectMap<FullEnum0> getP380() {
        return p380;
    }

    public void setP381(Short2ObjectMap<FullMessage0> p381) {
        this.p381 = p381;
    }

    public Short2ObjectMap<FullMessage0> getP381() {
        return p381;
    }

    public void setP382(Short2ObjectMap<FullMessage0> p382) {
        this.p382 = p382;
    }

    public Short2ObjectMap<FullMessage0> getP382() {
        return p382;
    }

    public void setP383(Short2ObjectMap<FullEnum0> p383) {
        this.p383 = p383;
    }

    public Short2ObjectMap<FullEnum0> getP383() {
        return p383;
    }

    public void setP384(Short2ObjectMap<FullMessage0> p384) {
        this.p384 = p384;
    }

    public Short2ObjectMap<FullMessage0> getP384() {
        return p384;
    }

    public void setP385(Short2ObjectMap<FullMessage0> p385) {
        this.p385 = p385;
    }

    public Short2ObjectMap<FullMessage0> getP385() {
        return p385;
    }

    public void setP386(Int2ObjectMap<FullEnum0> p386) {
        this.p386 = p386;
    }

    public Int2ObjectMap<FullEnum0> getP386() {
        return p386;
    }

    public void setP387(Int2ObjectMap<FullMessage0> p387) {
        this.p387 = p387;
    }

    public Int2ObjectMap<FullMessage0> getP387() {
        return p387;
    }

    public void setP388(Int2ObjectMap<FullMessage0> p388) {
        this.p388 = p388;
    }

    public Int2ObjectMap<FullMessage0> getP388() {
        return p388;
    }

    public void setP389(Int2ObjectMap<FullEnum0> p389) {
        this.p389 = p389;
    }

    public Int2ObjectMap<FullEnum0> getP389() {
        return p389;
    }

    public void setP390(Int2ObjectMap<FullMessage0> p390) {
        this.p390 = p390;
    }

    public Int2ObjectMap<FullMessage0> getP390() {
        return p390;
    }

    public void setP391(Int2ObjectMap<FullMessage0> p391) {
        this.p391 = p391;
    }

    public Int2ObjectMap<FullMessage0> getP391() {
        return p391;
    }

    public void setP392(Int2ObjectMap<FullEnum0> p392) {
        this.p392 = p392;
    }

    public Int2ObjectMap<FullEnum0> getP392() {
        return p392;
    }

    public void setP393(Int2ObjectMap<FullMessage0> p393) {
        this.p393 = p393;
    }

    public Int2ObjectMap<FullMessage0> getP393() {
        return p393;
    }

    public void setP394(Int2ObjectMap<FullMessage0> p394) {
        this.p394 = p394;
    }

    public Int2ObjectMap<FullMessage0> getP394() {
        return p394;
    }

    public void setP395(Int2ObjectMap<FullEnum0> p395) {
        this.p395 = p395;
    }

    public Int2ObjectMap<FullEnum0> getP395() {
        return p395;
    }

    public void setP396(Int2ObjectMap<FullMessage0> p396) {
        this.p396 = p396;
    }

    public Int2ObjectMap<FullMessage0> getP396() {
        return p396;
    }

    public void setP397(Int2ObjectMap<FullMessage0> p397) {
        this.p397 = p397;
    }

    public Int2ObjectMap<FullMessage0> getP397() {
        return p397;
    }

    public void setP398(Int2ObjectMap<FullEnum0> p398) {
        this.p398 = p398;
    }

    public Int2ObjectMap<FullEnum0> getP398() {
        return p398;
    }

    public void setP399(Int2ObjectMap<FullMessage0> p399) {
        this.p399 = p399;
    }

    public Int2ObjectMap<FullMessage0> getP399() {
        return p399;
    }

    public void setP400(Int2ObjectMap<FullMessage0> p400) {
        this.p400 = p400;
    }

    public Int2ObjectMap<FullMessage0> getP400() {
        return p400;
    }

    public void setP401(Long2ObjectMap<FullEnum0> p401) {
        this.p401 = p401;
    }

    public Long2ObjectMap<FullEnum0> getP401() {
        return p401;
    }

    public void setP402(Long2ObjectMap<FullMessage0> p402) {
        this.p402 = p402;
    }

    public Long2ObjectMap<FullMessage0> getP402() {
        return p402;
    }

    public void setP403(Long2ObjectMap<FullMessage0> p403) {
        this.p403 = p403;
    }

    public Long2ObjectMap<FullMessage0> getP403() {
        return p403;
    }

    public void setP404(Long2ObjectMap<FullEnum0> p404) {
        this.p404 = p404;
    }

    public Long2ObjectMap<FullEnum0> getP404() {
        return p404;
    }

    public void setP405(Long2ObjectMap<FullMessage0> p405) {
        this.p405 = p405;
    }

    public Long2ObjectMap<FullMessage0> getP405() {
        return p405;
    }

    public void setP406(Long2ObjectMap<FullMessage0> p406) {
        this.p406 = p406;
    }

    public Long2ObjectMap<FullMessage0> getP406() {
        return p406;
    }

    public void setP407(Long2ObjectMap<FullEnum0> p407) {
        this.p407 = p407;
    }

    public Long2ObjectMap<FullEnum0> getP407() {
        return p407;
    }

    public void setP408(Long2ObjectMap<FullMessage0> p408) {
        this.p408 = p408;
    }

    public Long2ObjectMap<FullMessage0> getP408() {
        return p408;
    }

    public void setP409(Long2ObjectMap<FullMessage0> p409) {
        this.p409 = p409;
    }

    public Long2ObjectMap<FullMessage0> getP409() {
        return p409;
    }

    public void setP410(Long2ObjectMap<FullEnum0> p410) {
        this.p410 = p410;
    }

    public Long2ObjectMap<FullEnum0> getP410() {
        return p410;
    }

    public void setP411(Long2ObjectMap<FullMessage0> p411) {
        this.p411 = p411;
    }

    public Long2ObjectMap<FullMessage0> getP411() {
        return p411;
    }

    public void setP412(Long2ObjectMap<FullMessage0> p412) {
        this.p412 = p412;
    }

    public Long2ObjectMap<FullMessage0> getP412() {
        return p412;
    }

    public void setP413(Long2ObjectMap<FullEnum0> p413) {
        this.p413 = p413;
    }

    public Long2ObjectMap<FullEnum0> getP413() {
        return p413;
    }

    public void setP414(Long2ObjectMap<FullMessage0> p414) {
        this.p414 = p414;
    }

    public Long2ObjectMap<FullMessage0> getP414() {
        return p414;
    }

    public void setP415(Long2ObjectMap<FullMessage0> p415) {
        this.p415 = p415;
    }

    public Long2ObjectMap<FullMessage0> getP415() {
        return p415;
    }

    public void setP416(Map<String,FullEnum0> p416) {
        this.p416 = p416;
    }

    public Map<String,FullEnum0> getP416() {
        return p416;
    }

    public void setP417(Map<String,FullMessage0> p417) {
        this.p417 = p417;
    }

    public Map<String,FullMessage0> getP417() {
        return p417;
    }

    public void setP418(Map<String,FullMessage0> p418) {
        this.p418 = p418;
    }

    public Map<String,FullMessage0> getP418() {
        return p418;
    }

    public void setP419(Double2ObjectMap<FullEnum0> p419) {
        this.p419 = p419;
    }

    public Double2ObjectMap<FullEnum0> getP419() {
        return p419;
    }

    public void setP420(Double2ObjectMap<FullMessage0> p420) {
        this.p420 = p420;
    }

    public Double2ObjectMap<FullMessage0> getP420() {
        return p420;
    }

    public void setP421(Double2ObjectMap<FullMessage0> p421) {
        this.p421 = p421;
    }

    public Double2ObjectMap<FullMessage0> getP421() {
        return p421;
    }

    public void setP422(Float2ObjectMap<FullEnum0> p422) {
        this.p422 = p422;
    }

    public Float2ObjectMap<FullEnum0> getP422() {
        return p422;
    }

    public void setP423(Float2ObjectMap<FullMessage0> p423) {
        this.p423 = p423;
    }

    public Float2ObjectMap<FullMessage0> getP423() {
        return p423;
    }

    public void setP424(Float2ObjectMap<FullMessage0> p424) {
        this.p424 = p424;
    }

    public Float2ObjectMap<FullMessage0> getP424() {
        return p424;
    }

}
