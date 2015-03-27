package com.booknetwork.app.entity;

import java.util.ArrayList;
import java.util.List;

public class School
{
  private List<Grade> grades = new ArrayList(0);
  private Profile profile;
  private Long school_id;
  
  public List<Grade> getGrades()
  {
    return this.grades;
  }
  
  public Profile getProfile()
  {
    return this.profile;
  }
  
  public Long getSchool_id()
  {
    return this.school_id;
  }
  
  public void setGrades(List<Grade> paramList)
  {
    this.grades = paramList;
  }
  
  public void setProfile(Profile paramProfile)
  {
    this.profile = paramProfile;
  }
  
  public void setSchool_id(Long paramLong)
  {
    this.school_id = paramLong;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.School
 * JD-Core Version:    0.7.0.1
 */