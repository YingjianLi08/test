package com.zmyjn.sys.user.controller;

import com.zmyjn.core.constant.SessionConstants;
import com.zmyjn.core.log.LogUtil;
import com.zmyjn.core.util.VercodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description: 系统验证码
 * @author: Administrator
 * @date: 2018-11-16 10:08:00
 */
@RestController
@Api(value = "系统验证码",tags = "系统验证码接口")
@RequestMapping("sys/sysvercode")
public class SysVercodeController {

    private final LogUtil logger = LogUtil.getLogger(this.getClass());

    @GetMapping(value="/vercode")
    @ApiOperation(value = "获取验证码")
    public void vercode(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        VercodeUtil vercodeUtil = new VercodeUtil();
        //获取验证码图片
        BufferedImage image = vercodeUtil.getImage();
        //获取验证码内容
        String text = vercodeUtil.getText();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.SESSION_VERCODE_KEY, randomCode.toString());
        System.out.println("session-vercode==>"+randomCode.toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(image, "jpeg", sos);
        sos.flush();
        sos.close();
    }
}
