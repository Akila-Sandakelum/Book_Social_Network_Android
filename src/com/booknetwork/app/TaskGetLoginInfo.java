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

class TaskGetLoginInfo
  extends AsyncTask<String, Void, String[]>
{
  final String URL = "http://books.knnect.com/user/login";
  String[] output;
  String response = "";
  
  protected String[] doInBackground(String... paramVarArgs)
  {
    Log.i("user..........", paramVarArgs[0] + "  pass " + paramVarArgs[1]);
    for (;;)
    {
      try
      {
        JsonObject localJsonObject1 = new JsonObject();
        localJsonObject1.addProperty("username", paramVarArgs[0]);
        localJsonObject1.addProperty("password", paramVarArgs[1]);
        Log.i("output..........", localJsonObject1.toString());
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/login");
        localHttpPost.setEntity(new StringEntity(localJsonObject1.toString()));
        localHttpPost.setHeader("Accept", "application/json");
        localHttpPost.setHeader("Content-type", "application/json");
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        Log.i("output..........", localJsonObject1.toString());
        InputStream localInputStream = localHttpResponse.getEntity().getContent();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
        str = localBufferedReader.readLine();
        if (str != null) {
          continue;
        }
        Log.i("server output..........", this.response);
        localInputStream.close();
        JsonObject localJsonObject2 = (JsonObject)new JsonParser().parse(this.response);
        JsonElement localJsonElement1 = localJsonObject2.get("credential_id");
        localJsonElement2 = localJsonObject2.get("user_type");
        this.output = new String[2];
        this.output[0] = localJsonElement1.getAsString();
        if (!this.output[0].equals("-1")) {
          continue;
        }
        this.output[1] = "";
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        String str;
        JsonElement localJsonElement2;
        localClientProtocolException.printStackTrace();
        continue;
        this.output[1] = localJsonElement2.getAsString();
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      return this.output;
      this.response += str;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskGetLoginInfo
 * JD-Core Version:    0.7.0.1
 */