package com.itbaizhan.controller;


import com.github.hui.quick.plugin.qrcode.wrapper.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.imageio.*;
import javax.servlet.http.*;

import java.awt.image.*;
import java.io.*;

/**
 * @author yaozeyu
 */
@Controller
public class GithubQrCodeController {

  /**
   * 编写请求跳转到使用qrcode生成二维码的页面
   */
  @GetMapping("/qrcode")
  public String toQrCode() {
    return "github-qrcode";
  }

  @PostMapping("/generateWithQrCode")
  public String generateWithQrCode(@RequestParam("url") String url, HttpServletResponse response, HttpServletRequest request) {
    try {
      InputStream inputStream = request.getPart("logo").getInputStream();
      BufferedImage bufferedImage = QrCodeGenWrapper.of(url).setLogo(inputStream).setLogoRate(7).setLogoStyle(QrCodeOptions.LogoStyle.ROUND).asBufferedImage();
      ImageIO.write(bufferedImage,"png",response.getOutputStream());
      inputStream.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
    return  null;
  }

}
