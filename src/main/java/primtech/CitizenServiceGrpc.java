package primtech;

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
    comments = "Source: src/main/proto/citizen.proto")
public final class CitizenServiceGrpc {

  private CitizenServiceGrpc() {}

  public static final String SERVICE_NAME = "primtech.CitizenService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<primtech.CitizenOuterClass.Void,
      primtech.CitizenOuterClass.Citizen> getGetCitizenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCitizen",
      requestType = primtech.CitizenOuterClass.Void.class,
      responseType = primtech.CitizenOuterClass.Citizen.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<primtech.CitizenOuterClass.Void,
      primtech.CitizenOuterClass.Citizen> getGetCitizenMethod() {
    io.grpc.MethodDescriptor<primtech.CitizenOuterClass.Void, primtech.CitizenOuterClass.Citizen> getGetCitizenMethod;
    if ((getGetCitizenMethod = CitizenServiceGrpc.getGetCitizenMethod) == null) {
      synchronized (CitizenServiceGrpc.class) {
        if ((getGetCitizenMethod = CitizenServiceGrpc.getGetCitizenMethod) == null) {
          CitizenServiceGrpc.getGetCitizenMethod = getGetCitizenMethod =
              io.grpc.MethodDescriptor.<primtech.CitizenOuterClass.Void, primtech.CitizenOuterClass.Citizen>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCitizen"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  primtech.CitizenOuterClass.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  primtech.CitizenOuterClass.Citizen.getDefaultInstance()))
              .setSchemaDescriptor(new CitizenServiceMethodDescriptorSupplier("GetCitizen"))
              .build();
        }
      }
    }
    return getGetCitizenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CitizenServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CitizenServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CitizenServiceStub>() {
        @java.lang.Override
        public CitizenServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CitizenServiceStub(channel, callOptions);
        }
      };
    return CitizenServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CitizenServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CitizenServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CitizenServiceBlockingStub>() {
        @java.lang.Override
        public CitizenServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CitizenServiceBlockingStub(channel, callOptions);
        }
      };
    return CitizenServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CitizenServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CitizenServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CitizenServiceFutureStub>() {
        @java.lang.Override
        public CitizenServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CitizenServiceFutureStub(channel, callOptions);
        }
      };
    return CitizenServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CitizenServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCitizen(primtech.CitizenOuterClass.Void request,
        io.grpc.stub.StreamObserver<primtech.CitizenOuterClass.Citizen> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCitizenMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCitizenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                primtech.CitizenOuterClass.Void,
                primtech.CitizenOuterClass.Citizen>(
                  this, METHODID_GET_CITIZEN)))
          .build();
    }
  }

  /**
   */
  public static final class CitizenServiceStub extends io.grpc.stub.AbstractAsyncStub<CitizenServiceStub> {
    private CitizenServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CitizenServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CitizenServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCitizen(primtech.CitizenOuterClass.Void request,
        io.grpc.stub.StreamObserver<primtech.CitizenOuterClass.Citizen> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCitizenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CitizenServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CitizenServiceBlockingStub> {
    private CitizenServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CitizenServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CitizenServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public primtech.CitizenOuterClass.Citizen getCitizen(primtech.CitizenOuterClass.Void request) {
      return blockingUnaryCall(
          getChannel(), getGetCitizenMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CitizenServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CitizenServiceFutureStub> {
    private CitizenServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CitizenServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CitizenServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<primtech.CitizenOuterClass.Citizen> getCitizen(
        primtech.CitizenOuterClass.Void request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCitizenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CITIZEN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CitizenServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CitizenServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CITIZEN:
          serviceImpl.getCitizen((primtech.CitizenOuterClass.Void) request,
              (io.grpc.stub.StreamObserver<primtech.CitizenOuterClass.Citizen>) responseObserver);
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

  private static abstract class CitizenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CitizenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return primtech.CitizenOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CitizenService");
    }
  }

  private static final class CitizenServiceFileDescriptorSupplier
      extends CitizenServiceBaseDescriptorSupplier {
    CitizenServiceFileDescriptorSupplier() {}
  }

  private static final class CitizenServiceMethodDescriptorSupplier
      extends CitizenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CitizenServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CitizenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CitizenServiceFileDescriptorSupplier())
              .addMethod(getGetCitizenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
