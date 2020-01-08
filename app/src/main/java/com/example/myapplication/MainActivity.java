package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.ApiResponse.LoginResponse;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/*
public class MainActivity extends AppCompatActivity {

    EditText editTextLoginUserMobileNuber, editTextPassword;
    TextView get_Login;

    public static LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        editTextLoginUserMobileNuber = (EditText) findViewById(R.id.editTextLoginUserMobileNuber);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        get_Login = (TextView) findViewById(R.id.get_Login);

        get_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    String userName = "", password = "", mPin = "";

    public void login() {

        if (editTextLoginUserMobileNuber.getText().toString().trim().isEmpty() || editTextPassword.getText().toString().trim().isEmpty()) {
            if (editTextLoginUserMobileNuber.getText().toString().trim().isEmpty()) {
                editTextLoginUserMobileNuber.setError("invalid Email");
                editTextLoginUserMobileNuber.requestFocus();
                //Toast.makeText(LoginActivity.this,getResources().getString(R.string.valid_user_mobile_),Toast.LENGTH_SHORT).show();
            } else if (editTextPassword.getText().toString().trim().isEmpty()) {
                editTextPassword.setError("Invalid Password");
                editTextPassword.requestFocus();
                Toast.makeText(MainActivity.this, getResources().getString(R.string.valid_pswd_), Toast.LENGTH_SHORT).show();
            }
        } else if (editTextLoginUserMobileNuber.getText().toString().trim().length() < 0) {
        } else {
            requestPostJSON();
        }
    }

    public void requestPostJSON() {
        userName = editTextLoginUserMobileNuber.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        String url = "https://reqres.in/api/login";
        JSONObject jsonBody = new JSONObject();

        try {
            jsonBody.put("email", userName);
            jsonBody.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof NoConnectionError) {
                            Log.d("Error_Response:====>", error.toString());
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("Error_Response:====>", error.toString());
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.add(jsObjRequest);
    }
}
*/


public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    TextView textView1;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView1 = (TextView) findViewById(R.id.textview1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                postresponse();
            }
        });

        /*editText1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Editable input_char = (Editable)s;
                String ss = String.valueOf(s);

                for(int i=0; i<ss.length();i++){
                    char c = ss.charAt(i);
                    System.out.println("char at "+i+" index is: "+c);
                    charCheck(c);
                }
            }
        });*/

    }

    public void charCheck(char input_char) {
        // CHECKING FOR ALPHABET
        if ((input_char >= 65 && input_char <= 90)
                || (input_char >= 97 && input_char <= 122)){
            Toast.makeText(MainActivity.this," Alphabet ",Toast.LENGTH_SHORT).show();
            System.out.println(" Alphabet ");

            // CHECKING FOR DIGITS
    }else if (input_char >= 48 && input_char <= 57) {
            Toast.makeText(MainActivity.this," Digit ",Toast.LENGTH_SHORT).show();
        System.out.println(" Digit ");

        // OTHERWISE SPECIAL CHARACTER
    }else
            Toast.makeText(MainActivity.this," Special Character ",Toast.LENGTH_SHORT).show();
            System.out.println(" Special Character ");
    }

    private void postresponse() {

        JSONObject object = new JSONObject();
        try {
            object.put("email", editText1.getText().toString());
            object.put("password", editText2.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging In,Please Wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, "https://reqres.in/api/login", object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(getApplicationContext(), VisitorsData.class);
                        //startActivity(intent);
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(postRequest);
    }

    /*public void getWithHeader(){

    JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, url, json, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(getApplicationContext(), VisitorsData.class);
                    //startActivity(intent);
                    //progressDialog.dismiss();

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    //progressDialog.dismiss();
                }
            })
    {
        //* Passing some request headers*
        @Override
        public Map getHeaders() throws AuthFailureError {
            HashMap headers = new HashMap();
            //headers.put("Content-Type", "application/json");
            //headers.put("Bearer", token);
            return headers;
        }
    };
    RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsObjRequest);

    }*/


}