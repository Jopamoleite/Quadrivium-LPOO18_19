package com.quadrivium.g13.model;

public final class GameDimensions {
    private static int width, height;
    private static boolean swing;

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        GameDimensions.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        GameDimensions.height = height;
    }

    public static boolean isSwing() {
        return swing;
    }

    public static void setSwing(boolean swing) {
        GameDimensions.swing = swing;
    }
}
