package com.itpainter.web.servlet;

import com.itpainter.dao.CanteenDao;
import com.itpainter.domain.*;
import com.itpainter.service.VisitorService;
import com.itpainter.service.impl.VisitorServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/visitor/*")
public class VisitorServlet extends BaseServlet {

    //声明Service业务对象
    private VisitorService service = new VisitorServiceImpl();

    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //UserService userService = new UserServiceImpl();
        Integer flag = service.regist(user);
        Info info = new Info();
        //4.响应结果
        if (flag == null) {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!已经有人用这个用户名或手机号了");
        } else if (flag == 0) {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("服务器拥挤，稍后再来");
        } else {
            //注册成功
            info.setFlag(true);
            info.setErrorMsg("注册成功");
        }
        writeValue(info, response);
    }

    /**
     * 登录功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        String user_telephone = request.getParameter("user_telephone");
        String user_password = request.getParameter("user_password");
        if (user_password==null||user_telephone==null){
            Info info = new Info();
            info.setErrorMsg("请输入完整的信息");
            writeValue(info, response);
        }
        //2.封装User对象
        User user = new User();
        user.setUser_telephone(user_telephone);
        user.setUser_password(user_password);
        //3.调用Service查询
        User u = service.login(user);

        Info info = new Info();

        //4.判断用户对象是否为null
        if (u == null) {
            //用户名密码或错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //5.判断登录成功
        if (u != null) {
            request.getSession().setAttribute("visitoruser", u);//登录成功标记
            //登录成功
            info.setFlag(true);
            info.setErrorMsg("登录成功");
            //response.sendRedirect("http://localhost:8083/canteen/pages/order/order.wxml");
        }
        System.out.println(u);
        writeValue(info, response);
    }

    public void windows(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取食堂位置
        String canteen = request.getParameter("canteen");
        //获取楼层信息
        String tier = request.getParameter("tier");
        //获取时间段
        String time = request.getParameter("time");

        if (canteen==null){
            canteen="新食堂";
        }
        if (tier==null){
            tier="一楼";
        }
        if (time==null){
            time="1";
        }
        //查询
        List<Windows> list = new CanteenDao().findAll(canteen,tier);
        Info info = new Info();
        info.setObjects(list.toArray());
        info.setFlag(true);
        Integer balance = new CanteenDao().findEmpty(canteen,tier,time);
        info.setData(balance+"");
        System.out.println(info.toString());
        writeValue(info,response);
    }

    public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String window_id = request.getParameter("window_id");
        List<food> list = service.menu(window_id);
        Info info =new Info();
        info.setObjects(list.toArray());
        info.setFlag(true);
        String window_name = service.findWName(window_id);
        info.setData(window_name);
        System.out.println(info.toString());
        writeValue(info,response);
    }

    public void submit(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(session != null){
            User user = (User) session.getAttribute("visitoruser");

            //订单信息
            OrderList orderList = new OrderList();
            orderList.setUser_id(user.);
        }
        throw new RuntimeException("未登录");
    }
}