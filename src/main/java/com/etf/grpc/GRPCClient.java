package com.etf.grpc;

import javax.annotation.PostConstruct;

import com.etf.grpc.test.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GRPCClient {

  private static final int NUMBER_OF_ITERATIONS = 100;
  private static final double MS = 1000000.0;

  private GRPCServiceGrpc.GRPCServiceBlockingStub gRPCServiceBlockingStub;

  @PostConstruct
  private void init() {
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 6565).usePlaintext().build();

    gRPCServiceBlockingStub =
        GRPCServiceGrpc.newBlockingStub(managedChannel);
  }

  public void test() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    gRPCServiceBlockingStub.test(emptyValue);
  }

  public List<Double> getStringExecutionTimes() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    List<Double> serviceCallsDurations = new ArrayList<>();

    for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
      long startTime = System.nanoTime();
      gRPCServiceBlockingStub.getString(emptyValue);
      long endTime = System.nanoTime();
      long totalTime = endTime - startTime;
      serviceCallsDurations.add(totalTime / MS);
    }

    return serviceCallsDurations;
  }

  public Double getStringObjectAsyncTime() {
    List<Integer> iterations = IntStream.of(new int[NUMBER_OF_ITERATIONS])
            .boxed()
            .collect(Collectors.toList());
    long startTime = System.nanoTime();
    iterations.parallelStream()
            .map(iteration -> getStringsAsync())
            .collect(Collectors.toList());
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    return totalTime / MS;
  }

  public List<Double> getSimpleObjectExecutionTimes() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    List<Double> serviceCallsDurations = new ArrayList<>();

    for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
      long startTime = System.nanoTime();
      gRPCServiceBlockingStub.getSimpleObject(emptyValue);
      long endTime = System.nanoTime();
      long totalTime = endTime - startTime;
      serviceCallsDurations.add(totalTime / MS);
    }

    return serviceCallsDurations;
  }

  public Double getSimpleObjectAsyncTime() {
    List<Integer> iterations = IntStream.of(new int[NUMBER_OF_ITERATIONS])
            .boxed()
            .collect(Collectors.toList());
    long startTime = System.nanoTime();
    iterations.parallelStream()
            .map(iteration -> getSimpleObjectAsync())
            .collect(Collectors.toList());
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    return totalTime / MS;
  }

  public List<Double> getComplexObjectExecutionTimes() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    List<Double> serviceCallsDurations = new ArrayList<>();

    for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
      long startTime = System.nanoTime();
      gRPCServiceBlockingStub.getComplexObject(emptyValue);
      long endTime = System.nanoTime();
      long totalTime = endTime - startTime;
      serviceCallsDurations.add(totalTime / MS);
    }

    return serviceCallsDurations;
  }

  public Double getComplexObjectAsyncTime() {
    List<Integer> iterations = IntStream.of(new int[NUMBER_OF_ITERATIONS])
            .boxed()
            .collect(Collectors.toList());
    long startTime = System.nanoTime();
    iterations.parallelStream()
            .map(iteration -> getComplexObjectAsync())
            .collect(Collectors.toList());
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    return totalTime / MS;
  }

  private CompletableFuture<StringValue> getStringsAsync() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    return CompletableFuture.supplyAsync(() -> gRPCServiceBlockingStub.getString(emptyValue))
            .exceptionally(x -> {
              System.out.print(x.getLocalizedMessage());
              return null;
            });
  }

  private CompletableFuture<SimpleModel> getSimpleObjectAsync() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    return CompletableFuture.supplyAsync(() -> gRPCServiceBlockingStub.getSimpleObject(emptyValue))
            .exceptionally(x -> {
              System.out.print(x.getLocalizedMessage());
              return null;
            });
  }

  private CompletableFuture<ComplexModel> getComplexObjectAsync() {
    EmptyValue emptyValue = EmptyValue.newBuilder().build();
    CompletableFuture<ComplexModel> complexModel = CompletableFuture.supplyAsync(() -> gRPCServiceBlockingStub.getComplexObject(emptyValue))
            .exceptionally(x -> {
              System.out.print(x.getLocalizedMessage());
              return null;
            });
    return complexModel;
  }
}
