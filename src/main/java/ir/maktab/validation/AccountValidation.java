package ir.maktab.validation;

import ir.maktab.exception.AccountException;

public class AccountValidation {
    public static void validCardNumber(String cardNumber) throws AccountException {
        if (!cardNumber.equals("") && cardNumber.matches("^[0-9]{16}"))
            return;
        throw new AccountException("شماره کارت معتبر نیست ");
    }
}
