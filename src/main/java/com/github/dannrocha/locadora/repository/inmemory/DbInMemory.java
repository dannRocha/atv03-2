package com.github.dannrocha.locadora.repository.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DbInMemory<T> {

    protected Integer contador = 0;
    protected List<T> db = new ArrayList<>();

}


