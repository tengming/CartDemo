package com.tengming.cart.servlet;

import com.tengming.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class ProductServlet extends HttpServlet {



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.equals("/list.do",req.getServletPath())){
            req.setAttribute("products",LocalCache.getProducts());
            req.setAttribute("jb","haha");
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }else if (Objects.equals("/test.do",req.getServletPath())){
            req.setAttribute("tt","第二个页面");
            req.getRequestDispatcher("/test.jsp").forward(req,resp);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
