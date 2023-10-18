package com.sarmexin.postman.annotation;

import java.lang.annotation.*;

/**
 * @author Sergey Gavrilov
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WithLogging {

    String service();

}

/**
 * Аннотация @Target позволяет ограничить область применения:
 *
 * @Target(ElementType.PACKAGE) – только для пакетов;
 * @Target(ElementType.TYPE) – только для классов;
 * @Target(ElementType.CONSTRUCTOR) – только для конструкторов;
 * @Target(ElementType.METHOD) – только для методов;
 * @Target(ElementType.FIELD) – только для атрибутов(переменных) класса;
 * @Target(ElementType.PARAMETER) – только для параметров метода;
 * @Target(ElementType.LOCAL_VARIABLE) – только для локальных переменных;
 * @Target(ElementType.ANNOTATION_TYPE) - означает аннотацию конфигурацию. Таким образом, аннотация может использоваться только для аннотирования других аннотаций. Как @Target и @Retention.
 *
 * @Retention определяет в каком жизненном цикле кода аннотация будет доступна.
 *
 * @SOURCE - аннотация доступна только в исходном коде и стирается во время создания .class файла;
 * @CLASS - аннотация хранится и в .class файле, но недоступна во время выполнения программы;
 * @RUNTIME - аннотация хранится в .class файле и доступна во время выполнения программы.
 *
 * @Documented - аннотация будет помещена в сгенерированную документацию javadoc
 */
