/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package handson.commons.domain.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public enum OrderStatus { 
  CREATED, PAID, CANCELLED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"OrderStatus\",\"namespace\":\"handson.commons.domain.avro\",\"symbols\":[\"CREATED\",\"PAID\",\"CANCELLED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}