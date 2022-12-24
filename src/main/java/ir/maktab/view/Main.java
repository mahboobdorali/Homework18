package ir.maktab.view;

import ir.maktab.entity.Account;
import ir.maktab.entity.Person;
import ir.maktab.exception.AccountException;
import ir.maktab.service.PersonService;
import ir.maktab.service.impl.PersonImpl;
import ir.maktab.service.impl.ServiceImpl;
import ir.maktab.validation.AccountValidation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Account account = new Account();
  /*  private static ServiceImpl instance=ServiceImpl.getInstance();
    private static PersonImpl personImpl= PersonImpl.getInstance();*/

    private static ServiceImpl service = new ServiceImpl();
    private static PersonImpl personImpl = new PersonImpl();

    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        String name;
        String family;
        do {
            System.out.println("Enter your  name : ");
            name = scanner.nextLine();

            System.out.println("Enter your family: ");
            family = scanner.nextLine();


            System.out.println("Enter your card number : ");
            String cardNumber = scanner.nextLine();
            try {
                AccountValidation.validCardNumber(cardNumber);
                account.setCardNumber(cardNumber);
                break;
            } catch (AccountException e) {
                System.out.println("Card number should be 16 ! ");
            }
        } while (true);
        System.out.println("Enter your account number : ");
        String accountNumber = scanner.nextLine();
        account.setAccountNumber(accountNumber);

        System.out.println("Enter your opening date : ");
        LocalDate openingDate = getDate();
        Date opening = Date.from(openingDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        account.setOpeningDate(opening);

        System.out.print("Your expire date is : ");
        LocalDate date = openingDate.plusYears(4);
        Date expire = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        account.setExpiryDate(expire);
        System.out.println(expire);

        System.out.println("Enter your amount : ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.setAmount(amount);

        System.out.print("your cvv2 is : ");
        int min = 1000;
        int max = 9999;
        account.setCvv2((int) (Math.random() * (max - min + 1) + min));
        System.out.println(account.getCvv2());
        System.out.println("enter your type of account :");
        String type = scanner.nextLine();
        System.out.println("account opening :" + type + "\tfor\t" + name + family);
        try {
            System.out.println(service.getAccount(account.getCardNumber(), accountNumber, opening, expire, amount,
                    account.getCvv2(), type));
        } catch (AccountException e) {
            throw new RuntimeException(e);
        }
        try {
            service.create(account);
        } catch (AccountException e) {
            throw new RuntimeException(e);
        }
        accountList.add(account);
        Person person = new Person(accountList, name, family);
        personImpl.create(person);

    }

    public static LocalDate getDate() {
        System.out.println("enter year : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("enter month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("enter day:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

}



