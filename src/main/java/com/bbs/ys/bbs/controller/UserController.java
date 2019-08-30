package com.bbs.ys.bbs.controller;



import com.bbs.ys.bbs.empty.User;
import com.bbs.ys.bbs.service.RoleService;
import com.bbs.ys.bbs.service.Role_perService;
import com.bbs.ys.bbs.service.UserService;
import com.bbs.ys.bbs.service.User_roleService;
import com.bbs.ys.bbs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    Role_perService role_perService;

    @Autowired
    User_roleService user_roleService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * redis存放三次错误登陆 <>
     * @param tel
     * @param password
     * @return
     */


//    @RequestMapping("/list")
//    public List<Map<String, Object>> userList() {
//        String sql = "select tel,password from user ";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        return list;
//    }



    @RequestMapping("/login")
    @ResponseBody

    public String login1(String tel,String password) {
        System.out.println("tel is:"+tel);
        System.out.println("password is:"+password);
         password=MD5Utils.getMD5(password);
        String sql = "select COUNT(*) as num from user where tel=? and password=?";

        //String   password1 = jdbcTemplate.queryForObject(sql, new MyRowMapper(), tel,password);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,tel,password);
        System.out.println("list"+list);
        Object a=null;
        for(int i=0;i<list.size();i++){
          Object o =  list.get(i).get("num");
            System.out.println(o);
        }

        for(Map<String,Object> map : list){
            Iterator<String> it=  map.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                System.out.println(map.get(key));
                a=map.get(key);
            }
        }
        System.out.println(a);

        if(a==null ){
            System.out.println("tel is:"+tel+password+"登录成功");
            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
                    return jsonStr;
        }else{
            System.out.println("tel is:"+tel+password+"登录失败");
            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"登录失败！\"}";
            return jsonStr;}
    }







//    /**
//     * 通过JDBC来实现
//     * @param tel
//     * @param password
//     * @return
//     */
//    @RequestMapping("/login")
//    @ResponseBody
//    public String login3(User user) {
//        String tel =user.getTel();
//        String password=MD5Utils.getMD5(user.getPassword());
//
//        System.out.println("tel is:"+user.getTel());
//        System.out.println("password is:"+user.getPassword());
//
//        System.out.println("tel is:"+tel);
//        System.out.println("password is:"+password);
//
//        List<Map<String, Object>> list = userList();
//    int count=0;
//    int count1=0;
//    int count2=0;
//
//        for(Map<String,Object> map : list){
//            Iterator<String> it=  map.keySet().iterator();
//            while(it.hasNext()){
//                String key = it.next();
//                System.out.println(count);
//                System.out.println(map.get(key));
//                count++;
//                if(tel==map.get(key)){
//                    count1=count;
//                    System.out.println(count1);
//                }
//                if(password==map.get(key)){
//                    count2 =count;
//                    System.out.println(count2);
//                }
//
//                if( count1+1==count2 ){
//                    break;
//                  }
//        }
//    }
//
//        if( count1+1==count2 ){
//            System.out.println("tel is:"+user.getTel()+user.getPassword()+"登录成功33");
//            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//            return jsonStr;}else
//        {
//            System.out.println("tel is:"+user.getTel()+user.getPassword()+"登录失败33");
//            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"登陆失败！\"}";
//            return jsonStr;
//        }
//
//    }
//
//
//

//    /**
//     //     *通过 @PathVariable来接收获取路径中的参数
//     //     * @param tel
//     //     * @param password
//     //     * @return
//     //     */
//    @RequestMapping(value="/login/{tel}/{password}",method=RequestMethod.GET)
//    public String login4(@PathVariable String tel,@PathVariable String password) {
//        System.out.println("tel is:"+tel);
//        System.out.println("password is:"+password);
//        if( tel.equals("15958596961") && password.equals("123456") ){
//            System.out.println("tel is:"+tel+password+"登录成功22");
//            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//            return jsonStr;
//        }else{
//            System.out.println("tel is:"+tel+password+"登录失败22");
//            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"登录失败！\"}";
//            return jsonStr;}
//    }
//







//    /**
//     * 通过@通过一个bean来接收获取路径中的参数
//     * @param tel
//     * @param password
//     * @return
//     */
//    @RequestMapping("/login")
//    @ResponseBody
//    public String login3(User user) {
//        System.out.println("tel is:"+user.getTel());
//        System.out.println("password is:"+user.getPassword());
//        if( (user.getTel()).equals("15958596961") && (user.getPassword()).equals("123456") ){
//            System.out.println("tel is:"+user.getTel()+user.getPassword()+"登录成功33");
//            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//            return jsonStr;
//        }else{
//            System.out.println("tel is:"+user.getTel()+user.getPassword()+"登录失败33");
//            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"登录失败！\"}";
//            return jsonStr;}
//    }
//
//


