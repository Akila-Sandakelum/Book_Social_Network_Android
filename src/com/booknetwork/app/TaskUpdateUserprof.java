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

class TaskUpdateUserprof
  extends AsyncTask<String, Void, Integer>
{
  final String URL = "http://books.knnect.com/user/update";
  int output;
  String response = "";
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    Log.i("input", paramVarArgs[0] + " " + paramVarArgs[1] + " " + paramVarArgs[2] + " " + paramVarArgs[3] + " " + paramVarArgs[4] + " " + paramVarArgs[5] + " " + paramVarArgs[6]);
    for (;;)
    {
      try
      {
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("username", paramVarArgs[0]);
        localJsonObject.addProperty("firstname", paramVarArgs[1]);
        localJsonObject.addProperty("secondname", paramVarArgs[2]);
        localJsonObject.addProperty("password", paramVarArgs[3]);
        localJsonObject.addProperty("location", paramVarArgs[4]);
        localJsonObject.addProperty("dob", paramVarArgs[5]);
        localJsonObject.addProperty("gender", paramVarArgs[6]);
        localJsonObject.addProperty("credential_id", paramVarArgs[7]);
        Log.i("output..........", localJsonObject.toString());
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/update");
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
      catch (Exception localException)
      {
        continue;
      }
      return Integer.valueOf(this.output);
      this.response += str;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskUpdateUserprof
 * JD-Core Version:    0.7.0.1
 */