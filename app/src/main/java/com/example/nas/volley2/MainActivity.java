package com.example.nas.volley2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {

    ListView free_list, paid_list;
    public static  ArrayList<Rowitem> rowItems, rowItems2;

    TextView mTextView, mTextView2;

    JSONArray contacts = null, contacts2 = null;

    public static final String BASE_URL = "http://wierwinhuizingafi.com/ask4wifi/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.tv_name);
        mTextView2 = (TextView) findViewById(R.id.tv_name1);
        free_list = (ListView) findViewById(R.id.free_list);
        paid_list = (ListView) findViewById(R.id.paid_list);


        String url = BASE_URL + "wifi_list_user.php";
        System.out.print("url is" + url);

        loadTopScorerData( url);


    }


    private void loadTopScorerData( String url) {

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading! Please wait . . .");
        pDialog.show();

        // System.out.println("inside resendCode");

        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //System.out.println("response of resend code is:" + response);


                        try {
                            JSONObject obj = new JSONObject(response);

                            String status = obj.getString("status");
                            //System.out.println("i am nazmul"+ status);
                            mTextView.setText("" + status);

                            String msg = obj.getString("msg");
                            mTextView2.setText("" + msg);

                            contacts = obj.getJSONArray("free_list");

                            rowItems = new ArrayList<Rowitem>();

                            for (int i = 0; i < contacts.length(); i++) {
                                JSONObject aobj = contacts.getJSONObject(i);

                                String name = aobj.getString("name");

                                //System.out.println(" i am nazmul shah " + name);
                                String wifi_type = aobj.getString("wifi_type");
                                String bssid = aobj.getString("bssid");
                                String key = aobj.getString("key");
                                String latitude = aobj.getString("latitude");
                                String longitude = aobj.getString("longitude");

                                Rowitem item;
                                //item = new Rowitem();
                                item = new Rowitem(name, wifi_type, bssid, key, latitude, longitude);
                                rowItems.add(item);
                            }

                            CustomListViewAdapter adapter = new CustomListViewAdapter(MainActivity.this, R.layout.activity_list, rowItems);
                            free_list.setAdapter( adapter);


                            rowItems2 = new ArrayList<Rowitem>();

                            contacts2 = obj.getJSONArray("paid_list");

                            for (int i = 0; i < contacts2.length(); i++) {
                                JSONObject aobj2 = contacts2.getJSONObject(i);

                                String name = aobj2.getString("name");
                                //System.out.println("hhhhhhhhhhhhhhhhhh"+name);
                                String wifi_type = aobj2.getString("wifi_type");
                                String bssid = aobj2.getString("bssid");
                                String key = aobj2.getString("key");
                                String latitude = aobj2.getString("latitude");
                                String longitude = aobj2.getString("longitude");
                                String half = aobj2.getString("half");
                                String one = aobj2.getString("one");
                                String two = aobj2.getString("two");
                                String five = aobj2.getString("five");
                                String ten = aobj2.getString("ten");
                                String twenty = aobj2.getString("twenty");
                                String twenty_four = aobj2.getString("twenty_four");
                                // System.out.println("ffffffffff  " + twenty_four);

                                Rowitem item2;
                                item2 = new Rowitem(name, wifi_type, bssid, key, latitude, longitude, half, one, two, five, ten, twenty, twenty_four);
                                rowItems2.add(item2);
                            }
                            CustomListViewAdapter1 adapter1 = new CustomListViewAdapter1(MainActivity.this, R.layout.activity_list2, rowItems2);
                            paid_list.setAdapter(adapter1);









                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        Log.w("Response", response);
                        System.out.println(response.toString());

                        //mTextView.setText("response is :" +response.substring(0, 100));

                        pDialog.dismiss();
                        ;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        pDialog.dismiss();
                        System.out.print("errrrrrrrrrrrrro");
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                // the POST parameters:
                // params.put("action", "top_score");

                params.put("leagueid", "1");
                params.put("userid", "5");
                params.put("season", "2015-16");
                return params;
            }
        };


        queue.add(postRequest);
        // AppController.getInstance().addToRequestQueue(postRequest, tag);
    }


}
