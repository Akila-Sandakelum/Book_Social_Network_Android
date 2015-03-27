package com.booknetwork.app.adapters;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.booknetwork.app.Wishlist;
import com.booknetwork.app.entity.WishListRawItem;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class WishListAdapter
  extends ArrayAdapter<WishListRawItem>
{
  Context context;
  
  public WishListAdapter(Context paramContext, int paramInt, List<WishListRawItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final WishListRawItem localWishListRawItem = (WishListRawItem)getItem(paramInt);
    View localView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130903072, null);
    Viewholder localViewholder = new Viewholder(null);
    localViewholder.titleTxt = ((TextView)localView.findViewById(2131362024));
    localViewholder.authorTxt = ((TextView)localView.findViewById(2131362023));
    localViewholder.image = ((ImageView)localView.findViewById(2131362025));
    localViewholder.titleTxt.setText(localWishListRawItem.getTitle());
    localViewholder.authorTxt.setText(localWishListRawItem.getAuthor());
    localViewholder.image.setImageResource(localWishListRawItem.getImageId());
    localViewholder.image.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(WishListAdapter.this.getContext());
        localBuilder.setTitle("Alert message!");
        localBuilder.setMessage("Are you sure you want to delete?");
        localBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            Wishlist.rowItems.remove(this.val$rowItem);
            Wishlist.adapter = new WishListAdapter(WishListAdapter.this.getContext(), 2130903072, Wishlist.rowItems);
            Wishlist.listview.setAdapter(Wishlist.adapter);
            try
            {
              TaskDeleteWishlist localTaskDeleteWishlist = new TaskDeleteWishlist();
              String[] arrayOfString = new String[1];
              arrayOfString[0] = this.val$rowItem.getInterest_id();
              ((Integer)localTaskDeleteWishlist.execute(arrayOfString).get()).intValue();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              return;
            }
            catch (ExecutionException localExecutionException)
            {
              localExecutionException.printStackTrace();
            }
          }
        });
        localBuilder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        localBuilder.create().show();
      }
    });
    return localView;
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
 * Qualified Name:     com.booknetwork.app.adapters.WishListAdapter
 * JD-Core Version:    0.7.0.1
 */