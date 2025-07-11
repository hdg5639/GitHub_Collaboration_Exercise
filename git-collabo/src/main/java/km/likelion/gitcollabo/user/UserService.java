package km.likelion.gitcollabo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO addUser(UserDTO user) {
        UserDTO userDTO = userRepository.save(UserEntity.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build())
                .toDTO();
        return userDTO;
    }

    public UserDTO getUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
        return user.toDTO();
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity user = userRepository.findById(userDTO.getId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user.toDTO();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
