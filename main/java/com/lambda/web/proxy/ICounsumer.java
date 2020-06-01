package com.lambda.web.proxy;

import org.springframework.stereotype.Component;

// @Component 컴포넌트도 필요없다. 아래꺼쓰면
@FunctionalInterface
public interface ICounsumer<T> {  // 서비스임플 안만들어도됨
    public void accept(T t);

}
