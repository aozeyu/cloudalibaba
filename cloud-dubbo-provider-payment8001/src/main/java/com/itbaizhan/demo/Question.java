package com.itbaizhan.demo;

import java.util.*;

public class Question {
  private String questionText;
  private List<String> options;
  private String correctAnswer;

  public Question(String text, List<String> options, String correctAnswer) {
    this.questionText = text;
    this.options = options;
    this.correctAnswer = correctAnswer;
  }

  public String getQuestionText() {
    return questionText;
  }

  public List<String> getOptions() {
    return options;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }
}
