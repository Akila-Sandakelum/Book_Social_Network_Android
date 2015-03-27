package com.booknetwork.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.booknetwork.app.entity.FriendlistRawItm;

import java.util.List;

public class FriendlistAdapter
  extends ArrayAdapter<FriendlistRawItm>
{
  Context context;
  
  public FriendlistAdapter(Context paramContext, int paramInt, List<FriendlistRawItm> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FriendlistRawItm localFriendlistRawItm = (FriendlistRawItm)getItem(paramInt);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    Viewholder localViewholder;
    if (paramView == null)
    {
      paramView = localLayoutInflater.inflate(2130903062, null);
      localViewholder = new Viewholder(null);
      localViewholder.nameTxt = ((TextView)paramView.findViewById(2131361968));
      localViewholder.homeTxt = ((TextView)paramView.findViewById(2131361969));
      localViewholder.image = ((ImageView)paramView.findViewById(2131361967));
      paramView.setTag(localViewholder);
    }
    for (;;)
    {
      localViewholder.nameTxt.setText(localFriendlistRawItm.getName());
      localViewholder.homeTxt.setText(localFriendlistRawItm.getHome_town());
      localViewholder.image.setImageResource(localFriendlistRawItm.getImageId());
      return paramView;
      localViewholder = (Viewholder)paramView.getTag();
    }
  }
  
  private class Viewholder
  {
    TextView homeTxt;
    ImageView image;
    TextView nameTxt;
    
    private Viewholder() {}
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.adapters.FriendlistAdapter
 * JD-Core Version:    0.7.0.1
 */