package homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        System.out.println(cartService.getCurrentCart());
        cartService.addToCartByProductId(1L);
        cartService.addToCartByProductTitle("Bread");
        System.out.println(cartService.getCurrentCart());
        System.out.println();

        Cart cart2 = context.getBean(Cart.class);
        cartService.setCart(cart2);
        System.out.println(cartService.getCurrentCart());
        cartService.addToCartByProductId(3L);
        cartService.addToCartByProductId(4L);
        cartService.addToCartByProductId(4L);
        cartService.addToCartByProductTitle("Carrot");
        System.out.println(cartService.getCurrentCart());
        cartService.removeFromCartById(4L);
        cartService.removeFromCartByTitle("Carrot");
        System.out.println(cartService.getCurrentCart());

    }
}
