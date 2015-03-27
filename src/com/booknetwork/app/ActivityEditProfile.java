package com.booknetwork.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import com.example.test.entity.Profile;

public class ActivityEditProfile
  extends Activity
{
  private String dob;
  private String firstName;
  private boolean isFemale;
  private boolean isMale;
  private String location;
  private String name;
  private String password;
  private Profile profile;
  private String secondName;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    this.name = ((EditText)findViewById(2131361869)).getText().toString();
    this.firstName = ((EditText)findViewById(2131361875)).getText().toString();
    EditText localEditText = (EditText)findViewById(2131361877);
    this.secondName = localEditText.getText().toString();
    ((EditText)findViewById(2131361879));
    this.location = localEditText.getText().toString();
    ((EditText)findViewById(2131361871));
    this.password = localEditText.getText().toString();
    this.dob = ((EditText)findViewById(2131361885)).getText().toString();
    this.profile = new Profile();
    this.profile.setFirstName(this.firstName);
    this.profile.setLastName(this.secondName);
    this.profile.setLocation(this.location);
    this.profile.setPassword(this.password);
    this.profile.setUsername(this.name);
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.ActivityEditProfile
 * JD-Core Version:    0.7.0.1
 */