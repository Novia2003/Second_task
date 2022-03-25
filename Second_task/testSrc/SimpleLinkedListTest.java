import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.novichikhin.SimpleLinkedList;
import ru.vsu.cs.util.ListUtils;

import java.util.List;

public class SimpleLinkedListTest {

    @Test
    public void testCreatingSortedListForPositiveNumbers() {
        List<SimpleLinkedList<Double>> lists = ListUtils.readListFromFile("testSrc/TestFiles/TestCase/inputForPositiveNumbers.txt");

        assert (lists != null ? lists.size() : 0) == 2;

        SimpleLinkedList<Double> list = new SimpleLinkedList<>(lists.get(0), lists.get(1));
        String result = ListUtils.toString(list);

        SimpleLinkedList<Double> expectedList = ListUtils.readLinkedListFromFile("testSrc/TestFiles/TestResult/outputForPositiveNumbers.txt");
        String expectedResult = ListUtils.toString(expectedList);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testCreatingSortedListForNegativeNumbers() {
        List<SimpleLinkedList<Double>> lists = ListUtils.readListFromFile("testSrc/TestFiles/TestCase/inputForNegativeNumbers.txt");

        assert (lists != null ? lists.size() : 0) == 2;

        SimpleLinkedList<Double> list = new SimpleLinkedList<>(lists.get(0), lists.get(1));
        String result = ListUtils.toString(list);

        SimpleLinkedList<Double> expectedList = ListUtils.readLinkedListFromFile("testSrc/TestFiles/TestResult/outputForNegativeNumbers.txt");
        String expectedResult = ListUtils.toString(expectedList);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testCreatingSortedListWhenAllValuesFirstListGreaterThanSecondList() {
        List<SimpleLinkedList<Double>> lists = ListUtils.readListFromFile("testSrc/TestFiles/TestCase/inputWhereAllValuesFirstListGreaterThanSecondList.txt");

        assert (lists != null ? lists.size() : 0) == 2;

        SimpleLinkedList<Double> list = new SimpleLinkedList<>(lists.get(0), lists.get(1));
        String result = ListUtils.toString(list);

        SimpleLinkedList<Double> expectedList = ListUtils.readLinkedListFromFile("testSrc/TestFiles/TestResult/outputWhereAllValuesFirstListGreaterThanSecondList.txt");
        String expectedResult = ListUtils.toString(expectedList);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testCreatingSortedListWhenAllValuesFirstListLessThanSecondList() {
        List<SimpleLinkedList<Double>> lists = ListUtils.readListFromFile("testSrc/TestFiles/TestCase/inputWhereAllValuesFirstListLessThanSecondList.txt");

        assert (lists != null ? lists.size() : 0) == 2;

        SimpleLinkedList<Double> list = new SimpleLinkedList<>(lists.get(0), lists.get(1));
        String result = ListUtils.toString(list);

        SimpleLinkedList<Double> expectedList = ListUtils.readLinkedListFromFile("testSrc/TestFiles/TestResult/outputWhereAllValuesFirstListLessThanSecondList.txt");
        String expectedResult = ListUtils.toString(expectedList);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testCreatingSortedListForNormalData() {
        List<SimpleLinkedList<Double>> lists = ListUtils.readListFromFile("testSrc/TestFiles/TestCase/inputForNormalData.txt");

        assert (lists != null ? lists.size() : 0) == 2;

        SimpleLinkedList<Double> list = new SimpleLinkedList<>(lists.get(0), lists.get(1));
        String result = ListUtils.toString(list);

        SimpleLinkedList<Double> expectedList = ListUtils.readLinkedListFromFile("testSrc/TestFiles/TestResult/outputForNormalData.txt");
        String expectedResult = ListUtils.toString(expectedList);

        Assert.assertEquals(expectedResult, result);
    }
}