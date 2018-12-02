package com.zmyjn.core.util;

import com.zmyjn.core.util.jwt.JwtHelper;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SessionUtil {

    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);


    @Value("${audience.base64Secret}")
    private static String base64Secret;


    private static Map<String, Object> parseToken(String token) throws Exception {
        if(base64Secret == null){
            base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
        }
        token = token.substring(7);
        Claims claims = JwtHelper.parseJWT(token,base64Secret);
        String json = claims.toString();
        GsonJsonParser gsonJsonParser = new GsonJsonParser();
        Map<String, Object> map = gsonJsonParser.parseMap(json);
        return map;
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    public static Map<String,Object> getLoginUserInfo(){

        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  ra.getRequest();

        Map<String,Object>map=new HashMap<String,Object>();
        String userId=null;
        String userName = null;
        String nickName = null;
        String mobile = null;
        String token = request.getHeader("access_token");
        if(token!=null && !token.equals("")) {
            try {
                Map<String, Object> tokenInfo = parseToken(token);
                userId = (String)tokenInfo.get("userId");
                userName = (String)tokenInfo.get("userName");
                nickName = (String)tokenInfo.get("nickName");
                mobile = (String)tokenInfo.get("mobile");
            } catch (Exception e) {
                logger.error("系统登录超时，请重新登录！");
            }
        }
        map.put("userId", userId);
        map.put("userName", userName);
        map.put("nickName", nickName);
        map.put("mobile", mobile);
        return map;
    }


    /**
     * 获取当前登录用户Id
     * @return
     */
    public static Integer getLoginUserId(){

        ServletRequestAttributes ra= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  ra.getRequest();

        Map<String,String>map=new HashMap<String,String>();
        Integer userId=null;
        String token = request.getHeader("access_token");
        if(token!=null && !token.equals("")) {
            try {
                Map<String, Object> tokenInfo = parseToken(token);
                double d = (double)tokenInfo.get("userId");
                userId = Integer.valueOf(Math.round(d) + "");
//                userId = Integer.valueOf(tokenInfo.get("userId") + "");
            } catch (Exception e) {
                logger.error("系统登录超时，请重新登录！");
            }
        }
        return userId;
    }

}
