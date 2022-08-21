package io.codeKonnects.ecommerce.controller;

import com.stripe.exception.StripeException;
//import com.stripe.model.checkout.Session;
import com.stripe.model.checkout.Session;
import io.codeKonnects.ecommerce.config.ApiResponse;
import io.codeKonnects.ecommerce.dto.cart.CheckoutItemDto;
import io.codeKonnects.ecommerce.dto.cart.StripeResponse;
import io.codeKonnects.ecommerce.exception.AuthenticationFailException;
import io.codeKonnects.ecommerce.exception.OrderNotFoundException;
import io.codeKonnects.ecommerce.model.Order;
import io.codeKonnects.ecommerce.model.User;
import io.codeKonnects.ecommerce.service.AuthenticationService;
import io.codeKonnects.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;
    // stripe create session API
    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
        // create the stripe session
        Session session= orderService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        // send the stripe session id in response
        return new ResponseEntity<StripeResponse>(stripeResponse, HttpStatus.OK);
    }
    // place order after checkout
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(@RequestParam("token") String token, @RequestParam("sessionId") String sessionId)
            throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        // place the order
        orderService.placeOrder(user, sessionId);
        return new ResponseEntity<>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        // get orders
        List<Order> orderDtoList = orderService.listOrders(user);

        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }
    // get orderitems for an order
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Integer id, @RequestParam("token") String token)
            throws AuthenticationFailException, OrderNotFoundException {
        // 1. validate token

        // validate token
        authenticationService.authenticate(token);

        // 2. find user

        // retrieve user
        User user = authenticationService.getUser(token);


        // 3. call getOrder method of order service an pass orderId and user

        Order order = orderService.getOrder(id, user);

        // 4. display order in json response

        return new ResponseEntity<>(order, HttpStatus.OK);

    }
}
