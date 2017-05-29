package com.example.nam.namdemoapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nam.namdemoapp.R;
import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

  ArrayList<AdapterItems> listNewsData = new ArrayList<AdapterItems>();
  MyCustomAdapter myadapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view);

    ListView listlv = (ListView) findViewById(R.id.lvlist);

    //Insert the data to the adapter and view it
    listNewsData.add(new AdapterItems(1, "developer", "develop apps"));
    listNewsData.add(new AdapterItems(2, "investor", "trading stocks"));
    listNewsData.add(new AdapterItems(3, "admin", "handling documents"));
    listNewsData.add(new AdapterItems(4, "accountant", "accounting"));
    listNewsData.add(new AdapterItems(5, "CTO", "manage the firm"));
    listNewsData.add(new AdapterItems(6, "assistant", "handling documents"));
    myadapter = new MyCustomAdapter(listNewsData);
    listlv.setAdapter(myadapter);

  }

  //display the news list
  public class MyCustomAdapter extends BaseAdapter {
    public ArrayList<AdapterItems> listNewsDataAdapter;

    public MyCustomAdapter(ArrayList<AdapterItems> listNewsDataAdapter) {
      this.listNewsDataAdapter = listNewsDataAdapter;
    }

    @Override public int getCount() {
      return listNewsDataAdapter.size();
    }

    @Override public Object getItem(int position) {
      return null;
    }

    @Override public long getItemId(int position) {
      return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
      LayoutInflater mInflater = getLayoutInflater();
      View myView = mInflater.inflate(R.layout.layout_ticket, null);

      final AdapterItems s = listNewsDataAdapter.get(position);
      TextView tvID = (TextView) myView.findViewById(R.id.tvID);
      tvID.setText("ID: " + s.ID);

      TextView tvTitle = (TextView) myView.findViewById(R.id.tvTitle);
      tvTitle.setText(s.JobTitle);
      tvTitle.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          Toast.makeText(getApplicationContext(), s.JobTitle, Toast.LENGTH_LONG).show();
        }
      });

      TextView tvDesc = (TextView) myView.findViewById(R.id.tvDesc);
      tvDesc.setText(s.Description);

      return myView;

    }


  }
}
