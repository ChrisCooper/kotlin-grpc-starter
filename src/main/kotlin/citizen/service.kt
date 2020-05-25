package citizen

import io.grpc.stub.StreamObserver
import primtech.CitizenOuterClass
import primtech.CitizenServiceGrpc

class CitizenService: CitizenServiceGrpc.CitizenServiceImplBase() {
    override fun getCitizen(
        request: CitizenOuterClass.Void,
        responseObserver: StreamObserver<CitizenOuterClass.Citizen>
    ) {
        val citizen: CitizenOuterClass.Citizen = CitizenOuterClass.Citizen.newBuilder().setId(12).setName("Bob").build()
        responseObserver.onNext(citizen)
        responseObserver.onCompleted()
    }
}
