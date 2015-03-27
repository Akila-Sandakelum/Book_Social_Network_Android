package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.booknetwork.app.adapters.SchoolBooklistAdapter;
import com.booknetwork.app.entity.SchoolBooklistRawItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SchoolBookLIst
  extends Activity
{
  SchoolBooklistAdapter adapter;
  ListView listview;
  ArrayList<SchoolBooklistInfo> mBookInfoList;
  List<SchoolBooklistRawItem> rowItems;
  int user_id;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903063);
    Button localButton = (Button)findViewById(2131361972);
    this.listview = ((ListView)findViewById(2131361971));
    this.user_id = getIntent().getExtras().getInt("credential_id");
    this.rowItems = new ArrayList();
    for (;;)
    {
      try
      {
        TaskGetSchoolBooklist localTaskGetSchoolBooklist = new TaskGetSchoolBooklist();
        Integer[] arrayOfInteger = new Integer[1];
        arrayOfInteger[0] = Integer.valueOf(this.user_id);
        this.mBookInfoList = ((ArrayList)localTaskGetSchoolBooklist.execute(arrayOfInteger).get());
        i = 0;
        int j = this.mBookInfoList.size();
        if (i < j) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        SchoolBooklistRawItem localSchoolBooklistRawItem;
        localInterruptedException.printStackTrace();
        continue;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        continue;
      }
      this.adapter = new SchoolBooklistAdapter(this, 2130903064, this.rowItems);
      this.listview.setAdapter(this.adapter);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), EditSchoolBookList.class);
          localIntent.putExtra("credential_id", SchoolBookLIst.this.user_id);
          SchoolBookLIst.this.startActivity(localIntent);
        }
      });
      return;
      localSchoolBooklistRawItem = new SchoolBooklistRawItem(2130837504, ((SchoolBooklistInfo)this.mBookInfoList.get(i)).getTitle(), ((SchoolBooklistInfo)this.mBookInfoList.get(i)).getAuthor());
      this.rowItems.add(localSchoolBooklistRawItem);
      i++;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.SchoolBookLIst
 * JD-Core Version:    0.7.0.1
 */