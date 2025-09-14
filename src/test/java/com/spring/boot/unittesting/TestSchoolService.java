package com.spring.boot.unittesting;

import org.junit.*;

import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;

public class TestSchoolService {
    private static SchoolService schoolService;
    private static School school;

    @BeforeClass
    public static void setup() {
        schoolService = new SchoolService();
        System.out.println("setup ..........");
    }

    @Before
    public void setUp() {
        school = new School();
        school.setName("BVB School");
        school.setAddress("BVB School");
        school.setPhoneNumber("+49 55 55 55 55");
        System.out.println("init school");
        System.out.println("setup school ..........");
    }

    @Test
    public void testAddSchool() {
        School newSchool = schoolService.addSchool(school);
        assertNotNull("Added school should return data not null ", newSchool);
    }

    @Test
    public void testGetSchool() {
        School newSchool = schoolService.addSchool(school);
        assertNotNull(newSchool);
        School findedSchool = schoolService.getSchool(newSchool.getId());
        assertNotNull("school should return id", findedSchool.getId());
    }

    @Test
    public void testNotFoundSchool() {
        School findedSchool = schoolService.getSchool(4L);
        assertNull("school should return null", findedSchool);
    }

    @Test
    public void testDeleteSchool() {
        schoolService.deleteSchool(school.getId());
        School findedSchool = schoolService.getSchool(school.getId());
        assertNull("school should return null", findedSchool);
    }

    @Test
    public void testGetAllLists() {
        schoolService.addSchool(school);
        schoolService.addSchool(school);
        List<School> schools = schoolService.getAllSchools();
        assertEquals("schools should return schools", 2, schools.size());
    }

    @Test
    public void testEqualsArray() {
        char[] arr1 = {'t', 'a', 'h', 'e', 'r'};
        char[] arr2 = "taher".toCharArray();
        assertArrayEquals("arr1 and arr2 not equal", arr1, arr2);
    }

    @Test
    public void assertNotSameMethod() {
        School school1 = new School();
        School school2 = new School();
        assertNotSame(school1, school2);
    }

    @Test
    public void assertBooleanMethod() {
        assertTrue("10 is greater than 6", 10 > 6);
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(List.of(1, 2, 3), hasItems(1, 2));
    }

    @Ignore("Not yet implemented")
    @Test
    public void testIgnore() {
        System.out.println("ignore");
        fail("@Ignore method will not run by JUnit4");
    }

    //    @Test(timeout = 1000)//ms
//    public void testTimeOut() {
//        System.out.println("@Test(timeout) can be used to enforce timeout in JUnit4 test case");
//        while (true) {
//
//        }
//    }
    @Test(expected = IndexOutOfBoundsException.class)//ms
    public void testException() {
        System.out.println("@Test(expected) will check for specified exception during its run");
        schoolService.getAllSchools().get(0);
    }

    @AfterClass
    public static void tearDown() {
        schoolService = null;
        System.out.println("Tearing down");
    }
}
