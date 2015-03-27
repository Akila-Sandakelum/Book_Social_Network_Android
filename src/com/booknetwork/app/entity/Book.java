package com.booknetwork.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Book
{
  private String author;
  private Long book_id;
  private List<Category> categories = new ArrayList(0);
  private int categoryCurrent;
  private Inventory inventory;
  private String isbn;
  private String title;
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public Long getBook_id()
  {
    return this.book_id;
  }
  
  public List<Category> getCategories()
  {
    return this.categories;
  }
  
  public Inventory getInventory()
  {
    return this.inventory;
  }
  
  public String getIsbn()
  {
    return this.isbn;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getcategoryCurrent()
  {
    return this.categoryCurrent;
  }
  
  public void setAuthor(String paramString)
  {
    this.author = paramString;
  }
  
  public void setBook_id(Long paramLong)
  {
    this.book_id = paramLong;
  }
  
  public void setCategories(List<Category> paramList)
  {
    this.categories = paramList;
  }
  
  public void setInventory(Inventory paramInventory)
  {
    this.inventory = paramInventory;
  }
  
  public void setIsbn(String paramString)
  {
    this.isbn = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setcategoryCurrent(int paramInt)
  {
    this.categoryCurrent = paramInt;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Book
 * JD-Core Version:    0.7.0.1
 */