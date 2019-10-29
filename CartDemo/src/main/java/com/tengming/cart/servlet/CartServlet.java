package com.tengming.cart.servlet;

import com.tengming.cart.data.Cart;
import com.tengming.cart.data.LocalCache;
import com.tengming.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/cart/cart.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (productId != null) {
                System.out.println(req.getServletPath());
                LocalCache.addCart(LocalCache.getProduct(Long.valueOf(productId)));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/delete.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (productId != null) {
                LocalCache.delCard(LocalCache.getProduct(Long.valueOf(productId)));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/incr.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (productId != null) {
                LocalCache.addOneCount(LocalCache.getProduct(Long.valueOf(productId)));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/decr.do", req.getServletPath())) {
            String productId = req.getParameter("productId");
            if (productId != null) {
                LocalCache.delOneCount(LocalCache.getProduct(Long.valueOf(productId)));
            }
            resp.sendRedirect("/cart/list.do");
        } else if (Objects.equals("/cart/settlement.do", req.getServletPath())) {
            String[] cartIds = req.getParameterValues("carts");
            int totalPrice = 0;
            for (int i = 0; i < cartIds.length; i++) {
                Cart cart = LocalCache.getCart(Long.valueOf(cartIds[i]));
                totalPrice += cart.getTotalPrice();
                LocalCache.delCart(cart.getId());
            }
            req.setAttribute("totalPrice", totalPrice);
            req.getRequestDispatcher("/settlement.jsp").forward(req, resp);
        } else if (Objects.equals("/cart/list.do", req.getServletPath())) {
            req.setAttribute("carts", LocalCache.getCarts());
            System.out.println(req.getServletPath());
            req.getRequestDispatcher("/cart.jsp").forward(req, resp);
        } else if (Objects.equals("/cart/settle.do", req.getServletPath())) {
            req.getRequestDispatcher("/settlement.jsp").forward(req, resp);
        }
    }
}
