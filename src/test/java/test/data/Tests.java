package test.data;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.Service;

import java.util.List;

public class Tests {

    @Test
    public void testingTestData() {
        Assert.assertFalse(Service.isUnique(TestData.addNotUniqueNames()), "Имена файлов не уникальны");
    }

    @Test
    public void notSortedYears() {
        List<Integer> listOfYears = Service.getListOfYears(TestData.addNotSorted());
        Assert.assertFalse(Ordering.natural().isOrdered(listOfYears), "Список не отсортирован по годам");
    }
}
