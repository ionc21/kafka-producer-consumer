/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.trackunit.pipeline;
@org.apache.avro.specific.AvroGenerated
public enum CanActivityStateAvro implements org.apache.avro.generic.GenericEnumSymbol<CanActivityStateAvro> {
  NO_ACTIVITY_DETECTED, ACTIVITY_DETECTED, ACTIVITY_UNKNOWN  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"CanActivityStateAvro\",\"namespace\":\"com.trackunit.pipeline\",\"symbols\":[\"NO_ACTIVITY_DETECTED\",\"ACTIVITY_DETECTED\",\"ACTIVITY_UNKNOWN\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
