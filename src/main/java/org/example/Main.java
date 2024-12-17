package org.example;

import org.apache.commons.lang3.builder.DiffResult;

public class Main {
    public static void main(String[] args) {
        final Item item1 = new Item();
        item1.setName("Name");
        item1.setValue("Brian");
        item1.setActive(Boolean.TRUE);

        final Item item2 = new Item();
        item2.setName("Name");
        item2.setValue("Ben");
        item2.setActive(Boolean.TRUE);

        final Item item3 = new Item();
        item3.setName("name");
        item3.setValue("Ben");
        item3.setActive(Boolean.FALSE);

        final Item item4 = new Item();
        item4.setName("Name");
        item4.setValue(null);
        item1.setActive(null);

        DiffResult<Item> diff1 = item1.diff(item1);
        System.out.println("Same: num of diffs = " + diff1.getNumberOfDiffs() + "\n" + diff1);
        DiffResult<Item> diff2 = item2.diff(item3);
        System.out.println("Name and active only: num of diffs = " + diff2.getNumberOfDiffs() + "\n" + diff2 + "\n");
        DiffResult<Item> diff3 = item1.diff(item2);
        System.out.println("Value and active only: num of diffs = " + diff3.getNumberOfDiffs() + "\n" + diff3 + "\n");
        DiffResult<Item> diff4 = item1.diff(item3);
        System.out.println("All: num of diffs = " +  + diff4.getNumberOfDiffs() + "\n" + diff4 + "\n");
        DiffResult<Item> diff5 = item1.diff(item4);
        System.out.println("Null: num of diffs = " +  + diff5.getNumberOfDiffs() + "\n" + diff5 + "\n");
        DiffResult<Item> diff6 = item4.diff(item1);
        System.out.println("Null (inverse): num of diffs = " +  + diff6.getNumberOfDiffs() + "\n" + diff6 + "\n");
    }
}