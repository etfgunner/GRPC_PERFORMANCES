package com.etf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.etf.grpc.GRPCClient;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {

    @Autowired
    private GRPCClient GRPCClient;

    @Test
    public void test() {
        GRPCClient.test();
    }

    @Test
    public void getStringExecutionTimesTest() {
        File file = new File("GRPCExecutionTimesString.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            GRPCClient.getStringExecutionTimes()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringAsyncTimingTest() {
        File file = new File("GRPCExecutionTimesStringAsync.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Double executionTime = GRPCClient.getStringObjectAsyncTime();
            writer.write(executionTime.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSimpleObjectExecutionTimesTest() {
        File file = new File("GRPCExecutionTimesSimpleObject.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            GRPCClient.getSimpleObjectExecutionTimes()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleObjectAsyncTimingTest() {
        File file = new File("GRPCExecutionTimeSimpleObjectAsync.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Double executionTime = GRPCClient.getSimpleObjectAsyncTime();
            writer.write(executionTime.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getComplexObjectExecutionTimes() {
        File file = new File("GRPCExecutionTimesComplexObject.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            GRPCClient.getComplexObjectExecutionTimes()
                    .stream()
                    .forEach(x -> {
                        try {
                            writer.write(x.toString() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void complexObjectAsyncTimingTest() {
        File file = new File("GRPCExecutionTimeComplexObjectAsync.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Double executionTime = GRPCClient.getComplexObjectAsyncTime();
            writer.write(executionTime.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
