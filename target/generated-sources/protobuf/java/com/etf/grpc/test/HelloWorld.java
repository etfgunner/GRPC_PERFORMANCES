// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GRPCtest.proto

package com.etf.grpc.test;

public final class HelloWorld {
  private HelloWorld() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_etf_grpc_test_StringValue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_etf_grpc_test_StringValue_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_etf_grpc_test_SimpleModel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_etf_grpc_test_SimpleModel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_etf_grpc_test_ComplexModel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_etf_grpc_test_ComplexModel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_etf_grpc_test_EmptyValue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_etf_grpc_test_EmptyValue_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020HelloWorld.proto\022\021com.etf.grpc.test\"\034\n" +
      "\013StringValue\022\r\n\005value\030\001 \001(\t\"\\\n\013SimpleMod" +
      "el\022\n\n\002id\030\001 \001(\001\022\014\n\004name\030\002 \001(\t\022\023\n\013descript" +
      "ion\030\003 \001(\t\022\016\n\006active\030\004 \001(\010\022\016\n\006amount\030\005 \001(" +
      "\001\"0\n\014ComplexModel\022\017\n\007numbers\030\001 \003(\001\022\017\n\007st" +
      "rings\030\002 \003(\t\"\014\n\nEmptyValue2\305\002\n\013GRPCServic" +
      "e\022D\n\004test\022\035.com.etf.grpc.test.EmptyValue" +
      "\032\035.com.etf.grpc.test.EmptyValue\022J\n\tgetSt" +
      "ring\022\035.com.etf.grpc.test.EmptyValue\032\036.co" +
      "m.etf.grpc.test.StringValue\022P\n\017getSimple" +
      "Object\022\035.com.etf.grpc.test.EmptyValue\032\036." +
      "com.etf.grpc.test.SimpleModel\022R\n\020getComp" +
      "lexObject\022\035.com.etf.grpc.test.EmptyValue" +
      "\032\037.com.etf.grpc.test.ComplexModelB\002P\001b\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_etf_grpc_test_StringValue_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_etf_grpc_test_StringValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_etf_grpc_test_StringValue_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_com_etf_grpc_test_SimpleModel_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_etf_grpc_test_SimpleModel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_etf_grpc_test_SimpleModel_descriptor,
        new java.lang.String[] { "Id", "Name", "Description", "Active", "Amount", });
    internal_static_com_etf_grpc_test_ComplexModel_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_etf_grpc_test_ComplexModel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_etf_grpc_test_ComplexModel_descriptor,
        new java.lang.String[] { "Numbers", "Strings", });
    internal_static_com_etf_grpc_test_EmptyValue_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_etf_grpc_test_EmptyValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_etf_grpc_test_EmptyValue_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
