package ru.tunkoff.fintech.qa;

public class Boy {
    private final String name;
    private final int age;

    Boy(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    @Override
    public final String toString() {
        return name + "-" + age;
    }
}
