package com.github.ollime.ferretmod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum FerretVariant {
    CHOCOLATE_STANDARD(0),
    CHOCOLATE_MITTS(1),
    CHOCOLATE_BIB(2),
    CHOCOLATE_WITH_WHITE(3),
    BLACK_SABLE(4),
    WHITE(5),
    PANDA(6),
    SABLE_BLAZE(7),
    CHAMPAGNE_POINT(8);

    private static final FerretVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(FerretVariant::getId)).toArray(FerretVariant[]::new);
    private final int id;

    FerretVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static FerretVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
