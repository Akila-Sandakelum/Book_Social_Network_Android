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
import android.widget.TextView;
import java.util.concurrent.ExecutionException;

public class EditSchool_Shop_Profile
  extends Activity
{
  EditText confpassET;
  EditText locationET;
  EditText nameET;
  EditText passET;
  EditText usernameET;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    final String str1 = Integer.toString(getIntent().getExtras().getInt("credential_id"));
    final String str2 = getIntent().getExtras().getString("userType");
    TextView localTextView = (TextView)findViewById(2131361811);
    localTextView.setText("Edit Profile");
    localTextView.setTextSize(25.0F);
    Button localButton = (Button)findViewById(2131361822);
    localButton.setText("Update");
    this.usernameET = ((EditText)findViewById(2131361813));
    this.passET = ((EditText)findViewById(2131361815));
    this.confpassET = ((EditText)findViewById(2131361817));
    this.nameET = ((EditText)findViewById(2131361819));
    this.locationET = ((EditText)findViewById(2131361821));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = EditSchool_Shop_Profile.this.usernameET.getText().toString();
        String str2 = EditSchool_Shop_Profile.this.passET.getText().toString();
        String str3 = EditSchool_Shop_Profile.this.confpassET.getText().toString();
        String str4 = EditSchool_Shop_Profile.this.nameET.getText().toString();
        String str5 = EditSchool_Shop_Profile.this.locationET.getText().toString();
        if (!str2.equals(str3))
        {
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Password mismatch!").setNeutralButton("OK", null).show();
          return;
        }
        if ((!str2.equals("")) && (str2.length() < 2))
        {
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Password is too short!").setNeutralButton("OK", null).show();
          return;
        }
        try
        {
          TaskGetProfSchoolShopInfo localTaskGetProfSchoolShopInfo = new TaskGetProfSchoolShopInfo();
          String[] arrayOfString = new String[6];
          arrayOfString[0] = str1;
          arrayOfString[1] = str2;
          arrayOfString[2] = str4;
          arrayOfString[3] = str5;
          arrayOfString[4] = str1;
          arrayOfString[5] = str2;
          int i = ((Integer)localTaskGetProfSchoolShopInfo.execute(arrayOfString).get()).intValue();
          if (i != -1)
          {
            new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update message").setMessage("Profile successfully updated!").setNeutralButton("OK", null).show();
            Intent localIntent = new Intent(paramAnonymousView.getContext(), School_Shop_Profile.class);
            localIntent.putExtra("credential_id", i);
            localIntent.putExtra("userType", str2);
            EditSchool_Shop_Profile.this.startActivity(localIntent);
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          return;
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Username already exists!").setNeutralButton("OK", null).show();
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
 * Qualified Name:     com.booknetwork.app.EditSchool_Shop_Profile
 * JD-Core Version:    0.7.0.1
 */