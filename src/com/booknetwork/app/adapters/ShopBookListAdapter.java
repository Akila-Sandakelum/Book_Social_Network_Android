package com.booknetwork.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.booknetwork.app.entity.BooklistRawItem;

import java.util.List;

public class ShopBookListAdapter
  extends ArrayAdapter<BooklistRawItem>
{
  Context context;
  
  public ShopBookListAdapter(Context paramContext, int paramInt, List<BooklistRawItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BooklistRawItem localBooklistRawItem = (BooklistRawItem)getItem(paramInt);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    Viewholder localViewholder;
    if (paramView == null)
    {
      paramView = localLayoutInflater.inflate(2130903069, null);
      localViewholder = new Viewholder(null);
      localViewholder.titleTxt = ((TextView)paramView.findViewById(2131361993));
      localViewholder.qtyTxt = ((TextView)paramView.findViewById(2131361994));
      localViewholder.qty = ((TextView)paramView.findViewById(2131361995));
      localViewholder.image = ((ImageView)paramView.findViewById(2131361992));
      paramView.setTag(localViewholder);
    }
    for (;;)
    {
      localViewholder.titleTxt.setText(localBooklistRawItem.getTitle());
      localViewholder.qty.setText(localBooklistRawItem.getquantity());
      localViewholder.image.setImageResource(localBooklistRawItem.getImageId());
      return paramView;
      localViewholder = (Viewholder)paramView.getTag();
    }
  }
  
  private class Viewholder
  {
    ImageView image;
    TextView qty;
    TextView qtyTxt;
    TextView titleTxt;
    
    private Viewholder() {}
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.adapters.ShopBookListAdapter
 * JD-Core Version:    0.7.0.1
 */