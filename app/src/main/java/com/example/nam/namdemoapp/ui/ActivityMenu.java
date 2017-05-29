package com.example.nam.namdemoapp.ui;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.nam.namdemoapp.R;

public class ActivityMenu extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.mainmenu, menu);
    SearchView sv = (SearchView) menu.findItem(R.id.searchbar).getActionView();
    SearchManager sm = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    sv.setSearchableInfo(sm.getSearchableInfo(getComponentName()));
    sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        Toast.makeText(getApplicationContext(), query, Toast.LENGTH_LONG).show();
        return false;
      }

      @Override public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.home:
        Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
        return true;
      case R.id.add:
        Toast.makeText(this, "Add", Toast.LENGTH_LONG).show();
        return true;
      case R.id.setting:
        Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }


}
