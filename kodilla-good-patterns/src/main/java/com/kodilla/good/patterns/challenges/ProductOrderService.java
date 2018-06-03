package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProductList(), orderRequest.getDateOfOrder());
        if(isOrdered) {
            informationService.inform(orderRequest.getUser(), orderRequest.getProductList());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProductList(),  orderRequest.getDateOfOrder());
            return new OrderDto(orderRequest.getUser(), orderService.getMapOfOrderedProducts(), orderService.isAllProductsAvailable(), orderService.isUserExist(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderService.getMapOfOrderedProducts(), orderService.isAllProductsAvailable(), orderService.isUserExist(), false);
        }
    }
}
