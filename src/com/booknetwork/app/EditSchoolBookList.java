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

public class EditSchoolBookList
  extends Activity
{
  EditText author;
  Button button;
  EditText title;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903059);
    final String str = Integer.toString(getIntent().getExtras().getInt("credential_id"));
    this.title = ((EditText)findViewById(2131361951));
    this.author = ((EditText)findViewById(2131361954));
    this.button = ((Button)findViewById(2131361955));
    this.button.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = EditSchoolBookList.this.title.getText().toString();
        String str2 = EditSchoolBookList.this.author.getText().toString();
        try
        {
          TaskUpdateSchoolBooklist localTaskUpdateSchoolBooklist = new TaskUpdateSchoolBooklist();
          String[] arrayOfString = new String[3];
          arrayOfString[0] = str;
          arrayOfString[1] = str1;
          arrayOfString[2] = str2;
          if (((Integer)localTaskUpdateSchoolBooklist.execute(arrayOfString).get()).intValue() != -1)
          {
            new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update Message!").setMessage("Successfully updated!").setNeutralButton("Ok", null).show();
            return;
          }
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update Message!").setMessage("Update failed!").setNeutralButton("Ok", null).show();
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
 * Qualified Name:     com.booknetwork.app.EditSchoolBookList
 * JD-Core Version:    0.7.0.1
 */