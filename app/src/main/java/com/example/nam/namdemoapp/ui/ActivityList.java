package com.example.nam.namdemoapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nam.namdemoapp.R;

public class ActivityList extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
  }

  public void buShow(View view) {
    //Hey I'm gonna communicate with a layout
    LayoutInflater mylayoutInflator = getLayoutInflater();
    //This is the way I commnunicate to a server
    View view1 = mylayoutInflator.inflate(R.layout.showlayout, null);
    EditText et = (EditText) view1.findViewById(R.id.editText6);
    et.setText("Welcome");
    Toast toast = new Toast(getApplicationContext());
    toast.setView(view1);
    toast.setDuration(Toast.LENGTH_LONG);
    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    toast.show();

  }


}
