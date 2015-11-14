package com.eebbk.onesearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private SurfaceView mSurfaceView;
    private Button mPic,mTran,mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView)findViewById(R.id.sv_show);
        mPic = (Button)findViewById(R.id.btn_pic);
        mTran = (Button)findViewById(R.id.btn_translate);
        mBar = (Button)findViewById(R.id.btn_bar);

        mPic.setOnClickListener(this);
        mBar.setOnClickListener(this);
        mTran.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_bar:

                break;
            case R.id.btn_pic:
                break;
            case R.id.btn_translate:
                break;
            default:
                break;
        }
    }



}
