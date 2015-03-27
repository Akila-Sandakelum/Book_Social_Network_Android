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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity
  extends Activity
  implements View.OnClickListener
{
  static TextView res;
  EditText name;
  EditText password;
  Spinner spinner;
  
  public void onClick(View paramView)
  {
    String str1 = this.name.getText().toString();
    String str2 = this.password.getText().toString();
    if (str1.equals(""))
    {
      new AlertDialog.Builder(this).setTitle("No Username Detected").setMessage("Enter Username").setNeutralButton("Ok", null).show();
      return;
    }
    if (str2.equals(""))
    {
      new AlertDialog.Builder(this).setTitle("No Password Detected").setMessage("Enter Password").setNeutralButton("Ok", null).show();
      return;
    }
    for (;;)
    {
      int i;
      String str3;
      try
      {
        new String[2];
        String[] arrayOfString = (String[])new TaskGetLoginInfo().execute(new String[] { str1, str2 }).get();
        i = Integer.parseInt(arrayOfString[0]);
        str3 = arrayOfString[1];
        if (i == -1)
        {
          new AlertDialog.Builder(this).setTitle("Logging Failure").setMessage("Enter correct username or password").setNeutralButton("Ok", null).show();
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
        if (str3.equals("Basic User"))
        {
          Intent localIntent1 = new Intent(paramView.getContext(), Activity3.class);
          localIntent1.putExtra("userType", str3);
          localIntent1.putExtra("credential_id", i);
          startActivity(localIntent1);
          finish();
          Toast.makeText(this, "Hi " + str1 + " , id= " + i + ", user_type= " + str3 + " welcome to Book Circle ", 2000).show();
          Log.i("Login msg....", "Hi " + str1 + " , id= " + i + ", user_type= " + str3 + " welcome to Book Circle ");
          return;
        }
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        return;
      }
      Intent localIntent2 = new Intent(paramView.getContext(), School_Shop_Profile.class);
      localIntent2.putExtra("userType", str3);
      localIntent2.putExtra("credential_id", i);
      startActivity(localIntent2);
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903051);
    this.spinner = ((Spinner)findViewById(2131361901));
    ((Button)findViewById(2131361898)).setOnClickListener(this);
    this.name = ((EditText)findViewById(2131361896));
    this.password = ((EditText)findViewById(2131361897));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Basic User");
    localArrayList.add("School");
    localArrayList.add("Bookshop");
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 17367048, localArrayList);
    localArrayAdapter.setDropDownViewResource(17367049);
    this.spinner.setAdapter(localArrayAdapter);
    ((Button)findViewById(2131361902)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (MainActivity.this.spinner.getSelectedItem().toString() == "Basic User")
        {
          Intent localIntent1 = new Intent(paramAnonymousView.getContext(), User_Signup.class);
          localIntent1.putExtra("userType", MainActivity.this.spinner.getSelectedItem().toString());
          MainActivity.this.startActivityForResult(localIntent1, 0);
          return;
        }
        Toast.makeText(paramAnonymousView.getContext(), MainActivity.this.spinner.getSelectedItem().toString(), 2000).show();
        Intent localIntent2 = new Intent(paramAnonymousView.getContext(), School_Shop_Signup.class);
        localIntent2.putExtra("userType", MainActivity.this.spinner.getSelectedItem().toString());
        MainActivity.this.startActivity(localIntent2);
      }
    });
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.MainActivity
 * JD-Core Version:    0.7.0.1
 */