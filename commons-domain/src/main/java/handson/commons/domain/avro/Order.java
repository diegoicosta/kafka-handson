/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package handson.commons.domain.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Order extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Order\",\"namespace\":\"handson.commons.domain.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"accountId\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"long\"},{\"name\":\"status\",\"type\":{\"type\":\"enum\",\"name\":\"OrderStatus\",\"symbols\":[\"CREATED\",\"PAID\",\"CANCELLED\"]}},{\"name\":\"createdAt\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence accountId;
  @Deprecated public long amount;
  @Deprecated public handson.commons.domain.avro.OrderStatus status;
  @Deprecated public long createdAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Order() {}

  /**
   * All-args constructor.
   */
  public Order(java.lang.CharSequence id, java.lang.CharSequence accountId, java.lang.Long amount, handson.commons.domain.avro.OrderStatus status, java.lang.Long createdAt) {
    this.id = id;
    this.accountId = accountId;
    this.amount = amount;
    this.status = status;
    this.createdAt = createdAt;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return accountId;
    case 2: return amount;
    case 3: return status;
    case 4: return createdAt;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: accountId = (java.lang.CharSequence)value$; break;
    case 2: amount = (java.lang.Long)value$; break;
    case 3: status = (handson.commons.domain.avro.OrderStatus)value$; break;
    case 4: createdAt = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'accountId' field.
   */
  public java.lang.CharSequence getAccountId() {
    return accountId;
  }

  /**
   * Sets the value of the 'accountId' field.
   * @param value the value to set.
   */
  public void setAccountId(java.lang.CharSequence value) {
    this.accountId = value;
  }

  /**
   * Gets the value of the 'amount' field.
   */
  public java.lang.Long getAmount() {
    return amount;
  }

  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(java.lang.Long value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'status' field.
   */
  public handson.commons.domain.avro.OrderStatus getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(handson.commons.domain.avro.OrderStatus value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   */
  public java.lang.Long getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.lang.Long value) {
    this.createdAt = value;
  }

  /** Creates a new Order RecordBuilder */
  public static handson.commons.domain.avro.Order.Builder newBuilder() {
    return new handson.commons.domain.avro.Order.Builder();
  }
  
  /** Creates a new Order RecordBuilder by copying an existing Builder */
  public static handson.commons.domain.avro.Order.Builder newBuilder(handson.commons.domain.avro.Order.Builder other) {
    return new handson.commons.domain.avro.Order.Builder(other);
  }
  
  /** Creates a new Order RecordBuilder by copying an existing Order instance */
  public static handson.commons.domain.avro.Order.Builder newBuilder(handson.commons.domain.avro.Order other) {
    return new handson.commons.domain.avro.Order.Builder(other);
  }
  
  /**
   * RecordBuilder for Order instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Order>
    implements org.apache.avro.data.RecordBuilder<Order> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence accountId;
    private long amount;
    private handson.commons.domain.avro.OrderStatus status;
    private long createdAt;

    /** Creates a new Builder */
    private Builder() {
      super(handson.commons.domain.avro.Order.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(handson.commons.domain.avro.Order.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountId)) {
        this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.amount)) {
        this.amount = data().deepCopy(fields()[2].schema(), other.amount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Order instance */
    private Builder(handson.commons.domain.avro.Order other) {
            super(handson.commons.domain.avro.Order.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountId)) {
        this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.amount)) {
        this.amount = data().deepCopy(fields()[2].schema(), other.amount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public handson.commons.domain.avro.Order.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public handson.commons.domain.avro.Order.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'accountId' field */
    public java.lang.CharSequence getAccountId() {
      return accountId;
    }
    
    /** Sets the value of the 'accountId' field */
    public handson.commons.domain.avro.Order.Builder setAccountId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.accountId = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'accountId' field has been set */
    public boolean hasAccountId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'accountId' field */
    public handson.commons.domain.avro.Order.Builder clearAccountId() {
      accountId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'amount' field */
    public java.lang.Long getAmount() {
      return amount;
    }
    
    /** Sets the value of the 'amount' field */
    public handson.commons.domain.avro.Order.Builder setAmount(long value) {
      validate(fields()[2], value);
      this.amount = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'amount' field has been set */
    public boolean hasAmount() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'amount' field */
    public handson.commons.domain.avro.Order.Builder clearAmount() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'status' field */
    public handson.commons.domain.avro.OrderStatus getStatus() {
      return status;
    }
    
    /** Sets the value of the 'status' field */
    public handson.commons.domain.avro.Order.Builder setStatus(handson.commons.domain.avro.OrderStatus value) {
      validate(fields()[3], value);
      this.status = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'status' field has been set */
    public boolean hasStatus() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'status' field */
    public handson.commons.domain.avro.Order.Builder clearStatus() {
      status = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'createdAt' field */
    public java.lang.Long getCreatedAt() {
      return createdAt;
    }
    
    /** Sets the value of the 'createdAt' field */
    public handson.commons.domain.avro.Order.Builder setCreatedAt(long value) {
      validate(fields()[4], value);
      this.createdAt = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'createdAt' field has been set */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'createdAt' field */
    public handson.commons.domain.avro.Order.Builder clearCreatedAt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public Order build() {
      try {
        Order record = new Order();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.accountId = fieldSetFlags()[1] ? this.accountId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.amount = fieldSetFlags()[2] ? this.amount : (java.lang.Long) defaultValue(fields()[2]);
        record.status = fieldSetFlags()[3] ? this.status : (handson.commons.domain.avro.OrderStatus) defaultValue(fields()[3]);
        record.createdAt = fieldSetFlags()[4] ? this.createdAt : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
