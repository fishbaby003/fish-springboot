// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg_user.proto

// Protobuf Java Version: 3.25.1
package com.fish.protobuf.entity;

/**
 *
 * @author fish
 */
public final class MessageUser {
  private MessageUser() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MessageUserLoginOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MessageUserLogin)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string access_token = 1;</code>
     * @return The accessToken.
     */
    java.lang.String getAccessToken();
    /**
     * <code>string access_token = 1;</code>
     * @return The bytes for accessToken.
     */
    com.google.protobuf.ByteString
        getAccessTokenBytes();

    /**
     * <code>string username = 2;</code>
     * @return The username.
     */
    java.lang.String getUsername();
    /**
     * <code>string username = 2;</code>
     * @return The bytes for username.
     */
    com.google.protobuf.ByteString
        getUsernameBytes();
  }
  /**
   * Protobuf type {@code MessageUserLogin}
   */
  public static final class MessageUserLogin extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:MessageUserLogin)
      MessageUserLoginOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MessageUserLogin.newBuilder() to construct.
    private MessageUserLogin(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MessageUserLogin() {
      accessToken_ = "";
      username_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new MessageUserLogin();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.fish.protobuf.entity.MessageUser.internal_static_MessageUserLogin_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.fish.protobuf.entity.MessageUser.internal_static_MessageUserLogin_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.fish.protobuf.entity.MessageUser.MessageUserLogin.class, com.fish.protobuf.entity.MessageUser.MessageUserLogin.Builder.class);
    }

    public static final int ACCESS_TOKEN_FIELD_NUMBER = 1;
    @SuppressWarnings("serial")
    private volatile java.lang.Object accessToken_ = "";
    /**
     * <code>string access_token = 1;</code>
     * @return The accessToken.
     */
    @java.lang.Override
    public java.lang.String getAccessToken() {
      java.lang.Object ref = accessToken_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        accessToken_ = s;
        return s;
      }
    }
    /**
     * <code>string access_token = 1;</code>
     * @return The bytes for accessToken.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getAccessTokenBytes() {
      java.lang.Object ref = accessToken_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        accessToken_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int USERNAME_FIELD_NUMBER = 2;
    @SuppressWarnings("serial")
    private volatile java.lang.Object username_ = "";
    /**
     * <code>string username = 2;</code>
     * @return The username.
     */
    @java.lang.Override
    public java.lang.String getUsername() {
      java.lang.Object ref = username_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        username_ = s;
        return s;
      }
    }
    /**
     * <code>string username = 2;</code>
     * @return The bytes for username.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      java.lang.Object ref = username_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(accessToken_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, accessToken_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(username_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, username_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(accessToken_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, accessToken_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(username_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, username_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.fish.protobuf.entity.MessageUser.MessageUserLogin)) {
        return super.equals(obj);
      }
      com.fish.protobuf.entity.MessageUser.MessageUserLogin other = (com.fish.protobuf.entity.MessageUser.MessageUserLogin) obj;

      if (!getAccessToken()
          .equals(other.getAccessToken())) return false;
      if (!getUsername()
          .equals(other.getUsername())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ACCESS_TOKEN_FIELD_NUMBER;
      hash = (53 * hash) + getAccessToken().hashCode();
      hash = (37 * hash) + USERNAME_FIELD_NUMBER;
      hash = (53 * hash) + getUsername().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.fish.protobuf.entity.MessageUser.MessageUserLogin prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * Protobuf type {@code MessageUserLogin}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MessageUserLogin)
        com.fish.protobuf.entity.MessageUser.MessageUserLoginOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.fish.protobuf.entity.MessageUser.internal_static_MessageUserLogin_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.fish.protobuf.entity.MessageUser.internal_static_MessageUserLogin_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.fish.protobuf.entity.MessageUser.MessageUserLogin.class, com.fish.protobuf.entity.MessageUser.MessageUserLogin.Builder.class);
      }

      // Construct using com.fish.protobuf.entity.MessageUser.MessageUserLogin.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        accessToken_ = "";
        username_ = "";
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.fish.protobuf.entity.MessageUser.internal_static_MessageUserLogin_descriptor;
      }

      @java.lang.Override
      public com.fish.protobuf.entity.MessageUser.MessageUserLogin getDefaultInstanceForType() {
        return com.fish.protobuf.entity.MessageUser.MessageUserLogin.getDefaultInstance();
      }

      @java.lang.Override
      public com.fish.protobuf.entity.MessageUser.MessageUserLogin build() {
        com.fish.protobuf.entity.MessageUser.MessageUserLogin result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.fish.protobuf.entity.MessageUser.MessageUserLogin buildPartial() {
        com.fish.protobuf.entity.MessageUser.MessageUserLogin result = new com.fish.protobuf.entity.MessageUser.MessageUserLogin(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(com.fish.protobuf.entity.MessageUser.MessageUserLogin result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.accessToken_ = accessToken_;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.username_ = username_;
        }
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.fish.protobuf.entity.MessageUser.MessageUserLogin) {
          return mergeFrom((com.fish.protobuf.entity.MessageUser.MessageUserLogin)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.fish.protobuf.entity.MessageUser.MessageUserLogin other) {
        if (other == com.fish.protobuf.entity.MessageUser.MessageUserLogin.getDefaultInstance()) return this;
        if (!other.getAccessToken().isEmpty()) {
          accessToken_ = other.accessToken_;
          bitField0_ |= 0x00000001;
          onChanged();
        }
        if (!other.getUsername().isEmpty()) {
          username_ = other.username_;
          bitField0_ |= 0x00000002;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                accessToken_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 18: {
                username_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private java.lang.Object accessToken_ = "";
      /**
       * <code>string access_token = 1;</code>
       * @return The accessToken.
       */
      public java.lang.String getAccessToken() {
        java.lang.Object ref = accessToken_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          accessToken_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string access_token = 1;</code>
       * @return The bytes for accessToken.
       */
      public com.google.protobuf.ByteString
          getAccessTokenBytes() {
        java.lang.Object ref = accessToken_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          accessToken_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string access_token = 1;</code>
       * @param value The accessToken to set.
       * @return This builder for chaining.
       */
      public Builder setAccessToken(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        accessToken_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>string access_token = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearAccessToken() {
        accessToken_ = getDefaultInstance().getAccessToken();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>string access_token = 1;</code>
       * @param value The bytes for accessToken to set.
       * @return This builder for chaining.
       */
      public Builder setAccessTokenBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        accessToken_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }

      private java.lang.Object username_ = "";
      /**
       * <code>string username = 2;</code>
       * @return The username.
       */
      public java.lang.String getUsername() {
        java.lang.Object ref = username_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          username_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string username = 2;</code>
       * @return The bytes for username.
       */
      public com.google.protobuf.ByteString
          getUsernameBytes() {
        java.lang.Object ref = username_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          username_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string username = 2;</code>
       * @param value The username to set.
       * @return This builder for chaining.
       */
      public Builder setUsername(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        username_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <code>string username = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearUsername() {
        username_ = getDefaultInstance().getUsername();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      /**
       * <code>string username = 2;</code>
       * @param value The bytes for username to set.
       * @return This builder for chaining.
       */
      public Builder setUsernameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        username_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:MessageUserLogin)
    }

    // @@protoc_insertion_point(class_scope:MessageUserLogin)
    private static final com.fish.protobuf.entity.MessageUser.MessageUserLogin DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.fish.protobuf.entity.MessageUser.MessageUserLogin();
    }

    public static com.fish.protobuf.entity.MessageUser.MessageUserLogin getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<MessageUserLogin>
        PARSER = new com.google.protobuf.AbstractParser<MessageUserLogin>() {
      @java.lang.Override
      public MessageUserLogin parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<MessageUserLogin> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MessageUserLogin> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.fish.protobuf.entity.MessageUser.MessageUserLogin getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessageUserLogin_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessageUserLogin_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016msg_user.proto\":\n\020MessageUserLogin\022\024\n\014" +
      "access_token\030\001 \001(\t\022\020\n\010username\030\002 \001(\tB\'\n\030" +
      "com.fish.protobuf.entityB\013MessageUserb\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_MessageUserLogin_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MessageUserLogin_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessageUserLogin_descriptor,
        new java.lang.String[] { "AccessToken", "Username", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
