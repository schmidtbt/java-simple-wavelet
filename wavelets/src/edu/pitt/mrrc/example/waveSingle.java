package edu.pitt.mrrc.example;

import edu.pitt.mrrc.util.math;
import edu.pitt.mrrc.wavelet.wavelet;
import edu.pitt.mrrc.*;


/**
 * Created by IntelliJ IDEA.
 * User: bschmidt
 * Date: 3/8/12
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class waveSingle {

    public static void main( String args[] ){
        double[] Y  = {7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0, 0.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0, 0.0};
        double decJ = 1;
        edu.pitt.mrrc.wavelet.wavelet.waveletcdf97( Y, decJ );

    }
}
