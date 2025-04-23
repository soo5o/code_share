package test.day06;

import java.util.Objects;

public class MaleCelebrity implements Celebrity {
    private String name;

    public MaleCelebrity(String name) throws InvalidNameException {
        if (!name.matches("^[가-힣]{2,10}$")) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "남자 연예인: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaleCelebrity)) return false;
        MaleCelebrity that = (MaleCelebrity) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
