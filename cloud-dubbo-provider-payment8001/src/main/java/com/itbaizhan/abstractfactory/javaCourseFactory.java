package com.itbaizhan.abstractfactory;

public class javaCourseFactory implements CourseFactory{
  @Override
  public Vedio getVideo() {
    return new JavaVideo();
  }

  @Override
  public Article getArticle() {
    return new JavaArticle();
  }
}
