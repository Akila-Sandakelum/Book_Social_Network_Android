package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Activity3
  extends Activity
{
  static int user_id;
  static String user_type;
  private String source;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    Button localButton1 = (Button)findViewById(2131361828);
    Button localButton2 = (Button)findViewById(2131361827);
    Button localButton3 = (Button)findViewById(2131361824);
    Button localButton4 = (Button)findViewById(2131361825);
    Button localButton5 = (Button)findViewById(2131361823);
    Button localButton6 = (Button)findViewById(2131361826);
    this.source = getIntent().getExtras().getString("source");
    user_id = getIntent().getExtras().getInt("credential_id");
    user_type = getIntent().getExtras().getString("userType");
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Activity3.user_id = Activity3.this.getIntent().getExtras().getInt("credential_id");
        Activity3.user_type = Activity3.this.getIntent().getExtras().getString("userType");
        Log.i("inputs....", Activity3.user_id + " " + Activity3.user_type);
        Toast.makeText(paramAnonymousView.getContext(), Activity3.user_type, 2000).show();
        if (Activity3.user_type.equals("Basic User"))
        {
          Intent localIntent1 = new Intent(paramAnonymousView.getContext(), Profile.class);
          localIntent1.putExtra("credential_id", Activity3.user_id);
          Activity3.this.startActivityForResult(localIntent1, 0);
          return;
        }
        Intent localIntent2 = new Intent(paramAnonymousView.getContext(), School_Shop_Profile.class);
        localIntent2.putExtra("credential_id", Activity3.user_id);
        localIntent2.putExtra("userType", Activity3.user_type);
        Activity3.this.startActivityForResult(localIntent2, 0);
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), MyLibrary.class);
        localIntent.putExtra("credential_id", Activity3.user_id);
        Activity3.this.startActivityForResult(localIntent, 0);
      }
    });
    localButton4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), Friendlist.class);
        Activity3.this.startActivityForResult(localIntent, 0);
      }
    });
    localButton3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), Bookstores.class);
        Activity3.this.startActivityForResult(localIntent, 0);
      }
    });
    localButton5.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), Schools.class);
        Activity3.this.startActivityForResult(localIntent, 0);
      }
    });
    localButton6.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), Wishlist.class);
        localIntent.putExtra("credential_id", Activity3.user_id);
        Activity3.this.startActivityForResult(localIntent, 0);
      }
    });
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.Activity3
 * JD-Core Version:    0.7.0.1
 */