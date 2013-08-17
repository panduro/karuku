package org.karuku;

import generated.CompositeExpression;
import generated.Modifier;
import generated.Operation;
import generated.PrimitiveExpression;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.karuku.client.CalculatorClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/16/13
 * Time: 4:43 PM
 */
public class IntegrationTest {
    private static CalculatorClient client;

    final static Lock lock = new ReentrantLock();
    final static Condition serverReady  = lock.newCondition();

    private static class ServerThread extends Thread {
        Process serverProcess;

        @Override
        public void run() {
            lock.lock();

            try {
                //spawn server process

                //some directory magick: when testing in maven, the working directory is directory of client,
                //but in IDEA it is main project root.
                String workingDir = System.getProperty("user.dir");
                String serverDir = workingDir.endsWith("client") ? ".." : ".";

                serverProcess = Runtime.getRuntime()
                        .exec("java -cp "+serverDir+"/server/target/dependency/*:"+serverDir+"/server/target/classes/ org.karuku.service.Main");

                BufferedReader stdInput = new BufferedReader(new
                        InputStreamReader(serverProcess.getInputStream()));

                String s;
                while(true) {
                    s = stdInput.readLine();
                    System.out.println("[SERVER] "+ s);
                    if (s.contains("Jersey started")) {
                        serverReady.signal();
                        lock.unlock();
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void stopGracefully() {
            serverProcess.destroy();
        }
    }

    private static ServerThread server = new ServerThread();

    @BeforeClass
    public static void init() throws IOException, InterruptedException {

         server.start();

        lock.lock();
        try {
            //wait until Jersey server is started.
            serverReady.await();

            client = CalculatorClient.createInstance();
        }
        finally {
            lock.unlock();
        }
    }

    @AfterClass
    public static void shutdown() {
        server.stopGracefully();
    }

    @Test
    public void testSimpleSum() {
        //2+4=6
        PrimitiveExpression operand1 = new PrimitiveExpression();
        operand1.setAbsoluteValue(4l);
        operand1.setModifier(Modifier.PLUS);

        PrimitiveExpression operand2 = new PrimitiveExpression();
        operand2.setAbsoluteValue(2l);
        operand2.setModifier(Modifier.PLUS);

        CompositeExpression sum = new CompositeExpression();
        sum.setFirstOperand(operand1);
        sum.setSecondOperand(operand2);
        sum.setOperation(Operation.PLUS);

        PrimitiveExpression result = client.evaluate(sum);

        Assert.assertEquals(result.getAbsoluteValue(), new Long(6l));
        Assert.assertEquals(result.getModifier(), Modifier.PLUS);
    }


    @Test
    public void testSimpleMul() {
        //5*(-2) = 10
        PrimitiveExpression operand1 = new PrimitiveExpression();
        operand1.setAbsoluteValue(5l);
        operand1.setModifier(Modifier.PLUS);

        PrimitiveExpression operand2 = new PrimitiveExpression();
        operand2.setAbsoluteValue(2l);
        operand2.setModifier(Modifier.MINUS);

        CompositeExpression sum = new CompositeExpression();
        sum.setFirstOperand(operand1);
        sum.setSecondOperand(operand2);
        sum.setOperation(Operation.MULTIPLY);

        PrimitiveExpression result = client.evaluate(sum);

        Assert.assertEquals(result.getAbsoluteValue(), new Long(10l));
        Assert.assertEquals(result.getModifier(), Modifier.MINUS);
    }


    @Test
    public void testMoreComplexExpression() {
        //((20-(-10) / (-3+6)) * 2 + 3 = 23
        PrimitiveExpression twenty = new PrimitiveExpression();
        twenty.setAbsoluteValue(20l);
        twenty.setModifier(Modifier.PLUS);

        PrimitiveExpression minusTen = new PrimitiveExpression();
        minusTen.setAbsoluteValue(10l);
        minusTen.setModifier(Modifier.MINUS);

        CompositeExpression twentyMinusMinusTen = new CompositeExpression();
        twentyMinusMinusTen.setFirstOperand(twenty);
        twentyMinusMinusTen.setSecondOperand(minusTen);
        twentyMinusMinusTen.setOperation(Operation.MINUS);

        PrimitiveExpression minusThree = new PrimitiveExpression();
        minusThree.setAbsoluteValue(3l);
        minusThree.setModifier(Modifier.MINUS);

        PrimitiveExpression six = new PrimitiveExpression();
        six.setAbsoluteValue(6l);
        six.setModifier(Modifier.PLUS);

        CompositeExpression minusThreePlusSix = new CompositeExpression();
        minusThreePlusSix.setFirstOperand(minusThree);
        minusThreePlusSix.setSecondOperand(six);
        minusThreePlusSix.setOperation(Operation.PLUS);

        CompositeExpression tmmtDivideMtps = new CompositeExpression();
        tmmtDivideMtps.setFirstOperand(twentyMinusMinusTen);
        tmmtDivideMtps.setSecondOperand(minusThreePlusSix);
        tmmtDivideMtps.setOperation(Operation.DIVIDE);

        PrimitiveExpression two = new PrimitiveExpression();
        two.setAbsoluteValue(2l);
        two.setModifier(Modifier.PLUS);

        CompositeExpression tdmMultiplyTwo = new CompositeExpression();
        tdmMultiplyTwo.setFirstOperand(tmmtDivideMtps);
        tdmMultiplyTwo.setSecondOperand(two);
        tdmMultiplyTwo.setOperation(Operation.MULTIPLY);

        PrimitiveExpression three = new PrimitiveExpression();
        three.setAbsoluteValue(3l);
        three.setModifier(Modifier.PLUS);

        CompositeExpression tmtPlusThree = new CompositeExpression();
        tmtPlusThree.setFirstOperand(tdmMultiplyTwo);
        tmtPlusThree.setSecondOperand(three);
        tmtPlusThree.setOperation(Operation.PLUS);

        PrimitiveExpression result = client.evaluate(tmtPlusThree);

        Assert.assertEquals(new Long(23l), result.getAbsoluteValue());
        Assert.assertEquals(result.getModifier(), Modifier.PLUS);
    }

}
