package ru.Entity.AndroidAnnotation;

public @interface DatabaseField {
    boolean generatedId() default false;
    boolean foreignAutoRefresh() default false;
    boolean canBeNull() default true;
    boolean foreign() default false;
}