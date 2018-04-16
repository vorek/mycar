package com.myauto.tools;

import java.util.UUID;

public class StringIdGenerator {
    public static String newId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
