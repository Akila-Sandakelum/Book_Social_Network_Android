package com.booknetwork.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Bookshop
{
  private Long bookshop_id;
  private List<Inventory> inventories = new ArrayList(0);
  private Profile profile;
  
  public Long getBookshop_id()
  {
    return this.bookshop_id;
  }
  
  public List<Inventory> getInventories()
  {
    return this.inventories;
  }
  
  public Profile getProfile()
  {
    return this.profile;
  }
  
  public void setBookshop_id(Long paramLong)
  {
    this.bookshop_id = paramLong;
  }
  
  public void setInventories(List<Inventory> paramList)
  {
    this.inventories = paramList;
  }
  
  public void setProfile(Profile paramProfile)
  {
    this.profile = paramProfile;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Bookshop
 * JD-Core Version:    0.7.0.1
 */