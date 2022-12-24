package ir.maktab.service.impl;

import ir.maktab.entity.ShortTermAccount;
import ir.maktab.repository.ShortTermAccountRepository;
import ir.maktab.service.ShortTermAccountService;

public class ShortTermAccountImpl implements ShortTermAccountService{
  //  private static ShortTermAccountService instance= (ShortTermAccountService) ShortTermAccountRepository.getInstance();


    ShortTermAccountRepository shortTermAccountRepository=new ShortTermAccountRepository();
    @Override
    public void create(ShortTermAccount shortTermAccount) {
       shortTermAccountRepository.create(shortTermAccount);
    }
}
