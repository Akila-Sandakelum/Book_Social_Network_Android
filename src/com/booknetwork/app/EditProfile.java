package com.booknetwork.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.concurrent.ExecutionException;

public class EditProfile
  extends Activity
{
  static int userid;
  EditText confpassET;
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
    setContentView(2130903048);
    userid = getIntent().getExtras().getInt("credential_id");
    final String str = Integer.toString(userid);
    this.userET = ((EditText)findViewById(2131361869));
    this.firstnameET = ((EditText)findViewById(2131361875));
    this.secodnameET = ((EditText)findViewById(2131361877));
    this.passwordET = ((EditText)findViewById(2131361871));
    this.confpassET = ((EditText)findViewById(2131361873));
    this.locationET = ((EditText)findViewById(2131361879));
    this.dobET = ((EditText)findViewById(2131361885));
    this.sexET = ((RadioGroup)findViewById(2131361881));
    ((Button)findViewById(2131361886)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = EditProfile.this.sexET.getCheckedRadioButtonId();
        EditProfile.this.genderRd = ((RadioButton)EditProfile.this.findViewById(i));
        EditProfile.this.gender = EditProfile.this.genderRd.getText().toString();
        String str1 = EditProfile.this.userET.getText().toString();
        String str2 = EditProfile.this.firstnameET.getText().toString();
        String str3 = EditProfile.this.secodnameET.getText().toString();
        String str4 = EditProfile.this.passwordET.getText().toString();
        String str5 = EditProfile.this.locationET.getText().toString();
        String str6 = EditProfile.this.dobET.getText().toString();
        try
        {
          TaskUpdateUserprof localTaskUpdateUserprof = new TaskUpdateUserprof();
          String[] arrayOfString = new String[8];
          arrayOfString[0] = str1;
          arrayOfString[1] = str2;
          arrayOfString[2] = str3;
          arrayOfString[3] = str4;
          arrayOfString[4] = str5;
          arrayOfString[5] = str6;
          arrayOfString[6] = EditProfile.this.gender;
          arrayOfString[7] = str;
          final int j = ((Integer)localTaskUpdateUserprof.execute(arrayOfString).get()).intValue();
          if (j != -1)
          {
            new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update message").setMessage("Profile successfully updated!").setNeutralButton("OK", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                Intent localIntent = new Intent(EditProfile.this, Activity3.class);
                localIntent.putExtra("credential_id", j);
                localIntent.putExtra("userType", "Basic User");
                localIntent.addFlags(67108864);
                EditProfile.this.startActivity(localIntent);
              }
            }).show();
            return;
          }
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Signup Failure").setMessage("Username already exists!").setNeutralButton("OK", null).show();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
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
 * Qualified Name:     com.booknetwork.app.EditProfile
 * JD-Core Version:    0.7.0.1
 */