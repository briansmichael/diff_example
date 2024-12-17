package org.example;

import lombok.Data;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class Item implements Diffable<Item> {

    private String name;

    private String value;

    private Boolean active;

    @Override
    public DiffResult<Item> diff(final Item other) {
        return new DiffBuilder.Builder<Item>()
                .setLeft(this)
                .setRight(other)
                .setStyle(ToStringStyle.JSON_STYLE)
                .setToStringFormat("Original: %s\n New: %s")
                .build()
                .append("name", getName(), other.getName())
                .append("value", getValue(), other.getValue())
                .append("active", getActive(), other.getActive())
                .build();
    }
}
