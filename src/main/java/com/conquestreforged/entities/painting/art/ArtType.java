package com.conquestreforged.entities.painting.art;

import com.conquestreforged.api.util.Translateable;

import java.util.stream.Stream;

/**
 * @author dags <dags@dags.me>
 */
public enum ArtType implements Translateable {
    //row 1
    A1x1_0(16, 16, 0, 0),
    A1x1_1(16, 16, 16, 0),
    A1x1_2(16, 16, 32, 0),
    A1x1_3(16, 16, 48, 0),
    A1x1_4(16, 16, 64, 0),
    A1x1_5(16, 16, 80, 0),
    A1x1_6(16, 16, 96, 0),
    A1x1_7(16, 16, 112, 0),
    A1x1_8(16, 16, 128, 0),
    A1x1_9(16, 16, 144, 0),
    A1x1_10(16, 16, 160, 0),
    A1x1_11(16, 16, 176, 0),

    //row 2
    A1x1_12(16, 16, 0, 16),
    A1x1_13(16, 16, 16, 16),
    A1x1_14(16, 16, 32, 16),
    A1x1_15(16, 16, 48, 16),
    A1x1_16(16, 16, 64, 16),
    A1x1_17(16, 16, 80, 16),
    A1x1_18(16, 16, 96, 16),
    A1x1_19(16, 16, 112, 16),
    A1x1_20(16, 16, 128, 16),
    A1x1_21(16, 16, 144, 16),
    A1x1_22(16, 16, 160, 16),
    A1x1_23(16, 16, 176, 16),

    //row 3
    A2x1_0(32, 16, 0, 32),
    A2x1_1(32, 16, 32, 32),
    A2x1_2(32, 16, 64, 32),
    A2x1_3(32, 16, 96, 32),
    A2x1_4(32, 16, 128, 32),
    A2x1_5(32, 16, 160, 32),

    //row 4
    A2x1_6(32, 16, 0, 48),
    A2x1_7(32, 16, 32, 48),
    A2x1_8(32, 16, 64, 48),
    A2x1_9(32, 16, 96, 48),
    A2x1_10(32, 16, 128, 48),
    A2x1_11(32, 16, 160, 48),

    //row 5
    A1x2_0(16, 32, 0, 64),
    A1x2_1(16, 32, 16, 64),
    A1x2_2(16, 32, 32, 64),
    A1x2_3(16, 32, 48, 64),
    A1x2_4(16, 32, 64, 64),
    A1x2_5(16, 32, 80, 64),
    A1x2_6(16, 32, 96, 64),
    A1x2_7(16, 32, 112, 64),
    A1x2_8(16, 32, 128, 64),
    A1x2_9(16, 32, 144, 64),
    A1x2_10(16, 32, 160, 64),
    A1x2_11(16, 32, 176, 64),

    //row 6
    A4x2_0(64, 32, 0, 96),
    A4x2_1(64, 32, 64, 96),
    A4x2_2(64, 32, 128, 96),

    //row 7
    A2x2_0(32, 32, 0, 128),
    A2x2_1(32, 32, 32, 128),
    A2x2_2(32, 32, 64, 128),
    A2x2_3(32, 32, 96, 128),
    A2x2_4(32, 32, 128, 128),
    A2x2_5(32, 32, 160, 128),

    //row 8
    A2x2_6(32, 32, 0, 160),
    A2x2_7(32, 32, 32, 160),
    A2x2_8(32, 32, 64, 160),
    A2x2_9(32, 32, 96, 160),
    A2x2_10(32, 32, 128, 160),
    A2x2_11(32, 32, 160, 160),
    A2x2_12(32, 32, 192, 160),
    A2x2_13(32, 32, 224, 160),

    //row 9
    A4x4_0(64, 64, 0, 192),
    A4x4_1(64, 64, 64, 192),
    A4x4_2(64, 64, 128, 192),
    A4x4_3(64, 64, 192, 192),

    //extras
    A2x3_0(32, 48, 192, 16),
    A2x3_1(32, 48, 224, 16),
    A4x3_0(64, 48, 192, 64),
    A4x3_1(64, 48, 192, 112),
    ;

    public final int sizeX;
    public final int sizeY;
    public final int offsetX;
    public final int offsetY;
    public final String shapeId;

    ArtType(int x, int y, int offsetX, int offsetY) {
        this.sizeX = x;
        this.sizeY = y;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.shapeId = name().toLowerCase().substring(1); // trim 'A'
    }

    @Override
    public String getName() {
        return shapeId;
    }

    @Override
    public String getTranslationKey() {
        return getTranslationKey("art");
    }

    @Override
    public String getTranslationKey(String parent) {
        return parent + "." + shapeId;
    }

    @Override
    public String toString() {
        return shapeId;
    }

    public int index() {
        ArtType[] arts = ArtType.values();
        for (int i = 0; i < arts.length; i++) {
            if (arts[i] == this) {
                return i;
            }
        }
        return 0;
    }

    public static ArtType fromId(int id) {
        ArtType[] arts = ArtType.values();
        if (id > -1 && id < arts.length) {
            return arts[id];
        }
        return ArtType.A1x1_0;
    }

    public static ArtType fromName(String name) {
        try {
            return ArtType.valueOf(name.charAt(0) == 'A' ? name : "A" + name);
        } catch (Throwable t) {
            return null;
        }
    }

    public static Stream<String> getNames() {
        return Stream.of(values()).map(ArtType::toString);
    }
}
