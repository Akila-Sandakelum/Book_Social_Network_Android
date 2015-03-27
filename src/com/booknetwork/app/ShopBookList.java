package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.booknetwork.app.adapters.ShopBookListAdapter;
import com.booknetwork.app.entity.BooklistRawItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ShopBookList
  extends Activity
{
  ShopBookListAdapter adapter;
  ListView listview;
  ArrayList<BooklistInfo> mBookInfoList;
  List<BooklistRawItem> rowItems;
  int user_id;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903067);
    Button localButton = (Button)findViewById(2131361988);
    this.listview = ((ListView)findViewById(2131361987));
    this.user_id = getIntent().getExtras().getInt("credential_id");
    this.rowItems = new ArrayList();
    for (;;)
    {
      try
      {
        TaskGetShopBooklistInfo localTaskGetShopBooklistInfo = new TaskGetShopBooklistInfo();
        Integer[] arrayOfInteger = new Integer[1];
        arrayOfInteger[0] = Integer.valueOf(this.user_id);
        this.mBookInfoList = ((ArrayList)localTaskGetShopBooklistInfo.execute(arrayOfInteger).get());
        i = 0;
        int j = this.mBookInfoList.size();
        if (i < j) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        BooklistRawItem localBooklistRawItem;
        localInterruptedException.printStackTrace();
        continue;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        continue;
      }
      this.adapter = new ShopBookListAdapter(this, 2130903069, this.rowItems);
      this.listview.setAdapter(this.adapter);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(paramAnonymousView.getContext(), "Add a book to Shop", 3000).show();
          Log.i("wwwwwwwwwwwww", "Add a book to Shop");
          Intent localIntent = new Intent(paramAnonymousView.getContext(), EditShoopBookList.class);
          localIntent.putExtra("credential_id", ShopBookList.this.user_id);
          ShopBookList.this.startActivity(localIntent);
        }
      });
      return;
      localBooklistRawItem = new BooklistRawItem(2130837504, ((BooklistInfo)this.mBookInfoList.get(i)).getTitle(), ((BooklistInfo)this.mBookInfoList.get(i)).getQuantity());
      this.rowItems.add(localBooklistRawItem);
      i++;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.ShopBookList
 * JD-Core Version:    0.7.0.1
 */