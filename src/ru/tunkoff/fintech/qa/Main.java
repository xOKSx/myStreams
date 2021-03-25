package ru.tunkoff.fintech.qa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
        final int limit = 4;
        final int majority = 18;

        // Способ №1 (более понятный).
        Map<String, List<Boy>> groupedBoys =
                boys.stream()
                        .collect(Collectors.groupingBy(Boy::getName));

        Map<String, Integer> namesakes1 = boys.stream()
                .filter(boy -> boy.getAge() >= majority)
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(limit)
                .collect(Collectors.toMap(name -> name, name -> groupedBoys.get(name).size() - 1));
        System.out.println(namesakes1);

        // Способ №2 (вложенные стримы).
        Map<String, Integer> namesakes2 = boys.stream()
                .filter(boy -> boy.getAge() >= majority)
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(limit)
                .collect(Collectors.toMap(
                        name -> name,
                        name -> (int) boys.stream()
                                .filter(boyName -> boyName.getName().equals(name)).count() - 1));
        System.out.println(namesakes2);
    }
}
