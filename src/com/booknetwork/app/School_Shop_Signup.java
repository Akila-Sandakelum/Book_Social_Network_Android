package com.booknetwork.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.concurrent.ExecutionException;

public class School_Shop_Signup
  extends Activity
{
  EditText confpassET;
  EditText locationET;
  EditText nameET;
  EditText passET;
  EditText userET;
  String user_type;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.user_type = getIntent().getExtras().get("userType").toString();
    this.userET = ((EditText)findViewById(2131361813));
    this.nameET = ((EditText)findViewById(2131361819));
    this.passET = ((EditText)findViewById(2131361815));
    this.confpassET = ((EditText)findViewById(2131361817));
    this.locationET = ((EditText)findViewById(2131361821));
    ((Button)findViewById(2131361822)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = School_Shop_Signup.this.userET.getText().toString();
        String str2 = School_Shop_Signup.this.nameET.getText().toString();
        String str3 = School_Shop_Signup.this.passET.getText().toString();
        String str4 = School_Shop_Signup.this.confpassET.getText().toString();
        String str5 = School_Shop_Signup.this.locationET.getText().toString();
        if ((str1.equals("")) || (str2.equals("")) || (str3.equals("")) || (str5.equals(""))) {
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Please complete the full form").setNeutralButton("OK", null).show();
        }
        for (;;)
        {
          return;
          if (!str3.equals(str4))
          {
            new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Password mismatch!").setNeutralButton("OK", null).show();
            return;
          }
          if (str3.length() < 2)
          {
            new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Password is too short!").setNeutralButton("OK", null).show();
            return;
          }
          try
          {
            TaskSignupSchoolShop localTaskSignupSchoolShop = new TaskSignupSchoolShop();
            String[] arrayOfString = new String[5];
            arrayOfString[0] = School_Shop_Signup.this.user_type;
            arrayOfString[1] = str1;
            arrayOfString[2] = str2;
            arrayOfString[3] = str3;
            arrayOfString[4] = str5;
            i = ((Integer)localTaskSignupSchoolShop.execute(arrayOfString).get()).intValue();
            if (i != -1)
            {
              Intent localIntent = new Intent(paramAnonymousView.getContext(), School_Shop_Profile.class);
              localIntent.putExtra("credential_id", i);
              localIntent.putExtra("userType", School_Shop_Signup.this.user_type);
              School_Shop_Signup.this.startActivity(localIntent);
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            int i;
            localInterruptedException.printStackTrace();
            return;
            if (i == -1)
            {
              new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Username already exists!").setNeutralButton("OK", null).show();
              return;
            }
          }
          catch (ExecutionException localExecutionException)
          {
            localExecutionException.printStackTrace();
          }
        }
      }
    });
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.School_Shop_Signup
 * JD-Core Version:    0.7.0.1
 */