package org.nipu.po.order;

import org.nipu.po.order.clients.ProductSpecificationRepository;
import org.nipu.po.order.exception.FallbackException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: This is autogenerated Java-Doc.
 *
 * @author Nikita_Puzankov
 */
@RestController
public class OrderController {
    private final ProductOrderRepository orderRepository;
    private final ProductSpecificationRepository specificationRepository;

    public OrderController(ProductOrderRepository orderRepository, ProductSpecificationRepository specificationRepository) {
        this.orderRepository = orderRepository;
        this.specificationRepository = specificationRepository;
    }

    @PutMapping("/catalog/{specificationId}/order")
    public ProductOrder orderProductBySpecificationId(@PathVariable String specificationId) {
        ProductSpecificationTO result = specificationRepository.findById(specificationId);
        if (result == null) {
            throw new FallbackException("There is no such product or product catalog service is currently unavailable." +
                                        " Specification with Id: " + specificationId);
        }
        return orderRepository.save(new ProductOrder(null, specificationId, 1l));
    }
}
