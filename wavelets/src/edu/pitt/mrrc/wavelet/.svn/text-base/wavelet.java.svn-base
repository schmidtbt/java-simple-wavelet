package edu.pitt.mrrc.wavelet;

import com.sun.deploy.util.ArrayUtil;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import edu.pitt.mrrc.util.math;

/**
 * Created by doubleelliJ IDEA.
 * User: bschmidt
 * Date: 3/8/12
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class wavelet {

    public static double[] waveletcdf97( double[] X, double Level ){
        double[] output = new double[ X.length ];

        double N1 = X.length;
        double N2 = 1;

        double[] LiftFilter = { -1.5861343420693648,-0.0529801185718856,0.8829110755411875,0.4435068520511142 };
        double ScaleFactor  = 1.1496043988602418;

        double S1 = LiftFilter[0];
        double S2 = LiftFilter[1];
        double S3 = LiftFilter[2];

        double[] numer = {S1*S2*S3,S2*S3,S1+S3+3*S1*S2*S3};
        double[] ExtrapolateOdd = new double[3];

        for( int i = 0; i <= 2; i++ ){
            ExtrapolateOdd[i] = -2*numer[i]/(1+2*S2*S3);
        }

        dispArr( ExtrapolateOdd );
        dispArr( LiftFilter );
        
        if( Level > 0 ){
            // Forward Transform

            // Loop over levels
            for( int k = 0; k < Level; k++ ){

                double M1 = Math.ceil( N1/2 );
                double M2 = Math.ceil( N2/2 );

                // Should always be true for our case

                double[] RightShift = math.rightshift( (int)M1 );
                double[] X0 = math.byTwos( X );
                // Even N1 calculation...

                double[] fb = {LiftFilter[0], LiftFilter[0] };
                double[] fX = math.rightShiftX0( X0 );
                double[] fB = math.rightpad( fb, X0.length );

                double Zi   = X0[0] * LiftFilter[0];
                double[] filt = math.filter( fB, new double[1], fX , Zi );
                double[] init = math.byTwosAt2( X );
                double[] X1 = math.add( filt, init );
                dispArr( X1 );

                fb[0] = LiftFilter[1]; fb[1] = LiftFilter[1];
                fB = math.rightpad( fb, X0.length );
                Zi = X1[0] * LiftFilter[1];
                filt = math.filter( fB, new double[1], X1, Zi);
                X0 = math.add( X0, filt );
                dispArr( X0 );

                fb[0] = LiftFilter[2]; fb[1] = LiftFilter[2];
                fB = math.rightpad( fb, X0.length );
                fX = math.rightShiftX0( X0 );
                Zi = X0[0] * LiftFilter[2];
                filt = math.filter( fB, new double[1], fX, Zi);
                dispArr( filt );
                X1 = math.add( X1, filt);
                dispArr( X1 );

                fb[0] = LiftFilter[3]; fb[1] = LiftFilter[3];
                fB = math.rightpad( fb, X0.length );
                Zi = X1[0] * LiftFilter[3];
                filt = math.filter( fB, new double[1], X1, Zi);
                X0 = math.add( X0, filt );
                dispArr( X0 );

                
                double[] divScale;
                double[] multScale;
                
                divScale = math.divByElem( X1, ScaleFactor );
                dispArr( divScale );

                multScale = math.multByElem( X0, ScaleFactor );
                dispArr( multScale );
                
                dispArr( math.concat( multScale, divScale ));
                
            }





        } else {
            // Inverse
        }

        
        
        
        
        
        
        
        return output;
    }







    public static void modi_unvPrior( double Nw, double[] L ){}

    /**
     *
     * @param Yo #Time points of a single channel
     * @param Xo ##Tieme points of a design matrix
     * @param NT
     */
    public static void detrend_wave_rev_v03( double[] Yo, double[] Xo, double NT ){


        double n_ch    = 1;
        double n_B     = 1;
        double m_Yo    = Yo.length;
        double m_W     = 9;
        double N_org   = Yo.length;

        System.out.println( Math.log( m_Yo / (m_W-1) ) / Math.log(2) );
        double decJ_tmp = edu.pitt.mrrc.util.math.fix(Math.log(m_Yo / (m_W - 1)) / Math.log(2));
        double Jtmp     = decJ_tmp + 1;

        double tmp_1 = 0;
        double tmp_2 = m_Yo;

        for( double i = Jtmp; i >= 2; i-- ){
            tmp_1   = Math.floor( tmp_2/ 2 );
            tmp_2   = tmp_2 - tmp_1;
        }

        double ini_m    = tmp_1;

        System.out.println( "init_m: " + ini_m );


        double dm_left = -100;
        double dm_right= -100;
        
        if( ini_m == m_W-1 ){
            System.out.println( "init_m == m_w-1" );
            System.exit(-1);
        } else {
            tmp_1 = 2*m_W-ini_m-2;
            tmp_2 = tmp_1*( Math.pow(2, decJ_tmp) );
            
            dm_left = Math.ceil( tmp_2/2 );
            dm_right = tmp_2 - dm_left;
        }

        dispVar("dm_right", dm_right);
        dispVar( "tmp_2"    , tmp_2 );
        dispVar( "tmp_1"    , tmp_1 );


        double[] Y;
        double[] X;
        
        Y = elongation( dm_left, dm_right, Yo );
        X   = elongation( dm_left, dm_right, Xo );
        
        dispArr( Y );
        dispArr( X );
        
        double N = Y.length;
        
        double decJ = edu.pitt.mrrc.util.math.fix( Math.log( N/(m_W-1) ) / Math.log(2) );
        dispVar( "decJ", decJ );
        double J = decJ+1;
        double[] L = new double[ (int)J ];

        for( int i = 0; i<J; i++ ){
            L[i] = 0;
        }
        
        double tmp = N;
        for( int i = (int)J - 1; i >= 1; i-- ){
            L[i] = Math.floor(tmp/2);
            tmp  = tmp-L[i];
        }
        
        L[0] = tmp;
        
        dispArr( L );



        
    }

    public static double[] elongation( double dm_left, double dm_right, double[] data ){

        double[] output = new double[ data.length * 3 ];

        int count = 0;
        for( int i = (int)dm_left - 1; i >= 0; i-- ){
            output[count] = data[i];
            count++;
        }
        
        for( int i = 0; i < data.length; i++ ){
            output[count] = data[i];
            count++;
        }

        for( int i = data.length - 1; i >= data.length-(int)dm_right; i-- ){
            output[count] = data[i];
            count++;
        }

        return output;
    }

    public static void dispVar( String var, double val ){
        System.out.println( var + ": " + val );
    }

    public static void dispArr( double[] arr ){

        for( int i = 0; i < arr.length; i++ ){
            System.out.print( arr[i] + " " );
        }
        System.out.println();

    }

}
