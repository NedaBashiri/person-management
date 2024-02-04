package com.example.personmanagementsystem.repository;

import com.example.personmanagementsystem.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class PersonRepository {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class);

    public void insert(Person person) {
        if (Data.list.contains(person)) {
            LOGGER.info(person.getFirstName() + ": Already exists");
        } else {
            Data.list.add(person);
            LOGGER.info(person.getFirstName() + ": Successfully saved");
        }
    }

    public void update(Person person) {

        int index = Data.list.indexOf(person);
        if (index != -1) {
            Data.list.set(index, person);
            LOGGER.info(person.getFirstName() + ": Successfully updated");
        }else {
            LOGGER.info("'" + person.getFirstName() + "' not found in the list.");
        }
    }

    public void delete(String nationalCode) {
        Iterator<Person> iterator = Data.list.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getNationalCode().equals(nationalCode)) {
                iterator.remove();
                LOGGER.info(person.getFirstName()+ ": Successfully deleted.");
                break;
            }
        }
    }

    public List<Person> select(){
        return Data.list;
    }
}
