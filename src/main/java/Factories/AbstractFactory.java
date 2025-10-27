package Factories;

import entites.Factory;

import java.util.List;

public abstract class AbstractFactory {

    public abstract Factory createFactory(String... data);
}
