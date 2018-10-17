package edu.illinois.cs.cs125.mp4.lib;

/**
 * A class that runs implements several simple transformations on 2D image arrays.
 */

public class Transform {

    //METHODS

    /**
     * Expand in the horizontal axis around the image center.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Expand in the vertical axis around the image center.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Flip the image on the horizontal axis across its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Flip the image on the vertical axis across its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Remove a green screen mask from an image.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if (originalImage[i][j].getGreen() > originalImage[i][j].getRed()
                    && originalImage[i][j].getGreen() > originalImage[i][j].getBlue()) {
                    changedImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    changedImage[i][j] = originalImage[i][j];
                }
            }
        }
        return changedImage;

    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Rotate the image right by 90 degrees around its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Shift the image down by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Shift the image left by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Shift the image right by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Shift the image up by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Shrink in the horizontal axis around the image center.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Shrink in the vertical axis around the image center.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }
}