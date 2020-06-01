package com.lambda.web.proxy;

@FunctionalInterface
public interface IPredicate<T> {
   boolean test( T t);

}
