import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetOperationsTest {
    SetOperations test = new SetOperations();

    @BeforeEach
    void setUp() {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("dog");
        s2.add("cat");
    }

    @org.junit.jupiter.api.Test
    void Union() {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("dog");
        s2.add("cat");
        Set<String> s3 = test.Union(s1, s2);
        System.out.println(s3);

    }

    @org.junit.jupiter.api.Test
    void Intersection() {
    }


}