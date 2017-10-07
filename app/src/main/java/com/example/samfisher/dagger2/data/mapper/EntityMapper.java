package com.example.samfisher.dagger2.data.mapper;

import java.util.Collection;

/**
 * Created by deept on 07/10/2017.
 */

public interface EntityMapper<T, V> {

    V map(T t);

    Collection<V> mapCollection(Collection<T> t);
}
