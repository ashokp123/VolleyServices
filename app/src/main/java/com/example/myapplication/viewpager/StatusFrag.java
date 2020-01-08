package com.example.myapplication.viewpager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.myapplication.ApiResponse.status.StatusResponse;
import com.example.myapplication.ApiResponse.visitors.VisistoersDataResponse;
import com.example.myapplication.R;
import com.example.myapplication.StatusAdapter;
import com.example.myapplication.StatusTotalData;
import com.example.myapplication.UsersAdapter;
import com.example.myapplication.VisitoerTotalData;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class StatusFrag extends Fragment {
    private RecyclerView status_recycler_view;
    private RecyclerView.LayoutManager layoutManager;

    public static StatusResponse statusResponse;
    public ArrayList<StatusTotalData> status_array;
    ProgressDialog progressDialog;
    StatusAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.status, container, false);
        init(rootView);
        return rootView;
    }

    public void init(View v){
        status_recycler_view = (RecyclerView)v. findViewById(R.id.status_recycler_view);
        //set adapters
        status_recycler_view.setHasFixedSize(true);
        //for list
        layoutManager = new LinearLayoutManager(getActivity());
        //for grid
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        status_recycler_view.setLayoutManager(layoutManager);
        status_recycler_view.setItemAnimator(new DefaultItemAnimator());
        getresponse();

    }

    int no;
    private void getresponse() {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Arya ForgotPassword");
        progressDialog.setMessage("Loding in, Please wait...");
        progressDialog.show();

        JSONObject object = new JSONObject();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, "https://gorest.co.in/public-api/users?_format=json&access-token=yrRT2jRYMF8YWMnRyOqendNj423smt5TDi01", object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response:====>",response.toString());
                        statusResponse = parseGsonResponse(response.toString(), StatusResponse.class);
                        String code = statusResponse.get_meta().getTotalCount();
                        no = Integer.parseInt(code);
                        Toast.makeText(getActivity(),code,Toast.LENGTH_SHORT).show();
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
        status_array = new ArrayList();
        for (int i = 0; i< statusResponse.getResult().length; i++){
            StatusTotalData statusTotalData = new StatusTotalData();

            statusTotalData.setHref(statusResponse.getResult()[i].get_links().getAvatar().getHref());
            statusTotalData.setFirst_name(statusResponse.getResult()[i].getFirst_name());
            statusTotalData.setLast_name(statusResponse.getResult()[i].getLast_name());
            statusTotalData.setEmail(statusResponse.getResult()[i].getEmail());
            statusTotalData.setPhone(statusResponse.getResult()[i].getPhone());
            statusTotalData.setGender(statusResponse.getResult()[i].getGender());
            statusTotalData.setStatus(statusResponse.getResult()[i].getStatus());
            status_array.add(statusTotalData);
        }
        if (no>0){
            adapter = new StatusAdapter(getActivity(),status_array);
            status_recycler_view.setAdapter(adapter);
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
