package com.itbaizhan.controller;


import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.decoder.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.imageio.*;
import javax.servlet.http.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * @author yaozeyu
 */
@Slf4j
@Controller
public class LogoCodeController {
  /**
   * 跳转到生成带logo的黑白二维码
   */

  @GetMapping("/logo")
  public String toLogo() {
    return "qrcode";
  }

  /**
   * 生成带logo的黑白二维码
   */
  @PostMapping("/generateWithLogo")
  public String generateWithLogo(@RequestParam("url") String url, HttpServletResponse response, HttpServletRequest request) {
    try {
      Map map = new HashMap();
      map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
      map.put(EncodeHintType.CHARACTER_SET, "utf-8");
      map.put(EncodeHintType.MARGIN, 1);
      MultiFormatWriter writer = new MultiFormatWriter();
      BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 300, 300, map);
      int width = bitMatrix.getWidth();
      int height = bitMatrix.getHeight();
      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
        }
      }
      //给二维码添加logo
      //1.获取logo
      Part logoPart = request.getPart("logo");
      InputStream inputStream = logoPart.getInputStream();
      BufferedImage logoImage = ImageIO.read(inputStream);
      //2.对获取的logo图片进行缩放
      int logoWidth = logoImage.getWidth(null);
      int logoHeight = logoImage.getHeight(null);
      if (logoWidth > 60){
        logoWidth = 60;
      }
      if (logoHeight > 60){
        logoHeight = 60;
      }
      //使用平滑缩放算法对原始的logo图像进行缩放到一个全新的图像
      Image scaledLogo  = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
      //3.将缩放的图片画在黑白的二维码上
      //获取一个画笔
      Graphics2D graphics2D = image.createGraphics();
      //计算从哪里开始画 300指的是二维码的宽度和高度
      int x = (300 - logoWidth) /2;
      int y = (300 - logoHeight) /2;
      //画上去
      graphics2D.drawImage(scaledLogo,x,y,null);
      //实现logo的圆角效果
      Shape shape = new RoundRectangle2D.Float(x, y, logoWidth, logoHeight, 10, 10);
      //使用一个宽度为4像素的基本笔触
      graphics2D.setStroke(new BasicStroke(4f));
      //给logo画圆角矩形
      graphics2D.draw(shape);
      graphics2D.dispose();

      //将二维码响应到浏览器
      ImageIO.write(image, "png", response.getOutputStream());
      inputStream.close();

    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


}
