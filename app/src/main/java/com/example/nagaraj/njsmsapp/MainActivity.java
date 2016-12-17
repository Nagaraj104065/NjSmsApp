
package com.example.nagaraj.njsmsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            Intent smsintent;
            smsintent=new Intent(Intent.ACTION_VIEW);
            smsintent.setData(Uri.parse("smsto:"));
            smsintent.setType("vnd.android-dir/mms-sms");
            smsintent.putExtra("address",new String("+918098827964"));
            smsintent.putExtra("sms_body","sms testing app");
            try{
                startActivity(smsintent);
                finish();
                Toast.makeText(getBaseContext(),"working",Toast.LENGTH_SHORT).show();
            }catch (android.content.ActivityNotFoundException e){
                Toast.makeText(MainActivity.this,
                        "SMS faild, please try again later.",          Toast.LENGTH_SHORT).show();
            }

        }
    }
}
