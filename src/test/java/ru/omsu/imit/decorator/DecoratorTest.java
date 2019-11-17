package ru.omsu.imit.decorator;

import org.junit.Test;

public class DecoratorTest {
    @Test
    public void testDecorator() {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded =
                new CompressionDecorator(
                        new EncryptionDecorator(
                                new FileDataSource("target/encoded.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("target/encoded.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
