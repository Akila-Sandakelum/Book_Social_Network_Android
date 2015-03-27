package com.booknetwork.app.entity;

import java.io.Serializable;

public class Profile
  implements Serializable
{
  private String firstName;
  private Long id;
  private String lastName;
  private String location;
  private String password;
  private String username;
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public String getLastName()
  {
    return this.lastName;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setFirstName(String paramString)
  {
    this.firstName = paramString;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setLastName(String paramString)
  {
    this.lastName = paramString;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public String toString()
  {
    return "Profile [id=" + getId() + ", ]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Profile
 * JD-Core Version:    0.7.0.1
 */