package com.patika.kredinbizdenservice.serive;

import com.patika.kredinbizdenservice.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public boolean addUser(User user) {
        // E-mail adresi kontrolü
        for (User existingUser : users) {
            if (existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                System.out.println("Bu e-mail adresi zaten kullanımda.");
                return false;
            }
        }
        users.add(user);
        return true;
    }

}
