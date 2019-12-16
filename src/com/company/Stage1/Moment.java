import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

import static java.lang.Math.*;

public class Moment implements PlugInFilter {
    public int setup(String args, ImagePlus im) {
        return DOES_8G;
    }

    public void run(ImageProcessor ip) {
        IJ.log(theta(ip) + " ");
    }

    public double theta(ImageProcessor ip) {
        double m20 = centralMoment(ip, 2, 0);
        double m02 = centralMoment(ip, 0, 2);
        double m11 = centralMoment(ip, 1, 1);
        double v = atan2(2 * m11, m20 - m02) / 2;
        return v;
    }

    // TAKEN FROM THE BOOK (page 235)
    public double moment(ImageProcessor I, int p, int q) {
        double Mpq = 0.0;
        for (int v = 0; v < I.getHeight(); v++) {
            for (int u = 0; u < I.getWidth(); u++) {
                if (I.getPixel(u, v) > 0) {
                    Mpq += Math.pow(u, p) * Math.pow(v, q);
                }
            }
        }
        return Mpq;
    }

    // Central moments:
    public double centralMoment(ImageProcessor I, int p, int q) {
        double m00 = moment(I, 0, 0); // region area
        double xCtr = moment(I, 1, 0) / m00;
        double yCtr = moment(I, 0, 1) / m00;
        double cMpq = 0.0;
        for (int v = 0; v < I.getHeight(); v++) {
            for (int u = 0; u < I.getWidth(); u++) {
                if (I.getPixel(u, v) > 0) {
                    cMpq += Math.pow(u - xCtr, p) * Math.pow(v - yCtr, q);
                }
            }
        }
        return cMpq;
    }

    // Normalized central moments:
    public double nCentralMoment(ImageProcessor I, int p, int q) {
        double m00 = moment(I, 0, 0);
        double norm = Math.pow(m00, 0.5 * (p + q + 2));
        return centralMoment(I, p, q) / norm;
    }
}