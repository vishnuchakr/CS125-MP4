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
        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];

        double centerFactor = (double) (changedImage.length - 1) / 2;

        for (int i = 0; i < changedImage.length; i++) {
            for (int j = 0; j < changedImage[i].length; j++) {

                double temp = i - centerFactor;
                temp /= amount;
                temp += centerFactor;

                int rounded = (int) Math.round(temp);
                changedImage[i][j] = originalImage[rounded][j];
            }
        }
        return changedImage;
    }

    /**
     * Expand in the vertical axis around the image center.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];

        double centerFactor = (double) (changedImage[0].length - 1) / 2;

        for (int i = 0; i < changedImage.length; i++) {
            for (int j = 0; j < changedImage[i].length; j++) {

                double temp = j - centerFactor;
                temp /= amount;
                temp += centerFactor;

                int rounded = (int) Math.round(temp);
                changedImage[i][j] = originalImage[i][rounded];

            }
        }
        return changedImage;
    }

    /**
     * Flip the image on the horizontal axis across its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double centered = (double) (originalImage.length - 1) / 2;
                double x = i - centered;
                int newX = (int) Math.round(-x + centered);
                changedImage[i][j] = originalImage[newX][j];
            }
        }
        return changedImage;
    }

    /**
     * Flip the image on the vertical axis across its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double centered = (double) (originalImage[0].length - 1) / 2;
                double y = j - centered;
                int newY = (int) Math.round(-y + centered);
                changedImage[i][j] = originalImage[i][newY];
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
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double centeredX =  (double) (originalImage.length - 1) / 2;
                double centeredY =  (double) (originalImage[0].length - 1) / 2;
                double valX = i - centeredX;
                double valY = j - centeredY;
                int newX = (int) Math.round(-valY + centeredX);
                int newY = (int) Math.round(valX + centeredY);
                if (newX < originalImage.length && newX >= 0
                        && newY < originalImage[0].length && newY >= 0) {
                    changedImage[i][j] = originalImage[newX][newY];
                } else {
                    changedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
        }
        return changedImage;
    }


    /**
     * Rotate the image right by 90 degrees around its center.
     * @param originalImage The original image.
     * @return The pixel.
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        if (originalImage == null) {
            return null;
        }
        return rotateLeft(rotateLeft(rotateLeft(originalImage)));
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
            for (int j = 0; j < originalImage[i].length; j++) {

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
     * Shift the image left by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        //if amount is larger than dimensions
        if (amount >= originalImage.length) {
            for (int i = 0; i < changedImage.length; i++) {
                for (int j = 0; j < changedImage[i].length; j++) {
                    changedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return changedImage;
        }
        //if amount is within the dimensions
        for (int i = originalImage.length - 1; i >= amount; i--) {
            for (int j = 0; j < originalImage[0].length; j++) {
                changedImage[i - amount][j] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = originalImage.length - 1; i >= originalImage.length - amount; i--) {
            for (int j = 0; j < originalImage[0].length; j++) {
                changedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return changedImage;
    }

    /**
     * Shift the image right by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        //if amount is larger than dimensions
        if (amount >= originalImage.length) {
            for (int i = 0; i < changedImage.length; i++) {
                for (int j = 0; j < changedImage[i].length; j++) {
                    changedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return changedImage;
        }
        //if amount is within the dimensions
        for (int i = 0; i < originalImage.length - amount; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                changedImage[i + amount][j] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                changedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return changedImage;
    }

    /**
     * Shift the image down by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        //if amount is larger than dimensions
        if (amount >= originalImage[0].length) {
            for (int i = 0; i < changedImage.length; i++) {
                for (int j = 0; j < changedImage[i].length; j++) {
                    changedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return changedImage;
        }
        //if amount is within the dimensions
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length - amount; j++) {
                changedImage[i][j + amount] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < amount; j++) {
                changedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return changedImage;
    }

    /**
     * Shift the image up by the specified amount.
     * @param originalImage The original image.
     * @param amount The amount.
     * @return The pixel.
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] changedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        //if amount is larger than dimensions
        if (amount >= originalImage[0].length) {
            for (int i = 0; i < changedImage.length; i++) {
                for (int j = 0; j < changedImage[i].length; j++) {
                    changedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return changedImage;
        }
        //if amount is within the dimensions
        for (int i = 0; i < changedImage.length; i++) {
            for (int j = changedImage[0].length - 1; j >= amount; j--) {
                changedImage[i][j - amount] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = 0; i < changedImage.length; i++) {
            for (int j = changedImage[0].length - 1; j >= changedImage[0].length - amount; j--) {
                changedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return changedImage;
    }

//    /**
//     * Shrink in the horizontal axis around the image center.
//     * @param originalImage The original image.
//     * @param amount The amount.
//     * @return The pixel.
//     */
//    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage, final int amount) {
//        return null;
//    }
//
//    /**
//     * Shrink in the vertical axis around the image center.
//     * @param originalImage The original image.
//     * @param amount The amount.
//     * @return The pixel.
//     */
//    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage, final int amount) {
//        return null;
//    }
}
