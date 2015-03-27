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

public class EditShoopBookList
  extends Activity
{
  Button button;
  EditText quantity;
  EditText title;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903061);
    final String str = Integer.toString(getIntent().getExtras().getInt("credential_id"));
    this.title = ((EditText)findViewById(2131361962));
    this.quantity = ((EditText)findViewById(2131361964));
    this.button = ((Button)findViewById(2131361965));
    this.button.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          String str1 = EditShoopBookList.this.title.getText().toString();
          String str2 = EditShoopBookList.this.quantity.getText().toString();
          TaskUpdateShopbookList localTaskUpdateShopbookList = new TaskUpdateShopbookList();
          String[] arrayOfString = new String[3];
          arrayOfString[0] = str;
          arrayOfString[1] = str1;
          arrayOfString[2] = str2;
          if (((Integer)localTaskUpdateShopbookList.execute(arrayOfString).get()).intValue() != -1)
          {
            new AlertDialog.Builder(EditShoopBookList.this).setTitle("Update message").setMessage("Booklist Successfully updated!").setNeutralButton("Ok", null).show();
            return;
          }
          new AlertDialog.Builder(EditShoopBookList.this).setTitle("Update message").setMessage("Error occured!").setNeutralButton("Ok", null).show();
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
 * Qualified Name:     com.booknetwork.app.EditShoopBookList
 * JD-Core Version:    0.7.0.1
 */