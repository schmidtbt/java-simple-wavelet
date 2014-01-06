package edu.pitt.mrrc.util;

/**
 * Created by IntelliJ IDEA.
 * User: bschmidt
 * Date: 3/8/12
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class math {
    
    public static double fix( double value ){
        
        if( value < 0 ){
            return Math.ceil( value );
        } else {
            return Math.floor( value );
        }
    }

    public static double[] rightshift( int M1 ){

        double[] output = new double[ M1 ];

        for( int i = 0; i < M1; i++ ){
            output[i] = i+2;
        }
        output[ M1-1 ] = M1;

        return output;

    }


    public static double[] rightShiftX0( double[] X0 ){

        double[] output = new double[ X0.length ];

        for( int i = 0; i < X0.length -1; i++ ){
            output[i] = X0[i+1];
        }

        output[ X0.length -1 ] = X0[ X0.length -1 ];

        return output;

    }



    public static double[] filter( double[] B, double[] A, double[] X, double Zi ){

        /// Create the output Y of same size as input X
        double[] Y = new double[ X.length ];

        // Initial Y Value
        Y[0] = B[0] * X[0];

        for( int i = 1; i < X.length; i++ ){

            Y[i] = 0.0;
            for( int j = 0; j < i+1; j++ ){

                Y[i] = Y[i] + B[j] * X[i-j];

            }
        }

        // Apply Z shift
        Y[0] = Y[0] + Zi;

        return Y;

    }

    public static double[] rightpad( double[] X, int ReturnLength ){

        
        
        if( X.length == ReturnLength ){
            return X;
        } else {
            
            double[] output = new double[ ReturnLength ];
            
            for( int i = 0; i < X.length; i++ ){
                output[i] = X[i];
            }
            
            for( int i = X.length; i < ReturnLength; i++ ){
                output[i] = 0.0;
            }

            return output;
            
        }

    }

    public static double[] byTwos( double[] X ){

        double[] output;
        int maxIdx;

        if( X.length % 2 == 0 ){
            output = new double[ X.length / 2 ];
            maxIdx = X.length;
        } else {
            output = new double[ (X.length+1) / 2 ];
            maxIdx = X.length +1;
        }

        int counter = 0;
        for( int i = 0; i < maxIdx; i += 2 ){
            output[ counter ] = X[i];
            counter++;
        }

        return output;
    }

    public static double[] byTwosAt2( double[] X ){

        double[] output;
        int maxIdx;

        if( X.length % 2 != 0 ){
            output = new double[ X.length / 2 ];
            maxIdx = X.length;
        } else {
            output = new double[ (X.length+1) / 2 ];
            maxIdx = X.length +1;
        }

        int counter = 0;
        for( int i = 1; i < maxIdx; i += 2 ){
            output[ counter ] = X[i];
            counter++;
        }

        return output;
    }
    
    public static double[] add( double[] A, double[] B ){
        
        double[] output = new double[ A.length ]; 
        
        for( int i = 0; i < A.length; i++ ){
            
            output[i] = A[i] + B[i];
            
        }

        return output;
        
        
    }


    public static double[] multByElem( double[] A, double elem ){
        double[] output = new double[ A.length ];
        for( int i = 0; i < A.length; i++ ){
            output[i] = A[i] * elem ;
        }
        return output;
    }

    public static double[] divByElem( double[] A, double elem ){
        double[] output = new double[ A.length ];
        for( int i = 0; i < A.length; i++ ){
            output[i] = A[i] / elem ;
        }
        return output;
    }
    
    public static double[] concat( double[] A, double[] B ){
        double[] output = new double[ A.length + B.length ];
        for( int i = 0; i< A.length; i++ ){
            output[i] = A[i];
        }
        for( int i = A.length; i < A.length + B.length; i++ ){
            output[i] = B[i - A.length];
        }
        return output;
    }
    
}
