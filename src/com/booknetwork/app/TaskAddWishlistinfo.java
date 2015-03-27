package com.booknetwork.app;

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

class TaskAddWishlistinfo
  extends AsyncTask<String, Void, Integer>
{
  final String URL = "http://books.knnect.com/user/wishlist/add";
  int output;
  String response = "";
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("title", paramVarArgs[0]);
        localJsonObject.addProperty("author", paramVarArgs[1]);
        localJsonObject.addProperty("credential_id", paramVarArgs[2]);
        Log.i("output..........", localJsonObject.toString());
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/wishlist/add");
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
        this.output = ((JsonObject)new JsonParser().parse(this.response)).get("credential_id").getAsInt();
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


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskAddWishlistinfo
 * JD-Core Version:    0.7.0.1
 */