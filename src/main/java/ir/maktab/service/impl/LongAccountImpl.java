package ir.maktab.service.impl;

import ir.maktab.entity.LongTermAccount;
import ir.maktab.repository.LongTermAccountRepository;
import ir.maktab.service.LongTermAccountService;

public class LongAccountImpl implements LongTermAccountService {
  /*  private static LongTermAccountService instance= (LongTermAccountService) LongTermAccountRepository.getInstance();*/

  LongTermAccountRepository longTermAccountRepository=new LongTermAccountRepository();
    @Override
    public void create(LongTermAccount longTermAccount) {
       longTermAccountRepository.create(longTermAccount);
    }
}
