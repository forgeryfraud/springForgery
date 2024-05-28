
package com.examly.springapp.service;

import com.examly.springapp.model.Transaction;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.TransactionRepository;
import com.examly.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    
    @Autowired
     TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;
    

    public Transaction createTransactionForUser(int userId, Transaction transaction) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            transaction.setUser(user);
            return transactionRepository.save(transaction);
        }
        return null;
    }

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getTransactionsByUserId(int userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction updateTransaction(int id, Transaction transaction) {
        if (transactionRepository.existsById(id)) {
            transaction.setId(id);
            return transactionRepository.save(transaction);
        }
        return null;
    }

    public boolean deleteTransaction(int id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
