package com.example.samfisher.dagger2.data;

/**
 * Created by Samfisher on 07/10/2017.
 */

public interface EntityDataMapper<T, V> {

    V transform(T t);
}
