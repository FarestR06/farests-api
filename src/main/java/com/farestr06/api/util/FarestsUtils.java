package com.farestr06.api.util;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

import java.net.URI;

public class FarestsUtils {
    /**
     * Tells a game screen to open a URL.
     * @param screen The screen to open the URL in
     * @param url The URL to open
     */
    public static void openUrl(Screen screen, String url) {
        screen.handleTextClick(Style.EMPTY.withClickEvent(new ClickEvent.OpenUrl(URI.create(url))));
    }

    /**
     * Creates a cuboid shape that is centered on all axes.
     * @param width The width (X axis) of the cuboid shape
     * @param height The height (Y axis) of the cuboid shape
     * @param depth The depth (Z axis) of the cuboid shape
     * @return The cuboid shape with a shape calculated using the three parameters
     */
    public static VoxelShape centeredBox(double width, double height, double depth) {
        double widthStart = (16d - width) / 2d;
        double heightStart = (16d - height) / 2d;
        double depthStart = (16d - depth) / 2d;
        double widthEnd = width - widthStart;
        double heightEnd = height - heightStart;
        double depthEnd = depth - depthStart;
        return Block.createCuboidShape(widthStart, heightStart, depthStart, widthEnd, heightEnd, depthEnd);
    }

    /**
     * Creates a cuboid shape that is centered on the X and Z axes and is aligned with the floor along the Y axis.
     * @param width The width (X axis) of the cuboid shape
     * @param height The height (Y axis) of the cuboid shape
     * @param depth The depth (Z axis) of the cuboid shape
     * @return The cuboid shape with a shape calculated using the three parameters
     */
    public static VoxelShape centeredFlooredCuboid(double width, double height, double depth) {
        double widthStart = (16d - width) / 2d;
        double depthStart = (16d - depth) / 2d;
        double widthEnd = width - widthStart;
        double depthEnd = depth - depthStart;
        return Block.createCuboidShape(widthStart, 0, depthStart, widthEnd, height, depthEnd);
    }

    public static class Math {
        /**
         * Rounds a value to a fraction with the specified denominator
         * @param value The value to be rounded
         * @param divisorOfOne The denominator of the fraction to round to
         * @return
         */
        public static double roundToFraction(double value, int divisorOfOne) {
            return java.lang.Math.round(value * divisorOfOne) / ((double) divisorOfOne);
        }


        /**
         * Rounds a value to a multiple of 0.5
         * @param value The value to be rounded
         * @return The rounded value
         */
        public static double roundToHalf(double value) {
            return java.lang.Math.round(value * 2) / 2d;
        }

        /**
         * Rounds a value to a multiple of 0.5f
         * @param value The value to be rounded
         * @return The rounded value
         */
        public static float roundToHalf(float value) {
            return java.lang.Math.round(value * 2) / 2f;
        }


        /**
         * Rounds a value to a multiple of 0.25
         * @param value The value to be rounded
         * @return The rounded value
         */
        public static double roundToQuarter(double value) {
            return java.lang.Math.round(value * 4) / 4d;
        }

        /**
         * Rounds a value to a multiple of 0.25f
         * @param value The value to be rounded
         * @return The rounded value
         */
        public static float roundToQuarter(float value) {
            return java.lang.Math.round(value * 4) / 4f;
        }


        /**
         * Rounds a value to a multiple of 0.1
         * @param value The value to be rounded
         * @return The rounded value
         */
        public static double roundToTenth(double value) {
            return java.lang.Math.round(value * 10) / 10d;
        }

        /**
         * Rounds a value to a multiple of 0.1f
         * @param value The value to be rounded
         * @return The rounded value
         */
        public static float roundToTenth(float value) {
            return java.lang.Math.round(value * 10) / 10f;
        }


        /**
         * Linearly a value and rounds it to a multiple 0.1
         * @param value The input value
         * @param oldStart The starting value of the original range
         * @param oldEnd The end value of the original range
         * @param newStart The starting value of the new range
         * @param newEnd The end value of the new range
         * @return The mapped and rounded value
         */
        public static double mapWithOneDecimalPlace(double value, double oldStart, double oldEnd, double newStart, double newEnd) {
            double mapped = MathHelper.map(value, oldStart, oldEnd, newStart, newEnd);
            return roundToTenth(mapped);
        }

        /**
         * Linearly a value and rounds it to 0.1f
         * @param value The input value
         * @param oldStart The starting value of the original range
         * @param oldEnd The end value of the original range
         * @param newStart The starting value of the new range
         * @param newEnd The end value of the new range
         * @return The mapped and rounded value
         */
        public static float mapWithOneDecimalPlace(float value, float oldStart, float oldEnd, float newStart, float newEnd) {
            float mapped = MathHelper.map(value, oldStart, oldEnd, newStart, newEnd);
            return roundToTenth(mapped);
        }

        /**
         * Creates a large float between zero and the specified bound
         * @param rand A Random object, which is used to generate the float
         * @param bound The upper bound of the generated float
         * @return A randomly generated float between 0 and the upper bound
         */
        public static float randomBigFloat(Random rand, int bound) {
            return randomBigFloat(rand, 0, bound);
        }

        /**
         * Creates a large float between the specified minimum and maximum values
         * @param rand A Random object, which is used to generate the float
         * @param min The lower bound of the generated float
         * @param max The upper bound of the generated float
         * @return A randomly generated float between the min and max
         */
        public static float randomBigFloat(Random rand, int min, int max) {
            int i = rand.nextBetween(min, max);
            return i * rand.nextFloat();
        }
    }
}
