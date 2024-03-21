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

@org.apache.avro.specific.AvroGenerated
public class CanInstance2Avro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1589949452413988453L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CanInstance2Avro\",\"namespace\":\"com.trackunit.pipeline\",\"fields\":[{\"name\":\"activity\",\"type\":{\"type\":\"enum\",\"name\":\"CanActivityState\",\"symbols\":[\"NO_ACTIVITY_DETECTED\",\"ACTIVITY_DETECTED\"],\"default\":\"NO_ACTIVITY_DETECTED\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CanInstance2Avro> ENCODER =
      new BinaryMessageEncoder<CanInstance2Avro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CanInstance2Avro> DECODER =
      new BinaryMessageDecoder<CanInstance2Avro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CanInstance2Avro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CanInstance2Avro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CanInstance2Avro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CanInstance2Avro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CanInstance2Avro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CanInstance2Avro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CanInstance2Avro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CanInstance2Avro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public com.trackunit.pipeline.CanActivityState activity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CanInstance2Avro() {}

  /**
   * All-args constructor.
   * @param activity The new value for activity
   */
  public CanInstance2Avro(com.trackunit.pipeline.CanActivityState activity) {
    this.activity = activity;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return activity;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: activity = (com.trackunit.pipeline.CanActivityState)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'activity' field.
   * @return The value of the 'activity' field.
   */
  public com.trackunit.pipeline.CanActivityState getActivity() {
    return activity;
  }


  /**
   * Sets the value of the 'activity' field.
   * @param value the value to set.
   */
  public void setActivity(com.trackunit.pipeline.CanActivityState value) {
    this.activity = value;
  }

  /**
   * Creates a new CanInstance2Avro RecordBuilder.
   * @return A new CanInstance2Avro RecordBuilder
   */
  public static com.trackunit.pipeline.CanInstance2Avro.Builder newBuilder() {
    return new com.trackunit.pipeline.CanInstance2Avro.Builder();
  }

  /**
   * Creates a new CanInstance2Avro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CanInstance2Avro RecordBuilder
   */
  public static com.trackunit.pipeline.CanInstance2Avro.Builder newBuilder(com.trackunit.pipeline.CanInstance2Avro.Builder other) {
    if (other == null) {
      return new com.trackunit.pipeline.CanInstance2Avro.Builder();
    } else {
      return new com.trackunit.pipeline.CanInstance2Avro.Builder(other);
    }
  }

  /**
   * Creates a new CanInstance2Avro RecordBuilder by copying an existing CanInstance2Avro instance.
   * @param other The existing instance to copy.
   * @return A new CanInstance2Avro RecordBuilder
   */
  public static com.trackunit.pipeline.CanInstance2Avro.Builder newBuilder(com.trackunit.pipeline.CanInstance2Avro other) {
    if (other == null) {
      return new com.trackunit.pipeline.CanInstance2Avro.Builder();
    } else {
      return new com.trackunit.pipeline.CanInstance2Avro.Builder(other);
    }
  }

  /**
   * RecordBuilder for CanInstance2Avro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CanInstance2Avro>
    implements org.apache.avro.data.RecordBuilder<CanInstance2Avro> {

    private com.trackunit.pipeline.CanActivityState activity;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.trackunit.pipeline.CanInstance2Avro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.activity)) {
        this.activity = data().deepCopy(fields()[0].schema(), other.activity);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing CanInstance2Avro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.trackunit.pipeline.CanInstance2Avro other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.activity)) {
        this.activity = data().deepCopy(fields()[0].schema(), other.activity);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'activity' field.
      * @return The value.
      */
    public com.trackunit.pipeline.CanActivityState getActivity() {
      return activity;
    }


    /**
      * Sets the value of the 'activity' field.
      * @param value The value of 'activity'.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanInstance2Avro.Builder setActivity(com.trackunit.pipeline.CanActivityState value) {
      validate(fields()[0], value);
      this.activity = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'activity' field has been set.
      * @return True if the 'activity' field has been set, false otherwise.
      */
    public boolean hasActivity() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'activity' field.
      * @return This builder.
      */
    public com.trackunit.pipeline.CanInstance2Avro.Builder clearActivity() {
      activity = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CanInstance2Avro build() {
      try {
        CanInstance2Avro record = new CanInstance2Avro();
        record.activity = fieldSetFlags()[0] ? this.activity : (com.trackunit.pipeline.CanActivityState) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CanInstance2Avro>
    WRITER$ = (org.apache.avro.io.DatumWriter<CanInstance2Avro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CanInstance2Avro>
    READER$ = (org.apache.avro.io.DatumReader<CanInstance2Avro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeEnum(this.activity.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.activity = com.trackunit.pipeline.CanActivityState.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.activity = com.trackunit.pipeline.CanActivityState.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










