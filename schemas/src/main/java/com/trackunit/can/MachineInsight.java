/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.trackunit.can;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class MachineInsight extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7950805015623840480L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MachineInsight\",\"namespace\":\"com.trackunit.can\",\"fields\":[{\"name\":\"machineInsights\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"array\",\"items\":\"string\"}},\"default\":[]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<MachineInsight> ENCODER =
      new BinaryMessageEncoder<MachineInsight>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MachineInsight> DECODER =
      new BinaryMessageDecoder<MachineInsight>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MachineInsight> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MachineInsight> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MachineInsight> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<MachineInsight>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MachineInsight to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MachineInsight from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MachineInsight instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MachineInsight fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<java.util.List<java.lang.CharSequence>> machineInsights;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MachineInsight() {}

  /**
   * All-args constructor.
   * @param machineInsights The new value for machineInsights
   */
  public MachineInsight(java.util.List<java.util.List<java.lang.CharSequence>> machineInsights) {
    this.machineInsights = machineInsights;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return machineInsights;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: machineInsights = (java.util.List<java.util.List<java.lang.CharSequence>>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'machineInsights' field.
   * @return The value of the 'machineInsights' field.
   */
  public java.util.List<java.util.List<java.lang.CharSequence>> getMachineInsights() {
    return machineInsights;
  }


  /**
   * Sets the value of the 'machineInsights' field.
   * @param value the value to set.
   */
  public void setMachineInsights(java.util.List<java.util.List<java.lang.CharSequence>> value) {
    this.machineInsights = value;
  }

  /**
   * Creates a new MachineInsight RecordBuilder.
   * @return A new MachineInsight RecordBuilder
   */
  public static com.trackunit.can.MachineInsight.Builder newBuilder() {
    return new com.trackunit.can.MachineInsight.Builder();
  }

  /**
   * Creates a new MachineInsight RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MachineInsight RecordBuilder
   */
  public static com.trackunit.can.MachineInsight.Builder newBuilder(com.trackunit.can.MachineInsight.Builder other) {
    if (other == null) {
      return new com.trackunit.can.MachineInsight.Builder();
    } else {
      return new com.trackunit.can.MachineInsight.Builder(other);
    }
  }

  /**
   * Creates a new MachineInsight RecordBuilder by copying an existing MachineInsight instance.
   * @param other The existing instance to copy.
   * @return A new MachineInsight RecordBuilder
   */
  public static com.trackunit.can.MachineInsight.Builder newBuilder(com.trackunit.can.MachineInsight other) {
    if (other == null) {
      return new com.trackunit.can.MachineInsight.Builder();
    } else {
      return new com.trackunit.can.MachineInsight.Builder(other);
    }
  }

  /**
   * RecordBuilder for MachineInsight instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MachineInsight>
    implements org.apache.avro.data.RecordBuilder<MachineInsight> {

    private java.util.List<java.util.List<java.lang.CharSequence>> machineInsights;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.trackunit.can.MachineInsight.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.machineInsights)) {
        this.machineInsights = data().deepCopy(fields()[0].schema(), other.machineInsights);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing MachineInsight instance
     * @param other The existing instance to copy.
     */
    private Builder(com.trackunit.can.MachineInsight other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.machineInsights)) {
        this.machineInsights = data().deepCopy(fields()[0].schema(), other.machineInsights);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'machineInsights' field.
      * @return The value.
      */
    public java.util.List<java.util.List<java.lang.CharSequence>> getMachineInsights() {
      return machineInsights;
    }


    /**
      * Sets the value of the 'machineInsights' field.
      * @param value The value of 'machineInsights'.
      * @return This builder.
      */
    public com.trackunit.can.MachineInsight.Builder setMachineInsights(java.util.List<java.util.List<java.lang.CharSequence>> value) {
      validate(fields()[0], value);
      this.machineInsights = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'machineInsights' field has been set.
      * @return True if the 'machineInsights' field has been set, false otherwise.
      */
    public boolean hasMachineInsights() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'machineInsights' field.
      * @return This builder.
      */
    public com.trackunit.can.MachineInsight.Builder clearMachineInsights() {
      machineInsights = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MachineInsight build() {
      try {
        MachineInsight record = new MachineInsight();
        record.machineInsights = fieldSetFlags()[0] ? this.machineInsights : (java.util.List<java.util.List<java.lang.CharSequence>>) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MachineInsight>
    WRITER$ = (org.apache.avro.io.DatumWriter<MachineInsight>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MachineInsight>
    READER$ = (org.apache.avro.io.DatumReader<MachineInsight>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    long size0 = this.machineInsights.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (java.util.List<java.lang.CharSequence> e0: this.machineInsights) {
      actualSize0++;
      out.startItem();
      long size1 = e0.size();
      out.writeArrayStart();
      out.setItemCount(size1);
      long actualSize1 = 0;
      for (java.lang.CharSequence e1: e0) {
        actualSize1++;
        out.startItem();
        out.writeString(e1);
      }
      out.writeArrayEnd();
      if (actualSize1 != size1)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size1 + ", but element count was " + actualSize1 + ".");
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      long size0 = in.readArrayStart();
      java.util.List<java.util.List<java.lang.CharSequence>> a0 = this.machineInsights;
      if (a0 == null) {
        a0 = new SpecificData.Array<java.util.List<java.lang.CharSequence>>((int)size0, SCHEMA$.getField("machineInsights").schema());
        this.machineInsights = a0;
      } else a0.clear();
      SpecificData.Array<java.util.List<java.lang.CharSequence>> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.util.List<java.lang.CharSequence>>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          java.util.List<java.lang.CharSequence> e0 = (ga0 != null ? ga0.peek() : null);
          long size1 = in.readArrayStart();
          java.util.List<java.lang.CharSequence> a1 = e0;
          if (a1 == null) {
            a1 = new SpecificData.Array<java.lang.CharSequence>((int)size1, SCHEMA$.getField("machineInsights").schema().getElementType());
            e0 = a1;
          } else a1.clear();
          SpecificData.Array<java.lang.CharSequence> ga1 = (a1 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a1 : null);
          for ( ; 0 < size1; size1 = in.arrayNext()) {
            for ( ; size1 != 0; size1--) {
              java.lang.CharSequence e1 = (ga1 != null ? ga1.peek() : null);
              e1 = in.readString(e1 instanceof Utf8 ? (Utf8)e1 : null);
              a1.add(e1);
            }
          }
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          long size0 = in.readArrayStart();
          java.util.List<java.util.List<java.lang.CharSequence>> a0 = this.machineInsights;
          if (a0 == null) {
            a0 = new SpecificData.Array<java.util.List<java.lang.CharSequence>>((int)size0, SCHEMA$.getField("machineInsights").schema());
            this.machineInsights = a0;
          } else a0.clear();
          SpecificData.Array<java.util.List<java.lang.CharSequence>> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.util.List<java.lang.CharSequence>>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              java.util.List<java.lang.CharSequence> e0 = (ga0 != null ? ga0.peek() : null);
              long size1 = in.readArrayStart();
              java.util.List<java.lang.CharSequence> a1 = e0;
              if (a1 == null) {
                a1 = new SpecificData.Array<java.lang.CharSequence>((int)size1, SCHEMA$.getField("machineInsights").schema().getElementType());
                e0 = a1;
              } else a1.clear();
              SpecificData.Array<java.lang.CharSequence> ga1 = (a1 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a1 : null);
              for ( ; 0 < size1; size1 = in.arrayNext()) {
                for ( ; size1 != 0; size1--) {
                  java.lang.CharSequence e1 = (ga1 != null ? ga1.peek() : null);
                  e1 = in.readString(e1 instanceof Utf8 ? (Utf8)e1 : null);
                  a1.add(e1);
                }
              }
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









