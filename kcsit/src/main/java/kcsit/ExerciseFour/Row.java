package kcsit.ExerciseFour;

import java.util.Objects;

class Row {

    private final int id;

    private final String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Row(int value) {

        this.id = value;

        this.content = "Row " + value;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Row element = (Row) o;

        return id == element.id && Objects.equals(content, element.content);

    }


    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }
}

