package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());

        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-100));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(200));
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertTrue(BankAccount.isEmailValid("a@b.co"));
        assertTrue(BankAccount.isEmailValid("a.@b.com"));

        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("@b.com"));
        assertFalse(BankAccount.isEmailValid("@com"));
        assertFalse(BankAccount.isEmailValid("ab.@com"));
        assertFalse(BankAccount.isEmailValid("a@b.c"));
        assertFalse(BankAccount.isEmailValid("a@b.comm"));
        assertFalse(BankAccount.isEmailValid("a$@b.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}