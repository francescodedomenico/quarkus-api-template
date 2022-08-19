package it.template.model;

import java.util.Objects;

public class ExampleModel {
    String fieldA;
    String fieldB;


    public ExampleModel() {
    }

    public ExampleModel(String fieldA, String fieldB) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
    }

    public String getFieldA() {
        return this.fieldA;
    }

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    public String getFieldB() {
        return this.fieldB;
    }

    public void setFieldB(String fieldB) {
        this.fieldB = fieldB;
    }

    public ExampleModel fieldA(String fieldA) {
        setFieldA(fieldA);
        return this;
    }

    public ExampleModel fieldB(String fieldB) {
        setFieldB(fieldB);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ExampleModel)) {
            return false;
        }
        ExampleModel exampleModel = (ExampleModel) o;
        return Objects.equals(fieldA, exampleModel.fieldA) && Objects.equals(fieldB, exampleModel.fieldB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldA, fieldB);
    }

    @Override
    public String toString() {
        return "{" +
            " fieldA='" + getFieldA() + "'" +
            ", fieldB='" + getFieldB() + "'" +
            "}";
    }
    
}
