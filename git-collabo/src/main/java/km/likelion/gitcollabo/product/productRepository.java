package km.likelion.gitcollabo.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<productEntity, String> {
}
