package ir.maktab.service.impl;

import ir.maktab.entity.Person;
import ir.maktab.repository.AccountRepo;
import ir.maktab.repository.PersonRepository;
import ir.maktab.service.PersonService;
import ir.maktab.service.Service;

public class PersonImpl implements PersonService {
   /* private static PersonImpl instance = new  PersonImpl();

    private  PersonImpl() {
    }
    public static  PersonImpl getInstance() {
        return instance;
    }
    private static Service service= (Service) AccountRepo.getInstance();
    private static PersonService personService= (PersonService) PersonRepository.getInstance();
  */
   PersonRepository personRepository=new PersonRepository();
    @Override
    public void create(Person person) {
        personRepository.create(person);
    }
}
