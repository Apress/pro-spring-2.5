package com.apress.prospring2.ch16;

import java.util.Random;

/**
 * @author janm
 */
public final class Grinch {
    private static final Random RND = new Random();
    private static final String MESSAGE = "Muhehe! It's broken now.";

    private Grinch() {

    }

    public static void ruin() {
        if (RND.nextInt() % 3 == 0) {
            System.out.println(MESSAGE);
            throw new RuntimeException(MESSAGE);
        }
    }

}
