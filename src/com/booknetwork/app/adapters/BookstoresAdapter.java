package com.booknetwork.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.booknetwork.app.entity.BookstoreRawItem;

import java.util.List;

public class BookstoresAdapter
  extends ArrayAdapter<BookstoreRawItem>
{
  Context context;
  
  public BookstoresAdapter(Context paramContext, int paramInt, List<BookstoreRawItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BookstoreRawItem localBookstoreRawItem = (BookstoreRawItem)getItem(paramInt);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
    Viewholder localViewholder;
    if (paramView == null)
    {
      paramView = localLayoutInflater.inflate(2130903060, null);
      localViewholder = new Viewholder(null);
      localViewholder.nameTxt = ((TextView)paramView.findViewById(2131361958));
      localViewholder.locationTxt = ((TextView)paramView.findViewById(2131361959));
      localViewholder.image = ((ImageView)paramView.findViewById(2131361957));
      paramView.setTag(localViewholder);
    }
    for (;;)
    {
      localViewholder.nameTxt.setText(localBookstoreRawItem.getName());
      localViewholder.locationTxt.setText(localBookstoreRawItem.getLocation());
      localViewholder.image.setImageResource(localBookstoreRawItem.getImageId());
      return paramView;
      localViewholder = (Viewholder)paramView.getTag();
    }
  }
  
  private class Viewholder
  {
    ImageView image;
    TextView locationTxt;
    TextView nameTxt;
    
    private Viewholder() {}
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.adapters.BookstoresAdapter
 * JD-Core Version:    0.7.0.1
 */