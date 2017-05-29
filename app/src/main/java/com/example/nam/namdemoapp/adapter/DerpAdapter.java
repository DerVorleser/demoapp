package com.example.nam.namdemoapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.nam.namdemoapp.R;
import com.example.nam.namdemoapp.model.ListItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nam on 5/25/17.
 */

//Create an interface inside DerpAdapter.java, called itemClickCallbacks, with two methods: The first, onItemClick(int p), will fire when the user clicks on anything but the secondary action icon; the second, onSecondaryIconClick(int p) doesn't warrant further explanation.
//    Make Derpholder implement View.OnClickListener, and override the requisite methods.
//    Call .setOnClickListener(this) on container and secondaryIcon.
//    Update onBindViewHolder() to handle our new kinds of data.
//    Depending on whether container or secondaryIcon was clicked, call the appropriate interface method, passing getAdapterPosition() as our parameter.

public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder>{

  private List<ListItem> listData;
  private LayoutInflater inflater;

  private ItemClickCallBack itemClickCallBack;

  public interface ItemClickCallBack {
    void onItemClick(int p);
    void onSecondaryIconClick(int p);
  }

  public void setItemClickCallback (final ItemClickCallBack itemClickCallBack) {
    this.itemClickCallBack = itemClickCallBack;
  }

  public DerpAdapter (List<ListItem> listData, Context c) {
    this.inflater = LayoutInflater.from(c);
    this.listData = listData;
  }

  @Override public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.list_item, parent, false);
    return new DerpHolder(view);
  }

  @Override public void onBindViewHolder(DerpHolder holder, int position) {
    ListItem item = listData.get(position);
    holder.title.setText(item.getTitle());
    holder.subTitle.setText(item.getSubTitle());
    if (item.isFavourite()) {
      holder.secondaryIcon.setImageResource(R.drawable.starmud);
    } else {
      holder.secondaryIcon.setImageResource(R.drawable.star);
    }

  }

  public void setListData(ArrayList<ListItem> exerciseList) {
    this.listData.clear();
    this.listData.addAll(exerciseList);
  }

  @Override public int getItemCount() {
    return listData.size();
  }

  class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView title;
    private ImageView thumbnail;
    private ImageView secondaryIcon;

    private View container;
    private TextView subTitle;


    public DerpHolder(View itemView) {
      super(itemView);
      title = (TextView) itemView.findViewById(R.id.lbl_item_text);
      subTitle = (TextView) itemView.findViewById(R.id.lbl_item_sub_title);
      thumbnail = (ImageView) itemView.findViewById(R.id.im_item_icon);
      secondaryIcon = (ImageView) itemView.findViewById(R.id.im_item_icon_secondary);
      secondaryIcon.setOnClickListener(this);
      container = itemView.findViewById(R.id.cont_item_root);
      container.setOnClickListener(this);

    }

    @Override public void onClick(View v) {
      if (v.getId() == R.id.cont_item_root) {
        itemClickCallBack.onItemClick(getAdapterPosition());

      } else {
        itemClickCallBack.onSecondaryIconClick(getAdapterPosition());

      }

    }
  }

}
