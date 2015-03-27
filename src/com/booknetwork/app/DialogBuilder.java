package com.booknetwork.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class DialogBuilder
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
    Bundle localBundle = getIntent().getExtras();
    String str1 = getIntent().getExtras().get("title").toString();
    String str2 = getIntent().getExtras().get("author").toString();
    String str3 = getIntent().getExtras().get("rating").toString();
    final String str4 = getIntent().getExtras().get("interest_id").toString();
    final String str5 = Integer.toString(getIntent().getExtras().getInt("credential_id"));
    Float localFloat = Float.valueOf(str3);
    TextView localTextView1 = (TextView)findViewById(2131361846);
    TextView localTextView2 = (TextView)findViewById(2131361844);
    RatingBar localRatingBar = (RatingBar)findViewById(2131361848);
    Button localButton = (Button)findViewById(2131361849);
    localTextView2.setText(str1);
    localTextView1.setText(str2);
    localRatingBar.setRating(localFloat.floatValue());
    if (!localBundle.containsKey("guest"))
    {
      localButton.setVisibility(4);
      return;
    }
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          DialogBuilder.LoadBooKDetails localLoadBooKDetails = new DialogBuilder.LoadBooKDetails(DialogBuilder.this);
          String[] arrayOfString = new String[2];
          arrayOfString[0] = str4;
          arrayOfString[1] = str5;
          if (((Integer)localLoadBooKDetails.execute(arrayOfString).get()).intValue() == 1) {
            new AlertDialog.Builder(DialogBuilder.this).setTitle("Update message").setMessage("Successfully added to My Wishlist!").setNeutralButton("OK", null).show();
          }
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
  
  class LoadBooKDetails
    extends AsyncTask<String, Void, Integer>
  {
    final String URL = "http://books.knnect.com/user/friendlist/library/addtowishlist";
    int output;
    String response = "";
    
    LoadBooKDetails() {}
    
    protected Integer doInBackground(String... paramVarArgs)
    {
      for (;;)
      {
        try
        {
          JsonObject localJsonObject = new JsonObject();
          localJsonObject.addProperty("interest_id", paramVarArgs[0]);
          localJsonObject.addProperty("credential_id", paramVarArgs[1]);
          Log.i("output..........", localJsonObject.toString());
          DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
          HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/friendlist/library/addtowishlist");
          localHttpPost.setEntity(new StringEntity(localJsonObject.toString()));
          localHttpPost.setHeader("Accept", "application/json");
          localHttpPost.setHeader("Content-type", "application/json");
          HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
          Log.i("output..........", localJsonObject.toString());
          InputStream localInputStream = localHttpResponse.getEntity().getContent();
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
          str = localBufferedReader.readLine();
          if (str != null) {
            continue;
          }
          Log.i("server output..........", this.response);
          localInputStream.close();
          this.output = ((JsonObject)new JsonParser().parse(this.response)).get("result").getAsInt();
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          String str;
          localClientProtocolException.printStackTrace();
          continue;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          continue;
        }
        return Integer.valueOf(this.output);
        this.response += str;
      }
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.DialogBuilder
 * JD-Core Version:    0.7.0.1
 */