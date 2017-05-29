package com.altotech.glass.api.opencvtest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

public class MainActivity extends Activity {// extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    /*static {
        System.loadLibrary("native-lib");
    }*/

    private static final String TAG = "DeBuggingOpenCV";
    static {
        System.loadLibrary("native-lib");
        if (!OpenCVLoader.initDebug()){
            Log.d(TAG, "Not Loaded");
        }else {
            Log.d(TAG, "is loaded");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Mat mat = new Mat(10, 10, CvType.CV_8UC1);
        mat.setTo(new Scalar(7));
        Log.d("JHKASGCD", "" + mat.get(7, 7));

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI() + mat.get(7, 7)[0]);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
