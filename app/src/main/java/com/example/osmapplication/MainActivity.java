package com.example.osmapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.Polygon;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.gridlines.LatLonGridlineOverlay2;
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MapView map;
    private IMapController mapController;

    private static final String TAG = "OsmActivity";
    private static final int PERMISSION_REQUEST_CODE = 1;

    Polyline polyline = null;
    Polygon polygon = null;
    List<LatLonGridlineOverlay2> latlon = new ArrayList<>();
    List<Marker> markers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //handle permissions first, before map is created. not depicted here
        //load/initialize the osmdroid configuration, this can be done
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string

        //inflate and create the map

        setContentView(R.layout.activity_main);

        //map.setOnClickListener();


        if (Build.VERSION.SDK_INT >= 23) {
            if (isStoragePermissionGranted()) {

            }
        }

        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(15);
        //GeoPoint startPoint = new GeoPoint(51496994, -134733);
        GeoPoint startPoint = new GeoPoint(22.60899757, 88.3869273);
        mapController.setCenter(startPoint);

        //ArrayList<GeoPoint> geoPoints = new ArrayList<>();
        polygon = new Polygon(map);

        polygon.setInfoWindow(
                new BasicInfoWindow(org.osmdroid.library.R.layout.bonuspack_bubble, map));
        polygon.getFillPaint().setColor(Color.argb(75, 255, 0, 0));
        //polygon.setPoints(geoPoints);
        polygon.setTitle("Bagjola polygon");
        polygon.showInfoWindow();

        polygon.addPoint(new GeoPoint(22.5973480970607, 88.3901592000838));
        polygon.addPoint(new GeoPoint(22.5972520346597, 88.3903626528037));
        polygon.addPoint(new GeoPoint(22.5972072055393, 88.3904117620809));
        polygon.addPoint(new GeoPoint(22.5972072055393, 88.3904678869691));
        polygon.addPoint(new GeoPoint(22.5971559722587, 88.3905169962463));
        polygon.addPoint(new GeoPoint(22.5971559722587, 88.3905661055235));
        polygon.addPoint(new GeoPoint(22.5971047389782, 88.3906713396889));
        polygon.addPoint(new GeoPoint(22.5968677850558, 88.390923901686));
        polygon.addPoint(new GeoPoint(22.5968165517752, 88.3910782451286));
        polygon.addPoint(new GeoPoint(22.5966756602538, 88.3912325885713));
        polygon.addPoint(new GeoPoint(22.5965283645722, 88.3914360412911));
        polygon.addPoint(new GeoPoint(22.5964323021713, 88.3914851505683));
        polygon.addPoint(new GeoPoint(22.5961441149683, 88.3917938374536));
        polygon.addPoint(new GeoPoint(22.5960480525673, 88.3918429467308));
        polygon.addPoint(new GeoPoint(22.5960032234468, 88.3918850403969));
        polygon.addPoint(new GeoPoint(22.5964899396119, 88.3920253526175));
        polygon.addPoint(new GeoPoint(22.5974505636218, 88.3921656648381));
        polygon.addPoint(new GeoPoint(22.598058958828, 88.392130586783));
        polygon.addPoint(new GeoPoint(22.5978284090657, 88.3926006327219));
        polygon.addPoint(new GeoPoint(22.5978284090657, 88.3926637732212));
        polygon.addPoint(new GeoPoint(22.5988594788363, 88.3926778044432));
        polygon.addPoint(new GeoPoint(22.5990900285987, 88.3927409449425));
        polygon.addPoint(new GeoPoint(22.5992629409205, 88.3927409449425));
        polygon.addPoint(new GeoPoint(22.5994358532423, 88.392867225941));
        polygon.addPoint(new GeoPoint(22.6002363732505, 88.392874241552));
        polygon.addPoint(new GeoPoint(22.6004092855723, 88.3929373820513));
        polygon.addPoint(new GeoPoint(22.6005821978941, 88.3929373820513));
        polygon.addPoint(new GeoPoint(22.6007487060558, 88.3930005225506));
        polygon.addPoint(new GeoPoint(22.6012674430212, 88.3930075381616));
        polygon.addPoint(new GeoPoint(22.6014403553429, 88.3930706786608));
        polygon.addPoint(new GeoPoint(22.6016132676647, 88.3930706786608));
        polygon.addPoint(new GeoPoint(22.6017797758264, 88.3931338191601));
        polygon.addPoint(new GeoPoint(22.6019526881482, 88.3931408347711));
        polygon.addPoint(new GeoPoint(22.60212560047, 88.3932039752704));
        polygon.addPoint(new GeoPoint(22.6025866999948, 88.3933302562689));
        polygon.addPoint(new GeoPoint(22.6028684830377, 88.3933933967682));
        polygon.addPoint(new GeoPoint(22.6031566702407, 88.3935196777667));
        polygon.addPoint(new GeoPoint(22.6033295825624, 88.3935266933777));
        polygon.addPoint(new GeoPoint(22.6034960907242, 88.393589833877));
        polygon.addPoint(new GeoPoint(22.6037842779271, 88.3936529743763));
        polygon.addPoint(new GeoPoint(22.6041301025707, 88.3937792553748));
        polygon.addPoint(new GeoPoint(22.6043030148925, 88.3937792553748));
        polygon.addPoint(new GeoPoint(22.6045847979354, 88.393842395874));
        polygon.addPoint(new GeoPoint(22.6055646344255, 88.3938564270961));
        polygon.addPoint(new GeoPoint(22.6055838469057, 88.3938073178189));
        polygon.addPoint(new GeoPoint(22.6071784827622, 88.3939055363733));
        polygon.addPoint(new GeoPoint(22.6101243963926, 88.3939406144284));
        polygon.addPoint(new GeoPoint(22.611136253683, 88.3938985207623));
        polygon.addPoint(new GeoPoint(22.6117446488893, 88.3941160047042));
        polygon.addPoint(new GeoPoint(22.6118919445708, 88.3939476300395));
        polygon.addPoint(new GeoPoint(22.6120136236121, 88.3937792553748));
        polygon.addPoint(new GeoPoint(22.612199344254, 88.3936670055983));
        polygon.addPoint(new GeoPoint(22.6152669369256, 88.3938704583181));
        polygon.addPoint(new GeoPoint(22.6152925535659, 88.3938915051512));
        polygon.addPoint(new GeoPoint(22.615977798693, 88.3935687870439));
        polygon.addPoint(new GeoPoint(22.61665663966, 88.3939055363733));
        polygon.addPoint(new GeoPoint(22.6169192102227, 88.3939055363733));
        polygon.addPoint(new GeoPoint(22.6170344851039, 88.3938494114851));
        polygon.addPoint(new GeoPoint(22.6172073974257, 88.3938494114851));
        polygon.addPoint(new GeoPoint(22.6173739055874, 88.3937862709858));
        polygon.addPoint(new GeoPoint(22.617719730231, 88.3937932865968));
        polygon.addPoint(new GeoPoint(22.6179502799933, 88.3936740212093));
        polygon.addPoint(new GeoPoint(22.6187572041617, 88.3936810368204));
        polygon.addPoint(new GeoPoint(22.6188724790429, 88.3936178963211));
        polygon.addPoint(new GeoPoint(22.6218247968333, 88.3936459587652));
        polygon.addPoint(new GeoPoint(22.6218119885132, 88.3932250221035));
        polygon.addPoint(new GeoPoint(22.6235475158911, 88.3930566474388));
        polygon.addPoint(new GeoPoint(22.6284979316222, 88.3924322580572));
        polygon.addPoint(new GeoPoint(22.6286388231436, 88.3921867116712));
        polygon.addPoint(new GeoPoint(22.6287092689044, 88.3921586492271));
        polygon.addPoint(new GeoPoint(22.6286900564242, 88.3919341496742));
        polygon.addPoint(new GeoPoint(22.6287797146651, 88.3919411652852));
        polygon.addPoint(new GeoPoint(22.6288053313054, 88.391660540844));
        polygon.addPoint(new GeoPoint(22.6287412897047, 88.391660540844));
        polygon.addPoint(new GeoPoint(22.6287092689044, 88.391422010069));
        polygon.addPoint(new GeoPoint(22.6288309479456, 88.3914430569021));
        polygon.addPoint(new GeoPoint(22.6289462228268, 88.3902924966934));
        polygon.addPoint(new GeoPoint(22.6289398186668, 88.3894015140927));
        polygon.addPoint(new GeoPoint(22.6290166685875, 88.3894015140927));
        polygon.addPoint(new GeoPoint(22.6289782436272, 88.3884894846589));
        polygon.addPoint(new GeoPoint(22.629644276274, 88.3883140943832));
        polygon.addPoint(new GeoPoint(22.6293945140314, 88.3880966104413));
        polygon.addPoint(new GeoPoint(22.6295802346734, 88.3871635341744));
        polygon.addPoint(new GeoPoint(22.6299836967575, 88.3866584101803));
        polygon.addPoint(new GeoPoint(22.6298812301965, 88.3865952696811));
        polygon.addPoint(new GeoPoint(22.6301630132394, 88.3856411465811));
        polygon.addPoint(new GeoPoint(22.6301822257196, 88.3856411465811));
        polygon.addPoint(new GeoPoint(22.6301117799588, 88.3847291171474));
        polygon.addPoint(new GeoPoint(22.6302142465199, 88.3840836809327));
        polygon.addPoint(new GeoPoint(22.6303551380414, 88.3841889150981));
        polygon.addPoint(new GeoPoint(22.6304512004423, 88.3839644155452));
        polygon.addPoint(new GeoPoint(22.6307714084457, 88.3816422482946));
        polygon.addPoint(new GeoPoint(22.6307393876453, 88.3806740939726));
        polygon.addPoint(new GeoPoint(22.6307137710051, 88.3803583914763));
        polygon.addPoint(new GeoPoint(22.6307521959655, 88.3803513758653));
        polygon.addPoint(new GeoPoint(22.6307586001255, 88.3800988138682));
        polygon.addPoint(new GeoPoint(22.6306881543648, 88.3800847826462));
        polygon.addPoint(new GeoPoint(22.6309827457278, 88.3784711921095));
        polygon.addPoint(new GeoPoint(22.6307393876453, 88.3784852233316));
        polygon.addPoint(new GeoPoint(22.6290807101882, 88.378590457497));
        polygon.addPoint(new GeoPoint(22.6279215572162, 88.3786606136073));
        polygon.addPoint(new GeoPoint(22.6263781546403, 88.3787518165507));
        polygon.addPoint(new GeoPoint(22.6252125975083, 88.3788219726609));
        polygon.addPoint(new GeoPoint(22.6238677238944, 88.3789061599933));
        polygon.addPoint(new GeoPoint(22.6228302499637, 88.3789622848815));
        polygon.addPoint(new GeoPoint(22.6219464758746, 88.3790184097698));
        polygon.addPoint(new GeoPoint(22.6187059708811, 88.3791867844345));
        polygon.addPoint(new GeoPoint(22.6171241433448, 88.3792709717668));
        polygon.addPoint(new GeoPoint(22.6167398937408, 88.3792499249337));
        polygon.addPoint(new GeoPoint(22.6164517065379, 88.3791657376014));
        polygon.addPoint(new GeoPoint(22.6162275609356, 88.3790605034359));
        polygon.addPoint(new GeoPoint(22.6159265654124, 88.3789201912154));
        polygon.addPoint(new GeoPoint(22.6136723010692, 88.377874865172));
        polygon.addPoint(new GeoPoint(22.6120200277721, 88.3771101635699));
        polygon.addPoint(new GeoPoint(22.6119047528909, 88.377138226014));
        polygon.addPoint(new GeoPoint(22.6113475909652, 88.3768716327949));
        polygon.addPoint(new GeoPoint(22.6104125835955, 88.3764296493001));
        polygon.addPoint(new GeoPoint(22.609394322145, 88.375938556528));
        polygon.addPoint(new GeoPoint(22.6076267739668, 88.3751036988156));
        polygon.addPoint(new GeoPoint(22.6073642034041, 88.3749774178171));
        polygon.addPoint(new GeoPoint(22.6067942331582, 88.374710824598));
        polygon.addPoint(new GeoPoint(22.6065636833958, 88.3746055904325));
        polygon.addPoint(new GeoPoint(22.6061602213117, 88.3744231845458));
        polygon.addPoint(new GeoPoint(22.6058143966681, 88.37424779427));
        polygon.addPoint(new GeoPoint(22.6055838469057, 88.3741215132715));
        polygon.addPoint(new GeoPoint(22.6054301470641, 88.3740373259392));
        polygon.addPoint(new GeoPoint(22.605513401145, 88.3738759668855));
        polygon.addPoint(new GeoPoint(22.6053340846631, 88.3737847639421));
        polygon.addPoint(new GeoPoint(22.6045847979354, 88.3752861047023));
        polygon.addPoint(new GeoPoint(22.601837413267, 88.3778047090617));
        polygon.addPoint(new GeoPoint(22.6010176807786, 88.3804145163645));
        polygon.addPoint(new GeoPoint(22.6009728516581, 88.38051975053));
        polygon.addPoint(new GeoPoint(22.600960043338, 88.3817544980711));
        polygon.addPoint(new GeoPoint(22.6009088100575, 88.3818527166255));
        polygon.addPoint(new GeoPoint(22.6009088100575, 88.3819088415137));
        polygon.addPoint(new GeoPoint(22.600863980937, 88.3819579507909));
        polygon.addPoint(new GeoPoint(22.600863980937, 88.3820070600681));
        polygon.addPoint(new GeoPoint(22.6008127476565, 88.3820561693453));
        polygon.addPoint(new GeoPoint(22.6008127476565, 88.3821122942336));
        polygon.addPoint(new GeoPoint(22.600767918536, 88.3822666376762));
        polygon.addPoint(new GeoPoint(22.6007615143759, 88.3824209811188));
        polygon.addPoint(new GeoPoint(22.6006654519749, 88.3826244338387));
        polygon.addPoint(new GeoPoint(22.6006142186944, 88.3827787772813));
        polygon.addPoint(new GeoPoint(22.6005181562934, 88.3830313392783));
        polygon.addPoint(new GeoPoint(22.6005181562934, 88.3832909168864));
        polygon.addPoint(new GeoPoint(22.6004669230129, 88.3834943696063));
        polygon.addPoint(new GeoPoint(22.6003196273314, 88.3839573999342));
        polygon.addPoint(new GeoPoint(22.6003196273314, 88.3841117433768));
        polygon.addPoint(new GeoPoint(22.6002235649304, 88.3843151960967));
        polygon.addPoint(new GeoPoint(22.6002235649304, 88.3844204302621));
        polygon.addPoint(new GeoPoint(22.6001723316499, 88.3846238829819));
        polygon.addPoint(new GeoPoint(22.6001210983693, 88.3847291171474));
        polygon.addPoint(new GeoPoint(22.6000698650888, 88.3849325698672));
        polygon.addPoint(new GeoPoint(22.5999738026878, 88.3850378040326));
        polygon.addPoint(new GeoPoint(22.5999289735673, 88.385136022587));
        polygon.addPoint(new GeoPoint(22.5998329111664, 88.3852903660297));
        polygon.addPoint(new GeoPoint(22.5997816778858, 88.3853464909179));
        polygon.addPoint(new GeoPoint(22.5997304446053, 88.3855008343606));
        polygon.addPoint(new GeoPoint(22.5996343822043, 88.3856481621922));
        polygon.addPoint(new GeoPoint(22.5994934906829, 88.3858025056348));
        polygon.addPoint(new GeoPoint(22.5994422574023, 88.3860059583546));
        polygon.addPoint(new GeoPoint(22.5993910241218, 88.3860620832429));
        polygon.addPoint(new GeoPoint(22.5993461950013, 88.3862164266855));
        polygon.addPoint(new GeoPoint(22.5992501326003, 88.3863707701282));
        polygon.addPoint(new GeoPoint(22.5992501326003, 88.3864198794054));
        polygon.addPoint(new GeoPoint(22.5991988993198, 88.3865180979598));
        polygon.addPoint(new GeoPoint(22.5990067745178, 88.386826784845));
        polygon.addPoint(new GeoPoint(22.5988146497158, 88.3870302375649));
        polygon.addPoint(new GeoPoint(22.5986673540343, 88.3872898151729));
        polygon.addPoint(new GeoPoint(22.5984239959518, 88.3876476113354));
        polygon.addPoint(new GeoPoint(22.5982767002703, 88.3879001733325));
        polygon.addPoint(new GeoPoint(22.5981358087488, 88.3880545167751));
        polygon.addPoint(new GeoPoint(22.5980397463478, 88.3882088602177));
        polygon.addPoint(new GeoPoint(22.5979885130673, 88.3883140943832));
        polygon.addPoint(new GeoPoint(22.5978924506663, 88.3884614222148));
        polygon.addPoint(new GeoPoint(22.5978412173858, 88.3886157656574));
        polygon.addPoint(new GeoPoint(22.5978412173858, 88.3887209998229));
        polygon.addPoint(new GeoPoint(22.5977451549848, 88.3888753432655));
        polygon.addPoint(new GeoPoint(22.5976939217043, 88.3889805774309));
        polygon.addPoint(new GeoPoint(22.5976939217043, 88.3890787959853));
        polygon.addPoint(new GeoPoint(22.5976490925838, 88.3891840301508));
        polygon.addPoint(new GeoPoint(22.5975466260228, 88.3894927170361));
        polygon.addPoint(new GeoPoint(22.5974953927422, 88.3897452790331));
        polygon.addPoint(new GeoPoint(22.5974505636218, 88.3898996224757));
        polygon.addPoint(new GeoPoint(22.5973993303412, 88.3900048566412));
        polygon.addPoint(new GeoPoint(22.5973480970607, 88.3901592000838));


        polygon.setOnClickListener(new Polygon.OnClickListener() {
            @Override
            public boolean onClick(Polygon polygon, MapView mapView, GeoPoint eventPos) {
                //lastPolygon = polygon;
                polygon.onClickDefault(polygon, mapView, eventPos);
                Toast.makeText(mapView.getContext(), "polygon was tapped", Toast.LENGTH_LONG).show();
                //Toast.makeText(mapView.getContext(), "polygon with " + polygon.getActualPoints().size() + "pts was tapped", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        map.getOverlayManager().add(polygon);

        //Polygon.pointsAsCircle(startPoint, 365);
        List<GeoPoint> circle = Polygon.pointsAsCircle(startPoint, 365);
        Polygon p = new Polygon(map);
        p.setPoints(circle);
        p.setTitle("A circle");
        map.getOverlayManager().add(p);

        //polygon.setHoles();
        //polygon.setOnClickListener(onClickListener);
        //polygon.setStrokeWidth(25.15f);
        //polyline.setWidth(25.2f);
        //polygon.setFillColor();
        //polygon.addPoint(startPoint);
        //map.getOverlayManager().add(polygon);

//        Marker startMarker = new Marker(map);
//        startMarker.setPosition(startPoint);
//        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
//        //startMarker.setIcon(getResources().getDrawable(R.drawable.icon));
//        startMarker.setTitle("White House");
//        startMarker.setSnippet("The White House is the official residence and principal workplace of the President of the United States.");
//        startMarker.setSubDescription("1600 Pennsylvania Ave NW, Washington, DC 20500");
//        map.getOverlays().add(startMarker);
//
//        ArrayList<OverlayItem> items = new ArrayList<>();
//        OverlayItem home = new OverlayItem("INRM Office", "my Office", new GeoPoint(28.7041, 77.1025));
//        Drawable m = home.getMarker(0);
//        items.add(home);
//        items.add(new OverlayItem("Elangovan", "Green Park", new GeoPoint(19.0760, 72.8777)));
//
//        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(), items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
//            @Override
//            public boolean onItemSingleTapUp(int index, OverlayItem item) {
//                return true;
//            }
//
//            @Override
//            public boolean onItemLongPress(int index, OverlayItem item) {
//                return false;
//            }
//        });
//
//        mOverlay.setFocusItemsOnTap(true);
//
//        map.getOverlays().add(mOverlay);

    }

    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        if (map != null)
            map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
    }

    public void onPause() {
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        if (map != null)
            map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
    }


    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }
}