package com.eebbk.onesearch;

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by jyqqhw on 15-11-14.
 */
public class SurView extends SurfaceView implements SurfaceHolder.Callback {

    private Camera mCamera;
    private SurfaceHolder mSurfaceHolder;

    public SurView(Context context) {
        this(context,null);
    }

    public SurView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SurView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        mSurfaceHolder = this.getHolder();
        mSurfaceHolder.setKeepScreenOn(true);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mSurfaceHolder.setFixedSize(240, 320);
        mSurfaceHolder.addCallback(this);


    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera = Camera.open();
            mCamera.setPreviewDisplay(holder);
            Camera.Parameters mParameters = mCamera.getParameters();
            mParameters.setPictureFormat(ImageFormat.JPEG);
            mParameters.set("orientation", "portrait");
            mParameters.set("rotation", 90);

            mCamera.setDisplayOrientation(90);
            mCamera.setParameters(mParameters);

            mCamera.startPreview();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(mCamera != null){
            mCamera.release();
            mCamera = null;
            holder = null;
        }
    }
}
