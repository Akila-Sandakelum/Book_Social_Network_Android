package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.booknetwork.app.adapters.FriendlistAdapter;
import com.booknetwork.app.entity.FriendlistRawItm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Friendlist
  extends Activity
{
  FriendlistAdapter adapter;
  ListView listview;
  ArrayList<FriendlistInfo> mfriendInfoList;
  List<FriendlistRawItm> rowItems;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903050);
    this.rowItems = new ArrayList();
    this.listview = ((ListView)findViewById(2131361894));
    for (;;)
    {
      try
      {
        this.mfriendInfoList = ((ArrayList)new TaskGetFriendListInfo().execute(new Void[0]).get());
        i = 0;
        int j = this.mfriendInfoList.size();
        if (i < j) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        FriendlistRawItm localFriendlistRawItm;
        localInterruptedException.printStackTrace();
        continue;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        continue;
      }
      this.adapter = new FriendlistAdapter(this, 2130903062, this.rowItems);
      this.listview.setAdapter(this.adapter);
      this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          String str = ((FriendlistRawItm)Friendlist.this.listview.getItemAtPosition(paramAnonymousInt)).getCredential_id();
          Intent localIntent = new Intent(Friendlist.this, ShopBookMenu.class);
          localIntent.putExtra("credential_id", str);
          Friendlist.this.startActivity(localIntent);
        }
      });
      return;
      localFriendlistRawItm = new FriendlistRawItm(2130837507, ((FriendlistInfo)this.mfriendInfoList.get(i)).getName(), ((FriendlistInfo)this.mfriendInfoList.get(i)).home_town, ((FriendlistInfo)this.mfriendInfoList.get(i)).getCredential_id());
      this.rowItems.add(localFriendlistRawItm);
      i++;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.Friendlist
 * JD-Core Version:    0.7.0.1
 */