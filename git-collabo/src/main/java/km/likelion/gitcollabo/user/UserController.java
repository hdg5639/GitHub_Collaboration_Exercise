package km.likelion.gitcollabo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
        UserDTO userDTO = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam Long id) {
        UserDTO userDTO = userService.getUser(id);
        return ResponseEntity.ok(userDTO);
    }

    @PatchMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        UserDTO userDTO = userService.updateUser(user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("삭제 성공");
    }
}
