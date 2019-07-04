package sg.edu.rp.c346.p08_locatingaplace;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng poi_Singapore = new LatLng(1.352083, 103.819839);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Singapore,
                        11));

                UiSettings ui = map.getUiSettings();

                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);


                LatLng poi_North = new LatLng(1.436050, 103.786057);

                Marker np = map.addMarker(new
                        MarkerOptions()
                        .position(poi_North)
                        .title("HQ - North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 \n" + "Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));



                LatLng poi_Central = new LatLng(1.302570, 103.785733);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Central)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


                LatLng poi_East = new LatLng(1.352480, 103.944611);
                Marker ep = map.addMarker(new
                        MarkerOptions()
                        .position(poi_East)
                        .title("Central")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED){
                    map.setMyLocationEnabled(true);
                }else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }


                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(MainActivity.this, marker.getTitle().toString(), Toast.LENGTH_LONG).show();
                        return false;
                    }
                });

            }
        });



        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        spn = findViewById(R.id.spn);






        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 1:
                        if (map != null){
                            LatLng poi_North = new LatLng(1.436050, 103.786057);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North,
                                    15));
                        }
                        break;
                    case 2:
                        if (map != null){
                            LatLng poi_Central = new LatLng(1.302570, 103.785733);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central,
                                    15));
                        }
                        break;
                    case 3:
                        if (map != null){
                            LatLng poi_North = new LatLng(1.352480, 103.944611);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North,
                                    15));
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null){
                    LatLng poi_North = new LatLng(1.436050, 103.786057);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North,
                            15));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null){
                    LatLng poi_Central = new LatLng(1.302570, 103.785733);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central,
                            15));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map != null){
                    LatLng poi_North = new LatLng(1.352480, 103.944611);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North,
                            15));
                }
            }
        });
    }
}
