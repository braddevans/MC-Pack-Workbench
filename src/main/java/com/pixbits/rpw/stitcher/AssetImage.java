package com.pixbits.rpw.stitcher;

import net.mightypork.rpw.tree.assets.AssetEntry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AssetImage implements Comparable<AssetImage> {
    public AssetEntry entry;
    public File file;
    public BufferedImage image;
    public StitchJson.Element element;
    public boolean placed;

    AssetImage(File file, AssetEntry entry) {
        this.file = file;
        this.entry = entry;

        placed = true;

        element = new StitchJson.Element();
        element.key = entry.getKey();
    }

    @Override
    public boolean equals(Object o) {
        return o != null & o instanceof AssetImage && entry.equals(entry);
    }

    @Override
    public int compareTo(AssetImage o) {
        int area1 = element.w * element.h;
        int area2 = element.w * element.h;

        if (area1 == area2) { return entry.getKey().compareTo(entry.getKey()); }
        else { return area2 - area1; }
    }

    public int width() {
        return element.w;
    }

    public int height() {
        return element.h;
    }

    public int x() {
        return element.x;
    }

    public int y() {
        return element.y;
    }

    public void place(int x, int y) {
        element.x = x;
        element.y = y;
    }

    public void reset() {
        place(- 1, - 1);
    }

    public void cacheImage(float w, float h) throws IOException {
        BufferedImage tmpImage = ImageIO.read(file);

        if (tmpImage.getWidth() == w && tmpImage.getHeight() == h) { image = tmpImage; }
        else {
            image = new BufferedImage((int) (tmpImage.getWidth() * w), (int) (tmpImage.getHeight() * h), tmpImage.getType());
            ((Graphics2D) image.getGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            image.getGraphics().drawImage(tmpImage, 0, 0, (int) (tmpImage.getWidth() * w), (int) (tmpImage.getHeight() * h), null);
        }

        element.w = image.getWidth();
        element.h = image.getHeight();
    }

}