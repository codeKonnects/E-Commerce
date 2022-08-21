package io.codeKonnects.ecommerce.exception;

public class CartItemNotExistException extends Exception{
    public CartItemNotExistException(String message) {
        super(message);
    }
}
