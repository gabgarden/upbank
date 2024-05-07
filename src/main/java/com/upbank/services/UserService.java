package com.upbank.services;

import com.upbank.domain.user.User;
import com.upbank.domain.user.UserType;
import com.upbank.dtos.UserDTO;
import com.upbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception
    {
        if (sender.getUserType() == UserType.MERCHANT)
        {
            throw new Exception("Usuário do tipo lojista não está autorizado a realizar transação.");
        }

        if (sender.getBalance().compareTo(amount) < 0)
        {
            throw new Exception("Usuário com saldo indisponpivel.");
        }
    }



    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO data)
    {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    public void saveUser(User user)
    {
        this.userRepository.save(user);
    }

}
