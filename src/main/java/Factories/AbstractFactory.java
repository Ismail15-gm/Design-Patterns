package Factories;

import entites.interfaces.Factory;

public abstract class AbstractFactory {
    public abstract Factory createFactory(String... data);
}
