package com.app.polylineupdater;

import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.app.polylineupdater.model.Coordinates;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<LatLng> list_coordianates = new ArrayList();
    PolylineOptions polyLineOptions = null;
    private TimerTask NoticeTimerTask;
    private final Handler handler = new Handler();
    Timer timer = new Timer();
    int index = 0, start_flag = 0;
    boolean forward = false;
    boolean isMarkerRotating;
    Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(22.573764, 88.359109);
        mMarker = mMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car)).anchor(0.5f, 0.5f));
        mMarker.setAnchor(0.5f, 0.5f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18.0f));
        fillpath();
    }

    ///hardcoded coordinated collected from google map
    private void fillpath() {
        list_coordianates.clear();
        list_coordianates.add(new LatLng(22.573764, 88.359109));
        list_coordianates.add(new LatLng(22.573947, 88.359174));
        list_coordianates.add(new LatLng(22.574145, 88.359244));
        list_coordianates.add(new LatLng(22.574328, 88.359313));
        list_coordianates.add(new LatLng(22.574526, 88.359372));
        list_coordianates.add(new LatLng(22.574720, 88.359469));
        list_coordianates.add(new LatLng(22.574918, 88.359506));
        list_coordianates.add(new LatLng(22.575111, 88.359571));
        list_coordianates.add(new LatLng(22.575299, 88.359624));
        list_coordianates.add(new LatLng(22.575365, 88.359370));
        list_coordianates.add(new LatLng(22.575380, 88.359329));
        list_coordianates.add(new LatLng(22.575390, 88.359276));
        list_coordianates.add(new LatLng(22.575407, 88.359230));
        list_coordianates.add(new LatLng(22.575432, 88.359134));
        list_coordianates.add(new LatLng(22.575457, 88.359083));
        list_coordianates.add(new LatLng(22.575472, 88.359024));
        list_coordianates.add(new LatLng(22.575459, 88.358966));
        list_coordianates.add(new LatLng(22.575511, 88.358903));
        list_coordianates.add(new LatLng(22.575516, 88.358871));
        list_coordianates.add(new LatLng(22.575541, 88.358820));
        list_coordianates.add(new LatLng(22.575546, 88.358755));
        list_coordianates.add(new LatLng(22.575556, 88.358710));
        list_coordianates.add(new LatLng(22.575596, 88.358629));
        list_coordianates.add(new LatLng(22.575620, 88.358576));
        list_coordianates.add(new LatLng(22.575591, 88.358512));
        list_coordianates.add(new LatLng(22.575626, 88.358481));
        list_coordianates.add(new LatLng(22.575634, 88.358443));
        list_coordianates.add(new LatLng(22.575642, 88.358415));
        list_coordianates.add(new LatLng(22.575660, 88.358388));
        list_coordianates.add(new LatLng(22.575663, 88.358355));
        list_coordianates.add(new LatLng(22.575684, 88.358316));
        list_coordianates.add(new LatLng(22.575637, 88.358343));
        list_coordianates.add(new LatLng(22.575613, 88.358355));
        list_coordianates.add(new LatLng(22.575588, 88.358357));
        list_coordianates.add(new LatLng(22.575577, 88.358329));
        list_coordianates.add(new LatLng(22.575551, 88.358336));
        list_coordianates.add(new LatLng(22.575531, 88.358341));
        list_coordianates.add(new LatLng(22.575507, 88.358349));
        list_coordianates.add(new LatLng(22.575480, 88.358355));
        list_coordianates.add(new LatLng(22.575463, 88.358359));
        list_coordianates.add(new LatLng(22.575439, 88.358361));
        list_coordianates.add(new LatLng(22.575422, 88.358363));
        list_coordianates.add(new LatLng(22.575401, 88.358365));
        list_coordianates.add(new LatLng(22.575381, 88.358364));
        list_coordianates.add(new LatLng(22.575367, 88.358352));
        list_coordianates.add(new LatLng(22.575287, 88.358345));
        list_coordianates.add(new LatLng(22.575223, 88.358323));
        list_coordianates.add(new LatLng(22.575144, 88.358323));
        list_coordianates.add(new LatLng(22.575094, 88.358355));
        list_coordianates.add(new LatLng(22.575005, 88.358339));
        list_coordianates.add(new LatLng(22.574881, 88.358414));
        list_coordianates.add(new LatLng(22.574861, 88.358506));
        list_coordianates.add(new LatLng(22.574866, 88.358613));
        list_coordianates.add(new LatLng(22.574836, 88.358677));
        list_coordianates.add(new LatLng(22.574836, 88.358784));
        list_coordianates.add(new LatLng(22.574817, 88.358843));
        list_coordianates.add(new LatLng(22.574827, 88.359010));
        list_coordianates.add(new LatLng(22.574846, 88.359144));
        list_coordianates.add(new LatLng(22.574802, 88.359273));
        list_coordianates.add(new LatLng(22.574802, 88.359337));
        list_coordianates.add(new LatLng(22.574777, 88.359417));
        list_coordianates.add(new LatLng(22.574861, 88.359487));
        list_coordianates.add(new LatLng(22.574945, 88.359535));
        list_coordianates.add(new LatLng(22.575049, 88.359552));
        list_coordianates.add(new LatLng(22.575248, 88.359605));

        ///for drawing the polyline
        drawpolyline();
    }

    private void drawpolyline() {
        polyLineOptions = new PolylineOptions();
        polyLineOptions.addAll(list_coordianates);
        polyLineOptions.width(10);
        polyLineOptions.color(Color.RED);
        mMap.addPolyline(polyLineOptions);

        ///for car movement
        movecaronpath();
    }

    ///used time to dalay the index
    private void movecaronpath() {
        timer = new Timer();
        NoticeTimerTask = new TimerTask() {

            public void run() {
                handler.post(new Runnable() {

                    public void run() {
                        /////////////////////////////////////////
                        makeAni2(list_coordianates.get(index));
                        /////////////////////////////////////////
                        if (forward) {
                            index++;
                            Log.d("Uber..... ", index + "");
                        } else {
                            index--;
                            Log.d("Uber..... ", index + "");
                            if (index < 0) {
                                forward = true;
                                index = 0;
                                Log.d("Uber..... ", index + "");
                            }
                        }
                        if (index == list_coordianates.size() && forward) {
                            index--;
                            Log.d("Uber..... ", index + "");
                            forward = false;
                        } else {
//                            forward=true;
                        }
                    }
                });
            }
        };
        timer.schedule(NoticeTimerTask, 0, 5000); //
    }

    private void makeAni2(final LatLng latlngg) {
        final LatLng startPosition = mMarker.getPosition();
        final LatLng finalPosition = latlngg;
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final Interpolator interpolator = new AccelerateDecelerateInterpolator();
        final float durationInMs = 4000;
        final boolean hideMarker = false;

        ///////for rotation of the marker
        rotateMarker(mMarker, startPosition, finalPosition);

        handler.post(new Runnable() {
            long elapsed;
            float t;
            float v;

            @Override
            public void run() {
                // Calculate progress using interpolator
                elapsed = SystemClock.uptimeMillis() - start;
                t = elapsed / durationInMs;

                LatLng currentPosition = new LatLng(
                        startPosition.latitude * (1 - t) + finalPosition.latitude * t,
                        startPosition.longitude * (1 - t) + finalPosition.longitude * t);

                mMarker.setPosition(currentPosition);
                //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, 18));
                // Repeat till progress is complete.
                if (t < 1) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                } else {
                    if (hideMarker) {
                        mMarker.setVisible(false);
                    } else {
                        mMarker.setVisible(true);
                    }
                }
            }
        });
    }

    private void rotateMarker(final Marker marker, LatLng startPos, LatLng stopPos) {
        final double toRotation = bearingBetweenLocations(startPos, stopPos);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println(decimalFormat.format(toRotation));

        if (!isMarkerRotating) {
            final Handler handler = new Handler();
            final long start = SystemClock.uptimeMillis();
            final float startRotation = marker.getRotation();
            final long duration = 2000;

            final Interpolator interpolator = new LinearInterpolator();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    isMarkerRotating = true;

                    long elapsed = SystemClock.uptimeMillis() - start;
                    float t = interpolator.getInterpolation((float) elapsed / duration);

                    float rot = t * (float) toRotation + (1 - t) * startRotation;

                    marker.setRotation(-rot > 180 ? rot / 2 : rot);
                    if (t < 1.0) {
                        // Post again 16ms later.
                        handler.postDelayed(this, 16);
                    } else {
                        isMarkerRotating = false;
                    }
                }
            });
        }
    }

    ////for calculating of the bearing
    private double bearingBetweenLocations(LatLng latLng1, LatLng latLng2) {
        double PI = 3.14159;
        double lat1 = latLng1.latitude * PI / 180;
        double long1 = latLng1.longitude * PI / 180;
        double lat2 = latLng2.latitude * PI / 180;
        double long2 = latLng2.longitude * PI / 180;

        double dLon = (long2 - long1);

        double y = Math.sin(dLon) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(dLon);

        double brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        brng = (brng + 360) % 360;

        return brng;
    }


}
