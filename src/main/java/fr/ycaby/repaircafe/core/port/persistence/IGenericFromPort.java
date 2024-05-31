package fr.ycaby.repaircafe.core.port.persistence;

import java.util.List;

public interface IGenericFromPort<U,T> {
    List<T> getFrom(U u);

    boolean isFromExist(U u, T o);

    T updateFrom(U u, T o);

    T createFrom(U u, T o);

    T removeFrom(U u, T o);
}
