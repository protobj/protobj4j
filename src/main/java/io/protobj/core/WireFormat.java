package io.protobj.core;

/**
 * @auther chenqiang
 * @date 2022/8/12
 */
public class WireFormat {
    public static final int WIRETYPE_VARINT = 0;//tag-value
    public static final int WIRETYPE_FIXED64 = 1;//tag-value
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;//tag-len-[index]-value
    public static final int WIRETYPE_FIXED8 = 3;//tag-value
    public static final int WIRETYPE_FIXED16 = 4;//tag-value
    public static final int WIRETYPE_FIXED32 = 5;//tag-value

    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = (1 << TAG_TYPE_BITS) - 1;

    /**
     * Given a tag value, determines the wire type (the lower 3 bits).
     */
    public static int getTagWireType(final int tag) {
        return tag & TAG_TYPE_MASK;
    }

    /**
     * Given a tag value, determines the field number (the upper 29 bits).
     */
    public static int getTagFieldNumber(final int tag) {
        return tag >>> TAG_TYPE_BITS;
    }

    /**
     * Makes a tag value given a field number and wire type.
     */
    public static int makeTag(final int fieldNumber, final int wireType) {
        return (fieldNumber << TAG_TYPE_BITS) | wireType;
    }

}
