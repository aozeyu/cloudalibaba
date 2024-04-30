package com.itbaizhan.abstractfactory;

public class Test {
  public static void main(String[] args) {
    javaCourseFactory javaCourseFactory = new javaCourseFactory();
    Vedio vedio = javaCourseFactory.getVideo();
    Article article = javaCourseFactory.getArticle();

    vedio.produce();
    article.produce();

  }
}
