package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.booknetwork.app.adapters.WishListAdapter;
import com.booknetwork.app.entity.WishListRawItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Wishlist
  extends Activity
{
  public static WishListAdapter adapter;
  private static final String[] authors = { "William Hewage", "Sir Arthur", "Akila Sandakelum", "Dr.Rosa" };
  public static ListView listview;
  public static ArrayList<WishlistInfo> myWishList;
  public static List<WishListRawItem> rowItems;
  private static final String[] titles = { "Lord of the Rings", "Sherlock homes", "The mind", "Matrix" };
  public static int user_id;
  final Integer imageId = Integer.valueOf(2131362025);
  
  private void mymethod()
  {
    Toast.makeText(this, "Hi welcome", 2000).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903058);
    Bundle localBundle = getIntent().getExtras();
    myWishList = new ArrayList();
    rowItems = new ArrayList();
    user_id = getIntent().getExtras().getInt("credential_id");
    try
    {
      TaskGetWishlist localTaskGetWishlist = new TaskGetWishlist();
      Integer[] arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(user_id);
      myWishList = (ArrayList)localTaskGetWishlist.execute(arrayOfInteger).get();
      i = 0;
      if (i >= myWishList.size())
      {
        listview = (ListView)findViewById(2131361948);
        adapter = new WishListAdapter(this, 2130903072, rowItems);
        listview.setAdapter(adapter);
        Button localButton = (Button)findViewById(2131361949);
        if (localBundle.containsKey("source")) {
          localButton.setVisibility(4);
        }
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent(paramAnonymousView.getContext(), Edit_wishlist.class);
            localIntent.putExtra("credential_id", Wishlist.user_id);
            Wishlist.this.startActivityForResult(localIntent, 0);
          }
        });
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        int i;
        localExecutionException.printStackTrace();
        continue;
        WishListRawItem localWishListRawItem = new WishListRawItem(2130837505, ((WishlistInfo)myWishList.get(i)).getTitle(), ((WishlistInfo)myWishList.get(i)).getAuthor(), ((WishlistInfo)myWishList.get(i)).getInterest_id());
        rowItems.add(localWishListRawItem);
        i++;
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent.getStringExtra("methodName").equals("myMethod")) {
      mymethod();
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.Wishlist
 * JD-Core Version:    0.7.0.1
 */