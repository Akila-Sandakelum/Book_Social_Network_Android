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

public class Edit_wishlist
  extends Activity
{
  EditText authorEt;
  EditText titleEt;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903049);
    final int i = getIntent().getExtras().getInt("credential_id");
    final String str = Integer.toString(i);
    this.titleEt = ((EditText)findViewById(2131361889));
    this.authorEt = ((EditText)findViewById(2131361891));
    ((Button)findViewById(2131361892)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = Edit_wishlist.this.titleEt.getText().toString();
        String str2 = Edit_wishlist.this.authorEt.getText().toString();
        try
        {
          TaskAddWishlistinfo localTaskAddWishlistinfo = new TaskAddWishlistinfo();
          String[] arrayOfString = new String[3];
          arrayOfString[0] = str1;
          arrayOfString[1] = str2;
          arrayOfString[2] = str;
          if (((Integer)localTaskAddWishlistinfo.execute(arrayOfString).get()).intValue() == 1) {
            new AlertDialog.Builder(Edit_wishlist.this).setTitle("Update message").setMessage("Wishlist Successfully updated!").setNeutralButton("Ok", null).show();
          }
          for (;;)
          {
            Intent localIntent = new Intent(paramAnonymousView.getContext(), Wishlist.class);
            localIntent.putExtra("credential_id", i);
            Edit_wishlist.this.startActivityForResult(localIntent, 0);
            return;
            new AlertDialog.Builder(Edit_wishlist.this).setTitle("Update message").setMessage("Update failed!").setNeutralButton("Ok", null).show();
          }
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
    });
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.Edit_wishlist
 * JD-Core Version:    0.7.0.1
 */