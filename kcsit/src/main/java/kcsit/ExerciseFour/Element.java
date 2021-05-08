package kcsit.ExerciseFour;

import java.util.Objects;

class Element {

    private final int id;

    private final String content;


    public Element(int value) {

        this.id = value;

        this.content = "Data " + value;

    }


    public int getId() {

        return id;

    }


    public String getContent() {

        return content;

    }


    @Override

    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        return id == element.id && Objects.equals(content, element.content);

    }


    @Override

    public int hashCode() {

        return Objects.hash(id, content);

    }

}
