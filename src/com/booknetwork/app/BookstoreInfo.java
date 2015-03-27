package com.booknetwork.app;

class BookstoreInfo
{
  private int id;
  private String location;
  private String name;
  
  public BookstoreInfo(String paramString1, String paramString2, int paramInt)
  {
    this.name = paramString1;
    this.location = paramString2;
    this.id = paramInt;
  }
  
  public int getId()
  {
    return this.id;
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
    return "BookstoreInfo [name=" + this.name + ", location=" + this.location + ", id=" + this.id + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.BookstoreInfo
 * JD-Core Version:    0.7.0.1
 */