package review.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JunitTestTest {

    static JunitTest junitTest = null;

    @BeforeAll
    static void m1() {
        junitTest = new JunitTest();
        System.out.println("所有测试方法执行前:创建对象");
    }
    @AfterAll
    static void m2() {
        junitTest = null;
        System.out.println("所有方法执行后:释放对象");
    }

    @Test
    void getLevel() {
        assertEquals("不及格",junitTest.getLevel(52));
    }
    @Test
    void getLevel2() {
        assertEquals("差",junitTest.getLevel(62));
    }
    @Test
    void getLevel3() {
        assertEquals("中",junitTest.getLevel(72));
    }
    @Test
    void getLevel4() {
        assertEquals("良",junitTest.getLevel(82));
    }
    @Test
    void getLevel5() {
        assertEquals("优",junitTest.getLevel(92));
    }

    @Test
    void getLevel6() {
        assertThrows(IllegalArgumentException.class,() -> junitTest.getLevel(-6));
    }
}