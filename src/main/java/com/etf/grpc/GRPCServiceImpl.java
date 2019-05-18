package com.etf.grpc;

import com.etf.grpc.test.*;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class GRPCServiceImpl
        extends GRPCServiceGrpc.GRPCServiceImplBase {

    private final String STRING_VALUE = "EXAMPLE";
    private final String STRING_DESCRIPTION = "THIS IS EXAMPLE DESCRIPTION FOR TESTING PERFORMANCE OF PROTOCOLS";

    @Override
    public void test(EmptyValue request,
                         StreamObserver<EmptyValue> responseObserver) {
        EmptyValue emptyValue = EmptyValue.newBuilder().build();
        responseObserver.onNext(emptyValue);
        responseObserver.onCompleted();
    }

    @Override
    public void getString(EmptyValue request,
                          StreamObserver<StringValue> responseObserver) {
        StringValue stringValue = StringValue.newBuilder().setValue(STRING_VALUE).build();
        responseObserver.onNext(stringValue);
        responseObserver.onCompleted();
    }

    @Override
    public void getSimpleObject(EmptyValue request,
                                StreamObserver<SimpleModel> responseObserver) {
        SimpleModel simpleObject = getSimpleModel();
        responseObserver.onNext(simpleObject);
        responseObserver.onCompleted();
    }

    @Override
    public void getComplexObject(EmptyValue request,
                                 StreamObserver<ComplexModel> responseObserver) {
        ComplexModel complexObject = getComplexModel();
        responseObserver.onNext(complexObject);
        responseObserver.onCompleted();
    }

    private SimpleModel getSimpleModel() {
        return SimpleModel.newBuilder()
                .setId(Long.MAX_VALUE)
                .setActive(true)
                .setAmount(Long.MIN_VALUE)
                .setName(STRING_VALUE)
                .setDescription(STRING_DESCRIPTION)
                .build();
    }

    private ComplexModel getComplexModel() {
        List<Double> doubleList = new ArrayList<Double>();
        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            doubleList.add(new Double(1.01));
            stringList.add(STRING_VALUE);
        }

        return ComplexModel.newBuilder()
                .addAllNumbers(doubleList)
                .addAllStrings(stringList)
                .build();
    }

}
