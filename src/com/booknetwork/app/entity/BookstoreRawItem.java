package com.booknetwork.app.entity;

public class BookstoreRawItem
{
  private int id;
  private int imageId;
  private String location;
  private String name;
  
  public BookstoreRawItem(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.location = paramString2;
    this.imageId = paramInt1;
    this.id = paramInt2;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getImageId()
  {
    return this.imageId;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageId(int paramInt)
  {
    this.imageId = paramInt;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return "BookstoreRawItem [name=" + this.name + ", location=" + this.location + ", imageId=" + this.imageId + ", id=" + this.id + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.BookstoreRawItem
 * JD-Core Version:    0.7.0.1
 */