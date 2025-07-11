package km.likelion.gitcollabo.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .id(id)
                .userName(userName)
                .email(email)
                .password(password)
                .build();
    }
}
