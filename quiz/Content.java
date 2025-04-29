package test.day08.quiz;

import java.util.Objects;

public class Content {
    private String question;

    public Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(question, content.question);
    }
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(question);
//    }

    @Override
    public String toString() {
        return question;
    }
}
