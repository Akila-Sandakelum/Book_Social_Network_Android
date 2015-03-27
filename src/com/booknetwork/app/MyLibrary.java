package com.booknetwork.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class MyLibrary
  extends Activity
  implements SearchView.OnQueryTextListener
{
  private Bundle bundle;
  private Intent intent;
  private ArrayList<BookInfo> myBooks;
  private ArrayList<String> result;
  String source;
  private int user_id;
  
  private void checkSource()
  {
    if (this.bundle.containsKey("source")) {
      this.intent.putExtra("guest", "myGuest");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903052);
    this.user_id = getIntent().getExtras().getInt("credential_id");
    this.bundle = getIntent().getExtras();
    Button localButton = (Button)findViewById(2131361919);
    SearchManager localSearchManager = (SearchManager)getSystemService("search");
    SearchView localSearchView = (SearchView)findViewById(2131361904);
    localSearchView.setSearchableInfo(localSearchManager.getSearchableInfo(getComponentName()));
    localSearchView.setIconifiedByDefault(false);
    localSearchView.setOnQueryTextListener(this);
    LinearLayout localLinearLayout1;
    LinearLayout localLinearLayout2;
    LinearLayout localLinearLayout3;
    LinearLayout localLinearLayout4;
    LinearLayout localLinearLayout5;
    LinearLayout localLinearLayout6;
    int i;
    try
    {
      TaskGetNewsFeeds localTaskGetNewsFeeds = new TaskGetNewsFeeds();
      Integer[] arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(this.user_id);
      this.myBooks = ((ArrayList)localTaskGetNewsFeeds.execute(arrayOfInteger).get());
      if (this.bundle.containsKey("source"))
      {
        this.source = getIntent().getExtras().getString("sorce");
        localButton.setVisibility(4);
      }
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(MyLibrary.this, Edit_library.class);
          localIntent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.startActivity(localIntent);
        }
      };
      localButton.setOnClickListener(local1);
      localArrayList = new ArrayList();
      localArrayList.add("Children's");
      localArrayList.add("Religion");
      localArrayList.add("Education");
      localArrayList.add("Fiction");
      localArrayList.add("Sports");
      localArrayList.add("Other");
      localLinearLayout1 = (LinearLayout)findViewById(2131361907);
      localLinearLayout2 = (LinearLayout)findViewById(2131361909);
      localLinearLayout3 = (LinearLayout)findViewById(2131361911);
      localLinearLayout4 = (LinearLayout)findViewById(2131361913);
      localLinearLayout5 = (LinearLayout)findViewById(2131361915);
      localLinearLayout6 = (LinearLayout)findViewById(2131361917);
      i = 0;
      int j = this.myBooks.size();
      if (i >= j)
      {
        Toast.makeText(this, localLinearLayout1.getChildCount() + " " + localLinearLayout2.getChildCount() + " " + localLinearLayout3.getChildCount() + " " + localLinearLayout4.getChildCount() + " " + localLinearLayout5.getChildCount() + " " + localLinearLayout6.getChildCount(), 3000).show();
        if (localLinearLayout1.getChildCount() == 1) {
          localLinearLayout1.setVisibility(8);
        }
        if (localLinearLayout2.getChildCount() == 1) {
          localLinearLayout2.setVisibility(8);
        }
        if (localLinearLayout3.getChildCount() == 1) {
          localLinearLayout3.setVisibility(8);
        }
        if (localLinearLayout4.getChildCount() == 1) {
          localLinearLayout4.setVisibility(8);
        }
        if (localLinearLayout5.getChildCount() == 1) {
          localLinearLayout5.setVisibility(8);
        }
        if (localLinearLayout6.getChildCount() == 1) {
          localLinearLayout6.setVisibility(8);
        }
        if ((localLinearLayout1.getChildCount() == 1) && (localLinearLayout2.getChildCount() == 1) && (localLinearLayout3.getChildCount() == 1) && (localLinearLayout4.getChildCount() == 1) && (localLinearLayout5.getChildCount() == 1) && (localLinearLayout6.getChildCount() == 1))
        {
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
          localBuilder.setTitle("Alert message!");
          localBuilder.setMessage("There are no added books in the Library!");
          DialogInterface.OnClickListener local8 = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              MyLibrary.this.finishActivity(0);
              Intent localIntent = new Intent(MyLibrary.this, ShopBookMenu.class);
              localIntent.putExtra("credential_id", Integer.toString(MyLibrary.this.user_id));
              localIntent.addFlags(67108864);
              MyLibrary.this.startActivity(localIntent);
            }
          };
          localBuilder.setNeutralButton("Ok", local8).show();
        }
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
      ArrayList localArrayList;
      for (;;)
      {
        localExecutionException.printStackTrace();
      }
      switch (localArrayList.indexOf(((BookInfo)this.myBooks.get(i)).getCategory()))
      {
      }
    }
    for (;;)
    {
      i++;
      break;
      TextView localTextView6 = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams6 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams6.gravity = 17;
      localLayoutParams6.setMargins(7, 7, 7, 7);
      localTextView6.setLayoutParams(localLayoutParams6);
      localTextView6.setText(((BookInfo)this.myBooks.get(i)).getTitle());
      localTextView6.setBackgroundColor(getResources().getColor(2131034112));
      localTextView6.setPadding(15, 15, 15, 15);
      localTextView6.setAlpha(0.9F);
      localLinearLayout1.addView(localTextView6);
      final BookInfo localBookInfo6 = (BookInfo)this.myBooks.get(i);
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(MyLibrary.this, localBookInfo6.getRating(), 3000).show();
          MyLibrary.this.intent = new Intent(MyLibrary.this, DialogBuilder.class);
          MyLibrary.this.intent.putExtra("title", localBookInfo6.getTitle());
          MyLibrary.this.intent.putExtra("author", localBookInfo6.getAuthor());
          MyLibrary.this.intent.putExtra("rating", localBookInfo6.getRating());
          MyLibrary.this.intent.putExtra("interest_id", localBookInfo6.getInterest_id());
          MyLibrary.this.intent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.checkSource();
          MyLibrary.this.startActivity(MyLibrary.this.intent);
        }
      };
      localTextView6.setOnClickListener(local2);
      continue;
      TextView localTextView5 = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams5 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams5.gravity = 17;
      localLayoutParams5.setMargins(7, 7, 7, 7);
      localTextView5.setLayoutParams(localLayoutParams5);
      localTextView5.setText(((BookInfo)this.myBooks.get(i)).getTitle());
      localTextView5.setBackgroundColor(getResources().getColor(2131034112));
      localTextView5.setPadding(15, 15, 15, 15);
      localTextView5.setAlpha(0.9F);
      localLinearLayout2.addView(localTextView5);
      final BookInfo localBookInfo5 = (BookInfo)this.myBooks.get(i);
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(MyLibrary.this, localBookInfo5.getRating(), 3000).show();
          MyLibrary.this.intent = new Intent(MyLibrary.this, DialogBuilder.class);
          MyLibrary.this.intent.putExtra("title", localBookInfo5.getTitle());
          MyLibrary.this.intent.putExtra("author", localBookInfo5.getAuthor());
          MyLibrary.this.intent.putExtra("rating", localBookInfo5.getRating());
          MyLibrary.this.intent.putExtra("interest_id", localBookInfo5.getInterest_id());
          MyLibrary.this.intent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.checkSource();
          MyLibrary.this.startActivity(MyLibrary.this.intent);
        }
      };
      localTextView5.setOnClickListener(local3);
      continue;
      TextView localTextView4 = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams4.gravity = 17;
      localLayoutParams4.setMargins(7, 7, 7, 7);
      localTextView4.setLayoutParams(localLayoutParams4);
      localTextView4.setText(((BookInfo)this.myBooks.get(i)).getTitle());
      localTextView4.setBackgroundColor(getResources().getColor(2131034112));
      localTextView4.setPadding(15, 15, 15, 15);
      localTextView4.setAlpha(0.9F);
      localLinearLayout3.addView(localTextView4);
      final BookInfo localBookInfo4 = (BookInfo)this.myBooks.get(i);
      View.OnClickListener local4 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(MyLibrary.this, localBookInfo4.getRating(), 3000).show();
          MyLibrary.this.intent = new Intent(MyLibrary.this, DialogBuilder.class);
          MyLibrary.this.intent.putExtra("title", localBookInfo4.getTitle());
          MyLibrary.this.intent.putExtra("author", localBookInfo4.getAuthor());
          MyLibrary.this.intent.putExtra("rating", localBookInfo4.getRating());
          MyLibrary.this.intent.putExtra("interest_id", localBookInfo4.getInterest_id());
          MyLibrary.this.intent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.checkSource();
          MyLibrary.this.startActivity(MyLibrary.this.intent);
        }
      };
      localTextView4.setOnClickListener(local4);
      continue;
      TextView localTextView3 = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams3.gravity = 17;
      localLayoutParams3.setMargins(7, 7, 7, 7);
      localTextView3.setLayoutParams(localLayoutParams3);
      localTextView3.setText(((BookInfo)this.myBooks.get(i)).getTitle());
      localTextView3.setBackgroundColor(getResources().getColor(2131034112));
      localTextView3.setPadding(15, 15, 15, 15);
      localTextView3.setAlpha(0.9F);
      localLinearLayout4.addView(localTextView3);
      final BookInfo localBookInfo3 = (BookInfo)this.myBooks.get(i);
      View.OnClickListener local5 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(MyLibrary.this, localBookInfo3.getRating(), 3000).show();
          MyLibrary.this.intent = new Intent(MyLibrary.this, DialogBuilder.class);
          MyLibrary.this.intent.putExtra("title", localBookInfo3.getTitle());
          MyLibrary.this.intent.putExtra("author", localBookInfo3.getAuthor());
          MyLibrary.this.intent.putExtra("rating", localBookInfo3.getRating());
          MyLibrary.this.intent.putExtra("interest_id", localBookInfo3.getInterest_id());
          MyLibrary.this.intent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.checkSource();
          MyLibrary.this.startActivity(MyLibrary.this.intent);
        }
      };
      localTextView3.setOnClickListener(local5);
      continue;
      TextView localTextView2 = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.gravity = 17;
      localLayoutParams2.setMargins(7, 7, 7, 7);
      localTextView2.setLayoutParams(localLayoutParams2);
      localTextView2.setText(((BookInfo)this.myBooks.get(i)).getTitle());
      localTextView2.setBackgroundColor(getResources().getColor(2131034112));
      localTextView2.setPadding(15, 15, 15, 15);
      localTextView2.setAlpha(0.9F);
      localLinearLayout5.addView(localTextView2);
      final BookInfo localBookInfo2 = (BookInfo)this.myBooks.get(i);
      View.OnClickListener local6 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(MyLibrary.this, localBookInfo2.getRating(), 3000).show();
          MyLibrary.this.intent = new Intent(MyLibrary.this, DialogBuilder.class);
          MyLibrary.this.intent.putExtra("title", localBookInfo2.getTitle());
          MyLibrary.this.intent.putExtra("author", localBookInfo2.getAuthor());
          MyLibrary.this.intent.putExtra("rating", localBookInfo2.getRating());
          MyLibrary.this.intent.putExtra("interest_id", localBookInfo2.getInterest_id());
          MyLibrary.this.intent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.checkSource();
          MyLibrary.this.startActivity(MyLibrary.this.intent);
        }
      };
      localTextView2.setOnClickListener(local6);
      continue;
      TextView localTextView1 = new TextView(this);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.gravity = 17;
      localLayoutParams1.setMargins(7, 7, 7, 7);
      localTextView1.setLayoutParams(localLayoutParams1);
      localTextView1.setText(((BookInfo)this.myBooks.get(i)).getTitle());
      localTextView1.setBackgroundColor(getResources().getColor(2131034112));
      localTextView1.setPadding(15, 15, 15, 15);
      localTextView1.setAlpha(0.9F);
      localLinearLayout6.addView(localTextView1);
      final BookInfo localBookInfo1 = (BookInfo)this.myBooks.get(i);
      View.OnClickListener local7 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toast.makeText(MyLibrary.this, localBookInfo1.getRating(), 3000).show();
          MyLibrary.this.intent = new Intent(MyLibrary.this, DialogBuilder.class);
          MyLibrary.this.intent.putExtra("title", localBookInfo1.getTitle());
          MyLibrary.this.intent.putExtra("author", localBookInfo1.getAuthor());
          MyLibrary.this.intent.putExtra("rating", localBookInfo1.getRating());
          MyLibrary.this.intent.putExtra("interest_id", localBookInfo1.getInterest_id());
          MyLibrary.this.intent.putExtra("credential_id", MyLibrary.this.user_id);
          MyLibrary.this.checkSource();
          MyLibrary.this.startActivity(MyLibrary.this.intent);
        }
      };
      localTextView1.setOnClickListener(local7);
    }
  }
  
  public boolean onQueryTextChange(String paramString)
  {
    return false;
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    Toast.makeText(this, paramString, 3000).show();
    Intent localIntent = new Intent(this, SearchBookResponse.class);
    localIntent.putExtra("credential_id", this.user_id);
    localIntent.putExtra("query", paramString);
    if (this.bundle.containsKey("source")) {
      localIntent.putExtra("guest", "myGuest");
    }
    startActivity(localIntent);
    return false;
  }
  
  class TaskGetNewsFeeds
    extends AsyncTask<Integer, Void, ArrayList<BookInfo>>
  {
    private final String URL = "http://books.knnect.com/user/library";
    private String response = "";
    
    TaskGetNewsFeeds() {}
    
    protected ArrayList<BookInfo> doInBackground(Integer... paramVarArgs)
    {
      for (;;)
      {
        try
        {
          JsonObject localJsonObject = new JsonObject();
          localJsonObject.addProperty("credential_id", paramVarArgs[0]);
          DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
          HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/library");
          localHttpPost.setEntity(new StringEntity(localJsonObject.toString()));
          localHttpPost.setHeader("Accept", "application/json");
          localHttpPost.setHeader("Content-type", "application/json");
          InputStream localInputStream = localDefaultHttpClient.execute(localHttpPost).getEntity().getContent();
          InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
          BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
          str1 = localBufferedReader.readLine();
          if (str1 != null) {
            continue;
          }
          localInputStream.close();
          Log.i("server output..........", this.response);
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          String str1;
          JsonArray localJsonArray;
          String str2;
          StringBuilder localStringBuilder;
          localClientProtocolException.printStackTrace();
          continue;
        }
        catch (IOException localIOException)
        {
          Gson localGson;
          ArrayList localArrayList;
          Iterator localIterator1;
          Iterator localIterator2;
          localIOException.printStackTrace();
          continue;
          localArrayList.add((BookInfo)localGson.fromJson((JsonElement)localIterator1.next(), BookInfo.class));
          continue;
          Log.i("list", ((BookInfo)localIterator2.next()).toString());
          continue;
        }
        localJsonArray = ((JsonObject)new JsonParser().parse(this.response)).get("library").getAsJsonArray();
        localGson = new Gson();
        localArrayList = new ArrayList();
        localIterator1 = localJsonArray.iterator();
        if (localIterator1.hasNext()) {
          continue;
        }
        localIterator2 = localArrayList.iterator();
        if (localIterator2.hasNext()) {
          continue;
        }
        return localArrayList;
        str2 = this.response;
        localStringBuilder = new StringBuilder(String.valueOf(str2));
        this.response = str1;
      }
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.MyLibrary
 * JD-Core Version:    0.7.0.1
 */