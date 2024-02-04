package com.example.personmanagementsystem.repository;

import com.example.personmanagementsystem.entity.Person;

import java.util.Iterator;
import java.util.List;

public class PersonRepository {

    public void insert(Person person) {
        if (Data.list.contains(person)) {
            System.out.println("Already exists");
        } else {
            Data.list.add(person);
        }
    }

    public void update(Person person) {

        int index = Data.list.indexOf(person);
        if (index != -1) {
            Data.list.set(index, person);
        }else {
            System.out.println("not found");
        }
    }

    public void delete(String nationalCode) {
        Iterator<Person> iterator = Data.list.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getNationalCode().equals(nationalCode)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Person> select(){
        return Data.list;
    }
}
