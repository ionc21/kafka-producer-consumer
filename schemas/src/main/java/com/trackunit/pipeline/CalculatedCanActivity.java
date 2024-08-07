/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.trackunit.pipeline;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Report containing if CAN activity has been detected or not */
@org.apache.avro.specific.AvroGenerated
public class CalculatedCanActivity extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6838865206121272161L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CalculatedCanActivity\",\"namespace\":\"com.trackunit.pipeline\",\"doc\":\"Report containing if CAN activity has been detected or not\",\"fields\":[{\"name\":\"assetId\",\"type\":{\"type\":\"string\",\"logicalType\":\"UUID\"},\"doc\":\"Asset Identifier\"},{\"name\":\"hardwareSerialNumber\",\"type\":\"string\",\"doc\":\"IoT hardware serial number\"},{\"name\":\"CAN1\",\"type\":{\"type\":\"record\",\"name\":\"CalculatedCanInstance\",\"fields\":[{\"name\":\"activity\",\"type\":{\"type\":\"enum\",\"name\":\"CanActivityState\",\"symbols\":[\"NO_ACTIVITY_DETECTED\",\"ACTIVITY_DETECTED\",\"UNKNOWN\"],\"default\":\"UNKNOWN\"},\"doc\":\"Mandatory field representing the detected activity state\",\"default\":\"UNKNOWN\"},{\"name\":\"updatedAt\",\"type\":\"long\",\"default\":0,\"comment\":\"Time of record being updated\"}]}},{\"name\":\"CAN2\",\"type\":[\"null\",\"CalculatedCanInstance\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CalculatedCanActivity> ENCODER =
      new BinaryMessageEncoder<CalculatedCanActivity>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CalculatedCanActivity> DECODER =
      new BinaryMessageDecoder<CalculatedCanActivity>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CalculatedCanActivity> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CalculatedCanActivity> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CalculatedCanActivity> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CalculatedCanActivity>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CalculatedCanActivity to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CalculatedCanActivity from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CalculatedCanActivity instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CalculatedCanActivity fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Asset Identifier */
  @Deprecated public java.lang.CharSequence assetId;
  /** IoT hardware serial number */
  @Deprecated public java.lang.CharSequence hardwareSerialNumber;
  @Deprecated public com.trackunit.pipeline.CalculatedCanInstance CAN1;
  @Deprecated public com.trackunit.pipeline.CalculatedCanInstance CAN2;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CalculatedCanActivity() {}

  /**
   * All-args constructor.
   * @param assetId Asset Identifier
   * @param hardwareSerialNumber IoT hardware serial number
   * @param CAN1 The new value for CAN1
   * @param CAN2 The new value for CAN2
   */
  public CalculatedCanActivity(java.lang.CharSequence assetId, java.lang.CharSequence hardwareSerialNumber, com.trackunit.pipeline.CalculatedCanInstance CAN1, com.trackunit.pipeline.CalculatedCanInstance CAN2) {
    this.assetId = assetId;
    this.hardwareSerialNumber = hardwareSerialNumber;
    this.CAN1 = CAN1;
    this.CAN2 = CAN2;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return assetId;
    case 1: return hardwareSerialNumber;
    case 2: return CAN1;
    case 3: return CAN2;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: assetId = (java.lang.CharSequence)value$; break;
    case 1: hardwareSerialNumber = (java.lang.CharSequence)value$; break;
    case 2: CAN1 = (com.trackunit.pipeline.CalculatedCanInstance)value$; break;
    case 3: CAN2 = (com.trackunit.pipeline.CalculatedCanInstance)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'assetId' field.
   * @return Asset Identifier
   */
  public java.lang.CharSequence getAssetId() {
    return assetId;
  }


  /**
   * Sets the value of the 'assetId' field.
   * Asset Identifier
   * @param value the value to set.
   */
  public void setAssetId(java.lang.CharSequence value) {
    this.assetId = value;
  }

  /**
   * Gets the value of the 'hardwareSerialNumber' field.
   * @return IoT hardware serial number
   */
  public java.lang.CharSequence getHardwareSerialNumber() {
    return hardwareSerialNumber;
  }


  /**
   * Sets the value of the 'hardwareSerialNumber' field.
   * IoT hardware serial number
   * @param value the value to set.
   */
  public void setHardwareSerialNumber(java.lang.CharSequence value) {
    this.hardwareSerialNumber = value;
  }

  /**
   * Gets the value of the 'CAN1' field.
   * @return The value of the 'CAN1' field.
   */
  public com.trackunit.pipeline.CalculatedCanInstance getCAN1() {
    return CAN1;
  }


  /**
   * Sets the value of the 'CAN1' field.
   * @param value the value to set.
   */
  public void setCAN1(com.trackunit.pipeline.CalculatedCanInstance value) {
    this.CAN1 = value;
  }

  /**
   * Gets the value of the 'CAN2' field.
   * @return The value of the 'CAN2' field.
   */
  public com.trackunit.pipeline.CalculatedCanInstance getCAN2() {
    return CAN2;
  }


  /**
   * Sets the value of the 'CAN2' field.
   * @param value the value to set.
   */
  public void setCAN2(com.trackunit.pipeline.CalculatedCanInstance value) {
    this.CAN2 = value;
  }

  /**
   * Creates a new CalculatedCanActivity RecordBuilder.
   * @return A new CalculatedCanActivity RecordBuilder
   */
  public static com.trackunit.pipeline.CalculatedCanActivity.Builder newBuilder() {
    return new com.trackunit.pipeline.CalculatedCanActivity.Builder();
  }

  /**
   * Creates a new CalculatedCanActivity RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CalculatedCanActivity RecordBuilder
   */
  public static com.trackunit.pipeline.CalculatedCanActivity.Builder newBuilder(com.trackunit.pipeline.CalculatedCanActivity.Builder other) {
    if (other == null) {
      return new com.trackunit.pipeline.CalculatedCanActivity.Builder();
    } else {
      return new com.trackunit.pipeline.CalculatedCanActivity.Builder(other);
    }
  }

  /**
   * Creates a new CalculatedCanActivity RecordBuilder by copying an existing CalculatedCanActivity instance.
   * @param other The existing instance to copy.
   * @return A new CalculatedCanActivity RecordBuilder
   */
  public static com.trackunit.pipeline.CalculatedCanActivity.Builder newBuilder(com.trackunit.pipeline.CalculatedCanActivity other) {
    if (other == null) {
      return new com.trackunit.pipeline.CalculatedCanActivity.Builder();
    } else {
      return new com.trackunit.pipeline.CalculatedCanActivity.Builder(other);
    }
  }

  /**
   * RecordBuilder for CalculatedCanActivity instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CalculatedCanActivity>
    implements org.apache.avro.data.RecordBuilder<CalculatedCanActivity> {

    /** Asset Identifier */
    private java.lang.CharSequence assetId;
    /** IoT hardware serial number */
    private java.lang.CharSequence hardwareSerialNumber;
    private com.trackunit.pipeline.CalculatedCanInstance CAN1;
    private com.trackunit.pipeline.CalculatedCanInstance.Builder CAN1Builder;
    private com.trackunit.pipeline.CalculatedCanInstance CAN2;
    private com.trackunit.pipeline.CalculatedCanInstance.Builder CAN2Builder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.trackunit.pipeline.CalculatedCanActivity.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.assetId)) {
        this.assetId = data().deepCopy(fields()[0].schema(), other.assetId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.hardwareSerialNumber)) {
        this.hardwareSerialNumber = data().deepCopy(fields()[1].schema(), other.hardwareSerialNumber);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.CAN1)) {
        this.CAN1 = data().deepCopy(fields()[2].schema(), other.CAN1);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (other.hasCAN1Builder()) {
        this.CAN1Builder = com.trackunit.pipeline.CalculatedCanInstance.newBuilder(other.getCAN1Builder());
      }
      if (isValidValue(fields()[3], other.CAN2)) {
        this.CAN2 = data().deepCopy(fields()[3].schema(), other.CAN2);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (other.hasCAN2Builder()) {
        this.CAN2Builder = com.trackunit.pipeline.CalculatedCanInstance.newBuilder(other.getCAN2Builder());
      }
    }

    /**
     * Creates a Builder by copying an existing CalculatedCanActivity instance
     * @param other The existing instance to copy.
     */
    private Builder(com.trackunit.pipeline.CalculatedCanActivity other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.assetId)) {
        this.assetId = data().deepCopy(fields()[0].schema(), other.assetId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.hardwareSerialNumber)) {
        this.hardwareSerialNumber = data().deepCopy(fields()[1].schema(), other.hardwareSerialNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.CAN1)) {
        this.CAN1 = data().deepCopy(fields()[2].schema(), other.CAN1);
        fieldSetFlags()[2] = true;
      }
      this.CAN1Builder = null;
      if (isValidValue(fields()[3], other.CAN2)) {
        this.CAN2 = data().deepCopy(fields()[3].schema(), other.CAN2);
        fieldSetFlags()[3] = true;
      }
      this.CAN2Builder = null;
    }

    /**
      * Gets the value of the 'assetId' field.
      * Asset Identifier
      * @return The value.
      */
    public java.lang.CharSequence getAssetId() {
      return assetId;
    }


    /**
      * Sets the value of the 'assetId' field.
      * Asset Identifier
      * @param value The value of 'assetId'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder setAssetId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.assetId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'assetId' field has been set.
      * Asset Identifier
      * @return True if the 'assetId' field has been set, false otherwise.
      */
    public boolean hasAssetId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'assetId' field.
      * Asset Identifier
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder clearAssetId() {
      assetId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'hardwareSerialNumber' field.
      * IoT hardware serial number
      * @return The value.
      */
    public java.lang.CharSequence getHardwareSerialNumber() {
      return hardwareSerialNumber;
    }


    /**
      * Sets the value of the 'hardwareSerialNumber' field.
      * IoT hardware serial number
      * @param value The value of 'hardwareSerialNumber'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder setHardwareSerialNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.hardwareSerialNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'hardwareSerialNumber' field has been set.
      * IoT hardware serial number
      * @return True if the 'hardwareSerialNumber' field has been set, false otherwise.
      */
    public boolean hasHardwareSerialNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'hardwareSerialNumber' field.
      * IoT hardware serial number
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder clearHardwareSerialNumber() {
      hardwareSerialNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'CAN1' field.
      * @return The value.
      */
    public com.trackunit.pipeline.CalculatedCanInstance getCAN1() {
      return CAN1;
    }


    /**
      * Sets the value of the 'CAN1' field.
      * @param value The value of 'CAN1'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder setCAN1(com.trackunit.pipeline.CalculatedCanInstance value) {
      validate(fields()[2], value);
      this.CAN1Builder = null;
      this.CAN1 = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'CAN1' field has been set.
      * @return True if the 'CAN1' field has been set, false otherwise.
      */
    public boolean hasCAN1() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'CAN1' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.trackunit.pipeline.CalculatedCanInstance.Builder getCAN1Builder() {
      if (CAN1Builder == null) {
        if (hasCAN1()) {
          setCAN1Builder(com.trackunit.pipeline.CalculatedCanInstance.newBuilder(CAN1));
        } else {
          setCAN1Builder(com.trackunit.pipeline.CalculatedCanInstance.newBuilder());
        }
      }
      return CAN1Builder;
    }

    /**
     * Sets the Builder instance for the 'CAN1' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder setCAN1Builder(com.trackunit.pipeline.CalculatedCanInstance.Builder value) {
      clearCAN1();
      CAN1Builder = value;
      return this;
    }

    /**
     * Checks whether the 'CAN1' field has an active Builder instance
     * @return True if the 'CAN1' field has an active Builder instance
     */
    public boolean hasCAN1Builder() {
      return CAN1Builder != null;
    }

    /**
      * Clears the value of the 'CAN1' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder clearCAN1() {
      CAN1 = null;
      CAN1Builder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'CAN2' field.
      * @return The value.
      */
    public com.trackunit.pipeline.CalculatedCanInstance getCAN2() {
      return CAN2;
    }


    /**
      * Sets the value of the 'CAN2' field.
      * @param value The value of 'CAN2'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder setCAN2(com.trackunit.pipeline.CalculatedCanInstance value) {
      validate(fields()[3], value);
      this.CAN2Builder = null;
      this.CAN2 = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'CAN2' field has been set.
      * @return True if the 'CAN2' field has been set, false otherwise.
      */
    public boolean hasCAN2() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'CAN2' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.trackunit.pipeline.CalculatedCanInstance.Builder getCAN2Builder() {
      if (CAN2Builder == null) {
        if (hasCAN2()) {
          setCAN2Builder(com.trackunit.pipeline.CalculatedCanInstance.newBuilder(CAN2));
        } else {
          setCAN2Builder(com.trackunit.pipeline.CalculatedCanInstance.newBuilder());
        }
      }
      return CAN2Builder;
    }

    /**
     * Sets the Builder instance for the 'CAN2' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder setCAN2Builder(com.trackunit.pipeline.CalculatedCanInstance.Builder value) {
      clearCAN2();
      CAN2Builder = value;
      return this;
    }

    /**
     * Checks whether the 'CAN2' field has an active Builder instance
     * @return True if the 'CAN2' field has an active Builder instance
     */
    public boolean hasCAN2Builder() {
      return CAN2Builder != null;
    }

    /**
      * Clears the value of the 'CAN2' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CalculatedCanActivity.Builder clearCAN2() {
      CAN2 = null;
      CAN2Builder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CalculatedCanActivity build() {
      try {
        CalculatedCanActivity record = new CalculatedCanActivity();
        record.assetId = fieldSetFlags()[0] ? this.assetId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.hardwareSerialNumber = fieldSetFlags()[1] ? this.hardwareSerialNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        if (CAN1Builder != null) {
          try {
            record.CAN1 = this.CAN1Builder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("CAN1"));
            throw e;
          }
        } else {
          record.CAN1 = fieldSetFlags()[2] ? this.CAN1 : (com.trackunit.pipeline.CalculatedCanInstance) defaultValue(fields()[2]);
        }
        if (CAN2Builder != null) {
          try {
            record.CAN2 = this.CAN2Builder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("CAN2"));
            throw e;
          }
        } else {
          record.CAN2 = fieldSetFlags()[3] ? this.CAN2 : (com.trackunit.pipeline.CalculatedCanInstance) defaultValue(fields()[3]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CalculatedCanActivity>
    WRITER$ = (org.apache.avro.io.DatumWriter<CalculatedCanActivity>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CalculatedCanActivity>
    READER$ = (org.apache.avro.io.DatumReader<CalculatedCanActivity>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.assetId);

    out.writeString(this.hardwareSerialNumber);

    this.CAN1.customEncode(out);

    if (this.CAN2 == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      this.CAN2.customEncode(out);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.assetId = in.readString(this.assetId instanceof Utf8 ? (Utf8)this.assetId : null);

      this.hardwareSerialNumber = in.readString(this.hardwareSerialNumber instanceof Utf8 ? (Utf8)this.hardwareSerialNumber : null);

      if (this.CAN1 == null) {
        this.CAN1 = new com.trackunit.pipeline.CalculatedCanInstance();
      }
      this.CAN1.customDecode(in);

      if (in.readIndex() != 1) {
        in.readNull();
        this.CAN2 = null;
      } else {
        if (this.CAN2 == null) {
          this.CAN2 = new com.trackunit.pipeline.CalculatedCanInstance();
        }
        this.CAN2.customDecode(in);
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.assetId = in.readString(this.assetId instanceof Utf8 ? (Utf8)this.assetId : null);
          break;

        case 1:
          this.hardwareSerialNumber = in.readString(this.hardwareSerialNumber instanceof Utf8 ? (Utf8)this.hardwareSerialNumber : null);
          break;

        case 2:
          if (this.CAN1 == null) {
            this.CAN1 = new com.trackunit.pipeline.CalculatedCanInstance();
          }
          this.CAN1.customDecode(in);
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.CAN2 = null;
          } else {
            if (this.CAN2 == null) {
              this.CAN2 = new com.trackunit.pipeline.CalculatedCanInstance();
            }
            this.CAN2.customDecode(in);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










