package com.tangwh.SpringIoc;

import com.tangwh.reflect_Demo.MyAnnotation_Test;

public class Question {
    private String titile;
    private String answer;

    @MyAnnotation_Test({"我的标题","我的答案"})
    public Question() {

    }

    public Question(String titile, String answer) {
        this.titile = titile;
        this.answer = answer;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {

        return "Question{" + "titile='" + titile + '\'' + ", answer='" + answer + '\'' + '}';
    }
}
