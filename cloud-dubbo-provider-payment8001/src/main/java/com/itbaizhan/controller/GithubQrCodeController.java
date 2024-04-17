package com.itbaizhan.controller;


import com.github.hui.quick.plugin.qrcode.wrapper.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.imageio.*;
import javax.servlet.http.*;

import java.awt.image.*;

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
      BufferedImage bufferedImage = QrCodeGenWrapper.of(url).asBufferedImage();
      ImageIO.write(bufferedImage,"png",response.getOutputStream());
    }catch (Exception e) {
      e.printStackTrace();
    }
    return  null;
  }

}
