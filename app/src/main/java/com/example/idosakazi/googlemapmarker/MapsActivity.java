package com.example.idosakazi.googlemapmarker;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Marker> markers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Marker markerUpload;

        // a marker in unversityOfBenGurion
        final LatLng unversityOfBenGurion = new LatLng(31.262310, 34.801418);
        markerUpload = mMap.addMarker(new MarkerOptions().position(unversityOfBenGurion).title("Unversity Of BenGurion"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unversityOfBenGurion));
        markers.add(markerUpload);

        LatLng turnerStadium = new LatLng(31.273432, 34.779419);
        markerUpload = mMap.addMarker(new MarkerOptions().position(turnerStadium).title("Turner Stadium"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(turnerStadium));
        markers.add(markerUpload);

        LatLng trainStationBeerShebaNorth = new LatLng(31.262398, 34.809327);
        markerUpload = mMap.addMarker(new MarkerOptions().position(trainStationBeerShebaNorth).title("Train Station BeerSheba North"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(trainStationBeerShebaNorth));
        markers.add(markerUpload);

        LatLng gavYamNegev = new LatLng(31.264902, 34.814152);
        markerUpload = mMap.addMarker(new MarkerOptions().position(gavYamNegev).title("GavYam Negev"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gavYamNegev));
        markers.add(markerUpload);

        LatLng library = new LatLng(31.252209, 34.795971);
        markerUpload = mMap.addMarker(new MarkerOptions().position(library).title("Library"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(library));
        markers.add(markerUpload);

        LatLng leonardoHotel = new LatLng(31.247594, 34.801023);
        markerUpload = mMap.addMarker(new MarkerOptions().position(leonardoHotel).title("Leonardo Hotel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(leonardoHotel));
        markers.add(markerUpload);

        LatLng CBSBeersheba = new LatLng(31.244075, 34.796812);
        markerUpload = mMap.addMarker(new MarkerOptions().position(CBSBeersheba).title("CBS Beersheba"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CBSBeersheba));
        markers.add(markerUpload);

        LatLng forumClub = new LatLng(31.222693, 34.802324);
        markerUpload = mMap.addMarker(new MarkerOptions().position(forumClub).title("Forum Club"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(forumClub));
        markers.add(markerUpload);

        LatLng yesPlanet = new LatLng(31.224420, 34.801540);
        markerUpload = mMap.addMarker(new MarkerOptions().position(yesPlanet).title("Yes Planet"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(yesPlanet));
        markers.add(markerUpload);

        LatLng sorokaMedicalCenter = new LatLng(31.259407, 34.801694);
        markerUpload = mMap.addMarker(new MarkerOptions().position(sorokaMedicalCenter).title("Soroka Medical Center"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sorokaMedicalCenter));
        markers.add(markerUpload);


        // focuse in the markers that i have create
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker m :markers) {
            builder.include(m.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.10); // offset from edges of the map 10% of screen

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

        mMap.animateCamera(cu);



        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                switch (marker.getTitle()){
                    case "Unversity Of BenGurion":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MapsActivity.this,unversityActivity.class);
                        startActivity(intent1);
                        break;
                    case "Turner Stadium":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MapsActivity.this,turnerStadiumActivity.class);
                        startActivity(intent2);
                        break;
                    case "Train Station BeerSheba North":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MapsActivity.this,trainStationActivity.class);
                        startActivity(intent3);
                        break;
                    case "GavYam Negev":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(MapsActivity.this,gavYamNegevActivity.class);
                        startActivity(intent4);
                        break;
                    case "Library":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent5 = new Intent(MapsActivity.this,libraryActivity.class);
                        startActivity(intent5);
                        break;
                    case "Leonardo Hotel":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent6 = new Intent(MapsActivity.this,leonardoHotelActivity.class);
                        startActivity(intent6);
                        break;
                    case "CBS Beersheba":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent7 = new Intent(MapsActivity.this,cbsBeershebaActivity.class);
                        startActivity(intent7);
                        break;
                    case "Forum Club":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent8 = new Intent(MapsActivity.this,forumClubActivity.class);
                        startActivity(intent8);
                        break;
                    case "Yes Planet":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent9 = new Intent(MapsActivity.this,yesPlanetActivity.class);
                        startActivity(intent9);
                        break;
                    case "Soroka Medical Center":
                        Toast.makeText(MapsActivity.this, "Clicked "+marker.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent10 = new Intent(MapsActivity.this,sorokaMedicalCenterActivity.class);
                        startActivity(intent10);
                        break;
                }

                return false;
            }
        });
    }
}
