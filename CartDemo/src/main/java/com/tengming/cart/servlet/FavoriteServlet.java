package com.tengming.cart.servlet;

import com.tengming.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class FavoriteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/favorite/favorite.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (productId != null) {
                LocalCache.addFavoriteProduct(LocalCache.getProduct(Long.valueOf(productId)));
            }
            resp.sendRedirect("/favorite/list.do");
        } else if (Objects.equals("/favorite/delete.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (productId != null){
                LocalCache.delFavorite(LocalCache.getProduct(Long.valueOf(productId)));
            }
            resp.sendRedirect("/favorite/list.do");
        } else if (Objects.equals("/favorite/list.do", req.getServletPath())) {
            req.setAttribute("products", LocalCache.getFavoriteProduct());
            req.getRequestDispatcher("/favorite.jsp").forward(req, resp);
        }
    }
}
