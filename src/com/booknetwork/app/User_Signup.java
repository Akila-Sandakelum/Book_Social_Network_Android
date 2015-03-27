package com.booknetwork.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.concurrent.ExecutionException;

public class User_Signup
  extends Activity
{
  EditText dobET;
  EditText firstnameET;
  String gender;
  RadioButton genderRd;
  EditText locationET;
  EditText passwordET;
  EditText secodnameET;
  RadioGroup sexET;
  EditText userET;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903071);
    this.userET = ((EditText)findViewById(2131362009));
    this.firstnameET = ((EditText)findViewById(2131362011));
    this.secodnameET = ((EditText)findViewById(2131362013));
    this.passwordET = ((EditText)findViewById(2131362015));
    this.locationET = ((EditText)findViewById(2131362017));
    this.dobET = ((EditText)findViewById(2131362021));
    this.sexET = ((RadioGroup)findViewById(2131362019));
    this.genderRd = ((RadioButton)findViewById(this.sexET.getCheckedRadioButtonId()));
    this.gender = this.genderRd.getText().toString();
    ((Button)findViewById(2131362022)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = User_Signup.this.userET.getText().toString();
        String str2 = User_Signup.this.firstnameET.getText().toString();
        String str3 = User_Signup.this.secodnameET.getText().toString();
        String str4 = User_Signup.this.passwordET.getText().toString();
        String str5 = User_Signup.this.locationET.getText().toString();
        String str6 = User_Signup.this.dobET.getText().toString();
        if ((str1.equals("")) || (str2.equals("")) || (str3.equals("")) || (str4.equals("")) || (str5.equals("")) || (str6.equals("")) || (User_Signup.this.gender.equals("")))
        {
          new AlertDialog.Builder(User_Signup.this).setTitle("Signup Failure").setMessage("Please complete the full form").setNeutralButton("Ok", null).show();
          return;
        }
        if (str4.length() < 2)
        {
          new AlertDialog.Builder(User_Signup.this).setTitle("Signup Failure").setMessage("Password is too short!").setNeutralButton("Ok", null).show();
          return;
        }
        try
        {
          TaskUserSignup localTaskUserSignup = new TaskUserSignup();
          String[] arrayOfString = new String[7];
          arrayOfString[0] = str1;
          arrayOfString[1] = str2;
          arrayOfString[2] = str3;
          arrayOfString[3] = str4;
          arrayOfString[4] = str5;
          arrayOfString[5] = str6;
          arrayOfString[6] = User_Signup.this.gender;
          int i = ((Integer)localTaskUserSignup.execute(arrayOfString).get()).intValue();
          Log.i("result id", i);
          if (i != -1)
          {
            Intent localIntent = new Intent(User_Signup.this, Activity3.class);
            localIntent.putExtra("credential_id", i);
            localIntent.putExtra("userType", "Basic User");
            User_Signup.this.startActivity(localIntent);
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          return;
          new AlertDialog.Builder(User_Signup.this).setTitle("Signup Failure").setMessage("Username already exists!").setNeutralButton("Ok", null).show();
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          localExecutionException.printStackTrace();
        }
      }
    });
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.User_Signup
 * JD-Core Version:    0.7.0.1
 */