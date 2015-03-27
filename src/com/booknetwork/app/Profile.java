package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;

public class Profile
  extends Activity
{
  static int user_id;
  String[] value;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903070);
    user_id = getIntent().getExtras().getInt("credential_id");
    Bundle localBundle = getIntent().getExtras();
    Log.i("in User profile", user_id);
    getResources().getDrawable(2130837508).setAlpha(35);
    TextView localTextView1 = (TextView)findViewById(2131362000);
    TextView localTextView2 = (TextView)findViewById(2131361999);
    TextView localTextView3 = (TextView)findViewById(2131362002);
    TextView localTextView4 = (TextView)findViewById(2131362004);
    try
    {
      this.value = new String[5];
      TaskGetProfileInfo localTaskGetProfileInfo = new TaskGetProfileInfo();
      Integer[] arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(user_id);
      this.value = ((String[])localTaskGetProfileInfo.execute(arrayOfInteger).get());
      localTextView1.setText(this.value[0] + " " + this.value[1]);
      localTextView2.setText(this.value[3]);
      localTextView3.setText(this.value[2]);
      localTextView4.setText(this.value[4]);
      Button localButton = (Button)findViewById(2131362005);
      if (localBundle.containsKey("source")) {
        localButton.setVisibility(4);
      }
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(paramAnonymousView.getContext(), EditProfile.class);
          localIntent.putExtra("credential_id", Profile.user_id);
          Profile.this.startActivityForResult(localIntent, 0);
          Profile.this.finish();
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
 * Qualified Name:     com.booknetwork.app.Profile
 * JD-Core Version:    0.7.0.1
 */