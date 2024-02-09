package com.example.dp_spring_backend.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(Long id) {super(String.format("Car with id %d not found",id));}
}