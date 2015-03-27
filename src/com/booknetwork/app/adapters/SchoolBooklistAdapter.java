package com.booknetwork.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.booknetwork.app.entity.SchoolBooklistRawItem;

import java.util.List;

public class SchoolBooklistAdapter
  extends ArrayAdapter<SchoolBooklistRawItem>
{
  Context context;
  
  public SchoolBooklistAdapter(Context paramContext, int paramInt, List<SchoolBooklistRawItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SchoolBooklistRawItem localSchoolBooklistRawItem = (SchoolBooklistRawItem)getItem(paramInt);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    Viewholder localViewholder;
    if (paramView == null)
    {
      paramView = localLayoutInflater.inflate(2130903064, null);
      localViewholder = new Viewholder(null);
      localViewholder.titleTxt = ((TextView)paramView.findViewById(2131361975));
      localViewholder.authorTxt = ((TextView)paramView.findViewById(2131361976));
      localViewholder.image = ((ImageView)paramView.findViewById(2131361973));
      paramView.setTag(localViewholder);
    }
    for (;;)
    {
      localViewholder.titleTxt.setText(localSchoolBooklistRawItem.getTitle());
      localViewholder.authorTxt.setText(localSchoolBooklistRawItem.getAuthor());
      localViewholder.image.setImageResource(localSchoolBooklistRawItem.getImageId());
      return paramView;
      localViewholder = (Viewholder)paramView.getTag();
    }
  }
  
  private class Viewholder
  {
    TextView authorTxt;
    ImageView image;
    TextView titleTxt;
    
    private Viewholder() {}
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.adapters.SchoolBooklistAdapter
 * JD-Core Version:    0.7.0.1
 */