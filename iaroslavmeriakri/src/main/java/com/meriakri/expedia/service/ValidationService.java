package com.meriakri.expedia.service;
public interface ValidationService<V>  {
    boolean validate(V value);
}