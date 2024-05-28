
package com.examly.springapp.controller;

import com.examly.springapp.model.Transaction;
import com.examly.springapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<Transaction> createTransactionForUser(@PathVariable("userId") int userId, @RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransactionForUser(userId, transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") int id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable("userId") int userId) {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        if (transactions == null || transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") int id, @RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
        if (updatedTransaction == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") int id) {
        boolean deleted = transactionService.deleteTransaction(id);
        if (!deleted) {
            return new ResponseEntity<>("Transaction not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
    }
}
