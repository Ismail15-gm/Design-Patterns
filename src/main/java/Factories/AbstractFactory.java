package Factories;

import Interfaces.Factory;

public abstract class AbstractFactory {
    public abstract Factory createFactory(String... data);
}
