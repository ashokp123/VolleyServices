package com.example.myapplication.ExConstants;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constants {

    public static String[] location_array = {"California","Chicago","San Fransisco","California"};

    public static String picuri_path="/breadmerchant/images";

    //login
    public static String partyId,partyTypeId,partyType,dlFront,dlBack,institutn_id,stateId,consumerData;
    public static String merchantUserId,accountId,openedDate,closedDate,currentBalance,status,institutionId,
                         institutionName,merchantId,merchantName,roleType,locationId,loginStatus,isAdministrator,userName;
    public static String geographicAddress,telecomAddress,webAddress;
    public static String id,deviceId,mpin,password,user_id,token_val,first_time_login;
    public static String registeredIdData,securityQuestions,roleId,roleName;
    public static String old_mpin;

    //for merchant_user_details
    public static String mud_id,mud_institutionId,mud_institutionName,mud_merchantName,mud_merchantId,mud_roleType,mud_userId,
                         mud_isAdministrator,mud_party,mud_mobileNumber,mud_emailId,mud_password,mud_confirmPassword,mud_status,
                         mud_loginStatus,mud_locationId,mud_userName,mud_mpin,mud_deviceId;

    //security_questions
    public static String qstn_id_onee,qstn_one,qstn_institutn_id_one,qstn_id_twoo,qstn_two,qstn_institutn_id_two,
                         qstn_id_three,qstn_three,qstn_institutn_id_three,qstn_id_four,qstn_four,qstn_institutn_id_four,
                         qstn_id_five,qstn_five,qstn_institutn_id_five;

    public static String location_name,location_id;
    //loc_details
    public static String ld_physical_addrss,ld_email,ld_phone,ld_account_id,ld_nickname;
    public static String nick_name_txt;

    public static String stateNames = "";

    public String mercnt_acnt_number,mercnt_acnt_name;
    public static String qstn_id_one,qstn_id_two;

    public static String loc_data;
    public static String account_name,account_id;

    public static double addrss_latitude,addrss_longitude;

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public static void ToastMethod(String meeasge, Context context){
        Toast.makeText(context, meeasge, Toast.LENGTH_SHORT).show();
    }

    public static void LogMethod(String meeasge, String meeasge1){
        //Toast.makeText(context, meeasge, Toast.LENGTH_SHORT).show();
        Log.d(meeasge,meeasge1);
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isPasswordPattern(String password) {
        String PASSSWORD_PATTERN = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        Pattern pattern = Pattern.compile(PASSSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static ProgressDialog progressDialog;
    public static Dialog dialog;

    public static void Progressbarshow(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        //progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);
        progressDialog.show();

    }
    public static void Progressbarcancel(Context context) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
