package com.booknetwork.app;

class BooklistInfo
{
  private String quantity;
  private String title;
  
  public String getQuantity()
  {
    return this.quantity;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setQuantity(String paramString)
  {
    this.quantity = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "BooklistInfo [title=" + this.title + ", quantity=" + this.quantity + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.BooklistInfo
 * JD-Core Version:    0.7.0.1
 */