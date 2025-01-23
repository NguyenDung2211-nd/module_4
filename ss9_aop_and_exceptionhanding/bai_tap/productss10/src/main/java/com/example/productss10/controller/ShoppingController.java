package com.example.productss10.controller;

import com.example.productss10.model.Cart;
import com.example.productss10.model.Product;
import com.example.productss10.service.ICartService;
import com.example.productss10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ShoppingController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService cartService;

    @ModelAttribute("cart")
    public Cart setup() {
        return new Cart();
    }

    @GetMapping("/shopping_cart")
    public ModelAndView showCart(@ModelAttribute("cart") Cart cart) {
        ModelAndView mav = new ModelAndView("/cart");
        mav.addObject("cart", cart);
        return mav;
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam("productId") int productId,
                             @RequestParam("quantity") int quantity,
                             @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(productId);
        if (productOptional.isPresent()) {
            cartService.updateProductQuantity(productOptional.get(), quantity, cart);
        }
        return "redirect:/shopping_cart";
    }

    @GetMapping("/cart/product/{id}")
    public ModelAndView viewProductDetail(@PathVariable int id, @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = cart.getProducts().keySet().stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        if (!productOptional.isPresent()) {
            return new ModelAndView("/error");
        }
        ModelAndView mav = new ModelAndView("/detail");
        mav.addObject("product", productOptional.get());
        mav.addObject("quantity", cart.getProducts().get(productOptional.get()));
        return mav;
    }

    @PostMapping("/delete")
    public String checkout(@ModelAttribute("cart") Cart cart, RedirectAttributes redirectAttributes) {
        if (cart.getProducts().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Cart is empty.");
            return "redirect:/shopping_cart";
        }
        cart.getProducts().clear();
        redirectAttributes.addFlashAttribute("message", "Delete successful!");
        return "redirect:/shop";
    }
}
