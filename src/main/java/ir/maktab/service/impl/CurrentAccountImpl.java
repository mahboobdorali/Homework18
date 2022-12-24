package ir.maktab.service.impl;

import ir.maktab.entity.CurrentAccount;
import ir.maktab.repository.CurrentAccountRepository;
import ir.maktab.repository.PersonRepository;
import ir.maktab.service.CurrentAccountService;

public class CurrentAccountImpl implements CurrentAccountService {
   /* private static CurrentAccountImpl instance = new  CurrentAccountImpl();

    private  CurrentAccountImpl() {
    }
    public static  CurrentAccountImpl getInstance() {
        return instance;
    }
    private static CurrentAccountService currentAccountService= (CurrentAccountService) CurrentAccountRepository.getInstance();*/

  CurrentAccountRepository currentAccountRepository=new CurrentAccountRepository();
    @Override
    public void create(CurrentAccount currentAccount) {
       currentAccountRepository.create(currentAccount);
    }
}
