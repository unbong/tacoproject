package com.example.tacoproject;

import com.example.tacoproject.Data.OrderRepository;
import com.example.tacoproject.Secure.UserForm;
import com.example.tacoproject.Web.OrderPros;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


import javax.validation.Valid;

@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes(names = "order")
public class OrderController {

    private final OrderRepository _orderRepository ;
    private OrderPros _orderPros;



     @ModelAttribute(name = "order")
    public Order order()
    {
        return new Order();
    }

    public OrderController(OrderRepository orderRepository, OrderPros orderPors)
    {
        this._orderRepository = orderRepository;
        this._orderPros = orderPors;
    }

    @GetMapping("/current")
    public String orderForm(Model model)
    {
       return "OrderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors error, SessionStatus sessionStatus)
    {
        if(error.hasErrors()) return "OrderForm";

        log.info("order Submited" + order);

        _orderRepository.save(order);

        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String orderFomr(@AuthenticationPrincipal UserForm user , Model model)
    {
        Pageable pageable = PageRequest.of(0,_orderPros.getPagesize());
        //model.addAttribute("order", _orderRepository.findByUserOrderByPlacedAtDesc(user.getUsername(), pageable));

        return "orderList";

    }

}
