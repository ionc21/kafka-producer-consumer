/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pluralsight.avro.audio;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PlaySong extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5677642384520307882L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PlaySong\",\"namespace\":\"com.pluralsight.avro.audio\",\"fields\":[{\"name\":\"song\",\"type\":\"string\"},{\"name\":\"artist\",\"type\":\"string\"},{\"name\":\"action\",\"type\":{\"type\":\"enum\",\"name\":\"Action\",\"symbols\":[\"PLAY\",\"STOP\",\"PAUSE\",\"RESUME\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PlaySong> ENCODER =
      new BinaryMessageEncoder<PlaySong>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PlaySong> DECODER =
      new BinaryMessageDecoder<PlaySong>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PlaySong> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PlaySong> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PlaySong> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PlaySong>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PlaySong to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PlaySong from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PlaySong instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PlaySong fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence song;
  @Deprecated public java.lang.CharSequence artist;
  @Deprecated public com.pluralsight.avro.audio.Action action;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PlaySong() {}

  /**
   * All-args constructor.
   * @param song The new value for song
   * @param artist The new value for artist
   * @param action The new value for action
   */
  public PlaySong(java.lang.CharSequence song, java.lang.CharSequence artist, com.pluralsight.avro.audio.Action action) {
    this.song = song;
    this.artist = artist;
    this.action = action;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return song;
    case 1: return artist;
    case 2: return action;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: song = (java.lang.CharSequence)value$; break;
    case 1: artist = (java.lang.CharSequence)value$; break;
    case 2: action = (com.pluralsight.avro.audio.Action)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'song' field.
   * @return The value of the 'song' field.
   */
  public java.lang.CharSequence getSong() {
    return song;
  }


  /**
   * Sets the value of the 'song' field.
   * @param value the value to set.
   */
  public void setSong(java.lang.CharSequence value) {
    this.song = value;
  }

  /**
   * Gets the value of the 'artist' field.
   * @return The value of the 'artist' field.
   */
  public java.lang.CharSequence getArtist() {
    return artist;
  }


  /**
   * Sets the value of the 'artist' field.
   * @param value the value to set.
   */
  public void setArtist(java.lang.CharSequence value) {
    this.artist = value;
  }

  /**
   * Gets the value of the 'action' field.
   * @return The value of the 'action' field.
   */
  public com.pluralsight.avro.audio.Action getAction() {
    return action;
  }


  /**
   * Sets the value of the 'action' field.
   * @param value the value to set.
   */
  public void setAction(com.pluralsight.avro.audio.Action value) {
    this.action = value;
  }

  /**
   * Creates a new PlaySong RecordBuilder.
   * @return A new PlaySong RecordBuilder
   */
  public static com.pluralsight.avro.audio.PlaySong.Builder newBuilder() {
    return new com.pluralsight.avro.audio.PlaySong.Builder();
  }

  /**
   * Creates a new PlaySong RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PlaySong RecordBuilder
   */
  public static com.pluralsight.avro.audio.PlaySong.Builder newBuilder(com.pluralsight.avro.audio.PlaySong.Builder other) {
    if (other == null) {
      return new com.pluralsight.avro.audio.PlaySong.Builder();
    } else {
      return new com.pluralsight.avro.audio.PlaySong.Builder(other);
    }
  }

  /**
   * Creates a new PlaySong RecordBuilder by copying an existing PlaySong instance.
   * @param other The existing instance to copy.
   * @return A new PlaySong RecordBuilder
   */
  public static com.pluralsight.avro.audio.PlaySong.Builder newBuilder(com.pluralsight.avro.audio.PlaySong other) {
    if (other == null) {
      return new com.pluralsight.avro.audio.PlaySong.Builder();
    } else {
      return new com.pluralsight.avro.audio.PlaySong.Builder(other);
    }
  }

  /**
   * RecordBuilder for PlaySong instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PlaySong>
    implements org.apache.avro.data.RecordBuilder<PlaySong> {

    private java.lang.CharSequence song;
    private java.lang.CharSequence artist;
    private com.pluralsight.avro.audio.Action action;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pluralsight.avro.audio.PlaySong.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.song)) {
        this.song = data().deepCopy(fields()[0].schema(), other.song);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.artist)) {
        this.artist = data().deepCopy(fields()[1].schema(), other.artist);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.action)) {
        this.action = data().deepCopy(fields()[2].schema(), other.action);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing PlaySong instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pluralsight.avro.audio.PlaySong other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.song)) {
        this.song = data().deepCopy(fields()[0].schema(), other.song);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.artist)) {
        this.artist = data().deepCopy(fields()[1].schema(), other.artist);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.action)) {
        this.action = data().deepCopy(fields()[2].schema(), other.action);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'song' field.
      * @return The value.
      */
    public java.lang.CharSequence getSong() {
      return song;
    }


    /**
      * Sets the value of the 'song' field.
      * @param value The value of 'song'.
      * @return This builder.
      */
    public com.pluralsight.avro.audio.PlaySong.Builder setSong(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.song = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'song' field has been set.
      * @return True if the 'song' field has been set, false otherwise.
      */
    public boolean hasSong() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'song' field.
      * @return This builder.
      */
    public com.pluralsight.avro.audio.PlaySong.Builder clearSong() {
      song = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'artist' field.
      * @return The value.
      */
    public java.lang.CharSequence getArtist() {
      return artist;
    }


    /**
      * Sets the value of the 'artist' field.
      * @param value The value of 'artist'.
      * @return This builder.
      */
    public com.pluralsight.avro.audio.PlaySong.Builder setArtist(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.artist = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'artist' field has been set.
      * @return True if the 'artist' field has been set, false otherwise.
      */
    public boolean hasArtist() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'artist' field.
      * @return This builder.
      */
    public com.pluralsight.avro.audio.PlaySong.Builder clearArtist() {
      artist = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'action' field.
      * @return The value.
      */
    public com.pluralsight.avro.audio.Action getAction() {
      return action;
    }


    /**
      * Sets the value of the 'action' field.
      * @param value The value of 'action'.
      * @return This builder.
      */
    public com.pluralsight.avro.audio.PlaySong.Builder setAction(com.pluralsight.avro.audio.Action value) {
      validate(fields()[2], value);
      this.action = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'action' field has been set.
      * @return True if the 'action' field has been set, false otherwise.
      */
    public boolean hasAction() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'action' field.
      * @return This builder.
      */
    public com.pluralsight.avro.audio.PlaySong.Builder clearAction() {
      action = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PlaySong build() {
      try {
        PlaySong record = new PlaySong();
        record.song = fieldSetFlags()[0] ? this.song : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.artist = fieldSetFlags()[1] ? this.artist : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.action = fieldSetFlags()[2] ? this.action : (com.pluralsight.avro.audio.Action) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PlaySong>
    WRITER$ = (org.apache.avro.io.DatumWriter<PlaySong>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PlaySong>
    READER$ = (org.apache.avro.io.DatumReader<PlaySong>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.song);

    out.writeString(this.artist);

    out.writeEnum(this.action.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.song = in.readString(this.song instanceof Utf8 ? (Utf8)this.song : null);

      this.artist = in.readString(this.artist instanceof Utf8 ? (Utf8)this.artist : null);

      this.action = com.pluralsight.avro.audio.Action.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.song = in.readString(this.song instanceof Utf8 ? (Utf8)this.song : null);
          break;

        case 1:
          this.artist = in.readString(this.artist instanceof Utf8 ? (Utf8)this.artist : null);
          break;

        case 2:
          this.action = com.pluralsight.avro.audio.Action.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










