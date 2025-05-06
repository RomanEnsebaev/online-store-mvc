package edu.epam.fop.controller;
import edu.epam.fop.CartItem;
import edu.epam.fop.dao.user.UserDAO;
import edu.epam.fop.entity.Order;
import edu.epam.fop.entity.OrderItem;
import edu.epam.fop.entity.User;
import edu.epam.fop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
@SessionAttributes("cart")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDAO userDAO;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String viewOrders(Model model, Authentication auth) {
        User user = userDAO.findByUsername(auth.getName());
        model.addAttribute("orders", orderService.getOrdersByUserId(user.getId()));
        return "orders";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/place")
    public String placeOrder(@SessionAttribute("cart") List<CartItem> cart,
                             Authentication auth,
                             SessionStatus status) {

        if (cart == null || cart.isEmpty()) {
            return "redirect:/cart";
        }

        User user = userDAO.findByUsername(auth.getName());

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cart) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getProduct().getPrice());
            total = total.add(orderItem.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            order.getItems().add(orderItem);
        }
        order.setTotal(total);

        orderService.placeOrder(order);
        status.setComplete(); // clear cart session

        return "redirect:/orders";
    }
}