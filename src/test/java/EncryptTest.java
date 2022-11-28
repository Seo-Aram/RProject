import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/context/security-context.xml")
public class EncryptTest {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void passwordEncoding() {
        System.out.println(System.currentTimeMillis());
        String pw = "test";
        String encodedPw1 = passwordEncoder.encode(pw);
        String encodedPw2 = passwordEncoder.encode(pw);

        System.out.println("원본 : " + pw);
        System.out.println("첫번 째 인코딩 : " + encodedPw1);
        System.out.println("두번 째 인코딩 : " + encodedPw2);

        System.out.println("단순 문자열 비교 : "
                + encodedPw1.equals(passwordEncoder.encode("codevang")));
        System.out.println("passwordEncoder matches 비교 : "
                + passwordEncoder.matches(pw, passwordEncoder.encode("codevang")));


    }
}
