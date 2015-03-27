package com.booknetwork.app.adapters;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class TaskDeleteWishlist
  extends AsyncTask<String, Void, Integer>
{
  private final String URL = "http://books.knnect.com/user/wishlist/delete";
  private String response = "";
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("interest_id", paramVarArgs[0]);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/wishlist/delete");
        localHttpPost.setEntity(new StringEntity(localJsonObject.toString()));
        localHttpPost.setHeader("Accept", "application/json");
        localHttpPost.setHeader("Content-type", "application/json");
        InputStream localInputStream = localDefaultHttpClient.execute(localHttpPost).getEntity().getContent();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
        str = localBufferedReader.readLine();
        if (str != null) {
          continue;
        }
        localInputStream.close();
        Log.i("server output..........", this.response);
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
      return Integer.valueOf(((JsonObject)new JsonParser().parse(this.response)).get("delete").getAsInt());
      this.response += str;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.adapters.TaskDeleteWishlist
 * JD-Core Version:    0.7.0.1
 */