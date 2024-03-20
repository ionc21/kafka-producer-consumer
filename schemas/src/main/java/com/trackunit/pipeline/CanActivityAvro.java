/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.trackunit.pipeline;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;

/** Report containing if CAN activity has been detected or not */
@org.apache.avro.specific.AvroGenerated
public class CanActivityAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8173309940961144618L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CanActivityAvro\",\"namespace\":\"com.trackunit.pipeline\",\"doc\":\"Report containing if CAN activity has been detected or not\",\"fields\":[{\"name\":\"assetId\",\"type\":\"string\",\"doc\":\"Asset Identifier\",\"logicalType\":\"UUID\"},{\"name\":\"hardwareSerialNumber\",\"type\":\"string\"},{\"name\":\"activity\",\"type\":{\"type\":\"enum\",\"name\":\"CanActivityStateAvro\",\"symbols\":[\"NO_ACTIVITY_DETECTED\",\"ACTIVITY_DETECTED\",\"ACTIVITY_UNKNOWN\"],\"default\":\"ACTIVITY_UNKNOWN\"},\"doc\":\"Mandatory field representing the detected activity state\"},{\"name\":\"time\",\"type\":\"long\",\"default\":0,\"comment\":\"Time of creation on the device\"},{\"name\":\"receivedAt\",\"type\":\"long\",\"default\":0,\"comment\":\"Time of reception\"},{\"name\":\"canInstance\",\"type\":{\"type\":\"enum\",\"name\":\"CanInstance\",\"symbols\":[\"CAN_1\",\"CAN_2\",\"UNKNOWN\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CanActivityAvro> ENCODER =
      new BinaryMessageEncoder<CanActivityAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CanActivityAvro> DECODER =
      new BinaryMessageDecoder<CanActivityAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CanActivityAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CanActivityAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CanActivityAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CanActivityAvro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CanActivityAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CanActivityAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CanActivityAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CanActivityAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Asset Identifier */
  @Deprecated public java.lang.CharSequence assetId;
  @Deprecated public java.lang.CharSequence hardwareSerialNumber;
  /** Mandatory field representing the detected activity state */
  @Deprecated public com.trackunit.pipeline.CanActivityStateAvro activity;
  @Deprecated public long time;
  @Deprecated public long receivedAt;
  @Deprecated public com.trackunit.pipeline.CanInstance canInstance;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CanActivityAvro() {}

  /**
   * All-args constructor.
   * @param assetId Asset Identifier
   * @param hardwareSerialNumber The new value for hardwareSerialNumber
   * @param activity Mandatory field representing the detected activity state
   * @param time The new value for time
   * @param receivedAt The new value for receivedAt
   * @param canInstance The new value for canInstance
   */
  public CanActivityAvro(java.lang.CharSequence assetId, java.lang.CharSequence hardwareSerialNumber, com.trackunit.pipeline.CanActivityStateAvro activity, java.lang.Long time, java.lang.Long receivedAt, com.trackunit.pipeline.CanInstance canInstance) {
    this.assetId = assetId;
    this.hardwareSerialNumber = hardwareSerialNumber;
    this.activity = activity;
    this.time = time;
    this.receivedAt = receivedAt;
    this.canInstance = canInstance;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return assetId;
    case 1: return hardwareSerialNumber;
    case 2: return activity;
    case 3: return time;
    case 4: return receivedAt;
    case 5: return canInstance;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: assetId = (java.lang.CharSequence)value$; break;
    case 1: hardwareSerialNumber = (java.lang.CharSequence)value$; break;
    case 2: activity = (com.trackunit.pipeline.CanActivityStateAvro)value$; break;
    case 3: time = (java.lang.Long)value$; break;
    case 4: receivedAt = (java.lang.Long)value$; break;
    case 5: canInstance = (com.trackunit.pipeline.CanInstance)value$; break;
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
   * @return The value of the 'hardwareSerialNumber' field.
   */
  public java.lang.CharSequence getHardwareSerialNumber() {
    return hardwareSerialNumber;
  }


  /**
   * Sets the value of the 'hardwareSerialNumber' field.
   * @param value the value to set.
   */
  public void setHardwareSerialNumber(java.lang.CharSequence value) {
    this.hardwareSerialNumber = value;
  }

  /**
   * Gets the value of the 'activity' field.
   * @return Mandatory field representing the detected activity state
   */
  public com.trackunit.pipeline.CanActivityStateAvro getActivity() {
    return activity;
  }


  /**
   * Sets the value of the 'activity' field.
   * Mandatory field representing the detected activity state
   * @param value the value to set.
   */
  public void setActivity(com.trackunit.pipeline.CanActivityStateAvro value) {
    this.activity = value;
  }

  /**
   * Gets the value of the 'time' field.
   * @return The value of the 'time' field.
   */
  public long getTime() {
    return time;
  }


  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(long value) {
    this.time = value;
  }

  /**
   * Gets the value of the 'receivedAt' field.
   * @return The value of the 'receivedAt' field.
   */
  public long getReceivedAt() {
    return receivedAt;
  }


  /**
   * Sets the value of the 'receivedAt' field.
   * @param value the value to set.
   */
  public void setReceivedAt(long value) {
    this.receivedAt = value;
  }

  /**
   * Gets the value of the 'canInstance' field.
   * @return The value of the 'canInstance' field.
   */
  public com.trackunit.pipeline.CanInstance getCanInstance() {
    return canInstance;
  }


  /**
   * Sets the value of the 'canInstance' field.
   * @param value the value to set.
   */
  public void setCanInstance(com.trackunit.pipeline.CanInstance value) {
    this.canInstance = value;
  }

  /**
   * Creates a new CanActivityAvro RecordBuilder.
   * @return A new CanActivityAvro RecordBuilder
   */
  public static com.trackunit.pipeline.CanActivityAvro.Builder newBuilder() {
    return new com.trackunit.pipeline.CanActivityAvro.Builder();
  }

  /**
   * Creates a new CanActivityAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CanActivityAvro RecordBuilder
   */
  public static com.trackunit.pipeline.CanActivityAvro.Builder newBuilder(com.trackunit.pipeline.CanActivityAvro.Builder other) {
    if (other == null) {
      return new com.trackunit.pipeline.CanActivityAvro.Builder();
    } else {
      return new com.trackunit.pipeline.CanActivityAvro.Builder(other);
    }
  }

  /**
   * Creates a new CanActivityAvro RecordBuilder by copying an existing CanActivityAvro instance.
   * @param other The existing instance to copy.
   * @return A new CanActivityAvro RecordBuilder
   */
  public static com.trackunit.pipeline.CanActivityAvro.Builder newBuilder(com.trackunit.pipeline.CanActivityAvro other) {
    if (other == null) {
      return new com.trackunit.pipeline.CanActivityAvro.Builder();
    } else {
      return new com.trackunit.pipeline.CanActivityAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for CanActivityAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CanActivityAvro>
    implements org.apache.avro.data.RecordBuilder<CanActivityAvro> {

    /** Asset Identifier */
    private java.lang.CharSequence assetId;
    private java.lang.CharSequence hardwareSerialNumber;
    /** Mandatory field representing the detected activity state */
    private com.trackunit.pipeline.CanActivityStateAvro activity;
    private long time;
    private long receivedAt;
    private com.trackunit.pipeline.CanInstance canInstance;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.trackunit.pipeline.CanActivityAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.assetId)) {
        this.assetId = data().deepCopy(fields()[0].schema(), other.assetId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.hardwareSerialNumber)) {
        this.hardwareSerialNumber = data().deepCopy(fields()[1].schema(), other.hardwareSerialNumber);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.activity)) {
        this.activity = data().deepCopy(fields()[2].schema(), other.activity);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.time)) {
        this.time = data().deepCopy(fields()[3].schema(), other.time);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.receivedAt)) {
        this.receivedAt = data().deepCopy(fields()[4].schema(), other.receivedAt);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.canInstance)) {
        this.canInstance = data().deepCopy(fields()[5].schema(), other.canInstance);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing CanActivityAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.trackunit.pipeline.CanActivityAvro other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.assetId)) {
        this.assetId = data().deepCopy(fields()[0].schema(), other.assetId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.hardwareSerialNumber)) {
        this.hardwareSerialNumber = data().deepCopy(fields()[1].schema(), other.hardwareSerialNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.activity)) {
        this.activity = data().deepCopy(fields()[2].schema(), other.activity);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.time)) {
        this.time = data().deepCopy(fields()[3].schema(), other.time);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.receivedAt)) {
        this.receivedAt = data().deepCopy(fields()[4].schema(), other.receivedAt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.canInstance)) {
        this.canInstance = data().deepCopy(fields()[5].schema(), other.canInstance);
        fieldSetFlags()[5] = true;
      }
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
    public com.trackunit.pipeline.CanActivityAvro.Builder setAssetId(java.lang.CharSequence value) {
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
    public com.trackunit.pipeline.CanActivityAvro.Builder clearAssetId() {
      assetId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'hardwareSerialNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getHardwareSerialNumber() {
      return hardwareSerialNumber;
    }


    /**
      * Sets the value of the 'hardwareSerialNumber' field.
      * @param value The value of 'hardwareSerialNumber'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder setHardwareSerialNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.hardwareSerialNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'hardwareSerialNumber' field has been set.
      * @return True if the 'hardwareSerialNumber' field has been set, false otherwise.
      */
    public boolean hasHardwareSerialNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'hardwareSerialNumber' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder clearHardwareSerialNumber() {
      hardwareSerialNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'activity' field.
      * Mandatory field representing the detected activity state
      * @return The value.
      */
    public com.trackunit.pipeline.CanActivityStateAvro getActivity() {
      return activity;
    }


    /**
      * Sets the value of the 'activity' field.
      * Mandatory field representing the detected activity state
      * @param value The value of 'activity'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder setActivity(com.trackunit.pipeline.CanActivityStateAvro value) {
      validate(fields()[2], value);
      this.activity = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'activity' field has been set.
      * Mandatory field representing the detected activity state
      * @return True if the 'activity' field has been set, false otherwise.
      */
    public boolean hasActivity() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'activity' field.
      * Mandatory field representing the detected activity state
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder clearActivity() {
      activity = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'time' field.
      * @return The value.
      */
    public long getTime() {
      return time;
    }


    /**
      * Sets the value of the 'time' field.
      * @param value The value of 'time'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder setTime(long value) {
      validate(fields()[3], value);
      this.time = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'time' field has been set.
      * @return True if the 'time' field has been set, false otherwise.
      */
    public boolean hasTime() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'time' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder clearTime() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'receivedAt' field.
      * @return The value.
      */
    public long getReceivedAt() {
      return receivedAt;
    }


    /**
      * Sets the value of the 'receivedAt' field.
      * @param value The value of 'receivedAt'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder setReceivedAt(long value) {
      validate(fields()[4], value);
      this.receivedAt = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'receivedAt' field has been set.
      * @return True if the 'receivedAt' field has been set, false otherwise.
      */
    public boolean hasReceivedAt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'receivedAt' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder clearReceivedAt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'canInstance' field.
      * @return The value.
      */
    public com.trackunit.pipeline.CanInstance getCanInstance() {
      return canInstance;
    }


    /**
      * Sets the value of the 'canInstance' field.
      * @param value The value of 'canInstance'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder setCanInstance(com.trackunit.pipeline.CanInstance value) {
      validate(fields()[5], value);
      this.canInstance = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'canInstance' field has been set.
      * @return True if the 'canInstance' field has been set, false otherwise.
      */
    public boolean hasCanInstance() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'canInstance' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanActivityAvro.Builder clearCanInstance() {
      canInstance = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CanActivityAvro build() {
      try {
        CanActivityAvro record = new CanActivityAvro();
        record.assetId = fieldSetFlags()[0] ? this.assetId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.hardwareSerialNumber = fieldSetFlags()[1] ? this.hardwareSerialNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.activity = fieldSetFlags()[2] ? this.activity : (com.trackunit.pipeline.CanActivityStateAvro) defaultValue(fields()[2]);
        record.time = fieldSetFlags()[3] ? this.time : (java.lang.Long) defaultValue(fields()[3]);
        record.receivedAt = fieldSetFlags()[4] ? this.receivedAt : (java.lang.Long) defaultValue(fields()[4]);
        record.canInstance = fieldSetFlags()[5] ? this.canInstance : (com.trackunit.pipeline.CanInstance) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CanActivityAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<CanActivityAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CanActivityAvro>
    READER$ = (org.apache.avro.io.DatumReader<CanActivityAvro>)MODEL$.createDatumReader(SCHEMA$);

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

    out.writeEnum(this.activity.ordinal());

    out.writeLong(this.time);

    out.writeLong(this.receivedAt);

    out.writeEnum(this.canInstance.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.assetId = in.readString(this.assetId instanceof Utf8 ? (Utf8)this.assetId : null);

      this.hardwareSerialNumber = in.readString(this.hardwareSerialNumber instanceof Utf8 ? (Utf8)this.hardwareSerialNumber : null);

      this.activity = com.trackunit.pipeline.CanActivityStateAvro.values()[in.readEnum()];

      this.time = in.readLong();

      this.receivedAt = in.readLong();

      this.canInstance = com.trackunit.pipeline.CanInstance.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.assetId = in.readString(this.assetId instanceof Utf8 ? (Utf8)this.assetId : null);
          break;

        case 1:
          this.hardwareSerialNumber = in.readString(this.hardwareSerialNumber instanceof Utf8 ? (Utf8)this.hardwareSerialNumber : null);
          break;

        case 2:
          this.activity = com.trackunit.pipeline.CanActivityStateAvro.values()[in.readEnum()];
          break;

        case 3:
          this.time = in.readLong();
          break;

        case 4:
          this.receivedAt = in.readLong();
          break;

        case 5:
          this.canInstance = com.trackunit.pipeline.CanInstance.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










