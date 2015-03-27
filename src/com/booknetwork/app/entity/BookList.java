package com.booknetwork.app.entity;

import java.util.ArrayList;
import java.util.List;

public class BookList
{
  private Long book_list_id;
  private List<Inventory> inventories = new ArrayList(0);
  
  public Long getBook_list_id()
  {
    return this.book_list_id;
  }
  
  public List<Inventory> getInventories()
  {
    return this.inventories;
  }
  
  public void setBook_list_id(Long paramLong)
  {
    this.book_list_id = paramLong;
  }
  
  public void setInventories(List<Inventory> paramList)
  {
    this.inventories = paramList;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.BookList
 * JD-Core Version:    0.7.0.1
 */