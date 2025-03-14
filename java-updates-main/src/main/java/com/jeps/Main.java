package com.jeps;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

//        var random = new Random();
//        int randomInt = random.nextInt(100); // number between 0 and 99
//        System.out.println("Random number: " + randomInt);

        var randomGenerator = RandomGenerator.of("Xoshiro256PlusPlus");
        int randomInt = randomGenerator.nextInt(1, 100); // number between 1 and 99
        System.out.println("Random number: " + randomInt);

        var payment1 = new Card("1234567812345678");
        var payment2 = new Pix("michelli@email.com");
        describePayment(payment2);
        printPaymentInfo(payment2);

        var pixRecordDto = new PixRecordDto("michellli@email.com", 90.99);
        printPixInfo(pixRecordDto);

//        String query = "SELECT id, name, email\n" +
//                "FROM tb_users\n" +
//                "WHERE status = 'active'\n" +
//                "ORDER BY id;";
//        System.out.println(query);

        String query = """
            SELECT id, name, email
            FROM tb_users
            WHERE status = 'active'
            ORDER BY name;
            """;
        System.out.println(query);

    }

    static void describePayment(Payment payment) {
        switch (payment) {
            case Card c -> System.out.println("Payment by Card!");
            case Pix p -> System.out.println("Payment by Pix!");
        }
    }

//    static void printPaymentInfo(Payment payment) { //step 1
//        if (payment instanceof Card) {
//            Card c = (Card) payment;
//            System.out.println("Payment by Card number: " + c.getCardNumber().substring(c.getCardNumber().length()-4));
//        } else if (payment instanceof Pix) {
//            Pix p = (Pix) payment;
//            System.out.println("Payment by Pix key: " + p.getPixKey());
//        }
//    }

//    static void printPaymentInfo(Payment payment) { //step 2
//        if (payment instanceof Card c) {
//            System.out.println("Payment by Card number: " + c.getCardNumber().substring(c.getCardNumber().length()-4));
//        } else if (payment instanceof Pix p) {
//            System.out.println("Payment by Pix key: " + p.getPixKey());
//        }
//    }

    static void printPaymentInfo(Payment payment) { //step 3
        switch (payment) {
            case Card c -> System.out.println("Payment by Card number: " + c.getCardNumber().substring(c.getCardNumber().length()-4));
            case Pix p -> System.out.println("Payment by Pix key: " + p.getPixKey());
            default -> System.out.println("Unknown payment type!");
        }
    }

//    public static void printPixInfo(Object object) {
//        if (object instanceof PixRecordDto pixRecordDto){
//            String keyPix = pixRecordDto.key();
//            double valuePix = pixRecordDto.value();
//            System.out.println("Pix Info: key=" + keyPix + ", value=" + valuePix);
//        }
//    }

    public static void printPixInfo(Object object) {
        if (object instanceof PixRecordDto(String keyPix, double valuePix)) {
            System.out.println("Pix Info: key=" + keyPix + ", value=" + valuePix);
        }
    }

}