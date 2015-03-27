package com.booknetwork.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Edit_library
  extends Activity
{
  private String author;
  private EditText authorET;
  private Button button;
  private String category;
  private String isbn;
  private EditText isbnET;
  private String rate;
  private RatingBar ratingbar;
  private Spinner spinner;
  private EditText tit;
  private String title;
  private String[] values = new String[4];
  
  public void addListenerOnSpinnerItemSelection()
  {
    this.spinner = ((Spinner)findViewById(2131361862));
    this.spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    final int i = getIntent().getExtras().getInt("credential_id");
    this.spinner = ((Spinner)findViewById(2131361862));
    this.ratingbar = ((RatingBar)findViewById(2131361864));
    this.authorET = ((EditText)findViewById(2131361858));
    this.tit = ((EditText)findViewById(2131361856));
    this.button = ((Button)findViewById(2131361865));
    this.isbnET = ((EditText)findViewById(2131361859));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Children's");
    localArrayList.add("Religion");
    localArrayList.add("Education");
    localArrayList.add("Fiction");
    localArrayList.add("Sports");
    localArrayList.add("Other");
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 17367048, localArrayList);
    localArrayAdapter.setDropDownViewResource(17367049);
    this.spinner.setAdapter(localArrayAdapter);
    addListenerOnSpinnerItemSelection();
    this.button.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = Integer.toString(i);
        Edit_library.this.title = Edit_library.this.tit.getText().toString();
        Edit_library.this.author = Edit_library.this.authorET.getText().toString();
        Edit_library.this.rate = String.valueOf(Edit_library.this.ratingbar.getRating());
        Edit_library.this.category = Edit_library.this.spinner.getSelectedItem().toString();
        Edit_library.this.isbn = Edit_library.this.isbnET.getText().toString();
        if ((Edit_library.this.title.equals("")) || (Edit_library.this.author.equals("")) || (Edit_library.this.rate.equals("")) || (Edit_library.this.category.equals("")) || (Edit_library.this.isbn.equals("")))
        {
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update message").setMessage("Complete all the fields!").setNeutralButton("OK", null).show();
          return;
        }
        if (Edit_library.this.isbn.length() != 13)
        {
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update message").setMessage("Enter a vallid isbn with 13 digits!").setNeutralButton("OK", null).show();
          return;
        }
        try
        {
          TaskSendBookInfo localTaskSendBookInfo = new TaskSendBookInfo();
          String[] arrayOfString = new String[6];
          arrayOfString[0] = Edit_library.this.title;
          arrayOfString[1] = Edit_library.this.author;
          arrayOfString[2] = Edit_library.this.isbn;
          arrayOfString[3] = Edit_library.this.category;
          arrayOfString[4] = Edit_library.this.rate;
          arrayOfString[5] = str;
          if (((String)localTaskSendBookInfo.execute(arrayOfString).get()).equals("true"))
          {
            new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update message").setMessage("My Library successfully updated!").setNeutralButton("OK", null).show();
            Intent localIntent = new Intent(paramAnonymousView.getContext(), Activity3.class);
            localIntent.addFlags(67108864);
            localIntent.putExtra("credential_id", str);
            Edit_library.this.startActivity(localIntent);
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          return;
          new AlertDialog.Builder(paramAnonymousView.getContext()).setTitle("Update message").setMessage("My Library successfully updated!").setNeutralButton("OK", null).show();
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
 * Qualified Name:     com.booknetwork.app.Edit_library
 * JD-Core Version:    0.7.0.1
 */