package com.itbaizhan.abstractfactory;

public class PythodCourseFactory implements CourseFactory{
  @Override
  public Vedio getVideo() {
    return new PythodVideo();
  }

  @Override
  public Article getArticle() {
    return new PythodArticle();
  }
}
