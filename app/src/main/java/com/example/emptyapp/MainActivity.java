package com.example.emptyapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends
        AppCompatActivity {

//    private TextView result_info;
    private EditText user_material;
    private Button main_btn;

    ListView listView;
//    192.168.43.145
//    private static final String JSON_URL = "http://vhost281788.cpsite.ru/points.json";
    private static final String JSON_URL = "http://192.168.43.145/geData.php";
//    private static final String JSON_URL = "http://127.0.0.1/geData.php";
//    private static final String JSON_URL = "http://aaainfo.rus/geData.php";



    ArrayList<JSONObject> infoList;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        loadJSONFromURL(JSON_URL);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nameEx = infoList.get(position).optString("name");
                String latitudeEx = infoList.get(position).optString("latitude");
                String longitudeEx = infoList.get(position).optString("longitude");
                String addressEx = infoList.get(position).optString("address");
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("nameEx", nameEx);
                intent.putExtra("latitudeEx", latitudeEx);
                intent.putExtra("longitudeEx", longitudeEx);
                intent.putExtra("addressEx", addressEx);
                startActivity(intent);
            }
        });

        user_material = findViewById(R.id.user_material);
        main_btn = findViewById(R.id.main_btn);



        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_material.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
                } else{
                    String material = user_material.getText().toString();
                    String longitude = "60";
                    String latitude = "30.5";

                    Intent intent1 = new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("geo:" + longitude + ", " + latitude));
                    startActivity(intent1);
;
                }
            }
        });

    }

    private void loadJSONFromURL(String url) {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ListView.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener< String>(){
            @Override
            public void onResponse(String response){
                progressBar.setVisibility(ListView.INVISIBLE);
                try{
                    System.out.println("я перед!");
                    JSONObject object = new JSONObject(response);
                    System.out.println("я тут!");
//                    JSONObject object = new JSONObject(EncodingToUTF8(response)); // было для JSON
                    JSONArray jsonArray = object.getJSONArray("points");
                    ArrayList<JSONObject> listItems = getArrayListFromJSONArray(jsonArray);
//                    loadJSONFromURL(JSON_URL);
                    infoList = listItems;
                    ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), R.layout.row, R.id.name, listItems);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
        new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){
        ArrayList<JSONObject> aList = new ArrayList();
        try {
            if(jsonArray!= null)
                for(int i = 0; i< jsonArray.length();i++){
                    aList.add(jsonArray.getJSONObject(i));
                }
            } catch (JSONException e) {
            e.printStackTrace();
        }
//    }catch(JSONException js){
//            js.printStackTrace();
//        }
        return aList;
    }

    public  static  String EncodingToUTF8(String response){
        try {
            byte[] code = response.toString().getBytes("ISO-8859-1");
            response = new String(code, "UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
        return response;
    }


//    StringRequest
//
//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//
//    }

//    private String JsonDataFromAsset(String fileName) {
//        String json = null;
//        try{
//            InputStream inputStream = getAssets().open(fileName);
//            int sizeOfFile = inputStream.available();
//            byte[] bufferDate = new byte[sizeOfFile];
//            inputStream.read(bufferDate);
//            inputStream.close();
//            json = new String(bufferDate, "UTF-8");
//
//        }catch (IOException e){
//            e.printStackTrace();
////            return null;
////        }
////        return json;
////    }
}