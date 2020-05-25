package primtech.tech;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: tech.proto")
public final class TechServiceGrpc {

  private TechServiceGrpc() {}

  public static final String SERVICE_NAME = "primtech.tech.TechService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<primtech.General.Void,
      primtech.General.Void> getGetTechMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTech",
      requestType = primtech.General.Void.class,
      responseType = primtech.General.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<primtech.General.Void,
      primtech.General.Void> getGetTechMethod() {
    io.grpc.MethodDescriptor<primtech.General.Void, primtech.General.Void> getGetTechMethod;
    if ((getGetTechMethod = TechServiceGrpc.getGetTechMethod) == null) {
      synchronized (TechServiceGrpc.class) {
        if ((getGetTechMethod = TechServiceGrpc.getGetTechMethod) == null) {
          TechServiceGrpc.getGetTechMethod = getGetTechMethod =
              io.grpc.MethodDescriptor.<primtech.General.Void, primtech.General.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTech"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  primtech.General.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  primtech.General.Void.getDefaultInstance()))
              .setSchemaDescriptor(new TechServiceMethodDescriptorSupplier("GetTech"))
              .build();
        }
      }
    }
    return getGetTechMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TechServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TechServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TechServiceStub>() {
        @java.lang.Override
        public TechServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TechServiceStub(channel, callOptions);
        }
      };
    return TechServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TechServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TechServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TechServiceBlockingStub>() {
        @java.lang.Override
        public TechServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TechServiceBlockingStub(channel, callOptions);
        }
      };
    return TechServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TechServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TechServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TechServiceFutureStub>() {
        @java.lang.Override
        public TechServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TechServiceFutureStub(channel, callOptions);
        }
      };
    return TechServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TechServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTech(primtech.General.Void request,
        io.grpc.stub.StreamObserver<primtech.General.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTechMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTechMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                primtech.General.Void,
                primtech.General.Void>(
                  this, METHODID_GET_TECH)))
          .build();
    }
  }

  /**
   */
  public static final class TechServiceStub extends io.grpc.stub.AbstractAsyncStub<TechServiceStub> {
    private TechServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TechServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TechServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTech(primtech.General.Void request,
        io.grpc.stub.StreamObserver<primtech.General.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTechMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TechServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TechServiceBlockingStub> {
    private TechServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TechServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TechServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public primtech.General.Void getTech(primtech.General.Void request) {
      return blockingUnaryCall(
          getChannel(), getGetTechMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TechServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TechServiceFutureStub> {
    private TechServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TechServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TechServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<primtech.General.Void> getTech(
        primtech.General.Void request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTechMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TECH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TechServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TechServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TECH:
          serviceImpl.getTech((primtech.General.Void) request,
              (io.grpc.stub.StreamObserver<primtech.General.Void>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TechServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TechServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return primtech.tech.Tech.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TechService");
    }
  }

  private static final class TechServiceFileDescriptorSupplier
      extends TechServiceBaseDescriptorSupplier {
    TechServiceFileDescriptorSupplier() {}
  }

  private static final class TechServiceMethodDescriptorSupplier
      extends TechServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TechServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TechServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TechServiceFileDescriptorSupplier())
              .addMethod(getGetTechMethod())
              .build();
        }
      }
    }
    return result;
  }
}