//
//    @RequestMapping("/login")
//    @ResponseBody
//
//
//
//    /**
//     * 2、通过HttpServletRequest接收
//     * @param request
//     * @return
//     */
//    public String login2(HttpServletRequest request) {
//        String tel=request.getParameter("tel");
//        String password=request.getParameter("password");
//        System.out.println("tel is:"+tel);
//        System.out.println("password is:"+password);
//        if( tel.equals("15958596961") && password.equals("123456") ){
//            System.out.println("tel is:"+tel+password+"登录成功22");
//            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//            return jsonStr;
//        }else{
//            System.out.println("tel is:"+tel+password+"登录失败22");
//            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"登录失败！\"}";
//            return jsonStr;}
//    }
//
//
//



//    /**
//     *写死的登录方式
//     * 直接把表单的参数写在Controller相应的方法的形参中
//     * @param tel
//     * @param password
//     * @return
//     */

//
//    @RequestMapping("/login")
//    @ResponseBody
//
//    public String login1(String tel,String password) {
//        System.out.println("tel is:"+tel);
//        System.out.println("password is:"+password);
//        if( tel.equals("15958596961") && password.equals("123456") ){
//            System.out.println("tel is:"+tel+password+"登录成功");
//            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//                    return jsonStr;
//        }else{
//            System.out.println("tel is:"+tel+password+"登录失败");
//            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"登录失败！\"}";
//            return jsonStr;}
//    }
//
//









    /**
     * redis存放三次错误登陆 <>
     * @param tel
     * @param password
     * @param request
     * @return
     *用注解@RequestParam绑定请求参数到方法入参
     */


//
//    @RequestMapping("/login")
//    @ResponseBody
//
//    public String losgin(@RequestParam(value="tel") String tel, @RequestParam(value="password") String password, HttpServletRequest request){
//
//        User user=new User();
//        user.setTel(tel);
//        user.setPassword(password);
//
//        //判断用户是否在数据库里，如果User不为空，则账号密码在数据库中有相应的匹配，即用户存在
//        User t_user=userService.selectUserByTel(tel);
//
//        if(t_user==null){
//            String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"该用户不存在\"}";
//            return jsonStr;
//        }
//
//        User rs_user=userService.selectUser(tel,password);
//
//        int count=redisTemplate.opsForValue().get("错误登陆"+tel)==null?
//                0:(int)redisTemplate.opsForValue().get("错误登陆"+tel);
//        if (rs_user!=null&&count<3){
//            HttpSession session=request.getSession();
//            session.setAttribute("rs_user", rs_user);
//            redisTemplate.delete("错误登陆"+tel);
//            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//            return jsonStr;
//        }
//        else if(count>=3){
//            String jsonStr = "{\"errorCode\":\"33\",\"errorMessage\":\"您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！\"}";
//            count++;
//            redisTemplate.opsForValue().set("错误登陆"+tel,count,180, TimeUnit.SECONDS);
//            return jsonStr;
//        }
//        else{
//            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"密码输入错误，错误输入三次后您的账户将会被锁定！\"}";
//            count++;
//            //这里的作用主要是考虑到用户只输错一次，在很长一段时间（姑且认为是一分钟至三分钟内）没有再次登陆，
//            //为了用户的体验，决定在这个时候将其错误登陆记录清除
//            redisTemplate.opsForValue().set("错误登陆"+tel,count,60,TimeUnit.SECONDS);
//            return jsonStr;
//        }
//    }

    /**
     * 关于redis中存放验证码：
     * 生成验证码，在redis中存入<tel,验证码>
     * @param nickname
     * @param tel
     * @param volidate
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam(value = "nickname")String nickname,@RequestParam(value="tel") String tel, @RequestParam(value = "volidate")String volidate, @RequestParam(value="password")String password, HttpServletRequest request){

        User user=userService.selectUserByTel(tel);
        if(!redisTemplate.hasKey(tel)||redisTemplate.opsForValue().get(tel).equals(volidate)) {
            System.out.println("voalidate为"+volidate+"  ,yzm为："+redisTemplate.opsForValue().get(tel));
            System.out.println("验证码错误*****");
            String jsonStr = "{\"errorCode\":\"2\",\"errorMessage\":\"验证码错误\"}";

            return jsonStr;
        }
        else {
            if(user==null) {

                System.out.println("进如此循环");
                userService.addUser(nickname,tel,password);
                User user1=userService.selectUserByTel(tel);
                int user_id=user1.getId();
                user_roleService.add(user_id,3);

                String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"success\"}";

                return  jsonStr;
            }
            else
            {
                System.out.println("未进如此循环");
                String jsonStr = "{\"errorCode\":\"0\",\"errorMessage\":\"phone or password is error\"}";
                return jsonStr;
            }
        }
    }

}

