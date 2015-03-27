package com.booknetwork.app;

class FriendlistInfo
{
  String credential_id;
  String dob;
  String gender;
  String home_town;
  String name;
  
  public String getCredential_id()
  {
    return this.credential_id;
  }
  
  public String getDob()
  {
    return this.dob;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public String getHomeTown()
  {
    return this.home_town;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setCredential_id(String paramString)
  {
    this.credential_id = paramString;
  }
  
  public void setDob(String paramString)
  {
    this.dob = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setHomeTown(String paramString)
  {
    this.home_town = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return "FriendlistInfo [name=" + this.name + ", home_town=" + this.home_town + ", dob=" + this.dob + ", gender=" + this.gender + ", credential_id=" + this.credential_id + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.FriendlistInfo
 * JD-Core Version:    0.7.0.1
 */