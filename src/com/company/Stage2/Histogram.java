package com.company.Stage2;

import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

import java.awt.*;

public class Histogram implements PlugInFilter {
    public int setup(String args, ImagePlus im) {
        return DOES_RGB;
    }

    public void run(ImageProcessor ip) {
        int width = ip.getWidth();
        int height = ip.getHeight();
        int pixel;
        int r, g, b;
        int[] red = new int[256];
        int[] green = new int[256];
        int[] blue = new int[256];
        Color color;
        // hist
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                color = new Color(ip.getPixel(col, row));
                r = color.getRed();
                g = color.getGreen();
                b = color.getBlue();
                red[r]++;
                green[g]++;
                blue[b]++;
            }
        }
        // c-hist
        double[] c_red = new double[256];
        double[] c_green = new double[256];
        double[] c_blue = new double[256];
        c_red[0] = red[0];
        c_green[0] = green[0];
        c_blue[0] = blue[0];
        for (int i = 1; i < 256; i++) {
            c_red[i] = c_red[i - 1] + red[i];
            c_green[i] = c_green[i - 1] + green[i];
            c_blue[i] = c_blue[i - 1] + blue[i];
        }

        for (int i = 0; i < 256; i++) {
            c_red[i] = c_red[i] / c_red[255];
            c_green[i] = c_green[i] / c_green[255];
            c_blue[i] = c_blue[i] / c_blue[255];
            IJ.log(c_red[i] + "");
//            IJ.log(c_green[i] + "");
//            IJ.log(c_blue[i] + "");
        }


    }
}
