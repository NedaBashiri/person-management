package com.example.personmanagementsystem.sevice;


import com.example.personmanagementsystem.entity.Person;
import com.example.personmanagementsystem.repository.PersonRepository;

import java.util.List;

public class PersonService {

    private PersonRepository personRepository = new PersonRepository();

    private static PersonService ourInstance = new PersonService();

    private PersonService() {
    }

    public static PersonService getInstance() {
        return ourInstance;
    }

     public void save (Person person){
         personRepository.insert(person);
     }

     public void update(Person person){
         personRepository.update(person);
     }

     public void delete(String nationalCode){
         personRepository.delete(nationalCode);
     }

     public List<Person> findAll(){
       return personRepository.select();
     }

}
