package edu.pitt.mrrc.util;

import edu.pitt.mrrc.wavelet.wavelet;

/**
 * Created by IntelliJ IDEA.
 * User: bschmidt
 * Date: 3/13/12
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class mathTest {
    public static void main( String[] args ){

        double[] b = {-1.58613434206936, -1.58613434206936};
        double[] B = {-1.58613434206936, -1.58613434206936,0,0,0,0,0,0,0,0,0,0};
        double[] X = {5, 3, 1, 0 , 2, 4, 6, 7, 5, 3, 1 ,1 };
        double[] A = {0};

        wavelet.dispArr( math.rightpad(b, 12) );
        wavelet.dispArr( math.filter(B, A, X, -11.1029403944856) );

        
        wavelet.dispArr( math.rightshift(12) );


        double[] bytwo = {1,2,3,4,5,6,7,8};
        wavelet.dispArr( math.byTwos( bytwo ));


        double[] bytwo2 = {1,2,3,4,5,6,7,8,9};
        wavelet.dispArr( math.byTwos( bytwo2 ));


        double[] bytwo3 = {1,2,3,4,5,6,7,8,9};
        wavelet.dispArr( math.byTwosAt2( bytwo2 ));


        double[] bytwo4 = {1,2,3,4,5,6,7,8};
        wavelet.dispArr( math.byTwosAt2( bytwo2 ));


        double[] x0 = {7,5,3,1,0,2,4,6,7,5,3,1};
        wavelet.dispArr( math.rightShiftX0( x0 ) );
        
        
        double[] One = {1,2};
        double[] Two = {3,4};
        wavelet.dispArr( math.concat( One, Two ) );
        
    }
}
