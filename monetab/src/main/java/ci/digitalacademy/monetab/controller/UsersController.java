package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @GetMapping
    public String showUsersPage(Model model) {
        log.debug("Request to show users page");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/add")
    public String showUsersAddPage(Model model) {
        log.debug("Request to show users add page");
        model.addAttribute("user", new User());
        return "users/forms";
    }

    @PostMapping
    public String saveUser(User user) {
        log.debug("Request to save user {}", user);
        user.setCreationDate(Instant.now());
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String updateUserForms(Model model, @PathVariable Long id) {
        log.debug("Request to update user {}", id);

        Optional<User> user = userService.findOne(id);

        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "users/forms";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        log.debug("Request to delete user {}", id);
        userService.delete(id);
        return "redirect:/users";
    }
}
