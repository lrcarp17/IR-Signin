package edu.nsu.ir.LoginSignin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import edu.nsu.ir.Cases.AppURLS;

public class LSSignupActivity extends AppCompatActivity {
    private Button mNewAccount;
    private Button mLogin;
    private EditText mFistName, mLastName,mUserName, mEmail, mPassword, mCity, mState, mCompany, mExperience, mContact;
    private Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(edu.nsu.ir.R.layout.ls_activity_signup);
        init();
        mNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LSSignupActivity.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LSSignupActivity.this, LSLoginActivity.class);
                startActivity(intent);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LSSignupActivity.this, LSLoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
mContext=this;
        mNewAccount = (Button)findViewById(edu.nsu.ir.R.id.freshAccountButton);
        mLogin = (Button)findViewById(edu.nsu.ir.R.id.backLogin);

    }
    private void doReg(){

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppURLS.REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG-RESPONSE", response.toString());
                       // clearFields();
                        Toast.makeText(mContext, "You Signed up successfully", Toast.LENGTH_LONG).show();
                       // startActivity(new Intent(getApplicationContext(),HomeActivity.class));
//                        statusReponse= gson.fromJson(response, StatusReponse.class);
//                        Toast.makeText(context, statusReponse.toString(), Toast.LENGTH_LONG).show();
//                        if(statusReponse.getSuccess()==1){
//                            clearFields();
//
//                        }else{
//                            Toast.makeText(context, "Sorry Post could not be added", Toast.LENGTH_LONG).show();
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
//                params.put(AppURLS.KEY_NAME, userProfile.getName());
//                params.put(AppURLS.KEY_EMAIL, userProfile.getEmail());
//                params.put(AppURLS.KEY_LOCATION, userProfile.getLocation());
//                params.put(AppURLS.KEY_CHURCH, userProfile.getChurch());
//                params.put(AppURLS.KEY_PASSWORD, userProfile.getPassword());
//                params.put(AppURLS.KEY_IMAGEURL, userProfile.getImageURL());

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
