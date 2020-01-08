package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.ApiResponse.visitors.VisistoersDataResponse;
import com.google.gson.Gson;

import org.json.JSONObject;
import java.util.ArrayList;

public class VisitorsData extends Fragment {
    private RecyclerView recycler_view;
    private RecyclerView.LayoutManager layoutManager;
    public static VisistoersDataResponse visistoersDataResponse;
    public ArrayList<VisitoerTotalData> visitoer_array;
    ProgressDialog progressDialog;
    UsersAdapter adapter;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        init();
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_one, container, false);
        init(rootView);
        return rootView;
    }

    public void init(View v){
        recycler_view = (RecyclerView)v. findViewById(R.id.recycler_view);
        //set adapters
        recycler_view.setHasFixedSize(true);
        //for list
        layoutManager = new LinearLayoutManager(getActivity());
        //for grid
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        getresponse();
    }

    int no;
    private void getresponse() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Arya ForgotPassword");
        progressDialog.setMessage("Loding in, Please wait...");
        progressDialog.show();
        JSONObject object = new JSONObject();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, "https://reqres.in/api/users?page=2", object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response:====>",response.toString());
                        visistoersDataResponse = parseGsonResponse(response.toString(), VisistoersDataResponse.class);
                        String total = visistoersDataResponse.getTotal();
                        no = Integer.parseInt(total);
                        Toast.makeText(getActivity(),total,Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        setUserData();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.toString());
                Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(getRequest);
    }

    public void setUserData(){
        visitoer_array = new ArrayList();
        for (int i = 0; i< visistoersDataResponse.getData().length; i++){
            VisitoerTotalData visitoerTotalData = new VisitoerTotalData();
            visitoerTotalData.setAvatar(visistoersDataResponse.getData()[i].getAvatar());
            visitoerTotalData.setId(visistoersDataResponse.getData()[i].getId());
            visitoerTotalData.setEmail(visistoersDataResponse.getData()[i].getEmail());
            visitoerTotalData.setFirst_name(visistoersDataResponse.getData()[i].getFirst_name());
            visitoerTotalData.setLast_name(visistoersDataResponse.getData()[i].getLast_name());
            visitoer_array.add(visitoerTotalData);
        }
        if (no>0){
            adapter = new UsersAdapter(getActivity(),visitoer_array);
            recycler_view.setAdapter(adapter);
        }
    }

    public static <T>T parseGsonResponse(String serverResponse, Class<T> target){
        T data = null;
        Gson gson = new Gson();
        try {
            data = gson.fromJson(serverResponse, target);
        }
        catch (Exception e) {
            Log.v("data","error " + e.toString());
        }
        // Log.v(TAG,"data trans " + data);
        return data;
    }

    /*@Override
    public void onResume() {
        super.onResume();
        progressDialog.dismiss();
    }*/

    @Override
    public void onPause() {
        super.onPause();
        progressDialog.dismiss();
    }

    @Override
    public void onStop() {
        super.onStop();
        progressDialog.dismiss();
    }
}
