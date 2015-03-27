package com.booknetwork.app.entity;

public class FriendlistRawItm
{
  private String credential_id;
  private String home_town;
  private int imageId;
  private String name;
  
  public FriendlistRawItm(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.home_town = paramString2;
    this.imageId = paramInt;
    this.credential_id = paramString3;
  }
  
  public String getCredential_id()
  {
    return this.credential_id;
  }
  
  public String getHome_town()
  {
    return this.home_town;
  }
  
  public int getImageId()
  {
    return this.imageId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setCredential_id(String paramString)
  {
    this.credential_id = paramString;
  }
  
  public void setHome_town(String paramString)
  {
    this.home_town = paramString;
  }
  
  public void setImageId(int paramInt)
  {
    this.imageId = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return "FriendlistRawItm [name=" + this.name + ", home_town=" + this.home_town + ", imageId=" + this.imageId + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.FriendlistRawItm
 * JD-Core Version:    0.7.0.1
 */