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

class TaskSendBookInfo
  extends AsyncTask<String, Void, String>
{
  final String URL = "http://books.knnect.com/user/library/add";
  String response = "";
  String result;
  
  protected String doInBackground(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("title", paramVarArgs[0]);
        localJsonObject.addProperty("author", paramVarArgs[1]);
        localJsonObject.addProperty("isbn", paramVarArgs[2]);
        localJsonObject.addProperty("category", paramVarArgs[3]);
        localJsonObject.addProperty("rating", paramVarArgs[4]);
        localJsonObject.addProperty("credential_id", paramVarArgs[5]);
        Log.i("output..........", localJsonObject.toString());
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/library/add");
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
        Log.i("profile server output..........", this.response);
        localInputStream.close();
        this.result = ((JsonObject)new JsonParser().parse(this.response)).get("credential_id").getAsString();
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
      catch (Exception localException)
      {
        continue;
      }
      return this.result;
      this.response += str;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskSendBookInfo
 * JD-Core Version:    0.7.0.1
 */