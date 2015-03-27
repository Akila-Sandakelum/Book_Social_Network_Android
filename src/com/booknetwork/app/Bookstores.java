package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.booknetwork.app.adapters.BookstoresAdapter;
import com.booknetwork.app.entity.BookstoreRawItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Bookstores
  extends Activity
{
  BookstoresAdapter adapter;
  ListView listview;
  ArrayList<BookstoreInfo> mStoreInfoList;
  List<BookstoreRawItem> rowItems;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    this.rowItems = new ArrayList();
    this.listview = ((ListView)findViewById(2131361841));
    for (;;)
    {
      try
      {
        this.mStoreInfoList = ((ArrayList)new TaskGetBookStores().execute(new Void[0]).get());
        i = 0;
        int j = this.mStoreInfoList.size();
        if (i < j) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        BookstoreRawItem localBookstoreRawItem;
        localInterruptedException.printStackTrace();
        continue;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        continue;
      }
      this.adapter = new BookstoresAdapter(this, 2130903060, this.rowItems);
      this.listview.setAdapter(this.adapter);
      this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = ((BookstoreRawItem)Bookstores.this.listview.getItemAtPosition(paramAnonymousInt)).getId();
          Intent localIntent = new Intent(Bookstores.this, ShopBookList.class);
          localIntent.putExtra("credential_id", i);
          Bookstores.this.startActivity(localIntent);
        }
      });
      return;
      localBookstoreRawItem = new BookstoreRawItem(2130837507, ((BookstoreInfo)this.mStoreInfoList.get(i)).getId(), ((BookstoreInfo)this.mStoreInfoList.get(i)).getName(), ((BookstoreInfo)this.mStoreInfoList.get(i)).getLocation());
      this.rowItems.add(localBookstoreRawItem);
      i++;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.Bookstores
 * JD-Core Version:    0.7.0.1
 */