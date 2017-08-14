/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package handson.commons.domain.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PaymentFull extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PaymentFull\",\"namespace\":\"handson.commons.domain.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"productId\",\"type\":\"string\"},{\"name\":\"transaction\",\"type\":\"string\"},{\"name\":\"productType\",\"type\":{\"type\":\"enum\",\"name\":\"ProductType\",\"symbols\":[\"SUBSCRIPTION\",\"INVOICE\",\"ECOMMERCE\"]}},{\"name\":\"amount\",\"type\":\"long\"},{\"name\":\"status\",\"type\":{\"type\":\"enum\",\"name\":\"PaymentStatus\",\"symbols\":[\"AUTHORIZED\",\"IN_ANALYSIS\",\"DENIED\"]}},{\"name\":\"createdAt\",\"type\":\"long\"},{\"name\":\"accountId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence productId;
  @Deprecated public java.lang.CharSequence transaction;
  @Deprecated public handson.commons.domain.avro.ProductType productType;
  @Deprecated public long amount;
  @Deprecated public handson.commons.domain.avro.PaymentStatus status;
  @Deprecated public long createdAt;
  @Deprecated public java.lang.CharSequence accountId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public PaymentFull() {}

  /**
   * All-args constructor.
   */
  public PaymentFull(java.lang.CharSequence id, java.lang.CharSequence productId, java.lang.CharSequence transaction, handson.commons.domain.avro.ProductType productType, java.lang.Long amount, handson.commons.domain.avro.PaymentStatus status, java.lang.Long createdAt, java.lang.CharSequence accountId) {
    this.id = id;
    this.productId = productId;
    this.transaction = transaction;
    this.productType = productType;
    this.amount = amount;
    this.status = status;
    this.createdAt = createdAt;
    this.accountId = accountId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return productId;
    case 2: return transaction;
    case 3: return productType;
    case 4: return amount;
    case 5: return status;
    case 6: return createdAt;
    case 7: return accountId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: productId = (java.lang.CharSequence)value$; break;
    case 2: transaction = (java.lang.CharSequence)value$; break;
    case 3: productType = (handson.commons.domain.avro.ProductType)value$; break;
    case 4: amount = (java.lang.Long)value$; break;
    case 5: status = (handson.commons.domain.avro.PaymentStatus)value$; break;
    case 6: createdAt = (java.lang.Long)value$; break;
    case 7: accountId = (java.lang.CharSequence)value$; break;
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
   * Gets the value of the 'productId' field.
   */
  public java.lang.CharSequence getProductId() {
    return productId;
  }

  /**
   * Sets the value of the 'productId' field.
   * @param value the value to set.
   */
  public void setProductId(java.lang.CharSequence value) {
    this.productId = value;
  }

  /**
   * Gets the value of the 'transaction' field.
   */
  public java.lang.CharSequence getTransaction() {
    return transaction;
  }

  /**
   * Sets the value of the 'transaction' field.
   * @param value the value to set.
   */
  public void setTransaction(java.lang.CharSequence value) {
    this.transaction = value;
  }

  /**
   * Gets the value of the 'productType' field.
   */
  public handson.commons.domain.avro.ProductType getProductType() {
    return productType;
  }

  /**
   * Sets the value of the 'productType' field.
   * @param value the value to set.
   */
  public void setProductType(handson.commons.domain.avro.ProductType value) {
    this.productType = value;
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
  public handson.commons.domain.avro.PaymentStatus getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(handson.commons.domain.avro.PaymentStatus value) {
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

  /** Creates a new PaymentFull RecordBuilder */
  public static handson.commons.domain.avro.PaymentFull.Builder newBuilder() {
    return new handson.commons.domain.avro.PaymentFull.Builder();
  }
  
  /** Creates a new PaymentFull RecordBuilder by copying an existing Builder */
  public static handson.commons.domain.avro.PaymentFull.Builder newBuilder(handson.commons.domain.avro.PaymentFull.Builder other) {
    return new handson.commons.domain.avro.PaymentFull.Builder(other);
  }
  
  /** Creates a new PaymentFull RecordBuilder by copying an existing PaymentFull instance */
  public static handson.commons.domain.avro.PaymentFull.Builder newBuilder(handson.commons.domain.avro.PaymentFull other) {
    return new handson.commons.domain.avro.PaymentFull.Builder(other);
  }
  
  /**
   * RecordBuilder for PaymentFull instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PaymentFull>
    implements org.apache.avro.data.RecordBuilder<PaymentFull> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence productId;
    private java.lang.CharSequence transaction;
    private handson.commons.domain.avro.ProductType productType;
    private long amount;
    private handson.commons.domain.avro.PaymentStatus status;
    private long createdAt;
    private java.lang.CharSequence accountId;

    /** Creates a new Builder */
    private Builder() {
      super(handson.commons.domain.avro.PaymentFull.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(handson.commons.domain.avro.PaymentFull.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.productId)) {
        this.productId = data().deepCopy(fields()[1].schema(), other.productId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.transaction)) {
        this.transaction = data().deepCopy(fields()[2].schema(), other.transaction);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.productType)) {
        this.productType = data().deepCopy(fields()[3].schema(), other.productType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.amount)) {
        this.amount = data().deepCopy(fields()[4].schema(), other.amount);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.status)) {
        this.status = data().deepCopy(fields()[5].schema(), other.status);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[6].schema(), other.createdAt);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.accountId)) {
        this.accountId = data().deepCopy(fields()[7].schema(), other.accountId);
        fieldSetFlags()[7] = true;
      }
    }
    
    /** Creates a Builder by copying an existing PaymentFull instance */
    private Builder(handson.commons.domain.avro.PaymentFull other) {
            super(handson.commons.domain.avro.PaymentFull.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.productId)) {
        this.productId = data().deepCopy(fields()[1].schema(), other.productId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.transaction)) {
        this.transaction = data().deepCopy(fields()[2].schema(), other.transaction);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.productType)) {
        this.productType = data().deepCopy(fields()[3].schema(), other.productType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.amount)) {
        this.amount = data().deepCopy(fields()[4].schema(), other.amount);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.status)) {
        this.status = data().deepCopy(fields()[5].schema(), other.status);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[6].schema(), other.createdAt);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.accountId)) {
        this.accountId = data().deepCopy(fields()[7].schema(), other.accountId);
        fieldSetFlags()[7] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public handson.commons.domain.avro.PaymentFull.Builder setId(java.lang.CharSequence value) {
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
    public handson.commons.domain.avro.PaymentFull.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'productId' field */
    public java.lang.CharSequence getProductId() {
      return productId;
    }
    
    /** Sets the value of the 'productId' field */
    public handson.commons.domain.avro.PaymentFull.Builder setProductId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.productId = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'productId' field has been set */
    public boolean hasProductId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'productId' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearProductId() {
      productId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'transaction' field */
    public java.lang.CharSequence getTransaction() {
      return transaction;
    }
    
    /** Sets the value of the 'transaction' field */
    public handson.commons.domain.avro.PaymentFull.Builder setTransaction(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.transaction = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'transaction' field has been set */
    public boolean hasTransaction() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'transaction' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearTransaction() {
      transaction = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'productType' field */
    public handson.commons.domain.avro.ProductType getProductType() {
      return productType;
    }
    
    /** Sets the value of the 'productType' field */
    public handson.commons.domain.avro.PaymentFull.Builder setProductType(handson.commons.domain.avro.ProductType value) {
      validate(fields()[3], value);
      this.productType = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'productType' field has been set */
    public boolean hasProductType() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'productType' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearProductType() {
      productType = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'amount' field */
    public java.lang.Long getAmount() {
      return amount;
    }
    
    /** Sets the value of the 'amount' field */
    public handson.commons.domain.avro.PaymentFull.Builder setAmount(long value) {
      validate(fields()[4], value);
      this.amount = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'amount' field has been set */
    public boolean hasAmount() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'amount' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearAmount() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'status' field */
    public handson.commons.domain.avro.PaymentStatus getStatus() {
      return status;
    }
    
    /** Sets the value of the 'status' field */
    public handson.commons.domain.avro.PaymentFull.Builder setStatus(handson.commons.domain.avro.PaymentStatus value) {
      validate(fields()[5], value);
      this.status = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'status' field has been set */
    public boolean hasStatus() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'status' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearStatus() {
      status = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'createdAt' field */
    public java.lang.Long getCreatedAt() {
      return createdAt;
    }
    
    /** Sets the value of the 'createdAt' field */
    public handson.commons.domain.avro.PaymentFull.Builder setCreatedAt(long value) {
      validate(fields()[6], value);
      this.createdAt = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'createdAt' field has been set */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'createdAt' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearCreatedAt() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'accountId' field */
    public java.lang.CharSequence getAccountId() {
      return accountId;
    }
    
    /** Sets the value of the 'accountId' field */
    public handson.commons.domain.avro.PaymentFull.Builder setAccountId(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.accountId = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'accountId' field has been set */
    public boolean hasAccountId() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'accountId' field */
    public handson.commons.domain.avro.PaymentFull.Builder clearAccountId() {
      accountId = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public PaymentFull build() {
      try {
        PaymentFull record = new PaymentFull();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.productId = fieldSetFlags()[1] ? this.productId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.transaction = fieldSetFlags()[2] ? this.transaction : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.productType = fieldSetFlags()[3] ? this.productType : (handson.commons.domain.avro.ProductType) defaultValue(fields()[3]);
        record.amount = fieldSetFlags()[4] ? this.amount : (java.lang.Long) defaultValue(fields()[4]);
        record.status = fieldSetFlags()[5] ? this.status : (handson.commons.domain.avro.PaymentStatus) defaultValue(fields()[5]);
        record.createdAt = fieldSetFlags()[6] ? this.createdAt : (java.lang.Long) defaultValue(fields()[6]);
        record.accountId = fieldSetFlags()[7] ? this.accountId : (java.lang.CharSequence) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}