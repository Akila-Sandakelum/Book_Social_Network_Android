package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;

public class School_Shop_Profile
  extends Activity
{
  static String userType;
  static int userid;
  String[] result;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903065);
    userType = getIntent().getExtras().getString("userType");
    userid = getIntent().getExtras().getInt("credential_id");
    String str = Integer.toString(userid);
    TextView localTextView1 = (TextView)findViewById(2131361980);
    TextView localTextView2 = (TextView)findViewById(2131361982);
    Button localButton1 = (Button)findViewById(2131361983);
    Button localButton2 = (Button)findViewById(2131361984);
    getResources().getDrawable(2130837509).setAlpha(50);
    try
    {
      this.result = new String[2];
      TaskGetSchool_Shop_Profinfo localTaskGetSchool_Shop_Profinfo = new TaskGetSchool_Shop_Profinfo();
      String[] arrayOfString = new String[2];
      arrayOfString[0] = str;
      arrayOfString[1] = userType;
      this.result = ((String[])localTaskGetSchool_Shop_Profinfo.execute(arrayOfString).get());
      localTextView1.setText(this.result[0]);
      localTextView2.setText(this.result[1]);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), EditSchool_Shop_Profile.class);
          localIntent.putExtra("credential_id", School_Shop_Profile.userid);
          localIntent.putExtra("userType", School_Shop_Profile.userType);
          School_Shop_Profile.this.startActivity(localIntent);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (School_Shop_Profile.userType.equals("School"))
          {
            Intent localIntent1 = new Intent(paramAnonymousView.getContext(), SchoolBookLIst.class);
            localIntent1.putExtra("credential_id", School_Shop_Profile.userid);
            School_Shop_Profile.this.startActivity(localIntent1);
            return;
          }
          Intent localIntent2 = new Intent(paramAnonymousView.getContext(), ShopBookList.class);
          localIntent2.putExtra("credential_id", School_Shop_Profile.userid);
          School_Shop_Profile.this.startActivity(localIntent2);
        }
      });
      return;
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
        localExecutionException.printStackTrace();
      }
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.School_Shop_Profile
 * JD-Core Version:    0.7.0.1
 */