package com.example.nam.namdemoapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/**
 * Created by nam on 5/25/17.
 */

public class AdapterItems {

  public int ID;
  public String JobTitle;
  public String Description;

  AdapterItems(int ID, String JobTitle, String Desctiption) {
    this.ID = ID;
    this.JobTitle = JobTitle;
    this.Description = Desctiption;
  }

}


