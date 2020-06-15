// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: great.proto

package io.grpc.justtest;

/**
 * Protobuf type {@code onlytest.LogMetaData}
 */
public  final class LogMetaData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:onlytest.LogMetaData)
    LogMetaDataOrBuilder {
  // Use LogMetaData.newBuilder() to construct.
  private LogMetaData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogMetaData() {
    currentTerm_ = 0L;
    votedFor_ = 0;
    firstLogIndex_ = 0L;
    commitIndex_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private LogMetaData(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            currentTerm_ = input.readUInt64();
            break;
          }
          case 16: {

            votedFor_ = input.readUInt32();
            break;
          }
          case 24: {

            firstLogIndex_ = input.readUInt64();
            break;
          }
          case 32: {

            commitIndex_ = input.readUInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.justtest.JustTestProto.internal_static_onlytest_LogMetaData_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.justtest.JustTestProto.internal_static_onlytest_LogMetaData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.justtest.LogMetaData.class, io.grpc.justtest.LogMetaData.Builder.class);
  }

  public static final int CURRENT_TERM_FIELD_NUMBER = 1;
  private long currentTerm_;
  /**
   * <code>optional uint64 current_term = 1;</code>
   */
  public long getCurrentTerm() {
    return currentTerm_;
  }

  public static final int VOTED_FOR_FIELD_NUMBER = 2;
  private int votedFor_;
  /**
   * <code>optional uint32 voted_for = 2;</code>
   */
  public int getVotedFor() {
    return votedFor_;
  }

  public static final int FIRST_LOG_INDEX_FIELD_NUMBER = 3;
  private long firstLogIndex_;
  /**
   * <code>optional uint64 first_log_index = 3;</code>
   */
  public long getFirstLogIndex() {
    return firstLogIndex_;
  }

  public static final int COMMIT_INDEX_FIELD_NUMBER = 4;
  private long commitIndex_;
  /**
   * <code>optional uint64 commit_index = 4;</code>
   */
  public long getCommitIndex() {
    return commitIndex_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (currentTerm_ != 0L) {
      output.writeUInt64(1, currentTerm_);
    }
    if (votedFor_ != 0) {
      output.writeUInt32(2, votedFor_);
    }
    if (firstLogIndex_ != 0L) {
      output.writeUInt64(3, firstLogIndex_);
    }
    if (commitIndex_ != 0L) {
      output.writeUInt64(4, commitIndex_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (currentTerm_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, currentTerm_);
    }
    if (votedFor_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, votedFor_);
    }
    if (firstLogIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, firstLogIndex_);
    }
    if (commitIndex_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, commitIndex_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.justtest.LogMetaData)) {
      return super.equals(obj);
    }
    io.grpc.justtest.LogMetaData other = (io.grpc.justtest.LogMetaData) obj;

    boolean result = true;
    result = result && (getCurrentTerm()
        == other.getCurrentTerm());
    result = result && (getVotedFor()
        == other.getVotedFor());
    result = result && (getFirstLogIndex()
        == other.getFirstLogIndex());
    result = result && (getCommitIndex()
        == other.getCommitIndex());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + CURRENT_TERM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCurrentTerm());
    hash = (37 * hash) + VOTED_FOR_FIELD_NUMBER;
    hash = (53 * hash) + getVotedFor();
    hash = (37 * hash) + FIRST_LOG_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFirstLogIndex());
    hash = (37 * hash) + COMMIT_INDEX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCommitIndex());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.justtest.LogMetaData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.justtest.LogMetaData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.justtest.LogMetaData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.justtest.LogMetaData parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.justtest.LogMetaData prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code onlytest.LogMetaData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:onlytest.LogMetaData)
      io.grpc.justtest.LogMetaDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.justtest.JustTestProto.internal_static_onlytest_LogMetaData_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.justtest.JustTestProto.internal_static_onlytest_LogMetaData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.justtest.LogMetaData.class, io.grpc.justtest.LogMetaData.Builder.class);
    }

    // Construct using io.grpc.justtest.LogMetaData.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      currentTerm_ = 0L;

      votedFor_ = 0;

      firstLogIndex_ = 0L;

      commitIndex_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.justtest.JustTestProto.internal_static_onlytest_LogMetaData_descriptor;
    }

    public io.grpc.justtest.LogMetaData getDefaultInstanceForType() {
      return io.grpc.justtest.LogMetaData.getDefaultInstance();
    }

    public io.grpc.justtest.LogMetaData build() {
      io.grpc.justtest.LogMetaData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.grpc.justtest.LogMetaData buildPartial() {
      io.grpc.justtest.LogMetaData result = new io.grpc.justtest.LogMetaData(this);
      result.currentTerm_ = currentTerm_;
      result.votedFor_ = votedFor_;
      result.firstLogIndex_ = firstLogIndex_;
      result.commitIndex_ = commitIndex_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.justtest.LogMetaData) {
        return mergeFrom((io.grpc.justtest.LogMetaData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.justtest.LogMetaData other) {
      if (other == io.grpc.justtest.LogMetaData.getDefaultInstance()) return this;
      if (other.getCurrentTerm() != 0L) {
        setCurrentTerm(other.getCurrentTerm());
      }
      if (other.getVotedFor() != 0) {
        setVotedFor(other.getVotedFor());
      }
      if (other.getFirstLogIndex() != 0L) {
        setFirstLogIndex(other.getFirstLogIndex());
      }
      if (other.getCommitIndex() != 0L) {
        setCommitIndex(other.getCommitIndex());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.justtest.LogMetaData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.justtest.LogMetaData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long currentTerm_ ;
    /**
     * <code>optional uint64 current_term = 1;</code>
     */
    public long getCurrentTerm() {
      return currentTerm_;
    }
    /**
     * <code>optional uint64 current_term = 1;</code>
     */
    public Builder setCurrentTerm(long value) {
      
      currentTerm_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 current_term = 1;</code>
     */
    public Builder clearCurrentTerm() {
      
      currentTerm_ = 0L;
      onChanged();
      return this;
    }

    private int votedFor_ ;
    /**
     * <code>optional uint32 voted_for = 2;</code>
     */
    public int getVotedFor() {
      return votedFor_;
    }
    /**
     * <code>optional uint32 voted_for = 2;</code>
     */
    public Builder setVotedFor(int value) {
      
      votedFor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 voted_for = 2;</code>
     */
    public Builder clearVotedFor() {
      
      votedFor_ = 0;
      onChanged();
      return this;
    }

    private long firstLogIndex_ ;
    /**
     * <code>optional uint64 first_log_index = 3;</code>
     */
    public long getFirstLogIndex() {
      return firstLogIndex_;
    }
    /**
     * <code>optional uint64 first_log_index = 3;</code>
     */
    public Builder setFirstLogIndex(long value) {
      
      firstLogIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 first_log_index = 3;</code>
     */
    public Builder clearFirstLogIndex() {
      
      firstLogIndex_ = 0L;
      onChanged();
      return this;
    }

    private long commitIndex_ ;
    /**
     * <code>optional uint64 commit_index = 4;</code>
     */
    public long getCommitIndex() {
      return commitIndex_;
    }
    /**
     * <code>optional uint64 commit_index = 4;</code>
     */
    public Builder setCommitIndex(long value) {
      
      commitIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 commit_index = 4;</code>
     */
    public Builder clearCommitIndex() {
      
      commitIndex_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:onlytest.LogMetaData)
  }

  // @@protoc_insertion_point(class_scope:onlytest.LogMetaData)
  private static final io.grpc.justtest.LogMetaData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.justtest.LogMetaData();
  }

  public static io.grpc.justtest.LogMetaData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogMetaData>
      PARSER = new com.google.protobuf.AbstractParser<LogMetaData>() {
    public LogMetaData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LogMetaData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LogMetaData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogMetaData> getParserForType() {
    return PARSER;
  }

  public io.grpc.justtest.LogMetaData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

