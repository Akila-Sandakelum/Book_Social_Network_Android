package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class JsonObject
  extends JsonElement
{
  private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();
  
  private JsonElement createJsonElement(Object paramObject)
  {
    if (paramObject == null) {
      return JsonNull.INSTANCE;
    }
    return new JsonPrimitive(paramObject);
  }
  
  public void add(String paramString, JsonElement paramJsonElement)
  {
    if (paramJsonElement == null) {
      paramJsonElement = JsonNull.INSTANCE;
    }
    this.members.put(paramString, paramJsonElement);
  }
  
  public void addProperty(String paramString, Boolean paramBoolean)
  {
    add(paramString, createJsonElement(paramBoolean));
  }
  
  public void addProperty(String paramString, Character paramCharacter)
  {
    add(paramString, createJsonElement(paramCharacter));
  }
  
  public void addProperty(String paramString, Number paramNumber)
  {
    add(paramString, createJsonElement(paramNumber));
  }
  
  public void addProperty(String paramString1, String paramString2)
  {
    add(paramString1, createJsonElement(paramString2));
  }
  
  JsonObject deepCopy()
  {
    JsonObject localJsonObject = new JsonObject();
    Iterator localIterator = this.members.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJsonObject.add((String)localEntry.getKey(), ((JsonElement)localEntry.getValue()).deepCopy());
    }
    return localJsonObject;
  }
  
  public Set<Map.Entry<String, JsonElement>> entrySet()
  {
    return this.members.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonObject)) && (((JsonObject)paramObject).members.equals(this.members)));
  }
  
  public JsonElement get(String paramString)
  {
    return (JsonElement)this.members.get(paramString);
  }
  
  public JsonArray getAsJsonArray(String paramString)
  {
    return (JsonArray)this.members.get(paramString);
  }
  
  public JsonObject getAsJsonObject(String paramString)
  {
    return (JsonObject)this.members.get(paramString);
  }
  
  public JsonPrimitive getAsJsonPrimitive(String paramString)
  {
    return (JsonPrimitive)this.members.get(paramString);
  }
  
  public boolean has(String paramString)
  {
    return this.members.containsKey(paramString);
  }
  
  public int hashCode()
  {
    return this.members.hashCode();
  }
  
  public JsonElement remove(String paramString)
  {
    return (JsonElement)this.members.remove(paramString);
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.gson.JsonObject
 * JD-Core Version:    0.7.0.1
 */