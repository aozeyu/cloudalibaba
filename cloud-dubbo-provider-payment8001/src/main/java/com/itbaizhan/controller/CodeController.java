package com.itbaizhan.controller;


import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.decoder.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.imageio.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

/**
 * @author yaozeyu
 */
@Slf4j
@Controller
public class CodeController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/generate")
  public String generate(@RequestParam("url") String url, HttpServletResponse response) {
    log.info("文本内容:{}", url);
    try {
      Map map = new HashMap<>();
      map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
      map.put(EncodeHintType.CHARACTER_SET,"utf-8");
      map.put(EncodeHintType.MARGIN,1);
      //创建zxing的核心对象MultiFormatWriter (多格式写入器)
      //通过MultiFormatWriter对象来生成二维码
      MultiFormatWriter writer = new MultiFormatWriter();
      //参数一:内容
      //参数二:二维码格式
      //BarcodeFormat(码格式) QR_CODE ：常见的二维码格式之一，广泛应用于商品包装、扫码支付
      //AZTEC_CODE：高密度，可靠性很高 容错率更低 储存个人信息、证件信息、账户密码
      //PDF417 可以存储大量的信息 数据密度高 应用于航空机票、配送标签、法律文件
      //DATA_MATRIX: 小巧的二维码格式 编码格式类似于QR_CODE 但是优于QR_CODE 适合嵌入简单的产品标签 医疗图像 检测数据
      //参数三四:二维码的宽度和高度
      //参数五:二维码参数
      //位矩阵对象 （位矩阵对象对象的内部实际上是一个二位数组，二维数组中每一个元素是boolean类型 true代表黑色 false代表白色）
      BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 300, 300, map);
      //获取矩阵的宽度和高度
      int width = bitMatrix.getWidth();
      int height = bitMatrix.getHeight();
      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
      //遍历位矩阵对象
      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          //设置每一块的颜色值
          //0xFF000000表示黑色  0xFFFFFFFF表示白色
          image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
        }
      }
      //将图片响应到客户端
      ServletOutputStream outputStream = response.getOutputStream();
      ImageIO.write(image,"png",outputStream);
      outputStream.flush();
      outputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
