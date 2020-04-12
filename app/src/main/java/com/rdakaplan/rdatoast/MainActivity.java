package com.rdakaplan.rdatoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rdakaplan.rdatoastlibrary.RDAToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void info(View view) {

        RDAToast.info(this, "MY AWESOME INFO TOAST", Toast.LENGTH_LONG);
    }
}
