// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GRPCtest.proto

package com.etf.grpc.test;

public interface SimpleModelOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.etf.grpc.test.SimpleModel)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>double id = 1;</code>
   */
  double getId();

  /**
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string description = 3;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 3;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>bool active = 4;</code>
   */
  boolean getActive();

  /**
   * <code>double amount = 5;</code>
   */
  double getAmount();
}