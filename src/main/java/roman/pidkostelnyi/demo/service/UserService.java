package roman.pidkostelnyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.pidkostelnyi.demo.dto.request.UserRequest;
import roman.pidkostelnyi.demo.entity.Cart;
import roman.pidkostelnyi.demo.entity.Product;
import roman.pidkostelnyi.demo.entity.User;
import roman.pidkostelnyi.demo.repository.CartRepository;
import roman.pidkostelnyi.demo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public void create(UserRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());

        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        user.setCart(cart);

        if (request.getFavoritesIds() != null) {
            List<Product> collect = request.getFavoritesIds().stream()
                    .map(productService::findOne)
                    .collect(Collectors.toList());
            user.setFavorites(collect);
        }

        userRepository.save(user);
    }

}
