package com.kosmo.a43googlemap01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO61";

    SupportMapFragment mapFragment;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "googleMap is ready...");

                map = googleMap;
            }
        });

        try {
            MapsInitializer.initialize(this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onBtnClicked(View view) {
        //증평
        LatLng curPoint = new LatLng(36.784530, 127.583853);
        //애니메이션 효과와 함계 지정된 위치로 이동됨
        //매개변수 -> (이동할 위치[위경도], Zoom 레벨)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
    }
}
